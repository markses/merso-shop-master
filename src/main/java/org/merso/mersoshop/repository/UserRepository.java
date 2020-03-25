package org.merso.mersoshop.repository;

import org.merso.mersoshop.entity.Shops;
import org.merso.mersoshop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    //用户登录
    User findByAccount(String account);

    //判断邮箱是否注册
    User findByEmail(String email);

    //返回用户名
    @Query(value = "select u.username from User u where u.account = ?1")
    String getUsername(String account);







}
