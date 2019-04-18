package com.sys.manage.modules.job.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sys.manage.modules.job.entity.ScheduleJobLogEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 定时任务日志
 *
 * @author xue
 */
@Mapper
public interface ScheduleJobLogDao extends BaseMapper<ScheduleJobLogEntity> {

}
