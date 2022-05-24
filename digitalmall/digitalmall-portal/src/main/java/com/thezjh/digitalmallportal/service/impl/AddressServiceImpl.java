package com.thezjh.digitalmallportal.service.impl;

import com.thezjh.digitalmallportal.dao.AddressMapper;
import com.thezjh.digitalmallportal.entity.UserAddress;
import com.thezjh.digitalmallportal.service.AddressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author thezjh
 * @create 2022/5/24 下午3:15
 */
@Service
public class AddressServiceImpl implements AddressService {
    @Resource
    private AddressMapper addressMapper;

    @Override
    public UserAddress getDefaultAddress(Long userId) {
        return addressMapper.getDefaultAddress(userId);
    }
}
