package com.yinrj.drawingboardserver.modules.subject.infrastructure.db.assembler;

import com.yinrj.drawingboardserver.common.assembler.BaseInfraAssembler;
import com.yinrj.drawingboardserver.common.utils.TimeUtil;
import com.yinrj.drawingboardserver.modules.subject.domain.entity.ExamEntity;
import com.yinrj.drawingboardserver.modules.subject.infrastructure.db.model.ExamDO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

/**
 * Name: ExamAssembler
 * Author: yinrongjie
 * Date: 2025/1/23
 */
@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        imports = {TimeUtil.class})
public interface ExamAssembler extends BaseInfraAssembler<ExamDO, ExamEntity> {

    @Override
    @Mapping(target = "createTime", expression = "java(TimeUtil.now())")
    @Mapping(target = "updateTime", expression = "java(TimeUtil.now())")
    ExamDO toDO(ExamEntity examEntity);
}
