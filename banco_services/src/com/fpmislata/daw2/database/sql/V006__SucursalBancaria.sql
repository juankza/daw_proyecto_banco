
CREATE TABLE `sucursalbancaria` (
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
