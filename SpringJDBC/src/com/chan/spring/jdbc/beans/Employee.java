package com.chan.spring.jdbc.beans;

public class Employee {
    private Integer id;
    private String name;
    private String email;
    private Integer departmentId;
    private Department department;

    public Employee() {
    }

    public Employee(Integer id, String name, String email, Department department) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.department = department;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", department_id=" + departmentId +
                ", department=" + department +
                '}';
    }
}
