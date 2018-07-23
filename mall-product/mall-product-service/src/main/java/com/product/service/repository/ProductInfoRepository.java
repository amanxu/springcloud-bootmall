package com.product.service.repository;


import com.product.model.pojo.ProductInfo;
import com.product.model.pojo.ProductInfoExample;
import com.product.service.mapper.ProductInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: niexx <br>
 * @date: 2018-06-24 10:21 <br>
 */
@Service
public class ProductInfoRepository {

    @Autowired
    private ProductInfoMapper productInfoMapper;

    /**
     * 根据状态查询商品
     *
     * @param productStatus
     * @return
     */
    public List<ProductInfo> findByProductStatus(Integer productStatus) {
        ProductInfoExample example = new ProductInfoExample();
        example.createCriteria().andProductStatusEqualTo(productStatus);
        return productInfoMapper.selectByExample(example);
    }

    public List<ProductInfo> findByProductIdIn(List<String> productIdList) {
        ProductInfoExample example = new ProductInfoExample();
        example.createCriteria().andProductIconIn(productIdList);
        return productInfoMapper.selectByExample(example);
    }

}
