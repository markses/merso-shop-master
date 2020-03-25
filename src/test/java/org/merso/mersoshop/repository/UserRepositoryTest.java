package org.merso.mersoshop.repository;



import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.merso.mersoshop.entity.User;
import org.merso.mersoshop.result.RandomUtil;
import org.merso.mersoshop.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)

@SpringBootTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

//    @Test
//    public void testFindByAccount() {
//        User userDO = userRepository.findByUsername("merso1");
//        if (userDO != null) {
//            System.out.println("name = " + userDO.getUsername());
//            System.out.println("account = " + userDO.getPassword());
//        }
//    }

    @Autowired
    private EmailService emailService;
    @Resource
    private RandomUtil randomUtil;
    @Resource
    private JavaMailSender javaMailSender;

    @Test
    public String sendEmail(String email) {
        SimpleMailMessage message = new SimpleMailMessage();
        String code = randomUtil.getRandom();
        //message.setFrom(from);
        email = "1424643646@qq.com";
        message.setTo(email);
        message.setSubject("用户注册");
        message.setText("你的验证码为:" + code);
        javaMailSender.send(message);
        System.out.println("发送成功");

        return email;


    }
}