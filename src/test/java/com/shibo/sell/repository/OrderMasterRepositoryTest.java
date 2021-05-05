package com.shibo.sell.repository;

import com.shibo.sell.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository repository;

    private final String OPENID = "110110";

    @Test
    public void saveTest() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("1234567");
        orderMaster.setBuyerName("guafu");
        orderMaster.setBuyerPhone("12345678911");
        orderMaster.setBuyerAddress("1204");
        orderMaster.setBuyerOpenid("110110");
        orderMaster.setOrderAmount(new BigDecimal(2.5));
        repository.save(orderMaster);

    }

    @Test
    public void findByBuyerOpenid() throws Exception {
        PageRequest pageRequest = PageRequest.of(0, 1);
        Page<OrderMaster> result = repository.findByBuyerOpenid(OPENID, pageRequest);

        Assert.assertNotEquals(0, result.getTotalElements());
    }
}