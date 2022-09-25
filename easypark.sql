-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: easypark
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
-- Table structure for table `configuraciones`
--

DROP TABLE IF EXISTS `configuraciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `configuraciones` (
  `id_configuraciones` int unsigned NOT NULL AUTO_INCREMENT,
  `nombreParqueadero` varchar(45) DEFAULT NULL,
  `valorHoraCarro` double DEFAULT NULL,
  `valorHoraMoto` double DEFAULT NULL,
  `ValorFracCarro` double DEFAULT NULL,
  `ValorFracMoto` double DEFAULT NULL,
  `ValorDiaCarro` double DEFAULT NULL,
  `ValorDiaMoto` double DEFAULT NULL,
  `ValorSemCarro` double DEFAULT NULL,
  `ValorSemMoto` double DEFAULT NULL,
  `ValorMesCarro` double DEFAULT NULL,
  `ValorMesMoto` double DEFAULT NULL,
  PRIMARY KEY (`id_configuraciones`),
  UNIQUE KEY `idconfiguraciones_UNIQUE` (`id_configuraciones`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `configuraciones`
--

LOCK TABLES `configuraciones` WRITE;
/*!40000 ALTER TABLE `configuraciones` DISABLE KEYS */;
INSERT INTO `configuraciones` VALUES (1,'EasyParking',2500,1000,1000,500,25000,15000,60000,35000,120000,80000);
/*!40000 ALTER TABLE `configuraciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `facturas`
--

DROP TABLE IF EXISTS `facturas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `facturas` (
  `id_Facturas` int unsigned NOT NULL AUTO_INCREMENT,
  `codigoFactura` int NOT NULL,
  `tipoVehiculo` varchar(10) NOT NULL,
  `placa` varchar(10) NOT NULL,
  `tipoContrato` varchar(10) NOT NULL,
  `fechaEntrada` datetime NOT NULL,
  `fechaSalida` datetime DEFAULT NULL,
  `valor` double DEFAULT NULL,
  `fechaFactura` datetime DEFAULT NULL,
  `id_Personas` int unsigned NOT NULL,
  `id_Plazas` int unsigned NOT NULL,
  PRIMARY KEY (`id_Facturas`),
  UNIQUE KEY `idFacturas_UNIQUE` (`id_Facturas`),
  KEY `idPersonas_idx` (`id_Personas`),
  KEY `idPlazas_idx` (`id_Plazas`),
  CONSTRAINT `FK_Personas_Facturas` FOREIGN KEY (`id_Personas`) REFERENCES `personas` (`id_Personas`),
  CONSTRAINT `FK_Plazas_Facturas` FOREIGN KEY (`id_Plazas`) REFERENCES `plazas` (`id_Plazas`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `facturas`
--

LOCK TABLES `facturas` WRITE;
/*!40000 ALTER TABLE `facturas` DISABLE KEYS */;
INSERT INTO `facturas` VALUES (1,1,'moto','HGF123','normal','2022-08-26 08:44:00','2022-08-26 09:44:00',2500,'2022-08-26 08:44:00',1,5),(2,2,'carro','HGF456','normal','2022-08-26 08:50:00','2022-08-26 09:50:00',2500,'2022-08-26 08:50:00',1,6),(7,3,'carro','RGT866','normal','2022-08-27 10:15:00',NULL,NULL,NULL,1,8);
/*!40000 ALTER TABLE `facturas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personas`
--

DROP TABLE IF EXISTS `personas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `personas` (
  `id_Personas` int unsigned NOT NULL AUTO_INCREMENT,
  `nombres` varchar(100) NOT NULL,
  `apellido` varchar(100) DEFAULT NULL,
  `tipDoc` varchar(20) DEFAULT NULL,
  `numDoc` varchar(20) NOT NULL,
  `direccion` varchar(250) DEFAULT NULL,
  `telefono` varchar(45) DEFAULT NULL,
  `email` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`id_Personas`),
  UNIQUE KEY `idPersonas_UNIQUE` (`id_Personas`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personas`
--

LOCK TABLES `personas` WRITE;
/*!40000 ALTER TABLE `personas` DISABLE KEYS */;
INSERT INTO `personas` VALUES (1,'Anoninmo',NULL,NULL,'0',NULL,NULL,NULL),(2,'Administrador',NULL,NULL,'1',NULL,NULL,NULL),(3,'Recepcionista',NULL,NULL,'2',NULL,NULL,NULL);
/*!40000 ALTER TABLE `personas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `plazas`
--

DROP TABLE IF EXISTS `plazas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `plazas` (
  `id_Plazas` int unsigned NOT NULL AUTO_INCREMENT,
  `codigoPlaza` varchar(5) NOT NULL,
  `tipoPlaza` varchar(10) NOT NULL,
  `estado` varchar(10) NOT NULL,
  PRIMARY KEY (`id_Plazas`),
  UNIQUE KEY `idPlazas_UNIQUE` (`id_Plazas`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plazas`
--

LOCK TABLES `plazas` WRITE;
/*!40000 ALTER TABLE `plazas` DISABLE KEYS */;
INSERT INTO `plazas` VALUES (1,'M001','moto','libre'),(2,'M002','moto','libre'),(3,'M003','moto','libre'),(4,'M004','moto','libre'),(5,'M005','moto','libre'),(6,'C001','carrro','libre'),(7,'C002','carrro','libre'),(8,'C003','carrro','ocupado'),(9,'C004','carrro','libre'),(10,'C005','carrro','libre');
/*!40000 ALTER TABLE `plazas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `id_Usuarios` int unsigned NOT NULL AUTO_INCREMENT,
  `usuario` varchar(45) NOT NULL,
  `clave` varchar(20) NOT NULL,
  `rol` varchar(45) NOT NULL,
  `id_Personas` int unsigned NOT NULL,
  PRIMARY KEY (`id_Usuarios`),
  UNIQUE KEY `idUsuarios_UNIQUE` (`id_Usuarios`),
  UNIQUE KEY `usuario_UNIQUE` (`usuario`),
  KEY `idPersonas_idx` (`id_Personas`),
  CONSTRAINT `FK_Personas_Usuarios` FOREIGN KEY (`id_Personas`) REFERENCES `personas` (`id_Personas`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'admin','12345','administrador',2),(2,'recep','12345','recepcionista',3),(3,'recep2','54321','recepcionista',3),(4,'admin2','54321','administrador',2);
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `v_facturas`
--

DROP TABLE IF EXISTS `v_facturas`;
/*!50001 DROP VIEW IF EXISTS `v_facturas`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `v_facturas` AS SELECT 
 1 AS `id_Facturas`,
 1 AS `codigoFactura`,
 1 AS `tipoVehiculo`,
 1 AS `tipoContrato`,
 1 AS `fechaEntrada`,
 1 AS `fechaSalida`,
 1 AS `fechaFactura`,
 1 AS `valor`,
 1 AS `id_Plazas`,
 1 AS `id_Personas`,
 1 AS `placa`,
 1 AS `nombres`,
 1 AS `apellido`,
 1 AS `email`,
 1 AS `direccion`,
 1 AS `tipDoc`,
 1 AS `numDoc`,
 1 AS `telefono`,
 1 AS `codigoPlaza`,
 1 AS `tipoPlaza`,
 1 AS `estado`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `v_usuarios`
--

DROP TABLE IF EXISTS `v_usuarios`;
/*!50001 DROP VIEW IF EXISTS `v_usuarios`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `v_usuarios` AS SELECT 
 1 AS `id_Usuarios`,
 1 AS `usuario`,
 1 AS `clave`,
 1 AS `rol`,
 1 AS `id_Personas`,
 1 AS `nombres`,
 1 AS `apellido`,
 1 AS `direccion`,
 1 AS `email`,
 1 AS `numDoc`,
 1 AS `tipDoc`,
 1 AS `telefono`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `v_facturas`
--

/*!50001 DROP VIEW IF EXISTS `v_facturas`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_facturas` AS select `facturas`.`id_Facturas` AS `id_Facturas`,`facturas`.`codigoFactura` AS `codigoFactura`,`facturas`.`tipoVehiculo` AS `tipoVehiculo`,`facturas`.`tipoContrato` AS `tipoContrato`,`facturas`.`fechaEntrada` AS `fechaEntrada`,`facturas`.`fechaSalida` AS `fechaSalida`,`facturas`.`fechaFactura` AS `fechaFactura`,`facturas`.`valor` AS `valor`,`facturas`.`id_Plazas` AS `id_Plazas`,`facturas`.`id_Personas` AS `id_Personas`,`facturas`.`placa` AS `placa`,`personas`.`nombres` AS `nombres`,`personas`.`apellido` AS `apellido`,`personas`.`email` AS `email`,`personas`.`direccion` AS `direccion`,`personas`.`tipDoc` AS `tipDoc`,`personas`.`numDoc` AS `numDoc`,`personas`.`telefono` AS `telefono`,`plazas`.`codigoPlaza` AS `codigoPlaza`,`plazas`.`tipoPlaza` AS `tipoPlaza`,`plazas`.`estado` AS `estado` from ((`facturas` join `personas` on((`facturas`.`id_Personas` = `personas`.`id_Personas`))) join `plazas` on((`facturas`.`id_Plazas` = `plazas`.`id_Plazas`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_usuarios`
--

/*!50001 DROP VIEW IF EXISTS `v_usuarios`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_usuarios` AS select `usuarios`.`id_Usuarios` AS `id_Usuarios`,`usuarios`.`usuario` AS `usuario`,`usuarios`.`clave` AS `clave`,`usuarios`.`rol` AS `rol`,`usuarios`.`id_Personas` AS `id_Personas`,`personas`.`nombres` AS `nombres`,`personas`.`apellido` AS `apellido`,`personas`.`direccion` AS `direccion`,`personas`.`email` AS `email`,`personas`.`numDoc` AS `numDoc`,`personas`.`tipDoc` AS `tipDoc`,`personas`.`telefono` AS `telefono` from (`usuarios` join `personas` on((`usuarios`.`id_Personas` = `personas`.`id_Personas`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-09-02  9:56:30
