package com.sys.manage.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * 部门管理
 *
 * @author xue
 */
@Data
@TableName("sys_dept")
public class SysDeptEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 部门ID
     */
    @TableId
    private Long deptId;
    /**
     * 上级部门ID，一级部门为0
     */
    private Long parentId;
    /**
     * 部门名称
     */
    private String name;
    /**
     * 上级部门名称
     */
    @TableField(exist = false)
    private String parentName;
    private Integer orderNum;
    @TableLogic
    private Integer delFlag;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;
    /**
     * 租户id
     */
    private Long tenantId;
    /**
     * 租户名称
     */
    @TableField(exist = false)
    private String tenantName;

    /**
     * ztree属性
     */
    @TableField(exist = false)
    private Boolean open;
    @TableField(exist = false)
    private List<?> list;
}
