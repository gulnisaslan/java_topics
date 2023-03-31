package com.example.functionalInterfaces;

import java.util.function.Predicate;
//58:49
public class Predicate_ {
    public static void main(String[] args) {
       System.out.println("without predicate");
        System.out.println(isPhoneNumberValid("07000000000"));
        System.out.println(isPhoneNumberValid("070000000"));
    
        System.out.println("with predicate");
        System.out.println(isPhoneNumberValidPredicate.test("07000000"));
        System.out.println(isPhoneNumberValidPredicate.test("07000000000"));
        System.out.println(isPhoneNumberValidPredicate.test("070000000"));
        System.out.println(isPhoneNumberValidPredicate.test("07005540000"));
    
        System.out.println(
            "Is phone valid and contains number 3 = "+
            isPhoneNumberValidPredicate.and(containsPhoneNumber3)
        .test("09995630002")
        );

        System.out.println(
            "Is phone valid and contains number 3 = "+
            isPhoneNumberValidPredicate.and(containsPhoneNumber3)
        .test("07990005630")
        );
        System.out.println(
            "Is phone valid and contains number 3 = "+
            isPhoneNumberValidPredicate.or(containsPhoneNumber3)
        .test("07990005699")
        );
    }
    

    //Methods
    static boolean isPhoneNumberValid(String phoneNumber){
        return phoneNumber.startsWith("07")&&phoneNumber.length()==11;
    
       
    }

    static Predicate<String> isPhoneNumberValidPredicate = phoneNumber->
    phoneNumber.startsWith("07")&&phoneNumber.length()==11;

    static Predicate<String> containsPhoneNumber3 = phoneNumber -> phoneNumber.contains("3");
}
