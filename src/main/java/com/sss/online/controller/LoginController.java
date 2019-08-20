package com.sss.online.controller;
import com.sss.online.basic.Result;
import com.sss.online.dto.EmployeeDto;
import com.sss.online.serviceimpl.EmployeeServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@RestController
public class LoginController {

    @Autowired
    EmployeeServiceImpl employeeService;
    @Autowired
    RedisTemplate<Object,EmployeeDto> employeeDtoRedisTemplate;

    @RequestMapping("/login")
    public Result login(HttpServletRequest request){
        Result result = new Result();
        String name = request.getParameter("name");
        String psd = request.getParameter("psd");
        //shiro 认证三部曲
        //1.subject
        Subject subject = SecurityUtils.getSubject();
        //2.封装用户信息
        UsernamePasswordToken token = new UsernamePasswordToken(name,psd);
        //3.执行login方法
        try{
            subject.login(token);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //是否认证通过
            boolean isAuthenticated = subject.isAuthenticated();
            System.out.println("是否认证通过="+isAuthenticated);
            //退出操作
            // subject.logout();
            if(isAuthenticated == true){
                result.setStatus(0);
                result.setMessage("登录成功");
                EmployeeDto employeeDto = employeeService.selectEmpDto(name);
                System.out.println(employeeDto);
                if(employeeDtoRedisTemplate.opsForValue().get(name) == null){
                    employeeDtoRedisTemplate.opsForValue().set(name,employeeDto);
                }
                result.setData(employeeDto);
                return result;
            }else {
                result.setStatus(1);
                result.setMessage("登陆失败");
                return result;
            }
        }


        /*Integer integer = employeeService.selectEmployee(request.getParameter("name"), request.getParameter("psd"));
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
        }*/
    }
}
