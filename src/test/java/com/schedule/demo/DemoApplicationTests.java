package com.schedule.demo;

import com.alibaba.fastjson.JSON;
import com.schedule.demo.common.Result;
import com.schedule.demo.dto.JobAndTriggerDTO;
import com.schedule.demo.entity.JobAndTrigger;
import com.schedule.demo.service.JobAndTriggerService;
import com.schedule.demo.service.impl.JobAndTriggerImpl;
import com.schedule.demo.util.ResultUtil;
import io.swagger.annotations.ApiOperation;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {

    private final static Logger logger = LoggerFactory.getLogger(JobAndTriggerImpl.class);

    @Resource
    private JobAndTriggerService jobAndTriggerService;

    @Test
    public void saveQuartz (){
        JobAndTriggerDTO quartz = new JobAndTriggerDTO();
        quartz.setJobName("test02");
        quartz.setJobGroup("test02");
        quartz.setDescription("测试任务02");
        quartz.setJobClassName("com.schedule.demo.job.HelloJob");
        quartz.setCronExpression("0/20 * * * * ?");
        Result result = jobAndTriggerService.saveQuartz(quartz);
        logger.info("saveQuartz result:{},", JSON.toJSONString(result));
    }

    /**
     * 获取任务列表
     */
    @Test
    public void list(){
        String jobName = "";
        Integer pageNo = 1;
        Integer pageSize = 10;
        List<JobAndTrigger> list = jobAndTriggerService.listQuartzEntity(jobName,pageNo,pageSize);
        logger.info("list:{},", JSON.toJSONString(list));

    }

    /**
     * 触发任务
     */
    @Test
    public void trigger() {
        JobAndTriggerDTO jobAndTriggerDTO = new JobAndTriggerDTO();
        jobAndTriggerDTO.setJobName("test02");
        jobAndTriggerDTO.setJobGroup("test02");
        jobAndTriggerDTO.setDescription("测试任务02");
        jobAndTriggerDTO.setJobClassName("com.schedule.demo.job.HelloJob");
        jobAndTriggerDTO.setCronExpression("0/20 * * * * ?");
        Result result = jobAndTriggerService.triggerQuartz(jobAndTriggerDTO);
        logger.info("trigger result:{},", JSON.toJSONString(result));
    }

    /**
     * 停止任务
     */
    @Test
    public void pause() {
        JobAndTriggerDTO jobAndTriggerDTO = new JobAndTriggerDTO();
        jobAndTriggerDTO.setJobName("test02");
        jobAndTriggerDTO.setJobGroup("test02");
        jobAndTriggerDTO.setDescription("测试任务02");
        jobAndTriggerDTO.setJobClassName("com.schedule.demo.job.HelloJob");
        jobAndTriggerDTO.setCronExpression("0/20 * * * * ?");
        Result result = jobAndTriggerService.pauseQuartz(jobAndTriggerDTO);
        logger.info("pause result:{},", JSON.toJSONString(result));
    }

    /**
     * 恢复任务
     */
    @Test
    public void resume() {
        JobAndTriggerDTO jobAndTriggerDTO = new JobAndTriggerDTO();
        jobAndTriggerDTO.setJobName("test02");
        jobAndTriggerDTO.setJobGroup("test02");
        jobAndTriggerDTO.setDescription("测试任务02");
        jobAndTriggerDTO.setJobClassName("com.schedule.demo.job.HelloJob");
        jobAndTriggerDTO.setCronExpression("0/20 * * * * ?");
        Result result = jobAndTriggerService.resumeQuartz(jobAndTriggerDTO);
        logger.info("resume result:{},", JSON.toJSONString(result));

    }

    /**
     * 移除任务
     */
    @Test
    public void remove() {
        JobAndTriggerDTO jobAndTriggerDTO = new JobAndTriggerDTO();
        jobAndTriggerDTO.setJobName("test02");
        jobAndTriggerDTO.setJobGroup("test02");
        jobAndTriggerDTO.setDescription("测试任务02");
        jobAndTriggerDTO.setJobClassName("com.schedule.demo.job.HelloJob");
        jobAndTriggerDTO.setCronExpression("0/20 * * * * ?");
        Result result = jobAndTriggerService.removeQuartz(jobAndTriggerDTO);
        logger.info("remove result:{},", JSON.toJSONString(result));
    }


}
