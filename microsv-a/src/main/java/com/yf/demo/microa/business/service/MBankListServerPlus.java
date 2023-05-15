package com.yf.demo.microa.business.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yf.demo.microa.business.entity.BO.MBankList;

/**
 * @Description
 * @Author yvan
 * @CreateDate 2023/5/4 10:05
 */
public interface MBankListServerPlus extends IService<MBankList> {
    Integer countMbankListPlus();
}
