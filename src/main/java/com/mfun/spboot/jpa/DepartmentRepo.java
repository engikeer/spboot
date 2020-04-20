package com.mfun.spboot.jpa;

import com.mfun.spboot.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository 的第一个类型参数是操作的对象的类型，第二个类型参数是主键的类型
public interface DepartmentRepo extends JpaRepository<Department, Integer> {
}
