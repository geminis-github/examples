package com.examples.java.design.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * 客户端类 - 使用 Criteria 过滤
 *
 * @author liangjinlong-CT00345
 * @date 2024-04-25 15:29
 */
public class CriteriaPatternExample {

    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("John", "Male", "Married"));
        persons.add(new Person("Laura", "Female", "Married"));
        persons.add(new Person("Joe", "Male", "Single"));
        persons.add(new Person("Daisy", "Female", "Single"));
        persons.add(new Person("Mike", "Male", "Single"));

        Criteria male = new CriteriaMale();
        Criteria single = new CriteriaSingle();

        System.out.println("Males: ");
        printPersons(male.meetCriteria(persons));

        System.out.println("\nSingle Males: ");
        printPersons(single.meetCriteria(male.meetCriteria(persons)));
    }

    private static void printPersons(List<Person> persons) {
        for (Person person : persons) {
            System.out.println("Person : [ Name : " + person.getName() +
                    ", Gender : " + person.getGender() +
                    ", Marital Status : " + person.getMaritalStatus() + " ]");
        }
    }

}
