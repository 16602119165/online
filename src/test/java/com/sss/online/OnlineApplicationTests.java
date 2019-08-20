package com.sss.online;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.sss.online.dao.QJGLMapper;
import com.sss.online.dto.EmployeeDto;
import com.sss.online.pojo.QJLX;
import com.sss.online.pojo.XZGL;
import com.sss.online.util.Md5Util;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.internet.MimeMessage;
import javax.sql.DataSource;
import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OnlineApplicationTests {

    @Autowired
    DataSource dataSource;

    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    RedisTemplate<Object, EmployeeDto> employeeDtoRedisTemplate;


    @Test
    public void contextLoads() {
    }
    @Test
    public void test(){

        System.out.println(dataSource.getClass());
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(connection);
    }
    @Test
    public void testTimeStamp(){
        XZGL xzgl = new XZGL();
        System.out.println(xzgl);
    }
    @Test
    public void test2(){
        //String md5 = Md5Util.getMd5("caozuoyuan", "2019");
        //String m = Md5Util.getMd5("caozuoyuan", "MjAxOQ==");
        //数据库中的密码：ef3aa164ea715451763956a1dd6141b2
        //token中的md5 ef3aa164ea715451763956a1dd6141b2
        String md6 = Md5Util.getMd5("guoguo", "2019");
        System.out.println(md6);
    }
    @Test
    public void test3(){
        //redisTemplate.opsForValue().append("hello","world");//操作string
        stringRedisTemplate.opsForValue().append("skr","skr");
        String msg = stringRedisTemplate.opsForValue().get("skr");
        System.out.println(msg);
    }
    @Test
    public void test4(){
//        EmployeeDto employeeDto = new EmployeeDto("bob",1001,"JavaSpring@126.com","zhou","ss");
//        employeeDtoRedisTemplate.opsForValue().set("empdto",employeeDto);
        EmployeeDto employeeDto = employeeDtoRedisTemplate.opsForValue().get("ssss");
        System.out.println(employeeDto);
    }
    @Autowired
    RabbitTemplate rabbitTemplate;
    @Test
    public void testrabbitmqdirect(){
        //该方法需要手动定义message消息类，比较自由
        //rabbitTemplate.send(exchange,routeKey,message);
        //自动序列化对象，保存发送给rabbitmq
        //rabbitTemplate.convertAndSend(exchange,routeKey,Object);
        Map<String,Object> map = new HashMap<>();
        map.put("msg","这是第一个消息");
        map.put("data", Arrays.asList("sconline",2019,"zhoubo"));
        rabbitTemplate.convertAndSend("exchange.direct","sconline.news",map);
    }
    @Test
    public void testrabbitmqreceive(){
        //接收数据会自动转为json数据
        Object o = rabbitTemplate.receiveAndConvert("sconline.news");
        //请注意在消息队列中消息没有时，若调用.getclass会有空指针异常
        System.out.println(o.getClass());
        System.out.println(o);
    }
    @Test
    public void testrabbitmqfanout(){
        Map<String,Object> map = new HashMap<>();
        map.put("fanout","发送给fanout交换机，该交换机下所有的队列都会收到消息");
        rabbitTemplate.convertAndSend("exchange.fanout","",map);
    }
    @Autowired
    AmqpAdmin amqpAdmin;//amqp系统管理器用来创建和删除消息队列
   @Test
    public void testamqpAdmin(){
        amqpAdmin.declareExchange(new DirectExchange("amqpAdmin.exchange"));
        amqpAdmin.declareQueue(new Queue("amqpAdmin.queue",true));
        amqpAdmin.declareBinding(new Binding
                ("amqpAdmin.queue",Binding.DestinationType.QUEUE,"amqpAdmin.exchange","amqpAdmin",null));
        System.out.println("创建完成");
    }
    @Autowired
    JavaMailSenderImpl javaMailSender;
    @Test
    public void testmailsend(){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("通知");
        message.setText("i love you");
        message.setTo("JavaSpring@126.com");
        //message.setTo("791053958@qq.com");
        message.setFrom("860671577@qq.com");
        javaMailSender.send(message);
    }
    @Test
    public void testmailsend2(){
        //复杂邮件需要这个类
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try{
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
            helper.setSubject("通讯录");
            helper.setText("<b style='color:red'>附件中为公司通讯录</b>",true);
            helper.addAttachment("通讯录.xls",new File("C:\\Users\\Administrator\\Desktop\\SC\\赛诚通讯录20170801.xls"));
            helper.setTo("javaSpring@126.com");
            helper.setFrom("860671577@qq.com");
            javaMailSender.send(mimeMessage);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Autowired
    RedisTemplate<Object,Object> redisTemplate;
    @Test
    public void testObjectJson(){
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName("stringRedisTemplate");
        stringRedisTemplate.opsForValue().set("stringRedisTemplate", JSON.toJSONString(employeeDto));
        //JSONObject test = JSON.parseObject((String) objectRedisTemplate.opsForValue().get("test"));
        String t = (String)stringRedisTemplate.opsForValue().get("stringRedisTemplate");
        EmployeeDto test = JSON.parseObject(t, EmployeeDto.class);
        System.out.println(test);
        System.out.println(test.getClass());
    }
    @Test
    public void testObjectSerializer(){
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName("genericJackson2JsonRedisSerializer");
        redisTemplate.opsForValue().set("genericJackson2JsonRedisSerializer",employeeDto);
        EmployeeDto dto = (EmployeeDto) redisTemplate.opsForValue().get("genericJackson2JsonRedisSerializer");
        System.out.println(dto);
        System.out.println(dto.getClass());
    }
    @Autowired
    QJGLMapper qjglMapper;
    @Test
    public void testSqlPrint(){
        List<QJLX> qjlxes = qjglMapper.selectAll();
        System.out.println(qjlxes);
    }
}
