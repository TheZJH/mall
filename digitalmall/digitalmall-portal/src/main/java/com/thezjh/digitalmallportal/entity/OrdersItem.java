package com.thezjh.digitalmallportal.entity;


import lombok.*;

/**
 * @author 20143
 */
@Data
public class OrdersItem {

  private long id;
  private long orderId;
  private long userId;
  private long productId;
  private String productName;
  private String productImage;
  private double currentPrice;
  private long quantity;
  private double price;
  private java.sql.Timestamp createTime;
  private java.sql.Timestamp updateTime;
  private long addressId;


}
