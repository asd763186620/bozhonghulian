package org.example.bzhl.vo;

import lombok.Data;

/**
 * @Classname UserInfoVo
 * @Date 2022/12/13 9:24
 * @Author 花非
 * @Version 1.0
 * @Description
 */
@Data
public class UserInfoVo {
    /**
     * 用户账号
     */
    private String userId;

    /**
     * 用户密码
     */
    private String userPassword;
}
