package com.chan.spring.bean.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * 汽车静态工厂类
 */
public class CarStaticFactory {
    /**
     * 静态Map，保存Car实例
     */
    private static Map<String, Car> cars = new HashMap<String, Car>();

    static {
        cars.put("Audi", new Car("Audi"));
        cars.put("BMW", new Car("BMW"));
    }

    /**
     * 静态方法，返回Car实例对象
     *
     * @param brand 品牌
     * @return Car
     */
    public static Car getCar(String brand) {
        return cars.get(brand);
    }
}
