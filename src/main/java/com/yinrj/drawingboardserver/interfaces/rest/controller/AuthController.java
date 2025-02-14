package com.yinrj.drawingboardserver.interfaces.rest.controller;

import com.yinrj.drawingboardserver.app.manager.AuthManager;
import com.yinrj.drawingboardserver.common.vo.R;
import com.yinrj.drawingboardserver.interfaces.rest.query.UserLoginQuery;
import com.yinrj.drawingboardserver.interfaces.rest.vo.UserVO;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Name: AuthController
 * Author: yinrongjie
 * Date: 2025/1/23
 */
@RestController
@RequestMapping("/api/auth/v1")
public class AuthController {

    @Resource
    private AuthManager authManager;

    @PostMapping("/login")
    public R<UserVO> login(@RequestBody @Valid UserLoginQuery userLoginQuery) {
        return R.success(authManager.login(userLoginQuery));
    }

}
