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
/*
ALTER TABLE Album DROP CONSTRAINT FK_AlbumArtistID;
ALTER TABLE Album ADD CONSTRAINT ArtistID_FK
FOREIGN KEY (ArtistID) REFERENCES Album (ArtistID) ON DELETE CASCADE;*/
DELETE FROM Customer WHERE Firstname = 'Robert' AND Lastname = 'Walter';

--3.0 FUNCTIONS
--3.1 SYSTEM DEFINED FUNCS
SELECT CURRENT_TIMESTAMP FROM dual;

--3.2 SYSTEM DEFINED AGGREGATE FUNCS

--3.3 USER DEFINED SCALAR FUNCS

--3.4 USER DEFINED TABLE VALUED FUNCS

--4.0 STORED PROCEDURES
--4.1 BASIC STORED PROCEDURE
--Task – Create a stored procedure that selects the first and last names of all the employees.

CREATE OR REPLACE PROCEDURE EmployeeNames
(
Emps OUT VARCHAR2
)
AS BEGIN
SELECT Firstname, Lastname FROM Employee INTO Emps;
RETURN Emps;
END EmployeeNames;
/

--4.2 STORED PROCEDURE INPUT PARAMS
--Task – Create a stored procedure that updates the personal information of an employee.
CREATE OR REPLACE PROCEDURE EditEmployee
(
id IN NUMBER,
fn IN VARCHAR2,
ln IN VARCHAR2
)
AS BEGIN
UPDATE Employee SET Firstname = fn, Lastname = ln
WHERE EmployeeID = id;
commit;
END EditEmployee;
/
BEGIN EditEmployee (3, 'Daniel', 'Fairbanks');
END;
/
SELECT * FROM Employee;

--Task – Create a stored procedure that returns the managers of an employee.
CREATE OR REPLACE PROCEDURE GetManager
(
id IN NUMBER
)
AS BEGIN
INSERT INTO Example (Firstname, Lastname, Favorite_Song_ID)
VALUES (fn, ln, songID);
commit;
END AddPerson;

--4.3 STORED PROCEDURE OUTPUT PARAMS
--Task – Create a stored procedure that returns the name and company of a customer.

--5.0 TRANSACTIONS 2

--6.0 TRIGGERS
--6.1 AFTER/FOR 3

--7.0 JOINS
--7.1 INNER
--Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.

--7.2 OUTER
--Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.

--7.3 RIGHT
--Task – Create a right join that joins album and artist specifying artist name and title.

--7.4 CROSS
--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.

--7.5 SELF
--Task – Perform a self-join on the employee table, joining on the reportsto column.

--7.5 SELF
