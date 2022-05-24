package com.thezjh.digitalmallportal.entity;


import lombok.Data;

/**
 * @author thezjh
 */
@Data
public class ShoppingCart {

    private long id;
    private long userId;
    private long productId;
    private long checked;
    private java.sql.Timestamp createTime;
    private java.sql.Timestamp updateTime;


}
