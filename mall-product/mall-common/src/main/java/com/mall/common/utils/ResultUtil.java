package com.mall.common.utils;


import com.mall.common.enums.ResultEnum;
import com.mall.common.pojo.Result;

/**
 * @author niexx
 */
public class ResultUtil {

    public static Result success(Object object) {
        Result result = new Result();
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMsg(ResultEnum.SUCCESS.getMsg());
        result.setData(object);
        return result;
    }

    public static Result success() {
        Result result = new Result();
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMsg(ResultEnum.SUCCESS.getMsg());
        return result;
    }

    public static Result error(Integer code, String msg) {
        Result result = new Result();
        result.setCode(ResultEnum.FAIL.getCode());
        result.setMsg(ResultEnum.FAIL.getMsg());
        return result;
    }

    public static Result error(String msg) {
        Result result = new Result();
        result.setCode(ResultEnum.FAIL.getCode());
        result.setMsg(msg);
        return result;
    }
}
