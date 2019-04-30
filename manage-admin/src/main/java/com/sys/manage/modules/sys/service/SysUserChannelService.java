package com.sys.manage.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sys.manage.modules.sys.entity.SysUserChannelEntity;

/**
 * 用户渠道表
 *
 * @author xue
 * @email xuepy@belink.com
 * @date 2019-04-28 17:10:42
 */
public interface SysUserChannelService extends IService<SysUserChannelEntity> {
    /**
     * 通过用户id查询用户渠道表信息
     * @param userId
     * @return
     */
    SysUserChannelEntity getByUserId(Long userId);

    /**
     * 修改用户密码
     * @param userId
     * @param newPassword
     * @return
     */
    int updatePassword(long userId, String newPassword);
}

