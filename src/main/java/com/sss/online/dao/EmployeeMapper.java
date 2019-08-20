package com.sss.online.dao;

import com.sss.online.dto.EmployeeDto;
import com.sss.online.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
//@Mapper
public interface EmployeeMapper {

    //未用，只是例子用于mapper文件
    Integer selectEmployee(@Param(value = "name") String name, @Param(value = "password") String password);

    @Select("select * from employee where id = #{id}")
    Employee selectByID(int id);

    //根据用户名返回职员信息
    @Select("select * from employee where name=#{name}")
    List<Employee> selectByName(String name );

    //根据用户名返回dto对象
    EmployeeDto selectEmpDto(String name);

    //根据用户名返回上级领导邮箱
    @Select("select leader_email from employee where name = #{name}")
    String selectEmailByName(String name);

}
