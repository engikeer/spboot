package com.mfun.spboot.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity // 标注是一个实体类
@Table(name = "department") // 指定对应的数据表。表名默认是类名小写，可通过 name 属性指定
public class Department implements Serializable {

    @Id // 标注主键字段
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 标注主键自增，在插入后将生成的主键设置给参数对象
    private Integer id;

    @Column(name = "department_name")
    private String departmentName;

    public Department() {}

    public Department(Integer id, String name) {
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
