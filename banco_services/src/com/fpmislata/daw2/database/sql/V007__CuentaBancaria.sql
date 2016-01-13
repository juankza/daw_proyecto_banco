
CREATE TABLE IF NOT EXISTS `cuentabancaria` (
  `idCuentaBancaria` int(11) NOT NULL,
  `saldo` decimal(10,2) DEFAULT NULL,
  `fechaCreacion` datetime DEFAULT NULL,
  `pin` varchar(4) DEFAULT NULL,
  `digitoControl` varchar(2) DEFAULT NULL,
  `numeroCuenta` varchar(10) DEFAULT NULL,
  `idSucursalBancaria` int(11) NOT NULL,
  `idUsuario` int(11) NOT NULL,
  PRIMARY KEY (`idCuentaBancaria`),
  UNIQUE KEY `numeroCuenta` (`numeroCuenta`),
  INDEX `fk_idSucursalBancaria` (`idSucursalBancaria`),
  INDEX `fk_idUsuario` (`idUsuario`),
  CONSTRAINT `fk_idSucursalBancaria` FOREIGN KEY (`idSucursalBancaria`) REFERENCES `sucursalbancaria` (`idSucursalBancaria`),
  CONSTRAINT `fk_idUsuario` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
