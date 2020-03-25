package org.merso.mersoshop.shiro;


import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;

import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.merso.mersoshop.entity.User;
import org.merso.mersoshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


/**
 * MyRealm:自定义一个授权
 *
 * @author zhangxiaoxiang
 * @date: 2019/07/12
 */

public class MyRealm extends AuthorizingRealm {

    @Autowired
    private UserRepository userRepository;

//    @Override
//    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
//        return null;
//    }
//
//    @Override
//    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
//        return null;
//    }


    //用户认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg0) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken)arg0;

        User user = userRepository.findByAccount(token.getUsername());

        //验证账户信息
        if (user == null) {
            return null; //it's will be throw a UnknownAccountException
        }
        //验证密码信息
       return new SimpleAuthenticationInfo("", user.getPassword(),"");

}

   //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }
}


