package com.shibo.sell.dto;

import lombok.Data;

/**
 * 购物车（前端返回的数据）
 */
@Data
public class CartDTO {

    private String productId;
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
