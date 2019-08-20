package com.sss.online.dao;

import com.sss.online.pojo.Employee;
import com.sss.online.pojo.QJLX;
import com.sss.online.pojo.UITree;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author
 * @create 2019-06-27-16:15
 */
@Repository
public interface QJGLMapper {
    @Select("select id,qjlx from qjlx")
    List<QJLX> selectAll();
    @Select("select id,name from employee")
    List<Employee> selectCSAll();
}
