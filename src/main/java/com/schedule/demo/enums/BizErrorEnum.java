package com.schedule.demo.enums;

/**
 * @author yepengjun
 */

public enum BizErrorEnum {

    SERVER_ERROR(500, "服务错误"),
    PARAM_ERROR(400, "参数错误"),
    DB_ERROR(600, "数据库错误"),
    DATA_DOES_NOT_EXIST(404, "数据不存在"),


    TRIGGER_TASK_ERROR(1000, "触发任务失败"),
    SAVE_TASK_ERROR(1001, "添加任务失败"),
    PAUSE_TASK_ERROR(1002, "停止任务失败"),
    RESUME_TASK_ERROR(1000, "恢复任务失败"),
    REMOVE_TASK_ERROR(1000, "移除任务失败"),

    ;
    private Integer value;
    private String note;

    BizErrorEnum(Integer value, String note) {
        this.value = value;
        this.note = note;
    }

    public Integer getValue() {
        return value;
    }

    public String getNote() {
        return note;
    }
}
