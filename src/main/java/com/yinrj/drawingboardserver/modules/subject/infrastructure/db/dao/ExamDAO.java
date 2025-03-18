package com.yinrj.drawingboardserver.modules.subject.infrastructure.db.dao;

import com.yinrj.drawingboardserver.modules.subject.infrastructure.db.model.ExamDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Result;

/**
 * Name: ExamDAO
 * Author: yinrongjie
 * Date: 2025/1/23
 */
@Mapper
public interface ExamDAO {

    @Insert("INSERT INTO exam(exam_id, flag, ctime, utime, student_id, login_time, ip_address, device_info) " +
            "VALUES (#{examId}, #{flag}, #{createTime}, #{updateTime}, #{studentId}, #{loginTime}, #{ipAddress}, #{deviceInfo})")
    @Results(value = {
            @Result(column = "id", property = "id"),
            @Result(column = "exam_id", property = "examId"),
            @Result(column = "flag", property = "flag"),
            @Result(column = "student_id", property = "studentId"),
            @Result(column = "login_time", property = "loginTime"),
            @Result(column = "ip_address", property = "ipAddress"),
            @Result(column = "device_info", property = "deviceInfo"),
            @Result(column = "ctime", property = "createTime"),
            @Result(column = "utime", property = "updateTime")
    })
    void insertExam(ExamDO examDO);

}
