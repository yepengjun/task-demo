package com.schedule.demo.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author xiaolong
 * @description:
 * @date 2022/6/14-11:12 下午
 */
public interface BaseJob extends Job {

    public void execute(JobExecutionContext context) throws JobExecutionException;

}
