package com.schedule.demo.service;

import com.schedule.demo.common.Result;
import com.schedule.demo.dto.JobAndTriggerDTO;
import com.schedule.demo.entity.JobAndTrigger;
import java.util.List;

/**
 * @author xiaolong
 * @description:
 * @date 2022/6/14-11:12 下午
 */
public interface JobAndTriggerService {


    /**
     * 添加任务
     * @param jobAndTriggerDTO
     * @return x
     */
    Result saveQuartz (JobAndTriggerDTO jobAndTriggerDTO);

    /**
     * 触发任务
     * @param jobAndTriggerDTO
     * @return
     */
    Result triggerQuartz (JobAndTriggerDTO jobAndTriggerDTO);

    /**
     * 停止任务
     * @param jobAndTriggerDTO
     * @return
     */
    Result pauseQuartz (JobAndTriggerDTO jobAndTriggerDTO);

    /**
     * 恢复任务
     * @param jobAndTriggerDTO
     * @return
     */
    Result resumeQuartz (JobAndTriggerDTO jobAndTriggerDTO);

    /**
     * 移除任务
     * @param jobAndTriggerDTO
     * @return
     */
    Result removeQuartz (JobAndTriggerDTO jobAndTriggerDTO);

    /**
     * 查询定时任务实体类
     * @param jobName
     * @param pageNo
     * @param pageSize
     * @return
     */
    List<JobAndTrigger> listQuartzEntity(String jobName,Integer pageNo,Integer pageSize);

    /**
     * 查总的任务数量
     * @param quartz
     * @return
     */
    Long listQuartzEntityNum(JobAndTrigger quartz);

}
