package com.example.stockmcp.entity;

import lombok.Data;

@Data
public class StockTime {
    /**
     * 交易时间，短分时级别格式为YYYY-MM-DD HH:MM，日线级别为yyyy-MM-dd
     */
    private String d;
    
    /**
     * 开盘价（元）
     */
    private Double o;
    
    /**
     * 最高价（元）
     */
    private Double h;
    
    /**
     * 最低价（元）
     */
    private Double l;
    
    /**
     * 收盘价（元）
     */
    private Double c;
    
    /**
     * 成交量（手）
     */
    private Integer v;
    
    /**
     * 成交额（元）
     */
    private Double e;
    
    /**
     * 振幅（%）
     */
    private Double zf;
    
    /**
     * 换手率（%）
     */
    private Double hs;
    
    /**
     * 涨跌幅（%）
     */
    private Double zd;
    
    /**
     * 涨跌额（元）
     */
    private Double zde;

    /**
     * 更新时间
     */
    private String ud;
}
