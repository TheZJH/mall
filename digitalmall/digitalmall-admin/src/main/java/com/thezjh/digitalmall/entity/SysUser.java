package com.thezjh.digitalmall.entity;

import lombok.Data;

/**
 * @author thezjh
 * @create 2022/5/11 下午2:51
 */
@Data
public class SysUser {
    private long id;
    private String username;
    private String password;
    private String realname;
    private long phone;
    private long role;
    private String email;
    private java.sql.Timestamp createTime;
    private java.sql.Timestamp updateTime;
    private long days;
}
