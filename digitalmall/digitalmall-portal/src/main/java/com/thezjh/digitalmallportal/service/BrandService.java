package com.thezjh.digitalmallportal.service;

import com.thezjh.digitalmallportal.entity.ProductCategory;

import java.util.List;

/**
 * @author thezjh
 * @create 2022/5/22 上午2:00
 */
public interface BrandService {
    /**
     * 根据品牌id查询品牌
     * @return
     */
    List<ProductCategory> getProductCategories();

    Integer insertBrand(ProductCategory productCategory);

    List<ProductCategory> getSecondProductCategories(Integer parentId);
}
