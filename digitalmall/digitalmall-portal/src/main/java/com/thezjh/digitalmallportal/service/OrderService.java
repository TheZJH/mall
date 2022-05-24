package com.thezjh.digitalmallportal.service;

import com.thezjh.digitalmallportal.entity.Orders;
import com.thezjh.digitalmallportal.entity.OrdersItem;

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
     *
     * @param id
     * @return
     */
    Integer deleteOrderById(Integer id);

    /**
     * 结算订单
     * @param ordersItem
     * @param orders
     * @return
     */
    Integer checkout(Orders orders);
}
