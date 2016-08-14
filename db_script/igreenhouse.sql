/*
Navicat MySQL Data Transfer

Source Server         : Tencent
Source Server Version : 50713
Source Host           : allenko.cn:3306
Source Database       : igreenhouse

Target Server Type    : MYSQL
Target Server Version : 50713
File Encoding         : 65001

Date: 2016-08-14 16:55:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `data_air_humidity`
-- ----------------------------
DROP TABLE IF EXISTS `data_air_humidity`;
CREATE TABLE `data_air_humidity` (
  `uid` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '记录ID',
  `deviceid` bigint(20) unsigned NOT NULL COMMENT '设备ID',
  `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录时间戳',
  `value` decimal(10,2) NOT NULL COMMENT '记录值',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=115862 DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for `data_air_temp`
-- ----------------------------
DROP TABLE IF EXISTS `data_air_temp`;
CREATE TABLE `data_air_temp` (
  `uid` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '记录ID',
  `deviceid` bigint(20) unsigned NOT NULL COMMENT '设备ID',
  `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录时间戳',
  `value` decimal(10,2) NOT NULL COMMENT '记录值',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=115861 DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for `data_atmosphere`
-- ----------------------------
DROP TABLE IF EXISTS `data_atmosphere`;
CREATE TABLE `data_atmosphere` (
  `uid` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '记录ID',
  `deviceid` bigint(20) unsigned NOT NULL COMMENT '设备ID',
  `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录时间戳',
  `value` decimal(10,2) NOT NULL COMMENT '记录值',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=2372 DEFAULT CHARSET=utf8;



-- ----------------------------
-- Table structure for `data_light`
-- ----------------------------
DROP TABLE IF EXISTS `data_light`;
CREATE TABLE `data_light` (
  `uid` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '记录ID',
  `deviceid` bigint(20) unsigned NOT NULL COMMENT '设备ID',
  `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录时间戳',
  `value` decimal(10,2) NOT NULL COMMENT '记录值',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=146 DEFAULT CHARSET=utf8;



-- ----------------------------
-- Table structure for `data_rainfall`
-- ----------------------------
DROP TABLE IF EXISTS `data_rainfall`;
CREATE TABLE `data_rainfall` (
  `uid` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '记录ID',
  `deviceid` bigint(20) unsigned NOT NULL COMMENT '设备ID',
  `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录时间戳',
  `value` decimal(10,2) NOT NULL COMMENT '记录值',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=2371 DEFAULT CHARSET=utf8;



-- ----------------------------
-- Table structure for `data_soil_humidity`
-- ----------------------------
DROP TABLE IF EXISTS `data_soil_humidity`;
CREATE TABLE `data_soil_humidity` (
  `uid` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '记录ID',
  `deviceid` bigint(20) unsigned NOT NULL COMMENT '设备ID',
  `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录时间戳',
  `value` decimal(10,2) NOT NULL COMMENT '记录值',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=146 DEFAULT CHARSET=utf8;



-- ----------------------------
-- Table structure for `data_soil_temp`
-- ----------------------------
DROP TABLE IF EXISTS `data_soil_temp`;
CREATE TABLE `data_soil_temp` (
  `uid` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '记录ID',
  `deviceid` bigint(20) unsigned NOT NULL COMMENT '设备ID',
  `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录时间戳',
  `value` decimal(10,2) NOT NULL COMMENT '记录值',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=146 DEFAULT CHARSET=utf8;



-- ----------------------------
-- Table structure for `data_solar_radiation`
-- ----------------------------
DROP TABLE IF EXISTS `data_solar_radiation`;
CREATE TABLE `data_solar_radiation` (
  `uid` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '记录ID',
  `deviceid` bigint(20) unsigned NOT NULL COMMENT '设备ID',
  `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录时间戳',
  `value` decimal(10,2) NOT NULL COMMENT '记录值',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=2373 DEFAULT CHARSET=utf8;



-- ----------------------------
-- Table structure for `data_wind_direct`
-- ----------------------------
DROP TABLE IF EXISTS `data_wind_direct`;
CREATE TABLE `data_wind_direct` (
  `uid` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '记录ID',
  `deviceid` bigint(20) unsigned NOT NULL COMMENT '设备ID',
  `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录时间戳',
  `value` decimal(10,2) NOT NULL COMMENT '记录值',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=2373 DEFAULT CHARSET=utf8;



-- ----------------------------
-- Table structure for `data_wind_speed`
-- ----------------------------
DROP TABLE IF EXISTS `data_wind_speed`;
CREATE TABLE `data_wind_speed` (
  `uid` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '记录ID',
  `deviceid` bigint(20) unsigned NOT NULL COMMENT '设备ID',
  `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录时间戳',
  `value` decimal(10,2) NOT NULL COMMENT '记录值',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=2373 DEFAULT CHARSET=utf8;



-- ----------------------------
-- Table structure for `device`
-- ----------------------------
DROP TABLE IF EXISTS `device`;
CREATE TABLE `device` (
  `uid` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '设备ID',
  `id` bigint(20) unsigned NOT NULL COMMENT '设备编号，前3位表示设备类型，后6位标识设备编号',
  `type` tinyint(1) unsigned NOT NULL COMMENT '第一位1传感器，2控制器；后两位01传感器，02ZED，03路由器，04ZC，05气象站',
  `name` varchar(255) NOT NULL COMMENT '设备名称',
  `serialid` int(10) unsigned DEFAULT NULL COMMENT '对应串口ID',
  `greenhouseid` bigint(20) unsigned DEFAULT NULL COMMENT '所属温室ID',
  `brand` varchar(255) DEFAULT NULL COMMENT '设备品牌',
  `model` varchar(255) DEFAULT NULL COMMENT '设备型号',
  `available` tinyint(1) unsigned NOT NULL COMMENT '1表示可用，2表示使用中，3表示损坏',
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of device
-- ----------------------------
INSERT INTO `device` VALUES ('1', '10400001', '104', '协调器1', '0', '1200240001', 'TI', 'CC2530', '2', null);
INSERT INTO `device` VALUES ('2', '10300001', '103', '路由器1', '1', '1200240001', 'TI', 'CC2530', '2', null);
INSERT INTO `device` VALUES ('3', '10300002', '103', '路由器2', '2', '1200240001', 'TI', 'CC2530', '2', null);
INSERT INTO `device` VALUES ('4', '10300003', '103', '路由器3', '3', '1200240001', 'TI', 'CC2530', '2', null);
INSERT INTO `device` VALUES ('5', '10300004', '103', '路由器4', '4', '1200240001', 'TI', 'CC2530', '2', null);
INSERT INTO `device` VALUES ('12', '10300005', '103', '路由器5', '5', '1200240001', 'TI', 'CC2530', '2', null);
INSERT INTO `device` VALUES ('13', '10300006', '103', '路由器6', '6', '1200240001', 'TI', 'CC2530', '2', null);
INSERT INTO `device` VALUES ('14', '10300007', '103', '路由器7', '7', '1200240001', 'TI', 'CC2530', '2', null);
INSERT INTO `device` VALUES ('15', '10300008', '103', '路由器8', '8', '1200240001', 'TI', 'CC2530', '2', null);
INSERT INTO `device` VALUES ('16', '10300009', '103', '路由器9', '9', '1200240001', 'TI', 'CC2530', '2', null);
INSERT INTO `device` VALUES ('17', '10200001', '102', '终端1', '10', '1200240001', 'TI', 'CC2530', '2', null);
INSERT INTO `device` VALUES ('18', '10200002', '102', '终端2', '11', '1200240001', 'TI', 'CC2530', '2', null);
INSERT INTO `device` VALUES ('19', '10200003', '102', '终端3', '12', '1200240001', 'TI', 'CC2530', '2', null);
INSERT INTO `device` VALUES ('20', '10200004', '102', '终端4', '13', '1200240001', 'TI', 'CC2530', '2', null);
INSERT INTO `device` VALUES ('21', '10200005', '102', '终端5', '14', '1200240001', 'TI', 'CC2530', '2', null);
INSERT INTO `device` VALUES ('22', '10200006', '102', '终端6', '15', '1200240001', 'TI', 'CC2530', '2', null);
INSERT INTO `device` VALUES ('23', '10200007', '102', '终端7', '16', '1200240001', 'TI', 'CC2530', '2', null);
INSERT INTO `device` VALUES ('24', '10200008', '102', '终端8', '17', '1200240001', 'TI', 'CC2530', '2', null);
INSERT INTO `device` VALUES ('25', '10200009', '102', '终端9', '18', '1200240001', 'TI', 'CC2530', '2', null);
INSERT INTO `device` VALUES ('26', '10200010', '102', '终端10', '19', '1200240001', 'TI', 'CC2530', '2', null);
INSERT INTO `device` VALUES ('27', '10200011', '102', '终端11', '20', '1200240001', 'TI', 'CC2530', '2', null);
INSERT INTO `device` VALUES ('28', '10200012', '102', '终端12', '21', '1200240001', 'TI', 'CC2530', '2', null);
INSERT INTO `device` VALUES ('29', '10200013', '102', '终端13', '22', '1200240001', 'TI', 'CC2530', '2', null);
INSERT INTO `device` VALUES ('30', '10200014', '102', '终端14', '23', '1200240001', 'TI', 'CC2530', '2', null);
INSERT INTO `device` VALUES ('31', '10200015', '102', '终端15', '24', '1200240001', 'TI', 'CC2530', '2', null);
INSERT INTO `device` VALUES ('32', '10200016', '102', '终端16', '25', '1200240001', 'TI', 'CC2530', '2', null);
INSERT INTO `device` VALUES ('33', '10200017', '102', '终端17', '26', '1200240001', 'TI', 'CC2530', '2', null);
INSERT INTO `device` VALUES ('34', '10200018', '102', '终端18', '27', '1200240001', 'TI', 'CC2530', '2', null);
INSERT INTO `device` VALUES ('35', '10200019', '102', '终端19', '28', '1200240001', 'TI', 'CC2530', '2', null);
INSERT INTO `device` VALUES ('36', '10200020', '102', '终端20', '29', '1200240001', 'TI', 'CC2530', '2', null);
INSERT INTO `device` VALUES ('37', '10200021', '102', '终端21', '30', '1200240001', 'TI', 'CC2530', '2', null);
INSERT INTO `device` VALUES ('38', '10200022', '102', '终端22', '31', '1200240001', 'TI', 'CC2530', '2', null);
INSERT INTO `device` VALUES ('39', '10200023', '102', '终端23', '32', '1200240001', 'TI', 'CC2530', '2', null);
INSERT INTO `device` VALUES ('40', '10200024', '102', '终端24', '33', '1200240001', 'TI', 'CC2530', '2', null);
INSERT INTO `device` VALUES ('41', '10200025', '102', '终端25', '34', '1200240001', 'TI', 'CC2530', '2', null);
INSERT INTO `device` VALUES ('42', '10200026', '102', '终端26', '35', '1200240001', 'TI', 'CC2530', '2', null);
INSERT INTO `device` VALUES ('43', '10200027', '102', '终端27', '36', '1200240001', 'TI', 'CC2530', '2', null);
INSERT INTO `device` VALUES ('44', '10200028', '102', '终端28', '37', '1200240001', 'TI', 'CC2530', '2', null);
INSERT INTO `device` VALUES ('45', '10200029', '102', '终端29', '38', '1200240001', 'TI', 'CC2530', '2', null);
INSERT INTO `device` VALUES ('46', '10200030', '102', '终端30', '39', '1200240001', 'TI', 'CC2530', '2', null);
INSERT INTO `device` VALUES ('47', '10500001', '105', '室外气象站1', null, '1200240001', '智翔宇仪器', 'MULTI-6P', '2', null);
INSERT INTO `device` VALUES ('48', '10500002', '105', '室外太阳辐射1', null, '1200240001', '智翔宇仪器', null, '2', null);

-- ----------------------------
-- Table structure for `greenhouse`
-- ----------------------------
DROP TABLE IF EXISTS `greenhouse`;
CREATE TABLE `greenhouse` (
  `uid` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '记录ID',
  `id` bigint(20) unsigned NOT NULL COMMENT '第一位温室类型，后六位邮政编码，后三位温室编号。',
  `type` tinyint(3) unsigned NOT NULL COMMENT '1普通拱棚，2薄膜温室，3玻璃温室',
  `name` varchar(255) NOT NULL COMMENT '温室名称',
  `location` varchar(255) DEFAULT NULL COMMENT '精确到村',
  `gpsinfo` varchar(255) DEFAULT NULL COMMENT '温室GPS信息',
  `available` tinyint(3) unsigned NOT NULL COMMENT '1表示正常，2表示在建，3表示弃用',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of greenhouse
-- ----------------------------
INSERT INTO `greenhouse` VALUES ('1', '1200240001', '1', '测试温室', '上海市闵行区', '123456789', '1');

-- ----------------------------
-- Table structure for `log_control`
-- ----------------------------
DROP TABLE IF EXISTS `log_control`;
CREATE TABLE `log_control` (
  `uid` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `deviceid` bigint(20) unsigned NOT NULL COMMENT '设备ID',
  `prestatus` tinyint(3) unsigned DEFAULT NULL COMMENT '之前状态，1:关闭 2:半开 3:全开',
  `curstatus` tinyint(3) unsigned DEFAULT NULL COMMENT '当前状态，1:关闭 2:半开 3:全开',
  `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of log_control
-- ----------------------------
INSERT INTO `log_control` VALUES ('1', '10500001', '0', '1', '2016-07-29 21:43:59');
