package com.thezjh.digitalmallportal.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.thezjh.digitalmallportal.entity.UserAddress;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author thezjh
 * @create 2022/5/24 下午3:04
 */
@Mapper
public interface AddressMapper extends BaseMapper<UserAddress> {
    /**
     * 根据用户id查询用户地址
     *
     * @param userId
     * @return
     */
    UserAddress getDefaultAddress(Long userId);
}
