-- Bank Data Control Language
CREATE USER hibank
IDENTIFIED BY p4ssw0rd;

GRANT CONNECT to hibank;
GRANT RESOURCE to hibank;
GRANT CREATE SESSION TO hibank;
GRANT CREATE TABLE TO hibank;
GRANT CREATE VIEW to hibank;