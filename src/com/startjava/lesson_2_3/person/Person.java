package com.startjava.lesson_2_3.person;

public class Person {

    String name = "Олег";
    String sex = "Male";
    byte age = 27;
    short height = 180;
    float weight = 77.6f;

    public void walk() {
        System.out.println(name + " is walking.");
    }

    public void sit() {
        System.out.println(name + " is sitting.");
    }

    public void run() {
        System.out.println(name + " is running.");
    }

    public void talk() {
        System.out.println(name + " is talking.");
    }

    public void learnJava() {
        System.out.println(name + " is learning Java.");
    }
}