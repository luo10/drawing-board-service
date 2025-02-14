package com.yinrj.drawingboardserver.app.assembler;

import com.yinrj.drawingboardserver.interfaces.rest.vo.UserVO;
import com.yinrj.drawingboardserver.modules.user.domain.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * Name: AuthAssembler
 * Author: yinrongjie
 * Date: 2025/1/23
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AuthAssembler {

    UserVO entity2VO(UserEntity userEntity);

}
