package com.finalproject.service;


import com.finalproject.pojo.Place;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Service("placevalidatorobj")
public class PlaceValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return type.isAssignableFrom(Place.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fund", "empty-fund", "fund cannot be blank");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "quantity", "empty-quantity", "quantity cannot be blank");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cust", "empty-cust", "cust cannot be blank");
    }


}
