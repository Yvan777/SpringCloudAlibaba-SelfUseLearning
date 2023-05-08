package com.yf.demo.microa.business.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
  * @Description
  * @Author yvan
  * @CreateDate 2023/3/3 10:50
  */
@Mapper
public interface Test1Mapper {
    @Select("select count(*) from m_bank_list")
    Integer countMbankList();
}
