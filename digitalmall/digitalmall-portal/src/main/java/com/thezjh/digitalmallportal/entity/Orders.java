package com.thezjh.digitalmallportal.entity;


import lombok.*;
import org.springframework.stereotype.Component;

/**
 * @author thezjh
 */
@Data
@Component
public class Orders {

    private long id;
    private long userId;
    private long shoppingId;
    private double payment;
    private long postage;
    private long status;
    private long freight;
    private java.sql.Timestamp paymentTime;
    private java.sql.Timestamp sendTime;
    private java.sql.Timestamp endTime;
    private java.sql.Timestamp createTime;
    private java.sql.Timestamp updateTime;


}
