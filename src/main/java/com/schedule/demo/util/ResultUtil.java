package com.schedule.demo.util;


import com.schedule.demo.common.BizException;
import com.schedule.demo.common.Result;
import com.schedule.demo.enums.BizErrorEnum;

/**
 * @author xiaolong
 * @description:
 * @date 2020-05-03-04:48
 */
public class ResultUtil {

    public static <T> Result<T> success(T object) {
        Result<T> result = new Result<>();
        result.setCode(200);
        result.setMsg("success");
        result.setData(object);
        return result;
    }

    public static <T> Result<T> success() {
        return success(null);
    }

    public static <T> Result<T> error(Integer code, String msg) {
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    public static <T> Result<T> error(BizException e) {
        return error(e.getCode(), e.getMessage());
    }

    public static <T> Result<T> error(BizErrorEnum bizErrorEnum) {
        return error(bizErrorEnum.getValue(), bizErrorEnum.getNote());
    }
}
