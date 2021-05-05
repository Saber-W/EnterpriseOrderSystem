package com.shibo.sell.repository;

import com.shibo.sell.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository repository;

    @Test
    public void saveTest() {
        OrderDetail orderDetail = new OrderDetail();

        orderDetail.setDetailId("1234567810");
        orderDetail.setOrderId("1232456");
        orderDetail.setProductId("1111132");
        orderDetail.setProductIcon("http://sssaaaaaaa.com");
        orderDetail.setProductName("皮蛋粥");
        orderDetail.setProductPrice(new BigDecimal(2.5));
        orderDetail.setProductQuantity(5);
        repository.save(orderDetail);
        // Assert.assertNotNull();
    }

    @Test
    public void findByOrderId() throws Exception {
        List<OrderDetail> orderDetailList = repository.findByOrderId("1232456");
        Assert.assertNotEquals(0, orderDetailList.size());
    }
}