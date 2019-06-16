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
INSERT INTO `users` VALUES (1,'admin','{noop}admin',NULL,NULL,NULL), (2, 'user', '{noop}user', NULL, NULL, NULL);
INSERT INTO `roles` VALUES (1,'ROLE_ADMIN'), (2,'ROLE_USER');
INSERT INTO `users_roles` VALUES (1,1), (2,2);

--changeset skhanov:3
--comment create tables for goods
CREATE TABLE `good_type` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`name` varchar(50) NOT NULL,
	PRIMARY KEY (`id`)	
);

CREATE TABLE `good_brend` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`name` varchar(50) NOT NULL,
	PRIMARY KEY (`id`)	
);

CREATE TABLE `goods` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`model` varchar(100) NOT NULL,
`description` varchar(100) NOT NULL,
`price` varchar(11) NOT NULL,
`good_type_id` int(11) NOT NULL,
`good_brend_id` int(11) NOT NULL,
PRIMARY KEY (`id`),
CONSTRAINT `fk_good_type_goods` FOREIGN KEY (`good_type_id`) REFERENCES `good_type`(`id`),
CONSTRAINT `fk_goot_brend_goods` FOREIGN KEY (`good_brend_id`) REFERENCES `good_brend`(`id`)
);

--changeset skhanov:4
--comment fill good tables
INSERT INTO `good_type` VALUES (1, 'monitor'), (2, 'keyboard'), (3, 'mouse');
INSERT INTO `good_brend` VALUES (1, "LG"), (2, 'defender'), (3, 'samsung');

