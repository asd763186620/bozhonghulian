package org.example.bzhl.vo;

import lombok.Data;

/**
 * @Classname UserInfoRegisterVo
 * @Date 2022/12/13 9:46
 * @Author 花非
 * @Version 1.0
 * @Description
 */
@Data
public class UserInfoRegisterVo {
    /**
     * 用户账号
     */
    private String userId;

    /**
     * 用户昵称
     */
    private String userName;

    /**
     * 用户密码
     */
    private String userPassword;
}
