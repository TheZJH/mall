package com.thezjh.digitalmall.security;

import com.thezjh.digitalmall.utils.JwtUtils;
import com.thezjh.digitalmall.utils.RedisUtil;

import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * jwt 认证过滤器
 *
 * @author thezjh
 * @create 2022/5/15 下午4:03
 */
@Component
@Slf4j
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
    @Autowired
    private RedisUtil redisUtil;
    @Resource
    private JwtUtils jwtUtils;


    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        //获取请求头中的 token
        String token = httpServletRequest.getHeader("Authorization");
        logger.info("请求头中的token为："+token);
        //如果token值为空，登录时请求头token必须为空
        if (!StringUtils.hasLength(token)) {
            //放行，后面还有其他过滤器
            filterChain.doFilter(httpServletRequest, httpServletResponse);
            //返回
            return;
        }
        //解析token获取username
        String username;
        try {
            Claims claimByToken = jwtUtils.getClaimByToken(token);
            username = claimByToken.getSubject();
            logger.info("解析前端获取的token key为：" + username);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("token非法");
        }
        //从redis中获取用户信息
        String key = username;
        Object user = redisUtil.get(key);
        if (Objects.isNull(user)) {
            throw new RuntimeException("用户未登录");
        }

        //存入SecurityContextHolderHolder
        //TODO 获取权限信息封装
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(user, null, null);
        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        //放行
        logger.info("放行-----------------");
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
