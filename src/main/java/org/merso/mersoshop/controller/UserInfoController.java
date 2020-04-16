package org.merso.mersoshop.controller;

import org.merso.mersoshop.entity.UserInfo;
import org.merso.mersoshop.repository.UserInfoRepository;
import org.merso.mersoshop.result.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping("/getInfo")
    @ResponseBody
    public ResponseData getInfo(@RequestParam("account") String account) {
        ResponseData responseData = new ResponseData();
        responseData.setData(userInfoRepository.findAllByAccount(account));
        return responseData;
    }

    @RequestMapping("/deleteInfo")
    @ResponseBody
    public ResponseData deleteInfo(@RequestParam("id") int id) {
        ResponseData responseData = new ResponseData();
        userInfoRepository.deleteById(id);
        responseData.setMsg("删除成功");
        return responseData;
    }
}
