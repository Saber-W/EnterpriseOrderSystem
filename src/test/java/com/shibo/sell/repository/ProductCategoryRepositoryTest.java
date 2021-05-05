package com.shibo.sell.repository;

import com.shibo.sell.dataobject.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class) // 单元测试
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void findOneTest() {
        ProductCategory productCategory = repository.findById(1).orElse(new ProductCategory());
        System.out.println(productCategory.toString());
    }

    @Test
    @Transactional // 做完事情后就回滚
    public void saveTest() {
        ProductCategory productCategory = repository.findById(1).orElse(new ProductCategory());
        productCategory.setCategoryType(1);
        /*ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryId(1);
        productCategory.setCategoryName("男生最爱");
        productCategory.setCategoryType(2);*/
        repository.save(productCategory);
    }

}