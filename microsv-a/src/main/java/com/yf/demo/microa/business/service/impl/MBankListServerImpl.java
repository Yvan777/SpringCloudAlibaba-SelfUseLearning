package com.yf.demo.microa.business.service.impl;

import com.yf.demo.microa.business.mapper.Test1Mapper;
import com.yf.demo.microa.business.service.MBankListServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author yvan
 * @CreateDate 2023/5/4 10:05
 */
@Service
public class MBankListServerImpl implements MBankListServer {
    @Autowired
    Test1Mapper test1Mapper;

    @Override
    public Integer countMbankList() {
        return test1Mapper.countMbankList();
    }
}
