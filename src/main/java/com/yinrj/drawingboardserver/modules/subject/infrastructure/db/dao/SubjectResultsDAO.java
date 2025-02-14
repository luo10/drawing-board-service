package com.yinrj.drawingboardserver.modules.subject.infrastructure.db.dao;

import com.yinrj.drawingboardserver.modules.subject.infrastructure.db.model.SubjectResultsDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * Name: SubjectResultsDAO
 * Author: yinrongjie
 * Date: 2025/1/24
 */
@Mapper
public interface SubjectResultsDAO {

    @Insert("INSERT INTO subject_results(exam_id, student_id, subject_title, img_name, img_url, used_time, " +
            "drawn_strokes, undo_count, redo_count, ctime, utime) " +
            "VALUES (#{examId}, #{studentId}, #{subjectTitle}, #{imgName}, #{imgUrl}, #{usedTime}, " +
            "#{drawnStrokes}, #{undoCount}, #{redoCount}, #{createTime}, #{updateTime})")
    void insertSubjectResults(SubjectResultsDO subjectResultsDO);

}
