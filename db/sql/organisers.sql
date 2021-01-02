CREATE DATABASE IF NOT EXISTS organisers;

USE organisers;

CREATE TABLE IF NOT EXISTS `organiser_info`
(
  `profile_id` varchar(32) PRIMARY KEY NOT NULL,
  `name` varchar(64) NOT NULL,
  `description` text,
  `photo_url` varchar(64)
);
