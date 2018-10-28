package com.gao.test;

import com.alibaba.fastjson.JSONObject;
import com.gao.model.TAddress;
import com.gao.service.TAddressSevice;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TAddressTest {
    @Autowired
    private TAddressSevice tAddressSevice;


    @Test
    public void testFindById() {
        TAddress tAddress = tAddressSevice.selectByPrimaryKey(1);
        Object o = (JSONObject) JSONObject.toJSON(tAddress);
        String s = ((JSONObject) o).toJSONString();

        System.out.println(s);

    }

}
