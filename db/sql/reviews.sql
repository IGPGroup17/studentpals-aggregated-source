CREATE DATABASE IF NOT EXISTS `reviews`;

USE `reviews`;

CREATE TABLE IF NOT EXISTS `reviews_ids`
(
  `review_id` int PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `event_id` varchar(32) NOT NULL,
  `organiser_id` varchar(32) NOT NULL,
  `creator_id` varchar(32) NOT NULL,
);

CREATE TABLE IF NOT EXISTS `reviews_body`
(
  `review_id` int PRIMARY KEY NOT NULL,
  `rating` int NOT NULL,
  `description` mediumtext
);

CREATE TABLE IF NOT EXISTS `reviews_dates`
(
  `review_id` int PRIMARY KEY NOT NULL,
  `initial_review_date` datetime NOT NULL,
  `last_modified_date` datetime
);
