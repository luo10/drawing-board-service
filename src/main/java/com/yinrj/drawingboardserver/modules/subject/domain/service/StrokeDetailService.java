package com.yinrj.drawingboardserver.modules.subject.domain.service;

import com.yinrj.drawingboardserver.modules.subject.domain.repository.StrokeDetailRepository;
import com.yinrj.drawingboardserver.modules.subject.infrastructure.db.model.StrokeDetailDO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 笔画详情服务
 */
@Service
public class StrokeDetailService {

  @Resource
  private StrokeDetailRepository strokeDetailRepository;

  /**
   * 批量插入笔画详情记录
   *
   * @param strokeDetails 笔画详情列表
   */
  public void batchInsert(List<StrokeDetailDO> strokeDetails) {
    strokeDetailRepository.batchInsert(strokeDetails);
  }
}