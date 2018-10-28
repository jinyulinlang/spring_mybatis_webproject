package com.gao.mappers;

import com.gao.model.TCivil;
import com.gao.model.TCivilWithBLOBs;

public interface TCivilMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TCivilWithBLOBs record);

    int insertSelective(TCivilWithBLOBs record);

    TCivilWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TCivilWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(TCivilWithBLOBs record);

    int updateByPrimaryKey(TCivil record);
}