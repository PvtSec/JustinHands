-- phpMyAdmin SQL Dump
-- version 4.9.4
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Feb 03, 2020 at 07:27 AM
-- Server version: 10.3.16-MariaDB
-- PHP Version: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `id10796925_gecwapi`
--

-- --------------------------------------------------------

--
-- Table structure for table `Student_Creds`
--

CREATE TABLE `Student_Creds` (
  `id` int(11) NOT NULL,
  `Name` varchar(100) NOT NULL,
  `Student_ID` varchar(100) NOT NULL,
  `Department` varchar(100) NOT NULL,
  `Password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Student_Creds`
--

INSERT INTO `Student_Creds` (`id`, `Name`, `Student_ID`, `Department`, `Password`) VALUES
(4, 'pvtsec', 'PVTSEC', 'E.C.E', '68fb3c03946a6fbb78b8e6b4f291eff4'),
(12, 'Rohit', 'ROHTIBF', 'C.S.E', '4d4cf4d73c2b50ede4c748a3b1b82883');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Student_Creds`
--
ALTER TABLE `Student_Creds`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Student_Creds`
--
ALTER TABLE `Student_Creds`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
