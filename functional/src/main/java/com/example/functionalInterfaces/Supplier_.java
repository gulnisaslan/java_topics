package com.example.functionalInterfaces;

import java.util.List;
import java.util.function.Supplier;

public class Supplier_ {
    public static void main(String[] args) {
        System.out.println(getDBConnectionUrl()); 
        System.out.println(getDBConnectionUrlSupplier.get()); 
        System.out.println(getDBConnectionUrlSupplierList.get());
    }

    static String getDBConnectionUrl(){
        return "jdbc://localhost:5432/users";
    }

    static Supplier<String> getDBConnectionUrlSupplier =
    () -> "jdbc://localhost:5432/users";

    static Supplier<List<String>> getDBConnectionUrlSupplierList =
    () -> List.of("jdbc://localhost:5432/users",
                  "jdbc://localhost:5432/customers");



}
