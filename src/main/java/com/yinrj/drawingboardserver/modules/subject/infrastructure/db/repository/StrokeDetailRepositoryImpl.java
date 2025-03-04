package com.yinrj.drawingboardserver.modules.subject.infrastructure.db.repository;

import com.yinrj.drawingboardserver.modules.subject.domain.repository.StrokeDetailRepository;
import com.yinrj.drawingboardserver.modules.subject.infrastructure.db.dao.StrokeDetailDAO;
import com.yinrj.drawingboardserver.modules.subject.infrastructure.db.model.StrokeDetailDO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 笔画详情仓库实现类
 */
@Repository
public class StrokeDetailRepositoryImpl implements StrokeDetailRepository {

  @Resource
  private StrokeDetailDAO strokeDetailDAO;

  @Override
  public int batchInsert(List<StrokeDetailDO> strokeDetails) {
    return strokeDetailDAO.batchInsert(strokeDetails);
  }
}