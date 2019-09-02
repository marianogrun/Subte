-- phpMyAdmin SQL Dump
-- version 4.0.4.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 01-09-2017 a las 21:30:55
-- Versión del servidor: 5.5.32
-- Versión de PHP: 5.4.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `subte_b`
--
CREATE DATABASE IF NOT EXISTS `subte_b` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `subte_b`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estaciones`
--

CREATE TABLE IF NOT EXISTS `estaciones` (
  `Actual` varchar(26) NOT NULL,
  `Siguiente` varchar(26) NOT NULL,
  `Anterior` varchar(26) NOT NULL,
  `Comentario` varchar(90) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `estaciones`
--

INSERT INTO `estaciones` (`Actual`, `Siguiente`, `Anterior`, `Comentario`) VALUES
('Leandro N. Alem', 'Florida', 'No hay', ''),
('Florida', 'Carlos Pellegrini', 'Leandro N. Alem', ''),
('Carlos Pellegrini', 'Uruguay', 'Florida', 'Combinación con las líneas C (Retiro - Constitución) y D (Catedral - Congreso de Tucumán).'),
('Uruguay', 'Callao', 'Carlos Pellegrini', ''),
('Callao', 'Pasteur - AMIA', 'Uruguay', ''),
('Pasteur - AMIA', 'Pueyrredón', 'Callao', ''),
('Pueyrredón', 'Carlos Gardel', 'Pasteur - AMIA', 'Combinación con la línea H (Corrientes - Hospitales).'),
('Carlos Gardel', 'Medrano', 'Pueyrredón', ''),
('Medrano', 'Ángel Gallardo', 'Carlos Gardel', ''),
('Ángel Gallardo', 'Malabia - Osvaldo Pugliese', 'Medrano', ''),
('Malabia - Osvaldo Pugliese', 'Dorrego', 'Ángel Gallardo', ''),
('Dorrego', 'Federico Lacroze', 'Malabia - Osvaldo Pugliese', 'Acceso a la estación Chacarita del Ferrocarril General San Martín.'),
('Federico Lacroze', 'Tronador - Villa Ortúzar', 'Dorrego', 'Acceso a la estación Federico Lacroze del Ferrocarril Urquiza.'),
('Tronador - Villa Ortúzar', 'De los Incas - Parque Chas', 'Federico Lacroze', ''),
('De los Incas - Parque Chas', 'Echeverría', 'Tronador - Villa Ortúzar', ''),
('Echeverría', 'Juan Manuel de Rosas', 'De los Incas - Parque Chas', ''),
('Juan Manuel de Rosas', 'No hay', 'Echeverría', 'Acceso a la Estación General Urquiza del Ferrocarril Mitre.');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
