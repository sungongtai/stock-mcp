package com.example.stockmcp.entity;

import lombok.Data;

@Data
public class StockSSJY {
    /**
     * 五分钟涨跌幅（%）
     */
    private Double fm;
    
    /**
     * 最高价（元）
     */
    private Double h;
    
    /**
     * 换手（%）
     */
    private Double hs;
    
    /**
     * 量比（%）
     */
    private Double lb;
    
    /**
     * 最低价（元）
     */
    private Double l;
    
    /**
     * 流通市值（元）
     */
    private Double lt;
    
    /**
     * 开盘价（元）
     */
    private Double o;
    
    /**
     * 市盈率（动态，总市值除以预估全年净利润）
     */
    private Double pe;
    
    /**
     * 涨跌幅（%）
     */
    private Double pc;
    
    /**
     * 当前价格（元）
     */
    private Double p;
    
    /**
     * 总市值（元）
     */
    private Double sz;
    
    /**
     * 成交额（元）
     */
    private Double cje;
    
    /**
     * 涨跌额（元）
     */
    private Double ud;
    
    /**
     * 成交量（手）
     */
    private Integer v;
    
    /**
     * 昨日收盘价（元）
     */
    private Double yc;
    
    /**
     * 振幅（%）
     */
    private Double zf;
    
    /**
     * 涨速（%）
     */
    private Double zs;
    
    /**
     * 市净率
     */
    private Double sjl;
    
    /**
     * 60日涨跌幅（%）
     */
    private Double zdf60;
    
    /**
     * 年初至今涨跌幅（%）
     */
    private Double zdfnc;
    
    /**
     * 更新时间
     */
    private String t;
}
