package com.mfun.spboot.controller;

import com.mfun.spboot.bean.Department;
import com.mfun.spboot.bean.Employee;
import com.mfun.spboot.dao.DepartmentDao;
import com.mfun.spboot.dao.EmployeeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;

@Controller
public class EmployeeController {

    private final EmployeeDao employeeDao;
    private final DepartmentDao departmentDao;
    Logger logger = LoggerFactory.getLogger(getClass());

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
        logger.debug("添加员工：" + employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable Integer id,
                             Map<String, Object> map) {
        Employee employee = employeeDao.getOne(id);
        Collection<Department> departments = departmentDao.getAll();
        map.put("emp", employee);
        map.put("depts", departments);
        // 去 add 页面进行修改
        return "emp/add";
    }

    @PutMapping("/emp")
    public String updateEmp(Employee employee) {
        logger.debug("修改员工：" + employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @DeleteMapping("/emp/{id}")
    public String deleteEmp(@PathVariable Integer id) {
        logger.debug("删除员工：" + id);
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
