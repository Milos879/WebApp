-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: ketering555
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `korisnik`
--

DROP TABLE IF EXISTS `korisnik`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `korisnik` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `role` varchar(45) NOT NULL,
  `discount` tinyint DEFAULT '1',
  `surname` varchar(45) NOT NULL,
  `address` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `korisnik`
--

LOCK TABLES `korisnik` WRITE;
/*!40000 ALTER TABLE `korisnik` DISABLE KEYS */;
INSERT INTO `korisnik` VALUES (7,'Dejane','dejan@gmail.com','123','menadzer',1,'Dejanovic','Balkansa 6'),(8,'Admin1','admin@gmail.com','123','admin',1,'Adamovski','Ruska 9'),(9,'menazder3','menadzer@gmail.com','12345','menadzer',1,'Jovanovic','Visnjicka 3'),(11,'Dejan','deki@gmail.com','123','klijent',0,'Markovic','Knez 1'),(12,'menadzer','men@gmail.com','555','menadzer',1,'menazderovice','Hotelska 5');
/*!40000 ALTER TABLE `korisnik` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ponude`
--

DROP TABLE IF EXISTS `ponude`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ponude` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) COLLATE utf8mb3_unicode_ci NOT NULL,
  `image` varchar(100) COLLATE utf8mb3_unicode_ci NOT NULL,
  `active` tinyint NOT NULL,
  `category` varchar(45) COLLATE utf8mb3_unicode_ci NOT NULL,
  `price` double NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ponude`
--

LOCK TABLES `ponude` WRITE;
/*!40000 ALTER TABLE `ponude` DISABLE KEYS */;
INSERT INTO `ponude` VALUES (1,'Proslave','proslava.jpg',1,'SLANI',239.12),(2,'Filmski','filmski.jpg',0,'SLANI',345.33),(3,'Slave','slave.jpg',1,'POSNI',123.55),(4,'Rodjendan','rodjendanski.jpg',1,'SALTKI',555),(5,'Posni','posni.jpg',1,'POSNI',34.56),(6,'Korporativni','korporativni.jpg',1,'MIX',1000),(7,'Svadbe','svadbe.jpg',0,'MIX',772);
/*!40000 ALTER TABLE `ponude` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `porudzbina`
--

DROP TABLE IF EXISTS `porudzbina`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `porudzbina` (
  `id` int NOT NULL AUTO_INCREMENT,
  `korisnik_id` int NOT NULL,
  `ponuda_id` int NOT NULL,
  `kolicina` int NOT NULL,
  `cena` double NOT NULL,
  `date` varchar(150) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `address` varchar(150) COLLATE utf8mb3_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_id_idx` (`korisnik_id`),
  KEY `fk_ponuda_id_idx` (`ponuda_id`),
  CONSTRAINT `fk_ponuda_id` FOREIGN KEY (`ponuda_id`) REFERENCES `ponude` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_user_id` FOREIGN KEY (`korisnik_id`) REFERENCES `korisnik` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `porudzbina`
--

LOCK TABLES `porudzbina` WRITE;
/*!40000 ALTER TABLE `porudzbina` DISABLE KEYS */;
INSERT INTO `porudzbina` VALUES (11,7,2,16,5525.28,'2022-08-02','Balkansa 6'),(12,11,1,4,956.48,'2022-08-02','Knez 1'),(13,11,5,4,138.24,'2022-08-02','Knez 1'),(14,11,4,17,9435,'2022-08-03','Knez 1');
/*!40000 ALTER TABLE `porudzbina` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-27  5:19:50
