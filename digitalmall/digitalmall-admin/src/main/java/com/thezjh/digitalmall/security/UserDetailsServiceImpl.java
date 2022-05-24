package com.thezjh.digitalmall.security;

import com.thezjh.digitalmall.entity.SysUser;
import com.thezjh.digitalmall.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @author thezjh
 * @create 2022/5/15 下午2:19
 */
@Service
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private SysUserService sysUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //查询用户信息
        SysUser user = sysUserService.getUserByName(username);
        //如果没有查询到用户就抛出异常
        if (Objects.isNull(user)) {
            throw new UsernameNotFoundException("该用户不存在");
        }
        //查询用户权限信息
        //把数据封装成 UserDetails 对象
        return new LoginUser(user);
    }
}
