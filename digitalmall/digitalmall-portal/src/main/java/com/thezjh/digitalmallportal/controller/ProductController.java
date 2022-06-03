package com.thezjh.digitalmallportal.controller;

import com.thezjh.digitalmallportal.entity.Products;
import com.thezjh.digitalmallportal.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author thezjh
 * @create 2022/5/22 下午3:21
 */
@Slf4j
@Controller
public class ProductController {
    @Resource
    private ProductService productService;

    @GetMapping("/product/get")
    public String productGet(@RequestParam("id") Integer id, Model model) {
        Products product = productService.getProduct(id);
        model.addAttribute("singleProduct", product);
        log.info("product get" + product);
        return "single-product";
    }

    @GetMapping("/single-product")
    public String productGet() {
        log.info("product get");
        return "single-product";
    }

    /**
     * 获取所有商品
     *
     * @param model
     * @return
     */
    @GetMapping("/shop")
    public String shopGet(Model model) {
        log.info("shop get");
        //获取所有商品
        List<Products> products = productService.getAllProduct();
        model.addAttribute("allProducts", products);
        return "shop-left-sidebar";
    }

    @GetMapping("/product/search")
    public String shopSearch(@RequestParam("name") String name, Model model) {
        log.info("用户搜索名:{}", name);
        List<Products> products = productService.searchProducts(name);
        model.addAttribute("allProducts", products);
        return "shop-left-sidebar";
    }

    @GetMapping("/shop-left-sidebar")
    public String searchSuccess() {
        return "shop-left-sidebar";
    }
}
