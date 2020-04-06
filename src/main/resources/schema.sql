use tutorial;

create table auth(
   id INT NOT NULL AUTO_INCREMENT UNIQUE,
   userId VARCHAR(20) NOT NULL UNIQUE,
   password VARCHAR(20) NOT NULL,
   active BOOLEAN NOT NULL default true,
   PRIMARY KEY ( id )
);

create table user(
   id INT NOT NULL AUTO_INCREMENT UNIQUE,
   userId VARCHAR(20) NOT NULL UNIQUE,
   userName VARCHAR(100) NOT NULL,
   userRole VARCHAR(10) NOT NULL,
   userEmail VARCHAR(150) NOT NULL,
   userContact VARCHAR(20) NOT NULL,
   PRIMARY KEY ( id )
);

INSERT INTO auth (userId, password) VALUES ('user1', 'user1');
INSERT INTO auth (userId, password) VALUES ('user2', 'user2');

INSERT INTO user (userId, userName, userRole, userEmail, userContact) VALUES ('user1', 'User1 Jhon Doe', 'Admin', 'user1email@emaildomain.com', '9876543210');
INSERT INTO user (userId, userName, userRole, userEmail, userContact) VALUES ('user2', 'User2 Jhon Doe', 'User', 'user2email@emaildomain.com', '9876543210');
