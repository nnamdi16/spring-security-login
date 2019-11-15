package com.nnamdi.web.model;

import java.io.Serializable;

public class Employee implements Serializable {

    private static final long serialVersionUID = 2401397786933204698L;
    private Long id;
    private String name;
    private Long age;
    private String dept;

    public Employee() {super();}

    public Employee(Long id, String name, Long age, String dept) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.dept = dept;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", dept='" + dept + '\'' +
                '}';
    }
}
