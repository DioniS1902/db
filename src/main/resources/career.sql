CREATE DATABASE  IF NOT EXISTS `career`  DEFAULT CHARACTER SET utf8 ;
USE `career`;

DROP TABLE IF EXISTS `medical_insurance`;
DROP TABLE IF EXISTS `medic_status`;
DROP TABLE IF EXISTS `worker_info`;
DROP TABLE IF EXISTS `worker`;
DROP TABLE IF EXISTS `worker_sensors`;
DROP TABLE IF EXISTS `transport_sesnsors`;
DROP TABLE IF EXISTS `sensors`;
DROP TABLE IF EXISTS `transport`;
DROP TABLE IF EXISTS `career`;
DROP TABLE IF EXISTS `position`;

CREATE TABLE `position` (
                            `id` int NOT NULL AUTO_INCREMENT,
                            `lat` float DEFAULT NULL,
                            `plong` float DEFAULT NULL,

                            PRIMARY KEY (`id`)
) ENGINE=InnoDB;

CREATE TABLE `career` (
                          `id` int NOT NULL AUTO_INCREMENT,
                          `name` varchar(45) DEFAULT NULL,
                          `position_id` int NOT NULL,
                          PRIMARY KEY (`id`),
                          KEY `fk_career_position1_idx` (`position_id`),
                          CONSTRAINT `fk_career_position1` FOREIGN KEY (`position_id`) REFERENCES `position` (`id`),
                          INDEX(`name`)
) ENGINE=InnoDB;

CREATE TABLE `transport` (
                             `id` int NOT NULL AUTO_INCREMENT,
                             `model` varchar(45) DEFAULT NULL,
                             `transportcol` varchar(45) DEFAULT NULL,
                             `career_id` int NOT NULL,
                             PRIMARY KEY (`id`),
                             KEY `fk_transport_career1_idx` (`career_id`),
                             CONSTRAINT `fk_transport_career1` FOREIGN KEY (`career_id`) REFERENCES `career` (`id`),
                             INDEX(`model`)
) ENGINE=InnoDB;

CREATE TABLE `sensors` (
                           `id` int NOT NULL AUTO_INCREMENT,
                           `transport_id` int NOT NULL,
                           `date_time` varchar(45) DEFAULT NULL,
                           PRIMARY KEY (`id`),
                           KEY `fk_sensors_transport1_idx` (`transport_id`),
                           CONSTRAINT `fk_sensors_transport1` FOREIGN KEY (`transport_id`) REFERENCES `transport` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB;

CREATE TABLE `transport_sesnsors` (
                                      `id` int NOT NULL AUTO_INCREMENT,
                                      `speed` float DEFAULT NULL,
                                      `amount_of_gasoline` float DEFAULT NULL,
                                      `position_id` int NOT NULL,
                                      `sensors_id` int NOT NULL,
                                      PRIMARY KEY (`id`),
                                      KEY `fk_transport_sesnsors_position1_idx` (`position_id`),
                                      KEY `fk_transport_sesnsors_sensors1_idx` (`sensors_id`),
                                      CONSTRAINT `fk_transport_sesnsors_position1` FOREIGN KEY (`position_id`) REFERENCES `position` (`id`),
                                      CONSTRAINT `fk_transport_sesnsors_sensors1` FOREIGN KEY (`sensors_id`) REFERENCES `sensors` (`id`)
) ENGINE=InnoDB;

CREATE TABLE `worker_sensors` (
                                  `id` int NOT NULL AUTO_INCREMENT,
                                  `temperature` float DEFAULT NULL,
                                  `palpitation` float DEFAULT NULL,
                                  `sensors_id` int NOT NULL,
                                  PRIMARY KEY (`id`),
                                  KEY `fk_worker_sensors_sensors1_idx` (`sensors_id`),
                                  CONSTRAINT `fk_worker_sensors_sensors1` FOREIGN KEY (`sensors_id`) REFERENCES `sensors` (`id`)
) ENGINE=InnoDB;

CREATE TABLE `worker` (
                          `id` int NOT NULL AUTO_INCREMENT,
                          `transport_id` int NOT NULL,
                          PRIMARY KEY (`id`),
                          KEY `fk_worker_transport1_idx` (`transport_id`),
                          CONSTRAINT `fk_worker_transport1` FOREIGN KEY (`transport_id`) REFERENCES `transport` (`id`)
) ENGINE=InnoDB;

CREATE TABLE `worker_info` (
                               `worker_id` int NOT NULL,
                               `first_name` varchar(45) NOT NULL,
                               `last_name` varchar(45) NOT NULL,
                               `birhday` date NOT NULL,
                               KEY `fk_worker_info_worker1` (`worker_id`),
                               CONSTRAINT `fk_worker_info_worker1` FOREIGN KEY (`worker_id`) REFERENCES `worker` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
                               INDEX(`first_name`),
                               INDEX(`last_name`)
) ENGINE=InnoDB;

CREATE TABLE `medic_status` (
                                `id` int NOT NULL AUTO_INCREMENT,
                                `date` date DEFAULT NULL,
                                `temperature` float DEFAULT NULL,
                                `worker_id` int NOT NULL,
                                PRIMARY KEY (`id`),
                                KEY `fk_medic_status_worker_idx` (`worker_id`),
                                CONSTRAINT `fk_medic_status_worker` FOREIGN KEY (`worker_id`) REFERENCES `worker` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB;

CREATE TABLE `medical_insurance` (
                                     `medic_id` int NOT NULL,
                                     `medic_code` varchar(45) DEFAULT NULL,
                                     KEY `fk_medical_insurance_medic_status1_idx` (`medic_id`),
                                     CONSTRAINT `fk_medical_insurance_medic_status1` FOREIGN KEY (`medic_id`) REFERENCES `medic_status` (`id`)
) ENGINE=InnoDB;




INSERT INTO `position` VALUES (1,45.3456,34.5635),(2,46.3456,32.5644),(3,47.3456,31.5644),(4,48.3456,30.5644),(5,48.3456,29.5644),(6,43.3456,30.5644),(7,44.3456,30.5644),(8,45.3456,30.5644),(9,41.3456,30.5644),(10,40.3456,30.5644),(11,47.3456,31.5644),(12,47.3456,31.5644),(13,47.3456,31.5644),(14,47.3456,31.5644),(15,47.3456,31.5644),(16,47.3456,31.5644),(17,47.3456,31.5644),(18,47.3456,31.5644),(19,47.3456,31.5644),(20,47.3456,31.5644);

INSERT INTO `career` VALUES (1,'carrer 1',1),(2,'carrer 2',2),(3,'carrer 3',3),(4,'carrer 4',4),(5,'carrer 5',5),(6,'carrer 6',6),(7,'carrer 8',8),(8,'carrer 9',9),(9,'carrer 10',10),(10,'career 7',7);

INSERT INTO `transport` VALUES (1,'model 1','red',1),(2,'model 2','red',2),(12,'model 3','green',3),(13,'model 4','green',4),(14,'model 5','green',5),(15,'model 6','green',6),(16,'model 7','green',7),(17,'model 8','green',8),(18,'model 9','green',9),(19,'model 10','green',10);

INSERT INTO `sensors` VALUES (1,1,'2021-09-20 17:34:06'),(2,2,'2021-09-20 17:34:06'),(12,12,'2021-09-20 17:34:06'),(13,13,'2021-09-20 17:34:06'),(14,14,'2021-09-20 17:34:06'),(15,15,'2021-09-20 17:34:06'),(16,16,'2021-09-20 17:34:06'),(17,17,'2021-09-20 17:34:06'),(18,18,'2021-09-20 17:34:06'),(19,19,'2021-09-20 17:34:06');

INSERT INTO `transport_sesnsors` VALUES (1,60,34,11,1),(2,60,34,12,2),(12,60,34,13,12),(13,60,34,14,13),(14,60,34,15,14),(15,60,34,16,15),(16,60,34,17,16),(17,60,34,18,17),(18,60,34,19,18),(19,60,34,20,19);

INSERT INTO `worker_sensors` VALUES (1,36.6,80,1),(2,36.6,80,2),(12,36.6,80,12),(13,36.6,80,13),(14,36.6,80,14),(15,36.6,80,15),(16,36.6,80,16),(17,36.6,80,17),(18,36.6,80,18),(19,36.6,80,19);

INSERT INTO `worker` VALUES (1,1),(2,2),(6,12),(7,13),(8,14),(9,15),(10,16),(11,17),(12,18),(13,19);

INSERT INTO `worker_info` VALUES (1,'ivan','petrovuh','2015-12-17'),(2,'petro','petrovuh','1999-12-07'),(6,'dominick','walton','1999-10-11'),(7,'hamaad','walton','1999-10-11'),(8,'hamaad','horner','1999-09-11'),(9,'dilan','atherton','1999-09-12'),(10,'pearce','friedman','1999-09-12'),(11,'kaylan','friedman','1998-09-12'),(12,'wil','lindsay','1998-09-12'),(13,'caspian','lindsay','1978-09-12');

INSERT INTO `medic_status` VALUES (1,'2021-09-20',36.6,1),(2,'2021-09-20',36.7,2),(3,'2021-09-20',36.3,6),(4,'2021-09-20',36.5,7),(5,'2021-09-20',36.5,8),(6,'2021-09-20',36.5,9),(7,'2021-09-20',36.5,10),(8,'2021-09-20',36.5,11),(9,'2021-09-20',36.5,12),(10,'2021-09-20',36.5,13);

INSERT INTO `medical_insurance` VALUES (1,'RERKFLRTGKLE'),(2,'DJVKLJETRVE'),(4,'EEVHCFECTB'),(5,'ELMKVKLERTH'),(6,'WEMLKFMVRV'),(7,'LVLRKTMB'),(8,'LMKECKLNREVT'),(9,'WEMKLFEKRLTGMRT'),(10,'WEKFNRETGYHJ');