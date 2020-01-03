package com.chan.spring.bean.factory;

import org.springframework.beans.factory.FactoryBean;

/**
 * Car 工厂bean类，实现了FactoryBean接口
 * 通过属性注入依赖
 */
public class CarFactoryBean implements FactoryBean<Car> {
    private String brand;
    private String color;
    private double price;
    private int maxSpeed;

    public CarFactoryBean() {
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

    /**
     * 返回Bean对象
     *
     * @return Car
     * @throws Exception Exception
     */
    @Override
    public Car getObject() throws Exception {
        return new Car(brand, color, price, maxSpeed);
    }

    /**
     * 返回Car的类型
     *
     * @return Car.Class
     */
    @Override
    public Class<?> getObjectType() {
        return Car.class;
    }

    /**
     * 是否是单例
     *
     * @return boolean
     */
    @Override
    public boolean isSingleton() {
        return true;
    }
}
