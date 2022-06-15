package com.schedule.demo.common;

import com.schedule.demo.enums.BizErrorEnum;

/**
 * @author yepengjun
 */
public class BizException extends RuntimeException {

    private Integer code;

    public BizException(Integer code, String note) {
        super(note);
        this.code = code;
    }

    public BizException(String note) {
        super(note);
        this.code = BizErrorEnum.SERVER_ERROR.getValue();
    }

    public BizException(BizErrorEnum bizErrorEnum) {
        super(bizErrorEnum.getNote());
        this.code = bizErrorEnum.getValue();
    }

    public BizException(BizErrorEnum bizErrorEnum, String note) {
        super(note);
        this.code = bizErrorEnum.getValue();
    }

    public Integer getCode() {
        return code;
    }
}
