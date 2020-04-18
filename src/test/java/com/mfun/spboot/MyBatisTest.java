package com.mfun.spboot;

import com.mfun.spboot.bean.MyDepartment;
import com.mfun.spboot.bean.MyEmployee;
import com.mfun.spboot.mapper.DepartmentMapper;
import com.mfun.spboot.mapper.EmployeeMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MyBatisTest {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Test
    void deptTest() {
        MyDepartment initDepartment = new MyDepartment(null, "生活部");
        departmentMapper.insertOne(initDepartment);
        System.out.println("插入：" + initDepartment);
        int id = initDepartment.getId();
        MyDepartment department = departmentMapper.getOneById(id);
        System.out.println("查询：" + department);
        department.setDepartmentName("武装部");
        departmentMapper.updateOne(department);
        System.out.println("更新：" + departmentMapper.getOneById(id));
        departmentMapper.deleteOneById(id);
        MyDepartment one = departmentMapper.getOneById(id);
        if (one == null) {
            System.out.println("删除成功");
        }
    }

    @Test
    void empTest() {
        MyEmployee employee = employeeMapper.getOneById(1);
        System.out.println(employee);
        System.out.println(departmentMapper.getOneById(1));
    }
}
