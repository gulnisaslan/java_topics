package com.example.imperative;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

//19:26
public class Functions {
    /**
     * @param args
     */
    public static void main(String[] args) {
        final List<Person> people = List.of(
                    new Person("John", Gender.Male),
                    new Person("Maria", Gender.Female),
                    new Person("Aisha", Gender.Female),
                    new Person("Alice", Gender.Female),
                    new Person("Alex", Gender.Male)
        );

        //ToDo: Imperative approach
        System.out.println("Imperative Approach");
        List<Person> females = new ArrayList<>();


        for (Person person:people){
            if (Gender.Female.equals(person.gender)){
                females.add(person);
            }
        }
        for (Person female:females) {
            System.out.println(female);

        }

        //ToDo : Declarative Approach
        System.out.println("Declarative Approach");
        
        Predicate<Person> personPredicate = 
        person ->Gender.Female.equals(person.gender);
        List<Person> females2 = people.stream()
                .filter(personPredicate)
                .collect(Collectors.toList());
        females2.forEach(t -> System.out.println(t));
 
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
        Male,Female

    }
}
