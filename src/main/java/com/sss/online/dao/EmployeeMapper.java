package com.sss.online.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeMapper {
    Integer selectEmployee(@Param(value = "name") String name, @Param(value = "password") String password);
}
