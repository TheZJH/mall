package com.thezjh.digitalmall.controller;

import cn.hutool.core.date.DateUtil;
import com.thezjh.digitalmall.common.lang.Result;
import com.thezjh.digitalmall.entity.ProductBrand;
import com.thezjh.digitalmall.entity.ProductCategory;
import com.thezjh.digitalmall.service.BrandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @author thezjh
 * @create 2022/5/22 上午1:34
 */
@Slf4j
@RestController
public class BrandController {
    @Resource
    private BrandService brandService;

    @GetMapping("/brand/get")
    public Result getBrandList() {
        return Result.success(brandService.getProductCategories());
    }

    @PostMapping("/brand/update")
    public Result updateBrand(@RequestBody ProductBrand productBrand) {
        //当前时间
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        log.info("当前时间：{}", DateUtil.formatDateTime(timestamp));
        brandService.insertProductBrand(productBrand);

        return Result.success(200, "添加成功", "");
    }

    @GetMapping("/brand/second")
    public Result getSecondBrandList(@RequestParam("id") Integer parentId) {

        return Result.success(brandService.getSecondProductCategories(parentId));
    }
}
