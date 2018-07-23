package com.product.service.biz.service;

import com.product.model.dto.CartDto;
import com.product.model.pojo.ProductInfo;

import java.util.List;

/**
 * @description:
 * @author: niexx <br>
 * @date: 2018-06-24 10:40 <br>
 */
public interface ProductService{

    /**
     * 查询所有在架商品列表
     *
     * @return
     */
    List<ProductInfo> findUpAll();

    /**
     * 查询商品列表
     *
     * @param productIdList
     * @return
     */
    List<ProductInfo> findList(List<String> productIdList);

    /**
     * 扣库存
     *
     * @param cartDtoList
     */
    void decreaseStock(List<CartDto> cartDtoList);
}
