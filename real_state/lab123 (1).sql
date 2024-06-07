-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 07, 2024 at 10:15 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `lab123`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `getproperty` (IN `description_param` VARCHAR(255))   BEGIN
    SELECT * FROM property WHERE description LIKE CONCAT('%', description_param, '%');
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `cid` int(11) NOT NULL,
  `type` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`cid`, `type`) VALUES
(5, 'land'),
(15, 'shop'),
(14, 'vela'),
(20, 'yy');

-- --------------------------------------------------------

--
-- Table structure for table `location`
--

CREATE TABLE `location` (
  `lid` int(11) NOT NULL,
  `city` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `location`
--

INSERT INTO `location` (`lid`, `city`) VALUES
(44, 'dukan'),
(45, 'halabja'),
(24, 'Hawler'),
(40, 'karkuk'),
(41, 'mahbad'),
(21, 'slemani'),
(39, 'soran');

-- --------------------------------------------------------

--
-- Table structure for table `property`
--

CREATE TABLE `property` (
  `pid` int(11) NOT NULL,
  `cid` int(11) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `lid` int(11) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `room` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `property`
--

INSERT INTO `property` (`pid`, `cid`, `description`, `image`, `lid`, `price`, `room`) VALUES
(19, 15, 'ddddd', 'https://img.freepik.com/free-photo/high-angle-pie-chart-with-cities_52683-98166.jpg?t=st=1717070499~exp=1717074099~hmac=46aca49859e3eea448c4af418aa775c302fc3d8d1ee2eec7f77774c323304138&w=900', 40, 55, 222),
(20, 15, 'eeeeeeeeeeee', 'https://img.freepik.com/free-photo/high-angle-pie-chart-with-cities_52683-98166.jpg?t=st=1717070499~exp=1717074099~hmac=46aca49859e3eea448c4af418aa775c302fc3d8d1ee2eec7f77774c323304138&w=900', 39, 55, 55),
(23, 5, 'eeeeeeeeeeee', 'https://img.freepik.com/free-photo/high-angle-pie-chart-with-cities_52683-98166.jpg?t=st=1717070499~exp=1717074099~hmac=46aca49859e3eea448c4af418aa775c302fc3d8d1ee2eec7f77774c323304138&w=900', 41, 22, 22),
(24, 5, 'eeeeeeeeeeee', 'https://img.freepik.com/free-photo/high-angle-pie-chart-with-cities_52683-98166.jpg?t=st=1717070499~exp=1717074099~hmac=46aca49859e3eea448c4af418aa775c302fc3d8d1ee2eec7f77774c323304138&w=900', 45, 22, 22),
(30, 15, 'eeeeeeeeeeee', 'https://images.unsplash.com/photo-1518780664697-55e3ad937233?q=80&w=1000&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8aG91c2V8ZW58MHx8MHx8fDA%3D', 40, 22, 22),
(31, 14, 'fdfdgfhgh', 'https://images.unsplash.com/photo-1518780664697-55e3ad937233?q=80&w=1000&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8aG91c2V8ZW58MHx8MHx8fDA%3D', 39, 222, 22);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`cid`),
  ADD UNIQUE KEY `type` (`type`);

--
-- Indexes for table `location`
--
ALTER TABLE `location`
  ADD PRIMARY KEY (`lid`),
  ADD UNIQUE KEY `city` (`city`);

--
-- Indexes for table `property`
--
ALTER TABLE `property`
  ADD PRIMARY KEY (`pid`),
  ADD KEY `lo_F` (`lid`),
  ADD KEY `ca_F` (`cid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `cid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT for table `location`
--
ALTER TABLE `location`
  MODIFY `lid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=50;

--
-- AUTO_INCREMENT for table `property`
--
ALTER TABLE `property`
  MODIFY `pid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `property`
--
ALTER TABLE `property`
  ADD CONSTRAINT `ca_F` FOREIGN KEY (`cid`) REFERENCES `category` (`cid`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `lo_F` FOREIGN KEY (`lid`) REFERENCES `location` (`lid`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
