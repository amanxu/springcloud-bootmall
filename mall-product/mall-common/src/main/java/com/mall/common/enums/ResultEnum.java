package com.mall.common.enums;

import lombok.Getter;

/**
 * @description:
 * @author: niexx <br>
 * @date: 2018-06-24 16:11 <br>
 */
@Getter
public enum ResultEnum {
    PRODUCT_NOT_EXIST(1, "商品不存在"),
    PRODUCT_STOCK_ERROR(2, "库存有误"),;
    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
