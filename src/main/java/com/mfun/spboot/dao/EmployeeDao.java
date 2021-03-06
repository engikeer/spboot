package com.mfun.spboot.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import com.mfun.spboot.bean.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class EmployeeDao {

	private final Map<Integer, Employee> employeeMap = new LinkedHashMap<>();
	private DepartmentDao departmentDao;

	private int initId = 1006;

	@Autowired
	public EmployeeDao(DepartmentDao departmentDao) throws ParseException {
		this.departmentDao = departmentDao;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		employeeMap.put(1001, new Employee(1001, "宋江", "及时雨@梁山.com", 1, format.parse("1998-11-15"), departmentDao.getOne(102)));
		employeeMap.put(1002, new Employee(1002, "扈三娘", "一丈青@扈家庄.com", 0, format.parse("1990-01-03"), departmentDao.getOne(101)));
		employeeMap.put(1003, new Employee(1003, "武松", "行者@梁山.com", 1, format.parse("1993-07-07"), departmentDao.getOne(107)));
		employeeMap.put(1004, new Employee(1004, "潘金莲", "小莲儿@好好吃炊饼.com", 0, format.parse("2006-03-25"), departmentDao.getOne(105)));
		employeeMap.put(1005, new Employee(1005, "时迁", "有求必应@梁山.com", 1, format.parse("2010-12-31"), departmentDao.getOne(106)));
	}

	public void save(Employee employee) {
		if(employee.getId() == null) {
			employee.setId(initId++);
		}
		// 传入的员工数据的 department 属性可以只有 id 属性
		employee.setDepartment(departmentDao.getOne(employee.getDepartment().getId()));
		employeeMap.put(employee.getId(), employee);
	}

	public Collection<Employee> getAll() {
		return employeeMap.values();
	}

	public Employee getOne(int id) {
		return employeeMap.get(id);
	}

	public void delete(int id) {
		employeeMap.remove(id);
	}
}
