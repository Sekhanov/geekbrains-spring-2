--liquibase formatted sql

--changeset skhanov:1
--comment create security tables
CREATE TABLE `roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
);

CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(512) NOT NULL,
  `first_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
);

CREATE TABLE `users_roles` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`, `role_id`),
  CONSTRAINT `fk_users_roles_roles` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`),
  CONSTRAINT `fk_users_roles_users` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
);

--changeset skhanov:2
--comment fill security tables
INSERT INTO `users` VALUES (1,'admin','$2a$10$/z5jkuuGfN9nlynG3jhlS.YxvTjPniXS3eiQdjVp369jOdKHZKoCe','Sergey','Khanov','sekhanov@gmail.com'), (2, 'user', '$2a$10$ab8/UIVfC4cSCQgYWvbUluHKXmPxgLuxKJX7E5vGf3Qf.EaUn8Y6.', "Vasiliy", 'Pupkin', 'vashya@mail.ru');
INSERT INTO `roles` VALUES (1,'ROLE_ADMIN'), (2,'ROLE_USER');
INSERT INTO `users_roles` VALUES (1,1), (2,2);

--changeset skhanov:3
--comment create tables for goods
CREATE TABLE `goods_type` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`name` varchar(50) NOT NULL,
	PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
);

CREATE TABLE `goods_brand` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`name` varchar(50) NOT NULL,
	PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)	
);

CREATE TABLE `goods_color`(
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
);

CREATE TABLE `goods` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`model` varchar(100) NOT NULL,
`description` varchar(100),
`price` int(11) NOT NULL,
`image_link` varchar(512),
`goods_type_id` int(11) NOT NULL,
`goods_brand_id` int(11) NOT NULL,
`goods_color_id` int(11) NOT NULL,
PRIMARY KEY (`id`),
CONSTRAINT `fk_goods_type_goods` FOREIGN KEY (`goods_type_id`) REFERENCES `goods_type`(`id`),
CONSTRAINT `fk_goods_brand_goods` FOREIGN KEY (`goods_brand_id`) REFERENCES `goods_brand`(`id`),
CONSTRAINT `fk_goods_color_goods` FOREIGN KEY (`goods_color_id`) REFERENCES `goods_color` (`id`)
);

--changeset skhanov:4
--comment fill goods tables
INSERT INTO `goods_type` VALUES (1, 'monitor'), (2, 'keyboard'), (3, 'mouse');
INSERT INTO `goods_brand` VALUES (1, "LG"), (2, 'defender'), (3, 'samsung'), (4, 'DELL');
INSERT INTO `goods_color` VALUES(1, 'black'), (2, 'white');
INSERT INTO `goods` VALUES(1, 'DELL S2817Q' , 'some descr', 1000, null, 1, 4, 1);

