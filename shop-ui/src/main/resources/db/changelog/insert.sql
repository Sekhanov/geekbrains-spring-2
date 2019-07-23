--liquibase formatted sql

--changeset skhanov:1-1
--comment insert user roles
INSERT INTO `users` VALUES (1,'admin','$2a$10$/z5jkuuGfN9nlynG3jhlS.YxvTjPniXS3eiQdjVp369jOdKHZKoCe','Sergey','Khanov','sekhanov@gmail.com'), (2, 'user', '$2a$10$ab8/UIVfC4cSCQgYWvbUluHKXmPxgLuxKJX7E5vGf3Qf.EaUn8Y6.', "Vasiliy", 'Pupkin', 'vashya@mail.ru'), (3, '1', '$2a$10$ZOfkJZQq9/TBQscSsQzgsO/ifmg7D7syBJm4kcf2yswXC.hxGyWZO','1','1','1');
INSERT INTO `roles` VALUES (1,'ROLE_ADMIN'), (2,'ROLE_USER');
INSERT INTO `users_roles` VALUES (1,1), (2,2), (3,1);


--changeset skhanov:1-2
--comment insert product
INSERT INTO `product_types` VALUES (1, 'Monitor'), (2, 'Keyboard'), (3, 'Mouse'), (4, 'Smartphone');
INSERT INTO `product_brands` VALUES (1, "LG"), (2, 'Defender'), (3, 'Samsung'), (4, 'DELL');
INSERT INTO `product_colors` VALUES(1, 'black'), (2, 'white'), (3, 'red'), (4, 'blue');
INSERT INTO `products` VALUES(1, '24MK600M-W' , 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Culpa eum tenetur magnam ab. Delectus aliquid iste, tempora deleniti nesciunt quidem voluptatem, provident fugit magnam esse ad. Cumque tenetur blanditiis est.', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Culpa eum tenetur magnam ab. Delectus aliquid iste, tempora deleniti nesciunt quidem voluptatem, provident fugit magnam esse ad. Cumque tenetur blanditiis est.
Voluptas aliquam laborum eaque autem corrupti incidunt, quam ab et eos! Doloribus hic repellendus cumque, deleniti soluta odio eius, molestias corrupti explicabo ad consequuntur vitae excepturi culpa in. Obcaecati, repellat!
Veritatis, est magni soluta molestiae, exercitationem ratione provident veniam, accusantium quia deserunt cumque sequi alias sit ducimus beatae voluptates distinctio dolores in placeat delectus quod vel cum pariatur. Eligendi, dignissimos.
Odit, autem odio dolorem assumenda aperiam similique ab labore fugiat ipsa officiis nisi, eaque id omnis accusamus pariatur officia ipsum dolor repellat modi voluptates veniam? Animi recusandae autem praesentium quod?
Architecto voluptas harum fuga beatae suscipit nemo, voluptatum neque. Facilis optio, ratione aut distinctio deleniti cum animi autem amet facere, veniam rerum est architecto, et minus at ducimus voluptate id!', 1000, 1, 1, 1);