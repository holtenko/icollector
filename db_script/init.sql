-- ----------------------------
-- Table structure for `t_airhumidity`
-- ----------------------------
DROP TABLE IF EXISTS `t_airhumidity`;
CREATE TABLE `t_airhumidity` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '记录ID',
  `deviceid` int(11) unsigned NOT NULL COMMENT '设备ID',
  `sampletime` sampletime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录时间戳',
  `value` decimal(10,2) NOT NULL COMMENT '记录值',
  PRIMARY KEY (`id`),
  KEY `deviceid` (`deviceid`),
  CONSTRAINT `t_airhumidity_ibfk_1` FOREIGN KEY (`deviceid`) REFERENCES `device` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for `t_airtemp`
-- ----------------------------
DROP TABLE IF EXISTS `t_airtemp`;
CREATE TABLE `t_airtemp` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '记录ID',
  `deviceid` int(11) unsigned NOT NULL COMMENT '设备ID',
  `sampletime` sampletime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录时间戳',
  `value` decimal(10,2) NOT NULL COMMENT '记录值',
  PRIMARY KEY (`id`),
  KEY `deviceid` (`deviceid`),
  CONSTRAINT `t_airtemp_ibfk_1` FOREIGN KEY (`deviceid`) REFERENCES `device` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for `t_atmosphere`
-- ----------------------------
DROP TABLE IF EXISTS `t_atmosphere`;
CREATE TABLE `t_atmosphere` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '记录ID',
  `deviceid` int(11) unsigned NOT NULL COMMENT '设备ID',
  `sampletime` sampletime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录时间戳',
  `value` decimal(10,2) NOT NULL COMMENT '记录值',
  PRIMARY KEY (`id`),
  KEY `deviceid` (`deviceid`),
  CONSTRAINT `t_atmosphere_ibfk_1` FOREIGN KEY (`deviceid`) REFERENCES `device` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



-- ----------------------------
-- Table structure for `t_light`
-- ----------------------------
DROP TABLE IF EXISTS `t_light`;
CREATE TABLE `t_light` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '记录ID',
  `deviceid` int(11) unsigned NOT NULL COMMENT '设备ID',
  `sampletime` sampletime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录时间戳',
  `value` decimal(10,2) NOT NULL COMMENT '记录值',
  PRIMARY KEY (`id`),
  KEY `deviceid` (`deviceid`),
  CONSTRAINT `t_light_ibfk_1` FOREIGN KEY (`deviceid`) REFERENCES `device` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



-- ----------------------------
-- Table structure for `t_rainfall`
-- ----------------------------
DROP TABLE IF EXISTS `t_rainfall`;
CREATE TABLE `t_rainfall` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '记录ID',
  `deviceid` int(11) unsigned NOT NULL COMMENT '设备ID',
  `sampletime` sampletime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录时间戳',
  `value` decimal(10,2) NOT NULL COMMENT '记录值',
  PRIMARY KEY (`id`),
  KEY `deviceid` (`deviceid`),
  CONSTRAINT `t_rainfall_ibfk_1` FOREIGN KEY (`deviceid`) REFERENCES `device` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



-- ----------------------------
-- Table structure for `t_soilhumidity`
-- ----------------------------
DROP TABLE IF EXISTS `t_soilhumidity`;
CREATE TABLE `t_soilhumidity` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '记录ID',
  `deviceid` int(11) unsigned NOT NULL COMMENT '设备ID',
  `sampletime` sampletime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录时间戳',
  `value` decimal(10,2) NOT NULL COMMENT '记录值',
  PRIMARY KEY (`id`),
  KEY `deviceid` (`deviceid`),
  CONSTRAINT `t_soilhumidity_ibfk_1` FOREIGN KEY (`deviceid`) REFERENCES `device` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



-- ----------------------------
-- Table structure for `t_soiltemp`
-- ----------------------------
DROP TABLE IF EXISTS `t_soiltemp`;
CREATE TABLE `t_soiltemp` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '记录ID',
  `deviceid` int(11) unsigned NOT NULL COMMENT '设备ID',
  `sampletime` sampletime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录时间戳',
  `value` decimal(10,2) NOT NULL COMMENT '记录值',
  PRIMARY KEY (`id`),
  KEY `deviceid` (`deviceid`),
  CONSTRAINT `t_soiltemp_ibfk_1` FOREIGN KEY (`deviceid`) REFERENCES `device` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



-- ----------------------------
-- Table structure for `t_solar`
-- ----------------------------
DROP TABLE IF EXISTS `t_solar`;
CREATE TABLE `t_solar` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '记录ID',
  `deviceid` int(11) unsigned NOT NULL COMMENT '设备ID',
  `sampletime` sampletime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录时间戳',
  `value` decimal(10,2) NOT NULL COMMENT '记录值',
  PRIMARY KEY (`id`),
  KEY `deviceid` (`deviceid`),
  CONSTRAINT `t_solar_ibfk_1` FOREIGN KEY (`deviceid`) REFERENCES `device` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



-- ----------------------------
-- Table structure for `t_winddirect`
-- ----------------------------
DROP TABLE IF EXISTS `t_winddirect`;
CREATE TABLE `t_winddirect` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '记录ID',
  `deviceid` int(11) unsigned NOT NULL COMMENT '设备ID',
  `sampletime` sampletime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录时间戳',
  `value` decimal(10,2) NOT NULL COMMENT '记录值',
  PRIMARY KEY (`id`),
  KEY `deviceid` (`deviceid`),
  CONSTRAINT `t_winddirect_ibfk_1` FOREIGN KEY (`deviceid`) REFERENCES `device` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



-- ----------------------------
-- Table structure for `t_windspeed`
-- ----------------------------
DROP TABLE IF EXISTS `t_windspeed`;
CREATE TABLE `t_windspeed` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '记录ID',
  `deviceid` int(11) unsigned NOT NULL COMMENT '设备ID',
  `sampletime` sampletime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录时间戳',
  `value` decimal(10,2) NOT NULL COMMENT '记录值',
  PRIMARY KEY (`id`),
  KEY `deviceid` (`deviceid`),
  CONSTRAINT `t_windspeed_ibfk_1` FOREIGN KEY (`deviceid`) REFERENCES `device` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



-- ----------------------------
-- Table structure for `device`
-- ----------------------------
DROP TABLE IF EXISTS `device`;
CREATE TABLE `device` (
  `uid` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '设备ID',
  `id` int(11) unsigned NOT NULL COMMENT '设备编号，前3位表示设备类型，后6位标识设备编号',
  `type` tinyint(1) unsigned NOT NULL COMMENT '第一位1传感器，2控制器；后两位01传感器，02ZED，03路由器，04ZC，05气象站',
  `name` varchar(255) NOT NULL COMMENT '设备名称',
  `serialid` int(10) unsigned DEFAULT NULL COMMENT '对应串口ID',
  `greenhouseid` int(11) unsigned DEFAULT NULL COMMENT '所属温室ID',
  `brand` varchar(255) DEFAULT NULL COMMENT '设备品牌',
  `model` varchar(255) DEFAULT NULL COMMENT '设备型号',
  `available` tinyint(1) unsigned NOT NULL COMMENT '1表示可用，2表示使用中，3表示损坏',
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uid`),
  KEY `id` (`id`),
  KEY `greenhouseid` (`greenhouseid`),
  CONSTRAINT `device_ibfk_1` FOREIGN KEY (`greenhouseid`) REFERENCES `greenhouse` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of device
-- ----------------------------
INSERT INTO `device` VALUES ('1', '10400001', '104', '协调器1', '0', '10001001', 'TI', 'CC2530', '2', null);
INSERT INTO `device` VALUES ('2', '10300001', '103', '路由器1', '1', '10001001', 'TI', 'CC2530', '2', null);
INSERT INTO `device` VALUES ('3', '10300002', '103', '路由器2', '2', '10001001', 'TI', 'CC2530', '2', null);
INSERT INTO `device` VALUES ('4', '10300003', '103', '路由器3', '3', '10001001', 'TI', 'CC2530', '2', null);
INSERT INTO `device` VALUES ('5', '10300004', '103', '路由器4', '4', '10001001', 'TI', 'CC2530', '2', null);
INSERT INTO `device` VALUES ('12', '10300005', '103', '路由器5', '5', '10001001', 'TI', 'CC2530', '2', null);
INSERT INTO `device` VALUES ('13', '10300006', '103', '路由器6', '6', '10001001', 'TI', 'CC2530', '2', null);
INSERT INTO `device` VALUES ('14', '10300007', '103', '路由器7', '7', '10001001', 'TI', 'CC2530', '2', null);
INSERT INTO `device` VALUES ('15', '10300008', '103', '路由器8', '8', '10001001', 'TI', 'CC2530', '2', null);
INSERT INTO `device` VALUES ('16', '10300009', '103', '路由器9', '9', '10001001', 'TI', 'CC2530', '2', null);
INSERT INTO `device` VALUES ('17', '10200001', '102', '终端1', '10', '10001001', 'TI', 'CC2530', '2', null);
INSERT INTO `device` VALUES ('18', '10200002', '102', '终端2', '11', '10001001', 'TI', 'CC2530', '2', null);
INSERT INTO `device` VALUES ('19', '10200003', '102', '终端3', '12', '10001001', 'TI', 'CC2530', '2', null);
INSERT INTO `device` VALUES ('20', '10200004', '102', '终端4', '13', '10001001', 'TI', 'CC2530', '2', null);
INSERT INTO `device` VALUES ('21', '10200005', '102', '终端5', '14', '10001001', 'TI', 'CC2530', '2', null);
INSERT INTO `device` VALUES ('22', '10200006', '102', '终端6', '15', '10001001', 'TI', 'CC2530', '2', null);
INSERT INTO `device` VALUES ('23', '10200007', '102', '终端7', '16', '10001001', 'TI', 'CC2530', '2', null);
INSERT INTO `device` VALUES ('24', '10200008', '102', '终端8', '17', '10001001', 'TI', 'CC2530', '2', null);
INSERT INTO `device` VALUES ('25', '10200009', '102', '终端9', '18', '10001001', 'TI', 'CC2530', '2', null);
INSERT INTO `device` VALUES ('26', '10200010', '102', '终端10', '19', '10001001', 'TI', 'CC2530', '2', null);
INSERT INTO `device` VALUES ('27', '10200011', '102', '终端11', '20', '10001001', 'TI', 'CC2530', '2', null);
INSERT INTO `device` VALUES ('28', '10200012', '102', '终端12', '21', '10001001', 'TI', 'CC2530', '2', null);
INSERT INTO `device` VALUES ('29', '10200013', '102', '终端13', '22', '10001001', 'TI', 'CC2530', '2', null);
INSERT INTO `device` VALUES ('30', '10200014', '102', '终端14', '23', '10001001', 'TI', 'CC2530', '2', null);
INSERT INTO `device` VALUES ('31', '10200015', '102', '终端15', '24', '10001001', 'TI', 'CC2530', '2', null);
INSERT INTO `device` VALUES ('32', '10200016', '102', '终端16', '25', '10001001', 'TI', 'CC2530', '2', null);
INSERT INTO `device` VALUES ('33', '10200017', '102', '终端17', '26', '10001001', 'TI', 'CC2530', '2', null);
INSERT INTO `device` VALUES ('34', '10200018', '102', '终端18', '27', '10001001', 'TI', 'CC2530', '2', null);
INSERT INTO `device` VALUES ('35', '10200019', '102', '终端19', '28', '10001001', 'TI', 'CC2530', '2', null);
INSERT INTO `device` VALUES ('36', '10200020', '102', '终端20', '29', '10001001', 'TI', 'CC2530', '2', null);
INSERT INTO `device` VALUES ('37', '10200021', '102', '终端21', '30', '10001001', 'TI', 'CC2530', '2', null);
INSERT INTO `device` VALUES ('38', '10200022', '102', '终端22', '31', '10001001', 'TI', 'CC2530', '2', null);
INSERT INTO `device` VALUES ('39', '10200023', '102', '终端23', '32', '10001001', 'TI', 'CC2530', '2', null);
INSERT INTO `device` VALUES ('40', '10200024', '102', '终端24', '33', '10001001', 'TI', 'CC2530', '2', null);
INSERT INTO `device` VALUES ('41', '10200025', '102', '终端25', '34', '10001001', 'TI', 'CC2530', '2', null);
INSERT INTO `device` VALUES ('42', '10200026', '102', '终端26', '35', '10001001', 'TI', 'CC2530', '2', null);
INSERT INTO `device` VALUES ('43', '10200027', '102', '终端27', '36', '10001001', 'TI', 'CC2530', '2', null);
INSERT INTO `device` VALUES ('44', '10200028', '102', '终端28', '37', '10001001', 'TI', 'CC2530', '2', null);
INSERT INTO `device` VALUES ('45', '10200029', '102', '终端29', '38', '10001001', 'TI', 'CC2530', '2', null);
INSERT INTO `device` VALUES ('46', '10200030', '102', '终端30', '39', '10001001', 'TI', 'CC2530', '2', null);
INSERT INTO `device` VALUES ('47', '10500001', '105', '室外气象站1', null, '10001001', '智翔宇仪器', 'MULTI-6P', '2', null);
INSERT INTO `device` VALUES ('48', '10500002', '105', '室外太阳辐射1', null, '10001001', '智翔宇仪器', null, '2', null);

-- ----------------------------
-- Table structure for `greenhouse`
-- ----------------------------
DROP TABLE IF EXISTS `greenhouse`;
CREATE TABLE `greenhouse` (
  `uid` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '记录ID',
  `id` int(11) unsigned NOT NULL COMMENT '第一位温室类型，后四位地区编号，后三位温室编号。',
  `type` tinyint(1) unsigned NOT NULL COMMENT '1普通拱棚，2薄膜温室，3玻璃温室',
  `name` varchar(255) NOT NULL COMMENT '温室名称',
  `location` varchar(255) DEFAULT NULL COMMENT '精确到村',
  `gpsinfo` varchar(255) DEFAULT NULL COMMENT '温室GPS信息',
  `available` tinyint(1) unsigned NOT NULL COMMENT '1表示正常，2表示在建，3表示弃用',
  PRIMARY KEY (`uid`),
  KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of greenhouse
-- ----------------------------
INSERT INTO `greenhouse` VALUES ('1', '10001001', '1', '测试温室', '上海市崇明区', '123456789', '1');
