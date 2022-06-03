package com.thezjh.digitalmallportal.service;

import com.thezjh.digitalmallportal.entity.Products;

import java.util.List;

/**
 * @author thezjh
 * @create 2022/5/14 下午8:41
 */
public interface ProductService {
    /**
     * 获取所有商品
     *
     * @return
     */
    List<Products> getAllProduct();

    /**
     * 根据 id 删除商品
     *
     * @param id
     * @return
     */
    Integer deleteProduct(Integer id);

    /**
     * 添加商品
     *
     * @param products
     * @return
     */
    Integer addProduct(Products products);

    /**
     * 根据 id 获取商品
     *
     * @return
     */
    Products getProduct(Integer id);

    /**
     * 查询商品
     * @param name
     * @return
     */
    List<Products> searchProducts(String name);
}
