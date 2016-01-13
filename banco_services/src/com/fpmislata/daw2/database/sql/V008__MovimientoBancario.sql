
CREATE TABLE IF NOT EXISTS `movimientobancario` (
  `idMovimientoBancario` int(11) NOT NULL AUTO_INCREMENT,
  `tipo` varchar(9) DEFAULT NULL,
  `concepto` varchar(255) DEFAULT NULL,
  `cantidad` decimal(10,2) DEFAULT NULL,
  `fecha` datetime DEFAULT NULL,
  `idCuentaBancaria` int(11) NOT NULL,
  PRIMARY KEY (`idMovimientoBancario`),
  INDEX `fk_idCuentaBancaria` (`idCuentaBancaria`),
  CONSTRAINT `fk_idCuentaBancaria` FOREIGN KEY (`idCuentaBancaria`) REFERENCES `cuentabancaria` (`idCuentaBancaria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
