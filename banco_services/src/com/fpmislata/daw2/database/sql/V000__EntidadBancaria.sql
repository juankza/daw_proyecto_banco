
CREATE TABLE IF NOT EXISTS `entidadbancaria` (
  `idEntidadBancaria` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  `codigoEntidadBancaria` varchar(4) DEFAULT NULL,
  `fechaCreacion` datetime DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `cif` varchar(9) DEFAULT NULL,
  PRIMARY KEY (`idEntidadBancaria`),
  UNIQUE KEY `nombre` (`nombre`),
  UNIQUE KEY `codigoEntidadBancaria` (`codigoEntidadBancaria`),
  UNIQUE KEY `cif` (`cif`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

INSERT IGNORE INTO `entidadbancaria` (`idEntidadBancaria`, `nombre`, `codigoEntidadBancaria`, `fechaCreacion`, `direccion`, `cif`) VALUES
	(3, 'prueba', '1111', '2015-01-20 13:55:46', 'prueba', 'prueba789'),
	(4, 'abc', '2222', '2015-02-20 00:00:00', 'abc', 'abc456789'),
	(5, 'banco', '3333', '2015-03-20 00:00:00', 'banco', 'banco6789');
