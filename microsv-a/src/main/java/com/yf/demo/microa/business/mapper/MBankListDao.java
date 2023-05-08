package com.yf.demo.microa.business.mapper;


import com.yf.demo.microa.business.entity.BO.MBankList;

public interface MBankListDao {
    int deleteByPrimaryKey(String id);

    int insert(MBankList record);

    int insertSelective(MBankList record);

    MBankList selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(MBankList record);

    int updateByPrimaryKey(MBankList record);
}