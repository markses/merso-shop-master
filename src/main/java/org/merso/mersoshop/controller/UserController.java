package org.merso.mersoshop.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.merso.mersoshop.entity.LoginState;
import org.merso.mersoshop.entity.User;
import org.merso.mersoshop.repository.UserRepository;
import org.merso.mersoshop.result.ResponseData;
import org.merso.mersoshop.result.ResponseDataUtil;
import org.merso.mersoshop.service.EmailService;
import org.merso.mersoshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;


@CrossOrigin
@RestController
@Slf4j
@RequestMapping(value="/user")
public class UserController {
  @Autowired
  private UserService userService;
  @Autowired
  private EmailService emailService;
  @Autowired
  private UserRepository userRepository;

  //用户注册
  @RequestMapping("/registered")
  @ResponseBody
  public ResponseData registered(@RequestBody User user, HttpSession session) {
    ResponseData responseData = new ResponseData();
    String code = (String)session.getAttribute("code");
    String email = (String)session.getAttribute("email");
    if (code != null && code.equals(user.getCode())&& email.equals(user.getEmail()) ) {

      userService.insertUser(user);
      responseData.setCode(250);
      responseData.setMsg("注册成功");
    }else {
      responseData.setCode(500);;
      responseData.setMsg("验证码错误");
      return responseData;
    }
    return responseData;
  }

  //验证码
  @RequestMapping(value = "/email",method = RequestMethod.GET)
  @ResponseBody
  public String judgeEmail(@RequestParam("email") String email, HttpSession session) {
    if (userService.findByEmail(email))
      return "邮箱已经注册";
       String code = emailService.sendEmail(email);
       session.setAttribute("email",email);
       session.setAttribute("code",code);
        return "邮箱验证成功";

  }

//用户登录
  @RequestMapping("/login")
  @ResponseBody
  public ResponseData login(@RequestBody User user, Model model,HttpSession session){
    /**
     * 使用shrio编写认证操作
     *
     */

    //1.获取subjec

    Subject subject = SecurityUtils.getSubject();

    //2.封装用户数据
    UsernamePasswordToken token = new UsernamePasswordToken(user.getAccount(),user.getPassword());


    //3.执行登录方法
    try {
      subject.login(token);
      LoginState loginState = new LoginState();
      loginState.setUsername(userService.getUsername(user.getAccount()));
     loginState.setIsLogin(false);
     loginState.setAccount(user.getAccount());
     session.setAttribute("loginState",loginState);
    return ResponseDataUtil.success("登录成功");

    }
    catch (UnknownAccountException e){

      return ResponseDataUtil.failure("账户错误");

    }catch (IncorrectCredentialsException e) {

      return ResponseDataUtil.failure(110,"密码错误");
    }



  }

  //判断用户登录状态
  @RequestMapping(value = "/init", method = RequestMethod.GET)
  @ResponseBody
  public LoginState ifUserLogin(HttpSession session) {
    LoginState loginState;
    loginState = (LoginState)session.getAttribute("loginState");
    System.out.println(session.getAttribute("loginState"));
    if (loginState == null)
      loginState = new LoginState();

    return loginState;


  }

  //用户退出
  @RequestMapping("/logout")
  public String logout(){
    Subject subject = SecurityUtils.getSubject();
    subject.logout();
    return "logout";
  }
//修改昵称
@RequestMapping(value = "/updateAccount",method = RequestMethod.GET)
@ResponseBody
public ResponseData updateAccount(@RequestParam("username") String username,@RequestParam("account")String account) {
    String username1 = userService.updateUsername(username, account);

 ResponseData responseData = new ResponseData();
 responseData.setMsg("修改成功");
 responseData.setData(username1);
 return  responseData;
}

  @RequestMapping(value = "/updatePassword",method = RequestMethod.GET)
  @ResponseBody
  public String updatePassword(@RequestParam("password") String password,@RequestParam("account")String account) {
   userRepository.updatePassword(password,account);
   return "修改成功";
  }

}