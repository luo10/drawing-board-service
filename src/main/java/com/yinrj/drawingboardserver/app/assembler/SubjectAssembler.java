package com.yinrj.drawingboardserver.app.assembler;

import com.yinrj.drawingboardserver.app.dto.SubjectResultsDTO;
import com.yinrj.drawingboardserver.modules.subject.domain.entity.SubjectResultsEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * Name: SubjectAssembler
 * Author: yinrongjie
 * Date: 2025/1/24
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SubjectAssembler {

    SubjectResultsEntity convert2ResultsEntity(SubjectResultsDTO result, String imgUrl);

}
