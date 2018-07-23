package com.product.service.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @description:
 * @author: niexx <br>
 * @date: 2018-06-24 10:58 <br>
 */
@Data
public class ProductVo {

    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("products")
    List<ProductInfoVo> productInfoVoList;
}
