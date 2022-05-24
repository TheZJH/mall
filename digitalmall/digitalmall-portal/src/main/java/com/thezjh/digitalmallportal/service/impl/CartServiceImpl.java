package com.thezjh.digitalmallportal.service.impl;

import com.thezjh.digitalmallportal.dao.CartMapper;
import com.thezjh.digitalmallportal.service.CartService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author thezjh
 * @create 2022/5/22 下午6:24
 */
@Service
public class CartServiceImpl implements CartService {
    @Resource
    private CartMapper cartMapper;

    @Override
    public Integer addShoppingCart(long userId, Integer productId) {
        return cartMapper.addShoppingCart(userId, productId);
    }

    @Override
    public List<Long> findAllShoppingCart(long userId) {
        //TODO 添加购物车商品是否被勾选
        return cartMapper.findAllShoppingCart(userId);
    }
}
