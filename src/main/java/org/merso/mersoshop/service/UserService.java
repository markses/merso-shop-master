package org.merso.mersoshop.service;

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
        System.out.println(user.getUsername());
        userRepository.save(user);
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
}
