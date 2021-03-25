-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 25-03-2021 a las 01:43:34
-- Versión del servidor: 10.4.17-MariaDB
-- Versión de PHP: 8.0.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `registro`
--

DELIMITER $$
--
-- Procedimientos
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_actualizar_correo` (IN `correoant` VARCHAR(5), `correonew` VARCHAR(20), `usuario` VARCHAR(30))  BEGIN
UPDATE usuari SET correo =fn_cambiar_mail (correoant,correonew,usuario)
WHERE usuario =  usuario;

END$$

--
-- Funciones
--
CREATE DEFINER=`root`@`localhost` FUNCTION `fn_cambiar_mail` (`correoant` VARCHAR(20), `correonew` VARCHAR(20), `usuario` VARCHAR(30)) RETURNS VARCHAR(80) CHARSET utf8mb4 BEGIN
DECLARE email VARCHAR(80)DEFAULT NULL;
UPDATE
    usuari
SET
    correo = REPLACE(correo,correoant,correonew)

WHERE usuario =  usuario LIMIT 1;
RETURN email;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comprador`
--

CREATE TABLE `comprador` (
  `ID_comprador` int(10) NOT NULL,
  `usuario` varchar(40) NOT NULL,
  `contrasena` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto_vendedor`
--

CREATE TABLE `producto_vendedor` (
  `ID_vendedor` int(11) NOT NULL,
  `ID_producto` int(11) NOT NULL,
  `nombre_producto` varchar(50) NOT NULL,
  `descripcion` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuari`
--

CREATE TABLE `usuari` (
  `id` int(10) NOT NULL,
  `usuario` varchar(30) DEFAULT NULL,
  `nombre` varchar(20) DEFAULT NULL,
  `apellido` varchar(20) DEFAULT NULL,
  `correo` varchar(20) DEFAULT NULL,
  `contrasena` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuari`
--

INSERT INTO `usuari` (`id`, `usuario`, `nombre`, `apellido`, `correo`, `contrasena`) VALUES
(1, 'anderson', 'anderson', 'triana', 'sas@gmail.com', '12345sa'),
(2, 'ansns', 'sas', 'saas', 'toon@gmail.com', 'sadd233'),
(3, 'gd', 'd', 'fd', 'fd@gmail.com', '122'),
(4, 'dv', 'df', 'fd', 'asas@gmail.com', '5U/ceSCub/RPhBOR5Q2iQg=='),
(5, 'ander', 'and', 'tri', 'as@gmail.com', '6inWY7fCt2wRNzYlKDC3Rg=='),
(6, 'asdds', 'as', 'dds', 'sas@gmail.com', 'WfMjTUGwmJ2e+EEOOn+eSQ=='),
(7, 'aaa', 'ssas', 'sd', 'dssdds@gmail.com', 'MIsvDxoVmSp+NdgrQdvwyw=='),
(8, 'ander', NULL, NULL, NULL, '6inWY7fCt2wRNzYlKDC3Rg=='),
(9, 'ander', NULL, NULL, NULL, '6inWY7fCt2wRNzYlKDC3Rg=='),
(10, 'ander', NULL, NULL, NULL, '6inWY7fCt2wRNzYlKDC3Rg=='),
(11, 'ander', NULL, NULL, NULL, '6inWY7fCt2wRNzYlKDC3Rg=='),
(12, 'aaa', NULL, NULL, NULL, 'MIsvDxoVmSp+NdgrQdvwyw=='),
(13, 'aaa', NULL, NULL, NULL, 'MIsvDxoVmSp+NdgrQdvwyw=='),
(14, 'panta', 'anderson', 'anderson', 'panta@gmail.com', '+cO+J29zpEQH/JKesb7igw=='),
(15, 'fsdf', 'dsf', 'df', 'df@gmail.com', 'AS1cUM7/zJ7g4gVELvvG/w=='),
(16, 'dssdds', 'sd', 'sdds', 'dsds@gmail.com', 'wT86B9FHdVjL83waYlzYdQ=='),
(17, 'anderson', 'as', 'as', 'dsds@gmail.com', 'YKqvs8AiazQgN3h1mRdXnA=='),
(18, 'ds', 'ds', 'sd', 'df@gmail.com', 'Oy/oAvfket47Worljm1t+Q=='),
(19, 'fd', 'df', 'fd', 'panta@gmail.com', '0IfwwWOhFN4z0tlBjWtWZw=='),
(21, 'panta', 'sas', 'sd', 'dssdds@gmail.com', 'Oy/oAvfket47Worljm1t+Q=='),
(22, 'fabiant', 'fabian', 'triana', '123@gmail.com', 'u7XZQC80vvqiWNHXkOdgOA==');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario_vendedor`
--

CREATE TABLE `usuario_vendedor` (
  `ID_vendedor` int(10) NOT NULL,
  `usuario` varchar(40) NOT NULL,
  `contrasena` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuuario`
--

CREATE TABLE `usuuario` (
  `usuario` int(50) NOT NULL,
  `nombre` int(40) NOT NULL,
  `apellido` int(50) NOT NULL,
  `contraseña` int(150) NOT NULL,
  `email` int(50) NOT NULL,
  `id` int(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `comprador`
--
ALTER TABLE `comprador`
  ADD PRIMARY KEY (`ID_comprador`);

--
-- Indices de la tabla `producto_vendedor`
--
ALTER TABLE `producto_vendedor`
  ADD PRIMARY KEY (`ID_vendedor`);

--
-- Indices de la tabla `usuari`
--
ALTER TABLE `usuari`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuario_vendedor`
--
ALTER TABLE `usuario_vendedor`
  ADD PRIMARY KEY (`ID_vendedor`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `usuari`
--
ALTER TABLE `usuari`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `comprador`
--
ALTER TABLE `comprador`
  ADD CONSTRAINT `comprador_ibfk_1` FOREIGN KEY (`ID_comprador`) REFERENCES `usuari` (`id`);

--
-- Filtros para la tabla `producto_vendedor`
--
ALTER TABLE `producto_vendedor`
  ADD CONSTRAINT `producto_vendedor_ibfk_1` FOREIGN KEY (`ID_vendedor`) REFERENCES `usuario_vendedor` (`ID_vendedor`);

--
-- Filtros para la tabla `usuario_vendedor`
--
ALTER TABLE `usuario_vendedor`
  ADD CONSTRAINT `usuario_vendedor_ibfk_1` FOREIGN KEY (`ID_vendedor`) REFERENCES `producto_vendedor` (`ID_vendedor`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
