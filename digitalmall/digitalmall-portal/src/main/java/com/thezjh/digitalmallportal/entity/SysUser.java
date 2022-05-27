package com.thezjh.digitalmallportal.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author thezjh
 * @create 2022/5/11 下午2:51
 */
@Data
@TableName("users")
public class SysUser {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("username")
    private String username;
    @TableField("password")
    private String password;
    @TableField("realname")
    private String realname;
    @TableField("phone")
    private long phone;
    @TableField("role")
    private long role;
    @TableField("email")
    private String email;
    @TableField("create_time")
    private java.sql.Timestamp createTime;
    @TableField("update_time")
    private java.sql.Timestamp updateTime;
    @TableField("days")
    private long days;
}
