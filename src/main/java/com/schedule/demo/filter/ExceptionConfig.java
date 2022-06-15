package com.schedule.demo.filter;

import com.schedule.demo.common.Result;
import com.schedule.demo.enums.BizErrorEnum;

import com.schedule.demo.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author xiaolong
 * @description:
 * @date 2021/11/8-3:44 下午
 */
@RestControllerAdvice
public class ExceptionConfig {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionConfig.class);

    @ExceptionHandler
    public Result handler(HttpServletRequest req, HttpServletResponse res, Exception e) {
        if (res.getStatus() == HttpStatus.BAD_REQUEST.value()) {
            res.setStatus(HttpStatus.OK.value());
        }
        return ResultUtil.error(BizErrorEnum.SERVER_ERROR);

    }
}
