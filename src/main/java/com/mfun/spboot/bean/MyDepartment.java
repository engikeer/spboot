package com.mfun.spboot.bean;

public class MyDepartment {
    private Integer id;
    private String departmentName;

    public MyDepartment() {}

    public MyDepartment(Integer id, String name) {
        this.id = id;
        this.departmentName = name;
    }

    @Override
    public String toString() {
        return "MyDepartment{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
