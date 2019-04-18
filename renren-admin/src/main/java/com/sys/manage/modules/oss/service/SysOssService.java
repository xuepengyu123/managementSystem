package com.sys.manage.modules.oss.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sys.manage.common.utils.PageUtils;
import com.sys.manage.modules.oss.entity.SysOssEntity;

import java.util.Map;

/**
 * 文件上传
 *
 * @author xue
 */
public interface SysOssService extends IService<SysOssEntity> {

    PageUtils queryPage(Map<String, Object> params);
}
