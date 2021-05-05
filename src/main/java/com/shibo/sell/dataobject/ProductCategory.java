package com.shibo.sell.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * 类目表
 */
@Entity // 把数据库映射成对象
@DynamicUpdate // 自动更新（时间）
@Data // 在编译时自动生成get，set，toString
public class ProductCategory {

    @Id // 主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 自增
    private Integer categoryId;

    private String categoryName;

    private Integer categoryType;

    public ProductCategory() {
    }

    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }
}
