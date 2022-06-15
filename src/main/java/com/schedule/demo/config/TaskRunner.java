package com.schedule.demo.config;

import com.schedule.demo.dto.JobAndTriggerDTO;
import com.schedule.demo.entity.JobAndTrigger;
import com.schedule.demo.service.JobAndTriggerService;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author xiaolong
 * @description:初始化一个测试Demo任务
 * @date 2022/6/14-11:12 下午
 */
@Component
public class TaskRunner implements ApplicationRunner{
    
	private final static Logger LOGGER = LoggerFactory.getLogger(TaskRunner.class);
	
	@Resource
    private JobAndTriggerService jobAndTriggerService;
	
	@Override
    public void run(ApplicationArguments var) throws Exception{
    	Long count = jobAndTriggerService.listQuartzEntityNum(null);
    	if(count == 0){
    		LOGGER.info("初始化测试任务");
    		JobAndTriggerDTO quartz = new JobAndTriggerDTO();
    		quartz.setJobName("test01");
    		quartz.setJobGroup("test");
    		quartz.setDescription("测试任务");
    		quartz.setJobClassName("com.schedule.demo.job.EatChickenJob");
    		quartz.setCronExpression("0/20 * * * * ?");
			jobAndTriggerService.saveQuartz(quartz);
    	}

    }

}