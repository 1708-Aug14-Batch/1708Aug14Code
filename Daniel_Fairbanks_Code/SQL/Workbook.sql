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
--Task – Create a function that returns the current time.
SELECT CURRENT_TIMESTAMP FROM dual;
CREATE OR REPLACE FUNCTION getTime
RETURN TIMESTAMP
IS
curTime TIMESTAMP;
BEGIN
SELECT CURRENT_TIMESTAMP INTO curTime FROM dual;
RETURN curTime;
END;
/

--Task – create a function that returns the length of a mediatype from the mediatype table
CREATE OR REPLACE FUNCTION mediatypeLength
RETURN NUMBER
IS
len NUMBER;
BEGIN
SELECT length(Name) INTO len FROM MediaType WHERE MediaTypeID = 4;
RETURN len;
END;
/

--3.2 SYSTEM DEFINED AGGREGATE FUNCS
--Task – Create a function that returns the average total of all invoices
CREATE OR REPLACE FUNCTION getAvgTotal
RETURN NUMBER
IS
avgTotal NUMBER;
BEGIN
SELECT Avg(Total) INTO avgTotal FROM Invoice;
RETURN avgTotal;
END;
/
--Task – Create a function that returns the most expensive track
CREATE OR REPLACE FUNCTION getMostExpensiveTrack
RETURN NUMBER
IS
price NUMBER;
BEGIN
SELECT max(UnitPrice) INTO price FROM Track;
RETURN price;
END;
/
--3.3 USER DEFINED SCALAR FUNCS
--Task – Create a function that returns the average price of invoiceline items in the invoiceline table
CREATE OR REPLACE FUNCTION getAvgPriceInvoiceItems
RETURN NUMBER
IS
avgPrice NUMBER;
BEGIN
SELECT avg(UnitPrice) INTO avgPrice FROM InvoiceLine;
RETURN avgPrice;
END;
/
--3.4 USER DEFINED TABLE VALUED FUNCS
--Task – Create a function that returns all employees who are born after 1968.

--4.0 STORED PROCEDURES
--4.1 BASIC STORED PROCEDURE
--Task – Create a stored procedure that selects the first and last names of all the employees.

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

--Task – Create a stored procedure that returns the managers of an employee.

--4.3 STORED PROCEDURE OUTPUT PARAMS
--Task – Create a stored procedure that returns the name and company of a customer.
CREATE OR REPLACE PROCEDURE getNameAndCompany
(
cusID IN NUMBER,
fn OUT VARCHAR2,
ln OUT VARCHAR2,
cmpny OUT VARCHAR2
)
AS BEGIN
SELECT Firstname, Lastname, Company INTO fn, ln, cmpny FROM Customer WHERE CustomerID = cusID;
END getNameAndCompany;
/
--5.0 TRANSACTIONS 2
--Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
--Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table

--6.0 TRIGGERS
--6.1 AFTER/FOR 3
--Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
--Task – Create an after update trigger on the album table that fires after a row is inserted in the table
--Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.

--7.0 JOINS
--7.1 INNER
--Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
SELECT c.Firstname, c.Lastname, i.InvoiceID FROM
Customer c
INNER JOIN Invoice i ON c.CustomerID = i.CustomerID;
--7.2 OUTER
--Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT c.CustomerID, c.Firstname, c.Lastname, i.InvoiceID, i.Total FROM
Customer c
FULL OUTER JOIN Invoice i ON c.CustomerID = i.CustomerID;
--7.3 RIGHT
--Task – Create a right join that joins album and artist specifying artist name and title.
SELECT Artist.Name, Album.Title FROM
Album
RIGHT JOIN Artist ON Album.ArtistID = Artist.ArtistID;
--7.4 CROSS
--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT * FROM Album CROSS JOIN Artist
ORDER BY Artist.Name ASC;
--7.5 SELF
--Task – Perform a self-join on the employee table, joining on the reportsto column.
SELECT a.ReportsTo, b.ReportsTo FROM Employee a, Employee b; 
