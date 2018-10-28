package com.gao.service.impl;

import com.gao.mappers.TAddressMapper;
import com.gao.model.TAddress;
import com.gao.service.TAddressSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TAddressSeviceImpl implements TAddressSevice {
    @Autowired
    private TAddressMapper tAddressMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return tAddressMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(TAddress tAddress) {
        return tAddressMapper.insert(tAddress);
    }

    @Override
    public int insertSelective(TAddress record) {
        return tAddressMapper.insertSelective(record);
    }

    @Override
    public TAddress selectByPrimaryKey(Integer id) {
        return tAddressMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(TAddress record) {
        return tAddressMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TAddress record) {
        return tAddressMapper.updateByPrimaryKey(record);
    }
}
