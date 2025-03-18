package com.yinrj.drawingboardserver.modules.user.domain.service.impl;

import com.yinrj.drawingboardserver.modules.user.domain.entity.UserEntity;
import com.yinrj.drawingboardserver.modules.user.domain.repository.UserRepository;
import com.yinrj.drawingboardserver.modules.user.domain.service.UserService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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
     * @param phone     手机号
     * @return 是否登录成功
     */
    @Override
    public UserEntity login(String username, String studentId, String phone) {
        try {
            // 先尝试完全匹配
            var user = userRepository.select(username, studentId, phone);
            if (user != null) {
                return user;
            }

            // 兼容老用户：如果没有通过phone查到用户，则尝试仅通过username和studentId查询
            user = userRepository.selectWithoutPhone(username, studentId);
            if (user != null) {
                // 找到老用户，更新手机号
                log.info("找到老用户，更新手机号. username: {}, studentId: {}, phone: {}", username, studentId, phone);
                user.setPhone(phone);
                userRepository.updatePhone(user);
                return user;
            }

            // 如果还是没找到，则创建新用户
            user = UserEntity.builder()
                    .username(username)
                    .studentId(studentId)
                    .phone(phone)
                    .build();
            userRepository.insert(user);
            return user;
        } catch (Exception e) {
            log.error("login error. username: {}, studentId: {}, phone: {}", username, studentId, phone, e);
        }
        return null;
    }
}
