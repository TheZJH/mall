package com.thezjh.digitalmall.controller;

import cn.hutool.db.Page;
import com.thezjh.digitalmall.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.ServletRequestUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author thezjh
 */
public class BaseController {

	@Autowired
	HttpServletRequest req;

	@Autowired
	RedisUtil redisUtil;


	/**
	 * 获取页面
	 * @return
	 */
	public Page getPage() {
		int current = ServletRequestUtils.getIntParameter(req, "current", 1);
		int size = ServletRequestUtils.getIntParameter(req, "size", 10);

		return new Page(current, size);
	}

}
