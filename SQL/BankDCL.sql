
CREATE USER bank
IDENTIFIED BY somberlain;

GRANT CONNECT TO bank;
GRANT RESOURCE TO bank;
GRANT CREATE SESSION TO bank;
GRANT CREATE TABLE TO bank;
GRANT CREATE VIEW TO bank;