
CREATE TABLE IF NOT EXISTS `usuario` (
  `idUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  `apellidos` varchar(255) DEFAULT NULL,
  `dni` varchar(9) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `contrasena` varchar(255) DEFAULT NULL,
  `rol` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`idUsuario`),
  UNIQUE KEY `dni` (`dni`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `nickname` (`nickname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT IGNORE INTO `usuario` (`idUsuario`, `nombre`, `apellidos`, `dni`, `email`, `nickname`, `contrasena`, `rol`) VALUES
    (3, 'admin', 'admin', '23824980Q', 'admin@domain.com', 'admin', 'p8GAoFkhecQKX8c2YhysR+zInVWkkOZN', 'ADMIN'),
    (4, 'empleado', 'empleado', '73557374Q', 'empleado@domain.com', 'empleado', 'gTs5Pef8K6jEcDQeGEm7oFdJjbw9LZhc', 'EMPLEADO'),
    (5, 'cliente', 'cliente', '48689633J', 'cliente@domain.com', 'cliente', '4T5qxwjLwQcN2cVeDoMeK35r6XwEhjjL', 'CLIENTE');
