package com.yinrj.drawingboardserver.modules.subject.infrastructure.db.dao;

import com.yinrj.drawingboardserver.modules.subject.infrastructure.db.model.SubjectResultsDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

/**
 * Name: SubjectResultsDAO
 * Author: yinrongjie
 * Date: 2025/1/24
 */
@Mapper
public interface SubjectResultsDAO {

    @Insert("INSERT INTO subject_results(exam_id, student_id, subject_title, img_name, img_url, used_time, " +
            "drawn_strokes, undo_count, redo_count, first_stroke_time, total_stroke_duration, ctime, utime) " +
            "VALUES (#{examId}, #{studentId}, #{subjectTitle}, #{imgName}, #{imgUrl}, #{usedTime}, " +
            "#{drawnStrokes}, #{undoCount}, #{redoCount}, #{firstStrokeTime}, #{totalStrokeDuration}, #{createTime}, #{updateTime})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(SubjectResultsDO subjectResultsDO);

}
