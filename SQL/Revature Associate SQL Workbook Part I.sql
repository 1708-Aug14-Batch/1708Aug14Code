
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
INTO employee() VALUES()
INTO employee() VALUES()
SELECT * FROM dual;