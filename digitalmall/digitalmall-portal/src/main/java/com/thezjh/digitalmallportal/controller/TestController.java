package com.thezjh.digitalmallportal.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.thezjh.digitalmallportal.dao.BrandMapper;
import com.thezjh.digitalmallportal.dao.CategoryMapper;
import com.thezjh.digitalmallportal.dao.ProductMapper;
import com.thezjh.digitalmallportal.entity.ProductBrand;
import com.thezjh.digitalmallportal.entity.ProductCategory;
import com.thezjh.digitalmallportal.entity.Products;
import com.thezjh.digitalmallportal.service.BrandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author thezjh
 * @create 2022/5/18 下午9:09
 */
@Controller
@Slf4j
public class TestController {
    @Resource
    private BrandService brandService;

    @Resource
    private ProductMapper productMapper;

    @Resource
    private CategoryMapper categoryMapper;

    @GetMapping("/index")
    public String index(Model model) {
        //添加手机分类
        List<ProductCategory> brand1 = brandService.getSecondProductCategories(1);
        List<Products> product = productMapper.getAllProduct();

        log.info("brand1:{}", brand1);
        model.addAttribute("brand1", brand1);
        QueryWrapper<ProductBrand> wrapper = new QueryWrapper<>();
        wrapper.eq("category_id", 1);
        List<ProductBrand> phoneProductBrand = categoryMapper.selectList(wrapper);
        QueryWrapper<ProductBrand> wrapper1 = new QueryWrapper<>();
        wrapper1.eq("category_id", 2);
        List<ProductBrand> laptopProductBrand = categoryMapper.selectList(wrapper1);
        List<Long> phoneProductId = new ArrayList<>();
        List<Long> laptopProductId = new ArrayList<>();
        for (ProductBrand productBrand : phoneProductBrand) {
            phoneProductId.add(productBrand.getProductId());
        }
        for (ProductBrand productBrand : laptopProductBrand) {
            laptopProductId.add(productBrand.getProductId());
        }
        List<Products> phone = productMapper.findAllProductsById(phoneProductId);
        List<Products> laptop = productMapper.findAllProductsById(laptopProductId);
        model.addAttribute("TopProduct", product);
        //添加手机热门推荐
        model.addAttribute("topPhone", phone);
        model.addAttribute("topLaptop", laptop);
        return "index";
    }


}
