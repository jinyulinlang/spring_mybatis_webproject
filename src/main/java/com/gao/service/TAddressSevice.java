package com.gao.service;

import com.gao.model.TAddress;

public interface TAddressSevice {

    int deleteByPrimaryKey(Integer id);

    int insert(TAddress record);

    int insertSelective(TAddress record);

    TAddress selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TAddress record);

    int updateByPrimaryKey(TAddress record);
}
