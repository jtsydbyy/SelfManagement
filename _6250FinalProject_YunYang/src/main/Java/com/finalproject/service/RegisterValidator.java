package com.finalproject.service;

import com.finalproject.pojo.Login;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Service("registervalidatorobj")
public class RegisterValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return type.isAssignableFrom(Login.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "empty-username", "username cannot be blank");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "empty-password", "password cannot be blank");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "type", "empty-type", "type cannot be blank");
    }


}
