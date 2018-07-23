package com.product.service.controller;

import com.mall.common.pojo.Result;
import com.mall.common.utils.ResultUtil;
import com.product.model.dto.CartDto;
import com.product.model.pojo.ProductCategory;
import com.product.model.pojo.ProductInfo;
import com.product.service.biz.service.CategoryService;
import com.product.service.biz.service.ProductService;
import com.product.service.vo.ProductInfoVo;
import com.product.service.vo.ProductVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: niexx <br>
 * @date: 2018-06-24 9:57 <br>
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    /**
     * 1.查询所有在架商品
     * 2.获取类目type列表
     * 3.查询类目
     * 4.构造数据
     */
    @RequestMapping("/list")
    public Result list() {
        //1.查询所有在架商品
        List<ProductInfo> productInfoList = productService.findUpAll();
        //2.获取类目type列表
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(ProductInfo::getCategoryType)
                .collect(Collectors.toList());
        //3.查询类目
        List<ProductCategory> categoryList = categoryService.findByCategoryTypeIn(categoryTypeList);
        // 4.构造数据
        List<ProductVo> productVoList = new ArrayList<>();
        for (ProductCategory productCategory : categoryList) {
            ProductVo productVo = new ProductVo();
            productVo.setCategoryName(productCategory.getCategoryName());
            productVo.setCategoryType(productCategory.getCategoryType());
            List<ProductInfoVo> productInfoVoList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVo productInfoVo = new ProductInfoVo();
                    BeanUtils.copyProperties(productInfo, productInfoVo);
                    productInfoVoList.add(productInfoVo);
                }
            }
            productVo.setProductInfoVoList(productInfoVoList);
            productVoList.add(productVo);
        }

        return ResultUtil.success(productVoList);
    }

    @RequestMapping("/listForOrder")
    public List<ProductInfo> listForOrder() {

        List<ProductInfo> productInfoList = productService.findList(Arrays.asList("", ""));
        return productInfoList;
    }

    @PostMapping("/decreaseStock")
    public void decreaseStock(@RequestBody List<CartDto> cartDtoList) {
        productService.decreaseStock(cartDtoList);
    }
}
