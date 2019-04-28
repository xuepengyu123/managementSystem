package com.sys.manage.modules.sys.controller;

import com.sys.manage.common.utils.PageUtils;
import com.sys.manage.common.utils.R;
import com.sys.manage.common.validator.ValidatorUtils;
import com.sys.manage.modules.sys.entity.TestEntity;
import com.sys.manage.modules.sys.service.TestService;
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
 * @date 2019-04-26 17:20:44
 */
@RestController
@RequestMapping("sys/test")
public class TestController {
    @Autowired
    private TestService testService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:test:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = testService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:test:info")
    public R info(@PathVariable("id") Long id){
        TestEntity test = testService.getById(id);

        return R.ok().put("test", test);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:test:save")
    public R save(@RequestBody TestEntity test){
        testService.save(test);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:test:update")
    public R update(@RequestBody TestEntity test){
        ValidatorUtils.validateEntity(test);
        testService.updateById(test);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:test:delete")
    public R delete(@RequestBody Long[] ids){
        testService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
