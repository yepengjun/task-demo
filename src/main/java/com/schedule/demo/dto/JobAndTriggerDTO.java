package com.schedule.demo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author xiaolong
 * @description:
 * @date 2022/6/14-11:28 下午
 */
@Data
@EqualsAndHashCode(callSuper=false)
@ApiModel(value="保存任务信息对象",description="保存任务信息对象SaveJobAndTriggerDTO")
public class JobAndTriggerDTO {

    /**
     * 任务名称
     */
    @ApiModelProperty(value="任务名称",name="jobName",example="1")
    private String jobName;

    /**
     * 任务分组
     */
    @ApiModelProperty(value="任务分组",name="jobGroup",example="1")
    private String jobGroup;

    /**
     * 任务描述
     */
    @ApiModelProperty(value="任务描述",name="description",example="1")
    private String description;

    /**
     * 执行类
     */
    @ApiModelProperty(value="执行类",name="jobClassName",example="1")
    private String jobClassName;

    /**
     * 执行时间cron
     */
    @ApiModelProperty(value="执行时间cron",name="cronExpression",example="1")
    private String cronExpression;

    /**
     * 执行时间
     */
    @ApiModelProperty(value="执行时间",name="triggerName",example="1")
    private String triggerName;

    /**
     * 任务状态
     */
    @ApiModelProperty(value="任务状态",name="triggerState",example="1")
    private String triggerState;

    /**
     * 任务名称用于修改
     */
    @ApiModelProperty(value="任务名称用于修改",name="oldJobName",example="1")
    private String oldJobName;

    /**
     * 任务分组用于修改
     */
    @ApiModelProperty(value="任务分组用于修改",name="oldJobGroup",example="1")
    private String oldJobGroup;
}
