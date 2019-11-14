CREATE  USER 'dbUser'@'localhost' IDENTIFIED BY 'dbUser';

GRANT ALL PRIVILEGES ON * . * TO 'dbUser'@'localhost';

ALTER USER 'dbUser'@'localhost' IDENTIFIED WITH mysql_native_password BY 'dbUser';