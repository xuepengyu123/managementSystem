package com.sys.manage.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户渠道表
 * 
 * @author xue
 * @email xuepy@belink.com
 * @date 2019-04-28 17:10:42
 */
@Data
@TableName("sys_user_channel")
public class SysUserChannelEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 用户渠道表主键
	 */
	@TableId
	private Long id;
	/**
	 * 用户主键
	 */
	private Long userId;
	/**
	 * 渠道
	 */
	private String channel;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 盐
	 */
	private String salt;
	/**
	 * 状态
	 */
	private Integer status;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;

}
