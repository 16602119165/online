package com.sss.online.dao;

import com.sss.online.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
//@Mapper
public interface EmployeeMapper {
    Integer selectEmployee(@Param(value = "name") String name, @Param(value = "password") String password);
    @Select("select * from employee where id = #{id}")
    Employee selectByID(int id);
}
