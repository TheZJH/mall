package com.thezjh.digitalmallportal.service.impl;

import com.thezjh.digitalmallportal.dao.BrandMapper;
import com.thezjh.digitalmallportal.entity.ProductCategory;
import com.thezjh.digitalmallportal.service.BrandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author thezjh
 * @create 2022/5/22 上午2:02
 */
@Service
@Slf4j
public class BrandServiceImpl implements BrandService {
    @Resource
    private BrandMapper brandMapper;

    @Override
    public List<ProductCategory> getProductCategories() {
        return brandMapper.getProductCategories();
    }

    @Override
    public Integer insertBrand(ProductCategory productCategory) {
        return brandMapper.insertBrand(productCategory);
    }

    @Override
    public List<ProductCategory> getSecondProductCategories(Integer parentId) {
        return brandMapper.getSecondProductCategories(parentId);
    }
}
