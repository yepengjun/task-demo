package com.schedule.demo.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author xiaolong
 * @description:
 * @date 2022/6/14-11:12 下午
 */
public class BobSimonPlayJob implements Job{

    /**
     * job执行的内容
     * @param jobExecutionContext
     * @throws JobExecutionException
     */
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        /**
         *  怎么执行这里面的任务呢哈
         */
        System.out.println("Bob Simon is an awesome man in the world!");
    }

}
