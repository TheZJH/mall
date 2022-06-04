package com.thezjh.digitalmallportal.service;

import com.thezjh.digitalmallportal.entity.SysUser;

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

    /**
     * 根据用户id删除用户
     *
     * @param id
     * @return
     */
    Integer deleteUserById(Integer id);

    /**
     * 登录方法
     *
     * @param username
     * @param password
     * @return
     */
    SysUser login(String username, String password);

    /**
     * 注册用户
     * @param user
     * @return
     */
    Integer register(SysUser user);
}
