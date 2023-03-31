package com.example.functionalInterfaces;

import java.util.function.BiFunction;
import java.util.function.Function;
//36:00
public class Function_ {
    public static void main(String[] args) {
        // Function 
        int increment = incrementByOne(1);
        System.out.println(increment);

       int increment2 = incrementByOneFunction.apply(1);
       System.out.println(increment2);

       int multipleByTen = multipleBy10.apply(2);
       System.out.println(multipleByTen);

        Function<Integer, Integer> VFunction = incrementByOneFunction.andThen(multipleBy10);
        System.out.println(VFunction.apply(10));

        // BiFunction takes 2 arguments and produces 1 result.

        System.out.println(incrementByOneAndMultiply(4, 100));

    }
   
    static  Function<Integer,Integer> incrementByOneFunction=number->number+1;
    
    static Function<Integer,Integer> multipleBy10 = num->num*10;

    static int incrementByOne(int number){
        return number+1;
    } 
    static BiFunction<Integer,Integer,Integer> incrementByOneAndMultiplyBifunction=
    (numberToIncrementByOne,numberToMultiply)-> (numberToIncrementByOne+1)*numberToMultiply;


    static int incrementByOneAndMultiply(int number,int numToMultiplyBy){
        return (number+1)*numToMultiplyBy;
    } 
    
}
