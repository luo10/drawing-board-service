package com.yinrj.drawingboardserver.modules.subject.domain.repository;

import com.yinrj.drawingboardserver.modules.subject.infrastructure.db.model.StrokeDetailDO;

import java.util.List;

/**
 * 笔画详情数据访问接口
 */
public interface StrokeDetailRepository {

  /**
   * 批量插入笔画详情
   *
   * @param strokeDetails 笔画详情列表
   * @return 插入的记录数量
   */
  int batchInsert(List<StrokeDetailDO> strokeDetails);
}