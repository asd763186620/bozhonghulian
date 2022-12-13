package org.example.bzhl.user.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.example.bzhl.user.service.UserInfoService;
import org.example.bzhl.vo.UserInfoRegisterVo;
import org.example.bzhl.vo.UserInfoVo;
import org.example.util.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname UserController
 * @Date 2022/12/12 16:41
 * @Author 花非
 * @Version 1.0
 * @Description
 */
@Api(tags = "登录与注册")
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserInfoService userInfoService;

    /**
     * 登陆请求
     * @param userInfoVo
     * @return
     */
    @ApiOperation(value = "登陆")
    @PostMapping("/login")
    public Result login(@RequestBody UserInfoVo userInfoVo){
        String userId = userInfoVo.getUserId();
        if (userId == null){
            throw new RuntimeException("用户不能为空");
        }
        String userPassword = userInfoVo.getUserPassword();
        if (userPassword == null) {
            throw new RuntimeException("密码不能为空");
        }
        //返回前端token
        String token = userInfoService.login(userId, userPassword);
        
        return Result.ok(token);
    }

    /**
     * 注册请求
     * @param userInfoRegisterVo
     * @return
     */
    @ApiOperation(value = "注册")
    @PostMapping("/register")
    public Result register(@RequestBody UserInfoRegisterVo userInfoRegisterVo){
        userInfoService.register(userInfoRegisterVo);
        return Result.ok();
    }
}
