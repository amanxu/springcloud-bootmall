package com.mall.order.hystrix;

import com.mall.common.pojo.Result;
import com.mall.common.utils.ResultUtil;
import com.mall.order.client.UserClient;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: xiaoxu.nie
 * @date: 2018-07-23 12:41
 */
@Component
public class UserClientHystrix implements UserClient {
    @Override
    public Result findById(Long userId) {
        return ResultUtil.error("User Server Connect Time Out!");
    }

    @Override
    public Result findByUserName(String userName) {
        return ResultUtil.error("User Server Connect Time Out!");
    }
}
