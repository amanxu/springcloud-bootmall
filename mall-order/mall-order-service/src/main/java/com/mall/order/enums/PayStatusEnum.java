package com.mall.order.enums;

import lombok.Getter;

/**
 * @description:
 * @author: niexx <br>
 * @date: 2018-06-24 11:59 <br>
 */
@Getter
public enum PayStatusEnum {
    WAIT(0, "等待支付"),
    SUCCESS(1, "支付成功"),
    ;
    private Integer code;

    private String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
