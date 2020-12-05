-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: new_schema
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `app_user`
--

CREATE SCHEMA `new_schema` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin ;
USE new_schema;
DROP TABLE IF EXISTS `app_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `app_user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `address` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `email` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `first_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `last_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `phone_no` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `user_type` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `app_user`
--

LOCK TABLES `app_user` WRITE;
/*!40000 ALTER TABLE `app_user` DISABLE KEYS */;
INSERT INTO `app_user` VALUES (1,NULL,'admin@appcal.com','Administrator',NULL,'$2a$10$8iiuxcwMkW6wyvp8wnhFjObpUqi.PdD16aNdy6acR3Bnyg0HFk16G',NULL,1),(2,'Flat 4 Kings court London WS35TY','sam.h@appcal.com','Sam','Hart','$2a$10$NN9.AXGL2LzBIsWQOGcKc.bteDhiQCZ7EcfsiimxljmDgs5NcJ9sS','0876767879',0),(3,'1 Dukes Ride Knightsfield Luton LU27LD','peterh@appcal.com','Peter','Hanks','$2a$10$K9I5E19lrVoCx6mVn.KqROVgINDuKthHzSL/BAgIaJ0eu4kQR6bXK','098765678987',0),(4,'34 Beech House Nothampton NH67YH','scott.r@appcal.com','Scott','Ryan','$2a$10$tj8Buhq5nVEE2GIq9XjX2.Defnq9kZVH5foKWPKxB7Pnj3nj0N26u','089789767894',0),(5,'1 Angel Court London TX789WU','appcalpatient1@gmail.com','Tee','Mayo','$2a$10$qtTiF8GFyC3K.uAuXl84vuC9DEPnKcEBtmp2MyFqY7GgVyydWn9VW','07896786789',2),(6,'105 Academy Holly St Luton LU13DS','appcalpatient2@gmail.com','Nathan','Taylor','$2a$10$mzoMHl6Sjk3S/3Puz3Jbse5IBaF3/3nFGGLFBMXO7n.TkB4LdJPl6','09876543214',2);
/*!40000 ALTER TABLE `app_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `appointment`
--

DROP TABLE IF EXISTS `appointment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `appointment` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  `notes` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `time` time DEFAULT NULL,
  `cus_id` bigint NOT NULL,
  `doc_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6k4g78yke9jw2lc4uen25bdfo` (`cus_id`),
  KEY `FK3ox9pj7opi2sh7hr5ceim6v8h` (`doc_id`),
  CONSTRAINT `FK3ox9pj7opi2sh7hr5ceim6v8h` FOREIGN KEY (`doc_id`) REFERENCES `doctor` (`id`),
  CONSTRAINT `FK6k4g78yke9jw2lc4uen25bdfo` FOREIGN KEY (`cus_id`) REFERENCES `customer` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appointment`
--

LOCK TABLES `appointment` WRITE;
/*!40000 ALTER TABLE `appointment` DISABLE KEYS */;
INSERT INTO `appointment` VALUES (1,'2020-12-02',NULL,'10:30:00',5,3),(2,'2020-12-05',NULL,'12:30:00',5,4),(3,'2020-11-25','Fever, Headache, Cough and Cold. ','17:15:00',5,3),(4,'2020-12-03',NULL,'10:30:00',6,2),(5,'2020-12-05',NULL,'11:15:00',6,4),(6,'2020-12-03',NULL,'10:15:00',6,4),(7,'2020-12-17',NULL,'09:45:00',6,2),(8,'2020-11-25','Gum pain, Observed decay on upper jaw wisdom tooth, Surgery recommended to remove tooth','17:30:00',6,4);
/*!40000 ALTER TABLE `appointment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cardcontainericoncardrelation`
--

DROP TABLE IF EXISTS `cardcontainericoncardrelation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cardcontainericoncardrelation` (
  `container_id` varchar(255) COLLATE utf8_bin NOT NULL,
  `card_id` varchar(255) COLLATE utf8_bin NOT NULL,
  KEY `FKlm6fab6ubw60aj02c9xm326xm` (`card_id`),
  KEY `FKqn7ll7bqey4n8a74fha4nt8vv` (`container_id`),
  CONSTRAINT `FKlm6fab6ubw60aj02c9xm326xm` FOREIGN KEY (`card_id`) REFERENCES `icon_card` (`id`),
  CONSTRAINT `FKqn7ll7bqey4n8a74fha4nt8vv` FOREIGN KEY (`container_id`) REFERENCES `icon_card_container_component` (`component_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cardcontainericoncardrelation`
--

LOCK TABLES `cardcontainericoncardrelation` WRITE;
/*!40000 ALTER TABLE `cardcontainericoncardrelation` DISABLE KEYS */;
INSERT INTO `cardcontainericoncardrelation` VALUES ('home_card_container','card_plus'),('home_card_container','card_calendar'),('home_card_container','card_book'),('home_card_container','card_check'),('patient-dashboard','patient-profile'),('patient-dashboard','view-appointments'),('patient-dashboard','my-appointments'),('patient-dashboard','my-prescriptions'),('doctor-dashboard','doc-profile'),('doctor-dashboard','doc-appointments'),('admin-dashboard','admin-profile'),('admin-dashboard','create-user'),('admin-dashboard','admin-maintainance');
/*!40000 ALTER TABLE `cardcontainericoncardrelation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `component`
--

DROP TABLE IF EXISTS `component`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `component` (
  `component_id` varchar(255) COLLATE utf8_bin NOT NULL,
  `component_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `component_type` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`component_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `component`
--

LOCK TABLES `component` WRITE;
/*!40000 ALTER TABLE `component` DISABLE KEYS */;
INSERT INTO `component` VALUES ('admin-dashboard','Admin Dashboard Card Container Component','iconcardcontainer'),('doctor-dashboard','Doctor Dashboard Card Container Component','iconcardcontainer'),('global_footer','Footer Component','footer'),('hero_banner','HeroBanner Component','herobanner'),('home_card_container','Content Card Container Component','iconcardcontainer'),('patient-dashboard','Patient Dashboard Card Container Component','iconcardcontainer'),('site_navigation','Site Navigationbar','navigation');
/*!40000 ALTER TABLE `component` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `age` int DEFAULT NULL,
  `blood_group` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `height` float DEFAULT NULL,
  `known_allergies` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `notes` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `weight` int DEFAULT NULL,
  `id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FKjlfgi6ceqby6oau1krf393ba7` FOREIGN KEY (`id`) REFERENCES `app_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (34,'O-',175,NULL,NULL,85,5),(45,'B+',184,NULL,NULL,74,6);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `doctor`
--

DROP TABLE IF EXISTS `doctor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `doctor` (
  `designation` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `qualification` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `specialization` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK8t8eucfe74h2qv9r8e8uyet00` FOREIGN KEY (`id`) REFERENCES `app_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctor`
--

LOCK TABLES `doctor` WRITE;
/*!40000 ALTER TABLE `doctor` DISABLE KEYS */;
INSERT INTO `doctor` VALUES ('Cardiologist',NULL,'MBBS, MD Cardiology',2),('General Practitioner',NULL,'MBBS',3),('Dentist',NULL,'BDS, DDS',4);
/*!40000 ALTER TABLE `doctor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `designation` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK4llm9fh2p4wuteyfhdbv4qdig` FOREIGN KEY (`id`) REFERENCES `app_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `footer_component`
--

DROP TABLE IF EXISTS `footer_component`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `footer_component` (
  `copyright_text` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `component_id` varchar(255) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`component_id`),
  CONSTRAINT `FKm6ji89dxk0nn8neo6fw6c4dn6` FOREIGN KEY (`component_id`) REFERENCES `component` (`component_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `footer_component`
--

LOCK TABLES `footer_component` WRITE;
/*!40000 ALTER TABLE `footer_component` DISABLE KEYS */;
INSERT INTO `footer_component` VALUES ('AppCal','global_footer');
/*!40000 ALTER TABLE `footer_component` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `footer_component_footer_sections`
--

DROP TABLE IF EXISTS `footer_component_footer_sections`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `footer_component_footer_sections` (
  `footer_component_component_id` varchar(255) COLLATE utf8_bin NOT NULL,
  `footer_sections_id` varchar(255) COLLATE utf8_bin NOT NULL,
  UNIQUE KEY `UK_o4h5y8p36issaq9ghw1aid9qv` (`footer_sections_id`),
  KEY `FKmnuo8r4xjpsgi01e3tktebnq0` (`footer_component_component_id`),
  CONSTRAINT `FK6n6xwjydfdqgud29hrmbysnap` FOREIGN KEY (`footer_sections_id`) REFERENCES `footer_section` (`id`),
  CONSTRAINT `FKmnuo8r4xjpsgi01e3tktebnq0` FOREIGN KEY (`footer_component_component_id`) REFERENCES `footer_component` (`component_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `footer_component_footer_sections`
--

LOCK TABLES `footer_component_footer_sections` WRITE;
/*!40000 ALTER TABLE `footer_component_footer_sections` DISABLE KEYS */;
INSERT INTO `footer_component_footer_sections` VALUES ('global_footer','about'),('global_footer','login');
/*!40000 ALTER TABLE `footer_component_footer_sections` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `footer_section`
--

DROP TABLE IF EXISTS `footer_section`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `footer_section` (
  `id` varchar(255) COLLATE utf8_bin NOT NULL,
  `section_header` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `footer_section`
--

LOCK TABLES `footer_section` WRITE;
/*!40000 ALTER TABLE `footer_section` DISABLE KEYS */;
INSERT INTO `footer_section` VALUES ('about','About'),('login','Login/Register');
/*!40000 ALTER TABLE `footer_section` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `footer_section_footer_links`
--

DROP TABLE IF EXISTS `footer_section_footer_links`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `footer_section_footer_links` (
  `footer_section_id` varchar(255) COLLATE utf8_bin NOT NULL,
  `footer_links_id` varchar(255) COLLATE utf8_bin NOT NULL,
  UNIQUE KEY `UK_icnhavx3jbb05mnbxpk2fd840` (`footer_links_id`),
  KEY `FK10yg760nc91ilw3p4k7maivrb` (`footer_section_id`),
  CONSTRAINT `FK10yg760nc91ilw3p4k7maivrb` FOREIGN KEY (`footer_section_id`) REFERENCES `footer_section` (`id`),
  CONSTRAINT `FKppvhid6rwd2p9t7v483n3wyui` FOREIGN KEY (`footer_links_id`) REFERENCES `navigation_link` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `footer_section_footer_links`
--

LOCK TABLES `footer_section_footer_links` WRITE;
/*!40000 ALTER TABLE `footer_section_footer_links` DISABLE KEYS */;
INSERT INTO `footer_section_footer_links` VALUES ('about','about'),('about','contact_page_link'),('login','login_page_link'),('login','register');
/*!40000 ALTER TABLE `footer_section_footer_links` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hero_banner_component`
--

DROP TABLE IF EXISTS `hero_banner_component`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hero_banner_component` (
  `banner_heading` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `banner_sub_heading` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `button_text` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `buttonurl` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `imageurl` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `component_id` varchar(255) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`component_id`),
  CONSTRAINT `FK3ydjipt61ws9taev09xq11rge` FOREIGN KEY (`component_id`) REFERENCES `component` (`component_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hero_banner_component`
--

LOCK TABLES `hero_banner_component` WRITE;
/*!40000 ALTER TABLE `hero_banner_component` DISABLE KEYS */;
INSERT INTO `hero_banner_component` VALUES ('Book your appointment today','Find a doctor and book appointment at your convinience.','Get Started','/signup','https://cdn.pixabay.com/photo/2017/02/20/14/18/health-2082630_1280.jpg','hero_banner');
/*!40000 ALTER TABLE `hero_banner_component` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `icon_card`
--

DROP TABLE IF EXISTS `icon_card`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `icon_card` (
  `id` varchar(255) COLLATE utf8_bin NOT NULL,
  `description` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `heading` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `icon_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `button_link_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `card_link_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK98nugm9t7vhc3dbbkn4cel7qf` (`button_link_id`),
  KEY `FKprm7095ap8vt9bxgw6nu24h3h` (`card_link_id`),
  CONSTRAINT `FK98nugm9t7vhc3dbbkn4cel7qf` FOREIGN KEY (`button_link_id`) REFERENCES `navigation_link` (`id`),
  CONSTRAINT `FKprm7095ap8vt9bxgw6nu24h3h` FOREIGN KEY (`card_link_id`) REFERENCES `navigation_link` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `icon_card`
--

LOCK TABLES `icon_card` WRITE;
/*!40000 ALTER TABLE `icon_card` DISABLE KEYS */;
INSERT INTO `icon_card` VALUES ('admin-maintainance','','Update site','fa fa-cog',NULL,'admin-maintainance'),('admin-profile','','My Profile','fa fa-user',NULL,'admin-profile'),('card_book','You can choose an appointment which is convenient for you','Book an appointment','icon-book-open icon',NULL,NULL),('card_calendar','Choose a date which suits you the best','Find available dates','icon-calendar icon',NULL,NULL),('card_check','Visit the hospital to finish your appointment. Your prescriptions can be viewed online from your account.','Attend the appointment','icon-check icon',NULL,NULL),('card_plus','We have experts who can give you the right advice. All you need to do is choose one from our panel of experts as per your convinience.','Choose a doctor','icon-plus icon',NULL,NULL),('create-user','','Create User','fa fa-user-plus',NULL,'admin-createuser'),('doc-appointments','','My Appointments','fa fa-calendar-times-o',NULL,'doc-appointments'),('doc-profile','','My Profile','fa fa-user',NULL,'doc-profile'),('my-appointments','','My Appointments','fa fa-calendar-times-o',NULL,'my-appointments'),('my-prescriptions','','My Prescriptions','fa fa-file-text-o',NULL,'my-prescriptions'),('patient-profile','','My Profile','fa fa-user',NULL,'patient-profile'),('view-appointments','','Book Appointment','fa fa-calendar-plus-o',NULL,'view-appointments');
/*!40000 ALTER TABLE `icon_card` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `icon_card_container_component`
--

DROP TABLE IF EXISTS `icon_card_container_component`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `icon_card_container_component` (
  `heading` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `component_id` varchar(255) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`component_id`),
  CONSTRAINT `FK44drxww24sro2ubtw51x8rfvq` FOREIGN KEY (`component_id`) REFERENCES `component` (`component_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `icon_card_container_component`
--

LOCK TABLES `icon_card_container_component` WRITE;
/*!40000 ALTER TABLE `icon_card_container_component` DISABLE KEYS */;
INSERT INTO `icon_card_container_component` VALUES (NULL,'admin-dashboard'),(NULL,'doctor-dashboard'),('Book an appointment in simple steps','home_card_container'),(NULL,'patient-dashboard');
/*!40000 ALTER TABLE `icon_card_container_component` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medicine`
--

DROP TABLE IF EXISTS `medicine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medicine` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `dosage` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicine`
--

LOCK TABLES `medicine` WRITE;
/*!40000 ALTER TABLE `medicine` DISABLE KEYS */;
INSERT INTO `medicine` VALUES (1,'3/Day','Ciprofloroxine'),(2,'4/Day','Paracetamol'),(3,'3/Day','Phenylephrine'),(4,'3/Day','Paracetamol'),(5,'2 Times a day after meal','CORSODYL 1% W/W DENTAL GEL');
/*!40000 ALTER TABLE `medicine` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `navigation_bar`
--

DROP TABLE IF EXISTS `navigation_bar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `navigation_bar` (
  `id` varchar(255) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `navigation_bar`
--

LOCK TABLES `navigation_bar` WRITE;
/*!40000 ALTER TABLE `navigation_bar` DISABLE KEYS */;
INSERT INTO `navigation_bar` VALUES ('site_navigation');
/*!40000 ALTER TABLE `navigation_bar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `navigation_bar_component`
--

DROP TABLE IF EXISTS `navigation_bar_component`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `navigation_bar_component` (
  `component_id` varchar(255) COLLATE utf8_bin NOT NULL,
  `navigation_bar_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`component_id`),
  KEY `FK87y94grakvkh07o8q54i0nph8` (`navigation_bar_id`),
  CONSTRAINT `FK87y94grakvkh07o8q54i0nph8` FOREIGN KEY (`navigation_bar_id`) REFERENCES `navigation_bar` (`id`),
  CONSTRAINT `FKe86nv2eno4x7x17tdq266gs6o` FOREIGN KEY (`component_id`) REFERENCES `component` (`component_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `navigation_bar_component`
--

LOCK TABLES `navigation_bar_component` WRITE;
/*!40000 ALTER TABLE `navigation_bar_component` DISABLE KEYS */;
INSERT INTO `navigation_bar_component` VALUES ('site_navigation','site_navigation');
/*!40000 ALTER TABLE `navigation_bar_component` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `navigation_bar_navigation_links`
--

DROP TABLE IF EXISTS `navigation_bar_navigation_links`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `navigation_bar_navigation_links` (
  `navigation_bar_id` varchar(255) COLLATE utf8_bin NOT NULL,
  `navigation_links_id` varchar(255) COLLATE utf8_bin NOT NULL,
  UNIQUE KEY `UK_9rt6n5hp7769wu9s23rrvrmdc` (`navigation_links_id`),
  KEY `FK9oqvqwmo0rae15iakl8c0vkte` (`navigation_bar_id`),
  CONSTRAINT `FK9oqvqwmo0rae15iakl8c0vkte` FOREIGN KEY (`navigation_bar_id`) REFERENCES `navigation_bar` (`id`),
  CONSTRAINT `FKgmgj5a7b0g5edxfwecobpxmi1` FOREIGN KEY (`navigation_links_id`) REFERENCES `navigation_link` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `navigation_bar_navigation_links`
--

LOCK TABLES `navigation_bar_navigation_links` WRITE;
/*!40000 ALTER TABLE `navigation_bar_navigation_links` DISABLE KEYS */;
INSERT INTO `navigation_bar_navigation_links` VALUES ('site_navigation','contact_page_link'),('site_navigation','home_page_link');
/*!40000 ALTER TABLE `navigation_bar_navigation_links` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `navigation_link`
--

DROP TABLE IF EXISTS `navigation_link`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `navigation_link` (
  `id` varchar(255) COLLATE utf8_bin NOT NULL,
  `link_text` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `url` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `navigation_link`
--

LOCK TABLES `navigation_link` WRITE;
/*!40000 ALTER TABLE `navigation_link` DISABLE KEYS */;
INSERT INTO `navigation_link` VALUES ('about','About us','/about-us'),('admin-createuser',NULL,'/admin/create-user'),('admin-maintainance',NULL,'/admin/initialize'),('admin-profile',NULL,'/admin/profile'),('contact_page_link','Contact Us','/contact-us'),('doc-appointments',NULL,'/doc/my-appointments'),('doc-profile',NULL,'/doc/profile'),('home_page_link','Home','/home'),('login_page_link','Login','/login'),('my-appointments',NULL,'/app/my-appointments'),('my-prescriptions',NULL,'/app/my-prescriptions'),('patient-profile',NULL,'/app/profile'),('register','Register','/signup'),('view-appointments',NULL,'/app/view-doctors');
/*!40000 ALTER TABLE `navigation_link` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `page`
--

DROP TABLE IF EXISTS `page`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `page` (
  `page_id` varchar(255) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`page_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `page`
--

LOCK TABLES `page` WRITE;
/*!40000 ALTER TABLE `page` DISABLE KEYS */;
INSERT INTO `page` VALUES ('404'),('admin-dashboard'),('booking-success'),('contact-us'),('create-user'),('doctor-dashboard'),('forgot'),('home'),('login'),('my-appointments'),('my-prescriptions'),('patient-dashboard'),('profile'),('signup'),('view-appointment'),('view-appointments'),('view-doctors');
/*!40000 ALTER TABLE `page` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pagecomponentrelation`
--

DROP TABLE IF EXISTS `pagecomponentrelation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pagecomponentrelation` (
  `pid` varchar(255) COLLATE utf8_bin NOT NULL,
  `cid` varchar(255) COLLATE utf8_bin NOT NULL,
  KEY `FKmbonlomgnxp81peu7c546g9e` (`cid`),
  KEY `FK7xeywgvk00lrepiqax87ckx9r` (`pid`),
  CONSTRAINT `FK7xeywgvk00lrepiqax87ckx9r` FOREIGN KEY (`pid`) REFERENCES `page` (`page_id`),
  CONSTRAINT `FKmbonlomgnxp81peu7c546g9e` FOREIGN KEY (`cid`) REFERENCES `component` (`component_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pagecomponentrelation`
--

LOCK TABLES `pagecomponentrelation` WRITE;
/*!40000 ALTER TABLE `pagecomponentrelation` DISABLE KEYS */;
INSERT INTO `pagecomponentrelation` VALUES ('home','site_navigation'),('home','hero_banner'),('home','home_card_container'),('home','global_footer'),('contact-us','site_navigation'),('contact-us','global_footer'),('signup','site_navigation'),('signup','global_footer'),('create-user','site_navigation'),('create-user','global_footer'),('login','site_navigation'),('login','global_footer'),('404','site_navigation'),('404','global_footer'),('view-appointments','site_navigation'),('view-appointments','global_footer'),('view-doctors','site_navigation'),('view-doctors','global_footer'),('booking-success','site_navigation'),('booking-success','global_footer'),('my-appointments','site_navigation'),('my-appointments','global_footer'),('view-appointment','site_navigation'),('view-appointment','global_footer'),('my-prescriptions','site_navigation'),('my-prescriptions','global_footer'),('profile','site_navigation'),('profile','global_footer'),('forgot','site_navigation'),('forgot','global_footer'),('admin-dashboard','site_navigation'),('admin-dashboard','admin-dashboard'),('admin-dashboard','global_footer'),('doctor-dashboard','site_navigation'),('doctor-dashboard','doctor-dashboard'),('doctor-dashboard','global_footer'),('patient-dashboard','site_navigation'),('patient-dashboard','patient-dashboard'),('patient-dashboard','global_footer');
/*!40000 ALTER TABLE `pagecomponentrelation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prescription`
--

DROP TABLE IF EXISTS `prescription`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prescription` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  `cus_id` bigint NOT NULL,
  `doc_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKf3pnse02ipopsxbmgmbioqb8e` (`cus_id`),
  KEY `FKiys0qguwy93nvkm9nxialyb44` (`doc_id`),
  CONSTRAINT `FKf3pnse02ipopsxbmgmbioqb8e` FOREIGN KEY (`cus_id`) REFERENCES `customer` (`id`),
  CONSTRAINT `FKiys0qguwy93nvkm9nxialyb44` FOREIGN KEY (`doc_id`) REFERENCES `doctor` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prescription`
--

LOCK TABLES `prescription` WRITE;
/*!40000 ALTER TABLE `prescription` DISABLE KEYS */;
INSERT INTO `prescription` VALUES (1,'2020-11-25',5,3),(2,'2020-11-25',6,4);
/*!40000 ALTER TABLE `prescription` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prescription_medicines`
--

DROP TABLE IF EXISTS `prescription_medicines`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prescription_medicines` (
  `prescription_id` bigint NOT NULL,
  `medicines_id` bigint NOT NULL,
  UNIQUE KEY `UK_g54ynfqb9r9hhpetrexpi12fq` (`medicines_id`),
  KEY `FKbwtcoglp0aw51n8ax8jcovi64` (`prescription_id`),
  CONSTRAINT `FK54vy97dsp7spiu1tsare26nhk` FOREIGN KEY (`medicines_id`) REFERENCES `medicine` (`id`),
  CONSTRAINT `FKbwtcoglp0aw51n8ax8jcovi64` FOREIGN KEY (`prescription_id`) REFERENCES `prescription` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prescription_medicines`
--

LOCK TABLES `prescription_medicines` WRITE;
/*!40000 ALTER TABLE `prescription_medicines` DISABLE KEYS */;
INSERT INTO `prescription_medicines` VALUES (1,1),(1,2),(1,3),(2,4),(2,5);
/*!40000 ALTER TABLE `prescription_medicines` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-11-25 16:58:59
