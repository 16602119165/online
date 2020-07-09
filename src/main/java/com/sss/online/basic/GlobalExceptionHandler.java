package com.sss.online.basic;

import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author
 * @create 2019-07-04-10:45
 */
@ControllerAdvice//所谓加强Controller就是@ControllerAdvice注解，有这个注解的类中的方法的某些注解会应用到所有的Controller里，其中就包括@ExceptionHandler注解。
@ResponseBody//rest接口 还有一个RestControllerAdvice注解不知道是不是三合一
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    //异常处理(@ControllerAdvice注解注释的controller层和此注解注释的方法,会对所有controller层抛出的异常进行统一处理)
    public Result exceptionHandler(HttpServletRequest request,BindException e){
        Result result = new Result();
        result.setStatus(1);
        if(e instanceof BindException){
            BindException bindException = (BindException) e;
            List<ObjectError> allErrors = bindException.getAllErrors();//捕获所有错误对象
            ObjectError error = allErrors.get(0);
            String defaultMessage = error.getDefaultMessage();//异常内容
            System.out.println("校验异常"+defaultMessage);
            /*List<String> strings = new ArrayList<>();
            strings.add(defaultMessage);*/
            result.setMessage("参数校验"+defaultMessage);
            return result;
            //return strings;
        }else {
            result.setMessage("其他异常");
            return result;
        }
    }
}
