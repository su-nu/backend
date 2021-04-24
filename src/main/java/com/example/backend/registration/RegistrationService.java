package com.example.backend.registration;

import com.example.backend.appUser.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final AppUserService appUserService;
    private final EmailValidator emailValidator;

    public String register(RegistrationRequest request) {
        boolean isEmailValid = emailValidator.test(request.getEmail());
        if(!isEmailValid) {
            throw new IllegalStateException("Email is not valid");
        }
        return appUserService.signUpUser(new com.example.backend.appUser.AppUser(
                request.getFirstName(),
                request.getLastName(),
                request.getEmail(),
                request.getPassword(),
                com.example.backend.appUser.AppUserRole.USER
        ));
    }
}
