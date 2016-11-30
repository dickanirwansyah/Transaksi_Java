-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema db_transaksi
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `db_transaksi` ;

-- -----------------------------------------------------
-- Schema db_transaksi
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `db_transaksi` DEFAULT CHARACTER SET utf8 ;
USE `db_transaksi` ;

-- -----------------------------------------------------
-- Table `db_transaksi`.`barang`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `db_transaksi`.`barang` ;

CREATE TABLE IF NOT EXISTS `db_transaksi`.`barang` (
  `kd_barang` VARCHAR(45) NOT NULL,
  `nama` VARCHAR(45) NOT NULL,
  `jumlah` INT NOT NULL,
  `harga` DOUBLE NOT NULL,
  PRIMARY KEY (`kd_barang`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_transaksi`.`transaksi`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `db_transaksi`.`transaksi` ;

CREATE TABLE IF NOT EXISTS `db_transaksi`.`transaksi` (
  `kd_transaksi` VARCHAR(45) NOT NULL,
  `tanggal` DATE NOT NULL,
  `karyawan` VARCHAR(45) NOT NULL,
  `total` DOUBLE NOT NULL,
  PRIMARY KEY (`kd_transaksi`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_transaksi`.`transaksi_detil`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `db_transaksi`.`transaksi_detil` ;

CREATE TABLE IF NOT EXISTS `db_transaksi`.`transaksi_detil` (
  `kd_transaksi` VARCHAR(45) NOT NULL,
  `kd_barang` VARCHAR(45) NOT NULL,
  `jumlah` INT NOT NULL,
  `harga` DOUBLE NOT NULL,
  PRIMARY KEY (`kd_transaksi`, `kd_barang`),
  INDEX `fk_transaksi_detil_b_idx` (`kd_barang` ASC),
  CONSTRAINT `fk_transaksi_detil_b`
    FOREIGN KEY (`kd_barang`)
    REFERENCES `db_transaksi`.`barang` (`kd_barang`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_transaksi_detil_t`
    FOREIGN KEY (`kd_transaksi`)
    REFERENCES `db_transaksi`.`transaksi` (`kd_transaksi`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
