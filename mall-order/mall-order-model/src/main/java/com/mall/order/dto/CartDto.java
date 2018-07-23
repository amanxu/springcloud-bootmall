package com.mall.order.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @description:
 * @author: niexx <br>
 * @date: 2018-06-24 16:04 <br>
 */
@Setter
@Getter
@ToString
public class CartDto implements Serializable {

    /*** 商品ID*/
    private String productId;
    /*** 商品数量*/
    private Integer productQuantity;

    public CartDto(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
