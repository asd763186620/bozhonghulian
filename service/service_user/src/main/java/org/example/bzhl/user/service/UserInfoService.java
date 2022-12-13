package org.example.bzhl.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.bzhl.model.UserInfo;
import org.example.bzhl.vo.UserInfoRegisterVo;

/**
* @author LiJia
* @description 针对表【user_info】的数据库操作Service
* @createDate 2022-12-12 16:40:28
*/
public interface UserInfoService extends IService<UserInfo> {

    String login(String userId,String userPassword);

    void register(UserInfoRegisterVo userInfoRegisterVo);
}
