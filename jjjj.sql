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


-- Dumping database structure for agent_db
CREATE DATABASE IF NOT EXISTS `agent_db` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `agent_db`;

-- Dumping structure for table agent_db.profile
CREATE TABLE IF NOT EXISTS `profile` (
  `name` varchar(100) NOT NULL,
  `DOB` date NOT NULL,
  `b_card_no` int(20) DEFAULT NULL,
  `agency_id` int(20) NOT NULL,
  `user_id` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `agent_number` int(20) NOT NULL,
  PRIMARY KEY (`name`),
  UNIQUE KEY `agent_number` (`agent_number`),
  UNIQUE KEY `user_id` (`user_id`),
  UNIQUE KEY `agency_id` (`agency_id`),
  UNIQUE KEY `b_card_no` (`b_card_no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='agent profile';

-- Data exporting was unselected.

-- Dumping database structure for b_card_db
CREATE DATABASE IF NOT EXISTS `b_card_db` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `b_card_db`;

-- Dumping structure for table b_card_db.bank_acc
CREATE TABLE IF NOT EXISTS `bank_acc` (
  `name` varchar(100) NOT NULL,
  `acc_no` int(11) NOT NULL,
  `balance` int(11) NOT NULL,
  PRIMARY KEY (`name`,`acc_no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='bank details of customer';

-- Data exporting was unselected.
-- Dumping structure for table b_card_db.loan_acc
CREATE TABLE IF NOT EXISTS `loan_acc` (
  `name` varchar(50) NOT NULL,
  `loan_no` int(11) NOT NULL,
  `pending_amount` int(11) NOT NULL,
  PRIMARY KEY (`name`,`loan_no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='loan details of customer';

-- Data exporting was unselected.
-- Dumping structure for table b_card_db.profile
CREATE TABLE IF NOT EXISTS `profile` (
  `name` varchar(100) NOT NULL,
  `acc_no` int(11) NOT NULL,
  `loan_no` int(11) DEFAULT NULL,
  `address` varchar(100) NOT NULL,
  `photo` blob,
  `username` varchar(50) NOT NULL,
  `paasword` varchar(50) NOT NULL,
  `dob` date NOT NULL,
  `gender` varchar(50) NOT NULL,
  PRIMARY KEY (`name`,`acc_no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='card profile data';

-- Data exporting was unselected.

-- Dumping database structure for bank_db
CREATE DATABASE IF NOT EXISTS `bank_db` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `bank_db`;

-- Dumping structure for table bank_db.profile
CREATE TABLE IF NOT EXISTS `profile` (
  `acc_no` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `dob` date NOT NULL,
  `address` varchar(100) NOT NULL,
  `b_card_no` int(11) DEFAULT NULL,
  `photo` blob,
  `balance` int(11) NOT NULL,
  PRIMARY KEY (`acc_no`),
  CONSTRAINT `acc_no` FOREIGN KEY (`acc_no`) REFERENCES `transaction` (`acc_no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='bank details';

-- Data exporting was unselected.
-- Dumping structure for table bank_db.transaction
CREATE TABLE IF NOT EXISTS `transaction` (
  `acc_no` int(11) NOT NULL,
  `trans_id` int(11) NOT NULL,
  `status` varchar(50) NOT NULL,
  `money` int(11) NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`acc_no`),
  UNIQUE KEY `trans_id` (`trans_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='details tranaction';

-- Data exporting was unselected.

-- Dumping database structure for credit_card_db
CREATE DATABASE IF NOT EXISTS `credit_card_db` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `credit_card_db`;

-- Dumping structure for table credit_card_db.profile
CREATE TABLE IF NOT EXISTS `profile` (
  `name` varchar(100) NOT NULL,
  `c_card_no` int(11) NOT NULL,
  `b_card_no` int(11) NOT NULL,
  `dob` date NOT NULL,
  `user_id` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `address` varchar(100) NOT NULL,
  `photo` blob,
  `date_to_pay` date NOT NULL,
  PRIMARY KEY (`c_card_no`),
  UNIQUE KEY `b_card_no` (`b_card_no`),
  UNIQUE KEY `user_id` (`user_id`),
  CONSTRAINT `c_card_no` FOREIGN KEY (`c_card_no`) REFERENCES `transaction` (`c_card_no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='credit card details';

-- Data exporting was unselected.
-- Dumping structure for table credit_card_db.transaction
CREATE TABLE IF NOT EXISTS `transaction` (
  `c_card_no` int(11) NOT NULL,
  `purpose` varchar(100) DEFAULT NULL,
  `date` date NOT NULL,
  `amount` int(11) NOT NULL,
  PRIMARY KEY (`c_card_no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.

-- Dumping database structure for loan_db
CREATE DATABASE IF NOT EXISTS `loan_db` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `loan_db`;

-- Dumping structure for table loan_db.due_data
CREATE TABLE IF NOT EXISTS `due_data` (
  `loan_no` int(11) NOT NULL,
  `due_date` date NOT NULL,
  `due_amount` int(11) NOT NULL,
  PRIMARY KEY (`loan_no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.
-- Dumping structure for table loan_db.profile
CREATE TABLE IF NOT EXISTS `profile` (
  `name` varchar(100) NOT NULL,
  `loan_no` int(11) NOT NULL,
  `dob` date NOT NULL,
  `address` varchar(100) NOT NULL,
  `photo` blob,
  `b_card_no` int(100) DEFAULT NULL,
  `loan_amount` int(50) NOT NULL,
  PRIMARY KEY (`loan_no`),
  UNIQUE KEY `loan_no` (`loan_no`),
  UNIQUE KEY `b_card_no` (`b_card_no`),
  CONSTRAINT `loan_no` FOREIGN KEY (`loan_no`) REFERENCES `due_data` (`loan_no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.

-- Dumping database structure for risky_db
CREATE DATABASE IF NOT EXISTS `risky_db` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `risky_db`;

-- Dumping structure for table risky_db.profile
CREATE TABLE IF NOT EXISTS `profile` (
  `name` varchar(100) NOT NULL,
  `acc_no` int(11) NOT NULL,
  `loan_no` int(11) DEFAULT NULL,
  `b_card_no` int(11) NOT NULL,
  PRIMARY KEY (`name`),
  UNIQUE KEY `acc_no` (`acc_no`),
  UNIQUE KEY `b_card_no` (`b_card_no`),
  UNIQUE KEY `loan_no` (`loan_no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
