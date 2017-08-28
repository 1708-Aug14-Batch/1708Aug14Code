
-- 2.1 SELECT --

-- Select all records from the Employee table.
SELECT * FROM EMPLOYEE;

-- Select all records from the Employee table
-- where last name is King.
SELECT * FROM EMPLOYEE
WHERE UPPER(LASTNAME) LIKE 'KING';

-- Select all records from the Employee table
-- where first name is Andrew and REPORTSTO is NULL.
SELECT * FROM EMPLOYEE
WHERE UPPER(FIRSTNAME) LIKE 'ANDREW'
  AND REPORTSTO IS NULL;


-- 2.2 ORDER BY --

-- Select all albums in Album table and sort
-- result set in descending order by title.
SELECT * FROM ALBUM
ORDER BY TITLE DESC;

-- Select first name from Customer and sort
-- result set in ascending order by city
SELECT FIRSTNAME FROM CUSTOMER
ORDER BY CITY;


-- 2.3 INSERT INTO --

-- Insert two new records into Genre table
INSERT INTO GENRE VALUES (26, 'Folk');
INSERT INTO GENRE VALUES (27, 'Hawaiian');

-- Insert two new records into Employee table
INSERT INTO EMPLOYEE (EMPLOYEEID, FIRSTNAME, LASTNAME, REPORTSTO)
VALUES (9, 'Nathan', 'Koszuta', NULL);
INSERT INTO EMPLOYEE (EMPLOYEEID, FIRSTNAME, LASTNAME, STATE)
VALUES (10, 'John', 'Doe', 9);

-- Insert two new records into Customer table
INSERT INTO CUSTOMER (CUSTOMERID, FIRSTNAME, LASTNAME, EMAIL)
VALUES (60, 'Aaron', 'Rodgers', 'rodgers@packers.com');
INSERT INTO CUSTOMER (CUSTOMERID, FIRSTNAME, LASTNAME, EMAIL)
VALUES (61, 'Ty', 'Montgomery', 'montgomery@packers.com');


-- 2.4 UPDATE --

-- Update Aaron Mitchell in Customer table to Robert Walter
UPDATE CUSTOMER
SET FIRSTNAME = 'Robert', LASTNAME = 'Walter'
WHERE FIRSTNAME = 'Aaron' AND LASTNAME = 'Mitchell';

-- Update name of artist in the Artist table
-- 'Creedence Clearwater Revival' to 'CCR'
UPDATE ARTIST
SET NAME = 'CCR'
WHERE NAME = 'Creedence Clearwater Revival';


-- 2.5 LIKE --

-- Select all invoices with a billing address like 'T%'
SELECT * FROM INVOICE
WHERE BILLINGADDRESS LIKE 'T%';


-- 2.6 BETWEEN --

-- Select all invoices that have a total between 15 and 50
SELECT * FROM INVOICE
WHERE TOTAL BETWEEN 15 AND 50;

-- Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT * FROM EMPLOYEE
WHERE HIREDATE BETWEEN
TO_DATE('06/01/2003', 'MM/DD/YYYY') AND TO_DATE('03/01/2004', 'MM/DD/YYYY');


-- 2.7 DELETE --

-- Delete a record in Customer table where the name
-- is Robert Walter (There may be constraints that
-- rely on this, find out how to resolve them).
ALTER TABLE INVOICE
DROP CONSTRAINT FK_INVOICECUSTOMERID;

ALTER TABLE INVOICE
ADD CONSTRAINT FK_INVOICECUSTOMERID
FOREIGN KEY(CUSTOMERID)
REFERENCES CUSTOMER(CUSTOMERID)
ON DELETE CASCADE;

ALTER TABLE INVOICELINE
DROP CONSTRAINT FK_INVOICELINEINVOICEID;

ALTER TABLE INVOICELINE
ADD CONSTRAINT FK_INVOICELINEINVOICEID
FOREIGN KEY(INVOICEID)
REFERENCES INVOICE(INVOICEID)
ON DELETE CASCADE;

DELETE FROM CUSTOMER
WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter';
