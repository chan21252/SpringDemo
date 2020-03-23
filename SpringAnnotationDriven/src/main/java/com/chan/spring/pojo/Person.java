package com.chan.spring.pojo;

/**
 * Person
 *
 * @author Chan
 * @since 2020/3/23
 */
public class Person {
    String name;
    int age;
    int gender;

    public Person() {
        System.out.println("构造Person");
    }

    public Person(String name, int age, int gender) {
        System.out.println("构造Person");
        this.name = name;
        this.age = age;
        this.gender = gender;
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

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }

    private void init() {
        System.out.println("初始化Person");
    }

    private void destroy() {
        System.out.println("销毁Person");
    }
}
