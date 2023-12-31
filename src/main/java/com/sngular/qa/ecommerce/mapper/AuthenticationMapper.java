package com.sngular.qa.ecommerce.mapper;

import com.sngular.qa.ecommerce.domain.User;
import com.sngular.qa.ecommerce.dto.PasswordResetRequest;
import com.sngular.qa.ecommerce.dto.RegistrationRequest;
import com.sngular.qa.ecommerce.dto.auth.AuthenticationRequest;
import com.sngular.qa.ecommerce.dto.auth.AuthenticationResponse;
import com.sngular.qa.ecommerce.dto.user.UserResponse;
import com.sngular.qa.ecommerce.exception.InputFieldException;
import com.sngular.qa.ecommerce.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class AuthenticationMapper {

    private final AuthenticationService authenticationService;
    private final CommonMapper commonMapper;

    public AuthenticationResponse login(AuthenticationRequest request) {
        Map<String, String> credentials = authenticationService.login(request.getEmail(), request.getPassword());
        AuthenticationResponse response = new AuthenticationResponse();
        response.setEmail(credentials.get("email"));
        response.setToken(credentials.get("token"));
        response.setUserRole(credentials.get("userRole"));
        return response;
    }

    public UserResponse findByPasswordResetCode(String code) {
        return commonMapper.convertToResponse(authenticationService.findByPasswordResetCode(code), UserResponse.class);
    }

    public String registerUser(String captcha, RegistrationRequest registrationRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new InputFieldException(bindingResult);
        }
        User user = commonMapper.convertToEntity(registrationRequest, User.class);
        return authenticationService.registerUser(user, captcha, registrationRequest.getPassword2());
    }

    public String activateUser(String code) {
        return authenticationService.activateUser(code);
    }

    public String sendPasswordResetCode(String email) {
        return authenticationService.sendPasswordResetCode(email);
    }

    public String passwordReset(String email, PasswordResetRequest passwordReset) {
        return authenticationService.passwordReset(email, passwordReset.getPassword(), passwordReset.getPassword2());
    }
}
