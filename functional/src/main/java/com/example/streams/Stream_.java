package com.example.streams;

import java.util.List;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import static java.lang.System.out;
public class Stream_ {
    public static void main(String[] args) {
        final List<Person> people = List.of(
           
                    new Person("John", Gender.Male),
                    new Person("Maria", Gender.Female),
                    new Person("Aisha", Gender.Female),
                    new Person("Alice", Gender.Female),
                    new Person("Alex", Gender.Male)
                   // new Person("Boob", Gender.Prefer_Not_Say)
        ); 
        streams_example(people);
        
        Predicate<Person> personPredicate = person -> Gender.Prefer_Not_Say.equals(person.gender);
        boolean containsOnlyFemales = people.stream()
        .allMatch(personPredicate);
        out.println(containsOnlyFemales);
        
        boolean containsOnlyFemales_ = people.stream()
        .anyMatch(personPredicate);
        out.println(containsOnlyFemales_);
        
        boolean contains_only_females_ = people.stream()
        .noneMatch(personPredicate);
        out.println(contains_only_females_);
    }
    private static void  streams_example(List<Person> people) {
        Function<Person,String> personStringFunction = 
        person->person.name;
       ToIntFunction<String> lengths = String :: length;
        
       IntConsumer printlns= System.out::println;
       
       people.stream()
              .map(person -> person.gender)
              .collect(Collectors.toSet());

              people.stream()
              .map(person -> person.gender)
              .collect(Collectors.toSet())
              .forEach(System.out::println);

              people.stream()
              .map(personStringFunction)
              .mapToInt(lengths)
              .forEach(printlns);
        
    }
    static class Person{
        private final String name;
        private final Gender gender;

 
         public String getName() {
            return name;
         }
        public Gender getGender() {
            return gender;
        }
        public Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

            @Override
            public String toString() {
                return "{"+name +" "+gender+
                    "}";
            }
       

    }
    enum Gender{
        Male,Female,Prefer_Not_Say

    }
}
