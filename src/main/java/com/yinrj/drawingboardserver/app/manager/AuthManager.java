package com.yinrj.drawingboardserver.app.manager;

import com.yinrj.drawingboardserver.app.assembler.AuthAssembler;
import com.yinrj.drawingboardserver.common.enums.StatusCodeEnum;
import com.yinrj.drawingboardserver.common.exception.CommonException;
import com.yinrj.drawingboardserver.interfaces.rest.query.UserLoginQuery;
import com.yinrj.drawingboardserver.interfaces.rest.vo.UserVO;
import com.yinrj.drawingboardserver.modules.user.domain.service.UserService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Name: AuthManager
 * Author: yinrongjie
 * Date: 2025/1/23
 */
@Component
@Slf4j
public class AuthManager {

    @Resource
    private UserService userService;

    @Resource
    private AuthAssembler assembler;

    public UserVO login(@Valid UserLoginQuery userLoginQuery) {
        var user = userService.login(userLoginQuery.getUsername(), userLoginQuery.getStudentId());
        if (user == null) {
            throw new CommonException(StatusCodeEnum.SYSTEM_ERROR);
        }
        return assembler.entity2VO(user);
    }

}
