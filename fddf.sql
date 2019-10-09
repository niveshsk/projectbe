-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.1.72-community - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for r
CREATE DATABASE IF NOT EXISTS `r` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `r`;

-- Dumping structure for table r.regist
CREATE TABLE IF NOT EXISTS `regist` (
  `name` varchar(500) DEFAULT NULL,
  `pass` varchar(500) DEFAULT NULL,
  `email` varchar(500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table r.regist: ~4 rows (approximately)
/*!40000 ALTER TABLE `regist` DISABLE KEYS */;
INSERT INTO `regist` (`name`, `pass`, `email`) VALUES
	('ni', 'ni', 'ni'),
	('', '', ''),
	('hi', 'hi', 'jio'),
	('nivesh', 'nivesh', 'jsk');
/*!40000 ALTER TABLE `regist` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
