package com.sys.manage.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;

import com.sys.manage.common.validator.ValidatorUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sys.manage.modules.sys.entity.SysTenantInfoEntity;
import com.sys.manage.modules.sys.service.SysTenantInfoService;
import com.sys.manage.common.utils.PageUtils;
import com.sys.manage.common.utils.R;



/**
 * 租户信息表
 *
 * @author xue
 * @email xuepy@belink.com
 * @date 2019-04-25 09:30:33
 */
@RestController
@RequestMapping("sys/systenantinfo")
public class SysTenantInfoController {
    @Autowired
    private SysTenantInfoService sysTenantInfoService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:systenantinfo:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysTenantInfoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{tenantId}")
    @RequiresPermissions("sys:systenantinfo:info")
    public R info(@PathVariable("tenantId") Long tenantId){
        SysTenantInfoEntity sysTenantInfo = sysTenantInfoService.getById(tenantId);

        return R.ok().put("sysTenantInfo", sysTenantInfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:systenantinfo:save")
    public R save(@RequestBody SysTenantInfoEntity sysTenantInfo){
        sysTenantInfoService.save(sysTenantInfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:systenantinfo:update")
    public R update(@RequestBody SysTenantInfoEntity sysTenantInfo){
        ValidatorUtils.validateEntity(sysTenantInfo);
        sysTenantInfoService.updateById(sysTenantInfo);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:systenantinfo:delete")
    public R delete(@RequestBody Long[] tenantIds){
        sysTenantInfoService.removeByIds(Arrays.asList(tenantIds));

        return R.ok();
    }

}
