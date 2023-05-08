package com.yf.demo.microa.business.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yf.demo.microa.business.entity.BO.MBankList;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
  * @Description
  * @Author yvan
  * @CreateDate 2023/3/3 10:50
  */
@Mapper
@Repository
public interface Test1MapperPlus extends BaseMapper<MBankList> {

}
