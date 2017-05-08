-- --------------------------------------------------------
-- Хост:                         127.0.0.1
-- Версия сервера:               5.1.72-community - MySQL Community Server (GPL)
-- ОС Сервера:                   Win32
-- HeidiSQL Версия:              9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Дамп структуры базы данных taskmanager
CREATE DATABASE IF NOT EXISTS `taskmanager` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `taskmanager`;


-- Дамп структуры для таблица taskmanager.task
CREATE TABLE IF NOT EXISTS `task` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `is_end` smallint(5) DEFAULT '0',
  `start_date` varchar(10) DEFAULT NULL,
  `expire_date` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы taskmanager.task: ~10 rows (приблизительно)
/*!40000 ALTER TABLE `task` DISABLE KEYS */;
INSERT INTO `task` (`id`, `name`, `description`, `is_end`, `start_date`, `expire_date`) VALUES
	(1, 'test1', 'descr1', 0, '24-05-2017', '25-25-2017'),
	(2, 'test2', 'descr2', 0, '24-05-2017', '25-05-2017'),
	(3, 'test3', 'descr3', 1, '24-05-2017', '25-05-2017');
/*!40000 ALTER TABLE `task` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
