package com.shibo.sell.service.impl;

import com.shibo.sell.dataobject.ProductInfo;
import com.shibo.sell.enums.ProductStatusEnum;
import com.shibo.sell.repository.ProductInfoRepository;
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
class ProductServiceImplTest {

    @Autowired
    ProductServiceImpl productService;

    @Test
    void findOne() {
        Assert.assertEquals("123456", productService.findOne("123456").getProductId());
    }

    @Test
    void findUpAll() {
        Assert.assertNotEquals(0, productService.findUpAll().size());
    }

    @Test
    void findAlProl() {
        PageRequest pageRequest = PageRequest.of(0, 2);
        Page<ProductInfo> page = productService.findAll(pageRequest);
        Assert.assertNotNull(page);
    }

    @Test
    void save() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123457");
        productInfo.setProductName("皮皮虾");
        productInfo.setProductPrice(new BigDecimal(3.2));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("很好喝的虾");
        productInfo.setProductIcon("http://xxxxx.jpg");
        productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());
        productInfo.setCategoryType(1);

        Assert.assertNotNull(productService.save(productInfo));
    }
}