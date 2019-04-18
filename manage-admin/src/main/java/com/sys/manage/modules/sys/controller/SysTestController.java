package com.sys.manage.modules.sys.controller;

import com.sys.manage.common.utils.PageUtils;
import com.sys.manage.common.utils.R;
import com.sys.manage.common.validator.ValidatorUtils;
import com.sys.manage.modules.sys.entity.SysTestEntity;
import com.sys.manage.modules.sys.service.SysTestService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;



/**
 * 系统用户
 *
 * @author xue
 * @email xuepy@belink.com
 * @date 2019-04-18 16:14:26
 */
@RestController
@RequestMapping("sys/systest")
public class SysTestController {
    @Autowired
    private SysTestService sysTestService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:systest:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysTestService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{userId}")
    @RequiresPermissions("sys:systest:info")
    public R info(@PathVariable("userId") Long userId){
        SysTestEntity sysTest = sysTestService.getById(userId);

        return R.ok().put("sysTest", sysTest);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:systest:save")
    public R save(@RequestBody SysTestEntity sysTest){
        sysTestService.save(sysTest);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:systest:update")
    public R update(@RequestBody SysTestEntity sysTest){
        ValidatorUtils.validateEntity(sysTest);
        sysTestService.updateById(sysTest);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:systest:delete")
    public R delete(@RequestBody Long[] userIds){
        sysTestService.removeByIds(Arrays.asList(userIds));

        return R.ok();
    }

}
