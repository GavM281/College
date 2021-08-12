-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Apr 05, 2021 at 12:06 AM
-- Server version: 10.3.27-MariaDB-0+deb10u1
-- PHP Version: 7.3.27-1~deb10u1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cs230_u200315`
--

-- --------------------------------------------------------

--
-- Table structure for table `USERS`
--

CREATE TABLE `USERS` (
  `Title` varchar(10) NOT NULL,
  `FirstName` varchar(20) NOT NULL,
  `SurName` varchar(20) NOT NULL,
  `Email` varchar(30) NOT NULL,
  `Mobile` varchar(20) NOT NULL,
  `Address1` varchar(20) NOT NULL,
  `Address2` varchar(20) NOT NULL,
  `Town` varchar(20) NOT NULL,
  `County` varchar(20) NOT NULL,
  `Eircode` varchar(10) NOT NULL,
  `ShipAddress1` varchar(40) NOT NULL,
  `ShipAddress2` varchar(40) NOT NULL,
  `ShipTown` varchar(30) NOT NULL,
  `ShipCounty` varchar(30) NOT NULL,
  `ShipEircode` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `USERS`
--

INSERT INTO `USERS` (`Title`, `FirstName`, `SurName`, `Email`, `Mobile`, `Address1`, `Address2`, `Town`, `County`, `Eircode`, `ShipAddress1`, `ShipAddress2`, `ShipTown`, `ShipCounty`, `ShipEircode`) VALUES
('Dr', 'John', 'Doe', 'John.Doe@here.com', '12345', 'Main Street', '', 'Town', 'Kildare', 'a12 b345', 'Main Street', '', 'Town', 'Kildare', 'a12 b345'),
('Ms', 'Jane', 'Smith', 'Jane_Smith@here.com', '123456', 'house', 'street', 'town', 'county', 'q12 e12', 'house', 'street', 'town', 'county', 'q12 e12'),
('Mr', 'Joe', 'Bloggs', 'Joe@email.com', '567', 'Street', '', 'Town', 'County', 'Eircode', 'Street', '', 'Town', 'County', 'Eircode');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `USERS`
--
ALTER TABLE `USERS`
  ADD PRIMARY KEY (`Mobile`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
