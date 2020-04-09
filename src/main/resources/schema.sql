use tutorial;

create table auth(
   id INT NOT NULL AUTO_INCREMENT UNIQUE,
   user_id VARCHAR(20) NOT NULL UNIQUE,
   password VARCHAR(20) NOT NULL,
   active BOOLEAN NOT NULL default true,
   PRIMARY KEY ( id )
);

create table user(
   id INT NOT NULL AUTO_INCREMENT UNIQUE,
   user_id VARCHAR(20) NOT NULL UNIQUE,
   user_name VARCHAR(100) NOT NULL,
   user_role VARCHAR(10) NOT NULL,
   user_email VARCHAR(150) NOT NULL,
   user_contact VARCHAR(20) NOT NULL,
   PRIMARY KEY ( id )
);

INSERT INTO auth (user_id, password) VALUES ('user1', 'user1');
INSERT INTO auth (userId, password) VALUES ('user2', 'user2');

INSERT INTO user (user_id, user_name, user_role, user_email, user_contact) VALUES ('user1', 'User1 Jhon Doe', 'Admin', 'user1email@emaildomain.com', '9876543210');
INSERT INTO user (user_id, user_name, user_role, user_email, user_contact) VALUES ('user2', 'User2 Jhon Doe', 'User', 'user2email@emaildomain.com', '9876543210');
