
CREATE TABLE IF NOT EXISTS `movimientobancario` (
  `idMovimientoBancario` int(11) NOT NULL AUTO_INCREMENT,
  `tipo` varchar(9) DEFAULT NULL,
  `concepto` varchar(255) DEFAULT NULL,
  `cantidad` decimal(10,2) DEFAULT NULL,
  `saldo` decimal(10,2) DEFAULT NULL,
  `fecha` datetime DEFAULT NULL,
  `idCuentaBancaria` int(11) NOT NULL,
  PRIMARY KEY (`idMovimientoBancario`),
  INDEX `fk_idCuentaBancaria` (`idCuentaBancaria`),
  CONSTRAINT `fk_idCuentaBancaria` FOREIGN KEY (`idCuentaBancaria`) REFERENCES `cuentabancaria` (`idCuentaBancaria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT IGNORE INTO `movimientobancario` (`idMovimientoBancario`, `tipo`, `concepto`, `cantidad`, `saldo`, `fecha`, `idCuentaBancaria`) VALUES
    (3, 'INGRESO', 'Ingreso 1', 1000.00, 2000.00, '2015-09-05 12:00:00', 3),
    (4, 'INGRESO', 'Ingreso 1', 1000.00, 3000.00, '2015-09-05 12:00:00', 4),
    (5, 'INGRESO', 'Ingreso 1', 1000.00, 4000.00, '2015-09-05 12:00:00', 5),
    (6, 'DEDUCCION', 'Deducción 1', 500.00, 1500.00, '2015-10-10 12:00:00', 3),
    (7, 'DEDUCCION', 'Deducción 1', 500.00, 2500.00, '2015-10-10 12:00:00', 4),
    (8, 'DEDUCCION', 'Deducción 1', 500.00, 3500.00, '2015-10-10 12:00:00', 5);
