package org.merso.mersoshop.service;

import org.merso.mersoshop.entity.User;
import org.merso.mersoshop.entity.UserInfo;
import org.merso.mersoshop.repository.UserInfoRepository;
import org.springframework.beans.NotWritablePropertyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService {
    @Autowired
    private UserInfoRepository userInfoRepository;
    public void insertInfo(UserInfo userInfo){


    }
}
