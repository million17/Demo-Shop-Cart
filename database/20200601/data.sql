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

-- Dumping structure for table db_demo_t3h.dbo_blog
CREATE TABLE IF NOT EXISTS `dbo_blog` (
  `blog_id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `image_blog` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  PRIMARY KEY (`blog_id`),
  KEY `fk_user_id` (`user_id`),
  CONSTRAINT `fk_user_blog_id` FOREIGN KEY (`user_id`) REFERENCES `dbo_user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table db_demo_t3h.dbo_blog: ~3 rows (approximately)
/*!40000 ALTER TABLE `dbo_blog` DISABLE KEYS */;
INSERT IGNORE INTO `dbo_blog` (`blog_id`, `title`, `image_blog`, `content`, `user_id`, `created_date`) VALUES
	(1, 'Black Friday Guide: Best Sales & Discount Codes', '/link/no_image.jpg', 'Duis ut velit gravida nibh bibendum commodo. Sus-pendisse pellentesque mattis augue id euismod. Inter-dum et malesuada fames', 1, '2020-05-13 17:42:41'),
	(2, 'The White Sneakers Nearly Every Fashion Girls Own', '/link/no_image.jpg', 'Nullam scelerisque, lacus sed consequat laoreet, dui enim iaculis leo, eu viverra ex nulla in tellus. Nullam nec ornare tellus, ac fringilla lacus. Ut sit ame', 1, '2020-05-13 17:42:41'),
	(3, 'New York SS 2018 Street Style: Annina Mislin', '/link/no_image.jpg', 'Proin nec vehicula lorem, a efficitur ex. Nam vehicula nulla vel erat tincidunt, sed hendrerit ligula porttitor. Fusce sit amet maximus nunc', 1, '2020-05-13 17:42:41');
/*!40000 ALTER TABLE `dbo_blog` ENABLE KEYS */;

-- Dumping structure for table db_demo_t3h.dbo_cart_product
CREATE TABLE IF NOT EXISTS `dbo_cart_product` (
  `cart_product_id` int NOT NULL AUTO_INCREMENT,
  `cart_id` int DEFAULT NULL,
  `product_entity_id` int DEFAULT NULL,
  `amount` int DEFAULT NULL,
  PRIMARY KEY (`cart_product_id`),
  KEY `fk_cart_id` (`cart_id`),
  KEY `fk_product_entity_id` (`product_entity_id`),
  CONSTRAINT `fk_cart_id` FOREIGN KEY (`cart_id`) REFERENCES `dbo_cart` (`cart_id`),
  CONSTRAINT `fk_product_entity_id` FOREIGN KEY (`product_entity_id`) REFERENCES `dbo_product_entity` (`product_entity_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table db_demo_t3h.dbo_cart_product: ~7 rows (approximately)
/*!40000 ALTER TABLE `dbo_cart_product` DISABLE KEYS */;
INSERT IGNORE INTO `dbo_cart_product` (`cart_product_id`, `cart_id`, `product_entity_id`, `amount`) VALUES
	(2, 39, 1, 10),
	(3, 39, 3, 2),
	(4, 39, 8, 2),
	(5, 40, 1, 1),
	(8, 42, 8, 3),
	(9, 42, 3, 1),
	(23, 54, 3, 1);
/*!40000 ALTER TABLE `dbo_cart_product` ENABLE KEYS */;

-- Dumping structure for table db_demo_t3h.dbo_category
CREATE TABLE IF NOT EXISTS `dbo_category` (
  `category_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `short_desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table db_demo_t3h.dbo_category: ~4 rows (approximately)
/*!40000 ALTER TABLE `dbo_category` DISABLE KEYS */;
INSERT IGNORE INTO `dbo_category` (`category_id`, `name`, `short_desc`, `created_date`) VALUES
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table db_demo_t3h.dbo_color: ~3 rows (approximately)
/*!40000 ALTER TABLE `dbo_color` DISABLE KEYS */;
INSERT IGNORE INTO `dbo_color` (`color_id`, `name`, `short_desc`, `created_date`) VALUES
	(1, 'Blue', 'this is blue', '2020-05-05 10:34:39'),
	(2, 'Black', 'this is black', '2020-05-04 11:12:12'),
	(3, 'Red', 'this is red', '2020-05-04 11:12:16');
/*!40000 ALTER TABLE `dbo_color` ENABLE KEYS */;

-- Dumping structure for table db_demo_t3h.dbo_delivery_status
CREATE TABLE IF NOT EXISTS `dbo_delivery_status` (
  `delivery_status_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  PRIMARY KEY (`delivery_status_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

-- Dumping data for table db_demo_t3h.dbo_delivery_status: ~5 rows (approximately)
/*!40000 ALTER TABLE `dbo_delivery_status` DISABLE KEYS */;
INSERT IGNORE INTO `dbo_delivery_status` (`delivery_status_id`, `name`) VALUES
	(1, 'Chờ thanh toán'),
	(2, 'Chờ lấy hàng'),
	(3, 'Đang giao'),
	(4, 'Đã giao'),
	(5, 'Đã hủy');
/*!40000 ALTER TABLE `dbo_delivery_status` ENABLE KEYS */;

-- Dumping structure for table db_demo_t3h.dbo_order
CREATE TABLE IF NOT EXISTS `dbo_order` (
  `order_id` int NOT NULL AUTO_INCREMENT,
  `guid` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `customer_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `phone_number` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `ship` decimal(10,2) DEFAULT NULL,
  `delivery_status_id` int DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  KEY `fk_delivery_status_id` (`delivery_status_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping structure for table db_demo_t3h.dbo_order_delivery_status
CREATE TABLE IF NOT EXISTS `dbo_order_delivery_status` (
  `order_delivery_status_id` int NOT NULL AUTO_INCREMENT,
  `order_id` int NOT NULL,
  `delivery_status_id` int NOT NULL,
  `created_date` datetime DEFAULT NULL,
  PRIMARY KEY (`order_delivery_status_id`),
  KEY `fk_order_id` (`order_id`) /*!80000 INVISIBLE */,
  KEY `fk_delivery_status_id` (`delivery_status_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

-- Dumping data for table db_demo_t3h.dbo_order_delivery_status: ~0 rows (approximately)
/*!40000 ALTER TABLE `dbo_order_delivery_status` DISABLE KEYS */;
/*!40000 ALTER TABLE `dbo_order_delivery_status` ENABLE KEYS */;

-- Dumping data for table db_demo_t3h.dbo_order_product: ~5 rows (approximately)
/*!40000 ALTER TABLE `dbo_order_product` DISABLE KEYS */;
INSERT IGNORE INTO `dbo_order_product` (`order_product_id`, `product_entity_id`, `order_id`, `amount`, `price`) VALUES
	(1, 8, 7, 1, 176.76),
	(2, 1, 7, 1, 176.76),
	(3, 3, 8, 10, 1767.60),
	(4, 8, 9, 1, 176.76),
	(5, 3, 9, 1, 176.76);
/*!40000 ALTER TABLE `dbo_order_product` ENABLE KEYS */;

-- Dumping data for table db_demo_t3h.dbo_product: ~5 rows (approximately)
/*!40000 ALTER TABLE `dbo_product` DISABLE KEYS */;
INSERT IGNORE INTO `dbo_product` (`product_id`, `product_name`, `short_desc`, `main_image`, `category_id`, `price`, `brand`, `created_date`) VALUES
	(1, 'Product 1', 'Product 1 short description', '/link/no_image.jpg', 2, 176.76, 'Viet Nam', '2020-05-11 18:04:32'),
	(2, 'Product 2', 'Product 2 short description', '/link/no_image.jpg', 1, 72.36, 'Japan', '2020-04-19 18:04:32'),
	(3, 'Product 3', 'Product 3 short description', '/link/no_image.jpg', 2, 153.54, 'Viet Nam', '2020-04-19 19:36:14'),
	(4, 'Product 4', 'Product 4 short description', '/link/no_image.jpg', 1, 129.21, 'Viet Nam', '2020-04-19 19:36:46'),
	(5, 'Product 5', 'Product 5 short description', '/link/no_image.jpg', 3, 99.88, 'Japan', '2020-04-19 21:30:16');
/*!40000 ALTER TABLE `dbo_product` ENABLE KEYS */;

/*!40000 ALTER TABLE `dbo_product_entity` DISABLE KEYS */;
INSERT IGNORE INTO `dbo_product_entity` (`product_entity_id`, `product_id`, `color_id`, `size_id`, `created_date`, `amount`) VALUES
	(1, 1, 2, 2, '2020-05-11 11:20:00', '3'),
	(2, 2, 3, 1, '2020-05-11 11:20:00', '6'),
	(3, 1, 1, 2, '2020-05-11 11:20:00', '12'),
	(4, 5, 3, 2, '2020-05-11 11:20:00', '12'),
	(5, 4, 2, 2, '2020-05-11 11:20:00', '3'),
	(6, 1, 2, 2, '2020-05-11 11:20:00', '3'),
	(7, 1, 1, 3, '2020-05-11 11:20:00', '3'),
	(8, 1, 3, 1, '2020-05-11 16:06:21', '4');
/*!40000 ALTER TABLE `dbo_product_entity` ENABLE KEYS */;

-- Dumping data for table db_demo_t3h.dbo_product_image: ~6 rows (approximately)
/*!40000 ALTER TABLE `dbo_product_image` DISABLE KEYS */;
INSERT IGNORE INTO `dbo_product_image` (`product_image_id`, `product_id`, `link`, `created_date`) VALUES
	(1, 1, '/link/no_image.jpg', '2020-05-11 11:18:46'),
	(2, 1, '/link/no_image.jpg', '2020-05-11 11:20:07'),
	(3, 1, '/link/no_image.jpg', '2020-05-11 11:20:07'),
	(4, 1, '/link/no_image.jpg', '2020-05-11 11:20:07'),
	(5, 1, '/link/no_image.jpg', '2020-05-11 11:20:07'),
	(6, 1, '/link/no_image.jpg', '2020-05-11 11:20:07');
/*!40000 ALTER TABLE `dbo_product_image` ENABLE KEYS */;

-- Dumping data for table db_demo_t3h.dbo_role: ~2 rows (approximately)
/*!40000 ALTER TABLE `dbo_role` DISABLE KEYS */;
INSERT IGNORE INTO `dbo_role` (`role_id`, `name`) VALUES
	(1, 'ADMIN'),
	(2, 'USER');
/*!40000 ALTER TABLE `dbo_role` ENABLE KEYS */;

-- Dumping data for table db_demo_t3h.dbo_size: ~3 rows (approximately)
/*!40000 ALTER TABLE `dbo_size` DISABLE KEYS */;
INSERT IGNORE INTO `dbo_size` (`size_id`, `name`, `short_desc`, `created_date`) VALUES
	(1, '37', 'this is 37 size', '2020-05-04 11:11:00'),
	(2, '38', 'this is 38 size', '2020-05-04 11:11:08'),
	(3, '39', 'this is 39 size', '2020-05-04 11:11:12');
/*!40000 ALTER TABLE `dbo_size` ENABLE KEYS */;


-- Dumping data for table db_demo_t3h.dbo_user: ~2 rows (approximately)
/*!40000 ALTER TABLE `dbo_user` DISABLE KEYS */;
INSERT IGNORE INTO `dbo_user` (`user_id`, `user_name`, `email`, `avatar`, `name`, `gender`, `address`, `password_hash`, `phone_number`, `created_date`) VALUES
	(1, 'trieu.ngoquang', 'ngoquangtrieu99tb@gmail.com', '/link/1590505557-3e07b0b5d7652c3b7574.jpg', 'Ngô Quang Triệu', 0, '', '$2a$10$qWM2dpyGZjla.XcdNGQcduX.mBqFY9chHMjPcDjyb14aKwEPmMe2W', '', '2020-05-26 22:05:58'),
	(2, 'trang.dothi', 'trang.dothi@vti.com.vn', NULL, 'Đỗ Thị Thu Trang', 0, NULL, '$2a$10$XPqnsZ.Q.1KprnC0SaZR4uhGWYdzLPlt96e/MgsbDYHHWbinAot/y', '', '2020-05-04 14:18:48');
/*!40000 ALTER TABLE `dbo_user` ENABLE KEYS */;

-- Dumping data for table db_demo_t3h.dbo_user_role: ~2 rows (approximately)
/*!40000 ALTER TABLE `dbo_user_role` DISABLE KEYS */;
INSERT IGNORE INTO `dbo_user_role` (`user_role_id`, `user_id`, `role_id`) VALUES
	(1, 1, 2),
	(2, 2, 2);
/*!40000 ALTER TABLE `dbo_user_role` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
