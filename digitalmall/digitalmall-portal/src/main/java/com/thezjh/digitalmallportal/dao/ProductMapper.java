package com.thezjh.digitalmallportal.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.thezjh.digitalmallportal.entity.Products;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author thezjh
 * @create 2022/5/12 下午6:04
 */
@Mapper
public interface ProductMapper extends BaseMapper<Products> {
    /**
     * 获取所有产品
     *
     * @return
     */
    List<Products> getAllProduct();

    /**
     * 根据 id 删除产品
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
     * 根据 id 获取商品信息
     *
     * @param id
     * @return
     */
    Products getProduct(Integer id);

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    List<Products> findAllProductsById(List<Long> id);

}
