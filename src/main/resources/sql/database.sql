-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema favourite_movie
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema favourite_movie
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `favourite_movie` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `favourite_movie` ;

-- -----------------------------------------------------
-- Table `favourite_movie`.`viewer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `favourite_movie`.`viewer` (
  `id_viewer` VARCHAR(20) NOT NULL,
  `user_name` VARCHAR(20) NULL DEFAULT NULL,
  `pass_word` VARCHAR(20) NULL DEFAULT NULL,
  `email` VARCHAR(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id_viewer`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `favourite_movie`.`movie`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `favourite_movie`.`movie` (
  `Id_movie` VARCHAR(20) NOT NULL,
  `name` VARCHAR(20) NULL DEFAULT NULL,
  `url_image` VARCHAR(100) NULL DEFAULT NULL,
  `year` INT NULL DEFAULT NULL,
  `type` VARCHAR(100) NULL DEFAULT NULL,
  `score` FLOAT NULL DEFAULT NULL,
  `status` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`Id_movie`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `favourite_movie`.`favourite_list`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `favourite_movie`.`favourite_list` (
  `id_viewer` VARCHAR(20) NOT NULL,
  `Id_movie` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`Id_movie`, `id_viewer`),
  INDEX `id_viewer` (`id_viewer` ASC) VISIBLE,
  CONSTRAINT `favourite_list_ibfk_1`
    FOREIGN KEY (`id_viewer`)
    REFERENCES `favourite_movie`.`viewer` (`id_viewer`),
  CONSTRAINT `favourite_list_ibfk_2`
    FOREIGN KEY (`Id_movie`)
    REFERENCES `favourite_movie`.`movie` (`Id_movie`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `favourite_movie`.`rank_board`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `favourite_movie`.`rank_board` (
  `STT` INT NOT NULL AUTO_INCREMENT,
  `view` FLOAT NULL DEFAULT NULL,
  `Id_movie` VARCHAR(20) NULL DEFAULT NULL,
  PRIMARY KEY (`STT`),
  INDEX `Id_movie` (`Id_movie` ASC) VISIBLE,
  CONSTRAINT `rank_board_ibfk_1`
    FOREIGN KEY (`Id_movie`)
    REFERENCES `favourite_movie`.`movie` (`Id_movie`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
