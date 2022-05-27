package com.thezjh.digitalmallportal.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

/**
 * @author thezjh
 */
@Data
@TableName("user_address")
public class UserAddress {

    private Integer id;
    private long userId;
    private String province;
    private String city;
    private String region;
    private String detailAddress;

}
