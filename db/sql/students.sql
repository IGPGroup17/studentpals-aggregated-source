CREATE DATABASE IF NOT EXISTS `students`;

USE `students`;

CREATE TABLE IF NOT EXISTS `students_info`
(
  `profile_id` varchar(32) PRIMARY KEY NOT NULL,
  `username` varchar(64) NOT NULL,
  `realname` varchar(64),
  `age` int NOT NULL
);

CREATE TABLE IF NOT EXISTS `students_uni`
(
  `profile_id` varchar(32) NOT NULL PRIMARY KEY,
  `email` varchar(32) NOT NULL,
  `university` varchar(64) NOT NULL,
  `year` int,
  `course` varchar(64)
);
