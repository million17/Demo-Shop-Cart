-- --------------------------------------------------------
-- Host:                         localhost
-- Server version:               8.0.19 - MySQL Community Server - GPL
-- Server OS:                    Win64
-- HeidiSQL Version:             10.3.0.5771
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for db_demo_t3h
CREATE DATABASE IF NOT EXISTS `db_demo_t3h` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_vietnamese_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `db_demo_t3h`;

-- Dumping structure for table db_demo_t3h.dbo_cart
CREATE TABLE IF NOT EXISTS `dbo_cart` (
  `cart_id` int NOT NULL AUTO_INCREMENT,
  `guid` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`cart_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table db_demo_t3h.dbo_cart: ~0 rows (approximately)
/*!40000 ALTER TABLE `dbo_cart` DISABLE KEYS */;
/*!40000 ALTER TABLE `dbo_cart` ENABLE KEYS */;

-- Dumping structure for table db_demo_t3h.dbo_cart_product
CREATE TABLE IF NOT EXISTS `dbo_cart_product` (
  `cart_product_id` int NOT NULL AUTO_INCREMENT,
  `cart_id` int DEFAULT NULL,
  `product_id` int DEFAULT NULL,
  `amount` int DEFAULT NULL,
  PRIMARY KEY (`cart_product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table db_demo_t3h.dbo_cart_product: ~0 rows (approximately)
/*!40000 ALTER TABLE `dbo_cart_product` DISABLE KEYS */;
/*!40000 ALTER TABLE `dbo_cart_product` ENABLE KEYS */;

-- Dumping structure for table db_demo_t3h.dbo_category
CREATE TABLE IF NOT EXISTS `dbo_category` (
  `category_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `short_desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table db_demo_t3h.dbo_category: ~0 rows (approximately)
/*!40000 ALTER TABLE `dbo_category` DISABLE KEYS */;
INSERT INTO `dbo_category` (`category_id`, `name`, `short_desc`, `created_date`) VALUES
	(1, 'Category 1', 'short desc 1', '2020-04-19 18:39:06'),
	(2, 'Category 2', 'short desc 2', '2020-04-19 18:39:20'),
	(3, 'Category 3', 'short desc 3', '2020-04-19 18:39:32'),
	(4, 'Category 4', 'short desc 4', '2020-04-19 18:39:41');
/*!40000 ALTER TABLE `dbo_category` ENABLE KEYS */;

-- Dumping structure for table db_demo_t3h.dbo_color
CREATE TABLE IF NOT EXISTS `dbo_color` (
  `color_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `short_desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  PRIMARY KEY (`color_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table db_demo_t3h.dbo_color: ~0 rows (approximately)
/*!40000 ALTER TABLE `dbo_color` DISABLE KEYS */;
/*!40000 ALTER TABLE `dbo_color` ENABLE KEYS */;

-- Dumping structure for table db_demo_t3h.dbo_oder
CREATE TABLE IF NOT EXISTS `dbo_oder` (
  `oder_id` int NOT NULL AUTO_INCREMENT,
  `guid` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `customer_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `phone_number` int DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `ship` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`oder_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table db_demo_t3h.dbo_oder: ~0 rows (approximately)
/*!40000 ALTER TABLE `dbo_oder` DISABLE KEYS */;
/*!40000 ALTER TABLE `dbo_oder` ENABLE KEYS */;

-- Dumping structure for table db_demo_t3h.dbo_oder_product
CREATE TABLE IF NOT EXISTS `dbo_oder_product` (
  `oder_product_id` int NOT NULL AUTO_INCREMENT,
  `product_id` int DEFAULT NULL,
  `oder_id` int DEFAULT NULL,
  PRIMARY KEY (`oder_product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='		';

-- Dumping data for table db_demo_t3h.dbo_oder_product: ~0 rows (approximately)
/*!40000 ALTER TABLE `dbo_oder_product` DISABLE KEYS */;
/*!40000 ALTER TABLE `dbo_oder_product` ENABLE KEYS */;

-- Dumping structure for table db_demo_t3h.dbo_product
CREATE TABLE IF NOT EXISTS `dbo_product` (
  `product_id` int NOT NULL AUTO_INCREMENT,
  `product_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `short_desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `main_image` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `category_id` int DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `brand` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table db_demo_t3h.dbo_product: ~0 rows (approximately)
/*!40000 ALTER TABLE `dbo_product` DISABLE KEYS */;
INSERT INTO `dbo_product` (`product_id`, `product_name`, `short_desc`, `main_image`, `category_id`, `price`, `brand`, `created_date`) VALUES
	(1, 'Product 1', 'Product 1 short description', '/no_image.jpg', 2, 176.76, 'Viet Nam', '2020-04-19 18:04:32'),
	(2, 'Product 2', 'Product 2 short description', '/no_image.jpg', 1, 72.36, 'Japan', '2020-04-19 18:04:32'),
	(3, 'Product 3', 'Product 3 short description', '/no_image.jpg', 2, 153.54, 'Viet Nam', '2020-04-19 19:36:14'),
	(4, 'Product 4', 'Product 4 short description', '/no_image.jpg', 1, 129.21, 'Viet Nam', '2020-04-19 19:36:46');
/*!40000 ALTER TABLE `dbo_product` ENABLE KEYS */;

-- Dumping structure for table db_demo_t3h.dbo_product_entity
CREATE TABLE IF NOT EXISTS `dbo_product_entity` (
  `product_entity_id` int NOT NULL AUTO_INCREMENT,
  `product_id` int DEFAULT NULL,
  `color_id` int DEFAULT NULL,
  `size_id` int DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  PRIMARY KEY (`product_entity_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table db_demo_t3h.dbo_product_entity: ~0 rows (approximately)
/*!40000 ALTER TABLE `dbo_product_entity` DISABLE KEYS */;
/*!40000 ALTER TABLE `dbo_product_entity` ENABLE KEYS */;

-- Dumping structure for table db_demo_t3h.dbo_product_image
CREATE TABLE IF NOT EXISTS `dbo_product_image` (
  `product_image_id` int NOT NULL AUTO_INCREMENT,
  `product_id` int NOT NULL,
  `link` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  PRIMARY KEY (`product_image_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table db_demo_t3h.dbo_product_image: ~0 rows (approximately)
/*!40000 ALTER TABLE `dbo_product_image` DISABLE KEYS */;
/*!40000 ALTER TABLE `dbo_product_image` ENABLE KEYS */;

-- Dumping structure for table db_demo_t3h.dbo_role
CREATE TABLE IF NOT EXISTS `dbo_role` (
  `role_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table db_demo_t3h.dbo_role: ~0 rows (approximately)
/*!40000 ALTER TABLE `dbo_role` DISABLE KEYS */;
INSERT INTO `dbo_role` (`role_id`, `name`) VALUES
	(1, 'ROLE_ADMIN'),
	(2, 'ROLE_USER');
/*!40000 ALTER TABLE `dbo_role` ENABLE KEYS */;

-- Dumping structure for table db_demo_t3h.dbo_size
CREATE TABLE IF NOT EXISTS `dbo_size` (
  `size_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `short_desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  PRIMARY KEY (`size_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table db_demo_t3h.dbo_size: ~0 rows (approximately)
/*!40000 ALTER TABLE `dbo_size` DISABLE KEYS */;
/*!40000 ALTER TABLE `dbo_size` ENABLE KEYS */;

-- Dumping structure for table db_demo_t3h.dbo_user
CREATE TABLE IF NOT EXISTS `dbo_user` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `gender` int DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `password_hash` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `phone_number` int DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table db_demo_t3h.dbo_user: ~0 rows (approximately)
/*!40000 ALTER TABLE `dbo_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `dbo_user` ENABLE KEYS */;

-- Dumping structure for table db_demo_t3h.dbo_user_role
CREATE TABLE IF NOT EXISTS `dbo_user_role` (
  `user_role_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `role_id` int DEFAULT NULL,
  PRIMARY KEY (`user_role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table db_demo_t3h.dbo_user_role: ~0 rows (approximately)
/*!40000 ALTER TABLE `dbo_user_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `dbo_user_role` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
