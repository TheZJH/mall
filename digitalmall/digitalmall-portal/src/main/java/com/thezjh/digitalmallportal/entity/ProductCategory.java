package com.thezjh.digitalmallportal.entity;


import lombok.Data;

/**
 * @author thezjh
 */
@Data
public class ProductCategory {

    private String categoryName;
    private long status;
    private java.sql.Timestamp createTime;
    private java.sql.Timestamp updateTime;
    private Integer id;
    private long parentId;
    private long level;

}
