package com.infosupport.lambdastreamsivor.demo01passingcode.domain;

public class Car {

    private String Brand;
    private int weight;
    private String Color;

    public Car(String brand, int weight, String color) {
        setBrand(brand);
        setWeight(weight);
        setColor(color);
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }
}
