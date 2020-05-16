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

-- Dumping data for table db_demo_t3h.dbo_blog: ~3 rows (approximately)
/*!40000 ALTER TABLE `dbo_blog` DISABLE KEYS */;
INSERT INTO `dbo_blog` (`blog_id`, `title`, `image_blog`, `content`, `user_id`, `created_date`) VALUES
	(1, 'Black Friday Guide: Best Sales & Discount Codes', '/blog-02.jpg', 'Duis ut velit gravida nibh bibendum commodo. Sus-pendisse pellentesque mattis augue id euismod. Inter-dum et malesuada fames', 1, '2020-05-13 17:42:41'),
	(2, 'The White Sneakers Nearly Every Fashion Girls Own', '/blog-02.jpg', 'Nullam scelerisque, lacus sed consequat laoreet, dui enim iaculis leo, eu viverra ex nulla in tellus. Nullam nec ornare tellus, ac fringilla lacus. Ut sit ame', 1, '2020-05-13 17:42:41'),
	(3, 'New York SS 2018 Street Style: Annina Mislin', '/blog-02.jpg', 'Proin nec vehicula lorem, a efficitur ex. Nam vehicula nulla vel erat tincidunt, sed hendrerit ligula porttitor. Fusce sit amet maximus nunc', 1, '2020-05-13 17:42:41');
/*!40000 ALTER TABLE `dbo_blog` ENABLE KEYS */;

-- Dumping data for table db_demo_t3h.dbo_cart: ~7 rows (approximately)
/*!40000 ALTER TABLE `dbo_cart` DISABLE KEYS */;
INSERT INTO `dbo_cart` (`cart_id`, `guid`, `user_name`) VALUES
	(1, 'c3e71906-7e57-4a53-bf1f-5925619fd15b', NULL),
	(2, '2464058e-5bb5-410f-aea7-cbb0a458844e', NULL),
	(3, '708e5be5-89e4-4f8b-a052-825c31f9eb94', NULL),
	(4, '406dc6e9-fbb4-45fb-a3a1-3c04501fb3ad', NULL),
	(5, 'f60df777-ef31-4b87-92ab-3359e2657c52', NULL),
	(6, '43a7dbb6-2306-4aa1-ac62-3a9d747c89a5', NULL),
	(7, '196b2cb5-6577-4228-af9c-1410dfa99c32', NULL);
/*!40000 ALTER TABLE `dbo_cart` ENABLE KEYS */;

-- Dumping data for table db_demo_t3h.dbo_cart_product: ~0 rows (approximately)
/*!40000 ALTER TABLE `dbo_cart_product` DISABLE KEYS */;
INSERT INTO `dbo_cart_product` (`cart_product_id`, `cart_id`, `product_entity_id`, `amount`) VALUES
	(1, 1, 1, 2);
/*!40000 ALTER TABLE `dbo_cart_product` ENABLE KEYS */;

-- Dumping data for table db_demo_t3h.dbo_category: ~4 rows (approximately)
/*!40000 ALTER TABLE `dbo_category` DISABLE KEYS */;
INSERT INTO `dbo_category` (`category_id`, `name`, `short_desc`, `created_date`) VALUES
	(1, 'Category 1', 'short desc 1', '2020-04-19 18:39:06'),
	(2, 'Category 2', 'short desc 2', '2020-04-19 18:39:20'),
	(3, 'Category 3', 'short desc 3', '2020-04-19 18:39:32'),
	(4, 'Category 4', 'short desc 4', '2020-04-19 18:39:41');
/*!40000 ALTER TABLE `dbo_category` ENABLE KEYS */;

-- Dumping data for table db_demo_t3h.dbo_color: ~3 rows (approximately)
/*!40000 ALTER TABLE `dbo_color` DISABLE KEYS */;
INSERT INTO `dbo_color` (`color_id`, `name`, `short_desc`, `created_date`) VALUES
	(1, 'Blue', 'this is blue', '2020-05-05 10:34:39'),
	(2, 'Black', 'this is black', '2020-05-04 11:12:12'),
	(3, 'Red', 'this is red', '2020-05-04 11:12:16');
/*!40000 ALTER TABLE `dbo_color` ENABLE KEYS */;

-- Dumping data for table db_demo_t3h.dbo_order: ~0 rows (approximately)
/*!40000 ALTER TABLE `dbo_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `dbo_order` ENABLE KEYS */;

-- Dumping data for table db_demo_t3h.dbo_order_product: ~0 rows (approximately)
/*!40000 ALTER TABLE `dbo_order_product` DISABLE KEYS */;
/*!40000 ALTER TABLE `dbo_order_product` ENABLE KEYS */;

-- Dumping data for table db_demo_t3h.dbo_product: ~5 rows (approximately)
/*!40000 ALTER TABLE `dbo_product` DISABLE KEYS */;
INSERT INTO `dbo_product` (`product_id`, `product_name`, `short_desc`, `main_image`, `category_id`, `price`, `brand`, `created_date`) VALUES
	(1, 'Product 1', 'Product 1 short description', '/no_image.jpg', 2, 176.76, 'Viet Nam', '2020-05-11 18:04:32'),
	(2, 'Product 2', 'Product 2 short description', '/no_image.jpg', 1, 72.36, 'Japan', '2020-04-19 18:04:32'),
	(3, 'Product 3', 'Product 3 short description', '/no_image.jpg', 2, 153.54, 'Viet Nam', '2020-04-19 19:36:14'),
	(4, 'Product 4', 'Product 4 short description', '/no_image.jpg', 1, 129.21, 'Viet Nam', '2020-04-19 19:36:46'),
	(5, 'Product 5', 'Product 5 short description', '/no_image.jpg', 3, 99.88, 'Japan', '2020-04-19 21:30:16');
/*!40000 ALTER TABLE `dbo_product` ENABLE KEYS */;

-- Dumping data for table db_demo_t3h.dbo_product_entity: ~8 rows (approximately)
/*!40000 ALTER TABLE `dbo_product_entity` DISABLE KEYS */;
INSERT INTO `dbo_product_entity` (`product_entity_id`, `product_id`, `color_id`, `size_id`, `created_date`) VALUES
	(1, 1, 1, 2, '2020-05-11 11:20:00'),
	(2, 2, 3, 1, '2020-05-11 11:20:00'),
	(3, 1, 1, 2, '2020-05-11 11:20:00'),
	(4, 5, 3, 2, '2020-05-11 11:20:00'),
	(5, 4, 2, 2, '2020-05-11 11:20:00'),
	(6, 1, 2, 1, '2020-05-11 11:20:00'),
	(7, 1, 1, 3, '2020-05-11 11:20:00'),
	(8, 1, 3, 1, '2020-05-11 16:06:21');
/*!40000 ALTER TABLE `dbo_product_entity` ENABLE KEYS */;

-- Dumping data for table db_demo_t3h.dbo_product_image: ~6 rows (approximately)
/*!40000 ALTER TABLE `dbo_product_image` DISABLE KEYS */;
INSERT INTO `dbo_product_image` (`product_image_id`, `product_id`, `link`, `created_date`) VALUES
	(1, 1, '/no_image1.jpg', '2020-05-11 11:18:46'),
	(2, 1, '/no_image1.jpg', '2020-05-11 11:20:07'),
	(3, 1, '/no_image.jpg', '2020-05-11 11:20:07'),
	(4, 1, '/no_image.jpg', '2020-05-11 11:20:07'),
	(5, 1, '/no_image.jpg', '2020-05-11 11:20:07'),
	(6, 1, '/no_image.jpg', '2020-05-11 11:20:07');
/*!40000 ALTER TABLE `dbo_product_image` ENABLE KEYS */;

-- Dumping data for table db_demo_t3h.dbo_role: ~2 rows (approximately)
/*!40000 ALTER TABLE `dbo_role` DISABLE KEYS */;
INSERT INTO `dbo_role` (`role_id`, `name`) VALUES
	(1, 'ADMIN'),
	(2, 'USER');
/*!40000 ALTER TABLE `dbo_role` ENABLE KEYS */;

-- Dumping data for table db_demo_t3h.dbo_size: ~2 rows (approximately)
/*!40000 ALTER TABLE `dbo_size` DISABLE KEYS */;
INSERT INTO `dbo_size` (`size_id`, `name`, `short_desc`, `created_date`) VALUES
	(1, '37', 'this is 37 size', '2020-05-04 11:11:00'),
	(2, '38', 'this is 38 size', '2020-05-04 11:11:08'),
	(3, '39', 'this is 39 size', '2020-05-04 11:11:12');
/*!40000 ALTER TABLE `dbo_size` ENABLE KEYS */;

-- Dumping data for table db_demo_t3h.dbo_user: ~2 rows (approximately)
/*!40000 ALTER TABLE `dbo_user` DISABLE KEYS */;
INSERT INTO `dbo_user` (`user_id`, `user_name`, `email`, `avatar`, `name`, `gender`, `address`, `password_hash`, `phone_number`, `created_date`) VALUES
	(1, 'trieu.ngoquang', 'ngoquangtrieu99tb@gmail.com', NULL, 'Ngô Quang Triệu', 0, NULL, '$2a$10$qWM2dpyGZjla.XcdNGQcduX.mBqFY9chHMjPcDjyb14aKwEPmMe2W', 0, '2020-05-04 14:16:16'),
	(2, 'trang.dothi', 'trang.dothi@vti.com.vn', NULL, 'Đỗ Thị Thu Trang', 0, NULL, '$2a$10$XPqnsZ.Q.1KprnC0SaZR4uhGWYdzLPlt96e/MgsbDYHHWbinAot/y', 0, '2020-05-04 14:18:48');
/*!40000 ALTER TABLE `dbo_user` ENABLE KEYS */;

-- Dumping data for table db_demo_t3h.dbo_user_role: ~2 rows (approximately)
/*!40000 ALTER TABLE `dbo_user_role` DISABLE KEYS */;
INSERT INTO `dbo_user_role` (`user_role_id`, `user_id`, `role_id`) VALUES
	(1, 1, 2),
	(2, 2, 2);
/*!40000 ALTER TABLE `dbo_user_role` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
