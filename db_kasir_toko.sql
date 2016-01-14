/*
SQLyog Ultimate v11.11 (64 bit)
MySQL - 5.6.20 : Database - db_kasir_toko
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_kasir_toko` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `db_kasir_toko`;

/*Table structure for table `barang` */

DROP TABLE IF EXISTS `barang`;

CREATE TABLE `barang` (
  `kd_barang` varchar(8) NOT NULL,
  `nama_barang` varchar(30) DEFAULT NULL,
  `jml_barang` varchar(5) DEFAULT NULL,
  `harga_barang` float DEFAULT NULL,
  `id_supplier` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`kd_barang`),
  KEY `id_supplier` (`id_supplier`),
  CONSTRAINT `barang_ibfk_1` FOREIGN KEY (`id_supplier`) REFERENCES `supplier` (`id_supplier`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `barang` */

insert  into `barang`(`kd_barang`,`nama_barang`,`jml_barang`,`harga_barang`,`id_supplier`) values ('a001','AC','3',2500000,'s002'),('l002','laptop asus core i5','5',700000,'s006'),('l020','laptop acer core i3','5',5000000,'s002'),('o001','oven lg','5',175000,'s003'),('s011','salon aktif dioba','10',600000,'s007'),('sy02','sanyo','3',1000000,'s004'),('t001','televisi Lg 32 inci','2',4000000,'s001'),('t002','televisi polytron 21 inci','10',1800000,'s010'),('t003','televisi sharp 21 inci','1',250000,'s005');

/*Table structure for table `detail_belanja` */

DROP TABLE IF EXISTS `detail_belanja`;

CREATE TABLE `detail_belanja` (
  `kd_struk` int(5) DEFAULT NULL,
  `kd_barang` varchar(8) DEFAULT NULL,
  `tgl_transaksi` date DEFAULT NULL,
  `harga_satuan` float DEFAULT NULL,
  `jml_belanja` int(4) DEFAULT NULL,
  `total_harga` float DEFAULT NULL,
  KEY `detail_belanja_ibfk_1` (`kd_barang`),
  KEY `kd_struk` (`kd_struk`),
  CONSTRAINT `detail_belanja_ibfk_1` FOREIGN KEY (`kd_barang`) REFERENCES `barang` (`kd_barang`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `detail_belanja_ibfk_2` FOREIGN KEY (`kd_struk`) REFERENCES `struk_belanja` (`kd_struk`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `detail_belanja` */

insert  into `detail_belanja`(`kd_struk`,`kd_barang`,`tgl_transaksi`,`harga_satuan`,`jml_belanja`,`total_harga`) values (2,'sy02','2015-10-04',1000000,1,1000000),(1,'l020','2015-11-02',200000,1,20000),(3,'t001','2015-11-02',20000,1,20000),(2,'t003','2015-10-25',20000,3,60000),(2,'a001','2015-11-01',20000,2,40000),(4,'o001','2015-10-25',20000,3,60000),(2,'l002','2015-11-01',20000,4,80000),(1,'s011','2015-10-04',20000,5,100000),(2,'t002','2015-10-31',20000,5,100000),(2,'t002','2015-12-28',20000,2,400000),(3,'t003','2015-12-28',20000,2,400000),(3,'t003','2015-12-28',20000,2,400000),(3,'t003','2015-12-28',20000,2,400000),(3,'t003','2015-12-28',20000,2,400000),(26,'t003','2015-12-28',20000,2,400000),(33,'a001','2015-12-28',2500000,1,2500000),(33,'sy02','2015-12-28',1000000,3,3000000),(34,'a001','2015-12-28',2500000,2,5000000),(38,'a001','2015-12-28',2500000,2,5000000),(39,'a001','2015-12-28',2500000,3,7500000),(40,'a001','2015-12-28',2500000,2,5000000),(41,'a001','2015-12-28',2500000,2,5000000),(41,'sy02','2015-12-28',1000000,3,3000000),(42,'a001','2015-12-28',2500000,3,7500000),(42,'sy02','2015-12-28',1000000,2,2000000),(43,'a001','2015-12-28',2500000,2,5000000),(43,'sy02','2015-12-28',1000000,3,3000000),(45,'a001','2015-12-28',2500000,2,5000000),(46,'a001','2015-12-28',2500000,2,5000000),(46,'sy02','2015-12-28',1000000,4,4000000),(47,'a001','2015-12-28',2500000,4,10000000),(48,'sy02','2015-12-28',1000000,3,3000000),(49,'a001','2015-12-28',2500000,4,10000000),(50,'a001','2015-12-28',2500000,3,7500000),(54,'a001','2015-12-28',2500000,3,7500000),(54,'t001','2015-12-28',4000000,2,8000000),(55,'t001','2015-12-28',4000000,2,8000000),(55,'a001','2015-12-28',2500000,3,7500000);

/*Table structure for table `karyawan` */

DROP TABLE IF EXISTS `karyawan`;

CREATE TABLE `karyawan` (
  `id_karyawan` varchar(8) NOT NULL,
  `nama_karyawan` varchar(30) DEFAULT NULL,
  `jabatan` varchar(20) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_karyawan`),
  KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `karyawan` */

insert  into `karyawan`(`id_karyawan`,`nama_karyawan`,`jabatan`,`username`) values ('u001','rusdi noor firdaus','manager','rusdi'),('u002','siti mulyati','staf','siti'),('u003','ingeu lizzi novianna','kasir','ingeu'),('u004','arif ardian','kasir','arif'),('u005','tami safitri','staf','tami'),('u006','hani','kasir','hani'),('u007','sarah nur pitri','staf','sarah'),('u008','ario dilla','staf','ario'),('u009','rahmad karyadi','kasir','rahmad'),('u010','anisa','kasir','anisa');

/*Table structure for table `struk_belanja` */

DROP TABLE IF EXISTS `struk_belanja`;

CREATE TABLE `struk_belanja` (
  `kd_struk` int(5) NOT NULL,
  `tgl_transaksi` date DEFAULT NULL,
  `total_belanja` double DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`kd_struk`),
  KEY `struk_belanja_ibfk_1` (`username`),
  CONSTRAINT `struk_belanja_ibfk_1` FOREIGN KEY (`username`) REFERENCES `user` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `struk_belanja` */

insert  into `struk_belanja`(`kd_struk`,`tgl_transaksi`,`total_belanja`,`username`) values (1,'2015-02-04',NULL,'anisa'),(2,'2015-04-07',NULL,'anisa'),(3,'2015-05-06',NULL,'ario'),(4,'2015-07-10',NULL,'ario'),(5,'2015-07-12',NULL,'anisa'),(6,'2015-09-25',NULL,'hani'),(7,'2015-10-11',NULL,'hani'),(8,'2015-10-15',NULL,'hani'),(9,'2015-10-18',NULL,'hani'),(10,'2015-10-20',NULL,'hani'),(11,'2015-12-28',NULL,'hani'),(12,'2015-12-28',NULL,'anisa'),(13,'2015-12-28',NULL,'sarah'),(14,'2015-12-28',NULL,'sarah'),(15,'2015-12-28',NULL,'sarah'),(16,'2015-12-28',NULL,NULL),(17,'2015-12-28',NULL,NULL),(18,'2015-12-28',NULL,NULL),(19,'2015-12-28',NULL,NULL),(20,'2015-12-28',NULL,NULL),(21,'2015-12-28',NULL,'anisa'),(22,'2015-12-28',NULL,'anisa'),(23,'2015-12-28',NULL,'anisa'),(24,NULL,NULL,'rahmad'),(25,NULL,NULL,'rahmad'),(26,'2015-12-28',NULL,NULL),(27,NULL,NULL,NULL),(28,NULL,NULL,NULL),(29,NULL,NULL,NULL),(30,NULL,NULL,NULL),(31,NULL,NULL,NULL),(32,NULL,NULL,NULL),(33,'2015-12-28',NULL,NULL),(34,'2015-12-28',NULL,NULL),(35,NULL,NULL,NULL),(36,NULL,NULL,NULL),(37,NULL,NULL,NULL),(38,'2015-12-28',NULL,NULL),(39,'2015-12-28',NULL,NULL),(40,'2015-12-28',NULL,NULL),(41,'2015-12-28',NULL,NULL),(42,'2015-12-28',NULL,NULL),(43,'2015-12-28',NULL,NULL),(44,'2015-12-28',NULL,NULL),(45,'2015-12-28',NULL,NULL),(46,'2015-12-28',NULL,NULL),(47,'2015-12-28',NULL,NULL),(48,'2015-12-28',NULL,NULL),(49,'2015-12-28',NULL,NULL),(50,'2015-12-28',NULL,NULL),(51,'2015-12-28',NULL,NULL),(52,'2015-12-28',NULL,NULL),(53,'2015-12-28',NULL,NULL),(54,'2015-12-28',NULL,NULL),(55,'2015-12-28',NULL,NULL);

/*Table structure for table `supplier` */

DROP TABLE IF EXISTS `supplier`;

CREATE TABLE `supplier` (
  `id_supplier` varchar(8) NOT NULL,
  `nama_supplier` varchar(30) DEFAULT NULL,
  `alamat` varchar(50) DEFAULT NULL,
  `no_hp` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id_supplier`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `supplier` */

insert  into `supplier`(`id_supplier`,`nama_supplier`,`alamat`,`no_hp`) values ('s001','asep','jl.tubagus','082213098789'),('s002','bayu','jl.suci','087726151782'),('s003','irawan','cimahi','081213095679'),('s004','boby','padalarang','081212468479'),('s005','arif','bukit dago','082246078780'),('s006','dedi','sekeloa','081267098785'),('s007','eko','cihelang 1','081256098787'),('s008','santi','cikutra','087713098555'),('s009','ina','pusdai','089634598589'),('s010','ani','ciumbeleuit','081323098779');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `nama` varchar(30) DEFAULT NULL,
  `level_akses` varchar(20) DEFAULT NULL,
  `id_karyawan` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`username`),
  KEY `id_karyawan` (`id_karyawan`),
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`id_karyawan`) REFERENCES `karyawan` (`id_karyawan`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `user` */

insert  into `user`(`username`,`password`,`nama`,`level_akses`,`id_karyawan`) values ('admin','admin','rian','administrator',NULL),('anisa','anisa','anisa','user',NULL),('arif','arif','arif','user',NULL),('ario','ario','ario dilla','user',NULL),('hani','hani','hani','user',NULL),('ingeu','ingeu','ingeu','user',NULL),('rahmad','rahmad','rahmad','user',NULL),('rusdi','rusdi','rusdi','administrator',NULL),('sarah','sarah','sarah','user',NULL),('siti','siti','siti','user',NULL),('tami','tami','tami','user',NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
