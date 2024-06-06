
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;

SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

CREATE DATABASE IF NOT EXISTS `emarina` DEFAULT CHARACTER SET utf8;
USE `emarina`;

CREATE TABLE IF NOT EXISTS `Limiteamarre` (
  `id_limiteamarre` VARCHAR(36) NOT NULL ,
  `letra_amarre` VARCHAR(1) NOT NULL,
  `esloramax` DOUBLE NOT NULL,
  `mangamax` DOUBLE NOT NULL,
  PRIMARY KEY (`id_limiteamarre`)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb3;

CREATE TABLE IF NOT EXISTS `Amarre` (
  `letra` VARCHAR(1) NOT NULL,
  `numero` VARCHAR(2) NOT NULL,
  `limitesamarre_id` VARCHAR(36) NOT NULL,
  PRIMARY KEY (`letra`, `numero`),
  CONSTRAINT `fk_Amarre_Limitesamarres1`
    FOREIGN KEY (`limitesamarre_id`)
    REFERENCES `Limiteamarre` (`id_limiteamarre`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb3;

CREATE TABLE IF NOT EXISTS `Propietario` (
  `id_propietario` VARCHAR(36) NOT NULL ,
  `identificacion` VARCHAR(45) NOT NULL UNIQUE,
  `nombre` VARCHAR(45) NOT NULL,
  `apellidos` VARCHAR(45) NOT NULL,
  `fnacimiento` DATE NOT NULL,
  `telefono` INT NOT NULL,
  `nacionalidad` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_propietario`)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb3;

CREATE TABLE IF NOT EXISTS `Barco` (
  `id_barco` VARCHAR(36) NOT NULL,
  `matricula` VARCHAR(45) NOT NULL UNIQUE,
  `eslora` DOUBLE NOT NULL,
  `manga` DOUBLE NOT NULL,
  `propulsion` VARCHAR(45) NOT NULL,
  `iscatamaran` TINYINT(1) NOT NULL,
  `ocupantes` INT NOT NULL,
  `telefono_armador` INT NULL,
  `nacionalidad` VARCHAR(45) NOT NULL,
  `propietario_id` VARCHAR(36) NOT NULL,
  PRIMARY KEY (`id_barco`),
  CONSTRAINT `fk_Barco_Propietario`
    FOREIGN KEY (`propietario_id`)
    REFERENCES `Propietario` (`id_propietario`)
   ON DELETE NO ACTION
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb3;

CREATE TABLE IF NOT EXISTS `Reservaamarre` (
  `id_reservamarre` VARCHAR(36) NOT NULL ,
  `fechainicio` DATE NOT NULL,
  `fechafin` DATE NOT NULL,
  `amarre_letra` VARCHAR(1) NOT NULL, 
  `amarre_numero` VARCHAR(2) NOT NULL,
  `barco_id` VARCHAR(36) NOT NULL,
  PRIMARY KEY (`id_reservamarre`),
  CONSTRAINT `fk_reservasamarres_amarre1`
    FOREIGN KEY (`amarre_letra`, `amarre_numero`) 
    REFERENCES `Amarre` (`letra`, `numero`)      
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_reservasamarres_barco1`
    FOREIGN KEY (`barco_id`)
    REFERENCES `Barco` (`id_barco`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb3;


CREATE TABLE IF NOT EXISTS `Factura` (
  `id_factura` VARCHAR(36) NOT NULL,
  `precio` DOUBLE NOT NULL,
  `reserva_id` VARCHAR(36) NOT NULL,
  PRIMARY KEY (`id_factura`),
  CONSTRAINT `fk_factura_reservaamarre`
    FOREIGN KEY (`reserva_id`)
    REFERENCES `Reservaamarre` (`id_reservamarre`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb3;

CREATE TABLE IF NOT EXISTS `Pago` (
  `id_pago` VARCHAR(36) NOT NULL ,
  `factura_id` VARCHAR(36) NOT NULL,
  `metodopago` VARCHAR(45) NOT NULL,
  `fechapago` DATE NULL,
  PRIMARY KEY (`id_pago`),
  INDEX `fk_pagos_factura_idx` (`factura_id`),
  CONSTRAINT `fk_pagos_factura`
    FOREIGN KEY (`factura_id`)
    REFERENCES `Factura` (`id_factura`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb3;



INSERT INTO `Limiteamarre` (`id_limiteamarre`, `letra_amarre`, `esloramax`, `mangamax`) VALUES
(UUID(), 'A', 10.0, 3.5),
(UUID(), 'B', 15.0, 4.5),
(UUID(), 'C', 20.0, 5.5);


INSERT INTO `Amarre` (`letra`, `numero`, `limitesamarre_id`) VALUES
('A', '01', (SELECT id_limiteamarre FROM `Limiteamarre` WHERE `letra_amarre` = 'A')),
('A', '02', (SELECT id_limiteamarre FROM `Limiteamarre` WHERE `letra_amarre` = 'A')),
('B', '01', (SELECT id_limiteamarre FROM `Limiteamarre` WHERE `letra_amarre` = 'B')),
('B', '02', (SELECT id_limiteamarre FROM `Limiteamarre` WHERE `letra_amarre` = 'B')),
('C', '01', (SELECT id_limiteamarre FROM `Limiteamarre` WHERE `letra_amarre` = 'C'));


INSERT INTO `Propietario` (`id_propietario`, `identificacion`, `nombre`, `apellidos`, `fnacimiento`, `telefono`, `nacionalidad`) VALUES
(UUID(), '12345678A', 'Juan', 'Pérez', '1980-01-15', 600123456, 'ESPAÑOLA'),
(UUID(), '87654321B', 'María', 'García', '1975-03-22', 600654321, 'ESPAÑOLA'),
(UUID(), '11223344C', 'Pedro', 'López', '1982-11-05', 600987654, 'ESPAÑOLA');


INSERT INTO `Barco` (`id_barco`, `matricula`, `eslora`, `manga`, `propulsion`, `iscatamaran`, `ocupantes`, `telefono_armador`, `nacionalidad`, `propietario_id`) VALUES
(UUID(), 'ABC123', 9.5, 3.0, 'Motor', 0, 6, 600123456, 'ESPAÑOLA', (SELECT id_propietario FROM `Propietario` WHERE `identificacion` = '12345678A')),
(UUID(), 'DEF456', 14.0, 4.0, 'Vela', 1, 8, 600654321, 'ESPAÑOLA', (SELECT id_propietario FROM `Propietario` WHERE `identificacion` = '87654321B')),
(UUID(), 'GHI789', 19.5, 5.0, 'Motor', 0, 10, 600987654, 'ESPAÑOLA', (SELECT id_propietario FROM `Propietario` WHERE `identificacion` = '11223344C'));


INSERT INTO `Reservaamarre` (`id_reservamarre`, `fechainicio`, `fechafin`, `amarre_letra`,`amarre_numero`, `barco_id`) VALUES
(UUID(), '2024-06-01', '2024-06-10', 'A', '01', (SELECT id_barco FROM `Barco` WHERE `matricula` = 'ABC123')),
(UUID(), '2024-06-11', '2024-06-20', 'B', '01', (SELECT id_barco FROM `Barco` WHERE `matricula` = 'DEF456')),
(UUID(), '2024-06-21', '2024-06-30', 'C', '01', (SELECT id_barco FROM `Barco` WHERE `matricula` = 'GHI789'));

INSERT INTO `Factura` (`id_factura`, `precio`, `reserva_id`) VALUES
(UUID(), 1000.0, (SELECT id_reservamarre FROM `Reservaamarre` WHERE `fechainicio` = '2024-06-01' AND `fechafin` = '2024-06-10')),
(UUID(), 1500.0, (SELECT id_reservamarre FROM `Reservaamarre` WHERE `fechainicio` = '2024-06-11' AND `fechafin` = '2024-06-20')),
(UUID(), 2000.0, (SELECT id_reservamarre FROM `Reservaamarre` WHERE `fechainicio` = '2024-06-21' AND `fechafin` = '2024-06-30'));

INSERT INTO `Pago` (`id_pago`, `factura_id`, `metodopago`, `fechapago`) VALUES
(UUID(), (SELECT id_factura FROM `Factura` WHERE `precio` = 1000.0), 'Tarjeta', '2024-06-05'),
(UUID(), (SELECT id_factura FROM `Factura` WHERE `precio` = 1500.0), 'Transferencia', '2024-06-15'),
(UUID(), (SELECT id_factura FROM `Factura` WHERE `precio` = 2000.0), 'Efectivo', '2024-06-25');