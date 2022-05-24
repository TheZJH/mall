package com.thezjh.digitalmall.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.thezjh.digitalmall.common.lang.Result;
import com.thezjh.digitalmall.dao.OrderMapper;
import com.thezjh.digitalmall.entity.Orders;
import com.thezjh.digitalmall.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author thezjh
 * @create 2022/5/15 上午2:13
 */
@RestController
@Slf4j
public class OrderController {
    @Resource
    private OrderService orderService;
    @Resource
    private OrderMapper orderMapper;

    @GetMapping("/order/get")
    public Result getAllOrder(@RequestParam(value = "page", defaultValue = "0") int page,
                              @RequestParam(value = "size", defaultValue = "10") int size) {
        log.info("page:" + page + "     " + "size:" + size);
        PageHelper.startPage(page, size);
        //必须使用 mapper，pagehelper需要直接针对数据库进行查询
        QueryWrapper queryWrapper = new QueryWrapper<>();
        List<Orders> ordersList = orderMapper.selectList(queryWrapper);
        PageInfo pageInfo = new PageInfo(ordersList);

        //使用pagehelper 实现分页，返回 pageInfo对象
        return Result.success(pageInfo);
    }

    @GetMapping("/order/delete")
    public Result deleteOrderById(@RequestParam("id") Integer id) {
        log.info("订单要删除的id是：" + id);
        orderService.deleteOrderById(id);
        return Result.success(200, "删除成功", "");
    }
}
