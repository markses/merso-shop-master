package org.merso.mersoshop.repository;

import org.merso.mersoshop.entity.Shops;
import org.merso.mersoshop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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

   //修改昵称
    @Modifying
    @Transactional
   @Query(value = "update User u set u.username = ?1 where u.account = ?2")
   void updateUsername(String username,String account);

    //修改密码
    @Modifying
    @Transactional
    @Query(value = "update User u set u.password = ?1 where u.account = ?2")
    void updatePassword(String password,String account);




}
