/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.10-log : Database - boh
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`boh` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

USE `boh`;

/*Table structure for table `boh_switch` */

DROP TABLE IF EXISTS `boh_switch`;

CREATE TABLE `boh_switch` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `identity` varchar(50) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '开关唯一性标识',
  `level` tinyint(2) NOT NULL DEFAULT '0' COMMENT '开关级别 1接口级别 2业务类型级别 3功能级别 4参数级别 5日志开关 6变量级别',
  `content` text COLLATE utf8_bin NOT NULL COMMENT '开关内容 若开关级别为1、2、3、5则内容为 0开关打开 1开关关闭，其他开关级别:为具体内容',
  `service_name` varchar(100) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '服务名',
  `bussiness_type` tinyint(4) NOT NULL DEFAULT '0' COMMENT '业务类型',
  `mark` varchar(200) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '开关描述',
  `del_flag` tinyint(1) NOT NULL DEFAULT '0' COMMENT '删除标记(0 有效，1删除）默认0',
  `system_id` tinyint(4) NOT NULL DEFAULT '1' COMMENT '系统编号  1表示BOH-NM 2表示BOH-PRC 3表示BOH-OTH 4表示BOH-CACHE 5表示BOH-CNF',
  PRIMARY KEY (`id`),
  UNIQUE KEY `identity` (`identity`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `boh_switch` */

insert  into `boh_switch`(`id`,`identity`,`level`,`content`,`service_name`,`bussiness_type`,`mark`,`del_flag`,`system_id`) values (1,'resCostQuerySize',3,'20','',0,'desc',0,1),(3,'queryProductDatePriceResIdNumberPerThread',3,'40','',0,'desc',0,1),(4,'%E5%BC%80%E5%85%B3%E6%A0%87%E8%AF%86',3,'content','',0,'desc',0,1),(5,'stockOn',3,'1','',0,'%E5%BC%80%E5%85%B3',0,1),(6,'stockOn1',3,'content','',0,'%E5%BC%80%E5%85%B31',0,1),(7,'11',3,'%E4%BD%A0%E5%A5%BD','',0,'desc',0,1),(8,'%E5%BC%80%E5%85%B3%E6%A0%87%E8%AF%861',3,'content','',0,'desc',0,1),(9,'开关标识',3,'content','',0,'desc',0,1),(10,'开关标识1',3,'content','',0,'desc',0,1),(11,'开关标识2',3,'content','',0,'desc',0,1),(12,'开关标识4',3,'content','',0,'desc',0,1),(13,'开关标识5',3,'content','',0,'desc',0,1),(14,'开关标识6',3,'content内容','',0,'desc描述',0,1),(15,'开关标识7',3,'content','',0,'desc',0,1),(16,'vari_banScenicIdList',6,'1833746','',0,'产品详情中门票详情禁止的景点ID',0,1),(17,'vari_banHolidayIdList',6,'8862','',0,'产品详情中门票详情中禁用的holidyId',0,1),(18,'vari_refreshCacheExecutorSleepMillSecondesPerUnit',6,'1000','',0,'BOH-CACHE中线程每执行单元sleep的时间（毫秒）',0,4);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
