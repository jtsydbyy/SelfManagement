package com.finalproject.service;

import com.finalproject.pojo.Customer;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Service("addcustomervalidatorobj")
public class AddCustomerValidator  implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return type.isAssignableFrom(Customer.class);
    }

    @Override
    public void validate(Object o, Errors errors) {


        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "empty-name", "name cannot be blank");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "empty-email", "email cannot be blank");

    }


}
