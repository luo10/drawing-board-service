package com.yinrj.drawingboardserver.interfaces.rest.query;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Name: UserLoginQuery
 * Author: yinrongjie
 * Date: 2025/1/23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginQuery {

    @NotBlank(message = "username is not blank")
    private String username;

    @JsonProperty("student_id")
    @NotBlank(message = "studentId is not blank")
    private String studentId;

    private String phone;
}
