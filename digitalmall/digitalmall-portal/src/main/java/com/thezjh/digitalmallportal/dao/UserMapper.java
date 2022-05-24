package com.thezjh.digitalmallportal.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.thezjh.digitalmallportal.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author thezjh
 * @create 2022/5/11 下午3:10
 */
@Mapper
public interface UserMapper extends BaseMapper<SysUser> {
    /**
     * 根据用户id获取用户信息
     *
     * @param id
     * @return
     */

    /**
     * 根据用户名获取用户信息
     *
     * @param username
     * @return
     */
    SysUser getUserByUsername(String username);


    /**
     * 获取所有用户信息
     *
     * @return
     */
    List<SysUser> getAllUsers();

    /**
     * 根据用户名删除用户信息
     *
     * @param id
     * @return
     */
    Integer deleteUserById(Integer id);

    /**
     * 管理员更改用户
     *
     * @param user
     * @return
     */
    SysUser login(String username, String password);
}
