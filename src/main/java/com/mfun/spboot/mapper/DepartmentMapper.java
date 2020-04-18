package com.mfun.spboot.mapper;

import com.mfun.spboot.bean.MyDepartment;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

// 标注 Mapper
//@Mapper
public interface DepartmentMapper {

    @Select("SELECT * FROM department WHERE id=#{id}")
    MyDepartment getOneById(int id);

    @Delete("DELETE FROM department WHERE id=#{id}")
    int deleteOneById(int id);

    // 使用 useGeneratedKeys 属性在插入后将生成的主键设置给参数对象
    @Insert("INSERT INTO department (department_name) VALUES (#{departmentName})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertOne(MyDepartment department);

    @Update("UPDATE department SET department_name=#{departmentName} WHERE id=#{id}")
    int updateOne(MyDepartment department);

}
