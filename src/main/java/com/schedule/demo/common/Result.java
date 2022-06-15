package com.schedule.demo.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author xiaolong
 * @description:
 * @date 2022/6/14-11:12 下午
 */
@Data
@ApiModel(value="返回数据对象",description="返回数据对象Result")
public class Result<T> implements Serializable {
    /**
     * 错误码.
     */
    @ApiModelProperty(value = "错误码",name="code",example="200")
    private Integer code;

    /**
     * 提示信息.
     */
    @ApiModelProperty(value = "提示信息",name="msg",example="成功")
    private String msg;

    /**
     * 具体的内容.
     */
    @ApiModelProperty(value = "具体的内容",name="data",example="")
    private T data;
}
