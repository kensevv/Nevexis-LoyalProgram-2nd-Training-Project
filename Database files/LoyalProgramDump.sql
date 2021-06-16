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
  `birthdate` date DEFAULT NULL,
  `loyal_card_id` bigint DEFAULT NULL,
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
INSERT INTO `client` VALUES (1,'Kenan','Yusein','0876617490','2000-06-05',1),(2,'Ivan','Tsonev','087679357','1997-03-01',2),(3,'Vesko','Mesko','0896356874','1990-01-01',3);
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
  `points` double DEFAULT NULL,
  `tier` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loyal_card`
--

LOCK TABLES `loyal_card` WRITE;
/*!40000 ALTER TABLE `loyal_card` DISABLE KEYS */;
INSERT INTO `loyal_card` VALUES (1,60,'DIAMOND'),(2,12,'BRONZE'),(3,0,'SILVER');
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permission`
--

LOCK TABLES `permission` WRITE;
/*!40000 ALTER TABLE `permission` DISABLE KEYS */;
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
  `role_id` bigint NOT NULL,
  `permissions_id` bigint NOT NULL,
  PRIMARY KEY (`role_id`,`permissions_id`),
  KEY `FKa1duuqu7fiw2v9r5va5esghd5` (`permissions_id`),
  CONSTRAINT `FK4hrolwj4ned5i7qe8kyiaak6m` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `FKa1duuqu7fiw2v9r5va5esghd5` FOREIGN KEY (`permissions_id`) REFERENCES `permission` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles_permissions`
--

LOCK TABLES `roles_permissions` WRITE;
/*!40000 ALTER TABLE `roles_permissions` DISABLE KEYS */;
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
  `date` date DEFAULT NULL,
  `price` double DEFAULT NULL,
  `client_id` bigint DEFAULT NULL,
  `total_discount` double DEFAULT NULL,
  `received_points` double DEFAULT NULL,
  `used_points` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKon0o9ba5ajsnwivekhl1tfjiy` (`client_id`),
  CONSTRAINT `FKon0o9ba5ajsnwivekhl1tfjiy` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sale`
--

LOCK TABLES `sale` WRITE;
/*!40000 ALTER TABLE `sale` DISABLE KEYS */;
INSERT INTO `sale` VALUES (5,'2021-06-16',200,1,20,18,NULL);
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
  `token_hash` int NOT NULL,
  `status` varchar(255) DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  `expiration_date` datetime(6) DEFAULT NULL,
  `issued_date` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`token_hash`),
  KEY `FKsgoqgsfs8lfll3g069mei5l13` (`user_id`),
  CONSTRAINT `FKsgoqgsfs8lfll3g069mei5l13` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_auth_token`
--

LOCK TABLES `user_auth_token` WRITE;
/*!40000 ALTER TABLE `user_auth_token` DISABLE KEYS */;
INSERT INTO `user_auth_token` VALUES (-2115111229,'VALID',1,'2021-06-04 10:21:33.208000','2021-06-04 09:21:33.214000'),(-1803761939,'VALID',1,'2021-06-04 10:28:05.321000','2021-06-04 09:28:05.325000'),(-1696820020,'VALID',1,'2021-06-04 10:26:59.377000','2021-06-04 09:26:59.380000'),(-1471687387,'VALID',1,'2021-06-03 17:21:09.328000','2021-06-03 16:21:09.333000'),(-1417356076,'VALID',1,'2021-06-04 11:44:49.332000','2021-06-04 10:44:49.336000'),(-1272699261,'EXPIRED',1,'2021-06-16 13:01:12.189000','2021-06-16 12:01:12.197000'),(-729166310,'VALID',1,'2021-06-03 17:26:54.882000','2021-06-03 16:26:54.886000'),(-470695745,'VALID',1,'2021-06-04 12:14:52.263000','2021-06-04 11:14:52.268000'),(-447963957,'VALID',1,'2021-06-04 10:25:49.513000','2021-06-04 09:25:49.516000'),(-444073876,'VALID',1,'2021-06-03 15:27:57.527000','2021-06-03 14:27:57.532000'),(-388496952,'VALID',1,'2021-06-11 12:36:00.883000','2021-06-11 11:36:00.890000'),(-381846805,'VALID',1,'2021-06-16 12:59:28.886000','2021-06-16 11:59:28.892000'),(-336196642,'VALID',1,'2021-06-04 10:32:00.891000','2021-06-04 09:32:00.895000'),(72565318,'VALID',1,'2021-06-04 10:31:19.976000','2021-06-04 09:31:19.979000'),(95441026,'VALID',1,'2021-06-04 11:43:16.748000','2021-06-04 10:43:16.754000'),(371427088,'VALID',1,'2021-06-04 10:29:54.062000','2021-06-04 09:29:54.066000'),(471197049,'VALID',1,'2021-06-04 12:14:17.582000','2021-06-04 11:14:17.587000'),(597633371,'VALID',1,'2021-06-04 10:30:56.632000','2021-06-04 09:30:56.637000'),(778961393,'VALID',1,'2021-06-03 17:11:56.884000','2021-06-03 16:11:56.890000'),(820985153,'VALID',1,'2021-06-16 16:00:20.144000','2021-06-16 15:00:20.149000'),(1224389223,'VALID',1,'2021-06-04 10:24:49.914000','2021-06-04 09:24:49.919000'),(1238074612,'VALID',1,'2021-06-04 10:25:21.505000','2021-06-04 09:25:21.508000'),(1300859559,'VALID',1,'2021-06-04 10:28:52.001000','2021-06-04 09:28:52.004000'),(1413902156,'VALID',1,'2021-06-04 11:45:59.716000','2021-06-04 10:45:59.720000'),(1640625826,'VALID',1,'2021-06-04 11:45:11.971000','2021-06-04 10:45:11.975000'),(1766354134,'VALID',1,'2021-06-04 11:44:26.731000','2021-06-04 10:44:26.735000'),(1772039656,'VALID',1,'2021-06-04 11:45:28.313000','2021-06-04 10:45:28.317000'),(1957578319,'VALID',1,'2021-06-04 11:40:54.742000','2021-06-04 10:40:54.745000');
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

-- Dump completed on 2021-06-16 15:08:31
