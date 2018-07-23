package com.mall.order.enums;

import lombok.Getter;

/**
 * @description:
 * @author: niexx <br>
 * @date: 2018-06-24 12:25 <br>
 */
@Getter
public enum ResultEnum {
    PARAM_ERROR(1, "参数错误"),
    CART_EMPTY(2, "购物车为空");

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
