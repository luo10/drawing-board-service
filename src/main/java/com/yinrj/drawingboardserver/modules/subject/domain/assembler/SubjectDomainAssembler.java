package com.yinrj.drawingboardserver.modules.subject.domain.assembler;

import com.yinrj.drawingboardserver.modules.subject.domain.entity.ExamEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

/**
 * Name: SubjectDomainAssembler
 * Author: yinrongjie
 * Date: 2025/1/23
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SubjectDomainAssembler {

    @Mapping(target = "flag", constant = "0")
    ExamEntity convert2ExamEntity(String studentId, String examId);

}
