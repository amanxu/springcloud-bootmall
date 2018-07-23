package com.mall.order.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mall.order.dto.OrderDto;
import com.mall.order.enums.ResultEnum;
import com.mall.order.exception.OrderException;
import com.mall.order.form.OrderForm;
import com.mall.order.model.OrderDetail;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: niexx <br>
 * @date: 2018-06-24 12:28 <br>
 */
@Slf4j
public class OrderForm2OrderDTOConverter {
    public static OrderDto convert(OrderForm orderForm) {
        Gson gson = new Gson();
        OrderDto orderDto = new OrderDto();
        orderDto.setBuyerName(orderForm.getName());
        orderDto.setBuyerPhone(orderForm.getPhone());
        orderDto.setBuyerAddress(orderForm.getAddress());
        orderDto.setBuyerOpenid(orderForm.getOpenid());

        List<OrderDetail> orderDetailList = new ArrayList<>();
        try {
            orderDetailList = gson.fromJson(orderForm.getItems(),
                    new TypeToken<List<OrderDetail>>() {
                    }.getType());
        } catch (Exception e) {
            log.error("【json转换】错误, string={}", orderForm.getItems());
            throw new OrderException(ResultEnum.PARAM_ERROR);
        }
        orderDto.setOrderDetailList(orderDetailList);

        return orderDto;
    }
}
