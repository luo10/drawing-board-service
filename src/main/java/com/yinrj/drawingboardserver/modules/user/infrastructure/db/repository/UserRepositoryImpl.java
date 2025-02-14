package com.yinrj.drawingboardserver.modules.user.infrastructure.db.repository;

import com.yinrj.drawingboardserver.common.utils.TimeUtil;
import com.yinrj.drawingboardserver.modules.user.domain.entity.UserEntity;
import com.yinrj.drawingboardserver.modules.user.domain.repository.UserRepository;
import com.yinrj.drawingboardserver.modules.user.infrastructure.db.assembler.UserModelAssembler;
import com.yinrj.drawingboardserver.modules.user.infrastructure.db.dao.UserDAO;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Name: UserRepositoryImpl
 * Author: yinrongjie
 * Date: 2025/1/22
 */
@Component
@Slf4j
public class UserRepositoryImpl implements UserRepository {

    @Resource
    private UserDAO userDAO;

    @Resource
    private UserModelAssembler userModelAssembler;

    /**
     * 插入用户信息
     *
     * @param user 用户信息
     */
    @Override
    public void insert(UserEntity user) {
        log.info("insert user info. {}", user);
        user.setCreateTime(TimeUtil.now());
        user.setUpdateTime(TimeUtil.now());
        userDAO.insertUser(userModelAssembler.toDO(user));
    }

    /**
     * 根据用户名与学号查询用户信息
     *
     * @param username  用户名
     * @param studentId 学号
     * @return 用户信息
     */
    @Override
    public UserEntity select(String username, String studentId) {
        return userModelAssembler.toEntity(userDAO.selectUser(username, studentId));
    }
}
