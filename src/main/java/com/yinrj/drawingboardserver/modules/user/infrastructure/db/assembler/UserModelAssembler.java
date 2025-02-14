package com.yinrj.drawingboardserver.modules.user.infrastructure.db.assembler;

import com.yinrj.drawingboardserver.common.assembler.BaseInfraAssembler;
import com.yinrj.drawingboardserver.common.utils.TimeUtil;
import com.yinrj.drawingboardserver.modules.user.domain.entity.UserEntity;
import com.yinrj.drawingboardserver.modules.user.infrastructure.db.model.UserDO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

/**
 * Name: UserModelAssembler
 * Author: yinrongjie
 * Date: 2025/1/22
 */
@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        imports = {TimeUtil.class})
public interface UserModelAssembler extends
        BaseInfraAssembler<UserDO, UserEntity> {

    @Override
    @Mapping(target = "createTime", expression = "java(TimeUtil.now())")
    @Mapping(target = "updateTime", expression = "java(TimeUtil.now())")
    UserDO toDO(UserEntity user);
}
