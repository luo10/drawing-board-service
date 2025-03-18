package com.yinrj.drawingboardserver.modules.user.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Name: UserEntity
 * Author: yinrongjie
 * Date: 2025/1/22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserEntity {

    private Long id;

    private String username;

    private String studentId;

    private String phone;

    private Long createTime;

    private Long updateTime;

}
