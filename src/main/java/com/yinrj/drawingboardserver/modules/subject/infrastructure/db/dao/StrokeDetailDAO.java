package com.yinrj.drawingboardserver.modules.subject.infrastructure.db.dao;

import com.yinrj.drawingboardserver.modules.subject.infrastructure.db.model.StrokeDetailDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 笔画详情数据访问对象
 */
@Mapper
public interface StrokeDetailDAO {

  /**
   * 插入单条笔画详情记录
   *
   * @param strokeDetailDO 笔画详情数据对象
   * @return 影响的行数
   */
  @Insert("INSERT INTO stroke_details(subject_result_id, stroke_index, start_time, end_time, duration, interval_time) "
      +
      "VALUES (#{subjectResultId}, #{strokeIndex}, #{startTime}, #{endTime}, #{duration}, #{intervalTime})")
  @Options(useGeneratedKeys = true, keyProperty = "id")
  int insert(StrokeDetailDO strokeDetailDO);

  /**
   * 批量插入笔画详情记录
   *
   * @param strokeDetails 笔画详情记录列表
   * @return 插入的记录数
   */
  @Insert("<script>" +
      "INSERT INTO stroke_details(subject_result_id, stroke_index, start_time, end_time, duration, interval_time) VALUES "
      +
      "<foreach collection='list' item='item' separator=','>" +
      "(#{item.subjectResultId}, #{item.strokeIndex}, #{item.startTime}, #{item.endTime}, #{item.duration}, #{item.intervalTime})"
      +
      "</foreach>" +
      "</script>")
  int batchInsert(@Param("list") List<StrokeDetailDO> strokeDetails);
}