package com.thezjh.digitalmall.service;

import com.thezjh.digitalmall.entity.Orders;

import java.util.List;

/**
 * @author thezjh
 * @create 2022/5/15 上午2:23
 */
public interface OrderService {
    /**
     * 获取所有订单
     *
     * @return
     */
    List<Orders> getAllOrders();

    /**
     * 根据id删除订单
     * @param id
     * @return
     */
    Integer deleteOrderById(Integer id);
}
