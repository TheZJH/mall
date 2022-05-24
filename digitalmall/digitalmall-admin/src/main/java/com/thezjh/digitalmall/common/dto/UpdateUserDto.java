package com.thezjh.digitalmall.common.dto;

import lombok.Data;

/**
 * @author thezjh
 * @create 2022/5/18 下午5:09
 */
@Data
public class UpdateUserDto {
    private long id;
    private String username;
    private String realname;
    private String phone;
    private long role;
}
