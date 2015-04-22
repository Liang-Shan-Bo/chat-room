/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50133
Source Host           : localhost:3306
Source Database       : chat_room

Target Server Type    : MYSQL
Target Server Version : 50133
File Encoding         : 65001

Date: 2014-09-29 20:13:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_channel`
-- ----------------------------
DROP TABLE IF EXISTS `t_channel`;
CREATE TABLE `t_channel` (
  `channel_id` tinyint(5) NOT NULL,
  `channel_name` varchar(50) NOT NULL,
  `user_count` int(5) NOT NULL DEFAULT '0',
  PRIMARY KEY (`channel_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_channel
-- ----------------------------
