package com.thezjh.digitalmallportal.service.impl;

import com.thezjh.digitalmallportal.dao.UserMapper;
import com.thezjh.digitalmallportal.entity.SysUser;
import com.thezjh.digitalmallportal.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author thezjh
 * @create 2022/5/22 下午8:20
 */
@Slf4j
@Service
public class SysUserServiceImpl implements SysUserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public SysUser getUserByName(String username) {
        return null;
    }

    @Override
    public SysUser getUserById(long id) {
        return null;
    }

    @Override
    public Integer deleteUserById(Integer id) {
        return null;
    }

    @Override
    public SysUser login(String username, String password) {

        return userMapper.login(username, password);
    }

    @Override
    public Integer register(SysUser user) {
        return userMapper.insert(user);
    }
}
