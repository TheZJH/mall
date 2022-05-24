package com.thezjh.digitalmallportal.service.impl;

import com.thezjh.digitalmallportal.dao.ProductMapper;
import com.thezjh.digitalmallportal.entity.Products;
import com.thezjh.digitalmallportal.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author thezjh
 * @create 2022/5/14 下午8:43
 */
@Service
@Slf4j
public class ProductServiceImpl implements ProductService {
    @Resource
    private ProductMapper productMapper;

    @Override
    public List<Products> getAllProduct() {

        return productMapper.getAllProduct();
    }

    @Override
    public Integer deleteProduct(Integer id) {
        return productMapper.deleteProduct(id);
    }

    @Override
    public Integer addProduct(Products products) {
        return productMapper.addProduct(products);
    }

    @Override
    public Products getProduct(Integer id) {
        return productMapper.getProduct(id);
    }
}
