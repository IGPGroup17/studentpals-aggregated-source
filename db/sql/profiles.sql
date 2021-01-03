CREATE DATABASE IF NOT EXISTS `profiles`;

USE `profiles`;

CREATE TABLE IF NOT EXISTS `profiles_info`
(
  `profile_id` varchar(32) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `access_token` varchar(128) NOT NULL
);

CREATE TABLE IF NOT EXISTS `profiles_dates`
(
  `profile_id` varchar(32) PRIMARY KEY NOT NULL,
  `creation_date` datetime NOT NULL,
  `last_access_date` datetime NOT NULL
);
