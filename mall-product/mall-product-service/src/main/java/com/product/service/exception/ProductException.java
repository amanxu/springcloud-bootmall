package com.product.service.exception;


import com.mall.common.enums.ResultEnum;

/**
 * @description:
 * @author: niexx <br>
 * @date: 2018-06-24 16:10 <br>
 */
public class ProductException extends RuntimeException {
    private Integer code;

    public ProductException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public ProductException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
