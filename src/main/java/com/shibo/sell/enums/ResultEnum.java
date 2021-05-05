package com.shibo.sell.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {

    SUCCESS(0, "成功"),
    PARAM_ERROR(1, "参数不正确"),
    PRODUCT_NOT_EXIST(10, "商品不存在"),
    PRODUCT_STOCK_ERROR(11, "库存不正确"),
    ORDER_NOT_EXIST(12, "订单不存在"),
    ORDERDETAIL_NOT_EXIST(13, "订单详情不存在"),
    ORDER_STATUS_ERROR(14, "订单状态不正确"),
    ORDER_UPDATE_FAIL(15, "更新失败"),
    PAY_STATUS_ERROR(16, "支付状态不正确"),
    CART_EMPTY(17, "购物车不能为空"),
    ORDER_OWNER_ERROR(18, "该订单不属于当前用户"),
    ;


    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
