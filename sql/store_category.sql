

CREATE DATABASE store_category;

USE store_category;


DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
  `category_id` INT(11) NOT NULL AUTO_INCREMENT,
  `category_name` CHAR(20) NOT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=INNODB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `category` */

INSERT  INTO `category`(`category_id`,`category_name`) VALUES (1,'手机'),(2,'电视机'),(3,'空调'),(4,'洗衣机'),(5,'保护套'),(6,'保护膜'),(7,'充电器'),(8,'充电宝');
