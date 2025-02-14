package com.yinrj.drawingboardserver.modules.user.infrastructure.db.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Name: UserDO
 * Author: yinrongjie
 * Date: 2025/1/22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDO {

    private Long id;

    private String username;

    private String studentId;

    private Long createTime;

    private Long updateTime;

}
