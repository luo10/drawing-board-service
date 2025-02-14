package com.yinrj.drawingboardserver.modules.user.domain.repository;

import com.yinrj.drawingboardserver.modules.user.domain.entity.UserEntity;

/**
 * Name: UserRepository
 * Author: yinrongjie
 * Date: 2025/1/22
 */
public interface UserRepository {

    /**
     * 插入用户信息
     *
     * @param user 用户信息
     */
    void insert(UserEntity user);

    /**
     * 根据用户名与学号查询用户信息
     *
     * @param username  用户名
     * @param studentId 学号
     * @return 用户信息
     */
    UserEntity select(String username, String studentId);

}
