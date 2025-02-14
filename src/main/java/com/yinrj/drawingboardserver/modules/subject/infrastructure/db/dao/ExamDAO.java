package com.yinrj.drawingboardserver.modules.subject.infrastructure.db.dao;

import com.yinrj.drawingboardserver.modules.subject.infrastructure.db.model.ExamDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * Name: ExamDAO
 * Author: yinrongjie
 * Date: 2025/1/23
 */
@Mapper
public interface ExamDAO {

    @Insert("INSERT INTO exam(exam_id, flag, ctime, utime, student_id) " +
            "VALUES (#{examId}, #{flag}, #{createTime}, #{updateTime}, #{studentId})")
    void insertExam(ExamDO examDO);

}
