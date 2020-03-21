package org.merso.mersoshop.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.merso.mersoshop.entity.LoginState;
import org.merso.mersoshop.entity.User;
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

  //用户注册
  @RequestMapping("/registered")
  @ResponseBody
  public ResponseData registered(@RequestBody User user, HttpSession session) {
    ResponseData responseData = new ResponseData();

    String code = (String)session.getAttribute("code");
    String email = (String)session.getAttribute("email");
    System.out.println(code);


    if (code != null && code.equals(user.getCode())&& email.equals(user.getEmail()) ) {

      userService.insertUser(user);
      responseData.setCode(250);
      responseData.setMsg("注册成功");
    }else {
      responseData.setCode(500);;
      responseData.setMsg("验证码错误");
      return responseData;
    }
//    else {
//      responseData.setMsg("请检查网络连接");
//      return responseData;
//    }
    return responseData;
  }

  //验证码
  @RequestMapping(value = "/email",method = RequestMethod.GET)
  @ResponseBody
  public String judgeEmail(@RequestParam("email") String email, HttpSession session) {
    //session.setMaxInactiveInterval(100);
    if (userService.findByEmail(email))
      return "邮箱已经注册";

      //return emailService.sendEmail(email);
    String code = emailService.sendEmail(email);
       session.setAttribute("email",email);
       session.setAttribute("code",code);
       System.out.println(session.getAttribute("code"));
    System.out.println(session.getAttribute("email"));

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
    System.out.println(user.getUsername()+user.getPassword());
    Subject subject = SecurityUtils.getSubject();

    //2.封装用户数据
    UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(),user.getPassword());
    System.out.println(token);

    //3.执行登录方法
    try {
      subject.login(token);
      LoginState loginState = new LoginState();
     loginState.setIsLogin(false);
     loginState.setUsername(user.getUsername());
     session.setAttribute("loginState",loginState);
     System.out.println(session.getAttribute("loginState"));
    return ResponseDataUtil.success("登录成功");
//      model.addAttribute("msg","登录成功");
    }
    catch (UnknownAccountException e){
//     model.addAttribute("msg","用户名不存在！");
      return ResponseDataUtil.failure("账户错误");

    }catch (IncorrectCredentialsException e) {
      //密码错误 ，登录失败
      //model.addAttribute("msg", "密码错误");
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


}