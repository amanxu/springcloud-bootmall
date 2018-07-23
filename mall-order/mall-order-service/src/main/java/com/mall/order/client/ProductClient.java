package com.mall.order.client;

import com.mall.order.dto.CartDto;
import com.product.model.pojo.ProductInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @description:
 * @author: niexx <br>
 * @date: 2018-06-24 13:29 <br>
 */
@Component
@FeignClient(name = "mall-product")
public interface ProductClient {

    /**
     * 查询订单商品列表
     *
     * @param productIdList
     * @return
     */
    @RequestMapping("/product/listForOrder")
    List<ProductInfo> listForOrder(@RequestBody List<String> productIdList);

    /**
     * 扣库存
     *
     * @param cartDtoList
     */
    @PostMapping("/product/decreaseStock")
    void decreaseStock(@RequestBody List<CartDto> cartDtoList);
}

