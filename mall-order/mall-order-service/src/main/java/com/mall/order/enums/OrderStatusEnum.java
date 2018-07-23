package com.mall.order.enums;

import lombok.Getter;

/**
 * @description:
 * @author: niexx <br>
 * @date: 2018-06-24 11:59 <br>
 */
@Getter
public enum OrderStatusEnum {
    NEW(0, "新订单"),
    FINISHED(1, "完结"),
    CANCEL(2, "取消"),;
    private Integer code;

    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
