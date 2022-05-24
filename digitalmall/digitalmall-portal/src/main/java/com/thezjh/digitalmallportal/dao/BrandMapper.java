package com.thezjh.digitalmallportal.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.thezjh.digitalmallportal.entity.ProductBrand;
import com.thezjh.digitalmallportal.entity.ProductCategory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author thezjh
 * @create 2022/5/22 上午1:57
 */
@Mapper
public interface BrandMapper extends BaseMapper<ProductCategory> {
    /**
     * 查询所有品牌
     *
     * @return
     */
    List<ProductCategory> getProductCategories();

    Integer insertBrand(ProductCategory productCategory);

    List<ProductCategory> getSecondProductCategories(Integer parentId);

}
