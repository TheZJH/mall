package com.thezjh.digitalmall.service.impl;

import cn.hutool.jwt.JWTUtil;
import com.thezjh.digitalmall.common.dto.UpdateUserDto;
import com.thezjh.digitalmall.common.lang.Result;
import com.thezjh.digitalmall.dao.UserMapper;
import com.thezjh.digitalmall.entity.SysUser;
import com.thezjh.digitalmall.security.LoginUser;
import com.thezjh.digitalmall.service.SysUserService;
import com.thezjh.digitalmall.utils.JwtUtils;
import com.thezjh.digitalmall.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author thezjh
 * @create 2022/5/11 下午3:28
 */
@Service
public class SysUserServiceImpl implements SysUserService {
    @Resource
    private UserMapper userMapper;

    @Autowired
    private AuthenticationManager authenticationManager;
    @Resource
    private JwtUtils jwtUtils;

    @Resource
    private RedisUtil redisUtil;

    @Override
    public SysUser getUserByName(String username) {
        return userMapper.getUserByUsername(username);
    }

    @Override
    public SysUser getUserById(long id) {
        SysUser user = userMapper.getOneUserById(id);
        return user;
    }

    @Override
    public Result login(SysUser user) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());

        //AuthenticationManager 进行用户认证，会调用 loadUserByUsername 进行校验
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        //如果认证通过
        if (Objects.isNull(authenticate)) {
            throw new RuntimeException("登录失败");
        }
        //如果认证通过，使用username生成jwt

        //根据用户名生成 jwt
        String jwt = jwtUtils.generateToken(user.getUsername());
        Map<String, String> map = new HashMap<>();
        map.put("token", jwt);
        //把完整的用户信息存入 redis，用户名 作为 key，设置过期时间为1周
        redisUtil.set(user.getUsername(), user, 604800);
        return Result.success(200, "登录成功", map);
    }

    @Override
    public Integer deleteUserById(Integer id) {
        int i = userMapper.deleteUserById(id);
        return i;
    }

    @Override
    public Integer AdminChangeUser(UpdateUserDto user) {
        Integer integer = userMapper.adminChangeUser(user);
        return integer;
    }


}
