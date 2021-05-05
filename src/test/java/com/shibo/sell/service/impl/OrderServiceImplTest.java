package com.shibo.sell.service.impl;

import com.shibo.sell.dataobject.OrderDetail;
import com.shibo.sell.dto.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
class OrderServiceImplTest {

    @Autowired
    private OrderServiceImpl orderService;

    private final String BUYER_OPENID = "110110";

    private final String ORDER_ID = "1582862357798734195";

    @Test
    void create() throws Exception {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("shibo");
        orderDTO.setBuyerAddress("com.shibo");
        orderDTO.setBuyerPhone("12345678910");
        orderDTO.setBuyerOpenid(BUYER_OPENID);

        List<OrderDetail> orderDetailList = new ArrayList<>();
        OrderDetail o1 = new OrderDetail();
        OrderDetail o2 = new OrderDetail();

        o1.setProductId("123456");
        o1.setProductQuantity(1);
        o2.setProductId("123457");
        o2.setProductQuantity(2);
        orderDetailList.add(o1);
        orderDetailList.add(o2);
        orderDTO.setOrderDetailList(orderDetailList);
        OrderDTO result = orderService.create(orderDTO);
        log.info("【创建订单】result={}", result);
    }

    @Test
    void findOne() {
        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
        log.info("【查询单个订单】result={}", orderDTO);
    }

    @Test
    void findList() {
        PageRequest pageRequest = PageRequest.of(0, 2);
        Page<OrderDTO> orderDTOPage = orderService.findList(BUYER_OPENID, pageRequest);
        Assert.assertNotNull(orderDTOPage);
    }

    @Test
    void cancel() {
        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
        OrderDTO result = orderService.cancel(orderDTO);
    }

    @Test
    void finish() {
    }

    @Test
    void paid() {
    }
}