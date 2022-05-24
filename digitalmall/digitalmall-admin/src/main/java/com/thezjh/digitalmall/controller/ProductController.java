package com.thezjh.digitalmall.controller;

import com.thezjh.digitalmall.common.lang.Result;
import com.thezjh.digitalmall.dao.ProductMapper;
import com.thezjh.digitalmall.entity.Products;
import com.thezjh.digitalmall.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author thezjh
 * @create 2022/5/12 下午3:38
 */
@RestController
@Slf4j
public class ProductController {
    @Resource
    private ProductService productService;

    @Resource
    private ProductMapper productMapper;

    /**
     * SpringSecurity 权限注解，不设置无权限访问
     *
     * @return
     */
    @GetMapping("/product/get")
    @PreAuthorize("hasAuthority('read')")
    public Result getProductList() {
        List<Products> productsList = productService.getAllProduct();
        log.info("获取所有商品");
        return Result.success(productsList);
    }

    @GetMapping("/product/delete")
    public Result deleteProduct(@RequestParam("id") Integer id) {
        log.info(id.toString());
        productService.deleteProduct(id);

        return Result.success(200, "删除成功", "");
    }

    @PostMapping("/product/add")
    public Result addProduct(@RequestBody Products products) {
        //TODO 添加商品创建时间
        log.info("商品id：" + products.getId() + "");
        log.info("商品名：" + products.getProductName());
        productService.addProduct(products);
        return Result.success(200, "添加成功", "");
    }

    @GetMapping("/product/getProduct")
    public Result getProduct(@RequestParam("id") Integer id) {
        Products products = productService.getProduct(id);

        if (products != null) {
            return Result.success(200, "已找到商品", products);
        }
        return Result.fail("修改失败，数据库无该商品");
    }

    @PostMapping("/product/update")
    public Result updateProduct(@RequestBody Products products) {
        productMapper.updateById(products);
        return Result.success(200, "修改成功", "");
    }
}
