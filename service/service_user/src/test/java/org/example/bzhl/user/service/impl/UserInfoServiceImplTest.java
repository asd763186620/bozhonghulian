package org.example.bzhl.user.service.impl;

import org.example.bzhl.user.service.UserInfoService;
import org.example.bzhl.vo.UserInfoRegisterVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


/**
 * @Classname UserInfoServiceImplTest
 * @Date 2022/12/13 14:03
 * @Author 花非
 * @Version 1.0
 * @Description
 */
@SpringBootTest
class UserInfoServiceImplTest {

    @Autowired
    private UserInfoService userInfoService;
    @Test
    public void testR(){
        UserInfoRegisterVo userInfoRegisterVo = new UserInfoRegisterVo();
        userInfoRegisterVo.setUserId("admin");
        userInfoRegisterVo.setUserName("admin");
        userInfoRegisterVo.setUserPassword("admin");
        userInfoService.register(userInfoRegisterVo);
    }
}