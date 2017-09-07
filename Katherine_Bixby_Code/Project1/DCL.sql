-- Bank Data Control Language
CREATE USER projectone
IDENTIFIED BY p4ssw0rd;

GRANT CONNECT to projectone;
GRANT RESOURCE to projectone;
GRANT CREATE SESSION TO projectone;
GRANT CREATE TABLE TO projectone;
GRANT CREATE VIEW to projectone;