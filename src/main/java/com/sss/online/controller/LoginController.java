package com.sss.online.controller;
import com.sss.online.basic.Result;
import com.sss.online.serviceimpl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class LoginController {

    @Autowired
    EmployeeServiceImpl employeeService;
    @RequestMapping("/login")
    public Result login(HttpServletRequest request){
        Result result = new Result();
        Integer integer = employeeService.selectEmployee(request.getParameter("name"), request.getParameter("psd"));
        if (integer == 1){
            result.setStatus(integer);
            result.setMessage("登陆成功");
            System.out.println(result);
            return result;
        }else {
            result.setStatus(integer);
            result.setMessage("登陆失败了");
            result.setData(integer);
            System.out.println(result);
            return result;
        }
    }
}
