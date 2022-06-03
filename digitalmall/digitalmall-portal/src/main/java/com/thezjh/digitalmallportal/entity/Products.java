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
@TableName("products")
public class Products {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("product_name")
    private String productName;
    @TableField("status")
    private long status;
    @TableField("title")
    private String title;
    @TableField("image")
    private String image;
    @TableField("price")
    private double price;
    @TableField("detail")
    private String detail;
    @TableField("stock")
    private long stock;
    @TableField("create_time")
    private java.sql.Timestamp createTime;
    @TableField("update_time")
    private java.sql.Timestamp updateTime;


}
