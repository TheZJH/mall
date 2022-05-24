package com.thezjh.digitalmall.controller;

import cn.hutool.core.map.MapUtil;
import com.thezjh.digitalmall.common.lang.Result;
import com.thezjh.digitalmall.entity.SysUser;
import com.thezjh.digitalmall.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author thezjh
 * @create 2022/5/11 下午2:24
 */
@RestController
public class TestController {
    /*@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;*/
    @Resource
    private SysUserService sysUserService;

  /*  @GetMapping("/test/password")
    public Result passwordEncoder() {
        String password = bCryptPasswordEncoder.encode("111111");
        boolean matches = bCryptPasswordEncoder.matches("111111", password);
        return Result.success(MapUtil.builder().put("pass", password).put("matches", matches).build());
    }*/

    @GetMapping("/test/user")
    public Result user() {
        SysUser user = sysUserService.getUserByName("root");
        return Result.success(200, "访问成功", user);
    }
}
