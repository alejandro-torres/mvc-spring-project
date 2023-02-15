-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 15-02-2023 a las 20:37:17
-- Versión del servidor: 10.4.21-MariaDB
-- Versión de PHP: 8.0.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `trailers`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `film`
--

CREATE TABLE `film` (
  `id` int(11) NOT NULL,
  `cover` varchar(255) COLLATE utf8mb4_spanish2_ci DEFAULT NULL,
  `first_release` date DEFAULT NULL,
  `synopsis` varchar(255) COLLATE utf8mb4_spanish2_ci DEFAULT NULL,
  `title` varchar(255) COLLATE utf8mb4_spanish2_ci DEFAULT NULL,
  `trailer` varchar(255) COLLATE utf8mb4_spanish2_ci DEFAULT NULL,
  `fk_genre` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `genre`
--

CREATE TABLE `genre` (
  `id` int(11) NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_spanish2_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `role`
--

CREATE TABLE `role` (
  `id` bigint(20) NOT NULL,
  `Name` varchar(255) COLLATE utf8mb4_spanish2_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user`
--

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `email` varchar(255) COLLATE utf8mb4_spanish2_ci DEFAULT NULL,
  `firstName` varchar(255) COLLATE utf8mb4_spanish2_ci DEFAULT NULL,
  `lastName` varchar(255) COLLATE utf8mb4_spanish2_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8mb4_spanish2_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user_roles`
--

CREATE TABLE `user_roles` (
  `fk_user` bigint(20) NOT NULL,
  `fk_role` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `film`
--
ALTER TABLE `film`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK6nn6wn0lccwl03dev4sqt0pm7` (`fk_genre`);

--
-- Indices de la tabla `genre`
--
ALTER TABLE `genre`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `user_roles`
--
ALTER TABLE `user_roles`
  ADD KEY `FKrs9nh9i35rjijylkw68akst4m` (`fk_role`),
  ADD KEY `FK1pk85moy0xghl1ulodhuco17l` (`fk_user`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `film`
--
ALTER TABLE `film`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `genre`
--
ALTER TABLE `genre`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `role`
--
ALTER TABLE `role`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `user`
--
ALTER TABLE `user`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `film`
--
ALTER TABLE `film`
  ADD CONSTRAINT `FK6nn6wn0lccwl03dev4sqt0pm7` FOREIGN KEY (`fk_genre`) REFERENCES `genre` (`id`);

--
-- Filtros para la tabla `user_roles`
--
ALTER TABLE `user_roles`
  ADD CONSTRAINT `FK1pk85moy0xghl1ulodhuco17l` FOREIGN KEY (`fk_user`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FKrs9nh9i35rjijylkw68akst4m` FOREIGN KEY (`fk_role`) REFERENCES `role` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
