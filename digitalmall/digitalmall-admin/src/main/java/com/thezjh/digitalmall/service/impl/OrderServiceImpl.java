package com.thezjh.digitalmall.service.impl;

import com.thezjh.digitalmall.dao.OrderMapper;
import com.thezjh.digitalmall.entity.Orders;
import com.thezjh.digitalmall.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author thezjh
 * @create 2022/5/15 上午2:24
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderMapper orderMapper;

    @Override
    public List<Orders> getAllOrders() {

        return orderMapper.getAllOrders();
    }

    @Override
    public Integer deleteOrderById(Integer id) {

        return orderMapper.deleteById(id);
    }
}
