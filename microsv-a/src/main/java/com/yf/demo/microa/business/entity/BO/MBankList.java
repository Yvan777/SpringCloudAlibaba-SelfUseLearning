package com.yf.demo.microa.business.entity.BO;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * m_bank_list
 * @author 
 */
@Data
public class MBankList implements Serializable {
    private String id;

    /**
     * 银行id
     */
    private String bankId;

    /**
     * 银行名称
     */
    private String bankName;

    private String displayName;

    /**
     * 银行类型枚举:b2c;b2b1
     */
    private String bankType;

    /**
     * 银行显示状态 1-显示;0-隐藏
     */
    private String status;

    /**
     * create time
     */
    private Date createDate;

    /**
     * modification time
     */
    private Date modifyDate;

    private static final long serialVersionUID = 1L;
}