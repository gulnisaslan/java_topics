package com.example.combinatorPattern;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
         Customer customer = new Customer(
            "Alice", 
            "alicegamil.com",
             "5336289521",
              LocalDate.of(2000, 1, 01));
       // System.out.println(new CustomerValidatorService().isValid(customer));
       //if valid we can store customer in db
       //Using Combinator Pattern
       ValidationResult apply = CustomerRegistrationService
              .isEmailValid()
              .and(CustomerRegistrationService.isPhoneNumberValid())
              .and(CustomerRegistrationService.isDobValid())
              .apply(customer);

              System.out.println(apply);

              if(apply != ValidationResult.Success){
                throw new IllegalStateException(apply.name());
              }
            }

}
