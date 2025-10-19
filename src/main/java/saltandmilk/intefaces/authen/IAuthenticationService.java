package saltandmilk.intefaces.authen;

import com.nimbusds.jose.JOSEException;
import saltandmilk.dto.request.authen.AuthenRequest;
import saltandmilk.dto.request.authen.IntrospectRequest;
import saltandmilk.dto.response.authen.AuthenResponse;
import saltandmilk.dto.response.authen.IntrospectResponse;

public interface IAuthenticationService {
    AuthenResponse authenticate(AuthenRequest authenRequest);
    IntrospectResponse introspect(IntrospectRequest request) throws JOSEException;
}
