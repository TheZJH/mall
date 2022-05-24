package com.thezjh.digitalmallportal.service;

import java.util.List;

/**
 * @author thezjh
 * @create 2022/5/22 下午6:23
 */
public interface CartService {
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
