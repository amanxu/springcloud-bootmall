package com.mall.common.enums;

import lombok.Getter;

/**
 * @description:
 * @author: niexx <br>
 * @date: 2018-06-24 16:11 <br>
 */
@Getter
public enum ResultEnum {
    SUCCESS("00000", "成功"),
    FAIL("FFFFF", "失败"),
    PRODUCT_NOT_EXIST("10001", "商品不存在"),
    PRODUCT_STOCK_ERROR("100002", "库存有误"),;
    private String code;
    private String msg;

    ResultEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
