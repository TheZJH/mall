package com.thezjh.digitalmall.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.thezjh.digitalmall.entity.Orders;
import org.apache.ibatis.annotations.Mapper;
import org.apache.tomcat.websocket.BackgroundProcess;
import org.aspectj.weaver.ast.Or;

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
}
