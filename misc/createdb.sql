-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema Libreria
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Libreria
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Libreria` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `Libreria` ;

-- -----------------------------------------------------
-- Table `Libreria`.`Autore`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Libreria`.`Autore` ;

CREATE TABLE IF NOT EXISTS `Libreria`.`Autore` (
  `idAutore` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `cognome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idAutore`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Libreria`.`CasaEditrice`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Libreria`.`CasaEditrice` ;

CREATE TABLE IF NOT EXISTS `Libreria`.`CasaEditrice` (
  `idCasaEd` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `PIVA` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idCasaEd`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Libreria`.`Genere`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Libreria`.`Genere` ;

CREATE TABLE IF NOT EXISTS `Libreria`.`Genere` (
  `idGenere` INT NOT NULL AUTO_INCREMENT,
  `Genere` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idGenere`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Libreria`.`Libro`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Libreria`.`Libro` ;

CREATE TABLE IF NOT EXISTS `Libreria`.`Libro` (
  `idLibro` INT NOT NULL AUTO_INCREMENT,
  `titolo` VARCHAR(50) NOT NULL,
  `idAutore` INT NOT NULL,
  `idCasaEd` INT NOT NULL,
  `costo` DECIMAL NULL,
  `giacenza` INT NULL,
  `idGenere` INT NOT NULL,
  PRIMARY KEY (`idLibro`),
  INDEX `idAutore_idx` (`idAutore` ASC),
  INDEX `idCasaEd_idx` (`idCasaEd` ASC),
  INDEX `idGenere_idx` (`idGenere` ASC),
  CONSTRAINT `idAutore`
    FOREIGN KEY (`idAutore`)
    REFERENCES `Libreria`.`Autore` (`idAutore`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `idCasaEd`
    FOREIGN KEY (`idCasaEd`)
    REFERENCES `Libreria`.`CasaEditrice` (`idCasaEd`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `idGenere`
    FOREIGN KEY (`idGenere`)
    REFERENCES `Libreria`.`Genere` (`idGenere`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Libreria`.`Utente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Libreria`.`Utente` ;

CREATE TABLE IF NOT EXISTS `Libreria`.`Utente` (
  `idUtente` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `cognome` VARCHAR(45) NOT NULL,
  `codfisc` VARCHAR(16) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(256) NOT NULL,
  `tipo` INT NOT NULL,
  `citta` VARCHAR(15) NOT NULL,
  `provincia` VARCHAR(2) NOT NULL,
  `telefono` INT NOT NULL,
  `indirizzo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idUtente`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Libreria`.`Vendite`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Libreria`.`Vendite` ;

CREATE TABLE IF NOT EXISTS `Libreria`.`Vendite` (
  `idVendite` INT NOT NULL AUTO_INCREMENT,
  `idLibro` INT NOT NULL,
  `idUtente` INT NOT NULL,
  `data_vendita` DATE NOT NULL,
  PRIMARY KEY (`idVendite`),
  INDEX `idLibro_idx` (`idLibro` ASC),
  INDEX `idUtente_idx` (`idUtente` ASC),
  CONSTRAINT `idLibro`
    FOREIGN KEY (`idLibro`)
    REFERENCES `Libreria`.`Libro` (`idLibro`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idUtente`
    FOREIGN KEY (`idUtente`)
    REFERENCES `Libreria`.`Utente` (`idUtente`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Libreria`.`Richieste`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Libreria`.`Richieste` ;

CREATE TABLE IF NOT EXISTS `Libreria`.`Richieste` (
  `idRichieste` INT NOT NULL AUTO_INCREMENT,
  `idLibro` INT NOT NULL,
  `idUtente` INT NOT NULL,
  `ncopie` INT NOT NULL,
  PRIMARY KEY (`idRichieste`),
  INDEX `idLibro_idx` (`idLibro` ASC),
  INDEX `idUtente_idx` (`idUtente` ASC),
    FOREIGN KEY (`idLibro`)
    REFERENCES `Libreria`.`Libro` (`idLibro`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    FOREIGN KEY (`idUtente`)
    REFERENCES `Libreria`.`Utente` (`idUtente`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

CREATE USER 'libreria'@'localhost' IDENTIFIED BY 'libreria`';GRANT USAGE ON *.* TO 'libreria'@'localhost' IDENTIFIED BY 'libreria' WITH MAX_QUERIES_PER_HOUR 0 MAX_CONNECTIONS_PER_HOUR 0 MAX_UPDATES_PER_HOUR 0 MAX_USER_CONNECTIONS 0;GRANT ALL PRIVILEGES ON `libreria`.* TO 'libreria'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
