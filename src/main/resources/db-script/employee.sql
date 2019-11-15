CREATE DATABASE IF NOT EXISTS  `employee_db`;

USE `employee_db`;
CREATE TABLE employee(
  id int(10) NOT NULL,
  name varchar(50) NOT NULL,
  age int(10) NOT NULL,
  dept varchar(20) NOT NULL,
  PRIMARY KEY employee(id))ENGINE = InnoDB AUTO_INCREMENT =1  DEFAULT CHARSET=latin1;
