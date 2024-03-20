package com.startjava.lesson_2_3.robot;

public class JaegerTest {

    public static void main(String[] args) {
        Jaeger jaeger1 = new Jaeger();

        System.out.println("Объект jaeger1 после создания при помощи конструктора без аргументов:");
        System.out.println("Name:\t" + jaeger1.getModelName());
        System.out.println("Mark:\t" + jaeger1.getMark());
        System.out.println("Status: " + jaeger1.getStatus());
        System.out.println("Height: " + jaeger1.getHeight() + " m");
        System.out.println("Weight: " + jaeger1.getWeight() + " tons\n");

        jaeger1.setModelName("Coyote Tango");
        jaeger1.setMark("Mark-1");
        jaeger1.setStatus("Active");
        jaeger1.setHeight(85.34);
        jaeger1.setWeight(2326);

        System.out.println("Объект jaeger1 после присвоения его полям значений с помощью сеттеров:");
        System.out.println(jaeger1);

        jaeger1.setStatus("Destroyed");
        jaeger1.setWeight(52544);

        System.out.println("Объект jaeger1 после изменения значений Status и Weight:");
        System.out.println(jaeger1);

        Jaeger jaeger2 = new Jaeger("Striker Eureka", "Mark-5", "Active", 76.20, 2087);

        System.out.println("Объект jaeger2 после инициализации при помощи параметризованного конструктора:");
        System.out.println(jaeger2);

        jaeger2.setHeight(-100);
        jaeger2.setWeight(0);

        System.out.println("Height и Weight jaeger2 после попытки присвоения неположительных значений:");
        System.out.println("Height: " + jaeger2.getHeight() + " m");
        System.out.println("Weight: " + jaeger2.getWeight() + " tons\n");
    }
}