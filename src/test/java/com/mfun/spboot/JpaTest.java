package com.mfun.spboot;

import com.mfun.spboot.entity.Department;
import com.mfun.spboot.jpa.DepartmentRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class JpaTest {

    @Autowired
    private DepartmentRepo departmentRepo;

    @Test
    void commonTest() {
        Department initDepartment = new Department(null, "生活部");
        departmentRepo.save(initDepartment);
        System.out.println("插入：" + initDepartment);
        int id = initDepartment.getId();

        Optional<Department> optionalDepartment = departmentRepo.findById(id);
        optionalDepartment.ifPresent(department -> System.out.println("查询：" + department));
        initDepartment.setDepartmentName("武装部");
        departmentRepo.save(initDepartment);
        departmentRepo.findById(id).ifPresent(department -> System.out.println("更新：" + department));
        departmentRepo.delete(initDepartment);
        if (!departmentRepo.findById(id).isPresent()) {
            System.out.println("删除成功");
        }
    }
}
