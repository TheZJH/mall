package com.thezjh.digitalmallportal.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author thezjh
 */
@Data
@TableName("shopping_cart")
public class ShoppingCart {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private long userId;
    private long productId;
    private long checked;
    private java.sql.Timestamp createTime;
    private java.sql.Timestamp updateTime;


}
