package com.yinrj.drawingboardserver.modules.user.domain.service.impl;

import com.yinrj.drawingboardserver.modules.user.domain.entity.UserEntity;
import com.yinrj.drawingboardserver.modules.user.domain.repository.UserRepository;
import com.yinrj.drawingboardserver.modules.user.domain.service.UserService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Name: UserServiceImpl
 * Author: yinrongjie
 * Date: 2025/1/22
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;

    /**
     * 用户登录
     *
     * @param username  用户名
     * @param studentId 学号
     * @return 是否登录成功
     */
    @Override
    public UserEntity login(String username, String studentId) {
        try {
            var user = userRepository.select(username, studentId);
            if (user == null) {
                user = UserEntity.builder()
                        .username(username)
                        .studentId(studentId)
                        .build();
                userRepository.insert(user);
            }
            return user;
        } catch (Exception e) {
            log.error("login error. username: {}, studentId: {}", username, studentId, e);
        }
        return null;
    }
}
