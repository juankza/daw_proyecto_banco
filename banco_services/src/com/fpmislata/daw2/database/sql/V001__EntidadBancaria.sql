
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT IGNORE INTO `entidadbancaria` (`idEntidadBancaria`, `nombre`, `codigoEntidadBancaria`, `fechaCreacion`, `direccion`, `cif`) VALUES
    (3, 'Bankia', '2038', '2015-01-15 12:00:00', 'Paseo de la Castellana, 189 - 28046 Madrid', 'A14010342'),
    (4, 'Santander', '0049', '2015-02-15 12:00:00', 'Avda de Cantabria, s/n - 28660 Boadilla del Monte', 'A39000013'),
    (5, 'Banco Bilbao Vizcaya Argentaria', '0182', '2015-03-15 12:00:00', 'Paseo de la Castellana, 81 - 28046 Madrid ', 'A48265169');
