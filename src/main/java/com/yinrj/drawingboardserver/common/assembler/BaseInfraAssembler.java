package com.yinrj.drawingboardserver.common.assembler;

import java.util.List;

/**
 * Name: BaseInfraAssembler
 * Author: yinrongjie
 * Date: 2025/1/22
 */

public interface BaseInfraAssembler<D, E> {

    E toEntity(D d);

    D toDO(E e);

    List<E> toEntityList(List<D> dList);

    List<D> toDOList(List<E> eList);

}
