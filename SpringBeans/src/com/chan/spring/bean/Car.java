package com.chan.spring.bean;

/**
 * 汽车类
 */
public class Car {
    //品牌
    private String brand;
    //颜色
    private String color;
    //价格
    private double price;
    //最高速
    private int maxSpeed;

    public Car() {
    }

    public Car(String brand, String color, double price) {
        this.brand = brand;
        this.color = color;
        this.price = price;
    }

    public Car(String brand, String color, int maxSpeed) {
        this.brand = brand;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }

    public Car(String brand, String color, double price, int maxSpeed) {
        this.brand = brand;
        this.color = color;
        this.price = price;
        this.maxSpeed = maxSpeed;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand=" + brand +
                ", color=" + color +
                ", price=" + price +
                ", maxSpeed=" + maxSpeed +
                '}';
    }
}
