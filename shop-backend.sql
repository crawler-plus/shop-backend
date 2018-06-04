/*
Navicat MySQL Data Transfer

Source Server         : mysql5.7
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : shop-backend

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-06-04 17:23:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_product`
-- ----------------------------
DROP TABLE IF EXISTS `t_product`;
CREATE TABLE `t_product` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `product_id` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '产品ID',
  `product_name` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '产品名称',
  `sale_price` int(11) DEFAULT NULL COMMENT '产品价格',
  `product_image` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '产品图片',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of t_product
-- ----------------------------
INSERT INTO `t_product` VALUES ('1', '201710003', '平衡车', '899', 'pingheng.jpg');
INSERT INTO `t_product` VALUES ('2', '201710004', '头戴式耳机-3', '80', '2.jpg');
INSERT INTO `t_product` VALUES ('3', '201710005', '小米笔记本', '3549', 'note.jpg');
INSERT INTO `t_product` VALUES ('4', '201710006', '小米6', '2499', 'mi6.jpg');
INSERT INTO `t_product` VALUES ('5', '201710002', '智能插线板', '59', '6.jpg');
INSERT INTO `t_product` VALUES ('6', '201710007', '自拍杆', '39', 'zipai.jpg');
INSERT INTO `t_product` VALUES ('7', '201710008', '小米净水器', '1999', '8.jpg');
INSERT INTO `t_product` VALUES ('8', '201710009', 'IH 电饭煲', '999', '9.jpg');
INSERT INTO `t_product` VALUES ('9', '201710010', '小米电视4A', '2099', '10.jpg');
INSERT INTO `t_product` VALUES ('10', '201710011', 'Ear1000', '1000', '11.jpg');
INSERT INTO `t_product` VALUES ('11', '201710012', 'Ear1100', '1100', '12.jpg');
INSERT INTO `t_product` VALUES ('12', '201710013', 'Ear2000', '2000', '13.jpg');
INSERT INTO `t_product` VALUES ('13', '201710014', 'Ear1600', '1600', '14.jpg');
INSERT INTO `t_product` VALUES ('14', '201710015', 'Ear1200', '1200', '15.jpg');
INSERT INTO `t_product` VALUES ('15', '201710016', 'Ear700', '700', '16.jpg');
INSERT INTO `t_product` VALUES ('16', '201710017', '小钢炮蓝牙音箱', '129', '1.jpg');
INSERT INTO `t_product` VALUES ('17', '201710018', '智能摄像机', '389', 'photo.jpg');
