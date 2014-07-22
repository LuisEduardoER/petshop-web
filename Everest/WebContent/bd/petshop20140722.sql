CREATE DATABASE  IF NOT EXISTS `petshop` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `petshop`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: localhost    Database: petshop
-- ------------------------------------------------------
-- Server version	5.5.37

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
-- Table structure for table `cita`
--

DROP TABLE IF EXISTS `cita`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cita` (
  `idCita` varchar(8) NOT NULL,
  `idMascota` varchar(8) NOT NULL COMMENT 'MAS0000X',
  `idCliente` int(11) NOT NULL,
  `idMedico` int(11) NOT NULL,
  `fecProg` datetime NOT NULL,
  `fecAtencion` datetime DEFAULT NULL,
  `estado` char(1) NOT NULL DEFAULT '1',
  `userCreate` varchar(200) DEFAULT NULL,
  `dateCreate` datetime DEFAULT NULL,
  PRIMARY KEY (`idCita`),
  KEY `fk_cita_cliente_idx` (`idCliente`),
  KEY `fk_Cita_Medico1_idx` (`idMedico`),
  KEY `fk_cia_mascota_idx` (`idMascota`),
  CONSTRAINT `fk_cita_cliente` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_cita_mascota` FOREIGN KEY (`idMascota`) REFERENCES `mascota` (`idMascota`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_cita_medico` FOREIGN KEY (`idMedico`) REFERENCES `medico` (`idMedico`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cita`
--

LOCK TABLES `cita` WRITE;
/*!40000 ALTER TABLE `cita` DISABLE KEYS */;
/*!40000 ALTER TABLE `cita` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `idCliente` int(11) NOT NULL AUTO_INCREMENT,
  `idParentCliente` int(11) DEFAULT NULL,
  `idUsuario` int(11) DEFAULT NULL,
  `idDIstrito` int(11) DEFAULT NULL,
  `dni` varchar(12) DEFAULT NULL COMMENT 'DNI/RUC',
  `nombres` varchar(200) DEFAULT NULL COMMENT 'NOMBRE/RAZON SOCIAL',
  `apePat` varchar(200) DEFAULT NULL,
  `apeMat` varchar(200) DEFAULT NULL,
  `sexo` char(1) DEFAULT NULL,
  `fecNac` date DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL,
  `telefono` int(11) DEFAULT NULL,
  `celular` int(11) DEFAULT NULL,
  `Direccion` varchar(300) DEFAULT NULL,
  `estado` char(1) NOT NULL DEFAULT '1',
  `lineaCreditoBool` char(1) NOT NULL,
  `lineaCredito` double DEFAULT NULL,
  `lineaDisponible` double DEFAULT NULL,
  `tipoCliente` char(1) NOT NULL COMMENT 'Tipo de Cliente',
  PRIMARY KEY (`idCliente`),
  UNIQUE KEY `documento_UNIQUE` (`dni`),
  KEY `fk_cliente_usuario_idx` (`idUsuario`),
  KEY `fk_cliente_parent_idx` (`idParentCliente`),
  CONSTRAINT `fk_cliente_parent` FOREIGN KEY (`idParentCliente`) REFERENCES `cliente` (`idCliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_cliente_usuario` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,NULL,NULL,NULL,'46846255','Carlos','De los santos','Garcia','M','1992-03-14','carlos.dls.1992@gmail.com',7654321,987654321,'jhgfdsa','1','',NULL,NULL,''),(2,NULL,NULL,NULL,'46846254','Carol','Alvarez','Ttupa','F','1990-01-07','alvarez.1816@gmail.com',7654321,987654321,'FGasfasd','1','',NULL,NULL,''),(3,NULL,NULL,NULL,'46846253','Yoshua2','Zamalloa','De los santos','M','1995-03-11','yoshuazdls@gmail.com',8765432,987654321,'DGSDFG','1','',NULL,NULL,''),(4,NULL,NULL,NULL,'46846252','Darwin','Chavez','Ocaña','M','1991-06-29','darwinco@gmail.com',7654321,987654321,'Direccion','1','',NULL,NULL,''),(5,4,NULL,NULL,'46846251','Shameli','Chavez','Ocaña','F','1995-07-25','sharmelico@gmail.com',7654321,987654321,'Direccion','1','',NULL,NULL,'');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cobro`
--

DROP TABLE IF EXISTS `cobro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cobro` (
  `idCobro` varchar(8) NOT NULL,
  `idCliente` int(11) DEFAULT NULL,
  `idCita` varchar(8) DEFAULT NULL,
  `userCreate` varchar(50) DEFAULT NULL,
  `dateCreate` datetime DEFAULT NULL,
  PRIMARY KEY (`idCobro`),
  KEY `fk_pago_cliente_idx` (`idCliente`),
  KEY `fk_pago_cita_idx` (`idCita`),
  CONSTRAINT `fk_pago_citas` FOREIGN KEY (`idCita`) REFERENCES `cita` (`idCita`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_pago_clientes` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cobro`
--

LOCK TABLES `cobro` WRITE;
/*!40000 ALTER TABLE `cobro` DISABLE KEYS */;
/*!40000 ALTER TABLE `cobro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `correlativo`
--

DROP TABLE IF EXISTS `correlativo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `correlativo` (
  `idCorrelativo` int(11) NOT NULL AUTO_INCREMENT,
  `tabla` varchar(200) NOT NULL,
  `valor` varchar(10) NOT NULL,
  PRIMARY KEY (`idCorrelativo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `correlativo`
--

LOCK TABLES `correlativo` WRITE;
/*!40000 ALTER TABLE `correlativo` DISABLE KEYS */;
/*!40000 ALTER TABLE `correlativo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cuentas`
--

DROP TABLE IF EXISTS `cuentas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cuentas` (
  `idCuenta` int(11) NOT NULL,
  `Descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idCuenta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cuentas`
--

LOCK TABLES `cuentas` WRITE;
/*!40000 ALTER TABLE `cuentas` DISABLE KEYS */;
/*!40000 ALTER TABLE `cuentas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detallecita`
--

DROP TABLE IF EXISTS `detallecita`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detallecita` (
  `idCita` varchar(8) NOT NULL,
  `idServicio` int(11) NOT NULL,
  `pelo` varchar(45) DEFAULT NULL,
  `tamano` varchar(45) DEFAULT NULL,
  `tiempoAprox` time DEFAULT NULL,
  `costo` double DEFAULT NULL,
  `observaciones` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`idCita`,`idServicio`),
  KEY `fk_detalle_cita_servicio_idx` (`idServicio`),
  CONSTRAINT `fk_detalle_cita_servicio` FOREIGN KEY (`idServicio`) REFERENCES `servicio` (`idServicio`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_detatlle_cita` FOREIGN KEY (`idCita`) REFERENCES `cita` (`idCita`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detallecita`
--

LOCK TABLES `detallecita` WRITE;
/*!40000 ALTER TABLE `detallecita` DISABLE KEYS */;
/*!40000 ALTER TABLE `detallecita` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detallecobro`
--

DROP TABLE IF EXISTS `detallecobro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detallecobro` (
  `idCobro` varchar(8) NOT NULL,
  `idTipo` int(11) NOT NULL COMMENT 'Tipo de Pago',
  `idDetalle` int(11) NOT NULL COMMENT 'Representa el "id" del Producto o Servicio',
  `idServicio` int(11) DEFAULT NULL,
  `idProducto` varchar(8) DEFAULT NULL,
  `costo` double DEFAULT NULL,
  `userCreate` varchar(50) DEFAULT NULL,
  `dateCreate` datetime DEFAULT NULL,
  PRIMARY KEY (`idCobro`,`idTipo`,`idDetalle`),
  KEY `fk_detalle_pago_servicio_idx` (`idServicio`),
  KEY `fk_detalle_pago_producto_idx` (`idProducto`),
  CONSTRAINT `fk_detalle_cobro` FOREIGN KEY (`idCobro`) REFERENCES `cobro` (`idCobro`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_detalle_cobro_producto` FOREIGN KEY (`idProducto`) REFERENCES `producto` (`idProducto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_detalle_cobro_servicio` FOREIGN KEY (`idServicio`) REFERENCES `servicio` (`idServicio`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detallecobro`
--

LOCK TABLES `detallecobro` WRITE;
/*!40000 ALTER TABLE `detallecobro` DISABLE KEYS */;
/*!40000 ALTER TABLE `detallecobro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detallepago`
--

DROP TABLE IF EXISTS `detallepago`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detallepago` (
  `idPago` int(11) NOT NULL,
  `idFormaPago` int(11) NOT NULL,
  `idCuenta` int(11) NOT NULL,
  `monto` double DEFAULT NULL,
  PRIMARY KEY (`idPago`),
  KEY `fk_detalle_formapago_idx` (`idFormaPago`),
  KEY `fk_detalle_cuenta_idx` (`idCuenta`),
  CONSTRAINT `fk_detalle_cuenta` FOREIGN KEY (`idCuenta`) REFERENCES `cuentas` (`idCuenta`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_detalle_formapago` FOREIGN KEY (`idFormaPago`) REFERENCES `formapago` (`idFormaPago`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_detalle_pago` FOREIGN KEY (`idPago`) REFERENCES `pago` (`idPago`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detallepago`
--

LOCK TABLES `detallepago` WRITE;
/*!40000 ALTER TABLE `detallepago` DISABLE KEYS */;
/*!40000 ALTER TABLE `detallepago` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `deudas`
--

DROP TABLE IF EXISTS `deudas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `deudas` (
  `idDeuda` int(11) NOT NULL,
  `idProveedor` int(11) NOT NULL,
  `Monto` double DEFAULT NULL,
  `Saldo` double DEFAULT NULL,
  PRIMARY KEY (`idDeuda`),
  KEY `fk_deuda_proveedor_idx` (`idProveedor`),
  CONSTRAINT `fk_deuda_proveedor` FOREIGN KEY (`idProveedor`) REFERENCES `proveedor` (`idProveedor`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `deudas`
--

LOCK TABLES `deudas` WRITE;
/*!40000 ALTER TABLE `deudas` DISABLE KEYS */;
/*!40000 ALTER TABLE `deudas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `formapago`
--

DROP TABLE IF EXISTS `formapago`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `formapago` (
  `idFormaPago` int(11) NOT NULL,
  `descripcion` varchar(200) DEFAULT NULL,
  `tipo` char(1) DEFAULT NULL COMMENT 'C:CLIENTE',
  PRIMARY KEY (`idFormaPago`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `formapago`
--

LOCK TABLES `formapago` WRITE;
/*!40000 ALTER TABLE `formapago` DISABLE KEYS */;
/*!40000 ALTER TABLE `formapago` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `historiaclinica`
--

DROP TABLE IF EXISTS `historiaclinica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `historiaclinica` (
  `idHistoria Clinica` int(11) NOT NULL,
  `idCliente` int(11) NOT NULL,
  `idMascota` varchar(8) NOT NULL COMMENT 'MAS0000X',
  `procedencia` varchar(45) DEFAULT NULL,
  `alergia` varchar(45) DEFAULT NULL,
  `talla` varchar(45) DEFAULT NULL,
  `raza` varchar(45) DEFAULT NULL,
  `peso` varchar(45) DEFAULT NULL,
  `temperatura` varchar(45) DEFAULT NULL,
  `fechaNac` date DEFAULT NULL,
  `observacion` varchar(200) DEFAULT NULL,
  `diagnostico` varchar(200) DEFAULT NULL,
  `tratamiento` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`idHistoria Clinica`),
  KEY `fk_Historia Clinica_Cliente1_idx` (`idCliente`),
  KEY `fk_Historia Clinica_Mascota1_idx` (`idMascota`),
  CONSTRAINT `fk_Historia Clinica_Cliente1` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Historia Clinica_Mascota1` FOREIGN KEY (`idMascota`) REFERENCES `mascota` (`idMascota`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `historiaclinica`
--

LOCK TABLES `historiaclinica` WRITE;
/*!40000 ALTER TABLE `historiaclinica` DISABLE KEYS */;
/*!40000 ALTER TABLE `historiaclinica` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `local`
--

DROP TABLE IF EXISTS `local`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `local` (
  `idLocal` int(11) NOT NULL,
  `nomLocal` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idLocal`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `local`
--

LOCK TABLES `local` WRITE;
/*!40000 ALTER TABLE `local` DISABLE KEYS */;
INSERT INTO `local` VALUES (1,'Local 1'),(2,'Local 2');
/*!40000 ALTER TABLE `local` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mascota`
--

DROP TABLE IF EXISTS `mascota`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mascota` (
  `idMascota` varchar(8) NOT NULL COMMENT 'MAS0000X',
  `idCliente` int(11) NOT NULL,
  `idTipoAnimal` int(11) NOT NULL,
  `nombre` varchar(200) DEFAULT NULL,
  `edad` int(11) DEFAULT NULL,
  `raza` varchar(200) DEFAULT NULL,
  `fecNac` date DEFAULT NULL,
  `sexo` char(1) DEFAULT NULL,
  `pedigree` char(1) DEFAULT NULL,
  `esterilizacion` char(1) DEFAULT NULL,
  `observaciones` varchar(500) DEFAULT NULL,
  `fotobin` longblob,
  `alergia` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`idMascota`),
  KEY `fk_mascota_cliente_idx` (`idCliente`),
  KEY `fk_mascota_tipoAnimal_idx` (`idTipoAnimal`),
  CONSTRAINT `fk_mascota_cliente` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_mascota_tipoAnimal` FOREIGN KEY (`idTipoAnimal`) REFERENCES `tipoanimal` (`idTipoAnimal`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mascota`
--

LOCK TABLES `mascota` WRITE;
/*!40000 ALTER TABLE `mascota` DISABLE KEYS */;
INSERT INTO `mascota` VALUES ('MSC00001',4,1,'Bobby',2,'Siberiano','2013-02-01','M',NULL,NULL,NULL,NULL,NULL),('MSC00002',4,1,'Hachicko',1,'Raza','2013-02-01','M',NULL,NULL,NULL,NULL,NULL),('MSC00003',4,1,'Kaizer',3,'Raza','2013-02-01','M',NULL,NULL,NULL,NULL,NULL),('MSC00004',4,1,'Lana',2,'Raza','2013-02-01','F',NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `mascota` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medico`
--

DROP TABLE IF EXISTS `medico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `medico` (
  `idMedico` int(11) NOT NULL,
  `idTurno` int(11) NOT NULL,
  `idLocal` int(11) NOT NULL,
  `idUsuario` int(11) DEFAULT NULL,
  `nombres` varchar(200) DEFAULT NULL,
  `apellidos` varchar(200) DEFAULT NULL,
  `telefono` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idMedico`),
  KEY `fk_Medico_Turno1_idx` (`idTurno`),
  KEY `fk_Medico_Local1_idx` (`idLocal`),
  CONSTRAINT `fk_Medico_Local1` FOREIGN KEY (`idLocal`) REFERENCES `local` (`idLocal`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Medico_Turno1` FOREIGN KEY (`idTurno`) REFERENCES `turno` (`idTurno`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medico`
--

LOCK TABLES `medico` WRITE;
/*!40000 ALTER TABLE `medico` DISABLE KEYS */;
INSERT INTO `medico` VALUES (1,1,1,NULL,'Juliet','Leyva','Leon');
/*!40000 ALTER TABLE `medico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `opcion`
--

DROP TABLE IF EXISTS `opcion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `opcion` (
  `idOpcion` int(11) NOT NULL AUTO_INCREMENT,
  `parentOpcionId` int(11) DEFAULT NULL,
  `Descripcion` varchar(200) DEFAULT NULL,
  `Titulo` varchar(200) NOT NULL,
  `url` varchar(1000) NOT NULL,
  `orden` int(11) DEFAULT NULL,
  `estado` char(50) DEFAULT NULL,
  `userCreate` varchar(200) DEFAULT NULL,
  `dateCreate` datetime DEFAULT NULL,
  PRIMARY KEY (`idOpcion`),
  KEY `fk_opcion_parent_idx` (`parentOpcionId`),
  CONSTRAINT `fk_opcion_parent` FOREIGN KEY (`parentOpcionId`) REFERENCES `opcion` (`idOpcion`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `opcion`
--

LOCK TABLES `opcion` WRITE;
/*!40000 ALTER TABLE `opcion` DISABLE KEYS */;
INSERT INTO `opcion` VALUES (1,NULL,'Mantenimientos','Mantenimientos','#',2,'Activo',NULL,NULL),(2,1,'Mant. Usuarios','Usuarios','showUsuarioListaAction',1,'Activo',NULL,NULL),(3,1,'Mant. Citas','Citas','#',2,'Activo',NULL,NULL),(4,NULL,'Secretaria','Secretaria','#',1,'Activo',NULL,NULL),(5,4,'Registro de Cita','Registro de Cita','showCitaRegistroAction',1,'Activo',NULL,NULL),(6,NULL,'Cliente','Cliente','#',3,'Activo',NULL,NULL),(7,1,'Mant. Clientes','Clientes','showClienteRegistroAction',1,'Activo',NULL,NULL),(8,1,'Mant. Proveedores','Proveedores','obtenerProveedores',3,'Activo',NULL,NULL),(9,1,'Mant. Roles','Roles','showRolLista',4,'Activo',NULL,NULL),(16,1,'Mant. Opciones','Opciones','showOpcionListaAction',5,'Activo',NULL,NULL),(18,4,'Disponiblidad Servicio','Disponibilidad Servicios','showServicioDisponiblidadAction',3,'Inactivo',NULL,NULL),(19,4,'Cobro a Clientes','Cobro a Clientes','showCobroPageAction',2,'Activo',NULL,NULL),(20,1,'Correlativo','Correlativo','showCorrelativoLista',6,'Activo',NULL,NULL);
/*!40000 ALTER TABLE `opcion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pago`
--

DROP TABLE IF EXISTS `pago`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pago` (
  `idPago` int(11) NOT NULL,
  `idProveedor` int(11) NOT NULL,
  `idDeuda` int(11) NOT NULL,
  PRIMARY KEY (`idPago`),
  KEY `fk_pago_proveedor_idx` (`idProveedor`),
  KEY `fk_pago_deuda_idx` (`idDeuda`),
  CONSTRAINT `fk_pago_deuda` FOREIGN KEY (`idDeuda`) REFERENCES `deudas` (`idDeuda`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_pago_proveedor` FOREIGN KEY (`idProveedor`) REFERENCES `proveedor` (`idProveedor`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pago`
--

LOCK TABLES `pago` WRITE;
/*!40000 ALTER TABLE `pago` DISABLE KEYS */;
/*!40000 ALTER TABLE `pago` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `producto` (
  `idProducto` varchar(8) NOT NULL,
  `idProveedor` int(11) NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  `idTipoProducto` int(11) DEFAULT NULL,
  `marca` varchar(45) DEFAULT NULL,
  `precio` varchar(45) DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `fecVec` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idProducto`),
  KEY `fk_producto_tipo_idx` (`idTipoProducto`),
  KEY `fk_producto_proveedor_idx` (`idProveedor`),
  CONSTRAINT `fk_producto_proveedor` FOREIGN KEY (`idProveedor`) REFERENCES `proveedor` (`idProveedor`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_producto_tipo` FOREIGN KEY (`idTipoProducto`) REFERENCES `tipoproducto` (`idTipoProducto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedor`
--

DROP TABLE IF EXISTS `proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `proveedor` (
  `idProveedor` int(11) NOT NULL AUTO_INCREMENT,
  `RUC` varchar(50) NOT NULL,
  `razonSocial` varchar(200) NOT NULL,
  `direccion` varchar(200) NOT NULL,
  `estado` char(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`idProveedor`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedor`
--

LOCK TABLES `proveedor` WRITE;
/*!40000 ALTER TABLE `proveedor` DISABLE KEYS */;
INSERT INTO `proveedor` VALUES (1,'10468462554','De los santos','Pte Piedra','1'),(3,'987654321','Aaaa','aaaaaaaa','1'),(4,'9876543','wrwerqwer','werqwerq','1'),(5,'234234','sdgsdfg','sdfhgsdf','1'),(6,'345234532','dgfwdfs','sdgfsad','1');
/*!40000 ALTER TABLE `proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rol`
--

DROP TABLE IF EXISTS `rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rol` (
  `idRol` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(200) NOT NULL,
  `estado` char(50) DEFAULT NULL,
  `userCreate` varchar(200) DEFAULT NULL,
  `dateCreate` datetime DEFAULT NULL,
  PRIMARY KEY (`idRol`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol`
--

LOCK TABLES `rol` WRITE;
/*!40000 ALTER TABLE `rol` DISABLE KEYS */;
INSERT INTO `rol` VALUES (1,'Administrador','Activo',NULL,NULL),(2,'Secretaria','Activo',NULL,NULL),(3,'Pediatra','Activo',NULL,NULL),(4,'Operario','Activo',NULL,NULL),(5,'Cliente','Activo',NULL,NULL);
/*!40000 ALTER TABLE `rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rolopcion`
--

DROP TABLE IF EXISTS `rolopcion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rolopcion` (
  `idRol` int(11) NOT NULL,
  `idOpcion` int(11) NOT NULL,
  `userCreate` varchar(200) DEFAULT NULL,
  `dateCreate` datetime DEFAULT NULL,
  PRIMARY KEY (`idRol`,`idOpcion`),
  UNIQUE KEY `idx_rol_opcion` (`idRol`,`idOpcion`),
  KEY `fk_detalle_opcion_idx` (`idOpcion`),
  KEY `fk_detalle_rol_idx` (`idRol`),
  CONSTRAINT `fk_detalle_opcion` FOREIGN KEY (`idOpcion`) REFERENCES `opcion` (`idOpcion`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_detalle_rol` FOREIGN KEY (`idRol`) REFERENCES `rol` (`idRol`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rolopcion`
--

LOCK TABLES `rolopcion` WRITE;
/*!40000 ALTER TABLE `rolopcion` DISABLE KEYS */;
INSERT INTO `rolopcion` VALUES (1,1,NULL,NULL),(1,2,NULL,NULL),(1,3,NULL,NULL),(1,4,NULL,NULL),(1,5,NULL,NULL),(1,6,NULL,NULL),(1,7,NULL,NULL),(2,2,NULL,NULL),(2,4,NULL,NULL),(2,5,NULL,NULL),(5,4,NULL,NULL),(5,5,NULL,NULL);
/*!40000 ALTER TABLE `rolopcion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `servicio`
--

DROP TABLE IF EXISTS `servicio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `servicio` (
  `idServicio` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(200) NOT NULL,
  `tiempoAprox` time DEFAULT NULL COMMENT 'Tiempo Aprox en minutos,',
  `costoRef` double NOT NULL,
  `estado` char(1) NOT NULL DEFAULT '1',
  `userCreate` varchar(200) DEFAULT NULL,
  `dateCreate` datetime DEFAULT NULL,
  PRIMARY KEY (`idServicio`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servicio`
--

LOCK TABLES `servicio` WRITE;
/*!40000 ALTER TABLE `servicio` DISABLE KEYS */;
INSERT INTO `servicio` VALUES (1,'Atencion Medica','00:30:00',20,'1',NULL,NULL),(2,'Bano','00:10:00',20,'1',NULL,NULL),(3,'Desparacitacion','00:20:00',10,'1',NULL,NULL),(4,'Vacuna','00:10:00',10,'1',NULL,NULL);
/*!40000 ALTER TABLE `servicio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipoanimal`
--

DROP TABLE IF EXISTS `tipoanimal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipoanimal` (
  `idTipoAnimal` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) DEFAULT NULL,
  `estado` char(1) DEFAULT NULL,
  PRIMARY KEY (`idTipoAnimal`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipoanimal`
--

LOCK TABLES `tipoanimal` WRITE;
/*!40000 ALTER TABLE `tipoanimal` DISABLE KEYS */;
INSERT INTO `tipoanimal` VALUES (1,'Perro','1');
/*!40000 ALTER TABLE `tipoanimal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipoproducto`
--

DROP TABLE IF EXISTS `tipoproducto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipoproducto` (
  `idTipoProducto` int(11) NOT NULL,
  `Descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idTipoProducto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipoproducto`
--

LOCK TABLES `tipoproducto` WRITE;
/*!40000 ALTER TABLE `tipoproducto` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipoproducto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `turno`
--

DROP TABLE IF EXISTS `turno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `turno` (
  `idTurno` int(11) NOT NULL,
  `nomTurno` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idTurno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `turno`
--

LOCK TABLES `turno` WRITE;
/*!40000 ALTER TABLE `turno` DISABLE KEYS */;
INSERT INTO `turno` VALUES (1,'Mañana'),(2,'Noche');
/*!40000 ALTER TABLE `turno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `idUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `idRol` int(11) NOT NULL,
  `user` varchar(100) NOT NULL,
  `pass` varchar(100) NOT NULL,
  `estado` char(1) DEFAULT NULL,
  `userCreate` varchar(200) DEFAULT NULL,
  `dateCreate` datetime DEFAULT NULL,
  PRIMARY KEY (`idUsuario`),
  KEY `fk_usuario_rol_idx` (`idRol`),
  CONSTRAINT `fk_usuario_rol` FOREIGN KEY (`idRol`) REFERENCES `rol` (`idRol`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,1,'admin','1234','1',NULL,NULL),(2,2,'secre','1234','1',NULL,NULL),(3,3,'ped','1234','1',NULL,NULL),(4,4,'ope','1234','1',NULL,NULL),(5,5,'cli','1234','1',NULL,NULL),(6,5,'darwinco@gmail.com','1234','1',NULL,NULL);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-07-22 14:34:59
