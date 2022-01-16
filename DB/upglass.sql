-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  Dim 16 jan. 2022 à 12:54
-- Version du serveur :  8.0.18
-- Version de PHP :  7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `upglass`
--

-- --------------------------------------------------------

--
-- Structure de la table `addresses`
--

DROP TABLE IF EXISTS `addresses`;
CREATE TABLE IF NOT EXISTS `addresses` (
  `id_address` int(11) NOT NULL AUTO_INCREMENT,
  `box` int(11) DEFAULT NULL,
  `number` int(11) NOT NULL,
  `street` varchar(255) NOT NULL,
  `id_city` int(11) NOT NULL,
  PRIMARY KEY (`id_address`),
  KEY `FK_addresses_id_city` (`id_city`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `address_users`
--

DROP TABLE IF EXISTS `address_users`;
CREATE TABLE IF NOT EXISTS `address_users` (
  `address_type` varchar(255) NOT NULL,
  `address` int(11) NOT NULL,
  `user` int(11) NOT NULL,
  PRIMARY KEY (`address`,`user`),
  KEY `FK_address_users_user` (`user`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `appointments`
--

DROP TABLE IF EXISTS `appointments`;
CREATE TABLE IF NOT EXISTS `appointments` (
  `id_appointment` int(11) NOT NULL AUTO_INCREMENT,
  `site` varchar(255) NOT NULL,
  PRIMARY KEY (`id_appointment`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `appointment_histories`
--

DROP TABLE IF EXISTS `appointment_histories`;
CREATE TABLE IF NOT EXISTS `appointment_histories` (
  `id_appointment_history` int(11) NOT NULL AUTO_INCREMENT,
  `begin_date_hours` datetime NOT NULL,
  `end_date_hours` datetime NOT NULL,
  `status` varchar(255) NOT NULL,
  `id_appointment` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  PRIMARY KEY (`id_appointment_history`),
  KEY `FK_appointment_histories_id_user` (`id_user`),
  KEY `FK_appointment_histories_id_appointment` (`id_appointment`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `billing_documents`
--

DROP TABLE IF EXISTS `billing_documents`;
CREATE TABLE IF NOT EXISTS `billing_documents` (
  `id_billingDocuments` int(11) NOT NULL AUTO_INCREMENT,
  `document_number` int(11) NOT NULL,
  `document_date` date NOT NULL,
  `mode_of_payement` varchar(255) DEFAULT NULL,
  `payed` tinyint(1) NOT NULL DEFAULT '0',
  `payement_date` date DEFAULT NULL,
  `id_cars` int(11) NOT NULL,
  `id_documentsType` int(11) NOT NULL,
  `id_order` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  PRIMARY KEY (`id_billingDocuments`),
  KEY `FK_billing_documents_id_user` (`id_user`),
  KEY `FK_billing_documents_id_cars` (`id_cars`),
  KEY `FK_billing_documents_id_order` (`id_order`),
  KEY `FK_billing_documents_id_documentsType` (`id_documentsType`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `billing_document_window`
--

DROP TABLE IF EXISTS `billing_document_window`;
CREATE TABLE IF NOT EXISTS `billing_document_window` (
  `operation_type` varchar(255) NOT NULL,
  `qty` int(11) NOT NULL,
  `unite_price` int(11) NOT NULL,
  `billing_documents` int(11) NOT NULL,
  `windows` int(11) NOT NULL,
  PRIMARY KEY (`billing_documents`,`windows`),
  KEY `FK_billing_document_window_windows` (`windows`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `body_shel_types`
--

DROP TABLE IF EXISTS `body_shel_types`;
CREATE TABLE IF NOT EXISTS `body_shel_types` (
  `id_body_shel_type` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(60) NOT NULL,
  PRIMARY KEY (`id_body_shel_type`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `body_shel_types`
--

INSERT INTO `body_shel_types` (`id_body_shel_type`, `name`) VALUES
(1, '4 portes');

-- --------------------------------------------------------

--
-- Structure de la table `brands`
--

DROP TABLE IF EXISTS `brands`;
CREATE TABLE IF NOT EXISTS `brands` (
  `id_brand` int(11) NOT NULL AUTO_INCREMENT,
  `brand_name` varchar(60) NOT NULL,
  PRIMARY KEY (`id_brand`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `brands`
--

INSERT INTO `brands` (`id_brand`, `brand_name`) VALUES
(1, 'Mercedes'),
(2, 'Bmw'),
(3, 'VW'),
(4, 'Nissan');

-- --------------------------------------------------------

--
-- Structure de la table `cars`
--

DROP TABLE IF EXISTS `cars`;
CREATE TABLE IF NOT EXISTS `cars` (
  `id_cars` int(11) NOT NULL AUTO_INCREMENT,
  `building_date` datetime NOT NULL,
  `car_plate` varchar(255) NOT NULL,
  `kilometers` float DEFAULT NULL,
  `vehicle_identification_number` varchar(255) NOT NULL,
  `id_model` int(11) NOT NULL,
  PRIMARY KEY (`id_cars`),
  KEY `FK_cars_id_model` (`id_model`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `cities`
--

DROP TABLE IF EXISTS `cities`;
CREATE TABLE IF NOT EXISTS `cities` (
  `id_city` int(11) NOT NULL AUTO_INCREMENT,
  `city_name` varchar(60) NOT NULL,
  `zip_code` int(11) NOT NULL,
  `id_country` int(11) NOT NULL,
  PRIMARY KEY (`id_city`),
  KEY `FK_cities_id_country` (`id_country`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `countries`
--

DROP TABLE IF EXISTS `countries`;
CREATE TABLE IF NOT EXISTS `countries` (
  `id_country` int(11) NOT NULL AUTO_INCREMENT,
  `country_name` varchar(60) NOT NULL,
  PRIMARY KEY (`id_country`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `documents_type`
--

DROP TABLE IF EXISTS `documents_type`;
CREATE TABLE IF NOT EXISTS `documents_type` (
  `id_documentsType` int(11) NOT NULL AUTO_INCREMENT,
  `document_type` varchar(255) NOT NULL,
  PRIMARY KEY (`id_documentsType`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `models`
--

DROP TABLE IF EXISTS `models`;
CREATE TABLE IF NOT EXISTS `models` (
  `id_model` int(11) NOT NULL AUTO_INCREMENT,
  `begin_date` datetime NOT NULL,
  `code` varchar(255) NOT NULL,
  `end_date` datetime NOT NULL,
  `model_name` varchar(255) NOT NULL,
  `id_body_shel_type` int(11) NOT NULL,
  `id_brand` int(11) NOT NULL,
  PRIMARY KEY (`id_model`),
  KEY `FK_models_id_body_shel_type` (`id_body_shel_type`),
  KEY `FK_models_id_brand` (`id_brand`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `models`
--

INSERT INTO `models` (`id_model`, `begin_date`, `code`, `end_date`, `model_name`, `id_body_shel_type`, `id_brand`) VALUES
(1, '1998-01-13 00:00:00', '1j', '2006-01-12 00:00:00', 'Golf 4', 1, 3);

-- --------------------------------------------------------

--
-- Structure de la table `options_windows`
--

DROP TABLE IF EXISTS `options_windows`;
CREATE TABLE IF NOT EXISTS `options_windows` (
  `id_optionsWindow` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id_optionsWindow`),
  UNIQUE KEY `name` (`name`)
) ENGINE=MyISAM AUTO_INCREMENT=103 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `options_windows`
--

INSERT INTO `options_windows` (`id_optionsWindow`, `name`) VALUES
(90, 'bbbb'),
(89, 'dfsdfsdf'),
(88, 'fjhgfghjfghj'),
(87, 'jjjjjjjjjjjj'),
(86, 'ghjghj'),
(85, 'option 200'),
(84, 'option 2'),
(83, 'option 1'),
(82, 'test24'),
(81, 'test23'),
(80, 'test22'),
(79, 'test21'),
(78, 'test20'),
(77, 'test19'),
(76, 'yyyyrty'),
(75, 'test18'),
(74, 'test17'),
(73, 'test16'),
(72, 'test15'),
(71, 'test14'),
(70, 'test13'),
(69, 'test12'),
(68, 'test11'),
(67, 'ttt'),
(66, 'test10'),
(65, 'test9'),
(64, 'test8'),
(63, 'test7'),
(62, 'test6'),
(61, 'test5'),
(60, 'test3'),
(59, 'test2'),
(58, 'test1'),
(57, 'test'),
(91, 'gggggggg'),
(92, 'gggg'),
(93, 'hhhh'),
(94, 'gfhdfhdfgh'),
(95, 'sdfqsdfq'),
(96, 'dfgdg'),
(97, 'fsdf'),
(98, 'sdffffff'),
(99, 'dfgdfg'),
(100, 'fghfh'),
(101, 'ggggg'),
(102, 'jjjjj');

-- --------------------------------------------------------

--
-- Structure de la table `orders`
--

DROP TABLE IF EXISTS `orders`;
CREATE TABLE IF NOT EXISTS `orders` (
  `id_order` int(11) NOT NULL AUTO_INCREMENT,
  `billed` tinyint(1) NOT NULL DEFAULT '0',
  `sale_price` int(11) NOT NULL,
  `id_appointment` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  PRIMARY KEY (`id_order`),
  KEY `FK_orders_id_user` (`id_user`),
  KEY `FK_orders_id_appointment` (`id_appointment`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `payment_methods`
--

DROP TABLE IF EXISTS `payment_methods`;
CREATE TABLE IF NOT EXISTS `payment_methods` (
  `id_payment_method` int(11) NOT NULL AUTO_INCREMENT,
  `nbr_day_mode` varchar(50) NOT NULL,
  `professional_discount` varchar(50) NOT NULL,
  `id_user` int(11) NOT NULL,
  PRIMARY KEY (`id_payment_method`),
  KEY `FK_payment_methods_id_user` (`id_user`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `permissions`
--

DROP TABLE IF EXISTS `permissions`;
CREATE TABLE IF NOT EXISTS `permissions` (
  `id_permission` int(11) NOT NULL AUTO_INCREMENT,
  `permission_name` varchar(50) NOT NULL,
  PRIMARY KEY (`id_permission`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `roles`
--

DROP TABLE IF EXISTS `roles`;
CREATE TABLE IF NOT EXISTS `roles` (
  `id_role` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(50) NOT NULL,
  PRIMARY KEY (`id_role`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `role_permissions`
--

DROP TABLE IF EXISTS `role_permissions`;
CREATE TABLE IF NOT EXISTS `role_permissions` (
  `permission` int(11) NOT NULL,
  `role` int(11) NOT NULL,
  PRIMARY KEY (`permission`,`role`),
  KEY `FK_role_permissions_role` (`role`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `teams`
--

DROP TABLE IF EXISTS `teams`;
CREATE TABLE IF NOT EXISTS `teams` (
  `id_team` int(11) NOT NULL AUTO_INCREMENT,
  `team_name` varchar(60) NOT NULL,
  PRIMARY KEY (`id_team`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `id_user` int(11) NOT NULL AUTO_INCREMENT,
  `actif` tinyint(1) NOT NULL DEFAULT '0',
  `birthday` datetime DEFAULT NULL,
  `first_name` varchar(60) NOT NULL,
  `inscription_date` datetime NOT NULL,
  `last_name` varchar(60) NOT NULL,
  `login` varchar(60) NOT NULL,
  `mail` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `vat` varchar(20) DEFAULT NULL,
  `id_role` int(11) NOT NULL,
  `id_team` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_user`),
  KEY `FK_users_id_team` (`id_team`),
  KEY `FK_users_id_role` (`id_role`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `windows`
--

DROP TABLE IF EXISTS `windows`;
CREATE TABLE IF NOT EXISTS `windows` (
  `id_window` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `total_quantity` int(11) NOT NULL,
  `unit_sale_price` int(11) NOT NULL,
  `id_model` int(11) NOT NULL,
  `id_windowsType` int(11) NOT NULL,
  PRIMARY KEY (`id_window`),
  KEY `FK_windows_id_model` (`id_model`),
  KEY `FK_windows_id_windowsType` (`id_windowsType`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `windows`
--

INSERT INTO `windows` (`id_window`, `code`, `name`, `total_quantity`, `unit_sale_price`, `id_model`, `id_windowsType`) VALUES
(1, '1', 'test ref', 0, 0, 1, 1),
(2, '2', 'Test ref 2', 0, 200, 1, 1);

-- --------------------------------------------------------

--
-- Structure de la table `windows_options_windows`
--

DROP TABLE IF EXISTS `windows_options_windows`;
CREATE TABLE IF NOT EXISTS `windows_options_windows` (
  `options_windows` int(11) NOT NULL,
  `windows` int(11) NOT NULL,
  PRIMARY KEY (`options_windows`,`windows`),
  KEY `FK_windows_options_windows_windows` (`windows`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `windows_orders`
--

DROP TABLE IF EXISTS `windows_orders`;
CREATE TABLE IF NOT EXISTS `windows_orders` (
  `orders` int(11) NOT NULL,
  `windows` int(11) NOT NULL,
  PRIMARY KEY (`orders`,`windows`),
  KEY `FK_windows_orders_windows` (`windows`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `windows_types`
--

DROP TABLE IF EXISTS `windows_types`;
CREATE TABLE IF NOT EXISTS `windows_types` (
  `id_windowsType` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id_windowsType`)
) ENGINE=MyISAM AUTO_INCREMENT=53 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `windows_types`
--

INSERT INTO `windows_types` (`id_windowsType`, `name`) VALUES
(1, 'test'),
(2, 'test2'),
(3, 'test3'),
(4, 'test 4'),
(5, 'test4'),
(6, 'test5'),
(7, 'test 6'),
(8, 'test 7'),
(9, 'testttt'),
(10, 'testttthhh'),
(11, 'tesst'),
(12, 'fffddfd'),
(13, 'gffggggfggggffg'),
(14, 'testsss'),
(15, 'gfg'),
(16, 'fff'),
(17, 'ggg'),
(18, 'ggggg'),
(19, 'g'),
(20, 'gggffgddfg'),
(21, 'gggffgddfggdfg'),
(22, 'gggg'),
(23, 'hhhh'),
(24, 'tessss'),
(25, 'tetqsdf'),
(26, 'qsdfqsdf'),
(27, 'qsdfqsdff'),
(28, 'fffff'),
(29, 'f'),
(30, 'fg'),
(31, 'dfgdfgdfg'),
(32, 'gg'),
(33, 'testttttttt'),
(34, 'test10'),
(35, 'test11'),
(36, 'test15'),
(37, 'test 555'),
(38, 'type 1'),
(39, 'test 55'),
(40, 'test 556'),
(41, 'test 5567'),
(42, 'test 55678'),
(43, 'test22'),
(44, 'gfsgsdfg'),
(45, 'gsdfgsdfg'),
(46, 'hjfghj'),
(47, 'sdfgsdfg'),
(48, 'vg,ghj'),
(49, 'type 500'),
(50, 'test 1222'),
(51, 'gjfghjfghj'),
(52, 'gdgggggggg');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
