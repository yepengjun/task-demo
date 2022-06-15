package com.schedule.demo.enums;

/**
 * @author xiaolong
 * @description:
 * @date 2021/5/9-6:27 下午
 */
public enum RetryStatusEnum {

    PROCESS(0, "PROCESS"),
    RETRY(1, "RETRY");

    Integer status;
    String desc;
    RetryStatusEnum(Integer status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public Integer getStatus() {
        return status;
    }

    public String getDesc() {
        return desc;
    }
}
