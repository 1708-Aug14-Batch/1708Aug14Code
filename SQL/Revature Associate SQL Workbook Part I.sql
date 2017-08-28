
--2.1 SELECT
--Select all records
SELECT *
FROM employee;
--Select all records from the Employee table where last name is King
SELECT *
FROM employee
WHERE lastname = 'King';
--Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL
SELECT *
FROM employee
WHERE firstname = 'Andrew' AND reportsto IS NULL;

--2.2
--Select all albums in Album table and sort result set in descending order by title
SELECT *
FROM album
ORDER BY title DESC;
--Select first name from Customer and sort result set in ascending order by city
SELECT firstname
FROM customer
ORDER BY city ASC;

--2.3
--Insert two new records into Genre table
INSERT ALL
INTO genre(genreid, name) VALUES(DEFAULT, 'Doom Metal')
INTO genre(genreid, name) VALUES(DEFAULT, 'Black Metal')
SELECT * FROM dual;
--Insert two new records into Employee table
INSERT ALL
INTO employee(employeeid, lastname, firstname) VALUES(DEFAULT, 'Putnam', 'Seth')
INTO employee(employeeid, lastname, firstname) VALUES(DEFAULT, 'Knight', 'Moon')
SELECT * FROM dual;
--Insert two new records into Customer table
INSERT ALL
  INTO customer(customerid, firstname, lastname, email) VALUES(DEFAULT, 'Scott', 'Michael', 'mscott@mailinator.com')
  INTO customer(customerid, firstname, lastname, email) VALUES(DEFAULT, 'Schrute', 'Dwight', 'dschrute@mailinator.com')
SELECT * FROM dual;

--2.4
--Update Aaron Mitchell in Customer table to Robert Walter
UPDATE customer
SET firstname = 'Robert',
    lastname = 'Walter'
WHERE firstname = 'Aaron' AND lastname = 'Mitchell';
--Update name of artist in the Artist table "Creedence Clearwater Revival" to "CCR"
UPDATE artist
SET name = 'CCR'
WHERE name = 'Creedence Clearwater Revival';

--2.5
--Select all invoices with a billing address like "T%"
SELECT *
FROM invoice
WHERE billingaddress LIKE 'T%';

--2.6
--Select all onvoices that have a total between 15 and 50
SELECT *
FROM invoice
WHERE total > 15 AND total < 50;
--Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT *
FROM employee
WHERE hiredate > to_date('01-JUN-03','DD-MON-YY') AND hiredate < to_date('01-MAR-04','DD-MON-YY');

--2.7
--Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them)
DELETE FROM invoiceline
WHERE invoiceid = 245 OR invoiceid = 268 OR invoiceid = 290 OR invoiceid = 342 OR invoiceid = 50 OR invoiceid = 61 OR invoiceid = 116;
DELETE FROM invoice
WHERE customerid = 32;
DELETE FROM customer
WHERE firstname = 'Robert' AND lastname = 'Walter';

--3.1
--Create a function that returns the current time
CREATE OR REPLACE FUNCTION get_current_time
  RETURN
    TIMESTAMP
  AS
    current_time TIMESTAMP;
  BEGIN
    SELECT SYSTIMESTAMP FROM dual;
END get_current_time;
--create a function that returns the length of a mediatype from the mediatype table
CREATE OR REPLACE FUNCTION get_mediatype_length
  RETURN NUMBER
  AS
    length NUMBER;
  BEGIN
    SELECT LENGTH(name)
    FROM mediatype
    WHERE mediatypeid = 1;
END get_mediatype_length;