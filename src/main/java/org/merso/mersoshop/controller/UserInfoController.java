package org.merso.mersoshop.controller;

import org.merso.mersoshop.entity.UserInfo;
import org.merso.mersoshop.repository.UserInfoRepository;
import org.merso.mersoshop.result.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/userInfo")
public class UserInfoController {
    @Autowired
    private UserInfoRepository userInfoRepository;

    @RequestMapping("/insertInfo")
    @ResponseBody
    public ResponseData insertInfo(@RequestBody UserInfo userInfo) {
        System.out.println(userInfo);
        userInfoRepository.save(userInfo);
        ResponseData responseData = new ResponseData();
        responseData.setMsg("okk");
        return responseData;
    }
}
