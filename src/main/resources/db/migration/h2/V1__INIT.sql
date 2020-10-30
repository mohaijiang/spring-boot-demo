CREATE TABLE `t_order` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `amount` decimal(19,2) NOT NULL,
  `order_no` varchar(255) NOT NULL,
  `status` int NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `t_order_item` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `amount` decimal(19,2) NOT NULL,
  `item_name` varchar(255) NOT NULL,
  `piece` int NOT NULL,
  `price_per_piece` decimal(19,2) NOT NULL,
  `order_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ;

INSERT INTO `t_order` VALUES(1,1000.00,'20201111100001',0);
INSERT INTO `t_order` VALUES(2,2000.00,'20201111100002',0);
INSERT INTO `t_order` VALUES(3,3000.00,'20201111100003',1);
INSERT INTO `t_order` VALUES(4,4000.00,'20201111100004',1);
INSERT INTO `t_order_item` VALUES (1,1000.00,'某个商品名',2,500.00,1);


