package com.schedule.demo.enums;

/**
 * @author xiaolong
 * @description:
 * @date 2021/5/9-6:27 下午
 */
public enum SyncStatusEnum {

    PROCESS(0, "待处理"),
    FINISH(1, "已处理"),
    CORRECT(2, "待订正交易"),
    CORRECT_LOG(3, "待订正log");

    Integer status;
    String desc;
    SyncStatusEnum(Integer status, String desc) {
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
