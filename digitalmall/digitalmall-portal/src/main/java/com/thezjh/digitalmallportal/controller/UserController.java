package com.thezjh.digitalmallportal.controller;

import com.thezjh.digitalmallportal.dao.UserMapper;
import com.thezjh.digitalmallportal.entity.SysUser;
import com.thezjh.digitalmallportal.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Objects;

/**
 * @author thezjh
 * @create 2022/5/22 下午8:02
 */
@Controller
@Slf4j
public class UserController {
    @Resource
    private SysUserService userService;
    @Resource
    private UserMapper userMapper;

    @GetMapping("/login")
    public String test() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "registration";
    }

    @PostMapping("/dologin")
    public String dologin(HttpServletRequest request, HttpSession session, Model model) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        log.info("username:{},password:{}", username, password);
        SysUser user = userService.login(username, password);
        if (!Objects.isNull(user)) {
            //将用户信息存入session
            session.setAttribute("user", user);
            return "redirect:/index";
        } else {
            model.addAttribute("msg", "用户名或密码错误");
            return "login";
        }
    }
}
