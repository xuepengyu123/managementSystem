package com.sys.manage.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 租户扩展表

 * 
 * @author xue
 * @email xuepy@belink.com
 * @date 2019-04-28 13:56:40
 */
@Data
@TableName("sys_tenant_extend")
public class SysTenantExtendEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 租户扩展表主键
	 */
	@TableId
	private Long id;
	/**
	 * 租户id
	 */
	private Long tenantId;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;

}
