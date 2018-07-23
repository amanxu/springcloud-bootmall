package com.mall.order.service.impl;

import com.mall.order.client.ProductClient;
import com.mall.order.dto.CartDto;
import com.mall.order.dto.OrderDto;
import com.mall.order.enums.OrderStatusEnum;
import com.mall.order.enums.PayStatusEnum;
import com.mall.order.mapper.OrderDetailMapper;
import com.mall.order.mapper.OrderMasterMapper;
import com.mall.order.model.OrderDetail;
import com.mall.order.model.OrderMaster;
import com.mall.order.service.OrderService;
import com.mall.order.utils.KeyUtil;
import com.product.model.pojo.ProductInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: niexx <br>
 * @date: 2018-06-24 12:09 <br>
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Autowired
    private OrderMasterMapper orderMasterMapper;

    @Autowired
    private ProductClient productClient;

    @Override
    public OrderDto create(OrderDto orderDTO) {
        String orderId = KeyUtil.genUniqueKey();

        //1.查询商品信息(调用商品服务)
        List<String> productIdList = orderDTO.getOrderDetailList().stream()
                .map(OrderDetail::getProductId)
                .collect(Collectors.toList());
        List<ProductInfo> productInfoList = productClient.listForOrder(productIdList);

        //2.计算总价
        BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);
        for (OrderDetail orderDetail : orderDTO.getOrderDetailList()) {
            for (ProductInfo productInfo : productInfoList) {
                if (productInfo.getProductId().equals(orderDetail.getProductId())) {
                    //单价*数量
                    orderAmount = productInfo.getProductPrice()
                            .multiply(new BigDecimal(orderDetail.getProductQuantity()))
                            .add(orderAmount);
                    BeanUtils.copyProperties(productInfo, orderDetail);
                    orderDetail.setOrderId(orderId);
                    orderDetail.setDetailId(KeyUtil.genUniqueKey());
                    //订单详情入库
                    orderDetailMapper.insert(orderDetail);
                }
            }
        }

        //3.扣库存(调用商品服务)
        List<CartDto> decreaseStockInputList = orderDTO.getOrderDetailList().stream()
                .map(e -> new CartDto(e.getProductId(), e.getProductQuantity()))
                .collect(Collectors.toList());
        productClient.decreaseStock(decreaseStockInputList);

        //订单入库
        OrderMaster orderMaster = new OrderMaster();
        orderDTO.setOrderId(orderId);
        BeanUtils.copyProperties(orderDTO, orderMaster);
        /*orderMaster.setOrderAmount(orderAmount);*/
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMasterMapper.insert(orderMaster);
        return orderDTO;
    }
}
