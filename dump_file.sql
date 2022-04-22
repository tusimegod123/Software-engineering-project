-- MySQL dump 10.13  Distrib 8.0.28, for macos12.2 (x86_64)
--
-- Host: localhost    Database: hotel_booking_db
-- ------------------------------------------------------
-- Server version	8.0.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `book_hotel`
--

DROP TABLE IF EXISTS `book_hotel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book_hotel` (
  `booking_id` int NOT NULL AUTO_INCREMENT,
  `date_of_arrival` date DEFAULT NULL,
  `date_of_departure` date DEFAULT NULL,
  `number_of_rooms` int NOT NULL,
  `other_reservations` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`booking_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_hotel`
--

LOCK TABLES `book_hotel` WRITE;
/*!40000 ALTER TABLE `book_hotel` DISABLE KEYS */;
INSERT INTO `book_hotel` VALUES (1,'2022-04-23','2022-04-25',2,'parking'),(2,'2022-04-22','2022-04-22',2,'Heating');
/*!40000 ALTER TABLE `book_hotel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (2);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rooms`
--

DROP TABLE IF EXISTS `rooms`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rooms` (
  `room_id` bigint NOT NULL AUTO_INCREMENT,
  `available` bit(1) NOT NULL,
  `bed_type` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `max_number_of_guests` int DEFAULT NULL,
  `number_of_beds` int DEFAULT NULL,
  `price` double DEFAULT NULL,
  `room_number` int DEFAULT NULL,
  `smoking` bit(1) NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  `booking_id` int DEFAULT NULL,
  PRIMARY KEY (`room_id`),
  UNIQUE KEY `UK_7ljglxlj90ln3lbas4kl983m2` (`room_number`),
  KEY `FKbfmp4bryn6i6211ghcdeim5u9` (`booking_id`),
  CONSTRAINT `FKbfmp4bryn6i6211ghcdeim5u9` FOREIGN KEY (`booking_id`) REFERENCES `book_hotel` (`booking_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rooms`
--

LOCK TABLES `rooms` WRITE;
/*!40000 ALTER TABLE `rooms` DISABLE KEYS */;
INSERT INTO `rooms` VALUES (1,_binary '\0','Small','wifi Available',2,2,30,2,_binary '\0','Double',1),(2,_binary '\0','King','wifi Available',2,3,50,3,_binary '\0','Double',2);
/*!40000 ALTER TABLE `rooms` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` bigint NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'jdoe@gmail.com','John Doe','test');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_bookings`
--

DROP TABLE IF EXISTS `users_bookings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users_bookings` (
  `booking_id` int NOT NULL,
  `id` bigint NOT NULL,
  PRIMARY KEY (`booking_id`,`id`),
  KEY `FKgj5cq24pfyhc9jx30pb47xr43` (`id`),
  CONSTRAINT `FKgj5cq24pfyhc9jx30pb47xr43` FOREIGN KEY (`id`) REFERENCES `users` (`id`),
  CONSTRAINT `FKoi3roit2aa2fgxn23503eqa8q` FOREIGN KEY (`booking_id`) REFERENCES `book_hotel` (`booking_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_bookings`
--

LOCK TABLES `users_bookings` WRITE;
/*!40000 ALTER TABLE `users_bookings` DISABLE KEYS */;
INSERT INTO `users_bookings` VALUES (1,1),(2,1);
/*!40000 ALTER TABLE `users_bookings` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-20 22:20:45
