package com.mfun.spboot.controller;

import com.mfun.spboot.bean.Department;
import com.mfun.spboot.bean.Employee;
import com.mfun.spboot.dao.DepartmentDao;
import com.mfun.spboot.dao.EmployeeDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;
import java.util.Map;

@Controller
public class EmployeeController {

    private final EmployeeDao employeeDao;
    private final DepartmentDao departmentDao;

    public EmployeeController(EmployeeDao employeeDao, DepartmentDao departmentDao) {
        this.employeeDao = employeeDao;
        this.departmentDao = departmentDao;
    }

    // 查询所有员工
    @GetMapping("/emps")
    public String list(Map<String, Object> map) {
        Collection<Employee> employees = employeeDao.getAll();
        map.put("emps", employees);
        return "emp/list";
    }

    @GetMapping("/emp")
    public String toAddPage(Map<String, Object> map) {
        Collection<Department> departments = departmentDao.getAll();
        map.put("depts", departments);
        return "emp/add";
    }

    @PostMapping("/emp")
    public String addEmp(Employee employee) {
        System.out.println(employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }
}
