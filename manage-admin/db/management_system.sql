/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : management_system

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2019-04-25 15:34:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_config
-- ----------------------------
DROP TABLE IF EXISTS `sys_config`;
CREATE TABLE `sys_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `param_key` varchar(50) DEFAULT NULL COMMENT 'key',
  `param_value` varchar(2000) DEFAULT NULL COMMENT 'value',
  `status` tinyint(4) DEFAULT '1' COMMENT '状态   0：隐藏   1：显示',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `param_key` (`param_key`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='系统配置信息表';

-- ----------------------------
-- Records of sys_config
-- ----------------------------
INSERT INTO `sys_config` VALUES ('1', 'CLOUD_STORAGE_CONFIG_KEY', '{\"aliyunAccessKeyId\":\"\",\"aliyunAccessKeySecret\":\"\",\"aliyunBucketName\":\"\",\"aliyunDomain\":\"\",\"aliyunEndPoint\":\"\",\"aliyunPrefix\":\"\",\"qcloudBucketName\":\"\",\"qcloudDomain\":\"\",\"qcloudPrefix\":\"\",\"qcloudSecretId\":\"\",\"qcloudSecretKey\":\"\",\"qiniuAccessKey\":\"NrgMfABZxWLo5B-YYSjoE8-AZ1EISdi1Z3ubLOeZ\",\"qiniuBucketName\":\"ios-app\",\"qiniuDomain\":\"http://7xqbwh.dl1.z0.glb.clouddn.com\",\"qiniuPrefix\":\"upload\",\"qiniuSecretKey\":\"uIwJHevMRWU0VLxFvgy0tAcOdGqasdtVlJkdy6vV\",\"type\":1}', '0', '云存储配置信息', '2019-04-24 17:54:13', '2019-04-24 17:54:33');

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept` (
  `dept_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '机构id',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '上级部门ID，一级部门为0',
  `name` varchar(50) DEFAULT NULL COMMENT '部门名称',
  `order_num` int(11) DEFAULT NULL COMMENT '排序',
  `del_flag` tinyint(4) DEFAULT '0' COMMENT '是否删除  -1：已删除  0：正常',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='部门管理';

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
INSERT INTO `sys_dept` VALUES ('1', '0', '总公司', '0', '0', null, '2019-04-24 17:36:53', '2019-04-24 17:36:53');
INSERT INTO `sys_dept` VALUES ('2', '1', '长沙分公司', '1', '0', null, '2019-04-24 17:36:53', '2019-04-24 17:36:53');
INSERT INTO `sys_dept` VALUES ('3', '1', '上海分公司', '2', '0', null, '2019-04-24 17:36:53', '2019-04-24 17:36:53');
INSERT INTO `sys_dept` VALUES ('4', '3', '技术部', '0', '0', null, '2019-04-24 17:36:53', '2019-04-24 17:36:53');
INSERT INTO `sys_dept` VALUES ('5', '3', '销售部', '1', '0', null, '2019-04-24 17:36:53', '2019-04-24 17:36:53');

-- ----------------------------
-- Table structure for sys_dict
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL COMMENT '字典名称',
  `type` varchar(100) NOT NULL COMMENT '字典类型',
  `code` varchar(100) NOT NULL COMMENT '字典码',
  `value` varchar(1000) NOT NULL COMMENT '字典值',
  `order_num` int(11) DEFAULT '0' COMMENT '排序',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `del_flag` tinyint(4) DEFAULT '0' COMMENT '删除标记  -1：已删除  0：正常',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `type` (`type`,`code`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='数据字典表';

-- ----------------------------
-- Records of sys_dict
-- ----------------------------
INSERT INTO `sys_dict` VALUES ('1', '性别', 'sex', '0', '女', '0', null, '0', '2019-04-24 17:52:54', '2019-04-24 17:53:16');
INSERT INTO `sys_dict` VALUES ('2', '性别', 'sex', '1', '男', '1', null, '0', '2019-04-24 17:52:54', '2019-04-24 17:53:16');
INSERT INTO `sys_dict` VALUES ('3', '性别', 'sex', '2', '未知', '3', null, '0', '2019-04-24 17:52:54', '2019-04-24 17:53:16');

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL COMMENT '用户名',
  `operation` varchar(50) DEFAULT NULL COMMENT '用户操作',
  `method` varchar(200) DEFAULT NULL COMMENT '请求方法',
  `params` varchar(5000) DEFAULT NULL COMMENT '请求参数',
  `time` bigint(20) NOT NULL COMMENT '执行时长(毫秒)',
  `ip` varchar(64) DEFAULT NULL COMMENT 'IP地址',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='系统日志';

-- ----------------------------
-- Records of sys_log
-- ----------------------------
INSERT INTO `sys_log` VALUES ('1', 'admin', '保存用户', 'com.sys.manage.modules.sys.controller.SysUserController.save()', '{\"userId\":2,\"username\":\"xuepengyu\",\"password\":\"fd1680c3c00e180cf7106ebe154624805c0e7741c497db7524d4967a4eba3ae3\",\"salt\":\"sX4hzYGHqxhmRlXJWGnR\",\"email\":\"123@qq.com\",\"mobile\":\"15232323322\",\"status\":1,\"roleIdList\":[],\"createTime\":\"Apr 23, 2019 3:12:10 PM\",\"deptId\":1,\"deptName\":\"总公司\"}', '326', '0:0:0:0:0:0:0:1', '2019-04-23 15:12:10', '2019-04-24 17:51:44');
INSERT INTO `sys_log` VALUES ('2', 'admin', '保存角色', 'com.sys.manage.modules.sys.controller.SysRoleController.save()', '{\"roleId\":1,\"roleName\":\"第一个角色\",\"deptId\":1,\"deptName\":\"总公司\",\"menuIdList\":[1,2,15,16,17,18,3,19,20,21,22,4,23,24,25,26,5,27,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45],\"deptIdList\":[1,2,3,4,5],\"createTime\":\"Apr 25, 2019 10:19:13 AM\"}', '361', '0:0:0:0:0:0:0:1', '2019-04-25 10:19:13', '2019-04-25 10:19:13');
INSERT INTO `sys_log` VALUES ('3', 'admin', '修改菜单', 'com.sys.manage.modules.sys.controller.SysMenuController.update()', '{\"menuId\":41,\"parentId\":1,\"parentName\":\"系统管理\",\"name\":\"租户管理\",\"url\":\"modules/sys/systenantinfo.html\",\"type\":1,\"icon\":\"fa fa-file-code-o\",\"orderNum\":6,\"createTime\":\"Apr 25, 2019 9:57:03 AM\",\"updateTime\":\"Apr 25, 2019 9:57:03 AM\"}', '61', '0:0:0:0:0:0:0:1', '2019-04-25 13:58:21', '2019-04-25 13:58:21');
INSERT INTO `sys_log` VALUES ('4', 'admin', '修改菜单', 'com.sys.manage.modules.sys.controller.SysMenuController.update()', '{\"menuId\":1,\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"系统管理\",\"type\":0,\"icon\":\"fa fa-cog\",\"orderNum\":2,\"createTime\":\"Apr 24, 2019 5:49:23 PM\",\"updateTime\":\"Apr 24, 2019 5:49:46 PM\"}', '50', '0:0:0:0:0:0:0:1', '2019-04-25 13:59:01', '2019-04-25 13:59:01');
INSERT INTO `sys_log` VALUES ('5', 'admin', '修改菜单', 'com.sys.manage.modules.sys.controller.SysMenuController.update()', '{\"menuId\":41,\"parentId\":1,\"parentName\":\"系统管理\",\"name\":\"租户管理\",\"url\":\"modules/sys/systenantinfo.html\",\"type\":1,\"icon\":\"fa fa-file-code-o\",\"orderNum\":2,\"createTime\":\"Apr 25, 2019 9:57:03 AM\",\"updateTime\":\"Apr 25, 2019 9:57:03 AM\"}', '39', '0:0:0:0:0:0:0:1', '2019-04-25 13:59:20', '2019-04-25 13:59:20');
INSERT INTO `sys_log` VALUES ('6', 'admin', '修改菜单', 'com.sys.manage.modules.sys.controller.SysMenuController.update()', '{\"menuId\":41,\"parentId\":1,\"parentName\":\"系统管理\",\"name\":\"租户管理\",\"url\":\"modules/sys/tenant.html\",\"type\":1,\"icon\":\"fa fa-file-code-o\",\"orderNum\":2,\"createTime\":\"Apr 25, 2019 9:57:03 AM\",\"updateTime\":\"Apr 25, 2019 9:57:03 AM\"}', '93', '0:0:0:0:0:0:0:1', '2019-04-25 15:01:13', '2019-04-25 15:01:13');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父菜单ID，一级菜单为0',
  `name` varchar(50) DEFAULT NULL COMMENT '菜单名称',
  `url` varchar(200) DEFAULT NULL COMMENT '菜单URL',
  `perms` varchar(500) DEFAULT NULL COMMENT '授权(多个用逗号分隔，如：user:list,user:create)',
  `type` int(11) DEFAULT NULL COMMENT '类型   0：目录   1：菜单   2：按钮',
  `icon` varchar(50) DEFAULT NULL COMMENT '菜单图标',
  `order_num` int(11) DEFAULT NULL COMMENT '排序',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8 COMMENT='菜单管理';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '0', '系统管理', null, null, '0', 'fa fa-cog', '2', '2019-04-24 17:49:23', '2019-04-24 17:49:46');
INSERT INTO `sys_menu` VALUES ('2', '1', '管理员管理', 'modules/sys/user.html', null, '1', 'fa fa-user', '1', '2019-04-24 17:49:23', '2019-04-24 17:49:46');
INSERT INTO `sys_menu` VALUES ('3', '1', '角色管理', 'modules/sys/role.html', null, '1', 'fa fa-user-secret', '2', '2019-04-24 17:49:23', '2019-04-24 17:49:46');
INSERT INTO `sys_menu` VALUES ('4', '1', '菜单管理', 'modules/sys/menu.html', null, '1', 'fa fa-th-list', '3', '2019-04-24 17:49:23', '2019-04-24 17:49:46');
INSERT INTO `sys_menu` VALUES ('5', '1', 'SQL监控', 'druid/sql.html', null, '1', 'fa fa-bug', '4', '2019-04-24 17:49:23', '2019-04-24 17:49:46');
INSERT INTO `sys_menu` VALUES ('15', '2', '查看', null, 'sys:user:list,sys:user:info', '2', null, '0', '2019-04-24 17:49:23', '2019-04-24 17:49:46');
INSERT INTO `sys_menu` VALUES ('16', '2', '新增', null, 'sys:user:save,sys:role:select', '2', null, '0', '2019-04-24 17:49:23', '2019-04-24 17:49:46');
INSERT INTO `sys_menu` VALUES ('17', '2', '修改', null, 'sys:user:update,sys:role:select', '2', null, '0', '2019-04-24 17:49:23', '2019-04-24 17:49:46');
INSERT INTO `sys_menu` VALUES ('18', '2', '删除', null, 'sys:user:delete', '2', null, '0', '2019-04-24 17:49:23', '2019-04-24 17:49:46');
INSERT INTO `sys_menu` VALUES ('19', '3', '查看', null, 'sys:role:list,sys:role:info', '2', null, '0', '2019-04-24 17:49:23', '2019-04-24 17:49:46');
INSERT INTO `sys_menu` VALUES ('20', '3', '新增', null, 'sys:role:save,sys:menu:perms', '2', null, '0', '2019-04-24 17:49:23', '2019-04-24 17:49:46');
INSERT INTO `sys_menu` VALUES ('21', '3', '修改', null, 'sys:role:update,sys:menu:perms', '2', null, '0', '2019-04-24 17:49:23', '2019-04-24 17:49:46');
INSERT INTO `sys_menu` VALUES ('22', '3', '删除', null, 'sys:role:delete', '2', null, '0', '2019-04-24 17:49:23', '2019-04-24 17:49:46');
INSERT INTO `sys_menu` VALUES ('23', '4', '查看', null, 'sys:menu:list,sys:menu:info', '2', null, '0', '2019-04-24 17:49:23', '2019-04-24 17:49:46');
INSERT INTO `sys_menu` VALUES ('24', '4', '新增', null, 'sys:menu:save,sys:menu:select', '2', null, '0', '2019-04-24 17:49:23', '2019-04-24 17:49:46');
INSERT INTO `sys_menu` VALUES ('25', '4', '修改', null, 'sys:menu:update,sys:menu:select', '2', null, '0', '2019-04-24 17:49:23', '2019-04-24 17:49:46');
INSERT INTO `sys_menu` VALUES ('26', '4', '删除', null, 'sys:menu:delete', '2', null, '0', '2019-04-24 17:49:23', '2019-04-24 17:49:46');
INSERT INTO `sys_menu` VALUES ('27', '1', '参数管理', 'modules/sys/config.html', 'sys:config:list,sys:config:info,sys:config:save,sys:config:update,sys:config:delete', '1', 'fa fa-sun-o', '6', '2019-04-24 17:49:23', '2019-04-24 17:49:46');
INSERT INTO `sys_menu` VALUES ('29', '1', '系统日志', 'modules/sys/log.html', 'sys:log:list', '1', 'fa fa-file-text-o', '7', '2019-04-24 17:49:23', '2019-04-24 17:49:46');
INSERT INTO `sys_menu` VALUES ('30', '1', '文件上传', 'modules/oss/oss.html', 'sys:oss:all', '1', 'fa fa-file-image-o', '6', '2019-04-24 17:49:23', '2019-04-24 17:49:46');
INSERT INTO `sys_menu` VALUES ('31', '1', '部门管理', 'modules/sys/dept.html', null, '1', 'fa fa-file-code-o', '1', '2019-04-24 17:49:23', '2019-04-24 17:49:46');
INSERT INTO `sys_menu` VALUES ('32', '31', '查看', null, 'sys:dept:list,sys:dept:info', '2', null, '0', '2019-04-24 17:49:23', '2019-04-24 17:49:46');
INSERT INTO `sys_menu` VALUES ('33', '31', '新增', null, 'sys:dept:save,sys:dept:select', '2', null, '0', '2019-04-24 17:49:23', '2019-04-24 17:49:46');
INSERT INTO `sys_menu` VALUES ('34', '31', '修改', null, 'sys:dept:update,sys:dept:select', '2', null, '0', '2019-04-24 17:49:23', '2019-04-24 17:49:46');
INSERT INTO `sys_menu` VALUES ('35', '31', '删除', null, 'sys:dept:delete', '2', null, '0', '2019-04-24 17:49:23', '2019-04-24 17:49:46');
INSERT INTO `sys_menu` VALUES ('36', '1', '字典管理', 'modules/sys/dict.html', null, '1', 'fa fa-bookmark-o', '6', '2019-04-24 17:49:23', '2019-04-24 17:49:46');
INSERT INTO `sys_menu` VALUES ('37', '36', '查看', null, 'sys:dict:list,sys:dict:info', '2', null, '6', '2019-04-24 17:49:23', '2019-04-24 17:49:46');
INSERT INTO `sys_menu` VALUES ('38', '36', '新增', null, 'sys:dict:save', '2', null, '6', '2019-04-24 17:49:23', '2019-04-24 17:49:46');
INSERT INTO `sys_menu` VALUES ('39', '36', '修改', null, 'sys:dict:update', '2', null, '6', '2019-04-24 17:49:23', '2019-04-24 17:49:46');
INSERT INTO `sys_menu` VALUES ('40', '36', '删除', null, 'sys:dict:delete', '2', null, '6', '2019-04-24 17:49:23', '2019-04-24 17:49:46');
INSERT INTO `sys_menu` VALUES ('41', '1', '租户管理', 'modules/sys/tenant.html', null, '1', 'fa fa-file-code-o', '2', '2019-04-25 09:57:03', '2019-04-25 09:57:03');
INSERT INTO `sys_menu` VALUES ('42', '41', '查看', null, 'sys:tenant:list,sys:tenant:info', '2', null, '6', '2019-04-25 09:57:03', '2019-04-25 15:02:06');
INSERT INTO `sys_menu` VALUES ('43', '41', '新增', null, 'sys:tenant:save', '2', null, '6', '2019-04-25 09:57:03', '2019-04-25 15:02:12');
INSERT INTO `sys_menu` VALUES ('44', '41', '修改', null, 'sys:tenant:update', '2', null, '6', '2019-04-25 09:57:03', '2019-04-25 15:02:20');
INSERT INTO `sys_menu` VALUES ('45', '41', '删除', null, 'sys:tenant:delete', '2', null, '6', '2019-04-25 09:57:04', '2019-04-25 15:02:27');

-- ----------------------------
-- Table structure for sys_oss
-- ----------------------------
DROP TABLE IF EXISTS `sys_oss`;
CREATE TABLE `sys_oss` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `url` varchar(200) DEFAULT NULL COMMENT 'URL地址',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文件上传';

-- ----------------------------
-- Records of sys_oss
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(100) DEFAULT NULL COMMENT '角色名称',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  `dept_id` bigint(20) DEFAULT NULL COMMENT '部门ID',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='角色';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '第一个角色', null, '1', '10001', '2019-04-25 10:19:13', '2019-04-25 11:47:25');

-- ----------------------------
-- Table structure for sys_role_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_dept`;
CREATE TABLE `sys_role_dept` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `dept_id` bigint(20) DEFAULT NULL COMMENT '部门ID',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='角色与部门对应关系';

-- ----------------------------
-- Records of sys_role_dept
-- ----------------------------
INSERT INTO `sys_role_dept` VALUES ('1', '1', '1', '2019-04-25 10:19:13', '2019-04-25 10:19:13');
INSERT INTO `sys_role_dept` VALUES ('2', '1', '2', '2019-04-25 10:19:13', '2019-04-25 10:19:13');
INSERT INTO `sys_role_dept` VALUES ('3', '1', '3', '2019-04-25 10:19:13', '2019-04-25 10:19:13');
INSERT INTO `sys_role_dept` VALUES ('4', '1', '4', '2019-04-25 10:19:13', '2019-04-25 10:19:13');
INSERT INTO `sys_role_dept` VALUES ('5', '1', '5', '2019-04-25 10:19:13', '2019-04-25 10:19:13');

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `menu_id` bigint(20) DEFAULT NULL COMMENT '菜单ID',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8 COMMENT='角色与菜单对应关系';

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES ('1', '1', '1', '2019-04-25 10:19:13', '2019-04-25 10:19:13');
INSERT INTO `sys_role_menu` VALUES ('2', '1', '2', '2019-04-25 10:19:13', '2019-04-25 10:19:13');
INSERT INTO `sys_role_menu` VALUES ('3', '1', '15', '2019-04-25 10:19:13', '2019-04-25 10:19:13');
INSERT INTO `sys_role_menu` VALUES ('4', '1', '16', '2019-04-25 10:19:13', '2019-04-25 10:19:13');
INSERT INTO `sys_role_menu` VALUES ('5', '1', '17', '2019-04-25 10:19:13', '2019-04-25 10:19:13');
INSERT INTO `sys_role_menu` VALUES ('6', '1', '18', '2019-04-25 10:19:13', '2019-04-25 10:19:13');
INSERT INTO `sys_role_menu` VALUES ('7', '1', '3', '2019-04-25 10:19:13', '2019-04-25 10:19:13');
INSERT INTO `sys_role_menu` VALUES ('8', '1', '19', '2019-04-25 10:19:13', '2019-04-25 10:19:13');
INSERT INTO `sys_role_menu` VALUES ('9', '1', '20', '2019-04-25 10:19:13', '2019-04-25 10:19:13');
INSERT INTO `sys_role_menu` VALUES ('10', '1', '21', '2019-04-25 10:19:13', '2019-04-25 10:19:13');
INSERT INTO `sys_role_menu` VALUES ('11', '1', '22', '2019-04-25 10:19:13', '2019-04-25 10:19:13');
INSERT INTO `sys_role_menu` VALUES ('12', '1', '4', '2019-04-25 10:19:13', '2019-04-25 10:19:13');
INSERT INTO `sys_role_menu` VALUES ('13', '1', '23', '2019-04-25 10:19:13', '2019-04-25 10:19:13');
INSERT INTO `sys_role_menu` VALUES ('14', '1', '24', '2019-04-25 10:19:13', '2019-04-25 10:19:13');
INSERT INTO `sys_role_menu` VALUES ('15', '1', '25', '2019-04-25 10:19:13', '2019-04-25 10:19:13');
INSERT INTO `sys_role_menu` VALUES ('16', '1', '26', '2019-04-25 10:19:13', '2019-04-25 10:19:13');
INSERT INTO `sys_role_menu` VALUES ('17', '1', '5', '2019-04-25 10:19:13', '2019-04-25 10:19:13');
INSERT INTO `sys_role_menu` VALUES ('18', '1', '27', '2019-04-25 10:19:13', '2019-04-25 10:19:13');
INSERT INTO `sys_role_menu` VALUES ('19', '1', '29', '2019-04-25 10:19:13', '2019-04-25 10:19:13');
INSERT INTO `sys_role_menu` VALUES ('20', '1', '30', '2019-04-25 10:19:13', '2019-04-25 10:19:13');
INSERT INTO `sys_role_menu` VALUES ('21', '1', '31', '2019-04-25 10:19:13', '2019-04-25 10:19:13');
INSERT INTO `sys_role_menu` VALUES ('22', '1', '32', '2019-04-25 10:19:13', '2019-04-25 10:19:13');
INSERT INTO `sys_role_menu` VALUES ('23', '1', '33', '2019-04-25 10:19:13', '2019-04-25 10:19:13');
INSERT INTO `sys_role_menu` VALUES ('24', '1', '34', '2019-04-25 10:19:13', '2019-04-25 10:19:13');
INSERT INTO `sys_role_menu` VALUES ('25', '1', '35', '2019-04-25 10:19:13', '2019-04-25 10:19:13');
INSERT INTO `sys_role_menu` VALUES ('26', '1', '36', '2019-04-25 10:19:13', '2019-04-25 10:19:13');
INSERT INTO `sys_role_menu` VALUES ('27', '1', '37', '2019-04-25 10:19:13', '2019-04-25 10:19:13');
INSERT INTO `sys_role_menu` VALUES ('28', '1', '38', '2019-04-25 10:19:13', '2019-04-25 10:19:13');
INSERT INTO `sys_role_menu` VALUES ('29', '1', '39', '2019-04-25 10:19:13', '2019-04-25 10:19:13');
INSERT INTO `sys_role_menu` VALUES ('30', '1', '40', '2019-04-25 10:19:13', '2019-04-25 10:19:13');
INSERT INTO `sys_role_menu` VALUES ('31', '1', '41', '2019-04-25 10:19:13', '2019-04-25 10:19:13');
INSERT INTO `sys_role_menu` VALUES ('32', '1', '42', '2019-04-25 10:19:13', '2019-04-25 10:19:13');
INSERT INTO `sys_role_menu` VALUES ('33', '1', '43', '2019-04-25 10:19:13', '2019-04-25 10:19:13');
INSERT INTO `sys_role_menu` VALUES ('34', '1', '44', '2019-04-25 10:19:13', '2019-04-25 10:19:13');
INSERT INTO `sys_role_menu` VALUES ('35', '1', '45', '2019-04-25 10:19:13', '2019-04-25 10:19:13');

-- ----------------------------
-- Table structure for sys_tenant
-- ----------------------------
DROP TABLE IF EXISTS `sys_tenant`;
CREATE TABLE `sys_tenant` (
  `tenant_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '租户id',
  `tenant_name` varchar(50) NOT NULL COMMENT '租户名称',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态  0：禁用   1：正常',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`tenant_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10004 DEFAULT CHARSET=utf8 COMMENT='租户信息表';

-- ----------------------------
-- Records of sys_tenant
-- ----------------------------
INSERT INTO `sys_tenant` VALUES ('10001', '这是第一个租户', '1', '2019-04-24 18:14:35', '2019-04-24 18:14:53');
INSERT INTO `sys_tenant` VALUES ('10002', '租户2', '1', '2019-04-25 10:02:52', '2019-04-25 10:02:52');

-- ----------------------------
-- Table structure for sys_test
-- ----------------------------
DROP TABLE IF EXISTS `sys_test`;
CREATE TABLE `sys_test` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL COMMENT '用户名',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(100) DEFAULT NULL COMMENT '手机号',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态  0：禁用   1：正常',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='系统用户';

-- ----------------------------
-- Records of sys_test
-- ----------------------------
INSERT INTO `sys_test` VALUES ('1', 'admin', 'root@renren.io', '13612345678', '1', '2016-11-11 11:11:11', '2019-04-24 17:42:46');
INSERT INTO `sys_test` VALUES ('2', 'xuepengyu123', null, null, '1', null, '2019-04-24 17:42:46');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `salt` varchar(20) DEFAULT NULL COMMENT '盐',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(100) DEFAULT NULL COMMENT '手机号',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态  0：禁用   1：正常',
  `dept_id` bigint(20) DEFAULT NULL COMMENT '部门ID',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='系统用户';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', 'e1153123d7d180ceeb820d577ff119876678732a68eef4e6ffc0b1f06a01f91b', 'YzcmCZNvbXocrsz9dm8e', 'xuepy@belink.com', '13612345678', '1', '1', null, '2016-11-11 11:11:11', '2019-04-24 17:39:39');
INSERT INTO `sys_user` VALUES ('2', 'xuepengyu', 'fd1680c3c00e180cf7106ebe154624805c0e7741c497db7524d4967a4eba3ae3', 'sX4hzYGHqxhmRlXJWGnR', '123@qq.com', '15232323322', '1', '1', null, '2019-04-23 15:12:10', '2019-04-24 17:39:39');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户与角色对应关系';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
