package com.thezjh.digitalmallportal.entity;


import lombok.*;

/**
 * @author thezjh
 */
@Data
public class Products {

    private Integer id;
    private String productName;
    private long status;
    private String title;
    private String image;
    private double price;
    private String detail;
    private long stock;
    private java.sql.Timestamp createTime;
    private java.sql.Timestamp updateTime;


}
