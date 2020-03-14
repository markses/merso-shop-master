package org.merso.mersoshop.repository;

import org.merso.mersoshop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    //用户登录
    User findByUsername(String username);

    //判断邮箱是否注册
    User findByEmail(String email);



}
