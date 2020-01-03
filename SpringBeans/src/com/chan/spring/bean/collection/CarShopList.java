package com.chan.spring.bean.collection;

import com.chan.spring.bean.base.Car;

import java.util.List;

/**
 * 汽车销售店
 */
public class CarShopList {
    private String name;
    private List<Car> cars;

    public CarShopList() {
    }

    public CarShopList(String name, List<Car> cars) {
        this.name = name;
        this.cars = cars;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
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
