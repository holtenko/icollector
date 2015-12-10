/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : logs

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2015-12-10 13:49:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `sqllog`
-- ----------------------------
DROP TABLE IF EXISTS `sqllog`;
CREATE TABLE `sqllog` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `dbname` varchar(16) NOT NULL,
  `sqlstatement` varchar(255) NOT NULL,
  `parameters` varchar(255) NOT NULL,
  `timestamp` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `status` tinyint(3) unsigned zerofill NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of sqllog
-- ----------------------------
