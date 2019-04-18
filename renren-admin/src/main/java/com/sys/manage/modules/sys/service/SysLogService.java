package com.sys.manage.modules.sys.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.sys.manage.common.utils.PageUtils;
import com.sys.manage.modules.sys.entity.SysLogEntity;

import java.util.Map;


/**
 * 系统日志
 *
 * @author xue
 */
public interface SysLogService extends IService<SysLogEntity> {

    PageUtils queryPage(Map<String, Object> params);

}
