SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account`
(
    `id`       int(10) UNSIGNED                                              NOT NULL AUTO_INCREMENT COMMENT '用户id',
    `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名',
    `balance`  decimal(10, 2)                                                NOT NULL COMMENT '账户余额',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE INDEX `unique_username` (`username`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 3
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account`
VALUES (1, 'tom', 100.00);
INSERT INTO `account`
VALUES (2, 'jack', 200.00);

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`
(
    `isbn`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
    `name`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
    `price` decimal(10, 2)                                                NOT NULL,
    PRIMARY KEY (`isbn`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book`
VALUES ('978-7-115-33383-4', 'Hive编程指南', 69.00);
INSERT INTO `book`
VALUES ('978-7-115-40309-4', 'Spark快速大数据分析', 59.00);
INSERT INTO `book`
VALUES ('978-7-302-46513-3', 'Hadoop权威指南', 148.00);

-- ----------------------------
-- Table structure for book_stock
-- ----------------------------
DROP TABLE IF EXISTS `book_stock`;
CREATE TABLE `book_stock`
(
    `isbn`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
    `stock` int(11)                                                       NULL DEFAULT NULL,
    PRIMARY KEY (`isbn`) USING BTREE,
    CONSTRAINT `fk_isbn` FOREIGN KEY (`isbn`) REFERENCES `book` (`isbn`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book_stock
-- ----------------------------
INSERT INTO `book_stock`
VALUES ('978-7-115-33383-4', 2);
INSERT INTO `book_stock`
VALUES ('978-7-115-40309-4', 5);
INSERT INTO `book_stock`
VALUES ('978-7-302-46513-3', 8);

SET FOREIGN_KEY_CHECKS = 1;
