package com.chan.spring.bean.autowire;

import com.chan.spring.bean.Car;

public class Person {
    private String name;
    private Address address;
    private com.chan.spring.bean.Car car;

    public Person() {
        System.out.println("Person默认无参构造器");
    }

    public Person(Address address, com.chan.spring.bean.Car car) {
        System.out.println("Person Address Car参构造器");
        this.address = address;
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public com.chan.spring.bean.Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", address=" + address +
                ", car=" + car +
                '}';
    }
}
