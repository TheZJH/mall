package com.thezjh.digitalmallportal.controller;

import com.thezjh.digitalmallportal.dao.ProductMapper;
import com.thezjh.digitalmallportal.entity.Products;
import com.thezjh.digitalmallportal.entity.SysUser;
import com.thezjh.digitalmallportal.service.CartService;
import com.thezjh.digitalmallportal.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author thezjh
 * @create 2022/5/22 下午6:07
 */
@Controller
@Slf4j
public class CartController {
    @Resource
    private ProductService productService;


    @Resource
    private CartService cartService;

    @Resource
    private ProductMapper productMapper;

    @GetMapping("/cart/create")
    public String addCart(@RequestParam("id") Integer productId, Model model, HttpSession session) {
        //将当前页面商品添加到购物车
        SysUser user = (SysUser) session.getAttribute("user");

        Integer userId = user.getId();
        log.info("当前用户：{}", userId);
        //查询用户购物车所有商品
        cartService.addShoppingCart(userId, productId);
        List<Long> allProductId = cartService.findAllShoppingCart(userId);
        log.info("所有商品id" + allProductId);
        List<Products> products = productMapper.findAllProductsById(allProductId);
        //测试
        log.info("商品:" + products);
        //保存到model，返回前端
        model.addAttribute("allProduct", products);
        return "cart";
    }
}
