package saltandmilk.controllers.user;

import com.nimbusds.jose.JOSEException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import saltandmilk.dto.request.authen.AuthenRequest;
import saltandmilk.dto.request.authen.IntrospectRequest;
import saltandmilk.dto.request.authen.LogoutRequest;
import saltandmilk.dto.request.authen.RefreshRequest;
import saltandmilk.dto.response.ApiResp;
import saltandmilk.dto.response.authen.AuthenResponse;
import saltandmilk.dto.response.authen.IntrospectResponse;
import saltandmilk.intefaces.authen.IAuthenticationService;
import saltandmilk.services.authen.AuthenticationServiceImpl;

import java.text.ParseException;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthenticationController {
    final AuthenticationServiceImpl authenticationService;

    @PostMapping("/token")
    ApiResp<AuthenResponse> authenticate(@RequestBody AuthenRequest authenRequest){
        var result = authenticationService.authenticate(authenRequest);
        return ApiResp.<AuthenResponse>builder().result(result).build();
    }

    @PostMapping("/introspect")
    ApiResp<IntrospectResponse> authenticate(@RequestBody IntrospectRequest request)
            throws ParseException, JOSEException {
        var result = authenticationService.introspect(request);
        return ApiResp.<IntrospectResponse>builder().result(result).build();
    }

    @PostMapping("/refresh")
    ApiResp<AuthenResponse> authenticate(@RequestBody RefreshRequest request)
            throws ParseException, JOSEException {
        var result = authenticationService.refreshToken(request);
        return ApiResp.<AuthenResponse>builder().result(result).build();
    }

    @PostMapping("/logout")
    ApiResp<Void> logout(@RequestBody LogoutRequest request) throws ParseException, JOSEException {
        authenticationService.logout(request);
        return ApiResp.<Void>builder().build();
    }
}
