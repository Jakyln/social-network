CREATE DATABASE IF NOT EXISTS `socialnetwork`;

USE `socialnetwork`;

DELETE FROM chatgroup_user;
DELETE FROM friends;
DELETE FROM message;
DELETE FROM chatgroup;
DELETE FROM socialnetwork.user;
DELETE FROM role;


DROP TABLE chatgroup_user;
DROP TABLE friends;
DROP TABLE message;
DROP TABLE chatgroup;
DROP TABLE socialnetwork.user;
DROP TABLE role;

CREATE TABLE IF NOT EXISTS `role`
(
    `id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `name` NVARCHAR(120)
    );

CREATE TABLE IF NOT EXISTS `user`
(
    `id` INT NOT NULL AUTO_INCREMENT,
    `username` NVARCHAR(160) NOT NULL,
    `password` NVARCHAR(160) NOT NULL,
    `mail` NVARCHAR(160) NOT NULL,
    `first_name` NVARCHAR(160) NOT NULL,
    `last_name` NVARCHAR(160) NOT NULL,
    `birth_date` DATE NOT NULL,
    `zip_code` NVARCHAR(160) NOT NULL,
    `address` NVARCHAR(160) NOT NULL,
    `bio` NVARCHAR(160) NOT NULL,
    `relationship` NVARCHAR(160) NOT NULL,
    `login_date` DATETIME,
    `status` NVARCHAR(160),
    `role_id` INT,
    CONSTRAINT `PK_user` PRIMARY KEY  (`id`)
);

CREATE TABLE IF NOT EXISTS `chatgroup`
(
    `id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `name` NVARCHAR(120) DEFAULT NULL
    );


CREATE TABLE IF NOT EXISTS `message`
(
    `id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `text` NVARCHAR(120),
    `message_date` DATETIME,
    `chatgroup_id` INT NOT NULL,
    `user_sender_id` INT NOT NULL
);


CREATE TABLE IF NOT EXISTS `friends`
(
    `id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `user_main` INT(255),
    `user_friend` INT(255),
    CONSTRAINT user_friends UNIQUE (user_main,user_friend)
    );

CREATE TABLE `chatgroup_user` (
    `id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `user_id` INT REFERENCES `user` (`id`),
    `chatgroup_id` INT REFERENCES `chatgroup` (`id`),
    CONSTRAINT user_friends UNIQUE (user_id,chatgroup_id)
);


ALTER TABLE `friends` ADD CONSTRAINT `FK_userfriend1`
    FOREIGN KEY (`user_main`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `friends` ADD CONSTRAINT `FK_userfriend2`
    FOREIGN KEY (`user_friend`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `chatgroup_user` ADD CONSTRAINT `FK_chatgroup_user`
    FOREIGN KEY (`chatgroup_id`) REFERENCES `chatgroup` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `message` ADD CONSTRAINT `FK_message_chatgroup_id`
    FOREIGN KEY (`chatgroup_id`) REFERENCES `chatgroup` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `message` ADD CONSTRAINT `FK_user_id`
    FOREIGN KEY (`user_sender_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `chatgroup_user` ADD CONSTRAINT `FK_user_chat_id`
    FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `chatgroup_user` ADD CONSTRAINT `FK_chatgroup_id`
    FOREIGN KEY (`chatgroup_id`) REFERENCES `chatgroup` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `friends` ADD CONSTRAINT `FK_user_main`
    FOREIGN KEY (`user_main`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `friends` ADD CONSTRAINT `FK_user_friend`
    FOREIGN KEY (`user_friend`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `user` ADD CONSTRAINT `FK_user_role_id`
    FOREIGN KEY (`role_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;


INSERT INTO Role (name) VALUES ('ROLE_ADMIN');
INSERT INTO Role (name) VALUES ('ROLE_user');

INSERT INTO user(username, password, mail, first_name, last_name, birth_date, zip_code, address, bio, relationship,login_date,status,role_id) VALUES ('admin','$2a$10$bpNMKeaQXKpJ4JVxOHWvu.tZdmCLT9nKcZreJ/ELfCgmTCyhC7GPy','test@gmail.com','Tim','Smith','2000-07-17','11 random Street','69780','hello this is a bio','single','2022-02-13 13:00:00','online',1);
INSERT INTO user(username, password, mail, first_name, last_name, birth_date, zip_code, address, bio, relationship,login_date,status,role_id) VALUES ('user','$2a$10$TA.UfUqLa8uDeGkt95FfLeq7T5Y5vpDpzAtvJrHSLzLliY/PARXUq','test2@gmail.com','Marc','Ray','2005-02-15','05 random Avenue','69800','hello this is a bio2','in a relationship','2022-02-13 14:00:00','do not disturb',2);

INSERT INTO chatgroup(name) VALUES ('The Awesome Twins');

INSERT INTO message(text, message_date, chatgroup_id, user_sender_id) VALUES ('Hey Salut Marc !','2022-02-13 13:00:00','1','1');
INSERT INTO message(text, message_date, chatgroup_id, user_sender_id) VALUES ('Salut Tim!','2022-02-13 14:00:00','1','2');
INSERT INTO message(text, message_date, chatgroup_id, user_sender_id) VALUES ('Ca va ?','2022-02-13 15:00:00','1','1');
INSERT INTO message(text, message_date, chatgroup_id, user_sender_id) VALUES ('Ouais !','2022-02-13 16:00:00','1','2');

INSERT INTO chatgroup_user(user_id,chatgroup_id) VALUES (1,1);
INSERT INTO chatgroup_user(user_id,chatgroup_id) VALUES (2,1);

INSERT INTO friends(user_main,user_friend) VALUES (1,2);



/*INSERT INTO public.user (id, first_name, last_name, email, password, username, role_id) VALUES (1, 'Admin', 'Admin','admin@gmail.com', '$2a$10$bpNMKeaQXKpJ4JVxOHWvu.tZdmCLT9nKcZreJ/ELfCgmTCyhC7GPy', 'admin', 1);
INSERT INTO public.user (id, first_name, last_name, email, password, username, role_id) VALUES (2, 'user', 'user','user@gmail.com','$2a$10$TA.UfUqLa8uDeGkt95FfLeq7T5Y5vpDpzAtvJrHSLzLliY/PARXUq', 'user', 2)*/

-- INSERT INTO friends(user_sender_id,userReceiver_id) VALUES (2,1); un user peut mettre en ami plusieurs fois le même, a corriger
