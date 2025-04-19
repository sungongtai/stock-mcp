package com.example.stockmcp.entity;

import lombok.Data;

@Data
public class CompanyDetail {
    /**
     * 公司名称
     */
    private String name;
    
    /**
     * 公司英文名称
     */
    private String ename;
    
    /**
     * 上市市场
     */
    private String market;
    
    /**
     * 概念及板块，多个概念由英文逗号分隔
     */
    private String idea;
    
    /**
     * 上市日期，格式yyyy-MM-dd
     */
    private String ldate;
    
    /**
     * 发行价格（元）
     */
    private String sprice;
    
    /**
     * 主承销商
     */
    private String principal;
    
    /**
     * 成立日期
     */
    private String rdate;
    
    /**
     * 注册资本
     */
    private String rprice;
    
    /**
     * 机构类型
     */
    private String instype;
    
    /**
     * 组织形式
     */
    private String organ;
    
    /**
     * 董事会秘书
     */
    private String secre;
    
    /**
     * 公司电话
     */
    private String phone;
    
    /**
     * 董秘电话
     */
    private String sphone;
    
    /**
     * 公司传真
     */
    private String fax;
    
    /**
     * 董秘传真
     */
    private String sfax;
    
    /**
     * 公司电子邮箱
     */
    private String email;
    
    /**
     * 董秘电子邮箱
     */
    private String semail;
    
    /**
     * 公司网站
     */
    private String site;
    
    /**
     * 邮政编码
     */
    private String post;
    
    /**
     * 信息披露网址
     */
    private String infosite;
    
    /**
     * 证券简称更名历史
     */
    private String oname;
    
    /**
     * 注册地址
     */
    private String addr;
    
    /**
     * 办公地址
     */
    private String oaddr;
    
    /**
     * 公司简介
     */
    private String desc;
    
    /**
     * 经营范围
     */
    private String bscope;
    
    /**
     * 承销方式
     */
    private String printype;
    
    /**
     * 上市推荐人
     */
    private String referrer;
    
    /**
     * 发行方式
     */
    private String putype;
    
    /**
     * 发行市盈率（按发行后总股本）
     */
    private String pe;
    
    /**
     * 首发前总股本（万股）
     */
    private String firgu;
    
    /**
     * 首发后总股本（万股）
     */
    private String lastgu;
    
    /**
     * 实际发行量（万股）
     */
    private String realgu;
    
    /**
     * 预计募集资金（万元）
     */
    private String planm;
    
    /**
     * 实际募集资金合计（万元）
     */
    private String realm;
    
    /**
     * 发行费用总额（万元）
     */
    private String pubfee;
    
    /**
     * 募集资金净额（万元）
     */
    private String collect;
    
    /**
     * 承销费用（万元）
     */
    private String signfee;
    
    /**
     * 招股公告日
     */
    private String pdate;
}
