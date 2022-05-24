package com.thezjh.digitalmall.service;

import com.thezjh.digitalmall.entity.ProductBrand;
import com.thezjh.digitalmall.entity.ProductCategory;

import java.util.List;

/**
 * @author thezjh
 * @create 2022/5/22 上午2:00
 */
public interface BrandService {
    /**
     * 根据品牌id查询品牌
     *
     * @return
     */
    List<ProductCategory> getProductCategories();

    Integer insertBrand(ProductCategory productCategory);

    List<ProductCategory> getSecondProductCategories(Integer parentId);

    /**
     * 插入商品品牌
     * @param productBrand
     * @return
     */
    Integer insertProductBrand(ProductBrand productBrand);
}
