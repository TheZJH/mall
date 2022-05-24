package com.thezjh.digitalmallportal.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.thezjh.digitalmallportal.entity.Orders;
import com.thezjh.digitalmallportal.entity.OrdersItem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author thezjh
 * @create 2022/5/15 上午2:21
 */
@Mapper
public interface OrderMapper extends BaseMapper<Orders> {
    /**
     * 获取所有订单
     *
     * @return
     */
    List<Orders> getAllOrders();

    /**
     * 添加订单
     * @param orders
     * @return
     */
    Integer addOrder(Orders orders);

    /**
     * 添加订单详情
     * @param ordersItem
     * @return
     */
    Integer addOrderItem(OrdersItem ordersItem);
}
