-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: db_demo_t3h
-- ------------------------------------------------------
-- Server version	8.0.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `dbo_cart`
--

DROP TABLE IF EXISTS `dbo_cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dbo_cart` (
  `cart_id` int NOT NULL AUTO_INCREMENT,
  `guid` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `user_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`cart_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dbo_cart`
--

LOCK TABLES `dbo_cart` WRITE;
/*!40000 ALTER TABLE `dbo_cart` DISABLE KEYS */;
/*!40000 ALTER TABLE `dbo_cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dbo_cart_product`
--

DROP TABLE IF EXISTS `dbo_cart_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dbo_cart_product` (
  `cart_product_id` int NOT NULL AUTO_INCREMENT,
  `cart_id` int DEFAULT NULL,
  `product_id` int DEFAULT NULL,
  `amount` int DEFAULT NULL,
  PRIMARY KEY (`cart_product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dbo_cart_product`
--

LOCK TABLES `dbo_cart_product` WRITE;
/*!40000 ALTER TABLE `dbo_cart_product` DISABLE KEYS */;
/*!40000 ALTER TABLE `dbo_cart_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dbo_category`
--

DROP TABLE IF EXISTS `dbo_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dbo_category` (
  `category_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `short_desc` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dbo_category`
--

LOCK TABLES `dbo_category` WRITE;
/*!40000 ALTER TABLE `dbo_category` DISABLE KEYS */;
/*!40000 ALTER TABLE `dbo_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dbo_color`
--

DROP TABLE IF EXISTS `dbo_color`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dbo_color` (
  `color_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  PRIMARY KEY (`color_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dbo_color`
--

LOCK TABLES `dbo_color` WRITE;
/*!40000 ALTER TABLE `dbo_color` DISABLE KEYS */;
/*!40000 ALTER TABLE `dbo_color` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dbo_oder`
--

DROP TABLE IF EXISTS `dbo_oder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dbo_oder` (
  `oder_id` int NOT NULL AUTO_INCREMENT,
  `guid` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `user_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `customer_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `phone_number` int DEFAULT NULL,
  `address` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `price` double DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `ship` double DEFAULT NULL,
  PRIMARY KEY (`oder_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dbo_oder`
--

LOCK TABLES `dbo_oder` WRITE;
/*!40000 ALTER TABLE `dbo_oder` DISABLE KEYS */;
/*!40000 ALTER TABLE `dbo_oder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dbo_oder_product`
--

DROP TABLE IF EXISTS `dbo_oder_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dbo_oder_product` (
  `oder_product_id` int NOT NULL AUTO_INCREMENT,
  `product_id` int DEFAULT NULL,
  `oder_id` int DEFAULT NULL,
  PRIMARY KEY (`oder_product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='		';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dbo_oder_product`
--

LOCK TABLES `dbo_oder_product` WRITE;
/*!40000 ALTER TABLE `dbo_oder_product` DISABLE KEYS */;
/*!40000 ALTER TABLE `dbo_oder_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dbo_product`
--

DROP TABLE IF EXISTS `dbo_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dbo_product` (
  `product_id` int NOT NULL AUTO_INCREMENT,
  `product_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `short_desc` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `main_image` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `category_id` int DEFAULT NULL,
  `price` double DEFAULT NULL,
  `brand` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dbo_product`
--

LOCK TABLES `dbo_product` WRITE;
/*!40000 ALTER TABLE `dbo_product` DISABLE KEYS */;
/*!40000 ALTER TABLE `dbo_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dbo_product_entity`
--

DROP TABLE IF EXISTS `dbo_product_entity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dbo_product_entity` (
  `product_entity_id` int NOT NULL AUTO_INCREMENT,
  `product_id` int DEFAULT NULL,
  `color_id` int DEFAULT NULL,
  `size_id` int DEFAULT NULL,
  PRIMARY KEY (`product_entity_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dbo_product_entity`
--

LOCK TABLES `dbo_product_entity` WRITE;
/*!40000 ALTER TABLE `dbo_product_entity` DISABLE KEYS */;
/*!40000 ALTER TABLE `dbo_product_entity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dbo_role`
--

DROP TABLE IF EXISTS `dbo_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dbo_role` (
  `role_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dbo_role`
--

LOCK TABLES `dbo_role` WRITE;
/*!40000 ALTER TABLE `dbo_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `dbo_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dbo_size`
--

DROP TABLE IF EXISTS `dbo_size`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dbo_size` (
  `size_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  PRIMARY KEY (`size_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dbo_size`
--

LOCK TABLES `dbo_size` WRITE;
/*!40000 ALTER TABLE `dbo_size` DISABLE KEYS */;
/*!40000 ALTER TABLE `dbo_size` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dbo_user`
--

DROP TABLE IF EXISTS `dbo_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dbo_user` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `avatar` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `gender` int DEFAULT NULL,
  `address` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password_hash` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `phone_number` int DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dbo_user`
--

LOCK TABLES `dbo_user` WRITE;
/*!40000 ALTER TABLE `dbo_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `dbo_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dbo_user_role`
--

DROP TABLE IF EXISTS `dbo_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dbo_user_role` (
  `user_role_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `role_id` int DEFAULT NULL,
  PRIMARY KEY (`user_role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dbo_user_role`
--

LOCK TABLES `dbo_user_role` WRITE;
/*!40000 ALTER TABLE `dbo_user_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `dbo_user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-02-15 11:51:43

-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: db_demo_t3h
-- ------------------------------------------------------
-- Server version 8.0.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `dbo_product_image`
--

DROP TABLE IF EXISTS `dbo_product_image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dbo_product_image` (
  `product_image_id` int NOT NULL AUTO_INCREMENT,
  `product_id` int NOT NULL,
  `link` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  PRIMARY KEY (`product_image_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dbo_product_image`
--

LOCK TABLES `dbo_product_image` WRITE;
/*!40000 ALTER TABLE `dbo_product_image` DISABLE KEYS */;
/*!40000 ALTER TABLE `dbo_product_image` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-03-01  9:52:07

