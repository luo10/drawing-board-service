package com.yinrj.drawingboardserver.modules.subject.infrastructure.db.assembler;

import com.yinrj.drawingboardserver.common.assembler.BaseInfraAssembler;
import com.yinrj.drawingboardserver.common.utils.TimeUtil;
import com.yinrj.drawingboardserver.modules.subject.domain.entity.SubjectResultsEntity;
import com.yinrj.drawingboardserver.modules.subject.infrastructure.db.model.SubjectResultsDO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

/**
 * Name: SubjectResultsAssembler
 * Author: yinrongjie
 * Date: 2025/1/24
 */
@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        imports = {TimeUtil.class})
public interface SubjectResultsAssembler extends BaseInfraAssembler<SubjectResultsDO, SubjectResultsEntity> {

    @Override
    @Mapping(target = "createTime", expression = "java(TimeUtil.now())")
    @Mapping(target = "updateTime", expression = "java(TimeUtil.now())")
    SubjectResultsDO toDO(SubjectResultsEntity subjectResultsEntity);
}
