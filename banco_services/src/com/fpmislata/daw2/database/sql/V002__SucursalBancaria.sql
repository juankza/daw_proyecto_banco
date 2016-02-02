
CREATE TABLE IF NOT EXISTS `sucursalbancaria` (
  `idSucursalBancaria` int(11) NOT NULL AUTO_INCREMENT,
  `codigoSucursalBancaria` varchar(4) DEFAULT NULL,
  `fechaCreacion` datetime DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `telefono` varchar(30) DEFAULT NULL,
  `idEntidadBancaria` int(11) NOT NULL,
  PRIMARY KEY (`idSucursalBancaria`),
  UNIQUE KEY `codigoSucursalBancaria` (`codigoSucursalBancaria`),
  INDEX `fk_entidadBancaria` (`idEntidadBancaria`),
  CONSTRAINT `fk_entidadBancaria` FOREIGN KEY (`idEntidadBancaria`) REFERENCES `entidadbancaria` (`idEntidadBancaria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT IGNORE INTO `sucursalbancaria` (`idSucursalBancaria`, `codigoSucursalBancaria`, `fechaCreacion`, `direccion`, `telefono`, `idEntidadBancaria`) VALUES
    (3, '8302', '2015-04-20 12:00:00', 'Calle Falsa, 123 - 28046 Madrid', '+34941585858', 3),
    (4, '9400', '2015-05-20 12:00:00', 'Calle Falsa, s/n - 28046 Madrid', '+34942686868', 4),
    (5, '2810', '2015-06-20 12:00:00', 'Calle Falsa, 321 - 28046 Madrid', '+34943787878', 5);
