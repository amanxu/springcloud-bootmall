package com.product.service.biz.service.impl;

import com.mall.common.enums.ResultEnum;
import com.product.model.dto.CartDto;
import com.product.model.pojo.ProductInfo;
import com.product.service.biz.service.ProductService;
import com.product.service.enums.ProductStatus;
import com.product.service.exception.ProductException;
import com.product.service.mapper.ProductInfoMapper;
import com.product.service.repository.ProductInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @description:
 * @author: niexx <br>
 * @date: 2018-06-24 10:42 <br>
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Autowired
    private ProductInfoMapper productInfoMapper;

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoRepository.findByProductStatus(ProductStatus.UP.getCode());
    }

    @Override
    public List<ProductInfo> findList(List<String> productIdList) {
        return productInfoRepository.findByProductIdIn(productIdList);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void decreaseStock(List<CartDto> cartDtoList) {
        for (CartDto cartDto : cartDtoList) {
            ProductInfo productInfo = productInfoMapper.selectByPrimaryKey(cartDto.getProductId());
            // 判断商品是否存在
            if (productInfo == null) {
                throw new ProductException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            // 判断库存是否充足
            Integer result = productInfo.getProductStock() - cartDto.getProductQuantity();
            if (result < 0) {
                throw new ProductException(ResultEnum.PRODUCT_STOCK_ERROR);
            }
            productInfo.setProductStock(result);
            productInfoMapper.insert(productInfo);
        }
    }
}
