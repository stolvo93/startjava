package com.startjava.lesson_2_3.robot;

import java.util.Locale;

public class Jaeger {

    private String modelName;
    private String mark;
    private String status;
    private double height;
    private int weight;

    public Jaeger() {}

    public Jaeger(String modelName, String mark, String status, double height, int weight) {
        this.modelName = modelName;
        this.mark = mark;
        this.status = status;
        setHeight(height);
        setWeight(weight);
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        if (isPositive(height, "Height")) {
            this.height = height;
        }
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        if (isPositive(weight, "Weight")) {
            this.weight = weight;
        }
    }

    private boolean isPositive (double quantifiableValue, String fieldName) {
        if (quantifiableValue > 0) {
            return true;
        }
        System.out.printf("Неверное значение %s! Используйте только положительные значения.%n%n", fieldName);
        return false;
    }

    @Override
    public String toString() {
        String s = "Name:\t%s%nMark:\t%s%nStatus: %s%nHeight: %.2f m%nWeight: %d tons%n";
        return String.format(Locale.UK, s, modelName, mark, status, height, weight);
    }
}