package com.shibo.sell.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.shibo.sell.dataobject.OrderDetail;
import com.shibo.sell.dto.OrderDTO;
import com.shibo.sell.enums.ResultEnum;
import com.shibo.sell.exception.SellException;
import com.shibo.sell.form.OrderForm;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class OrderForm2OrderDTOConverter {

    public static OrderDTO convert(OrderForm orderForm) {
        Gson gson = new Gson();
        OrderDTO orderDTO = new OrderDTO();
        List<OrderDetail> orderDetailList = new ArrayList<>();

        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setOrderId(orderForm.getOpenid());

        try {
            gson.fromJson(orderForm.getItems(), new TypeToken<List<OrderDetail>>() {
            }.getType());
        } catch (Exception e) {
            log.error("【对象转换】错误，string={}", orderForm.getItems());
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        orderDTO.setOrderDetailList(orderDetailList);
        return orderDTO;
    }
}
