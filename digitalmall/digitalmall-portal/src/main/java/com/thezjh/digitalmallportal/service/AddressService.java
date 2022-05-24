package com.thezjh.digitalmallportal.service;

import com.thezjh.digitalmallportal.entity.UserAddress;

/**
 * @author thezjh
 * @create 2022/5/24 下午3:14
 */
public interface AddressService {
    /**
     * 根据用户id查询用户地址
     *
     * @param userId
     * @return
     */
    UserAddress getDefaultAddress(Long userId);
}
