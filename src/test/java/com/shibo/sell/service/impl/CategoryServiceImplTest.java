package com.shibo.sell.service.impl;

import com.shibo.sell.dataobject.ProductCategory;
import com.shibo.sell.service.CategoryService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class CategoryServiceImplTest {

    @Autowired
    private CategoryServiceImpl categoryService;

    @Test
    void findOne() {
        ProductCategory productCategory = categoryService.findOne(111);
        Assert.assertEquals(new Integer(111), productCategory.getCategoryId());
    }

    @Test
    void findAll() {
        List<ProductCategory> productCategory = categoryService.findAll();
        Assert.assertNotEquals(0, productCategory.size());
    }

    @Test
    void findByCategoryTypeIn() {
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(Arrays.asList(1, 2, 3));
        Assert.assertNotEquals(0, productCategoryList);
    }

    @Test
    void save() {
        ProductCategory productCategory = categoryService.save(new ProductCategory("男生专享", 12));
        Assert.assertNotEquals(null, productCategory);
    }
}