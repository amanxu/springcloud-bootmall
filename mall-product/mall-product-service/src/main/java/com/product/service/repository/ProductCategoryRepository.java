package com.product.service.repository;


import com.product.model.pojo.ProductCategory;
import com.product.model.pojo.ProductCategoryExample;
import com.product.service.mapper.ProductCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: niexx <br>
 * @date: 2018-06-24 10:33 <br>
 */
@Service
public class ProductCategoryRepository {

    @Autowired
    private ProductCategoryMapper productCategoryMapper;


    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        ProductCategoryExample example = new ProductCategoryExample();
        example.createCriteria().andCategoryTypeIn(categoryTypeList);
        example.setOrderByClause(" id desc");
        example.setDistinct(true);
        return productCategoryMapper.selectByExample(example);
    }
}
