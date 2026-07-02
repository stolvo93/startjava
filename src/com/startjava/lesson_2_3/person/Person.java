package com.startjava.lesson_2_3.person;

public class Person {
    String sex = "female";
    String name = "Карина";
    int height = 168;
    float weight = 44.2f;
    int age = 25;

    void walk() {
        System.out.println(name + " идёт");
    }

    void sit() {
        System.out.println(name + " сидит");
    }

    void run() {
        System.out.println(name + " бежит");
    }

    void talk() {
        System.out.println(name + " говорит");
    }

    void learnJava() {
        System.out.println(name + " изучает Java");
    }
}