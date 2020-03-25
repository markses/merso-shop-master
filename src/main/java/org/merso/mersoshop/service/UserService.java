package org.merso.mersoshop.service;

import org.merso.mersoshop.entity.Order;
import org.merso.mersoshop.entity.User;
import org.merso.mersoshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    //用户注册
    @Autowired
    private UserRepository userRepository;

    public void insertUser(User user) {
        User user1 = new User();
        user1.setAccount(user.getAccount());
        user1.setUsername(user.getUsername());
        user1.setPassword(user.getPassword());
        user1.setEmail(user.getEmail());
        userRepository.save(user1);
        System.out.println("ok");

    }

    //判断邮箱是否被注册
    public Boolean findByEmail(String email) {
        User user = userRepository.findByEmail(email);

        if (user != null) {
            return true;
        } else {
                return false;
            }

    }

    //返回用户名
    public String getUsername(String account) {
        String username = userRepository.getUsername(account);
        return username;
    }
}
