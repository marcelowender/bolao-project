CREATE DATABASE  IF NOT EXISTS `bolao_db` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `bolao_db`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: bolao_db
-- ------------------------------------------------------
-- Server version	5.5.57-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `clube`
--

DROP TABLE IF EXISTS `clube`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clube` (
  `ID_CLUBE` int(11) NOT NULL AUTO_INCREMENT,
  `NOME_CLUBE` varchar(100) NOT NULL,
  `NOME_LOGO_CLUBE` varchar(45) DEFAULT NULL,
  `PAIS_CLUBE` varchar(45) DEFAULT NULL,
  `UF_CLUBE` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`ID_CLUBE`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clube`
--

LOCK TABLES `clube` WRITE;
/*!40000 ALTER TABLE `clube` DISABLE KEYS */;
INSERT INTO `clube` VALUES (1,'Atletico MG','atleico','BR','MG'),(2,'Cruzeiro','cruzeiro','BR','MG'),(3,'América MG','americaMg','BR','MG'),(4,'Caldense MG','caldenseMg','BR','MG'),(29,'Teste MG','urtMg','BR','MG'),(30,'Teste MG','urtMg','BR','MG');
/*!40000 ALTER TABLE `clube` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `competicao`
--

DROP TABLE IF EXISTS `competicao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `competicao` (
  `ID_COMPETICAO` int(11) NOT NULL AUTO_INCREMENT,
  `NOME_COMPETICAO` varchar(200) NOT NULL,
  `DATA_INICIO_COMPETICAO` date NOT NULL,
  `DATA_FIM_COMPETICAO` datetime DEFAULT NULL,
  PRIMARY KEY (`ID_COMPETICAO`),
  UNIQUE KEY `ID_COMPETICAO_UNIQUE` (`ID_COMPETICAO`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `competicao`
--

LOCK TABLES `competicao` WRITE;
/*!40000 ALTER TABLE `competicao` DISABLE KEYS */;
INSERT INTO `competicao` VALUES (1,'Campeonato Brasileiro 2018','2018-01-01','2018-01-01 00:00:00'),(27,'Copa do Brasil','2018-01-01','2018-01-01 00:00:00'),(31,'Copa do Brasil 2018','2018-01-01','2018-01-01 00:00:00'),(32,'Copa do Brasil 2019','2018-01-01','2018-01-01 00:00:00'),(37,'Copa do Brasil 2020','2018-01-01','2018-01-01 00:00:00');
/*!40000 ALTER TABLE `competicao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (41),(41),(41),(41),(41),(41);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jogo`
--

DROP TABLE IF EXISTS `jogo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jogo` (
  `ID_JOGO` int(11) NOT NULL AUTO_INCREMENT,
  `ID_COMPETICAO` int(11) NOT NULL,
  `ID_CLUBE_MANDANTE` int(11) NOT NULL,
  `ID_CLUBE_VISITANTE` int(11) NOT NULL,
  `DATA_JOGO` datetime NOT NULL,
  `GOLS_MANDANTE` int(11) DEFAULT NULL,
  `GOLS_VISITANTE` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_JOGO`),
  KEY `FK_COMPETICAO_idx` (`ID_COMPETICAO`),
  KEY `FK_MANDANTE_idx` (`ID_CLUBE_MANDANTE`),
  KEY `FK_VISITANTE_idx` (`ID_CLUBE_VISITANTE`),
  CONSTRAINT `FK5w23yrpp6h7pn352xyq88g9go` FOREIGN KEY (`ID_CLUBE_VISITANTE`) REFERENCES `clube` (`ID_CLUBE`),
  CONSTRAINT `FKec3a1rk10q9s65mgaitr0m2av` FOREIGN KEY (`ID_COMPETICAO`) REFERENCES `competicao` (`ID_COMPETICAO`),
  CONSTRAINT `FKrnmmrehqxody8u7f4b87hq73l` FOREIGN KEY (`ID_CLUBE_MANDANTE`) REFERENCES `clube` (`ID_CLUBE`),
  CONSTRAINT `FK_COMPETICAO` FOREIGN KEY (`ID_COMPETICAO`) REFERENCES `competicao` (`ID_COMPETICAO`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_MANDANTE` FOREIGN KEY (`ID_CLUBE_MANDANTE`) REFERENCES `clube` (`ID_CLUBE`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_VISITANTE` FOREIGN KEY (`ID_CLUBE_VISITANTE`) REFERENCES `clube` (`ID_CLUBE`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jogo`
--

LOCK TABLES `jogo` WRITE;
/*!40000 ALTER TABLE `jogo` DISABLE KEYS */;
INSERT INTO `jogo` VALUES (1,1,1,2,'2018-03-04 00:00:00',2,0),(10,1,2,1,'2018-03-04 00:00:00',1,2),(11,1,2,1,'2018-03-04 00:00:00',1,2),(12,1,2,1,'2018-03-04 00:00:00',1,2),(13,1,2,1,'2018-03-04 00:00:00',1,2),(14,1,2,1,'2018-03-04 00:00:00',1,2),(15,1,2,1,'2018-03-04 00:00:00',1,2),(16,1,2,1,'2018-03-04 00:00:00',1,2),(17,1,2,1,'2018-03-04 00:00:00',1,2),(18,1,2,1,'2018-03-04 00:00:00',1,2),(19,1,2,1,'2018-03-04 00:00:00',1,2),(20,1,2,1,'2018-03-04 00:00:00',1,2),(21,1,2,1,'2018-03-04 00:00:00',1,2),(23,1,2,1,'2018-03-04 00:00:00',NULL,NULL),(24,1,2,1,'2018-03-04 00:00:00',NULL,NULL),(25,1,2,1,'2018-03-04 00:00:00',NULL,NULL),(26,1,2,1,'2018-03-04 00:00:00',NULL,NULL),(33,1,2,1,'2018-03-04 00:00:00',NULL,NULL);
/*!40000 ALTER TABLE `jogo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `liga`
--

DROP TABLE IF EXISTS `liga`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `liga` (
  `ID_LIGA` int(11) NOT NULL AUTO_INCREMENT,
  `ID_COMPETICAO` int(11) NOT NULL,
  `NOME_LIGA` varchar(150) NOT NULL,
  `DATA_CRIACAO_LIGA` datetime NOT NULL,
  PRIMARY KEY (`ID_LIGA`),
  UNIQUE KEY `ID_LIGA_UNIQUE` (`ID_LIGA`),
  KEY `FK_ID_COMPETICAO_idx` (`ID_COMPETICAO`),
  CONSTRAINT `FKg3n1tm6noj9ej60tiun67720t` FOREIGN KEY (`ID_COMPETICAO`) REFERENCES `competicao` (`ID_COMPETICAO`),
  CONSTRAINT `FK_ID_COMPETICAO` FOREIGN KEY (`ID_COMPETICAO`) REFERENCES `competicao` (`ID_COMPETICAO`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `liga`
--

LOCK TABLES `liga` WRITE;
/*!40000 ALTER TABLE `liga` DISABLE KEYS */;
INSERT INTO `liga` VALUES (1,1,'Bolao Linx','2018-03-03 00:00:00'),(34,1,'Quebrando o Cartola','2018-03-03 00:00:00'),(38,1,'Quebrando o Cartola2','2018-03-03 00:00:00');
/*!40000 ALTER TABLE `liga` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `palpite`
--

DROP TABLE IF EXISTS `palpite`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `palpite` (
  `ID_PALPITE` int(11) NOT NULL AUTO_INCREMENT,
  `ID_JOGO` int(11) NOT NULL,
  `ID_USUARIO` int(11) NOT NULL,
  `GOLS_MANDANTE` int(11) DEFAULT NULL,
  `GOLS_VISITANTE` int(11) DEFAULT NULL,
  `DATA_PALPITE` datetime DEFAULT NULL,
  PRIMARY KEY (`ID_PALPITE`),
  KEY `FK_JOGO_idx` (`ID_JOGO`),
  KEY `FK_USUARIO_idx` (`ID_USUARIO`),
  CONSTRAINT `FK6lyixh0lirr86tol9kowldnrt` FOREIGN KEY (`ID_JOGO`) REFERENCES `jogo` (`ID_JOGO`),
  CONSTRAINT `FK9dleass7liu1i7kahxd2jwm6s` FOREIGN KEY (`ID_USUARIO`) REFERENCES `usuario` (`ID_USUARIO`),
  CONSTRAINT `FK_JOGO` FOREIGN KEY (`ID_JOGO`) REFERENCES `jogo` (`ID_JOGO`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_USUARIO` FOREIGN KEY (`ID_USUARIO`) REFERENCES `usuario` (`ID_USUARIO`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `palpite`
--

LOCK TABLES `palpite` WRITE;
/*!40000 ALTER TABLE `palpite` DISABLE KEYS */;
INSERT INTO `palpite` VALUES (1,1,1,5,2,'2018-03-03 00:00:00'),(35,1,1,5,2,'2018-03-03 00:00:00'),(36,1,1,5,2,'2018-03-03 00:00:00');
/*!40000 ALTER TABLE `palpite` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `ID_USUARIO` int(11) NOT NULL AUTO_INCREMENT,
  `ID_USUARIO_FIREBASE` varchar(150) NOT NULL,
  `NOME_USUARIO` varchar(150) NOT NULL,
  `EMAIL` varchar(150) NOT NULL,
  `LOGIN` varchar(45) NOT NULL,
  `DATA_CRIACAO_USUARIO` datetime NOT NULL,
  PRIMARY KEY (`ID_USUARIO`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'564s6d54asd4sad4a6sd54','Marcelo Wender','marcelowender@hotmail.com','marcelowender','2018-01-01 00:00:00'),(39,'asasdasdasd','asdasdasddddd','marcelowender@hotmail.com','marcelowender','2018-01-01 00:00:00');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario_liga`
--

DROP TABLE IF EXISTS `usuario_liga`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario_liga` (
  `ID_USUARIO` int(11) NOT NULL,
  `ID_LIGA` int(11) NOT NULL,
  `DATA_ENTRADA_LIGA` datetime NOT NULL,
  PRIMARY KEY (`ID_USUARIO`,`ID_LIGA`),
  KEY `FK_ID_USUARIO_idx` (`ID_USUARIO`),
  KEY `FK_ID_LIGA_idx` (`ID_LIGA`),
  CONSTRAINT `FK5urein899x16d0tghcn0qevo2` FOREIGN KEY (`ID_LIGA`) REFERENCES `liga` (`ID_LIGA`),
  CONSTRAINT `FKdeq262c1161rb13cc1id1613h` FOREIGN KEY (`ID_USUARIO`) REFERENCES `usuario` (`ID_USUARIO`),
  CONSTRAINT `FK_ID_LIGA` FOREIGN KEY (`ID_LIGA`) REFERENCES `liga` (`ID_LIGA`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_ID_USUARIO` FOREIGN KEY (`ID_USUARIO`) REFERENCES `usuario` (`ID_USUARIO`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario_liga`
--

LOCK TABLES `usuario_liga` WRITE;
/*!40000 ALTER TABLE `usuario_liga` DISABLE KEYS */;
INSERT INTO `usuario_liga` VALUES (1,1,'2018-03-03 00:00:00');
/*!40000 ALTER TABLE `usuario_liga` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-03-04  0:56:42
