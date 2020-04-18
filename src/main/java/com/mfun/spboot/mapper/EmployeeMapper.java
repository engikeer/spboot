package com.mfun.spboot.mapper;

import com.mfun.spboot.bean.MyEmployee;

public interface EmployeeMapper {
    MyEmployee getOneById(int id);

    int insertOne(MyEmployee employee);
}
