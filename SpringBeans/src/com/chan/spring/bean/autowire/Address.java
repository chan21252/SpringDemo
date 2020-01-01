package com.chan.spring.bean.autowire;

public class Address {
    private String city;
    private String road;

    public Address() {
        System.out.println("Address默认无参构造器");
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", road='" + road + '\'' +
                '}';
    }
}
