
INSERT INTO STATUS (STATUSID, NAME)
VALUES(1, 'PENDING');
INSERT INTO STATUS (STATUSID, NAME)
VALUES(2, 'APPROVED');
INSERT INTO STATUS (STATUSID, NAME)
VALUES(3, 'DENIED');
/

INSERT INTO USERS (FIRSTNAME,LASTNAME,EMAIL,PASSWORD,ISMANAGER)
VALUES ('Aaron', 'Rodgers', 'arod@packers.com', 'gopackgo', 1);

INSERT INTO USERS (FIRSTNAME,LASTNAME,EMAIL,PASSWORD,ISMANAGER)
VALUES ('Aaron', 'Rodgers', 'dog', 'dog', 0);

SELECT * FROM USERS WHERE USERID = 1;

INSERT INTO REQUESTS (SUBMITTERID, AMOUNT)
VALUES (1, 10);
