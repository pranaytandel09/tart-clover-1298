CREATE DATABASE  IF NOT EXISTS `cwp` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `cwp`;
-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: cwp
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Table structure for table `bus`
--

DROP TABLE IF EXISTS `bus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bus` (
  `bus_id` int NOT NULL AUTO_INCREMENT,
  `arrival_time` time(6) DEFAULT NULL,
  `available_seats` int DEFAULT NULL,
  `bus_name` varchar(255) DEFAULT NULL,
  `bus_type` varchar(255) DEFAULT NULL,
  `departure_time` time(6) DEFAULT NULL,
  `driver_name` varchar(255) DEFAULT NULL,
  `route_from` varchar(255) DEFAULT NULL,
  `route_to` varchar(255) DEFAULT NULL,
  `seats` int DEFAULT NULL,
  `route_route_id` int DEFAULT NULL,
  PRIMARY KEY (`bus_id`),
  KEY `FK34202857f4x6hu34lxlbh7y69` (`route_route_id`),
  CONSTRAINT `FK34202857f4x6hu34lxlbh7y69` FOREIGN KEY (`route_route_id`) REFERENCES `route` (`route_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bus`
--

LOCK TABLES `bus` WRITE;
/*!40000 ALTER TABLE `bus` DISABLE KEYS */;
INSERT INTO `bus` VALUES (1,'02:05:20.000000',19,'Shikari Travlers','AC','07:05:20.000000','Raju','Mumbai','Pune',40,1),(2,'02:05:20.000000',19,'Shikari Travlers','Non-AC','07:05:20.000000','Kala','Mumbai','Pune',40,1),(3,'01:05:20.000000',10,'Maharastra Travlers','Non-AC','03:05:20.000000','ABC','Matheran','Pune',35,2),(4,'05:05:20.000000',9,'ABC Travlers','AC','03:05:20.000000','CDS','Delhi','Mumbai',35,3),(5,'04:05:20.000000',10,'Goa Travlers','AC','02:05:20.000000','KBC','Goa','Mumbai',35,4);
/*!40000 ALTER TABLE `bus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `current_user_session`
--

DROP TABLE IF EXISTS `current_user_session`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `current_user_session` (
  `user_id` int NOT NULL,
  `local_date_time` datetime(6) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `uuid` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `current_user_session`
--

LOCK TABLES `current_user_session` WRITE;
/*!40000 ALTER TABLE `current_user_session` DISABLE KEYS */;
/*!40000 ALTER TABLE `current_user_session` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `feedback`
--

DROP TABLE IF EXISTS `feedback`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `feedback` (
  `feedback_id` int NOT NULL AUTO_INCREMENT,
  `comments` varchar(255) DEFAULT NULL,
  `driver_rating` int DEFAULT NULL,
  `feedback_date` date DEFAULT NULL,
  `overall_rating` int DEFAULT NULL,
  `service_rating` int DEFAULT NULL,
  `bus_bus_id` int DEFAULT NULL,
  `user_user_login_id` int DEFAULT NULL,
  PRIMARY KEY (`feedback_id`),
  UNIQUE KEY `UK_r88sg8b6tlok026lw3mrwt668` (`bus_bus_id`),
  UNIQUE KEY `UK_7c9bdhspllm9go6dnx9s63p9p` (`user_user_login_id`),
  CONSTRAINT `FK3cscao38988bj2d3glpvn2c0t` FOREIGN KEY (`user_user_login_id`) REFERENCES `user` (`user_login_id`),
  CONSTRAINT `FKnsyckbsa0g31fueyt4lyr7as9` FOREIGN KEY (`bus_bus_id`) REFERENCES `bus` (`bus_id`),
  CONSTRAINT `feedback_chk_1` CHECK (((`driver_rating` >= 1) and (`driver_rating` <= 10))),
  CONSTRAINT `feedback_chk_2` CHECK (((`overall_rating` >= 1) and (`overall_rating` <= 10))),
  CONSTRAINT `feedback_chk_3` CHECK (((`service_rating` >= 1) and (`service_rating` <= 10)))
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `feedback`
--

LOCK TABLES `feedback` WRITE;
/*!40000 ALTER TABLE `feedback` DISABLE KEYS */;
INSERT INTO `feedback` VALUES (1,'Had a good service',7,'2023-10-03',7,7,1,5),(28,'ssdfj',1,'2023-10-03',3,2,2,1);
/*!40000 ALTER TABLE `feedback` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservation`
--

DROP TABLE IF EXISTS `reservation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reservation` (
  `reservation_id` int NOT NULL AUTO_INCREMENT,
  `destination` varchar(255) DEFAULT NULL,
  `reservation_date` date DEFAULT NULL,
  `reservation_status` varchar(255) DEFAULT NULL,
  `reservation_time` time(6) DEFAULT NULL,
  `reservation_type` varchar(255) DEFAULT NULL,
  `source` varchar(255) DEFAULT NULL,
  `bus_bus_id` int DEFAULT NULL,
  PRIMARY KEY (`reservation_id`),
  UNIQUE KEY `UK_d9bxpew7nosnn0ob9a9jrwaoq` (`bus_bus_id`),
  CONSTRAINT `FK1cwae71jt1ek8y0yhcdshjuta` FOREIGN KEY (`bus_bus_id`) REFERENCES `bus` (`bus_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservation`
--

LOCK TABLES `reservation` WRITE;
/*!40000 ALTER TABLE `reservation` DISABLE KEYS */;
INSERT INTO `reservation` VALUES (2,'Pune','2023-10-09','Booked','18:56:42.598000','Online','Matheran',3),(3,'Pune','2023-10-06','Booked','19:05:14.928000','Online','Mumbai',1),(4,'Mumbai','2023-10-09','Booked','19:18:31.576000','Online','Delhi',4),(5,'Pune','2023-10-09','Booked','19:25:29.601000','Online','Mumbai',2);
/*!40000 ALTER TABLE `reservation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `route`
--

DROP TABLE IF EXISTS `route`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `route` (
  `route_id` int NOT NULL AUTO_INCREMENT,
  `distance` int DEFAULT NULL,
  `route_from` varchar(255) DEFAULT NULL,
  `route_to` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`route_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `route`
--

LOCK TABLES `route` WRITE;
/*!40000 ALTER TABLE `route` DISABLE KEYS */;
INSERT INTO `route` VALUES (1,150,'Mumbai','Pune'),(2,100,'Matheran','Pune'),(3,400,'Delhi','Mumbai'),(4,300,'Goa','Mumbai'),(5,40,'MP chowk','UP chowk');
/*!40000 ALTER TABLE `route` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_login_id` int NOT NULL AUTO_INCREMENT,
  `contact` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `password` varchar(10) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `reservation_reservation_id` int DEFAULT NULL,
  PRIMARY KEY (`user_login_id`),
  UNIQUE KEY `UK_lqjrcobrh9jc8wpcar64q1bfh` (`user_name`),
  UNIQUE KEY `UK_4h7cmhnierc8odmidy9iuincc` (`reservation_reservation_id`),
  CONSTRAINT `FK2ngkxieol1mq09cdbvpum6ys8` FOREIGN KEY (`reservation_reservation_id`) REFERENCES `reservation` (`reservation_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'9960524286','kishorkamble589@gmail.com','Kishor','Kamble','kishor','Kishor',5),(3,'8060646864','pranay@gmail.com','Pranay','Pranay','pranay','Pranay',NULL),(5,'9912345333','aman@gmail.com','Aman','Choure','123456','aman',4),(6,'9772472914','abc@gmail.com','ABCED','abc','ab333c','BCD',NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-10-03 22:56:31
