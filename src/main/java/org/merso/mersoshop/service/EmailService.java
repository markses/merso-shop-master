package org.merso.mersoshop.service;


import org.merso.mersoshop.result.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.merso.mersoshop.result.RandomUtil;
import javax.annotation.Resource;

@Service
public class EmailService {

    @Resource
    private JavaMailSender javaMailSender;
    @Value("${spring.mail.username}")
    private String from;



    public String sendEmail(String email) {
        SimpleMailMessage message = new SimpleMailMessage();
        String code = RandomUtil.getRandom();
        message.setFrom(from);

        message.setTo(email);
        message.setSubject("用户注册");
        message.setText("你的验证码为:"+code);
        javaMailSender.send(message);


        return code;
    }


}
