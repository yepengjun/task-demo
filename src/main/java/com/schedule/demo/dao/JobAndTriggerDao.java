package com.schedule.demo.dao;

import com.schedule.demo.entity.JobAndTrigger;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xiaolong
 * @description:
 * @date 2022/6/14-11:12 下午
 */
@Mapper
public interface JobAndTriggerDao {


    /**
     * 查询job详情列表
     * @return
     */
    List<JobAndTrigger> getJobAndTriggerDetails();


    /**
     * 计算job的个数
     * @param quartz
     * @return
     */
    long listQuartzEntityNum(JobAndTrigger quartz);

    /**
     * 查询出任务
     * @param jobName
     * @param pageNo
     * @param pageSize
     * @return
     */
    List<JobAndTrigger> listQuartzEntity(@Param("jobName")String jobName,
                                         @Param("pageNo")Integer pageNo,
                                         @Param("pageSize")Integer pageSize);
}
