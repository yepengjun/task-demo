package com.schedule.demo.dao;

import com.schedule.demo.entity.SysLog;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author xiaolong
 * @description:
 * @date 2022/6/14-11:12 下午
 */
@Mapper
public interface SysLogDao {

    /**
     * 删除系统日志
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入日志记录
     * @param record
     * @return
     */
    int insert(SysLog record);
}
