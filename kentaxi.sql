-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 28, 2024 at 02:56 PM
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
-- Database: `kentaxi`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_user`
--

CREATE TABLE `tbl_user` (
  `id` int(11) NOT NULL,
  `fname` varchar(50) NOT NULL,
  `lname` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(200) NOT NULL,
  `accnt_type` varchar(50) NOT NULL,
  `status` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_user`
--

INSERT INTO `tbl_user` (`id`, `fname`, `lname`, `email`, `username`, `password`, `accnt_type`, `status`) VALUES
(1, 'joshua', 'espanillo', 'wangska1283@gmail.com', 'wangska1283', '7c222fb2927d828af22f592134e8932480637c0d', 'Admin', 'Active'),
(2, 'johnny ', 'Sins', 'wang@gmail.com', 'wang', '7c222fb2927d828af22f592134e8932480637c0d', 'User', 'Active'),
(3, 'test', 'test', 'test@gmail.com', 'test', 'f7c3bc1d808e04732adf679965ccc34ca7ae3441', 'User', 'Active'),
(6, 'yame', 'yaming', 'yaming@gmail.com', 'yaming', '7c222fb2927d828af22f592134e8932480637c0d', 'Admin', 'Pending'),
(7, 'testing', 'testing', 'testing@gmail.com', 'testing', '7c222fb2927d828af22f592134e8932480637c0d', 'User', 'Active'),
(8, 'ikaw', 'lamang', 'ang', 'hinahanap', '7c222fb2927d828af22f592134e8932480637c0d', 'User', 'Active');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_user`
--
ALTER TABLE `tbl_user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_user`
--
ALTER TABLE `tbl_user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
