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
INSERT INTO `users` VALUES (1,'admin','$2a$10$/z5jkuuGfN9nlynG3jhlS.YxvTjPniXS3eiQdjVp369jOdKHZKoCe','Sergey','Khanov','sekhanov@gmail.com'), (2, 'user', '$2a$10$ab8/UIVfC4cSCQgYWvbUluHKXmPxgLuxKJX7E5vGf3Qf.EaUn8Y6.', "Vasiliy", 'Pupkin', 'vashya@mail.ru'), (3, '1', '$2a$10$ZOfkJZQq9/TBQscSsQzgsO/ifmg7D7syBJm4kcf2yswXC.hxGyWZO','1','1','1');
INSERT INTO `roles` VALUES (1,'ROLE_ADMIN'), (2,'ROLE_USER');
INSERT INTO `users_roles` VALUES (1,1), (2,2), (3,1);

--changeset skhanov:3
--comment create tables for product
CREATE TABLE `product_types` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`name` varchar(50) NOT NULL,
	PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
);

CREATE TABLE `product_brands` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`name` varchar(50) NOT NULL,
	PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)	
);

CREATE TABLE `product_colors`(
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
);

CREATE TABLE `products` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`model` varchar(100) NOT NULL,
`short_description` varchar(500),
`description` varchar(2000),
`price` int(11) NOT NULL,
`product_type_id` int(11) NOT NULL,
`product_brand_id` int(11) NOT NULL,
`product_color_id` int(11) NOT NULL,
PRIMARY KEY (`id`),
CONSTRAINT `fk_product_types_products` FOREIGN KEY (`product_type_id`) REFERENCES `product_types`(`id`),
CONSTRAINT `fk_product_brands_products` FOREIGN KEY (`product_brand_id`) REFERENCES `product_brands`(`id`),
CONSTRAINT `fk_product_colors_products` FOREIGN KEY (`product_color_id`) REFERENCES `product_colors` (`id`)
);

CREATE TABLE `pictures` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content_type` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `picture_data` mediumblob,
  PRIMARY KEY (`id`)
  );

  CREATE TABLE `products_pictures` (
`product_id` int(11) NOT NULL,
`picture_id` int(11) NOT NULL,
PRIMARY KEY (`product_id`, `picture_id`),
CONSTRAINT `if_product_pictures_product` FOREIGN KEY (`product_id`) REFERENCES `products`(`id`),
CONSTRAINT `fk_product_pictures_pictures` FOREIGN KEY (`picture_id`) REFERENCES `pictures`(`id`)
); 

--changeset skhanov:4
--comment fill product tables
INSERT INTO `product_types` VALUES (1, 'Monitor'), (2, 'Keyboard'), (3, 'Mouse'), (4, 'Smartphone');
INSERT INTO `product_brands` VALUES (1, "LG"), (2, 'Defender'), (3, 'Samsung'), (4, 'DELL');
INSERT INTO `product_colors` VALUES(1, 'black'), (2, 'white'), (3, 'red'), (4, 'blue');
INSERT INTO `products` VALUES(1, '24MK600M-W' , 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Culpa eum tenetur magnam ab. Delectus aliquid iste, tempora deleniti nesciunt quidem voluptatem, provident fugit magnam esse ad. Cumque tenetur blanditiis est.', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Culpa eum tenetur magnam ab. Delectus aliquid iste, tempora deleniti nesciunt quidem voluptatem, provident fugit magnam esse ad. Cumque tenetur blanditiis est.
Voluptas aliquam laborum eaque autem corrupti incidunt, quam ab et eos! Doloribus hic repellendus cumque, deleniti soluta odio eius, molestias corrupti explicabo ad consequuntur vitae excepturi culpa in. Obcaecati, repellat!
Veritatis, est magni soluta molestiae, exercitationem ratione provident veniam, accusantium quia deserunt cumque sequi alias sit ducimus beatae voluptates distinctio dolores in placeat delectus quod vel cum pariatur. Eligendi, dignissimos.
Odit, autem odio dolorem assumenda aperiam similique ab labore fugiat ipsa officiis nisi, eaque id omnis accusamus pariatur officia ipsum dolor repellat modi voluptates veniam? Animi recusandae autem praesentium quod?
Architecto voluptas harum fuga beatae suscipit nemo, voluptatum neque. Facilis optio, ratione aut distinctio deleniti cum animi autem amet facere, veniam rerum est architecto, et minus at ducimus voluptate id!', 1000, 1, 1, 1);


--changeset skhanov:5
--create table for orders
CREATE TABLE `orders` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`order_time` timestamp NOT NULL,
`user_id` int(11) NOT NULL,
PRIMARY KEY (`id`),
CONSTRAINT `fk_orders_users` FOREIGN KEY (`user_id`) REFERENCES `users`(`id`)
);

CREATE TABLE `order_items` (
  `id` int(11) NOT NUll AUTO_INCREMENT,
  `order_id` int(11) NOT NUll,
  `product_id` int(11) NOT NUll,
  `quantity` int(11) NOT NUll,
  PRIMARY KEY (`id`),
  CONSTRAINT `order_items_orders` FOREIGN KEY (`order_id`) REFERENCES `orders`(`id`),
  CONSTRAINT `order_items_products` FOREIGN KEY (`product_id`) REFERENCES
  `products`(`id`)
)
