package com.yf.demo.microa.business.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yf.demo.microa.business.entity.BO.MBankList;
import com.yf.demo.microa.business.mapper.Test1MapperPlus;
import com.yf.demo.microa.business.service.MBankListServerPlus;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author yvan
 * @CreateDate 2023/5/4 10:05
 */
@Service
public class MBankListServerImplPlus extends ServiceImpl<Test1MapperPlus, MBankList> implements MBankListServerPlus {
    @Override
    public Integer countMbankListPlus() {
        QueryWrapper<MBankList> queryWrapper = new QueryWrapper<>();
        long count = this.count(queryWrapper);
        int i = Integer.parseInt(String.valueOf(count));
        return i;
    }

}
