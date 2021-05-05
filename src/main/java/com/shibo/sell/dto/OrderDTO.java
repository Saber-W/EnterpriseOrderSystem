package com.shibo.sell.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.shibo.sell.dataobject.OrderDetail;
import com.shibo.sell.enums.OrderStatusEnum;
import com.shibo.sell.enums.PayStatusEnum;
import com.shibo.sell.utils.EnumUtil;
import com.shibo.sell.utils.serializer.Date2LongSerializer;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 用户下的订单，前端返回的数据
 */
@Data
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO {

    private String orderId;

    private String buyerName;

    private String buyerPhone;

    private String buyerAddress;

    private String buyerOpenid;

    private BigDecimal orderAmount;

    /* 默认状态：0新订单 */
    private Integer orderStatus;

    /* 默认状态：0等待支付 */
    private Integer payStatus;

    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;

    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;

    List<OrderDetail> orderDetailList;

    @JsonIgnore
    public OrderStatusEnum getOrderStatusEnum() {
        return EnumUtil.getByCode(orderStatus, OrderStatusEnum.class);
    }

    @JsonIgnore
    public PayStatusEnum getPayStatusEnum() {
        return EnumUtil.getByCode(payStatus, PayStatusEnum.class);
    }

}
