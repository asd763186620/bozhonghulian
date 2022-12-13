package org.example.bzhl.user.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.bzhl.model.UserInfo;
import org.example.bzhl.user.mapper.UserInfoMapper;
import org.example.bzhl.user.service.UserInfoService;
import org.example.bzhl.vo.UserInfoRegisterVo;
import org.example.util.JwtHelper;
import org.example.util.MD5;
import org.springframework.stereotype.Service;


/**
* @author LiJia
* @description 针对表【user_info】的数据库操作Service实现
* @createDate 2022-12-12 16:40:28
*/
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo>
    implements UserInfoService{

    @Override
    public String login(String userId,String userPassword) {
        //密码加密
        String encrypt = MD5.encrypt(userPassword);
        QueryWrapper<UserInfo> userInfoQueryWrapper = new QueryWrapper<>();
        userInfoQueryWrapper.eq("user_id",userId).eq("user_password",encrypt);
        //查库
        UserInfo userInfo = this.getOne(userInfoQueryWrapper);
        //生成token
        String token = JwtHelper.createToken(userInfo.getId(), userInfo.getUserId());
        return token;
    }

    @Override
    public void register(UserInfoRegisterVo userInfoRegisterVo) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(userInfoRegisterVo.getUserId());
        userInfo.setUserName(userInfoRegisterVo.getUserName());
        userInfo.setUserPassword(MD5.encrypt(userInfoRegisterVo.getUserPassword()));
        this.save(userInfo);
    }
}




