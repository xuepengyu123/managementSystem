package com.sys.manage.modules.job.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sys.manage.common.utils.PageUtils;
import com.sys.manage.modules.job.entity.ScheduleJobLogEntity;

import java.util.Map;

/**
 * 定时任务日志
 *
 * @author xue
 */
public interface ScheduleJobLogService extends IService<ScheduleJobLogEntity> {

    PageUtils queryPage(Map<String, Object> params);

}
