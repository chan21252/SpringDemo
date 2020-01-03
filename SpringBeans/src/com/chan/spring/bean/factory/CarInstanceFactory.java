package com.chan.spring.bean.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * 汽车实例工厂类
 */
public class CarInstanceFactory {
    private Map<String, Car> cars;

    CarInstanceFactory() {
        cars = new HashMap<String, Car>();
        cars.put("Audi", new Car("Audi"));
        cars.put("BMW", new Car("BMW"));
    }

    public Car getCar(String brand) {
        return cars.get(brand);
    }
}
