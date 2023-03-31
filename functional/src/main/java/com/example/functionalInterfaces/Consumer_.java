package com.example.functionalInterfaces;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Consumer_ {
    public static void main(String[] args) {
       //Normal java function
        Customer customer = new Customer("Maria", "55555");
        greetCustomer(customer);
        greetCustomerV2(customer, false);
        //consumer functional interface
        greetCustomerConsumer.accept(customer);
        //BiConsumer function
        greetCustomerBiConsumer.accept(customer,false);
    }
    static BiConsumer<Customer,Boolean> greetCustomerBiConsumer = (customer,showNumber)->
    System.out.println("Hello "
    + customer.customerName+
    " thanks registering phone number "
    +(showNumber ?  customer.customerPhoneNumber:"**********"));

    //Consumer
    static Consumer<Customer> greetCustomerConsumer = customer->
     System.out.println("Hello "
     + customer.customerName+
     " thanks registering phone number "
     +customer.customerPhoneNumber);
   
   //normal java func
    static void greetCustomer(Customer customer){
       System.out.println("Hello "+ customer.customerName+" thanks registering phone number "+customer.customerPhoneNumber);
    }

    static void greetCustomerV2(Customer customer,boolean showNumber){
        System.out.println("Hello "+ customer.customerName+" thanks registering phone number "+(showNumber ? customer.customerPhoneNumber : "********"));
     }

    //static java class
    static class Customer{
        private final String customerName;
        private final String customerPhoneNumber;
        public Customer(String customerName, String customerPhoneNumber) {
            this.customerName = customerName;
            this.customerPhoneNumber = customerPhoneNumber;
        }
    }
}
