-- ----------------------------
--  Table structure for `CATEGORY`
-- ----------------------------
DROP TABLE IF EXISTS `CATEGORY`;
CREATE TABLE `CATEGORY` (
  `sub_category_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(15) COLLATE utf8_vietnamese_ci NOT NULL,
  `status` tinyint(1) NOT NULL,
  `category_id` int(11) DEFAULT NULL,
  `url` varchar(15) COLLATE utf8_vietnamese_ci NOT NULL,
  `create_date` datetime DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;
----------------------PERMISSION
DROP TABLE IF EXISTS `PERMISSION`;
CREATE TABLE `PERMISSION` (
  `id` int(11) NOT NULL,
  `permission` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 


-- ----------------------------
--  Table structure for `CUSTOMER`
-- ----------------------------
DROP TABLE IF EXISTS `CUSTOMER`;
CREATE TABLE `CUSTOMER` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) COLLATE utf8_vietnamese_ci NOT NULL,
  `email` varchar(30) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `password` varchar(30) text DEFAULT NULL,
  `registration_date` date NOT NULL,
  `permission_id` int(11) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  'address' text COLLATE utf8_vietnamese_ci DEFAULT NULL,
  'phone_number' varchar(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `permission_id` (`permission_id`),
  CONSTRAINT `permission` FOREIGN KEY (`permission_id`) REFERENCES `PERMISSION` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;


INSERT INTO PERMISSION values(1,'ADMIN',now(), null);
INSERT INTO PERMISSION values(2,'USER',now(), null);
insert into CUSTOMER (name, email, password,address, phone_number, permission_id, create_date) values ('admin','tranthuy0696@gmail.com','$2a$10$2uF6.A.foJ9imeSFyLcMSuYp0/PGkimzcfAcECdEuMQzbxy6L3gUu','THU DUC','01659552922',1,now());

