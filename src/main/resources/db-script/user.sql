 CREATE  DATABASE IF NOT EXISTS `user_db`;
 USE `user_db`;

 DROP  TABLE  IF EXISTS  `users`;

 CREATE TABLE `users`
   (
	username VARCHAR(50) NOT NULL,
    password VARCHAR(68) NOT NULL,
    PRIMARY KEY(username)
   ) ENGINE = InnoDB AUTO_INCREMENT=1 DEFAULT  CHARSET=latin1;


   DROP TABLE IF EXISTS  `authorities`;
   
   CREATE TABLE `authorities`
   (
		username VARCHAR(50) NOT NULL,
        authority VARCHAR(68) NOT NULL,
        FOREIGN KEY (username) REFERENCES users(username)
   ) ENGINE=InnoDb AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

