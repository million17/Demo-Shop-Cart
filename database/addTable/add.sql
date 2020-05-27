-- --------------------------------------------------------
-- Host:                         localhost
-- Server version:               8.0.17 - MySQL Community Server - GPL
-- Server OS:                    Win64
-- HeidiSQL Version:             11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for db_demo_t3h
CREATE DATABASE IF NOT EXISTS `db_demo_t3h` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_vietnamese_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `db_demo_t3h`;

-- Dumping structure for table db_demo_t3h.dbo_blog
CREATE TABLE IF NOT EXISTS `dbo_blog` (
  `blog_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `image_blog` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  PRIMARY KEY (`blog_id`),
  KEY `fk_user_id` (`user_id`),
  CONSTRAINT `fk_user_blog_id` FOREIGN KEY (`user_id`) REFERENCES `dbo_user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table db_demo_t3h.dbo_blog: ~0 rows (approximately)
/*!40000 ALTER TABLE `dbo_blog` DISABLE KEYS */;
INSERT INTO `dbo_blog` (`blog_id`, `title`, `image_blog`, `content`, `user_id`, `created_date`) VALUES
	(1, 'Black Friday Guide: Best Sales & Discount Codes', '/no_image.jpg', 'Duis ut velit gravida nibh bibendum commodo. Sus-pendisse pellentesque mattis augue id euismod. Inter-dum et malesuada fames', 1, '2020-05-13 17:42:41'),
	(2, 'The White Sneakers Nearly Every Fashion Girls Own', '/no_image.jpg', 'Nullam scelerisque, lacus sed consequat laoreet, dui enim iaculis leo, eu viverra ex nulla in tellus. Nullam nec ornare tellus, ac fringilla lacus. Ut sit ame', 1, '2020-05-13 17:42:41'),
	(3, 'New York SS 2018 Street Style: Annina Mislin', '/no_image.jpg', 'Proin nec vehicula lorem, a efficitur ex. Nam vehicula nulla vel erat tincidunt, sed hendrerit ligula porttitor. Fusce sit amet maximus nunc', 1, '2020-05-13 17:42:41');
/*!40000 ALTER TABLE `dbo_blog` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

ALTER TABLE dbo_product_entity
 ADD amount long;


/*change column*/
 ALTER TABLE db_demo_t3h.dbo_user
MODIFY phone_number varchar(255);
