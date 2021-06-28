-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: enade
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
-- Table structure for table `Prova`
--

DROP TABLE IF EXISTS `Prova`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Prova` (
  `idProva` int NOT NULL AUTO_INCREMENT,
  `dataProva` date NOT NULL,
  PRIMARY KEY (`idProva`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Prova`
--

LOCK TABLES `Prova` WRITE;
/*!40000 ALTER TABLE `Prova` DISABLE KEYS */;
INSERT INTO `Prova` VALUES (10,'2021-06-29'),(11,'2021-06-30');
/*!40000 ALTER TABLE `Prova` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Prova_has_Questao`
--

DROP TABLE IF EXISTS `Prova_has_Questao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Prova_has_Questao` (
  `Prova_idProva` int NOT NULL,
  `Questao_idQuestao` int NOT NULL,
  PRIMARY KEY (`Prova_idProva`,`Questao_idQuestao`),
  KEY `fk_Prova_has_Questao_Questao1_idx` (`Questao_idQuestao`),
  KEY `fk_Prova_has_Questao_Prova1_idx` (`Prova_idProva`),
  CONSTRAINT `fk_Prova_has_Questao_Prova1` FOREIGN KEY (`Prova_idProva`) REFERENCES `Prova` (`idProva`),
  CONSTRAINT `fk_Prova_has_Questao_Questao1` FOREIGN KEY (`Questao_idQuestao`) REFERENCES `Questao` (`idQuestao`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Prova_has_Questao`
--

LOCK TABLES `Prova_has_Questao` WRITE;
/*!40000 ALTER TABLE `Prova_has_Questao` DISABLE KEYS */;
INSERT INTO `Prova_has_Questao` VALUES (10,6),(10,7),(10,8),(11,8),(10,9),(11,9);
/*!40000 ALTER TABLE `Prova_has_Questao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Questao`
--

DROP TABLE IF EXISTS `Questao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Questao` (
  `idQuestao` int NOT NULL AUTO_INCREMENT,
  `descricaoQuestao` varchar(45) NOT NULL,
  `alternativaA` varchar(45) DEFAULT NULL,
  `alternativaB` varchar(45) DEFAULT NULL,
  `alternativaC` varchar(45) DEFAULT NULL,
  `alternativaD` varchar(45) DEFAULT NULL,
  `alternativaE` varchar(45) DEFAULT NULL,
  `questaoCorreta` char(1) DEFAULT NULL,
  `estadoQuestao` tinyint DEFAULT NULL,
  `TipoQuestao_idTipoQuestao` int NOT NULL,
  PRIMARY KEY (`idQuestao`),
  KEY `fk_Questao_TipoOuestao1_idx` (`TipoQuestao_idTipoQuestao`),
  CONSTRAINT `fk_Questao_TipoOuestao1` FOREIGN KEY (`TipoQuestao_idTipoQuestao`) REFERENCES `TipoQuestao` (`idTipoQuestao`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Questao`
--

LOCK TABLES `Questao` WRITE;
/*!40000 ALTER TABLE `Questao` DISABLE KEYS */;
INSERT INTO `Questao` VALUES (6,'Defina a sua profissão:','','','','','',NULL,1,1),(7,'Onde fica o Brasil?','América do norte','América Central','África','Oceania','América do Sul','E',1,2),(8,'Quanto é 10 + 10','15','16','10','12','20','E',1,2),(9,'O dia tem quantas horas','24','48','36','12','16','A',1,2);
/*!40000 ALTER TABLE `Questao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Resultado`
--

DROP TABLE IF EXISTS `Resultado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Resultado` (
  `idResultado` int NOT NULL AUTO_INCREMENT,
  `valorObtido` double NOT NULL,
  `Usuario_idUsuario` int NOT NULL,
  `Prova_idProva` int NOT NULL,
  PRIMARY KEY (`idResultado`),
  KEY `fk_Resultado_Usuario1_idx` (`Usuario_idUsuario`),
  KEY `fk_Resultado_Prova1_idx` (`Prova_idProva`),
  CONSTRAINT `fk_Resultado_Prova1` FOREIGN KEY (`Prova_idProva`) REFERENCES `Prova` (`idProva`),
  CONSTRAINT `fk_Resultado_Usuario1` FOREIGN KEY (`Usuario_idUsuario`) REFERENCES `Usuario` (`idUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Resultado`
--

LOCK TABLES `Resultado` WRITE;
/*!40000 ALTER TABLE `Resultado` DISABLE KEYS */;
INSERT INTO `Resultado` VALUES (3,7.5,16,10),(5,5,17,10),(6,2.5,18,10),(7,10,14,10),(8,10,18,10);
/*!40000 ALTER TABLE `Resultado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TipoQuestao`
--

DROP TABLE IF EXISTS `TipoQuestao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `TipoQuestao` (
  `idTipoQuestao` int NOT NULL AUTO_INCREMENT,
  `nomeTipoQuestao` varchar(45) NOT NULL,
  PRIMARY KEY (`idTipoQuestao`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TipoQuestao`
--

LOCK TABLES `TipoQuestao` WRITE;
/*!40000 ALTER TABLE `TipoQuestao` DISABLE KEYS */;
INSERT INTO `TipoQuestao` VALUES (1,'Discursiva'),(2,'Múltipla escolha');
/*!40000 ALTER TABLE `TipoQuestao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TipoUsuario`
--

DROP TABLE IF EXISTS `TipoUsuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `TipoUsuario` (
  `idTipoUsuario` int NOT NULL AUTO_INCREMENT,
  `nomeTipoUsuario` varchar(9) NOT NULL,
  PRIMARY KEY (`idTipoUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TipoUsuario`
--

LOCK TABLES `TipoUsuario` WRITE;
/*!40000 ALTER TABLE `TipoUsuario` DISABLE KEYS */;
INSERT INTO `TipoUsuario` VALUES (1,'Aluno'),(2,'Professor');
/*!40000 ALTER TABLE `TipoUsuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Usuario`
--

DROP TABLE IF EXISTS `Usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Usuario` (
  `idUsuario` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `senha` varchar(255) NOT NULL,
  `TipoUsuario_idTipoUsuario` int NOT NULL,
  PRIMARY KEY (`idUsuario`),
  KEY `fk_Usuario_TipoUsuario_idx` (`TipoUsuario_idTipoUsuario`),
  CONSTRAINT `fk_Usuario_TipoUsuario` FOREIGN KEY (`TipoUsuario_idTipoUsuario`) REFERENCES `TipoUsuario` (`idTipoUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Usuario`
--

LOCK TABLES `Usuario` WRITE;
/*!40000 ALTER TABLE `Usuario` DISABLE KEYS */;
INSERT INTO `Usuario` VALUES (14,'Davi','admin','8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918',1),(15,'Professor','prof','51d1e6a398acbda7e15b687de747e7dfe95fa13154dcb40aa8ab37f1e2b393a0',2),(16,'Matheus','admina','df419f7fff8134729c6b498037f0526117d7a2e568c0115287482db230c08d1f',1),(17,'Cristiano','123','a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3',1),(18,'Carlos','carlos@gmail.com','7b85175b455060e3237e925f023053ca9515e8682a83c8b09911c724a1f8b75f',1);
/*!40000 ALTER TABLE `Usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-06-28 20:01:12
