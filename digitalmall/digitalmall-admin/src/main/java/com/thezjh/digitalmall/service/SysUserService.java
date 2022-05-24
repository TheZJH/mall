package com.thezjh.digitalmall.service;

import com.thezjh.digitalmall.common.dto.UpdateUserDto;
import com.thezjh.digitalmall.common.lang.Result;
import com.thezjh.digitalmall.entity.SysUser;

import java.util.List;

/**
 * @author thezjh
 * @create 2022/5/11 下午3:26
 */
public interface SysUserService {
    /**
     * 根据用户名获取用户信息
     *
     * @param username
     * @return
     */
    SysUser getUserByName(String username);

    /**
     * 根据用户id获取用户信息
     *
     * @param id
     * @return
     */
    SysUser getUserById(long id);

    /**
     * 登录认证方法
     *
     * @param user
     * @return
     */
    Result login(SysUser user);

    /**
     * 根据用户id删除用户
     *
     * @param id
     * @return
     */
    Integer deleteUserById(Integer id);

    /**
     * 管理员修改用户
     * @param user
     * @return
     */
    Integer AdminChangeUser(UpdateUserDto user);
}
