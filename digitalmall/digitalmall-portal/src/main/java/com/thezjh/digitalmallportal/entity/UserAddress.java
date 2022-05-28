package com.thezjh.digitalmallportal.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

/**
 * @author thezjh
 */
@Data
@TableName("user_address")
public class UserAddress {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("user_id")
    private long userId;
    @TableField("province")
    private String province;
    @TableField("city")
    private String city;
    @TableField("region")
    private String region;
    @TableField("detail_address")
    private String detailAddress;

}
