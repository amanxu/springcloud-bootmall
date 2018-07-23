package com.product.service.enums;

import lombok.Getter;

/**
 * @description: 商品上下架状态
 * @author: niexx <br>
 * @date: 2018-06-24 10:43 <br>
 */
@Getter
public enum ProductStatus {
    UP(0, "在架"),
    DOWN(1, "下架");
    private Integer code;
    private String message;

    ProductStatus(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
