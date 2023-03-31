package com.example.optionals;
import static java.lang.System.out;

import java.util.Optional;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {
      Supplier<IllegalStateException> exception = () -> new IllegalStateException("Exception");
      
      Object object =   Optional.ofNullable("Hello")
        .orElseGet(() -> "default value");
        out.println(object);
       
        Object object1 =   Optional.ofNullable("Hello")
        .orElseThrow(exception);
       out.println(object1);

      Optional.ofNullable("john@gmail.com")
      .ifPresent(email -> out.println("Sending email to "+email));
     
     
      Optional.ofNullable(null)
      .ifPresentOrElse(email -> out.println("Sending email to "+email),
      ()->{
         out.println("Cannot send email");
      });
        
    }
}
