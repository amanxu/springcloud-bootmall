package com.mall.order.exception;


import com.mall.order.enums.ResultEnum;

/**
 * @description:
 * @author: niexx <br>
 * @date: 2018-06-24 12:24 <br>
 */
public class OrderException extends RuntimeException {
    private Integer code;

    public OrderException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public OrderException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
