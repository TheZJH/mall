package com.thezjh.digitalmallportal.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.thezjh.digitalmallportal.entity.ShoppingCart;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author thezjh
 * @create 2022/5/22 下午6:21
 */
@Mapper
public interface CartMapper extends BaseMapper<ShoppingCart> {
    /**
     * 根据用户id和商品id插入购物车
     *
     * @param userId
     * @param productId
     * @return
     */
    Integer addShoppingCart(long userId, Integer productId);

    /**
     * 根据用户id查询购物车商品id
     *
     * @param userId
     * @return
     */
    List<Long> findAllShoppingCart(long userId);
}
