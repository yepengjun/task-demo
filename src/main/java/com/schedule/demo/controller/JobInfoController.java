package com.schedule.demo.controller;

import com.schedule.demo.common.Result;
import com.schedule.demo.dto.JobAndTriggerDTO;
import com.schedule.demo.entity.JobAndTrigger;
import com.schedule.demo.enums.BizErrorEnum;
import com.schedule.demo.service.JobAndTriggerService;
import com.schedule.demo.service.impl.JobAndTriggerImpl;
import com.schedule.demo.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

/**
 * @author xiaolong
 * @description:
 * @date 2021/11/6-10:08 下午
 */
@RestController
@RequestMapping(value = "/api" , produces = MediaType.APPLICATION_JSON_VALUE)
@Api("api接口")
public class JobInfoController {

    private final static Logger logger = LoggerFactory.getLogger(JobInfoController.class);

    @Resource
    private JobAndTriggerService jobAndTriggerService;

    /**
     * 获取任务列表
     * @param jobName
     * @param pageNo
     * @param pageSize
     * @return
     */
    @ApiOperation(value="任务列表")
    @PostMapping("/list")
    public Result list(@RequestParam("jobName") String jobName,
                       @RequestParam("pageNo")Integer pageNo,
                       @RequestParam("pageSize")Integer pageSize){
        List<JobAndTrigger> list = jobAndTriggerService.listQuartzEntity(jobName,pageNo,pageSize);
        return ResultUtil.success(list);
    }

    /**
     * 新建任务
     * @param jobAndTriggerDTO
     * @return
     */
    @ApiOperation(value="新建任务")
    @PostMapping("/add")
    public Result save(JobAndTriggerDTO jobAndTriggerDTO) throws Exception {
        return jobAndTriggerService.saveQuartz(jobAndTriggerDTO);

    }

    /**
     * 触发任务
     * @param jobAndTriggerDTO
     * @return
     */
    @ApiOperation(value="触发任务")
    @PostMapping("/trigger")
    public  Result trigger(JobAndTriggerDTO jobAndTriggerDTO) {
        return jobAndTriggerService.triggerQuartz(jobAndTriggerDTO);

    }

    /**
     * 停止任务
     * @param jobAndTriggerDTO
     * @return
     */
    @ApiOperation(value="停止任务")
    @PostMapping("/pause")
    public  Result pause(JobAndTriggerDTO jobAndTriggerDTO) {
        return jobAndTriggerService.pauseQuartz(jobAndTriggerDTO);
    }

    /**
     * 恢复任务
     * @param jobAndTriggerDTO
     * @return
     */
    @ApiOperation(value="恢复任务")
    @PostMapping("/resume")
    public  Result resume(JobAndTriggerDTO jobAndTriggerDTO) {
        return jobAndTriggerService.resumeQuartz(jobAndTriggerDTO);

    }

    /**
     * 移除任务
     * @param jobAndTriggerDTO
     * @return
     */
    @ApiOperation(value="移除任务")
    @PostMapping("/remove")
    public Result remove(JobAndTriggerDTO jobAndTriggerDTO) {
        return jobAndTriggerService.removeQuartz(jobAndTriggerDTO);
    }
}
