package com.sys.manage.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 租户信息表
 * 
 * @author xue
 * @email xuepy@belink.com
 * @date 2019-04-25 09:30:33
 */
@Data
@TableName("sys_tenant")
public class SysTenantEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 租户id
	 */
	@TableId
	private Long tenantId;
	/**
	 * 租户名称
	 */
	private String tenantName;
	/**
	 * 状态  0：禁用   1：正常
	 */
	private Integer status;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 修改时间
	 */
	private Date updateTime;

}
