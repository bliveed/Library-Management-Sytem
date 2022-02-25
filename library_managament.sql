-- --------------------------------------------------------
-- Sunucu:                       127.0.0.1
-- Sunucu sürümü:                10.4.14-MariaDB - mariadb.org binary distribution
-- Sunucu İşletim Sistemi:       Win64
-- HeidiSQL Sürüm:               11.1.0.6116
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- database_lms için veritabanı yapısı dökülüyor
CREATE DATABASE IF NOT EXISTS `database_lms` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `database_lms`;

-- tablo yapısı dökülüyor database_lms.book
CREATE TABLE IF NOT EXISTS `book` (
  `BookId` int(20) unsigned NOT NULL AUTO_INCREMENT,
  `BookName` varchar(50) NOT NULL,
  `Author` varchar(50) NOT NULL,
  `Genre` varchar(50) NOT NULL,
  `ISBNnumber` int(20) unsigned NOT NULL,
  `Available` enum('Available','Issued') DEFAULT 'Available',
  PRIMARY KEY (`BookId`) USING BTREE,
  UNIQUE KEY `isbn` (`ISBNnumber`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

-- Veri çıktısı seçilmemişti

-- tablo yapısı dökülüyor database_lms.issue
CREATE TABLE IF NOT EXISTS `issue` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `UserEmail` varchar(50) NOT NULL,
  `BookName` varchar(50) NOT NULL,
  `ISBNNumber` float NOT NULL DEFAULT 0,
  `IssueDate` date NOT NULL,
  `DueDate` date NOT NULL,
  PRIMARY KEY (`Id`,`UserEmail`) USING BTREE,
  UNIQUE KEY `ISBN_Number` (`ISBNNumber`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- Veri çıktısı seçilmemişti

-- tablo yapısı dökülüyor database_lms.person
CREATE TABLE IF NOT EXISTS `person` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) NOT NULL,
  `Surname` varchar(50) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL,
  `Birthday` date DEFAULT NULL,
  `Gender` enum('Male','Female') NOT NULL DEFAULT 'Female',
  `Status` enum('User','Librarian','Admin') NOT NULL DEFAULT 'User',
  PRIMARY KEY (`Id`,`Email`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4;

-- Veri çıktısı seçilmemişti

-- tablo yapısı dökülüyor database_lms.return
CREATE TABLE IF NOT EXISTS `return` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `UserEmail` varchar(50) NOT NULL,
  `ISBNnumber` int(11) NOT NULL DEFAULT 0,
  `IssuedDate` date NOT NULL,
  `ReturnDate` date NOT NULL,
  PRIMARY KEY (`Id`,`UserEmail`),
  UNIQUE KEY `ISBNnumber` (`ISBNnumber`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- Veri çıktısı seçilmemişti

-- yöntem yapısı dökülüyor database_lms.viewBook
DELIMITER //
CREATE PROCEDURE `viewBook`(IN id INT)
BEGIN			
					select * from book WHERE BookId=id; 
				END//
DELIMITER ;

-- yöntem yapısı dökülüyor database_lms.viewBooks
DELIMITER //
CREATE PROCEDURE `viewBooks`()
BEGIN
	SELECT * 
	FROM Book
	WHERE Available='Available';

END//
DELIMITER ;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
