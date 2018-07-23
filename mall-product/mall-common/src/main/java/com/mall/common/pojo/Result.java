package com.mall.common.pojo;

import lombok.Data;

/**
 * @description:
 * @author: niexx <br>
 * @date: 2018-06-24 10:56 <br>
 */
@Data
public class Result<T> {
    /**
     * 错误码
     */
    private String code;
    /**
     * 错误描述
     */
    private String msg;
    /**
     * 数据域
     */
    private T data;
}
