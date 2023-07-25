-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 12, 2022 at 07:49 AM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.2.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `propertyrental`
--

-- --------------------------------------------------------

--
-- Table structure for table `amenitiestb`
--

CREATE TABLE `amenitiestb` (
  `AmenitiesId` int(11) NOT NULL,
  `Amenities` varchar(50) NOT NULL,
  `IsActive` int(11) NOT NULL DEFAULT 0,
  `CreateDate` datetime NOT NULL,
  `LastUpdate` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `amenitiestb`
--

INSERT INTO `amenitiestb` (`AmenitiesId`, `Amenities`, `IsActive`, `CreateDate`, `LastUpdate`) VALUES
(2, 'Swimming ', 0, '2022-05-05 20:44:13', '2022-05-05 20:45:15');

-- --------------------------------------------------------

--
-- Table structure for table `citytb`
--

CREATE TABLE `citytb` (
  `CityId` int(11) NOT NULL,
  `StateId` int(11) NOT NULL,
  `City` varchar(50) NOT NULL,
  `IsActive` int(11) NOT NULL DEFAULT 0,
  `CreateDate` datetime NOT NULL DEFAULT current_timestamp(),
  `LastUpdate` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `citytb`
--

INSERT INTO `citytb` (`CityId`, `StateId`, `City`, `IsActive`, `CreateDate`, `LastUpdate`) VALUES
(1, 1, 'Surat', 0, '2022-03-13 14:08:12', '2022-03-13 23:01:15'),
(3, 1, 'Vapi', 0, '2022-03-14 14:10:24', NULL),
(11, 1, 'Vadodara', 0, '2022-06-16 22:09:35', NULL),
(12, 3, 'Amritsar', 0, '2022-06-16 22:09:53', NULL),
(13, 3, 'Ludhiana', 0, '2022-06-16 22:10:03', NULL),
(14, 1, 'ahemdabad', 0, '2022-06-17 14:21:42', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `featurestb`
--

CREATE TABLE `featurestb` (
  `FeatureId` int(11) NOT NULL,
  `PropertyTypeId` int(11) NOT NULL,
  `Feature` varchar(50) NOT NULL,
  `IsActive` int(11) NOT NULL DEFAULT 0,
  `CreateDate` datetime NOT NULL DEFAULT current_timestamp(),
  `LastUpdate` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `featurestb`
--

INSERT INTO `featurestb` (`FeatureId`, `PropertyTypeId`, `Feature`, `IsActive`, `CreateDate`, `LastUpdate`) VALUES
(1, 4, 'Parking', 0, '2022-05-09 23:14:17', '2022-05-09 23:19:05'),
(2, 5, 'big pool', 0, '2022-06-15 12:58:56', '2022-06-15 09:28:33'),
(3, 5, 'gym', 0, '2022-06-15 12:59:28', '2022-06-15 09:29:13'),
(4, 4, 'Swimming pool', 0, '2022-06-15 22:58:25', NULL),
(5, 4, 'Garden', 0, '2022-06-15 22:58:35', NULL),
(6, 4, 'Play Ground', 0, '2022-06-15 22:58:45', NULL),
(7, 5, 'Community Hall', 0, '2022-06-15 22:59:35', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `featurevaluetb`
--

CREATE TABLE `featurevaluetb` (
  `FeatureValueId` int(11) NOT NULL,
  `FeatureId` int(11) NOT NULL,
  `Value` varchar(50) NOT NULL,
  `IsActive` int(11) NOT NULL DEFAULT 0,
  `CreateDate` int(11) NOT NULL DEFAULT current_timestamp(),
  `LastUpdate` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `featurevaluetb`
--

INSERT INTO `featurevaluetb` (`FeatureValueId`, `FeatureId`, `Value`, `IsActive`, `CreateDate`, `LastUpdate`) VALUES
(1, 1, '5000', 0, 1, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `grouptb`
--

CREATE TABLE `grouptb` (
  `GroupId` int(11) NOT NULL,
  `GroupName` varchar(50) NOT NULL,
  `IsActive` int(11) NOT NULL DEFAULT 0,
  `CreateDate` datetime NOT NULL DEFAULT current_timestamp(),
  `LastUpdate` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `grouptb`
--

INSERT INTO `grouptb` (`GroupId`, `GroupName`, `IsActive`, `CreateDate`, `LastUpdate`) VALUES
(2, 'Admin', 0, '2022-03-14 14:57:20', NULL),
(4, 'User', 0, '2022-05-08 11:54:49', NULL),
(5, 'Seller', 0, '2022-05-08 11:55:39', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `propertyamenitiestb`
--

CREATE TABLE `propertyamenitiestb` (
  `PropertyAmenitiesId` int(11) NOT NULL,
  `PropertyId` int(11) NOT NULL,
  `AmenitiesId` int(11) NOT NULL,
  `IsActive` int(11) NOT NULL DEFAULT 0,
  `CreateDate` datetime NOT NULL DEFAULT current_timestamp(),
  `LastUpdate` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `propertyamenitiestb`
--

INSERT INTO `propertyamenitiestb` (`PropertyAmenitiesId`, `PropertyId`, `AmenitiesId`, `IsActive`, `CreateDate`, `LastUpdate`) VALUES
(1, 1, 2, 0, '2022-05-11 19:08:10', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `propertyfeaturestb`
--

CREATE TABLE `propertyfeaturestb` (
  `PropertyFeatureId` int(11) NOT NULL,
  `PropertyId` int(11) NOT NULL,
  `FeatureId` int(11) NOT NULL,
  `FeatureValueId` int(11) DEFAULT NULL,
  `IsActive` int(11) NOT NULL DEFAULT 0,
  `CreateDate` datetime NOT NULL DEFAULT current_timestamp(),
  `LastUpdate` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `propertyfeaturestb`
--

INSERT INTO `propertyfeaturestb` (`PropertyFeatureId`, `PropertyId`, `FeatureId`, `FeatureValueId`, `IsActive`, `CreateDate`, `LastUpdate`) VALUES
(4, 1, 1, NULL, 0, '2022-05-11 19:08:46', NULL),
(5, 2, 1, NULL, 0, '2022-06-15 12:58:19', '2022-06-15 09:28:11'),
(6, 2, 3, NULL, 0, '2022-06-15 12:59:47', '2022-06-15 09:29:38'),
(7, 3, 7, NULL, 0, '2022-06-15 23:01:05', NULL),
(8, 3, 3, NULL, 0, '2022-06-15 23:01:22', NULL),
(9, 4, 7, NULL, 0, '2022-06-15 23:02:17', NULL),
(10, 4, 2, NULL, 0, '2022-06-15 23:02:51', NULL),
(13, 6, 7, 1, 0, '2022-06-16 18:18:01', NULL),
(14, 6, 6, 1, 0, '2022-06-16 18:18:01', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `propertyimagetb`
--

CREATE TABLE `propertyimagetb` (
  `ImageId` int(11) NOT NULL,
  `PropertyId` int(11) NOT NULL,
  `Image` varchar(70) NOT NULL,
  `IsActive` int(11) NOT NULL DEFAULT 0,
  `CreateDate` datetime NOT NULL DEFAULT current_timestamp(),
  `LastUpdate` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `propertyimagetb`
--

INSERT INTO `propertyimagetb` (`ImageId`, `PropertyId`, `Image`, `IsActive`, `CreateDate`, `LastUpdate`) VALUES
(1, 1, 'listing-05.jpg', 0, '2022-06-15 12:57:21', '2022-06-15 09:26:07'),
(2, 2, 'listing-03.jpg', 0, '2022-06-15 12:57:57', '2022-06-15 09:27:31'),
(3, 1, 'listing-02.jpg', 0, '2022-06-15 13:43:36', '2022-06-15 10:12:56'),
(4, 3, 'pics1.png', 0, '2022-06-15 22:53:46', NULL),
(5, 3, 'pics3.jpg', 0, '2022-06-15 22:54:00', NULL),
(6, 4, 'pics2.jpg', 0, '2022-06-15 22:57:34', NULL),
(7, 4, 'pics4.jpg', 0, '2022-06-15 22:57:45', NULL),
(9, 6, 'IMG_863214761619.jpg', 0, '2022-06-16 18:18:01', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `propertytb`
--

CREATE TABLE `propertytb` (
  `PropertyId` int(11) NOT NULL,
  `PropertyTypeId` int(11) NOT NULL,
  `PropertyName` varchar(50) NOT NULL,
  `PlotArea` varchar(50) NOT NULL,
  `AreaUnit` varchar(50) NOT NULL,
  `Price` int(20) NOT NULL,
  `Description` varchar(50) NOT NULL,
  `IsActive` int(11) NOT NULL DEFAULT 0,
  `CreateDate` datetime NOT NULL DEFAULT current_timestamp(),
  `LastUpdate` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `propertytb`
--

INSERT INTO `propertytb` (`PropertyId`, `PropertyTypeId`, `PropertyName`, `PlotArea`, `AreaUnit`, `Price`, `Description`, `IsActive`, `CreateDate`, `LastUpdate`) VALUES
(1, 5, 'Twilight', '200', '100', 30000, 'best Row House', 0, '2022-03-14 15:27:10', '2022-03-14 15:34:05'),
(2, 4, 'orenge', 'adajan', '34', 3500000, 'good property to have', 0, '2022-06-15 12:54:35', '2022-06-15 09:23:50'),
(3, 5, 'Skyview', '300', '200', 5000, 'best row house', 0, '2022-06-15 22:46:17', NULL),
(4, 5, 'Akshara Twon Ship', '500', '200', 10000, 'one of a series of houses connected by common side', 0, '2022-06-15 22:55:28', NULL),
(6, 5, 'White', '500', '200', 200000, 'asd', 1, '2022-06-16 18:18:01', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `propertytypetb`
--

CREATE TABLE `propertytypetb` (
  `PropertytypeId` int(11) NOT NULL,
  `PropertyName` varchar(100) NOT NULL,
  `IsActive` int(11) NOT NULL DEFAULT 0,
  `CreateDate` datetime NOT NULL DEFAULT current_timestamp(),
  `LastUpdate` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `propertytypetb`
--

INSERT INTO `propertytypetb` (`PropertytypeId`, `PropertyName`, `IsActive`, `CreateDate`, `LastUpdate`) VALUES
(4, 'Apartment ', 0, '2022-03-14 15:23:04', NULL),
(5, 'Row House', 0, '2022-03-14 15:29:37', NULL),
(6, 'building', 1, '2022-05-05 22:30:57', '2022-05-05 22:31:04');

-- --------------------------------------------------------

--
-- Table structure for table `sellertb`
--

CREATE TABLE `sellertb` (
  `SellerId` int(11) NOT NULL,
  `UserId` int(11) NOT NULL,
  `PropertyId` int(11) NOT NULL,
  `Type` varchar(50) NOT NULL,
  `CompanyName` varchar(50) NOT NULL,
  `CompanyURL` varchar(50) NOT NULL,
  `CityId` int(11) NOT NULL,
  `StateId` int(11) NOT NULL,
  `Address` varchar(50) NOT NULL,
  `IsActive` int(11) NOT NULL DEFAULT 0,
  `CreateDate` datetime NOT NULL DEFAULT current_timestamp(),
  `LastUpdate` datetime DEFAULT NULL,
  `UpdateBy` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `sellertb`
--

INSERT INTO `sellertb` (`SellerId`, `UserId`, `PropertyId`, `Type`, `CompanyName`, `CompanyURL`, `CityId`, `StateId`, `Address`, `IsActive`, `CreateDate`, `LastUpdate`, `UpdateBy`) VALUES
(1, 10, 1, 'Rent', '', '', 1, 1, 'Adajan', 0, '2022-05-11 19:06:52', NULL, NULL),
(2, 10, 2, 'Rent', 'lenovo', 'xyz.co.in', 1, 1, '12 pragti soc,adajan,sureat', 0, '2022-06-15 12:55:53', '2022-06-15 09:24:52', NULL),
(3, 10, 3, 'Sale', 'Anand Group', 'anandgroup.com', 3, 1, 'Priyanka City Light', 0, '2022-06-15 22:47:06', NULL, NULL),
(4, 10, 4, 'Sale', 'Raj group', 'rajgroup.com', 1, 1, 'Model Town,Near Parvat Patiya', 0, '2022-06-15 22:57:09', NULL, NULL),
(6, 10, 6, 'Sale', 'lenovo', 'legion', 1, 1, 'Priyanka city light', 1, '2022-06-16 18:18:01', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `statetb`
--

CREATE TABLE `statetb` (
  `StateId` int(11) NOT NULL,
  `State` varchar(50) NOT NULL,
  `IsActive` int(11) NOT NULL DEFAULT 0,
  `CreateDate` datetime NOT NULL DEFAULT current_timestamp(),
  `LastUpdate` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `statetb`
--

INSERT INTO `statetb` (`StateId`, `State`, `IsActive`, `CreateDate`, `LastUpdate`) VALUES
(1, 'Gujarat', 0, '2022-03-13 12:25:16', '2023-03-13 12:25:16'),
(3, 'Punjab', 0, '2022-03-13 16:30:42', NULL),
(4, 'Telelangana', 1, '2022-05-03 19:28:41', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `usergrouptb`
--

CREATE TABLE `usergrouptb` (
  `UserGroupId` int(11) NOT NULL,
  `UserId` int(11) NOT NULL,
  `GroupId` int(11) NOT NULL,
  `IsActive` int(11) NOT NULL DEFAULT 0,
  `CreateDate` datetime NOT NULL DEFAULT current_timestamp(),
  `LastUpdate` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `usergrouptb`
--

INSERT INTO `usergrouptb` (`UserGroupId`, `UserId`, `GroupId`, `IsActive`, `CreateDate`, `LastUpdate`) VALUES
(4, 9, 4, 0, '2022-05-10 18:08:36', NULL),
(5, 10, 5, 0, '2022-05-10 18:09:20', NULL),
(6, 11, 4, 0, '2022-06-12 14:39:33', NULL),
(7, 12, 5, 0, '2022-06-16 22:05:58', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `usertb`
--

CREATE TABLE `usertb` (
  `UserId` int(11) NOT NULL,
  `UserName` varchar(50) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL,
  `MobileNo` bigint(10) NOT NULL,
  `IsSeller` int(11) NOT NULL DEFAULT 0,
  `IsActive` int(11) NOT NULL DEFAULT 0,
  `CreateDate` datetime NOT NULL DEFAULT current_timestamp(),
  `LastUpdate` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `usertb`
--

INSERT INTO `usertb` (`UserId`, `UserName`, `Email`, `Password`, `MobileNo`, `IsSeller`, `IsActive`, `CreateDate`, `LastUpdate`) VALUES
(9, 'vishaly', 'yennam20@gmail.com', 'vishal', 9924987162, 0, 0, '2022-05-10 18:08:36', NULL),
(10, 'shrutint', 'shrutin@gmail.com', 'shrutin', 1234567891, 1, 0, '2022-05-10 18:09:20', '2022-06-17 14:24:37'),
(11, 'vatsal', 'vatsal@gmail.com', '1234', 123456789, 0, 0, '2022-06-12 14:39:33', NULL),
(12, 'rahuld', 'rahul@gmail.com', 'rahul', 1234567899, 1, 0, '2022-06-16 22:05:58', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `wishlisttb`
--

CREATE TABLE `wishlisttb` (
  `WishlistId` int(11) NOT NULL,
  `UserId` int(11) NOT NULL,
  `PropertyId` int(11) NOT NULL,
  `IsActive` int(11) NOT NULL DEFAULT 0,
  `CreateDate` datetime NOT NULL DEFAULT current_timestamp(),
  `LastUpdate` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `wishlisttb`
--

INSERT INTO `wishlisttb` (`WishlistId`, `UserId`, `PropertyId`, `IsActive`, `CreateDate`, `LastUpdate`) VALUES
(7, 11, 3, 0, '2022-06-16 11:16:20', NULL),
(8, 9, 6, 0, '2022-06-16 23:38:56', NULL),
(9, 10, 2, 0, '2022-06-16 23:40:53', NULL),
(10, 10, 3, 0, '2022-06-17 14:25:18', NULL),
(11, 9, 1, 0, '2022-06-17 14:26:45', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `amenitiestb`
--
ALTER TABLE `amenitiestb`
  ADD PRIMARY KEY (`AmenitiesId`);

--
-- Indexes for table `citytb`
--
ALTER TABLE `citytb`
  ADD PRIMARY KEY (`CityId`),
  ADD KEY `citytb_ibfk_1` (`StateId`);

--
-- Indexes for table `featurestb`
--
ALTER TABLE `featurestb`
  ADD PRIMARY KEY (`FeatureId`),
  ADD KEY `PropertyTypeId` (`PropertyTypeId`);

--
-- Indexes for table `featurevaluetb`
--
ALTER TABLE `featurevaluetb`
  ADD PRIMARY KEY (`FeatureValueId`);

--
-- Indexes for table `grouptb`
--
ALTER TABLE `grouptb`
  ADD PRIMARY KEY (`GroupId`);

--
-- Indexes for table `propertyamenitiestb`
--
ALTER TABLE `propertyamenitiestb`
  ADD PRIMARY KEY (`PropertyAmenitiesId`),
  ADD KEY `PropertyId` (`PropertyId`),
  ADD KEY `AmenitiesId` (`AmenitiesId`);

--
-- Indexes for table `propertyfeaturestb`
--
ALTER TABLE `propertyfeaturestb`
  ADD PRIMARY KEY (`PropertyFeatureId`),
  ADD KEY `PropertyId` (`PropertyId`),
  ADD KEY `FeatureId` (`FeatureId`),
  ADD KEY `FeatureValueId` (`FeatureValueId`);

--
-- Indexes for table `propertyimagetb`
--
ALTER TABLE `propertyimagetb`
  ADD PRIMARY KEY (`ImageId`),
  ADD KEY `PropertyId` (`PropertyId`);

--
-- Indexes for table `propertytb`
--
ALTER TABLE `propertytb`
  ADD PRIMARY KEY (`PropertyId`),
  ADD KEY `PropertyTypeId` (`PropertyTypeId`);

--
-- Indexes for table `propertytypetb`
--
ALTER TABLE `propertytypetb`
  ADD PRIMARY KEY (`PropertytypeId`);

--
-- Indexes for table `sellertb`
--
ALTER TABLE `sellertb`
  ADD PRIMARY KEY (`SellerId`),
  ADD KEY `StateId` (`StateId`),
  ADD KEY `CityId` (`CityId`),
  ADD KEY `PropertyId` (`PropertyId`),
  ADD KEY `UserId` (`UserId`);

--
-- Indexes for table `statetb`
--
ALTER TABLE `statetb`
  ADD PRIMARY KEY (`StateId`);

--
-- Indexes for table `usergrouptb`
--
ALTER TABLE `usergrouptb`
  ADD PRIMARY KEY (`UserGroupId`),
  ADD KEY `UserId` (`UserId`),
  ADD KEY `GroupId` (`GroupId`);

--
-- Indexes for table `usertb`
--
ALTER TABLE `usertb`
  ADD PRIMARY KEY (`UserId`);

--
-- Indexes for table `wishlisttb`
--
ALTER TABLE `wishlisttb`
  ADD PRIMARY KEY (`WishlistId`),
  ADD KEY `UserId` (`UserId`),
  ADD KEY `PropertyId` (`PropertyId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `amenitiestb`
--
ALTER TABLE `amenitiestb`
  MODIFY `AmenitiesId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `citytb`
--
ALTER TABLE `citytb`
  MODIFY `CityId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `featurestb`
--
ALTER TABLE `featurestb`
  MODIFY `FeatureId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `featurevaluetb`
--
ALTER TABLE `featurevaluetb`
  MODIFY `FeatureValueId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `grouptb`
--
ALTER TABLE `grouptb`
  MODIFY `GroupId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `propertyamenitiestb`
--
ALTER TABLE `propertyamenitiestb`
  MODIFY `PropertyAmenitiesId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `propertyfeaturestb`
--
ALTER TABLE `propertyfeaturestb`
  MODIFY `PropertyFeatureId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `propertyimagetb`
--
ALTER TABLE `propertyimagetb`
  MODIFY `ImageId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `propertytb`
--
ALTER TABLE `propertytb`
  MODIFY `PropertyId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `propertytypetb`
--
ALTER TABLE `propertytypetb`
  MODIFY `PropertytypeId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `sellertb`
--
ALTER TABLE `sellertb`
  MODIFY `SellerId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `statetb`
--
ALTER TABLE `statetb`
  MODIFY `StateId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `usergrouptb`
--
ALTER TABLE `usergrouptb`
  MODIFY `UserGroupId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `usertb`
--
ALTER TABLE `usertb`
  MODIFY `UserId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `wishlisttb`
--
ALTER TABLE `wishlisttb`
  MODIFY `WishlistId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `citytb`
--
ALTER TABLE `citytb`
  ADD CONSTRAINT `citytb_ibfk_1` FOREIGN KEY (`StateId`) REFERENCES `statetb` (`StateId`);

--
-- Constraints for table `featurestb`
--
ALTER TABLE `featurestb`
  ADD CONSTRAINT `featurestb_ibfk_1` FOREIGN KEY (`PropertyTypeId`) REFERENCES `propertytypetb` (`PropertytypeId`);

--
-- Constraints for table `featurevaluetb`
--
ALTER TABLE `featurevaluetb`
  ADD CONSTRAINT `featurevaluetb_ibfk_1` FOREIGN KEY (`FeatureValueId`) REFERENCES `featurestb` (`FeatureId`);

--
-- Constraints for table `propertyamenitiestb`
--
ALTER TABLE `propertyamenitiestb`
  ADD CONSTRAINT `propertyamenitiestb_ibfk_1` FOREIGN KEY (`PropertyId`) REFERENCES `propertytb` (`PropertyId`),
  ADD CONSTRAINT `propertyamenitiestb_ibfk_2` FOREIGN KEY (`AmenitiesId`) REFERENCES `amenitiestb` (`AmenitiesId`);

--
-- Constraints for table `propertyfeaturestb`
--
ALTER TABLE `propertyfeaturestb`
  ADD CONSTRAINT `propertyfeaturestb_ibfk_1` FOREIGN KEY (`PropertyId`) REFERENCES `propertytb` (`PropertyId`),
  ADD CONSTRAINT `propertyfeaturestb_ibfk_2` FOREIGN KEY (`FeatureId`) REFERENCES `featurestb` (`FeatureId`),
  ADD CONSTRAINT `propertyfeaturestb_ibfk_3` FOREIGN KEY (`FeatureValueId`) REFERENCES `featurevaluetb` (`FeatureValueId`);

--
-- Constraints for table `propertyimagetb`
--
ALTER TABLE `propertyimagetb`
  ADD CONSTRAINT `propertyimagetb_ibfk_1` FOREIGN KEY (`PropertyId`) REFERENCES `propertytb` (`PropertyId`);

--
-- Constraints for table `propertytb`
--
ALTER TABLE `propertytb`
  ADD CONSTRAINT `propertytb_ibfk_1` FOREIGN KEY (`PropertyTypeId`) REFERENCES `propertytypetb` (`PropertytypeId`);

--
-- Constraints for table `sellertb`
--
ALTER TABLE `sellertb`
  ADD CONSTRAINT `sellertb_ibfk_1` FOREIGN KEY (`StateId`) REFERENCES `statetb` (`StateId`),
  ADD CONSTRAINT `sellertb_ibfk_2` FOREIGN KEY (`CityId`) REFERENCES `citytb` (`CityId`),
  ADD CONSTRAINT `sellertb_ibfk_3` FOREIGN KEY (`PropertyId`) REFERENCES `propertytb` (`PropertyId`),
  ADD CONSTRAINT `sellertb_ibfk_4` FOREIGN KEY (`UserId`) REFERENCES `usertb` (`UserId`);

--
-- Constraints for table `usergrouptb`
--
ALTER TABLE `usergrouptb`
  ADD CONSTRAINT `usergrouptb_ibfk_1` FOREIGN KEY (`UserId`) REFERENCES `usertb` (`UserId`),
  ADD CONSTRAINT `usergrouptb_ibfk_2` FOREIGN KEY (`GroupId`) REFERENCES `grouptb` (`GroupId`);

--
-- Constraints for table `wishlisttb`
--
ALTER TABLE `wishlisttb`
  ADD CONSTRAINT `wishlisttb_ibfk_1` FOREIGN KEY (`UserId`) REFERENCES `usertb` (`UserId`),
  ADD CONSTRAINT `wishlisttb_ibfk_2` FOREIGN KEY (`PropertyId`) REFERENCES `propertytb` (`PropertyId`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
