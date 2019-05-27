package com.sss.online.controller;
import com.sss.online.dao.EmployeeMapper;
import com.sss.online.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author
 * @create 2019-05-27-14:38
 */
@RestController
public class TestController {
    @Autowired
    EmployeeMapper employeeMapper;

    @RequestMapping("/test")
    public Employee getEmployee(HttpServletRequest request){
        String id = request.getParameter("id");
        Employee employee = employeeMapper.selectByID(Integer.parseInt(id));
        return employee;
    }
}
