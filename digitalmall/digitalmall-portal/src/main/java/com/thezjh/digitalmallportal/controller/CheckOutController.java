package com.thezjh.digitalmallportal.controller;

import com.thezjh.digitalmallportal.dao.OrderMapper;
import com.thezjh.digitalmallportal.entity.Orders;
import com.thezjh.digitalmallportal.entity.Products;
import com.thezjh.digitalmallportal.entity.SysUser;
import com.thezjh.digitalmallportal.entity.UserAddress;
import com.thezjh.digitalmallportal.service.AddressService;
import com.thezjh.digitalmallportal.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * 提交订单
 *
 * @author thezjh
 * @create 2022/5/23 下午5:02
 */
@Controller
@Slf4j
public class CheckOutController {
    @Resource
    private AddressService addressService;

    @Resource
    private OrderMapper orderMapper;

    @Resource
    private ProductService productService;
    @Autowired
    private Orders orders;

    @GetMapping("/checkout")
    public String checkout(@RequestParam("id") Integer productId, HttpSession session, Model model) {
        //获取用户id
        SysUser user = (SysUser) session.getAttribute("user");
        Long userId = user.getId();
        UserAddress userAddress = addressService.getDefaultAddress(userId);
        //添加用户地址到model
        model.addAttribute("userAddress", userAddress);
        orders.setUserId(userId);
        orders.setShoppingId(productId);
        Products product = productService.getProduct(productId);

        Double price = product.getPrice();
        orders.setPayment(price);
        orderMapper.addOrder(orders);
        log.info("提交订单，商品id：{}", productId);
        log.info("提交订单，收货地址：{}", userAddress);
        model.addAttribute("orders", orders);
        return "checkout";
    }

}
