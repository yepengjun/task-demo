package com.schedule.demo.service.impl;

import com.alibaba.fastjson.JSON;
import com.schedule.demo.common.Result;
import com.schedule.demo.dao.JobAndTriggerDao;
import com.schedule.demo.dto.JobAndTriggerDTO;
import com.schedule.demo.entity.JobAndTrigger;
import com.schedule.demo.enums.BizErrorEnum;
import com.schedule.demo.service.JobAndTriggerService;
import com.schedule.demo.util.ResultUtil;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xiaolong
 * @description:
 * @date 2022/6/14-11:12 下午
 */

@Service("jobAndTriggerService")
public class JobAndTriggerImpl implements JobAndTriggerService {

    private final static Logger logger = LoggerFactory.getLogger(JobAndTriggerImpl.class);

    @Resource
    JobAndTriggerDao jobAndTriggerDao;
    @Resource
    private Scheduler scheduler;

    @Override
    public Result saveQuartz(JobAndTriggerDTO jobAndTriggerDTO) {
        try {
            if(StringUtils.hasText(jobAndTriggerDTO.getOldJobGroup())){
                JobKey key = new JobKey(jobAndTriggerDTO.getOldJobName(),jobAndTriggerDTO.getOldJobGroup());
                scheduler.deleteJob(key);
            }
            Class jobClass = Class.forName(jobAndTriggerDTO.getJobClassName()) ;
            jobClass.newInstance();
            /***构建job信息*/
            JobDetail job = JobBuilder.newJob(jobClass).withIdentity(jobAndTriggerDTO.getJobName(),
                    jobAndTriggerDTO.getJobGroup())
                    .withDescription(jobAndTriggerDTO.getDescription()).build();

            /***触发时间点*/
            CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(jobAndTriggerDTO.getCronExpression());
            Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger"+jobAndTriggerDTO.getJobName(),jobAndTriggerDTO.getJobGroup())
                    .startNow().withSchedule(cronScheduleBuilder).build();

            /***交由Scheduler安排触发*/
            scheduler.scheduleJob(job,trigger);
        }catch (Exception ex) {
            logger.error("saveQuartz is error:{},jobAndTriggerDTO:{}",ex, JSON.toJSONString(jobAndTriggerDTO));
            return ResultUtil.error(BizErrorEnum.SAVE_TASK_ERROR);
        }
        return ResultUtil.success();
    }

    @Override
    public Result triggerQuartz(JobAndTriggerDTO jobAndTriggerDTO) {
        try {
            JobKey key = new JobKey(jobAndTriggerDTO.getJobName(),jobAndTriggerDTO.getJobGroup());
            scheduler.triggerJob(key);
        } catch (SchedulerException ex) {
            logger.error("triggerQuartz is error:{},jobAndTriggerDTO:{}",ex, JSON.toJSONString(jobAndTriggerDTO));
            return ResultUtil.error(BizErrorEnum.TRIGGER_TASK_ERROR);
        }
        return ResultUtil.success();
    }

    @Override
    public Result pauseQuartz(JobAndTriggerDTO jobAndTriggerDTO) {
        try {
            JobKey key = new JobKey(jobAndTriggerDTO.getJobName(),jobAndTriggerDTO.getJobGroup());
            scheduler.pauseJob(key);
        } catch (SchedulerException ex) {
            logger.error("pauseQuartz is error:{},jobAndTriggerDTO:{}",ex, JSON.toJSONString(jobAndTriggerDTO));
            return ResultUtil.error(BizErrorEnum.PAUSE_TASK_ERROR);
        }
        return ResultUtil.success();
    }

    @Override
    public Result resumeQuartz(JobAndTriggerDTO jobAndTriggerDTO) {
        try {
            JobKey key = new JobKey(jobAndTriggerDTO.getJobName(),jobAndTriggerDTO.getJobGroup());
            scheduler.resumeJob(key);
        } catch (SchedulerException ex) {
            logger.error("resumeQuartz is error:{},jobAndTriggerDTO:{}",ex, JSON.toJSONString(jobAndTriggerDTO));
            return ResultUtil.error(BizErrorEnum.RESUME_TASK_ERROR);
        }
        return ResultUtil.success();
    }

    @Override
    public Result removeQuartz(JobAndTriggerDTO jobAndTriggerDTO) {
        try {
            TriggerKey triggerKey = TriggerKey.triggerKey(jobAndTriggerDTO.getJobName(), jobAndTriggerDTO.getJobGroup());
            /***停止触发器*/
            scheduler.pauseTrigger(triggerKey);
            /**移除触发器*/
            scheduler.unscheduleJob(triggerKey);
            /***删除任务*/
            scheduler.deleteJob(JobKey.jobKey(jobAndTriggerDTO.getJobName(), jobAndTriggerDTO.getJobGroup()));
        } catch (Exception ex) {
            logger.error("removeQuartz is error:{},jobAndTriggerDTO:{}",ex, JSON.toJSONString(jobAndTriggerDTO));
            return ResultUtil.error(BizErrorEnum.REMOVE_TASK_ERROR);
        }
        return ResultUtil.success();
    }

    /**
     * 查询有多少个任务
     * @param jobName
     * @param pageNo
     * @param pageSize
     * @return
     */
    @Override
    public List<JobAndTrigger> listQuartzEntity(String jobName, Integer pageNo, Integer pageSize) {
        return jobAndTriggerDao.listQuartzEntity(jobName,pageNo,pageSize);
    }

    /**
     * 查询任务个数
     * @param quartz
     * @return
     */
    @Override
    public Long listQuartzEntityNum(JobAndTrigger quartz) {
        return jobAndTriggerDao.listQuartzEntityNum(quartz);
    }


}
