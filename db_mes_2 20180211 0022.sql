-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.45-community-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema db_mes_2
--

CREATE DATABASE IF NOT EXISTS db_mes_2;
USE db_mes_2;

--
-- Definition of table `tbl_account_details`
--

DROP TABLE IF EXISTS `tbl_account_details`;
CREATE TABLE `tbl_account_details` (
  `account_details_id` int(10) unsigned NOT NULL auto_increment,
  `account_id` int(10) unsigned NOT NULL,
  `member_id` int(10) unsigned NOT NULL,
  `ttl_deposit` double NOT NULL default '0',
  `ttl_meal` double NOT NULL default '0',
  `num_bazar` double NOT NULL default '0',
  `extra` double NOT NULL default '0',
  PRIMARY KEY  (`account_details_id`),
  KEY `FK_account_details_account_id` (`account_id`),
  CONSTRAINT `FK_account_details_account_id` FOREIGN KEY (`account_id`) REFERENCES `tbl_accounts` (`account_id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_account_details`
--

/*!40000 ALTER TABLE `tbl_account_details` DISABLE KEYS */;
INSERT INTO `tbl_account_details` (`account_details_id`,`account_id`,`member_id`,`ttl_deposit`,`ttl_meal`,`num_bazar`,`extra`) VALUES 
 (1,1,1,2100,2,2,0),
 (2,1,4,0,0,0,0),
 (3,1,5,0,0,0,0),
 (19,5,4,0,0,0,0),
 (20,5,5,0,0,0,0),
 (21,5,6,0,0,0,0),
 (22,5,7,0,0,0,0),
 (23,5,8,0,0,0,0),
 (24,6,4,0,0,0,0),
 (25,6,5,0,0,0,0),
 (26,6,6,0,0,0,0),
 (27,6,7,0,0,0,0),
 (28,6,8,0,0,0,0),
 (29,7,4,0,80,1,0),
 (30,7,5,0,36,0,0),
 (31,7,6,0,39,0,0),
 (32,7,7,0,14,0,0),
 (33,7,8,0,9,3,0),
 (34,8,4,3690,16,1,0),
 (35,8,5,2738,13,0,0),
 (36,8,6,2280,17,5,0),
 (37,8,7,1154,5,3,0),
 (38,8,8,3612,12,1,0),
 (39,9,4,4453,13,0,0),
 (40,9,5,1500,15,0,0),
 (41,9,6,1545,17,3,0),
 (42,9,7,1434,9,1,0),
 (43,9,8,300,5,1,0),
 (44,11,4,0,0,0,0),
 (45,11,5,0,0,0,0),
 (46,11,6,0,0,0,0),
 (47,11,7,0,0,0,0),
 (48,11,8,0,0,0,0),
 (49,11,9,0,0,0,0);
/*!40000 ALTER TABLE `tbl_account_details` ENABLE KEYS */;


--
-- Definition of table `tbl_accountants`
--

DROP TABLE IF EXISTS `tbl_accountants`;
CREATE TABLE `tbl_accountants` (
  `accountant_id` int(10) unsigned NOT NULL auto_increment,
  `name` varchar(45) NOT NULL,
  `user_name` varchar(45) NOT NULL,
  `pass` varchar(45) NOT NULL,
  PRIMARY KEY  USING BTREE (`accountant_id`),
  UNIQUE KEY `user_name` (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_accountants`
--

/*!40000 ALTER TABLE `tbl_accountants` DISABLE KEYS */;
INSERT INTO `tbl_accountants` (`accountant_id`,`name`,`user_name`,`pass`) VALUES 
 (1,'Zakaria','zakaria','zakaria123'),
 (7,'Shafi','shafi','shafi123'),
 (8,'Shafi','safi','safi123'),
 (9,'Emon','emon','emon123'),
 (10,'rohman','rohman','sdf');
/*!40000 ALTER TABLE `tbl_accountants` ENABLE KEYS */;


--
-- Definition of table `tbl_accounts`
--

DROP TABLE IF EXISTS `tbl_accounts`;
CREATE TABLE `tbl_accounts` (
  `account_id` int(10) unsigned NOT NULL auto_increment,
  `accountant_id` int(10) unsigned NOT NULL,
  `start_date` date default NULL,
  `end_date` date default NULL,
  `acc_name` varchar(45) NOT NULL default '',
  PRIMARY KEY  (`account_id`),
  KEY `FK_tbl_acc_basic_info_manager_id` USING BTREE (`accountant_id`),
  CONSTRAINT `FK_tbl_accounts_accountant_id` FOREIGN KEY (`accountant_id`) REFERENCES `tbl_accountants` (`accountant_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_accounts`
--

/*!40000 ALTER TABLE `tbl_accounts` DISABLE KEYS */;
INSERT INTO `tbl_accounts` (`account_id`,`accountant_id`,`start_date`,`end_date`,`acc_name`) VALUES 
 (1,1,'2018-01-01',NULL,'January'),
 (2,1,'2018-01-01',NULL,'January2'),
 (3,1,'2018-02-02',NULL,'February 89'),
 (4,1,'2018-02-08',NULL,'February 23'),
 (5,1,'2018-02-08',NULL,'February 4'),
 (6,1,'2018-02-08',NULL,'February  34'),
 (7,1,'2018-02-08',NULL,'February7'),
 (8,1,'2018-02-08',NULL,'February'),
 (9,1,'2018-02-10',NULL,'Acc_Feb2'),
 (11,1,'2018-02-10',NULL,'Acc_10');
/*!40000 ALTER TABLE `tbl_accounts` ENABLE KEYS */;


--
-- Definition of table `tbl_bazars`
--

DROP TABLE IF EXISTS `tbl_bazars`;
CREATE TABLE `tbl_bazars` (
  `bazar_id` int(10) unsigned NOT NULL auto_increment,
  `account_id` int(10) unsigned NOT NULL,
  `member_id` int(10) unsigned NOT NULL,
  `bazar_amt` double NOT NULL,
  `bazar_date` date NOT NULL,
  PRIMARY KEY  (`bazar_id`),
  KEY `FK_tbl_bazars_account_id` (`account_id`),
  CONSTRAINT `FK_tbl_bazars_account_id` FOREIGN KEY (`account_id`) REFERENCES `tbl_accounts` (`account_id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_bazars`
--

/*!40000 ALTER TABLE `tbl_bazars` DISABLE KEYS */;
INSERT INTO `tbl_bazars` (`bazar_id`,`account_id`,`member_id`,`bazar_amt`,`bazar_date`) VALUES 
 (15,8,4,3445,'2018-02-10'),
 (16,8,6,600,'2018-02-10'),
 (17,9,6,545,'2018-02-10'),
 (18,9,6,235,'2018-02-10'),
 (19,9,6,454,'2018-02-10'),
 (20,9,7,45,'2018-02-10'),
 (21,9,8,700,'2018-02-10');
/*!40000 ALTER TABLE `tbl_bazars` ENABLE KEYS */;


--
-- Definition of trigger `tBeforeAddbazar`
--

DROP TRIGGER /*!50030 IF EXISTS */ `tBeforeAddbazar`;

DELIMITER $$

CREATE DEFINER = `root`@`localhost` TRIGGER `tBeforeAddbazar` BEFORE INSERT ON `tbl_bazars` FOR EACH ROW BEGIN
UPDATE db_mes_2.tbl_account_details SET num_bazar=num_bazar+1
where member_id=NEW.member_id AND account_id=NEW.account_id;
END $$

DELIMITER ;

--
-- Definition of table `tbl_deposits`
--

DROP TABLE IF EXISTS `tbl_deposits`;
CREATE TABLE `tbl_deposits` (
  `deposit_id` int(10) unsigned NOT NULL auto_increment,
  `account_id` int(10) unsigned NOT NULL,
  `member_id` int(10) unsigned NOT NULL,
  `deposit_amt` double NOT NULL,
  `deposit_date` date NOT NULL,
  PRIMARY KEY  USING BTREE (`deposit_id`),
  KEY `FK_tbl_diposits_member_id` (`member_id`),
  KEY `FK_tbl_deposits_account_id` (`account_id`),
  CONSTRAINT `FK_tbl_deposits_account_id` FOREIGN KEY (`account_id`) REFERENCES `tbl_accounts` (`account_id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_deposits`
--

/*!40000 ALTER TABLE `tbl_deposits` DISABLE KEYS */;
INSERT INTO `tbl_deposits` (`deposit_id`,`account_id`,`member_id`,`deposit_amt`,`deposit_date`) VALUES 
 (1,1,1,500,'2018-01-02'),
 (2,1,1,500,'2018-01-03'),
 (3,1,1,600,'2018-01-09'),
 (4,1,1,1000,'2018-02-01'),
 (5,8,4,2600,'2018-02-08'),
 (6,8,5,2000,'2018-02-08'),
 (7,8,6,1500,'2018-02-08'),
 (8,8,7,870,'2018-02-08'),
 (9,8,8,3000,'2018-02-08'),
 (10,8,4,890,'2018-02-09'),
 (11,8,5,738,'2018-02-09'),
 (12,8,6,780,'2018-02-09'),
 (13,8,7,284,'2018-02-09'),
 (14,8,8,489,'2018-02-09'),
 (15,8,4,200,'2018-02-10'),
 (16,8,8,123,'2018-02-10'),
 (17,9,4,1000,'2018-02-10'),
 (18,9,6,200,'2018-02-10'),
 (19,9,8,300,'2018-02-10'),
 (20,9,6,345,'2018-02-10'),
 (21,9,7,434,'2018-02-10'),
 (22,9,4,453,'2018-02-10'),
 (23,9,4,3000,'2018-02-10'),
 (24,9,5,500,'2018-02-10'),
 (25,9,6,1000,'2018-02-10'),
 (26,9,7,1000,'2018-02-10'),
 (27,9,5,1000,'2018-02-10');
/*!40000 ALTER TABLE `tbl_deposits` ENABLE KEYS */;


--
-- Definition of trigger `tBeforeAddDiposit`
--

DROP TRIGGER /*!50030 IF EXISTS */ `tBeforeAddDiposit`;

DELIMITER $$

CREATE DEFINER = `root`@`localhost` TRIGGER `tBeforeAddDiposit` BEFORE INSERT ON `tbl_deposits` FOR EACH ROW BEGIN
UPDATE db_mes_2.tbl_account_details SET ttl_deposit=ttl_deposit+NEW.deposit_amt
where member_id=NEW.member_id AND account_id=NEW.account_id;
END $$

DELIMITER ;

--
-- Definition of table `tbl_extras`
--

DROP TABLE IF EXISTS `tbl_extras`;
CREATE TABLE `tbl_extras` (
  `extra_id` int(10) unsigned NOT NULL auto_increment,
  `account_id` int(10) unsigned NOT NULL,
  `extra_name` varchar(45) NOT NULL,
  `extra_amount` double NOT NULL,
  PRIMARY KEY  (`extra_id`),
  KEY `FK_tbl_extras_account_id` (`account_id`),
  CONSTRAINT `FK_tbl_extras_account_id` FOREIGN KEY (`account_id`) REFERENCES `tbl_accounts` (`account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_extras`
--

/*!40000 ALTER TABLE `tbl_extras` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_extras` ENABLE KEYS */;


--
-- Definition of table `tbl_managers`
--

DROP TABLE IF EXISTS `tbl_managers`;
CREATE TABLE `tbl_managers` (
  `manager_id` int(10) unsigned NOT NULL auto_increment,
  `name` varchar(45) NOT NULL,
  `user_name` varchar(45) NOT NULL,
  `pass` varchar(45) NOT NULL,
  `mess_name` varchar(45) NOT NULL default '',
  `sdate` date NOT NULL,
  PRIMARY KEY  USING BTREE (`manager_id`),
  UNIQUE KEY `user_name` (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1 COMMENT='Table Mess Manager';

--
-- Dumping data for table `tbl_managers`
--

/*!40000 ALTER TABLE `tbl_managers` DISABLE KEYS */;
INSERT INTO `tbl_managers` (`manager_id`,`name`,`user_name`,`pass`,`mess_name`,`sdate`) VALUES 
 (1,'Zakaria','zakaria123','Frinds','','0000-00-00'),
 (2,'Zakaria','zakaria','zakaria123','','2018-01-01'),
 (3,'Ismail','ismail','ismail123','','2018-02-03'),
 (4,'Ismail','ismail2','sf','','2018-02-05'),
 (5,'Emon','emon','emon123','','2018-02-05'),
 (6,'arif','arif','arif','','2018-02-05'),
 (7,'Shuvo','shuvo','sd','','2018-02-05'),
 (8,'rohman','rohman','rohman','','2018-02-05');
/*!40000 ALTER TABLE `tbl_managers` ENABLE KEYS */;


--
-- Definition of table `tbl_meals`
--

DROP TABLE IF EXISTS `tbl_meals`;
CREATE TABLE `tbl_meals` (
  `meal_id` int(10) unsigned NOT NULL auto_increment,
  `account_id` int(10) unsigned NOT NULL,
  `member_id` int(10) unsigned NOT NULL,
  `num_meal` double NOT NULL,
  `meal_date` date NOT NULL,
  PRIMARY KEY  (`meal_id`),
  KEY `FK_tbl_meals_member_id` (`member_id`),
  KEY `FK_tbl_meals_account_account_id` (`account_id`),
  CONSTRAINT `FK_tbl_meals_account_account_id` FOREIGN KEY (`account_id`) REFERENCES `tbl_accounts` (`account_id`)
) ENGINE=InnoDB AUTO_INCREMENT=106 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_meals`
--

/*!40000 ALTER TABLE `tbl_meals` DISABLE KEYS */;
INSERT INTO `tbl_meals` (`meal_id`,`account_id`,`member_id`,`num_meal`,`meal_date`) VALUES 
 (33,7,4,5,'2018-02-08'),
 (34,7,4,5,'2018-02-08'),
 (35,7,5,2,'2018-02-08'),
 (36,7,4,5,'2018-02-08'),
 (37,7,5,2,'2018-02-08'),
 (38,7,6,3,'2018-02-08'),
 (39,7,4,5,'2018-02-08'),
 (40,7,5,2,'2018-02-08'),
 (41,7,6,3,'2018-02-08'),
 (42,7,7,2,'2018-02-08'),
 (43,7,4,5,'2018-02-08'),
 (44,7,5,2,'2018-02-08'),
 (45,7,6,3,'2018-02-08'),
 (46,7,7,2,'2018-02-08'),
 (47,7,8,3,'2018-02-08'),
 (48,7,4,4,'2018-02-08'),
 (49,7,4,4,'2018-02-08'),
 (50,7,5,2,'2018-02-08'),
 (51,7,4,4,'2018-02-08'),
 (52,7,5,2,'2018-02-08'),
 (53,7,6,5,'2018-02-08'),
 (54,7,4,4,'2018-02-08'),
 (55,7,5,2,'2018-02-08'),
 (56,7,6,5,'2018-02-08'),
 (57,7,7,2,'2018-02-08'),
 (58,7,4,4,'2018-02-08'),
 (59,7,5,2,'2018-02-08'),
 (60,7,6,5,'2018-02-08'),
 (61,7,7,2,'2018-02-08'),
 (62,7,8,1,'2018-02-08'),
 (63,8,4,3,'2018-02-09'),
 (64,8,5,2,'2018-02-09'),
 (65,8,6,3,'2018-02-09'),
 (66,8,7,1,'2018-02-09'),
 (67,8,8,2,'2018-02-09'),
 (68,8,4,3,'2018-02-09'),
 (69,8,5,2,'2018-02-09'),
 (70,8,6,3,'2018-02-09'),
 (71,8,7,1,'2018-02-09'),
 (72,8,8,2,'2018-02-09'),
 (73,8,4,3,'2018-02-09'),
 (74,8,5,2,'2018-02-09'),
 (75,8,6,3,'2018-02-09'),
 (76,8,4,4,'2018-02-10'),
 (77,8,5,5,'2018-02-10'),
 (78,8,6,7,'2018-02-10'),
 (79,8,7,1,'2018-02-10'),
 (80,8,8,5,'2018-02-10'),
 (81,8,4,3,'2018-02-10'),
 (82,8,5,2,'2018-02-10'),
 (83,8,6,1,'2018-02-10'),
 (84,8,7,2,'2018-02-10'),
 (85,8,8,3,'2018-02-10'),
 (86,9,4,2,'2018-02-10'),
 (87,9,5,3,'2018-02-10'),
 (88,9,6,4,'2018-02-10'),
 (89,9,7,2,'2018-02-10'),
 (90,9,8,1,'2018-02-10'),
 (91,9,4,4,'2018-02-10'),
 (92,9,5,5,'2018-02-10'),
 (93,9,6,6,'2018-02-10'),
 (94,9,7,2,'2018-02-10'),
 (95,9,8,1,'2018-02-10'),
 (96,9,4,4,'2018-02-10'),
 (97,9,5,5,'2018-02-10'),
 (98,9,6,6,'2018-02-10'),
 (99,9,7,2,'2018-02-10'),
 (100,9,8,1,'2018-02-10'),
 (101,9,4,3,'2018-02-10'),
 (102,9,5,2,'2018-02-10'),
 (103,9,6,1,'2018-02-10'),
 (104,9,7,3,'2018-02-10'),
 (105,9,8,2,'2018-02-10');
/*!40000 ALTER TABLE `tbl_meals` ENABLE KEYS */;


--
-- Definition of trigger `tBeforeAddMeal`
--

DROP TRIGGER /*!50030 IF EXISTS */ `tBeforeAddMeal`;

DELIMITER $$

CREATE DEFINER = `root`@`localhost` TRIGGER `tBeforeAddMeal` BEFORE INSERT ON `tbl_meals` FOR EACH ROW BEGIN
UPDATE db_mes_2.tbl_account_details SET ttl_meal=ttl_meal+NEW.num_meal
where member_id=NEW.member_id AND account_id=NEW.account_id;
END $$

DELIMITER ;

--
-- Definition of table `tbl_members`
--

DROP TABLE IF EXISTS `tbl_members`;
CREATE TABLE `tbl_members` (
  `member_id` int(10) unsigned NOT NULL auto_increment,
  `manager_id` int(10) unsigned NOT NULL,
  `f_name` varchar(45) NOT NULL default '',
  `l_name` varchar(45) NOT NULL default '',
  `meal_name` varchar(245) NOT NULL default '',
  `image` varchar(100) NOT NULL,
  `c_date` date NOT NULL default '0000-00-00',
  PRIMARY KEY  USING BTREE (`member_id`),
  KEY `FK_tbl_members_manager_id` (`manager_id`),
  CONSTRAINT `FK_tbl_members_manager_id` FOREIGN KEY (`manager_id`) REFERENCES `tbl_managers` (`manager_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1 COMMENT='Tble Mess Members';

--
-- Dumping data for table `tbl_members`
--

/*!40000 ALTER TABLE `tbl_members` DISABLE KEYS */;
INSERT INTO `tbl_members` (`member_id`,`manager_id`,`f_name`,`l_name`,`meal_name`,`image`,`c_date`) VALUES 
 (4,1,'Zakaria','Ahmmed','zakaria','','2018-02-02'),
 (5,1,'Zakaria2','Ahmmed2','','zakaria2','2018-02-02'),
 (6,1,'Habibur','Rahman','','C:\\Users\\Zakakaria\\Pictures','2018-02-06'),
 (7,1,'Imam','Hossin','','C:\\Users\\Zakakaria\\Pictures\\question.png','2018-02-06'),
 (8,1,'Riaz','Hero','','C:\\Users\\Zakakaria\\Pictures\\question.png','2018-02-06'),
 (9,1,'Sakib','ahmmed','','C:\\Users\\B5\\Desktop\\cat.jpg','2018-02-10');
/*!40000 ALTER TABLE `tbl_members` ENABLE KEYS */;


--
-- Definition of function `fAccountantLoginValidator`
--

DROP FUNCTION IF EXISTS `fAccountantLoginValidator`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER' */ $$
CREATE DEFINER=`root`@`localhost` FUNCTION `fAccountantLoginValidator`(u_name varchar(45),u_pass varchar(45)) RETURNS int(4)
BEGIN
return(SELECT COUNT(*) FROM db_mes_2.tbl_accountants where user_name=u_name and pass=u_pass);
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of function `fGetLastAccountId`
--

DROP FUNCTION IF EXISTS `fGetLastAccountId`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER' */ $$
CREATE DEFINER=`root`@`localhost` FUNCTION `fGetLastAccountId`() RETURNS int(11)
BEGIN
return(SELECT max(account_id) FROM db_mes_2.tbl_accounts);
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of function `fGetManagerId`
--

DROP FUNCTION IF EXISTS `fGetManagerId`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER' */ $$
CREATE DEFINER=`root`@`localhost` FUNCTION `fGetManagerId`(manager_name varchar (45)) RETURNS int(11)
BEGIN
return(select manager_id from db_mes_2.tbl_managers where manager_name='Zakaria');
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of function `fgetTotalBazar`
--

DROP FUNCTION IF EXISTS `fgetTotalBazar`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER' */ $$
CREATE DEFINER=`root`@`localhost` FUNCTION `fgetTotalBazar`(id int(10)) RETURNS int(11)
BEGIN
return(SELECT sum(bazar_amt) FROM db_mes_2.tbl_bazars where account_id=id);
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of function `fgetTotalMeal`
--

DROP FUNCTION IF EXISTS `fgetTotalMeal`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER' */ $$
CREATE DEFINER=`root`@`localhost` FUNCTION `fgetTotalMeal`(id int(10)) RETURNS int(11)
BEGIN
return(SELECT sum(ttl_meal) FROM db_mes_2.tbl_account_details where account_id=id);
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of function `fManagerLoginValidator`
--

DROP FUNCTION IF EXISTS `fManagerLoginValidator`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER' */ $$
CREATE DEFINER=`root`@`localhost` FUNCTION `fManagerLoginValidator`(u_name varchar(45),u_pass varchar(45)) RETURNS int(4)
BEGIN
return(SELECT COUNT(*) FROM db_mes_2.tbl_managers where user_name=u_name and pass=u_pass);
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of function `fTotalDiposit`
--

DROP FUNCTION IF EXISTS `fTotalDiposit`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER' */ $$
CREATE DEFINER=`root`@`localhost` FUNCTION `fTotalDiposit`(id int(10)) RETURNS int(11)
BEGIN
return(SELECT sum(ttl_deposit) from db_mes_2.tbl_account_details where account_id=id);
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of function `pGetManagerId`
--

DROP FUNCTION IF EXISTS `pGetManagerId`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER' */ $$
CREATE DEFINER=`root`@`localhost` FUNCTION `pGetManagerId`(manager_name VARCHAR (45)) RETURNS int(11)
BEGIN
RETURN (select manager_id from db_mes_2.tbl_managers where manager_name=manager_name);
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `getMembersForAccount`
--

DROP PROCEDURE IF EXISTS `getMembersForAccount`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getMembersForAccount`(in id int(10))
BEGIN
SELECT m.member_id, m.manager_id, m.f_name,m.l_name,m.meal_name,m.image,m.c_date
FROM db_mes_2.tbl_members m join db_mes_2.tbl_account_details d
on (m.member_id=d.member_id)
where account_id=id;
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `pAddAccount`
--

DROP PROCEDURE IF EXISTS `pAddAccount`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `pAddAccount`(in accountant_id integer, in start_date date, in acc_name varchar(45))
BEGIN
insert into db_mes_2.tbl_accounts (accountant_id, start_date,acc_name) values(accountant_id, start_date,acc_name);
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `pAddAccountant`
--

DROP PROCEDURE IF EXISTS `pAddAccountant`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `pAddAccountant`( in name varchar(45),in user_name varchar(45), in pass varchar(45))
BEGIN
insert into db_mes_2.tbl_accountants (name,user_name,pass) values(name,user_name,pass);
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `pAddAccountDetails`
--

DROP PROCEDURE IF EXISTS `pAddAccountDetails`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `pAddAccountDetails`(in account_id integer, in member_id integer)
BEGIN
insert into db_mes_2.tbl_account_details (account_id,member_id)
values(account_id,member_id);
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `pAddBazar`
--

DROP PROCEDURE IF EXISTS `pAddBazar`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `pAddBazar`(in a_id integer, in m_id integer, in b_amt double, in b_date date)
BEGIN
insert into db_mes_2.tbl_bazars (account_id,member_id, bazar_amt, bazar_date)
values(a_id,m_id, b_amt, b_date);
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `pAddDiposit`
--

DROP PROCEDURE IF EXISTS `pAddDiposit`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `pAddDiposit`(in account_id integer, in member_id integer,
in deposit_amt double, in deposit_date date)
BEGIN
insert into db_mes_2.tbl_deposits (account_id, member_id,deposit_amt,deposit_date)
values(account_id, member_id,deposit_amt,deposit_date);
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `pAddManager`
--

DROP PROCEDURE IF EXISTS `pAddManager`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `pAddManager`(in name varchar(45),in user_name varchar(45), in pass varchar(45),in sdate date)
BEGIN
insert into db_mes_2.tbl_managers (name, user_name, pass, sdate) values(name, user_name, pass, sdate);
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `pAddMeal`
--

DROP PROCEDURE IF EXISTS `pAddMeal`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `pAddMeal`(in account_id integer, in member_id integer,
in num_meal double, in meal_date date)
BEGIN
insert into db_mes_2.tbl_meals (account_id, member_id,num_meal,meal_date)
values(account_id, member_id,num_meal,meal_date);
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `pAddMember`
--

DROP PROCEDURE IF EXISTS `pAddMember`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `pAddMember`(in manager_id int, in f_name varchar(45),in l_name varchar(45)
,in image varchar(100), in c_date date)
BEGIN
insert into db_mes_2.tbl_members (manager_id, f_name,l_name,image,c_date) values(manager_id, f_name,l_name,image,c_date);
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `pGetAllAccountDetails`
--

DROP PROCEDURE IF EXISTS `pGetAllAccountDetails`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `pGetAllAccountDetails`(in id int(10))
BEGIN
SELECT * FROM db_mes_2.tbl_account_details where account_id=id;
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `pGetAllAccountForAccountant`
--

DROP PROCEDURE IF EXISTS `pGetAllAccountForAccountant`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `pGetAllAccountForAccountant`(in id int(10))
BEGIN
SELECT * FROM db_mes_2.tbl_accounts where accountant_id=id;
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `pGetAllBazar`
--

DROP PROCEDURE IF EXISTS `pGetAllBazar`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `pGetAllBazar`(in id int(10))
BEGIN
SELECT m.f_name,m.l_name,b.bazar_amt , b.bazar_date,b.account_id,b.member_id
FROM db_mes_2.tbl_members m join db_mes_2.tbl_bazars b
on (m.member_id=b.member_id)
where account_id=id
order by bazar_date;
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `pGetAllDiposit`
--

DROP PROCEDURE IF EXISTS `pGetAllDiposit`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `pGetAllDiposit`(in id int)
BEGIN
SELECT * FROM db_mes_2.tbl_deposits where account_id=id  order by(member_id);
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `pGetAllMembers`
--

DROP PROCEDURE IF EXISTS `pGetAllMembers`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `pGetAllMembers`()
BEGIN
select *from db_mes_2.tbl_members;
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `pUpdateMealName`
--

DROP PROCEDURE IF EXISTS `pUpdateMealName`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `pUpdateMealName`(in member_id int, in meal_name varchar(45))
BEGIN
update db_mes_2.tbl_members set meal_name=meal_name where member_id=1;
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `pUpdateMember`
--

DROP PROCEDURE IF EXISTS `pUpdateMember`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `pUpdateMember`(in member_id int,in name varchar(45), in image varchar(245))
BEGIN
update db_mes_2.tbl_members set name=name, image=image where member_id=member_id;
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;



/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
