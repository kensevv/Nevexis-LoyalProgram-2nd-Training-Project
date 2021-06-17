-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: loyal_program
-- ------------------------------------------------------
-- Server version	8.0.23

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
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `client` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `loyal_card_id` bigint DEFAULT NULL,
  `birthdate` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKbn3pdf82jm78fjn2pfcyxrch8` (`loyal_card_id`),
  CONSTRAINT `FKbn3pdf82jm78fjn2pfcyxrch8` FOREIGN KEY (`loyal_card_id`) REFERENCES `loyal_card` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES (1,'Kenan','Yusein','0876617490',1,'2000-06-05 00:00:00.000000'),(2,'Ivan','Tsonev','087679357',2,'1980-01-01 00:00:00.000000'),(3,'Vesko','Mesko','0896356874',3,'1950-01-01 00:00:00.000000');
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loyal_card`
--

DROP TABLE IF EXISTS `loyal_card`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `loyal_card` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `tier` varchar(255) DEFAULT NULL,
  `points` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loyal_card`
--

LOCK TABLES `loyal_card` WRITE;
/*!40000 ALTER TABLE `loyal_card` DISABLE KEYS */;
INSERT INTO `loyal_card` VALUES (1,'DIAMOND',9.00),(2,'BRONZE',0.00),(3,'SILVER',0.00);
/*!40000 ALTER TABLE `loyal_card` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `merchant`
--

DROP TABLE IF EXISTS `merchant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `merchant` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `company_registration_number` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `merchant`
--

LOCK TABLES `merchant` WRITE;
/*!40000 ALTER TABLE `merchant` DISABLE KEYS */;
/*!40000 ALTER TABLE `merchant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permission`
--

DROP TABLE IF EXISTS `permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `permission` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `permission` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permission`
--

LOCK TABLES `permission` WRITE;
/*!40000 ALTER TABLE `permission` DISABLE KEYS */;
INSERT INTO `permission` VALUES (1,'READ'),(2,'DELETE'),(3,'UPDATE'),(4,'INSERT');
/*!40000 ALTER TABLE `permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ROLE_ADMIN'),(2,'ROLE_CLIENT'),(3,'ROLE_OWNER'),(4,'ROLE_MERCHANT');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles_permissions`
--

DROP TABLE IF EXISTS `roles_permissions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles_permissions` (
  `roles_id` bigint NOT NULL,
  `permissions_id` bigint NOT NULL,
  `role_id` bigint NOT NULL,
  PRIMARY KEY (`roles_id`,`permissions_id`),
  KEY `FKa1duuqu7fiw2v9r5va5esghd5` (`permissions_id`),
  CONSTRAINT `FKa1duuqu7fiw2v9r5va5esghd5` FOREIGN KEY (`permissions_id`) REFERENCES `permission` (`id`),
  CONSTRAINT `FKlvxwcrxm02n6xlcr6r7f2oak3` FOREIGN KEY (`roles_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles_permissions`
--

LOCK TABLES `roles_permissions` WRITE;
/*!40000 ALTER TABLE `roles_permissions` DISABLE KEYS */;
INSERT INTO `roles_permissions` VALUES (1,1,0),(1,2,0),(1,3,0),(1,4,0),(2,1,0),(2,4,0),(3,1,0),(3,2,0),(3,3,0),(3,4,0),(4,1,0),(4,3,0),(4,4,0);
/*!40000 ALTER TABLE `roles_permissions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sale`
--

DROP TABLE IF EXISTS `sale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sale` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `client_id` bigint DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `received_points` decimal(10,2) DEFAULT NULL,
  `total_discount` decimal(10,2) DEFAULT NULL,
  `used_points` decimal(10,2) DEFAULT NULL,
  `date` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKon0o9ba5ajsnwivekhl1tfjiy` (`client_id`),
  CONSTRAINT `FKon0o9ba5ajsnwivekhl1tfjiy` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sale`
--

LOCK TABLES `sale` WRITE;
/*!40000 ALTER TABLE `sale` DISABLE KEYS */;
INSERT INTO `sale` VALUES (49,1,100.00,9.00,10.00,0.00,'2021-06-17 14:24:46.444936'),(50,1,100.00,9.00,28.00,36.00,'2021-06-17 14:25:16.924047'),(51,1,100.00,9.00,10.00,0.00,'2021-06-17 14:25:27.301679');
/*!40000 ALTER TABLE `sale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `enabled` bit(1) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `failed_attempts` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_ob8kqyqqgmefl0aco34akdtpe` (`email`),
  UNIQUE KEY `UK_sb8bbouer5wak8vyiiy4pf2bx` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'kensev2000@gmail.com',_binary '','$2a$10$iI5Thn39UDUFl8cc4YlBce.945q/yfYn3sqKxzVQM8CE/zuJyfJdC','kensev',0);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_auth_token`
--

DROP TABLE IF EXISTS `user_auth_token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_auth_token` (
  `encrypted_token` varchar(255) NOT NULL,
  `status` varchar(255) DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  `expiration_date` datetime(6) DEFAULT NULL,
  `issued_date` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`encrypted_token`),
  KEY `FKsgoqgsfs8lfll3g069mei5l13` (`user_id`),
  CONSTRAINT `FKsgoqgsfs8lfll3g069mei5l13` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_auth_token`
--

LOCK TABLES `user_auth_token` WRITE;
/*!40000 ALTER TABLE `user_auth_token` DISABLE KEYS */;
INSERT INTO `user_auth_token` VALUES ('7pLHBbeCGIsVAnOVODR7Ch3xV2Dj0fkPpLvVKmmpQvU=','VALID',1,'2021-06-17 15:24:08.606021','2021-06-17 14:24:08.616991'),('ROmtrT16sPDDe4pTe7LyAWlbiO0jiHm8vOaM38UP9N0=','VALID',1,'2021-06-17 15:25:30.214290','2021-06-17 14:25:30.218535'),('sSl6G7X//6YTuCnxPoHTlU6olVI9tZUQc3ff2Pyd0mg=','VALID',1,'2021-06-17 15:25:29.461528','2021-06-17 14:25:29.466525');
/*!40000 ALTER TABLE `user_auth_token` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_roles`
--

DROP TABLE IF EXISTS `users_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users_roles` (
  `user_id` bigint NOT NULL,
  `roles_id` bigint NOT NULL,
  PRIMARY KEY (`user_id`,`roles_id`),
  KEY `FK15d410tj6juko0sq9k4km60xq` (`roles_id`),
  CONSTRAINT `FK15d410tj6juko0sq9k4km60xq` FOREIGN KEY (`roles_id`) REFERENCES `role` (`id`),
  CONSTRAINT `FKgd3iendaoyh04b95ykqise6qh` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_roles`
--

LOCK TABLES `users_roles` WRITE;
/*!40000 ALTER TABLE `users_roles` DISABLE KEYS */;
INSERT INTO `users_roles` VALUES (1,1);
/*!40000 ALTER TABLE `users_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'loyal_program'
--

--
-- Dumping routines for database 'loyal_program'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-06-17 14:28:42
