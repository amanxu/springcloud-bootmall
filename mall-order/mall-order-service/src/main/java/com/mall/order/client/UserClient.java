package com.mall.order.client;

import com.mall.common.pojo.Result;
import com.mall.order.hystrix.UserClientHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @description:
 * @author: xiaoxu.nie
 * @date: 2018-07-22 22:59
 */
@Component
@FeignClient(name = "mall-user", fallback = UserClientHystrix.class)
public interface UserClient {

    /**
     * 根据用户名查询
     *
     * @param userId
     * @return
     */
    @RequestMapping("/user/queryId")
    public Result findById(@RequestParam("userId") Long userId);

    /**
     * 根据用户名查询
     *
     * @param userName
     * @return
     */
    @RequestMapping("/user/queryName")
    public Result findByUserName(@RequestParam("userName") String userName);
}
