--2.1 SELECT
SELECT * FROM Employee;

SELECT * FROM Employee WHERE Lastname = 'King';

SELECT * FROM Employee WHERE Firstname = 'Andrew' AND ReportsTo IS NULL;

--2.2 ORDER BY
SELECT * FROM Album ORDER BY Title DESC;

SELECT Firstname FROM Customer ORDER BY City ASC;

--2.3 INSERT INTO
INSERT INTO Genre (Name) VALUES ('Pop-Punk');
INSERT INTO Genre (Name) VALUES ('Classical-Metal');

INSERT INTO Employee (Lastname, Firstname, Title)
VALUES ('Fairbanks', 'Daniel', 'Java Developer');
INSERT INTO Employee (Lastname, Firstname, Title, City, State)
VALUES ('Andrew', 'Bonds', 'Engineer', 'Reston', 'VA');

INSERT INTO Customer (Firstname, Lastname, Email)
VALUES ('Zelda', 'Hyrule', 'princess@Hyrule.com');
INSERT INTO Customer (Firstname, Lastname, Country, Email)
VALUES ('Mario', 'Bro', 'Nintendoland', 'plumberbro@Nintendo.com');

--2.4 UPDATE
UPDATE Customer SET Firstname = 'Robert', Lastname = 'Walter'
WHERE Firstname = 'Aaron' AND Lastname = 'Mitchell';

UPDATE Artist SET Name = 'CCR' 
WHERE Name = 'Creedence Clearwater Revival';

--2.5 LIKE
SELECT * FROM Invoice WHERE BillingAddress LIKE 'T%';

--2.6 BETWEEN
SELECT * FROM Invoice WHERE Total BETWEEN 15 AND 50;

SELECT * FROM Employee WHERE HireDate 
BETWEEN '01-JUN-03' AND '01-MAR-04';

--2.7 DELETE
DELETE FROM Customer WHERE Firstname = 'Robert' AND Lastname = 'Walter';
