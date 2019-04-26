package com.sys.manage.modules.sys.controller;

import com.sys.manage.common.utils.PageUtils;
import com.sys.manage.common.utils.R;
import com.sys.manage.common.validator.ValidatorUtils;
import com.sys.manage.modules.sys.entity.SysTenantEntity;
import com.sys.manage.modules.sys.service.SysTenantService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


/**
 * 租户信息表
 *
 * @author xue
 * @email xuepy@belink.com
 * @date 2019-04-25 09:30:33
 */
@RestController
@RequestMapping("sys/tenant")
public class SysTenantController {
    @Autowired
    private SysTenantService sysTenantService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:tenant:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = sysTenantService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{tenantId}")
    @RequiresPermissions("sys:tenant:info")
    public R info(@PathVariable("tenantId") Long tenantId) {
        SysTenantEntity sysTenant = sysTenantService.getById(tenantId);

        return R.ok().put("tenant", sysTenant);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:tenant:save")
    public R save(@RequestBody SysTenantEntity sysTenant) {
        sysTenantService.save(sysTenant);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:tenant:update")
    public R update(@RequestBody SysTenantEntity sysTenant) {
        ValidatorUtils.validateEntity(sysTenant);
        sysTenantService.updateById(sysTenant);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:tenant:delete")
    public R delete(@RequestBody Long[] tenantIds) {
        sysTenantService.removeByIds(Arrays.asList(tenantIds));

        return R.ok();
    }

    /**
     * 租户列表
     */
    @RequestMapping("/select")
    @RequiresPermissions("sys:tenant:select")
    public R select() {
        List<SysTenantEntity> list = sysTenantService.list();

        return R.ok().put("list", list);
    }

}
