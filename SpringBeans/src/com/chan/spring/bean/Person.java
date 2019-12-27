package com.chan.spring.bean;

/**
 * 人类
 */
public class Person {
    //姓名
    private String name;
    //年龄
    private int age;
    //汽车
    private Car car;

    public Person() {
    }

    public Person(String name, int age, Car car) {
        this.name = name;
        this.age = age;
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name=" + name +
                ", age=" + age +
                ", car=" + car.getBrand() +
                '}';
    }
}
