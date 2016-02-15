
CREATE TABLE IF NOT EXISTS `cuentabancaria` (
  `idCuentaBancaria` int(11) NOT NULL AUTO_INCREMENT,
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

INSERT IGNORE INTO `cuentabancaria` (`idCuentaBancaria`, `saldo`, `fechaCreacion`, `pin`, `digitoControl`, `numeroCuenta`, `idSucursalBancaria`, `idUsuario`) VALUES
    (3, 1000.00, '2015-07-25 12:00:00', '5313', '21', '0958741325', 3, 3),
    (4, 2000.00, '2015-08-25 12:00:00', '6424', '20', '0846084608', 4, 4),
    (5, 3000.00, '2015-09-25 12:00:00', '7535', '22', '6985123654', 5, 5),
(6, 1001193.00, '2016-02-14 01:00:00', '0846', '88', '0563987412', 4, 6);
