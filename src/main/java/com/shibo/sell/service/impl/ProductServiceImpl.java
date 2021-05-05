package com.shibo.sell.service.impl;

import com.shibo.sell.dataobject.ProductInfo;
import com.shibo.sell.dto.CartDTO;
import com.shibo.sell.enums.ProductStatusEnum;
import com.shibo.sell.enums.ResultEnum;
import com.shibo.sell.exception.SellException;
import com.shibo.sell.repository.ProductInfoRepository;
import com.shibo.sell.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository repository;

    @Override
    public ProductInfo findOne(String productId) {
        return repository.findById(productId).orElse(null);
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return repository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return repository.save(productInfo);
    }

    @Override
    @Transactional
    public void increaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO : cartDTOList) {
            ProductInfo productInfo = repository.findById(cartDTO.getProductId()).orElse(null);
            Integer result = productInfo.getProductStock() + cartDTO.getProductQuantity();
            productInfo.setProductStock(result);
            repository.save(productInfo);
        }
    }

    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO : cartDTOList) {
            ProductInfo productInfo = repository.findById(cartDTO.getProductId()).orElse(null);
            if (productInfo == null) throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            Integer result = productInfo.getProductStock() - cartDTO.getProductQuantity();
            if (result < 0) throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
            productInfo.setProductStock(result);
            repository.save(productInfo);
        }
    }
}
