package com.sys.manage.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户扩展表
 * 
 * @author xue
 * @email xuepy@belink.com
 * @date 2019-04-28 17:10:42
 */
@Data
@TableName("sys_user_extend")
public class SysUserExtendEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 用户扩展表主键
	 */
	@TableId
	private Long id;
	/**
	 * 用户id
	 */
	private Long userId;
	/**
	 * 用户头像
	 */
	private String userPortrait;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;

}
