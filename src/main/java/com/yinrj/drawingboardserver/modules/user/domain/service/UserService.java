package com.yinrj.drawingboardserver.modules.user.domain.service;

import com.yinrj.drawingboardserver.modules.user.domain.entity.UserEntity;

/**
 * Name: UserService
 * Author: yinrongjie
 * Date: 2025/1/22
 */
public interface UserService {

    /**
     * 用户登录
     *
     * @param username  用户名
     * @param studentId 学号
     * @return 用户信息
     */
    UserEntity login(String username, String studentId);

}
