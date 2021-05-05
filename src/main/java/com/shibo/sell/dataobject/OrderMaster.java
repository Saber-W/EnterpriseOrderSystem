package com.shibo.sell.dataobject;

import com.shibo.sell.enums.OrderStatusEnum;
import com.shibo.sell.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@DynamicUpdate // 自动更新时间字段
public class OrderMaster {

    @Id
    private String orderId;

    private String buyerName;

    private String buyerPhone;

    private String buyerAddress;

    private String buyerOpenid;

    private BigDecimal orderAmount;

    /* 默认状态：0新订单 */
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    /* 默认状态：0等待支付 */
    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    private Date createTime;

    private Date updateTime;

}
