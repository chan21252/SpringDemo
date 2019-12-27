package com.chan.spring.bean.collection;

import com.chan.spring.bean.Car;

import java.util.Set;

/**
 * 汽车销售店
 */
public class CarShopSet {
    private String name;
    private Set<Car> cars;

    public CarShopSet() {
    }

    public CarShopSet(String name, Set<Car> cars) {
        this.name = name;
        this.cars = cars;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Car> getCars() {
        return cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "CarShopList{" +
                "name=" + name +
                ", cars=" + cars +
                '}';
    }
}
