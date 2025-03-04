package com.yinrj.drawingboardserver.modules.subject.infrastructure.db.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 笔画详情数据对象
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StrokeDetailDO {

  /**
   * 主键ID
   */
  private Long id;

  /**
   * 关联到主表subject_results的ID
   */
  private Long subjectResultId;

  /**
   * 笔画索引(第几笔)
   */
  private Integer strokeIndex;

  /**
   * 笔画开始时间戳(毫秒)
   */
  private Long startTime;

  /**
   * 笔画结束时间戳(毫秒)
   */
  private Long endTime;

  /**
   * 笔画持续时间(毫秒)
   */
  private Integer duration;

  /**
   * 与上一笔的间隔时间(毫秒)
   */
  private Integer intervalTime;
}
