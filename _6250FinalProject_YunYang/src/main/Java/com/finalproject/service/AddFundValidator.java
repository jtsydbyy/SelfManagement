package com.finalproject.service;

import com.finalproject.pojo.Fund;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Service("addfundvalidatorobj")
public class AddFundValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return type.isAssignableFrom(Fund.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "empty-name", "name cannot be blank");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "empty-price", "price cannot be blank");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "type", "empty-type", "type cannot be blank");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "quantity", "empty-quantity", "quantity cannot be blank");

    }


}
