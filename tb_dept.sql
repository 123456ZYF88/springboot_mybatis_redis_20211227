/*
 Navicat Premium Data Transfer

 Source Server         : 第一个
 Source Server Type    : MySQL
 Source Server Version : 80026
 Source Host           : localhost:3306
 Source Schema         : tab_account

 Target Server Type    : MySQL
 Target Server Version : 80026
 File Encoding         : 65001

 Date: 28/12/2021 16:02:30
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_dept
-- ----------------------------
DROP TABLE IF EXISTS `tb_dept`;
CREATE TABLE `tb_dept`  (
  `deptno` int NOT NULL AUTO_INCREMENT,
  `dname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门名称',
  `loc` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门位置',
  PRIMARY KEY (`deptno`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 76 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_dept
-- ----------------------------
INSERT INTO `tb_dept` VALUES (20, '67', 'zz11');
INSERT INTO `tb_dept` VALUES (30, '开发3部', 'zz11');
INSERT INTO `tb_dept` VALUES (40, '开发111', 'zz444');
INSERT INTO `tb_dept` VALUES (50, '开发55部', 'zz55');
INSERT INTO `tb_dept` VALUES (55, '开发70部', '南阳');
INSERT INTO `tb_dept` VALUES (62, 'dev70', '郑州');
INSERT INTO `tb_dept` VALUES (63, 'dev70', '郑州');
INSERT INTO `tb_dept` VALUES (64, 'dev70', '郑州');
INSERT INTO `tb_dept` VALUES (65, 'dev70', '郑州');
INSERT INTO `tb_dept` VALUES (66, 'dev70', '郑州');
INSERT INTO `tb_dept` VALUES (67, '开发6部', '6楼');
INSERT INTO `tb_dept` VALUES (70, '开发11部', '11楼');
INSERT INTO `tb_dept` VALUES (71, '开发11部', '11楼');
INSERT INTO `tb_dept` VALUES (73, '开发11部', '11楼');
INSERT INTO `tb_dept` VALUES (75, '66', '9999');
INSERT INTO `tb_dept` VALUES (77, '990099', '1100011100');
INSERT INTO `tb_dept` VALUES (78, '990099', '1100011100');

SET FOREIGN_KEY_CHECKS = 1;
