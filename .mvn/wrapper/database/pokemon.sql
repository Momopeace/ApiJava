CREATE DATABASE IF NOT EXISTS Pokemon;

USE Pokemon;

DROP TABLE IF EXISTS Pokemon;

CREATE TABLE Pokemon(
   `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(40) NOT NULL,
  `genre` VARCHAR(40) NOT NULL,
    PRIMARY KEY (`id`)
   
);