-- ANDY ZHENG SQL HOMEWORK


--2.0 SQL Queries 14
--In this section you will be performing various queries against the Oracle Chinook database.
--2.1 SELECT
--Task  Select all records from the Employee table.
SELECT * FROM EMPLOYEE;

--Task  Select all records from the Employee table where last name is King.
SELECT * FROM EMPLOYEE WHERE LASTNAME = 'King';

--Task  Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT * FROM EMPLOYEE WHERE FIRSTNAME = 'Andrew' AND REPORTSTO IS NULL;

--2.2 ORDER BY
--Task  Select all albums in Album table and sort result set in descending order by title.
SELECT * FROM ALBUM ORDER BY TITLE DESC;

--Task  Select first name from Customer and sort result set in ascending order by city
SELECT FIRSTNAME FROM CUSTOMER ORDER BY CITY ASC;


--2.3 INSERT INTO
--Task  Insert two new records into Genre table
INSERT INTO GENRE
VALUES(26,'Potatoe');
INSERT INTO GENRE
VALUES(27, 'tacos');

--Task  Insert two new records into Employee table
INSERT INTO EMPLOYEE
VALUES(9,'Jackson','Bob','Taco Maker',3,'20-DEC-03','14-AUG-04','321 Taco Drive W','New York','NY','USA','10004','321-323-4232','323-421-3214','taco@taco.com');
INSERT INTO EMPLOYEE
VALUES(10,'Makerson','Jack','Taco Maker',4,'24-JAN-03','10-AUG-04','3211 Taco Drive W','New York','NY','USA','10034','321-323-4242','323-421-3244','taco@taco1.com');

--Task  Insert two new records into Customer table
INSERT INTO CUSTOMER
VALUES(60,'Patrick','Ham','Kitchen','321 Chicken Rd','New Jersey','NJ','USA','10124','321-431-4213','323-432-3214','kitchen@taco.com',9);
INSERT INTO CUSTOMER
VALUES(61,'Tin','Bacon','Kitchen','32134 Taco Rd','New Jersey','NJ','USA','10304','897-321-5218','562-213-6541','birds1@taco.com',10);

--2.4 UPDATE
--Task  Update Aaron Mitchell in Customer table to Robert Walter
UPDATE CUSTOMER SET FIRSTNAME = 'Robert', LASTNAME = 'Walter' WHERE FIRSTNAME = 'Aaron' AND LASTNAME = 'Mitchell'; 

--Task  Update name of artist in the Artist table Creedence Clearwater Revival to CCR
UPDATE ARTIST SET NAME = 'CCR' WHERE NAME = 'Creedence Clearwater Revival';

--2.5 LIKE
--Task  Select all invoices with a billing address like T%
SELECT * FROM INVOICE WHERE BILLINGADDRESS LIKE 'T%';

--2.6 BETWEEN
--Task  Select all invoices that have a total between 15 and 50
SELECT * FROM INVOICE WHERE TOTAL BETWEEN 15 AND 50;

--Task  Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT * FROM EMPLOYEE WHERE HIREDATE BETWEEN '01-JUN-03' AND '01-MAR-04';

--2.7 DELETE
--Task  Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).


--	SQL Functions 6
--In this section you will be using the Oracle system functions, as well as your own functions, to perform various actions against the database


--3.1 System Defined Functions
--Task  Create a function that returns the current time.


--Task  create a function that returns the length of a mediatype from the mediatype table


--3.2 System Defined Aggregate Functions
--Task  Create a function that returns the average total of all invoices


--Task  Create a function that returns the most expensive track


--3.3 User Defined Scalar Functions
--Task  Create a function that returns the average price of invoiceline items in the invoiceline table


--3.4 User Defined Table Valued Functions
--Task  Create a function that returns all employees who are born after 1968.


--4.0 Stored Procedures 4
--In this section you will be creating and executing stored procedures. You will be creating various types of stored procedures that take input and output parameters.


--4.1 Basic Stored Procedure
--Task  Create a stored procedure that selects the first and last names of all the employees.


--4.2 Stored Procedure Input Parameters
--Task  Create a stored procedure that updates the personal information of an employee.


--Task  Create a stored procedure that returns the managers of an employee.


--4.3 Stored Procedure Output Parameters
--Task  Create a stored procedure that returns the name and company of a customer.



--5.0 Transactions 2
--In this section you will be working with transactions. Transactions are usually nested within a stored procedure.

--Task  Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).


--Task  Create a transaction nested within a stored procedure that inserts a new record in the Customer table



--6.0 Triggers
--In this section you will create various kinds of triggers that work when certain DML statements are executed on a table.

--6.1 AFTER/FOR 3
--Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
--CREATE TRIGGER TRIGGERONE

--Task  Create an after update trigger on the album table that fires after a row is inserted in the table


--Task  Create an after delete trigger on the customer table that fires after a row is deleted from the table.


--7.0 JOINS 5
--In this section you will be working with combing various tables through the use of joins. You will work with outer, inner, right, left, cross, and self joins.

--7.1 INNER
--Task  Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
SELECT CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME, INVOICE.INVOICEID
FROM CUSTOMER INNER JOIN INVOICE ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;
--7.2 OUTER
--Task  Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT CUSTOMER.CUSTOMERID, CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME, INVOICE.INVOICEID, INVOICE.TOTAL
FROM CUSTOMER FULL OUTER JOIN INVOICE ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;
--7.3 RIGHT
--Task  Create a right join that joins album and artist specifying artist name and title.
SELECT ARTIST.NAME, ALBUM.TITLE
FROM ARTIST RIGHT JOIN ALBUM ON ARTIST.ARTISTID = ALBUM.ARTISTID;
--7.4 CROSS
--Task  Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT ARTIST.NAME
FROM ALBUM
CROSS JOIN ARTIST
ORDER BY ARTIST.NAME ASC;
--7.5 SELF
--Task  Perform a self-join on the employee table, joining on the reportsto column.

