package com.thezjh.digitalmall.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.thezjh.digitalmall.common.dto.UpdateUserDto;
import com.thezjh.digitalmall.common.lang.Result;
import com.thezjh.digitalmall.dao.UserMapper;
import com.thezjh.digitalmall.entity.Orders;
import com.thezjh.digitalmall.entity.SysUser;
import com.thezjh.digitalmall.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author thezjh
 * @create 2022/5/16 下午3:00
 */
@RestController
@Slf4j
public class UserController {
    @Resource
    private UserMapper userMapper;

    @Resource
    private SysUserService sysUserService;

    @GetMapping("/user/get")
    public Result getAllUser(@RequestParam(value = "page", defaultValue = "1") Integer page,
                             @RequestParam(value = "size", defaultValue = "10") Integer size) {
        PageHelper.startPage(page, size);
        //必须使用 mapper，pagehelper需要直接针对数据库进行查询
        List<SysUser> ordersList = userMapper.getAllUsers();
        PageInfo pageInfo = new PageInfo(ordersList);
        pageInfo.setPageNum(page);
        pageInfo.setPageSize(size);
        //使用pagehelper 实现分页，返回 pageInfo对象
        return Result.success(pageInfo);
    }

    @GetMapping("/user/delete")
    public Result deleteUserById(@RequestParam("id") Integer id) {
        log.info("要删除的用户id：" + id);
        sysUserService.deleteUserById(id);
        return Result.success(200, "删除成功", "");
    }

    @PostMapping("/user/update")
    public Result adminChangeUser(@RequestBody UpdateUserDto user) {
        log.info("要修改的用户id：" + user.getId());
        sysUserService.AdminChangeUser(user);
        return Result.success(200, "修改成功", "");
    }
}
