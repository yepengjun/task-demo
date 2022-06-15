package com.schedule.demo.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.io.Serializable;

/**
 * @author xiaolong
 * @description:吃鸡任务
 * @date 2022/6/14-11:12 下午
 */
public class EatChickenJob implements Job,Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * job执行的内容
	 * @param arg0
	 * @throws JobExecutionException
	 */
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		System.out.println("大吉大利、今晚吃鸡");
	}

}
