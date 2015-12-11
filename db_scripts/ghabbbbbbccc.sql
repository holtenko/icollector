/*
Navicat MySQL Data Transfer

Source Server         : Aliyun
Source Server Version : 50627
Source Host           : 120.55.191.224:3306
Source Database       : gh1200240002

Target Server Type    : MYSQL
Target Server Version : 50627
File Encoding         : 65001

Date: 2015-12-10 16:52:38
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
) ENGINE=InnoDB AUTO_INCREMENT=75 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of datain
-- ----------------------------
INSERT INTO `datain` VALUES ('1', '10300010', '2015-12-10 13:54:39', '17.32', '70.61', '18.92', '0.32', '185.00');
INSERT INTO `datain` VALUES ('2', '10300010', '2015-12-10 13:54:39', '17.32', '70.61', '18.92', '0.32', '185.00');
INSERT INTO `datain` VALUES ('3', '10200003', '2015-12-10 13:54:39', '17.09', '71.17', '16.97', '11.05', '175.00');
INSERT INTO `datain` VALUES ('4', '10200003', '2015-12-10 13:54:39', '17.09', '71.24', '17.36', '11.05', '175.00');
INSERT INTO `datain` VALUES ('5', '10300010', '2015-12-10 13:54:39', '17.34', '70.62', '18.53', '0.00', '185.00');
INSERT INTO `datain` VALUES ('6', '10200003', '2015-12-10 13:54:39', '17.11', '71.24', '16.97', '11.05', '175.00');
INSERT INTO `datain` VALUES ('7', '10300010', '2015-12-10 13:54:39', '17.36', '70.52', '18.53', '0.00', '185.00');
INSERT INTO `datain` VALUES ('8', '10200003', '2015-12-10 13:54:39', '17.11', '71.81', '16.97', '11.05', '175.00');
INSERT INTO `datain` VALUES ('9', '10300010', '2015-12-10 13:54:39', '17.34', '71.22', '18.53', '0.32', '185.00');
INSERT INTO `datain` VALUES ('10', '10300010', '2015-12-10 13:54:39', '17.34', '70.95', '18.92', '0.00', '185.00');
INSERT INTO `datain` VALUES ('11', '10300010', '2015-12-10 13:54:39', '17.36', '70.75', '18.92', '0.00', '185.00');
INSERT INTO `datain` VALUES ('12', '10300010', '2015-12-10 13:54:39', '17.36', '70.59', '18.92', '0.00', '185.00');
INSERT INTO `datain` VALUES ('13', '10200003', '2015-12-10 13:54:39', '17.14', '71.61', '17.36', '11.05', '175.00');
INSERT INTO `datain` VALUES ('14', '10300010', '2015-12-10 13:54:39', '17.34', '70.42', '18.53', '0.32', '185.00');
INSERT INTO `datain` VALUES ('15', '10200003', '2015-12-10 13:54:39', '17.14', '71.55', '17.36', '11.05', '175.00');
INSERT INTO `datain` VALUES ('16', '10300010', '2015-12-10 13:54:39', '17.36', '70.45', '18.53', '0.32', '185.00');
INSERT INTO `datain` VALUES ('17', '10200003', '2015-12-10 13:54:39', '17.14', '71.48', '17.36', '11.05', '175.00');
INSERT INTO `datain` VALUES ('18', '10200003', '2015-12-10 13:54:39', '17.18', '71.42', '17.36', '11.05', '175.00');
INSERT INTO `datain` VALUES ('19', '10300010', '2015-12-10 13:54:39', '17.37', '70.59', '18.92', '0.32', '185.00');
INSERT INTO `datain` VALUES ('20', '10300010', '2015-12-10 13:54:39', '17.39', '70.92', '18.53', '0.32', '185.00');
INSERT INTO `datain` VALUES ('21', '10200003', '2015-12-10 13:54:39', '17.16', '71.85', '16.97', '11.05', '175.00');
INSERT INTO `datain` VALUES ('22', '10300010', '2015-12-10 13:59:38', '17.39', '70.86', '18.53', '0.00', '185.00');
INSERT INTO `datain` VALUES ('23', '10200003', '2015-12-10 14:09:39', '17.21', '71.89', '17.36', '11.05', '175.00');
INSERT INTO `datain` VALUES ('24', '10300010', '2015-12-10 14:09:39', '17.41', '70.93', '18.53', '0.32', '185.00');
INSERT INTO `datain` VALUES ('25', '10200003', '2015-12-10 14:09:39', '17.21', '71.89', '17.36', '11.05', '175.00');
INSERT INTO `datain` VALUES ('26', '10300010', '2015-12-10 14:14:38', '17.44', '71.07', '18.92', '0.32', '185.00');
INSERT INTO `datain` VALUES ('27', '10200003', '2015-12-10 14:14:38', '17.25', '72.07', '17.36', '11.05', '175.00');
INSERT INTO `datain` VALUES ('28', '10300010', '2015-12-10 14:19:38', '17.46', '71.07', '18.92', '0.32', '185.00');
INSERT INTO `datain` VALUES ('29', '10200003', '2015-12-10 14:19:38', '17.29', '71.91', '17.36', '11.05', '175.00');
INSERT INTO `datain` VALUES ('30', '10300010', '2015-12-10 14:24:38', '17.48', '71.24', '18.92', '0.32', '185.00');
INSERT INTO `datain` VALUES ('31', '10200003', '2015-12-10 14:24:38', '17.28', '71.91', '17.36', '11.05', '175.00');
INSERT INTO `datain` VALUES ('32', '10200003', '2015-12-10 14:34:39', '17.30', '71.81', '17.36', '11.05', '175.00');
INSERT INTO `datain` VALUES ('33', '10300010', '2015-12-10 14:34:39', '17.48', '71.01', '18.53', '0.32', '185.00');
INSERT INTO `datain` VALUES ('34', '10200003', '2015-12-10 14:34:39', '17.30', '71.81', '17.36', '11.05', '175.00');
INSERT INTO `datain` VALUES ('35', '10300010', '2015-12-10 14:34:39', '17.50', '70.88', '18.92', '0.32', '185.00');
INSERT INTO `datain` VALUES ('36', '10200003', '2015-12-10 14:34:39', '17.32', '71.94', '17.36', '11.05', '175.00');
INSERT INTO `datain` VALUES ('37', '10300010', '2015-12-10 14:39:38', '17.52', '70.91', '18.92', '0.32', '185.00');
INSERT INTO `datain` VALUES ('38', '10200003', '2015-12-10 14:39:38', '17.34', '71.65', '17.36', '11.05', '175.00');
INSERT INTO `datain` VALUES ('39', '10300010', '2015-12-10 14:44:38', '17.54', '70.89', '18.92', '0.00', '185.00');
INSERT INTO `datain` VALUES ('40', '10200003', '2015-12-10 14:44:38', '17.36', '71.42', '17.36', '11.05', '175.00');
INSERT INTO `datain` VALUES ('41', '10200003', '2015-12-10 14:49:38', '17.37', '71.32', '17.36', '11.05', '175.00');
INSERT INTO `datain` VALUES ('42', '10300010', '2015-12-10 14:49:38', '17.55', '70.85', '18.92', '0.32', '185.00');
INSERT INTO `datain` VALUES ('43', '10200003', '2015-12-10 14:49:38', '17.37', '71.32', '17.36', '11.05', '175.00');
INSERT INTO `datain` VALUES ('44', '10300010', '2015-12-10 14:54:38', '17.57', '70.82', '18.92', '0.00', '185.00');
INSERT INTO `datain` VALUES ('45', '10200003', '2015-12-10 14:54:38', '17.39', '71.46', '17.36', '11.05', '175.00');
INSERT INTO `datain` VALUES ('46', '10300010', '2015-12-10 14:59:38', '17.61', '70.53', '18.92', '0.32', '185.00');
INSERT INTO `datain` VALUES ('47', '10200003', '2015-12-10 14:59:38', '17.41', '71.33', '17.36', '11.05', '175.00');
INSERT INTO `datain` VALUES ('48', '10300010', '2015-12-10 15:04:38', '17.59', '70.39', '18.92', '0.32', '185.00');
INSERT INTO `datain` VALUES ('49', '10200003', '2015-12-10 15:04:38', '17.43', '71.26', '17.36', '11.05', '175.00');
INSERT INTO `datain` VALUES ('50', '10200003', '2015-12-10 15:09:38', '17.43', '71.50', '17.36', '11.05', '175.00');
INSERT INTO `datain` VALUES ('51', '10300010', '2015-12-10 15:09:38', '17.61', '70.76', '18.92', '0.00', '185.00');
INSERT INTO `datain` VALUES ('52', '10200003', '2015-12-10 15:14:38', '17.46', '71.47', '17.75', '11.05', '175.00');
INSERT INTO `datain` VALUES ('53', '10300010', '2015-12-10 15:14:38', '17.62', '70.67', '18.92', '0.00', '185.00');
INSERT INTO `datain` VALUES ('54', '10300010', '2015-12-10 15:14:38', '17.62', '70.67', '18.92', '0.00', '185.00');
INSERT INTO `datain` VALUES ('55', '10200003', '2015-12-10 15:24:38', '17.48', '71.64', '17.36', '11.05', '175.00');
INSERT INTO `datain` VALUES ('56', '10300010', '2015-12-10 15:24:38', '17.66', '70.77', '18.92', '0.00', '185.00');
INSERT INTO `datain` VALUES ('57', '10300010', '2015-12-10 15:29:38', '17.66', '70.44', '18.92', '0.00', '185.00');
INSERT INTO `datain` VALUES ('58', '10200003', '2015-12-10 15:29:38', '17.52', '71.45', '17.36', '11.05', '175.00');
INSERT INTO `datain` VALUES ('59', '10300010', '2015-12-10 15:29:38', '17.66', '70.44', '18.92', '0.00', '185.00');
INSERT INTO `datain` VALUES ('60', '10200003', '2015-12-10 15:34:38', '17.53', '71.32', '17.36', '11.05', '175.00');
INSERT INTO `datain` VALUES ('61', '10300010', '2015-12-10 15:34:38', '17.66', '70.47', '18.92', '0.00', '185.00');
INSERT INTO `datain` VALUES ('62', '10200003', '2015-12-10 15:39:38', '17.54', '71.25', '17.36', '11.05', '175.00');
INSERT INTO `datain` VALUES ('63', '10300010', '2015-12-10 15:39:38', '17.69', '70.81', '18.92', '0.00', '185.00');
INSERT INTO `datain` VALUES ('64', '10300010', '2015-12-10 15:44:38', '17.69', '70.71', '18.92', '0.32', '185.00');
INSERT INTO `datain` VALUES ('65', '10300010', '2015-12-10 15:49:38', '17.70', '70.45', '18.92', '0.32', '185.00');
INSERT INTO `datain` VALUES ('66', '10200003', '2015-12-10 15:49:38', '17.55', '71.09', '17.36', '11.05', '175.00');
INSERT INTO `datain` VALUES ('67', '10200003', '2015-12-10 15:54:38', '17.57', '71.16', '17.36', '11.05', '175.00');
INSERT INTO `datain` VALUES ('68', '10300010', '2015-12-10 15:54:39', '17.73', '70.65', '18.92', '0.32', '185.00');
INSERT INTO `datain` VALUES ('69', '10200003', '2015-12-10 15:59:39', '17.57', '71.12', '17.75', '11.05', '175.00');
INSERT INTO `datain` VALUES ('70', '10300010', '2015-12-10 15:59:39', '17.73', '70.42', '18.92', '0.00', '185.00');
INSERT INTO `datain` VALUES ('71', '10200003', '2015-12-10 16:04:39', '17.57', '70.79', '17.36', '11.05', '175.00');
INSERT INTO `datain` VALUES ('72', '10300010', '2015-12-10 16:04:39', '17.75', '70.22', '18.92', '0.32', '185.00');
INSERT INTO `datain` VALUES ('73', '10300010', '2015-12-10 16:09:39', '17.75', '70.15', '18.92', '0.32', '185.00');
INSERT INTO `datain` VALUES ('74', '10200003', '2015-12-10 16:09:39', '17.59', '70.89', '17.36', '11.05', '175.00');

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dataout
-- ----------------------------

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
-- Records of device
-- ----------------------------

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
-- Records of devicemap
-- ----------------------------

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of indoor
-- ----------------------------
INSERT INTO `indoor` VALUES ('1', '2015-12-10 15:35:46', '20.56', '65.10', '19.25', '0.32', '1545.00');
INSERT INTO `indoor` VALUES ('2', '2015-12-10 15:31:02', '17.57', '70.98', '18.34', '4.42', '181.00');
INSERT INTO `indoor` VALUES ('3', '2015-12-10 15:51:02', '17.62', '70.84', '18.30', '4.48', '181.00');

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of outdoor
-- ----------------------------
INSERT INTO `outdoor` VALUES ('1', '2015-12-10 15:36:28', '18.22', '75.29', '150.00', '2.10', '1234.00', '0.00');

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

-- ----------------------------
-- Records of plant
-- ----------------------------
