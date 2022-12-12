package org.example.bzhl.user.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.bzhl.model.UserInfo;
import org.example.bzhl.user.mapper.UserInfoMapper;
import org.example.bzhl.user.service.UserInfoService;
import org.springframework.stereotype.Service;

/**
* @author LiJia
* @description 针对表【user_info】的数据库操作Service实现
* @createDate 2022-12-12 16:40:28
*/
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo>
    implements UserInfoService{

}




