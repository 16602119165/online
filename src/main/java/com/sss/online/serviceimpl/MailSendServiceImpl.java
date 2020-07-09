package com.sss.online.serviceimpl;

import com.sss.online.dao.EmployeeMapper;
import com.sss.online.service.MailSendService;
import com.sss.online.vo.QJGLVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;

/**
 * @author
 * @create 2019-07-05-11:07
 */
public class MailSendServiceImpl implements MailSendService {
    @Autowired
    EmployeeMapper employeeMapper;

    @Override
    public void sendSimpleMail(QJGLVO qjglvo) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(employeeMapper.selectEmailByName(qjglvo.getEmpName()));//接收者
        simpleMailMessage.setText(qjglvo.getQjsy());//内容
        simpleMailMessage.setSubject(qjglvo.getEmpName()+"请假申请");//主题
        simpleMailMessage.setFrom("OA");
    }

    @Override
    public void sendComplex(QJGLVO qjglvo) {

    }
}
