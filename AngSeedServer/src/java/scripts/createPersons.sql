--DROP TABLE IF EXISTS `currencyrates`;
CREATE TABLE `currencyrates` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `CODE` varchar(255) DEFAULT NULL,
  `DATE` varchar(255) DEFAULT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `RATE` double DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8;

LOCK TABLES `currencyrates` WRITE;
INSERT INTO `currencyrates` VALUES (1,'XDR','2015-11-04','SDR (Calculated **)',950.62),(2,'NOK','2015-11-04','Norwegian kroner',79.97),(3,'MYR','2015-11-04','Malaysian ringgit',159.94),(4,'THB','2015-11-04','Thai baht',19.24),(5,'GBP','2015-11-04','Pounds sterling',1051.51),(6,'HRK','2015-11-04','Croatian kuna',98.43),(7,'USD','2015-11-04','US dollars',682.16),(8,'SGD','2015-11-04','Singapore dollars',487.99),(9,'MXN','2015-11-04','Mexican peso',41.63),(10,'IDR','2015-11-04','Indonesian rupiah',0.0506),(11,'NZD','2015-11-04','New Zealand dollars',452.5),(12,'CHF','2015-11-04','Swiss francs',689.85),(13,'INR','2015-11-04','Indian rupee',10.42),(14,'BGN','2015-11-04','Bulgarian lev',381.4),(15,'CAD','2015-11-04','Canadian dollars',521.93),(16,'HKD','2015-11-04','Hong Kong dollars',88.02),(17,'EUR','2015-11-04','Euro',745.94),(18,'KRW','2015-11-04','South Korean won',0.6031),(19,'RUB','2015-11-04','Russian rouble',10.91),(20,'ILS','2015-11-04','Israeli shekel',175.97),(21,'ISK','2015-11-04','Icelandic kronur *',1),(22,'HUF','2015-11-04','Hungarian forints',2.369),(23,'RON','2015-11-04','Romanian leu',167.69),(24,'CNY','2015-11-04','Chinese yuan renminbi',107.65),(25,'TRY','2015-11-04','Turkish lira',240.22),(26,'SEK','2015-11-04','Swedish kronor',79.64),(27,'CZK','2015-11-04','Czech koruny',27.55),(28,'PLN','2015-11-04','Polish zlotys',176.02),(29,'BRL','2015-11-04','Brazilian real',181.78),(30,'PHP','2015-11-04','Philippine peso',14.58),(31,'AUD','2015-11-04','Australian dollars',490.43),(32,'JPY','2015-11-04','Japanese yen',5.6319),(33,'ZAR','2015-11-04','South African rand',49.37),(34,'IDR','2015-11-04','Indonesian rupiah',0.0506),(35,'EUR','2015-11-04','Euro',745.94),(36,'TRY','2015-11-04','Turkish lira',240.22),(37,'THB','2015-11-04','Thai baht',19.24),(38,'GBP','2015-11-04','Pounds sterling',1051.51),(39,'KRW','2015-11-04','South Korean won',0.6031),(40,'PLN','2015-11-04','Polish zlotys',176.02),(41,'RUB','2015-11-04','Russian rouble',10.91),(42,'JPY','2015-11-04','Japanese yen',5.6319),(43,'INR','2015-11-04','Indian rupee',10.42),(44,'NZD','2015-11-04','New Zealand dollars',452.5),(45,'SEK','2015-11-04','Swedish kronor',79.64),(46,'BGN','2015-11-04','Bulgarian lev',381.4),(47,'AUD','2015-11-04','Australian dollars',490.43),(48,'ISK','2015-11-04','Icelandic kronur *',1),(49,'RON','2015-11-04','Romanian leu',167.69),(50,'CZK','2015-11-04','Czech koruny',27.55),(51,'SGD','2015-11-04','Singapore dollars',487.99),(52,'NOK','2015-11-04','Norwegian kroner',79.97),(53,'CNY','2015-11-04','Chinese yuan renminbi',107.65),(54,'MYR','2015-11-04','Malaysian ringgit',159.94),(55,'ILS','2015-11-04','Israeli shekel',175.97),(56,'HKD','2015-11-04','Hong Kong dollars',88.02),(57,'USD','2015-11-04','US dollars',682.16),(58,'CAD','2015-11-04','Canadian dollars',521.93),(59,'CHF','2015-11-04','Swiss francs',689.85),(60,'PHP','2015-11-04','Philippine peso',14.58),(61,'HUF','2015-11-04','Hungarian forints',2.369),(62,'HRK','2015-11-04','Croatian kuna',98.43),(63,'ZAR','2015-11-04','South African rand',49.37),(64,'MXN','2015-11-04','Mexican peso',41.63),(65,'XDR','2015-11-04','SDR (Calculated **)',950.62),(66,'BRL','2015-11-04','Brazilian real',181.78);
UNLOCK TABLES;


--DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `USERNAME` varchar(255) NOT NULL,
  `PASSWORD` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`USERNAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `user` WRITE;
INSERT INTO `user` VALUES ('admin','1000:ee6f3e3e27ee39f20ac5f066c62b4b9f693bee4f6fd3ea4d:645b972b69029c6e07449a59c41e973e4ece3a978093b4e2'),('both','1000:fd83a11b93eef0ffc54a00d6b50a8eaab89e0ebe57100d8e:d4cc3135c7619997e7f06accfda18f70342fbcd37c9c8879'),('hue','1000:a8aad120e80da08fec2eb0c98cab81f25a00c67a384890b9:b3bf62cbd60464d9bb9232397888bcf1076b3de62ab79859'),('lol','1000:9f0b3b90f1ee81028503696f150c66573d9ae4cd5aa6b71b:61210b3836f8ef644ebc67e9d3c128badfd65ecdf1c46ade'),('user','1000:a125d27a3cf8e9b0203687fb8d524c215a575aa176e74f69:7b7e89f5f15ab456bdf7c7dc9043dd4d828681b8a0922bde');
UNLOCK TABLES;


--DROP TABLE IF EXISTS `user_roles`;
CREATE TABLE `user_roles` (
  `User_USERNAME` varchar(255) DEFAULT NULL,
  `ROLES` varchar(255) DEFAULT NULL,
  KEY `FK_User_ROLES_User_USERNAME` (`User_USERNAME`),
  CONSTRAINT `FK_User_ROLES_User_USERNAME` FOREIGN KEY (`User_USERNAME`) REFERENCES `user` (`USERNAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `user_roles` WRITE;
INSERT INTO `user_roles` VALUES ('user','User'),('admin','Admin'),('both','Admin'),('both','User'),('lol','User'),('hue','User');
UNLOCK TABLES;