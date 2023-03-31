package com.example.finalSection;

import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        hello("John", "Mpntana", value->System.out.println("No lastName provided for "+ value));
        hello2("John", null, ()->System.out.println("No lastName provided "));
    
    }

    static void hello(String firstName,String lastName,Consumer<String> callBack){
        System.out.println(firstName);
        if(lastName != null){
            System.out.println(lastName);
        }else{
            callBack.accept(firstName);
        }
    }

    static void hello2(String firstName,String lastName,Runnable callBack){
        System.out.println(firstName);
        if(lastName != null){
            System.out.println(lastName);
        }else{
            callBack.run();
        }
    }

   
}
