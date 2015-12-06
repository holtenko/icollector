/*
Navicat MySQL Data Transfer

Source Server         : collector0
Source Server Version : 50627
Source Host           : 192.168.0.137:3306
Source Database       : igreenhouse

Target Server Type    : MYSQL
Target Server Version : 50627
File Encoding         : 65001

Date: 2015-12-04 09:26:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `chemical`
-- ----------------------------
DROP TABLE IF EXISTS `chemical`;
CREATE TABLE `chemical` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `type` tinyint(3) unsigned NOT NULL,
  `name` varchar(255) NOT NULL,
  `brand` varchar(255) DEFAULT NULL,
  `effect` varchar(255) DEFAULT NULL,
  `available` tinyint(3) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of chemical
-- ----------------------------

-- ----------------------------
-- Table structure for `device`
-- ----------------------------
DROP TABLE IF EXISTS `device`;
CREATE TABLE `device` (
  `uid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `id` int(10) unsigned NOT NULL,
  `type` tinyint(3) unsigned NOT NULL,
  `name` varchar(255) NOT NULL,
  `brand` varchar(255) DEFAULT NULL,
  `model` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `available` tinyint(3) unsigned NOT NULL,
  `greenhouse` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=107 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of device
-- ----------------------------
INSERT INTO `device` VALUES ('1', '10400001', '104', '协调器1', 'TI', 'CC2530', null, '2', '1200240001');
INSERT INTO `device` VALUES ('2', '10300001', '103', '路由器1', 'TI', 'CC2530', null, '2', '1200240001');
INSERT INTO `device` VALUES ('3', '10300002', '103', '路由器2', 'TI', 'CC2530', null, '2', '1200240001');
INSERT INTO `device` VALUES ('4', '10300003', '103', '路由器3', 'TI', 'CC2530', null, '2', '1200240001');
INSERT INTO `device` VALUES ('5', '10300004', '103', '路由器4', 'TI', 'CC2530', null, '2', '1200240001');
INSERT INTO `device` VALUES ('12', '10300005', '103', '路由器5', 'TI', 'CC2530', null, '2', '1200240001');
INSERT INTO `device` VALUES ('13', '10300006', '103', '路由器6', 'TI', 'CC2530', null, '2', '1200240001');
INSERT INTO `device` VALUES ('14', '10300007', '103', '路由器7', 'TI', 'CC2530', null, '2', '1200240001');
INSERT INTO `device` VALUES ('15', '10300008', '103', '路由器8', 'TI', 'CC2530', null, '2', '1200240001');
INSERT INTO `device` VALUES ('16', '10300009', '103', '路由器9', 'TI', 'CC2530', null, '2', '1200240001');
INSERT INTO `device` VALUES ('17', '10200001', '102', '终端1', 'TI', 'CC2530', null, '2', '1200240001');
INSERT INTO `device` VALUES ('18', '10200002', '102', '终端2', 'TI', 'CC2530', null, '2', '1200240001');
INSERT INTO `device` VALUES ('19', '10200003', '102', '终端3', 'TI', 'CC2530', null, '2', '1200240001');
INSERT INTO `device` VALUES ('20', '10200004', '102', '终端4', 'TI', 'CC2530', null, '2', '1200240001');
INSERT INTO `device` VALUES ('21', '10200005', '102', '终端5', 'TI', 'CC2530', null, '2', '1200240001');
INSERT INTO `device` VALUES ('22', '10200006', '102', '终端6', 'TI', 'CC2530', null, '2', '1200240001');
INSERT INTO `device` VALUES ('23', '10200007', '102', '终端7', 'TI', 'CC2530', null, '2', '1200240001');
INSERT INTO `device` VALUES ('24', '10200008', '102', '终端8', 'TI', 'CC2530', null, '2', '1200240001');
INSERT INTO `device` VALUES ('25', '10200009', '102', '终端9', 'TI', 'CC2530', null, '2', '1200240001');
INSERT INTO `device` VALUES ('26', '10200010', '102', '终端10', 'TI', 'CC2530', null, '2', '1200240001');
INSERT INTO `device` VALUES ('27', '10200011', '102', '终端11', 'TI', 'CC2530', null, '2', '1200240001');
INSERT INTO `device` VALUES ('28', '10200012', '102', '终端12', 'TI', 'CC2530', null, '2', '1200240001');
INSERT INTO `device` VALUES ('29', '10200013', '102', '终端13', 'TI', 'CC2530', null, '2', '1200240001');
INSERT INTO `device` VALUES ('30', '10200014', '102', '终端14', 'TI', 'CC2530', null, '2', '1200240001');
INSERT INTO `device` VALUES ('31', '10200015', '102', '终端15', 'TI', 'CC2530', null, '2', '1200240001');
INSERT INTO `device` VALUES ('32', '10200016', '102', '终端16', 'TI', 'CC2530', null, '2', '1200240001');
INSERT INTO `device` VALUES ('33', '10200017', '102', '终端17', 'TI', 'CC2530', null, '2', '1200240001');
INSERT INTO `device` VALUES ('34', '10200018', '102', '终端18', 'TI', 'CC2530', null, '2', '1200240001');
INSERT INTO `device` VALUES ('35', '10200019', '102', '终端19', 'TI', 'CC2530', null, '2', '1200240001');
INSERT INTO `device` VALUES ('36', '10200020', '102', '终端20', 'TI', 'CC2530', null, '2', '1200240001');
INSERT INTO `device` VALUES ('37', '10200021', '102', '终端21', 'TI', 'CC2530', null, '2', '1200240001');
INSERT INTO `device` VALUES ('38', '10200022', '102', '终端22', 'TI', 'CC2530', null, '2', '1200240001');
INSERT INTO `device` VALUES ('39', '10200023', '102', '终端23', 'TI', 'CC2530', null, '2', '1200240001');
INSERT INTO `device` VALUES ('40', '10200024', '102', '终端24', 'TI', 'CC2530', null, '2', '1200240001');
INSERT INTO `device` VALUES ('41', '10200025', '102', '终端25', 'TI', 'CC2530', null, '2', '1200240001');
INSERT INTO `device` VALUES ('42', '10200026', '102', '终端26', 'TI', 'CC2530', null, '2', '1200240001');
INSERT INTO `device` VALUES ('43', '10200027', '102', '终端27', 'TI', 'CC2530', null, '2', '1200240001');
INSERT INTO `device` VALUES ('44', '10200028', '102', '终端28', 'TI', 'CC2530', null, '2', '1200240001');
INSERT INTO `device` VALUES ('45', '10200029', '102', '终端29', 'TI', 'CC2530', null, '2', '1200240001');
INSERT INTO `device` VALUES ('46', '10200030', '102', '终端30', 'TI', 'CC2530', null, '2', '1200240001');
INSERT INTO `device` VALUES ('47', '10200031', '102', '终端31', 'TI', 'CC2530', null, '2', '1200240001');
INSERT INTO `device` VALUES ('48', '10200032', '102', '终端32', 'TI', 'CC2530', null, '2', '1200240001');
INSERT INTO `device` VALUES ('49', '10200033', '102', '终端33', 'TI', 'CC2530', null, '2', '1200240001');
INSERT INTO `device` VALUES ('50', '10200034', '102', '终端34', 'TI', 'CC2530', null, '2', '1200240001');
INSERT INTO `device` VALUES ('51', '10200035', '102', '终端35', 'TI', 'CC2530', null, '2', '1200240001');
INSERT INTO `device` VALUES ('52', '10200036', '102', '终端36', 'TI', 'CC2530', null, '2', '1200240001');
INSERT INTO `device` VALUES ('53', '10200037', '102', '终端37', 'TI', 'CC2530', null, '2', '1200240001');
INSERT INTO `device` VALUES ('54', '10200038', '102', '终端38', 'TI', 'CC2530', null, '2', '1200240001');
INSERT INTO `device` VALUES ('55', '10200039', '102', '终端39', 'TI', 'CC2530', null, '2', '1200240001');
INSERT INTO `device` VALUES ('56', '10200040', '102', '终端40', 'TI', 'CC2530', null, '2', '1200240001');
INSERT INTO `device` VALUES ('57', '10200041', '102', '终端41', 'TI', 'CC2530', null, '2', '1200240001');
INSERT INTO `device` VALUES ('58', '10200042', '102', '终端42', 'TI', 'CC2530', null, '2', '1200240001');
INSERT INTO `device` VALUES ('59', '10200043', '102', '终端43', 'TI', 'CC2530', null, '2', '1200240001');
INSERT INTO `device` VALUES ('60', '10200044', '102', '终端44', 'TI', 'CC2530', null, '2', '1200240001');
INSERT INTO `device` VALUES ('61', '10200045', '102', '终端45', 'TI', 'CC2530', null, '2', '1200240001');
INSERT INTO `device` VALUES ('62', '10200046', '102', '终端46', 'TI', 'CC2530', null, '2', '1200240001');
INSERT INTO `device` VALUES ('63', '10200047', '102', '终端47', 'TI', 'CC2530', null, '2', '1200240001');
INSERT INTO `device` VALUES ('64', '10200048', '102', '终端48', 'TI', 'CC2530', null, '2', '1200240001');
INSERT INTO `device` VALUES ('65', '10200049', '102', '终端49', 'TI', 'CC2530', null, '2', '1200240001');
INSERT INTO `device` VALUES ('66', '10200050', '102', '终端50', 'TI', 'CC2530', null, '2', '1200240001');
INSERT INTO `device` VALUES ('67', '10200051', '102', '终端51', 'TI', 'CC2530', null, '2', '1200240001');
INSERT INTO `device` VALUES ('68', '10200052', '102', '终端52', 'TI', 'CC2530', null, '2', '1200240001');
INSERT INTO `device` VALUES ('69', '10200053', '102', '终端53', 'TI', 'CC2530', null, '2', '1200240001');
INSERT INTO `device` VALUES ('70', '10200054', '102', '终端54', 'TI', 'CC2530', null, '2', '1200240001');
INSERT INTO `device` VALUES ('71', '10200055', '102', '终端55', 'TI', 'CC2530', null, '2', '1200240001');
INSERT INTO `device` VALUES ('72', '10200056', '102', '终端56', 'TI', 'CC2530', null, '2', '1200240001');
INSERT INTO `device` VALUES ('73', '10200057', '102', '终端57', 'TI', 'CC2530', null, '2', '1200240001');
INSERT INTO `device` VALUES ('74', '10200058', '102', '终端58', 'TI', 'CC2530', null, '2', '1200240001');
INSERT INTO `device` VALUES ('75', '10200059', '102', '终端59', 'TI', 'CC2530', null, '2', '1200240001');
INSERT INTO `device` VALUES ('76', '10200060', '102', '终端60', 'TI', 'CC2530', null, '2', '1200240001');
INSERT INTO `device` VALUES ('77', '10200061', '102', '终端61', 'TI', 'CC2530', null, '2', '1200240001');
INSERT INTO `device` VALUES ('78', '10200062', '102', '终端62', 'TI', 'CC2530', null, '2', '1200240001');
INSERT INTO `device` VALUES ('79', '10200063', '102', '终端63', 'TI', 'CC2530', null, '2', '1200240001');
INSERT INTO `device` VALUES ('80', '10200064', '102', '终端64', 'TI', 'CC2530', null, '2', '1200240001');
INSERT INTO `device` VALUES ('81', '10200065', '102', '终端65', 'TI', 'CC2530', null, '2', '1200240001');
INSERT INTO `device` VALUES ('82', '10200066', '102', '终端66', 'TI', 'CC2530', null, '2', '1200240001');
INSERT INTO `device` VALUES ('83', '10200067', '102', '终端67', 'TI', 'CC2530', null, '2', '1200240001');
INSERT INTO `device` VALUES ('84', '10200068', '102', '终端68', 'TI', 'CC2530', null, '2', '1200240001');
INSERT INTO `device` VALUES ('85', '10200069', '102', '终端69', 'TI', 'CC2530', null, '2', '1200240001');
INSERT INTO `device` VALUES ('86', '10200070', '102', '终端70', 'TI', 'CC2530', null, '2', '1200240001');
INSERT INTO `device` VALUES ('87', '10200071', '102', '终端71', 'TI', 'CC2530', null, '2', '1200240001');
INSERT INTO `device` VALUES ('88', '10200072', '102', '终端72', 'TI', 'CC2530', null, '2', '1200240001');
INSERT INTO `device` VALUES ('89', '10200073', '102', '终端73', 'TI', 'CC2530', null, '2', '1200240001');
INSERT INTO `device` VALUES ('90', '10200074', '102', '终端74', 'TI', 'CC2530', null, '2', '1200240001');
INSERT INTO `device` VALUES ('91', '10200075', '102', '终端75', 'TI', 'CC2530', null, '2', '1200240001');
INSERT INTO `device` VALUES ('92', '10200076', '102', '终端76', 'TI', 'CC2530', null, '2', '1200240001');
INSERT INTO `device` VALUES ('93', '10200077', '102', '终端77', 'TI', 'CC2530', null, '2', '1200240001');
INSERT INTO `device` VALUES ('94', '10200078', '102', '终端78', 'TI', 'CC2530', null, '2', '1200240001');
INSERT INTO `device` VALUES ('95', '10200079', '102', '终端79', 'TI', 'CC2530', null, '2', '1200240001');
INSERT INTO `device` VALUES ('96', '10200080', '102', '终端80', 'TI', 'CC2530', null, '2', '1200240001');
INSERT INTO `device` VALUES ('97', '10200081', '102', '终端81', 'TI', 'CC2530', null, '2', '1200240001');
INSERT INTO `device` VALUES ('98', '10200082', '102', '终端82', 'TI', 'CC2530', null, '2', '1200240001');
INSERT INTO `device` VALUES ('99', '10200083', '102', '终端83', 'TI', 'CC2530', null, '2', '1200240001');
INSERT INTO `device` VALUES ('100', '10200084', '102', '终端84', 'TI', 'CC2530', null, '2', '1200240001');
INSERT INTO `device` VALUES ('101', '10200085', '102', '终端85', 'TI', 'CC2530', null, '2', '1200240001');
INSERT INTO `device` VALUES ('102', '10200086', '102', '终端86', 'TI', 'CC2530', null, '2', '1200240001');
INSERT INTO `device` VALUES ('103', '10200087', '102', '终端87', 'TI', 'CC2530', null, '2', '1200240001');
INSERT INTO `device` VALUES ('104', '10200088', '102', '终端88', 'TI', 'CC2530', null, '2', '1200240001');
INSERT INTO `device` VALUES ('105', '10200089', '102', '终端89', 'TI', 'CC2530', null, '2', '1200240001');
INSERT INTO `device` VALUES ('106', '10300010', '103', '路由器10', 'TI', 'CC2530', null, '2', '1200240001');

-- ----------------------------
-- Table structure for `greenhouse`
-- ----------------------------
DROP TABLE IF EXISTS `greenhouse`;
CREATE TABLE `greenhouse` (
  `uid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `id` int(10) unsigned NOT NULL,
  `type` tinyint(3) unsigned NOT NULL,
  `name` varchar(255) NOT NULL,
  `location` varchar(255) DEFAULT NULL,
  `gpsinfo` varchar(255) DEFAULT NULL,
  `dbname` varchar(255) DEFAULT NULL,
  `available` tinyint(3) unsigned DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of greenhouse
-- ----------------------------
INSERT INTO `greenhouse` VALUES ('1', '1200240001', '1', '闵行拱棚', '上海市闵行区东川路800号', '123456789', 'gh1200240001', '1');

-- ----------------------------
-- Table structure for `variety`
-- ----------------------------
DROP TABLE IF EXISTS `variety`;
CREATE TABLE `variety` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL,
  `brand` varchar(32) DEFAULT NULL,
  `unit` varchar(16) DEFAULT NULL,
  `available` tinyint(3) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of variety
-- ----------------------------
