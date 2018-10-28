package com.gao.mappers;

import com.gao.model.TVistor;

public interface TVistorMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TVistor record);

    int insertSelective(TVistor record);

    TVistor selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TVistor record);

    int updateByPrimaryKey(TVistor record);
}