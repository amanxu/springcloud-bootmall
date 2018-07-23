package com.mall.order.controller;

import com.mall.common.pojo.Result;
import com.mall.common.utils.ResultUtil;
import com.mall.order.client.UserClient;
import com.mall.order.converter.OrderForm2OrderDTOConverter;
import com.mall.order.dto.OrderDto;
import com.mall.order.enums.ResultEnum;
import com.mall.order.exception.OrderException;
import com.mall.order.form.OrderForm;
import com.mall.order.service.OrderService;
import com.mall.user.model.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: niexx <br>
 * @date: 2018-06-24 12:05 <br>
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserClient userClient;

    /**
     * 1. 参数检验
     * 2. 查询商品信息(调用商品服务)
     * 3. 计算总价
     * 4. 扣库存(调用商品服务)
     * 5. 订单入库
     */
    @PostMapping("/create")
    public Result<Map<String, String>> create(@Valid OrderForm orderForm,
                                              BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("【创建订单】参数不正确, orderForm={}", orderForm);
            throw new OrderException(ResultEnum.PARAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }
        // orderForm -> orderDTO
        OrderDto orderDTO = OrderForm2OrderDTOConverter.convert(orderForm);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
            log.error("【创建订单】购物车信息为空");
            throw new OrderException(ResultEnum.CART_EMPTY);
        }

        OrderDto result = orderService.create(orderDTO);

        Map<String, String> map = new HashMap<>();
        map.put("orderId", result.getOrderId());
        return ResultUtil.success(map);
    }

    @RequestMapping("/getUserInfo")
    public Result getUserByOrderServer(String userName) {
        Result result = userClient.findByUserName(userName);
        return ResultUtil.success(result.getData());
    }
}
