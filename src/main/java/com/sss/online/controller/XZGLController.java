package com.sss.online.controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.sss.online.basic.Result;
import com.sss.online.dao.EmployeeMapper;
import com.sss.online.dto.EmployeeDto;
import com.sss.online.pojo.Employee;
import com.sss.online.pojo.UICombobox;
import com.sss.online.serviceimpl.OverTimeServiceImpl;
import com.sss.online.serviceimpl.QJGLServiceImp;
import com.sss.online.vo.JBGLVO;
import com.sss.online.vo.QJGLVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * @author
 * @create 2019-06-05-9:52
 */
@RestController
@RequestMapping("/page/xzgl")
public class XZGLController {

    @Autowired
    OverTimeServiceImpl overTimeService;
    @Autowired
    RedisTemplate<Object,EmployeeDto> employeeDtoRedisTemplate;
    @Autowired
    RedisTemplate<Object,Object> redisTemplate;
    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    @Qualifier(value = "qjglServiceImp")
    QJGLServiceImp qjglServiceImp;
    @Autowired
    JavaMailSenderImpl javaMailSender;

    //请假申请，add
    @RequestMapping("/qjgl/add")
    public Result qjadd(@Valid QJGLVO qjglvo){
        System.out.println("请假表单提交");
        //校验参数 在GlobalExceptionHandler中会拦截所有添加了@Valid的controler方法校验参数
        //先存入缓存，防止重复提交。
        /*StringBuilder sb = new StringBuilder();
        String start = qjglvo.getStart();
        String end = qjglvo.getEnd();*/
        Result result = new Result();
        //插入请假数据
        int i = qjglServiceImp.qjglAdd(qjglvo);
        if(i != 0){
            //给上级领导发送邮件
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setTo(employeeMapper.selectEmailByName(qjglvo.getEmpName()));//接收者
            simpleMailMessage.setText(qjglvo.getQjsy());//内容
            simpleMailMessage.setSubject(qjglvo.getEmpName()+"请假申请");//主题
            //simpleMailMessage.setFrom("860671577@qq.com");//("OA<860671577@qq.com>")
            simpleMailMessage.setFrom("OA<bob.zhou@saichenglogistics.com>");
            if(qjglvo.getCs() != null){
                simpleMailMessage.setCc("bob.zhou@saichenglogistics.com");//抄送
            }
            try{
                javaMailSender.send(simpleMailMessage);
            }catch (Exception e){
                e.printStackTrace();
                result.setStatus(1);
                result.setMessage("邮件发送错误");
                //返回提交提示
                return result;
            }
            result.setStatus(0);
            result.setMessage("提交成功");
            //返回提交提示
            return result;
        }else {
            //返回提交提示
            result.setStatus(1);
            result.setMessage("数据上传失败，请联系管理员");
            return result;
        }
    }




    //行政管理中的加班管理，加班申请。
    @RequestMapping("/jbgl/insert")
    public Result overTime(JBGLVO jbglvo){
        String name = jbglvo.getName();
        EmployeeDto employeeDto = employeeDtoRedisTemplate.opsForValue().get(name);
        overTimeService.insertOverTime(jbglvo,employeeDto);
        return null;
    }



    //请假管理中的请假类型查询
    @RequestMapping("/qjgl/qjlx")
    public List<UICombobox> qjlxquery(){
        System.out.println("qjlx 查询");
        List<UICombobox> lists = qjglServiceImp.qjlxquery();
        return lists;
    }
    @RequestMapping("/qjgl/cs")
    public List<UICombobox> csquery(){
        System.out.println("cs 查询");
        List<UICombobox> lists = qjglServiceImp.csQuery();
        return lists;
    }


}
