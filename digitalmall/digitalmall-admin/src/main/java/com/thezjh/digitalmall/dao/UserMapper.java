package com.thezjh.digitalmall.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.thezjh.digitalmall.common.dto.UpdateUserDto;
import com.thezjh.digitalmall.entity.SysUser;
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
    List<SysUser> getUserById(long id);

    /**
     * 根据用户名获取用户信息
     *
     * @param username
     * @return
     */
    SysUser getUserByUsername(String username);

    SysUser getOneUserById(long id);

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
     * @param user
     * @return
     */
    Integer adminChangeUser(UpdateUserDto user);
}
