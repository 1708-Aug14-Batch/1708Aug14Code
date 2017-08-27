
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
