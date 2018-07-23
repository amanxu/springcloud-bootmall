package com.mall.order.service;


import com.mall.order.dto.OrderDto;

/**
 * @description:
 * @author: niexx <br>
 * @date: 2018-06-24 12:05 <br>
 */
public interface OrderService {

    /**
     * 创建订单
     *
     * @param orderDto
     * @return
     */
    OrderDto create(OrderDto orderDto);
}
