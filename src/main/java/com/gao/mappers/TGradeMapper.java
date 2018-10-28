package com.gao.mappers;

import com.gao.model.TGrade;

public interface TGradeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TGrade record);

    int insertSelective(TGrade record);

    TGrade selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TGrade record);

    int updateByPrimaryKey(TGrade record);
}