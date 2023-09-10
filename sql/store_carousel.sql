
CREATE DATABASE store_carousel;

USE store_carousel;

DROP TABLE IF EXISTS `carousel`;

CREATE TABLE `carousel` (
  `carousel_id` INT(11) NOT NULL AUTO_INCREMENT,
  `img_path` CHAR(50) NOT NULL,
  `describes` CHAR(50) NOT NULL,
  `product_id` INT(11) DEFAULT NULL COMMENT '广告关联的商品图片',
  `priority` INT DEFAULT 10 COMMENT '优先级',
  PRIMARY KEY (`carousel_id`)
) ENGINE=INNODB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `carousel` */

INSERT  INTO `carousel`(`carousel_id`,`img_path`,`describes`,`product_id`) VALUES (1,'public/imgs/cms_1.jpg','123456',1),(2,'public/imgs/cms_2.jpg','123456',2),(3,'public/imgs/cms_3.jpg','123456',3),(4,'public/imgs/cms_4.jpg','123456',4);
