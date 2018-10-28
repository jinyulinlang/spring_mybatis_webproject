package com.gao.mappers;

import com.gao.model.TEmployee;

public interface TEmployeeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TEmployee record);

    int insertSelective(TEmployee record);

    TEmployee selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TEmployee record);

    int updateByPrimaryKey(TEmployee record);
}