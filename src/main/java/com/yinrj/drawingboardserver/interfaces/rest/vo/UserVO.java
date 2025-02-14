package com.yinrj.drawingboardserver.interfaces.rest.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Name: UserVO
 * Author: yinrongjie
 * Date: 2025/1/22
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserVO {

    private String username;

    @JsonProperty("student_id")
    private String studentId;

}
