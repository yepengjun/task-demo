package com.schedule.demo.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author xiaolong
 * @description:hello任务
 * @date 2022/6/14-11:12 下午
 */
public class HelloJob implements BaseJob {

    private static Logger _log = LoggerFactory.getLogger(HelloJob.class);

    public HelloJob() {

    }

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        /**_log.error("Hello Job执行时间: " + new Date());*/
        System.out.println("this is Hello Job");
    }

}
