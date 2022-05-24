package com.thezjh.digitalmallportal.service.impl;

import com.thezjh.digitalmallportal.dao.OrderMapper;
import com.thezjh.digitalmallportal.entity.Orders;
import com.thezjh.digitalmallportal.entity.OrdersItem;
import com.thezjh.digitalmallportal.service.OrderService;
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

    @Override
    public Integer checkout(Orders orders) {
        orderMapper.addOrder(orders);
        return orderMapper.addOrder(orders);
    }
}
