/*
Navicat MySQL Data Transfer

Source Server         : Aliyun
Source Server Version : 50627
Source Host           : 120.55.191.224:3306
Source Database       : gh1200240001

Target Server Type    : MYSQL
Target Server Version : 50627
File Encoding         : 65001

Date: 2015-12-10 13:40:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `datain`
-- ----------------------------
DROP TABLE IF EXISTS `datain`;
CREATE TABLE `datain` (
  `uid` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `deviceid` int(10) unsigned NOT NULL,
  `timestamp` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `airtemp` decimal(10,2) DEFAULT NULL,
  `airhum` decimal(10,2) unsigned DEFAULT NULL,
  `soiltemp` decimal(10,2) DEFAULT NULL,
  `soilhum` decimal(10,2) unsigned DEFAULT NULL,
  `light` decimal(10,2) unsigned DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for `dataout`
-- ----------------------------
DROP TABLE IF EXISTS `dataout`;
CREATE TABLE `dataout` (
  `uid` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `deviceid` int(10) unsigned NOT NULL,
  `timestamp` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `airtemp` decimal(10,2) DEFAULT NULL,
  `airhum` decimal(10,2) DEFAULT NULL,
  `winddirect` decimal(10,2) unsigned DEFAULT NULL,
  `windspeed` decimal(10,2) unsigned DEFAULT NULL,
  `atmosphere` decimal(10,2) unsigned DEFAULT NULL,
  `rainfall` decimal(10,2) unsigned DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for `device`
-- ----------------------------
DROP TABLE IF EXISTS `device`;
CREATE TABLE `device` (
  `uid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `deviceid` int(10) unsigned NOT NULL,
  `location` int(10) unsigned NOT NULL,
  `status` tinyint(3) unsigned NOT NULL,
  `parentid` int(10) unsigned NOT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



-- ----------------------------
-- Table structure for `devicemap`
-- ----------------------------
DROP TABLE IF EXISTS `devicemap`;
CREATE TABLE `devicemap` (
  `uid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `deviceid` int(10) unsigned NOT NULL,
  `serialid` int(10) unsigned NOT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for `indoor`
-- ----------------------------
DROP TABLE IF EXISTS `indoor`;
CREATE TABLE `indoor` (
  `uid` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `timestamp` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `airtemp` decimal(10,2) DEFAULT NULL,
  `airhum` decimal(10,2) unsigned DEFAULT NULL,
  `soiltemp` decimal(10,2) DEFAULT NULL,
  `soilhum` decimal(10,2) unsigned DEFAULT NULL,
  `light` decimal(10,2) unsigned DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for `logcontrol`
-- ----------------------------
DROP TABLE IF EXISTS `logcontrol`;
CREATE TABLE `logcontrol` (
  `uid` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `deviceid` int(10) unsigned NOT NULL,
  `prestatus` tinyint(3) unsigned DEFAULT NULL,
  `curstatus` tinyint(3) unsigned DEFAULT NULL,
  `timestamp` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`uid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of logcontrol
-- ----------------------------

-- ----------------------------
-- Table structure for `logdevice`
-- ----------------------------
DROP TABLE IF EXISTS `logdevice`;
CREATE TABLE `logdevice` (
  `uid` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `deviceid` int(10) unsigned NOT NULL,
  `prestatus` tinyint(3) unsigned DEFAULT NULL,
  `curstatus` tinyint(3) unsigned DEFAULT NULL,
  `timestamp` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`uid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of logdevice
-- ----------------------------

-- ----------------------------
-- Table structure for `loggrow`
-- ----------------------------
DROP TABLE IF EXISTS `loggrow`;
CREATE TABLE `loggrow` (
  `uid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `plantid` int(10) unsigned NOT NULL,
  `prestatus` tinyint(3) unsigned DEFAULT NULL,
  `curstatus` tinyint(3) unsigned DEFAULT NULL,
  `timstamp` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`uid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of loggrow
-- ----------------------------

-- ----------------------------
-- Table structure for `logoperation`
-- ----------------------------
DROP TABLE IF EXISTS `logoperation`;
CREATE TABLE `logoperation` (
  `uid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `chemicalid` int(10) unsigned NOT NULL,
  `event` varchar(255) DEFAULT NULL,
  `timestamp` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`uid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of logoperation
-- ----------------------------

-- ----------------------------
-- Table structure for `outdoor`
-- ----------------------------
DROP TABLE IF EXISTS `outdoor`;
CREATE TABLE `outdoor` (
  `uid` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `timestamp` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `airtemp` decimal(10,2) DEFAULT NULL,
  `airhum` decimal(10,2) DEFAULT NULL,
  `winddirect` decimal(10,2) unsigned DEFAULT NULL,
  `windspeed` decimal(10,2) unsigned DEFAULT NULL,
  `atmosphere` decimal(10,2) unsigned DEFAULT NULL,
  `rainfall` decimal(10,2) unsigned DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for `plant`
-- ----------------------------
DROP TABLE IF EXISTS `plant`;
CREATE TABLE `plant` (
  `uid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `varietyid` int(10) unsigned NOT NULL,
  `number` int(10) unsigned DEFAULT NULL,
  `planttime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `status` tinyint(3) unsigned NOT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
