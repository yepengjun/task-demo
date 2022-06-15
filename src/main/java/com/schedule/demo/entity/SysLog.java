package com.schedule.demo.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @author xiaolong
 * @description:
 * @date 2022/6/14-11:12 下午
 */
@Data
public class SysLog {


    /**
     * id编号
     */
    private Integer id;

    /**
     * 用户名
     */
    private long userId;

    /**
     * ip地址
     */
    private String ip;

    /**
     * 操作类型,update还是select还是del等
     */
    private String type;

    /**
     * 描述内容，更新用户还是删除用户等
     */
    private String text;

    /**
     * 参数列表
     */
    private String param;

    /**
     * 创建时间
     */
    private Date createTime;
}
