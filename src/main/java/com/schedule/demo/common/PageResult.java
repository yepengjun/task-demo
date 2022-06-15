package com.schedule.demo.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author xiaolong
 * @description:
 * @date 2022/6/14-11:12 下午
 */
@Data
@ApiModel(value="分页数据对象",description="分页数据对象数据对象PageResult")
public class PageResult<T> implements Serializable {

    /**
     * 总页数
     */
    @ApiModelProperty(value = "总页数",name="totalPages",example="10")
    private Integer totalPages;

    /**
     * 当前页数
     */
    @ApiModelProperty(value = "当前页数",name="pageIndex",example="10")
    private Integer pageIndex;

    /**
     * 每页的数据条数
     */
    @ApiModelProperty(value = "每页的数据条数",name="pageSize",example="10")
    private Integer pageSize;

    /**
     * 数据集合
     */
    @ApiModelProperty(value = "数据集合",name="data",example="")
    private List<T> data;
}
