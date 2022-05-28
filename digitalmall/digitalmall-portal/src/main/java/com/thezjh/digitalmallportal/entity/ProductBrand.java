package com.thezjh.digitalmallportal.entity;


import lombok.*;

/**
 * @author thezjh
 */
@Data
public class ProductBrand {

    private Integer id;
    private String name;
    private long productCount;
    private String logo;
    private long productId;
    private long categoryId;


}
