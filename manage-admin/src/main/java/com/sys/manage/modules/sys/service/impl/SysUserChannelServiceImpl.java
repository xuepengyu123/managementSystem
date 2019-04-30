package com.sys.manage.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sys.manage.modules.sys.dao.SysUserChannelDao;
import com.sys.manage.modules.sys.entity.SysUserChannelEntity;
import com.sys.manage.modules.sys.service.SysUserChannelService;
import org.springframework.stereotype.Service;


@Service("sysUserChannelService")
public class SysUserChannelServiceImpl extends ServiceImpl<SysUserChannelDao, SysUserChannelEntity> implements SysUserChannelService {

    @Override
    public SysUserChannelEntity getByUserId(Long userId) {
        return baseMapper.selectOne(new QueryWrapper<SysUserChannelEntity>().eq("user_id", userId));
    }

    @Override
    public int updatePassword(long userId, String newPassword) {
        SysUserChannelEntity sysUserChannelEntity = new SysUserChannelEntity();
        sysUserChannelEntity.setPassword(newPassword);
        return baseMapper.update(sysUserChannelEntity, new QueryWrapper<SysUserChannelEntity>().eq("user_id", userId));
    }

}
