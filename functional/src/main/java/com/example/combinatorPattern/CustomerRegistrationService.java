package com.example.combinatorPattern;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

public interface CustomerRegistrationService extends Function<Customer,ValidationResult> {
   
    static CustomerRegistrationService isEmailValid (){
        return customer -> customer.getEmail().contains("@")
        ? ValidationResult.Success : ValidationResult.EMAIL_NOT_VALID;
    }
    
    static CustomerRegistrationService isPhoneNumberValid (){
        return customer -> customer.getPhoneNumber().startsWith("+0")
        ? ValidationResult.Success : ValidationResult.PHONE_NUMBER_NOT_VALID;
    }

    static CustomerRegistrationService isDobValid (){
        return customer -> Period.between(customer.getDob(), LocalDate.now()).getYears()>16?
        ValidationResult.Success : ValidationResult.IS_NOT_AN_ADULT;
    }

    default CustomerRegistrationService and(CustomerRegistrationService other){
        return customerv-> {
            ValidationResult result = this.apply(customerv);
            return result.equals(ValidationResult.Success)?other.apply(customerv) : result;
        };
    }







    
}
enum ValidationResult{
    Success,
    PHONE_NUMBER_NOT_VALID,
    EMAIL_NOT_VALID,
    IS_NOT_AN_ADULT

}
