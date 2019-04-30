package com.sys.manage.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sys.manage.common.utils.PageUtils;
import com.sys.manage.common.utils.Query;
import com.sys.manage.modules.sys.dao.SysTenantDao;
import com.sys.manage.modules.sys.entity.SysTenantEntity;
import com.sys.manage.modules.sys.entity.SysTenantExtendEntity;
import com.sys.manage.modules.sys.service.SysTenantExtendService;
import com.sys.manage.modules.sys.service.SysTenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;


@Service("sysTenantService")
public class SysTenantServiceImpl extends ServiceImpl<SysTenantDao, SysTenantEntity> implements SysTenantService {

    @Autowired
    private SysTenantExtendService sysTenantExtendService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SysTenantEntity> page = this.page(
                new Query<SysTenantEntity>().getPage(params),
                new QueryWrapper<SysTenantEntity>()
        );
        // 查询租户扩展信息
        for (SysTenantEntity sysTenantEntity : page.getRecords()) {
            SysTenantExtendEntity sysTenantExtendEntity = sysTenantExtendService.getByTenantId(sysTenantEntity.getTenantId());
            sysTenantEntity.setRemark(sysTenantExtendEntity.getRemark());
        }

        return new PageUtils(page);
    }

    @Override
    public SysTenantEntity info(Long tenantId) {
        SysTenantEntity sysTenantEntity = this.getById(tenantId);
        SysTenantExtendEntity sysTenantExtendEntity = sysTenantExtendService.getByTenantId(sysTenantEntity.getTenantId());
        sysTenantEntity.setRemark(sysTenantExtendEntity.getRemark());
        return sysTenantEntity;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveSysTenant(SysTenantEntity sysTenant) {
        // 保存租户信息
        sysTenant.setStatus(1);
        this.save(sysTenant);
        // 保存租户扩展信息
        SysTenantExtendEntity sysTenantExtendEntity = new SysTenantExtendEntity();
        sysTenantExtendEntity.setRemark(sysTenant.getRemark());
        sysTenantExtendEntity.setTenantId(sysTenant.getTenantId());
        sysTenantExtendService.save(sysTenantExtendEntity);

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateSysTenantEntityById(SysTenantEntity sysTenant) {
        // 更新租户信息
        this.updateById(sysTenant);
        // 更新租户扩展表信息
        SysTenantExtendEntity sysTenantExtendEntity = sysTenantExtendService.getByTenantId(sysTenant.getTenantId());
        sysTenantExtendEntity.setRemark(sysTenant.getRemark());
        sysTenantExtendService.updateById(sysTenantExtendEntity);
    }

}
