package saltandmilk.services.authen;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import saltandmilk.dto.request.authen.AuthenRequest;
import saltandmilk.dto.request.authen.IntrospectRequest;
import saltandmilk.dto.response.authen.AuthenResponse;
import saltandmilk.dto.response.authen.IntrospectResponse;
import saltandmilk.entities.user.Role;
import saltandmilk.entities.user.User;
import saltandmilk.exceptions.AppException;
import saltandmilk.exceptions.ErrorCode;
import saltandmilk.intefaces.authen.IAuthenticationService;
import saltandmilk.repositories.user.UserRepository;

import java.text.ParseException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.StringJoiner;

@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationServiceImpl implements IAuthenticationService {

    private final UserRepository _userRepository;

    @NonFinal
    @Value("${jwt.signerKey}")
    protected String SIGNER_KEY;

    @Override
    public AuthenResponse authenticate(AuthenRequest authenRequest) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        var user = _userRepository.findByEmail(authenRequest.getEmail()).orElseThrow(() ->
                new AppException(ErrorCode.USER_NOT_EXISTED));
        boolean authenticated = passwordEncoder.matches(authenRequest.getPassword(), user.getPassword());

        if(!authenticated) throw new AppException(ErrorCode.UNAUTHENTICATED);

        var token = generateToken(user);
        return AuthenResponse.builder()
                .token(token.token)
                .authenticated(true)
                .build();
    }

    @Override
    public IntrospectResponse introspect(IntrospectRequest request) throws JOSEException {
        var token = request.getToken();

        JWSVerifier verifier = null; // sua o day
        try {
            verifier = new MACVerifier(SIGNER_KEY.getBytes());
        } catch (JOSEException e) {
            throw new RuntimeException(e); // lam cho ro ra- xu ly doan nay
        }

        SignedJWT signedJWT = null;
        try {
            signedJWT = SignedJWT.parse(token);
            Date expiry = signedJWT.getJWTClaimsSet().getExpirationTime(); // lay duoc time cua token

            var verify = signedJWT.verify(verifier);

            return IntrospectResponse.builder()
                    .valid(verify && expiry.after(new Date()))
                    .build();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    private TokenInfo generateToken(User user){

        JWSHeader header = new JWSHeader(JWSAlgorithm.HS512);
        Date issueTime = new Date();
        Date expiryTime = new Date(Instant.ofEpochMilli(issueTime.getTime())
                .plus(1, ChronoUnit.HOURS)
                .toEpochMilli());
        //các data trong body gọi là claimset
        JWTClaimsSet jwtClaimsSet = new JWTClaimsSet.Builder()
                .subject(user.getFull_name()) // đại diện cho user đăng nhập
                .issuer("tien") // thường  là domain service
                .issueTime(issueTime) //Lấy thời điểm hịiện tại
                .expirationTime(expiryTime) //Thời  hạn token
                .jwtID(java.util.UUID.randomUUID().toString())
                .claim("full_name",user.getFull_name())
                .claim("scope",buildScope(user))
                .claim("id",user.getUser_id())
                .build();

        Payload payload = new Payload(jwtClaimsSet.toJSONObject());

        JWSObject jwsObject = new JWSObject(header, payload);

        try {
            jwsObject.sign(new MACSigner(SIGNER_KEY.getBytes())); //thuật toán ký và giải mã trùng nhau https://generate-random.org/
            return new TokenInfo(jwsObject.serialize(), expiryTime);

        } catch (JOSEException e) {
            log.error("Cannot create token", e);
            throw new AppException(ErrorCode.UNAUTHENTICATED);
        }
    }

    private String buildScope(User user) {
        StringJoiner stringJoiner = new StringJoiner(" "); // Dấu phân cách là một khoảng trắng
        Role userRole = user.getRole();

        if (userRole != null) {
            // Thêm tên Role vào scope, theo chuẩn của Spring Security
            stringJoiner.add("ROLE_" + userRole.getName().toUpperCase());

            // Lấy danh sách permissions từ Role và thêm vào scope
            if (!CollectionUtils.isEmpty(userRole.getPermissions())) {
                userRole.getPermissions()
                        .forEach(permission -> stringJoiner.add(permission.getName()));
            }
        }

        return stringJoiner.toString();
    }

    private record TokenInfo(String token, Date expiryDate) {}


}
