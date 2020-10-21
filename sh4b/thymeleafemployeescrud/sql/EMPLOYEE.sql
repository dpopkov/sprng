CREATE DATABASE IF NOT EXISTS `sh4b_employee_directory`;
USE `sh4b_employee_directory`;

DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `first_name` varchar(45) DEFAULT NULL,
    `last_name` varchar(45) DEFAULT NULL,
    `email` varchar(45) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO `employee` VALUES 
    (1, 'Leslie', 'Andrews', 'leslie@example.com'),
    (2, 'Emma', 'Baumgarten', 'emma@example.com'),
    (3, 'Avani', 'Gupta', 'avani@example.com'),
    (4, 'Yuri', 'Petrov', 'yuri@example.com'),
    (5, 'Juan', 'Vega', 'juan@example.com');
    
CREATE USER 'sh4bstudent'@'localhost' IDENTIFIED BY 'sh4b_Student';

GRANT ALL PRIVILEGES ON `sh4b_employee_directory`.* TO 'sh4bstudent'@'localhost';