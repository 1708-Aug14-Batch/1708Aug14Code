--Revature Associate SQL Workbook
--
--Oracle 11g
--
--Working with Relational Database Management Systems

--2.1 SELECT
--Task – Select all records from the Employee table.
SELECT * FROM EMPLOYEE;

--Task – Select all records from the Employee table where last name is King.
SELECT * FROM EMPLOYEE WHERE upper (LASTNAME) = upper ('KING');

--Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT *
FROM EMPLOYEE
WHERE upper (FIRSTNAME) = upper('Andrew')AND reportsto IS NULL;

--2.2 ORDER BY
--Task – Select all albums in Album table and sort result set in descending order by title.
SELECT * FROM album 
ORDER BY TITLE DESC;

--Task – Select first name from Customer and sort result set in ascending order by city
SELECT FIRSTNAME, CITY FROM CUSTOMER 
ORDER BY CITY ASC;

--2.3 INSERT INTO
--Task – Insert two new records into Genre table
INSERT INTO GENRE(GENREID, NAME)
VALUES(26, 'Anime');
INSERT INTO GENRE(GENREID, NAME)
VALUES(27, 'Horror');

--Task – Insert two new records into Employee table
INSERT INTO EMPLOYEE(EMPLOYEEID, LASTNAME, FIRSTNAME, TITLE)--REPORTSTO, BIRTHDAY,HIREDATE, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX,EMAIL)
with name as (
select 9, 'SANCHEZ', 'RICK', 'MANAGER' from dual union all
select 10, 'Smith', 'Morty', 'Staff' from dual
)
select * from name;-- NULL, DATE '23-JUL-1985', '23-JUL-2014'), '11730 PLAZA AMERICA DR', 'CLAGARY', 'AB', 'CANADA', '1H2 4G5', '+1 (675) 456-3755', '+1 (867) 343-6573', 'rick@email.com');

--Task – Insert two new records into Customer table
INSERT INTO CUSTOMER(CUSTOMERID, FIRSTNAME, LASTNAME, EMAIL)
WITH name AS (
SELECT 60, 'SUMMER', 'SMITH', 'summer@email.com' FROM dual
UNION ALL
SELECT 61, 'Jerry', 'SMITH', 'jerry.jones@email.com'  from dual
)
SELECT * FROM name;

--2.4 UPDATE
--Task – Update Aaron Mitchell in Customer table to Robert Walter
UPDATE CUSTOMER
SET FIRSTNAME = 'Robert', LASTNAME = 'Walter'
WHERE FIRSTNAME = 'Aaron' and LASTNAME = 'Mitchell';

--Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
UPDATE ARTIST
SET NAME = 'CCR'
WHERE upper (NAME) = upper ('Creedence Clearwater Revival');

--2.5 LIKE
--Task – Select all invoices with a billing address like “T%”
SELECT * FROM INVOICE
WHERE upper (BILLINGADDRESS) LIKE 'T%';

--2.6 BETWEEN
--Task – Select all invoices that have a total between 15 and 50
SELECT * FROM INVOICE
WHERE TOTAL BETWEEN 15 AND 50;

--Task – Select all employees hired between 1 st of June 2003 and 1 st of March 2004
SELECT * FROM EMPLOYEE
WHERE HIREDATE BETWEEN '1-JUN-2003' AND '1-MAR-2004';

--2.7 DELETE
--Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints
--that rely on this, find out how to resolve them).

ALTER TABLE invoiceline
DROP CONSTRAINT FK_invoicelineinvoiceid;

ALTER TABLE invoiceline 
ADD CONSTRAINT FK_invoicelineinvoiceid 
FOREIGN KEY (invoiceid) REFERENCES invoice (invoiceid) 
ON DELETE CASCADE;

ALTER TABLE invoice
DROP CONSTRAINT FK_invoicecustomerid;
ALTER TABLE invoice 
ADD CONSTRAINT FK_invoicecustomerid 
FOREIGN KEY (customerid) REFERENCES customer (customerid) 
ON DELETE CASCADE;

ALTER TABLE Customer
DROP CONSTRAINT FK_CUStomerSupportrepId;

ALTER TABLE Customer 
ADD CONSTRAINT FK_customersupportrepid 
FOREIGN KEY (supportrepid) REFERENCES employee (employeeid) 
ON DELETE CASCADE;


DELETE FROM customer
WHERE lower(FIRSTNAME) = lower('robert')
AND lower (lastname)   = lower('walter');
--selec
----
--3.0SQL Functions 6
--In this section you will be using the Oracle system functions, as well as your own functions, to perform
--various actions against the database
--3.1 System Defined Functions
--Task – Create a function that returns the current time.
select sysdate
from dual;
--Task – create a function that returns the length of a mediatype from the mediatype table

--3.2 System Defined Aggregate Functions
--Task – Create a function that returns the average total of all invoices
CREATE OR REPLACE FUNCTION averageInvoice 
RETURN number
is average number(10,2);
BEGIN
  select avg(total) into average from invoice;
  return average;
END;
 select AVERAGEINVOICE from invoice;
--Task – Create a function that returns the most expensive track

--3.3 User Defined Scalar Functions
--Task – Create a function that returns the average price of invoiceline items in the invoiceline table



--3.4 User Defined Table Valued Functions
--Task – Create a function that returns all employees who are born after 1968.
create or replace function getEmployeeBornAfter
       Return firstname
       is employees Employee;
       begin
            SELECT Employee Into employees  from Employee where birthdate >= date '1968-01-01';
        return employees;
        end;

--4.0 Stored Procedures 4
--In this section you will be creating and executing stored procedures. You will be creating various types
--of stored procedures that take input and output parameters.
--4.1 Basic Stored Procedure
--Task – Create a stored procedure that selects the first and last names of all the employees.
--4.2 Stored Procedure Input Parameters
--Task – Create a stored procedure that updates the personal information of an employee.
--Task – Create a stored procedure that returns the managers of an employee.
--4.3 Stored Procedure Output Parameters
--Task – Create a stored procedure that returns the name and company of a customer.
--5.0 Transactions 2
--In this section you will be working with transactions. Transactions are usually nested within a stored
--procedure.
--Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that
--rely on this, find out how to resolve them).
--Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer
--table
--6.0 Triggers
--In this section you will create various kinds of triggers that work when certain DML statements are
--executed on a table.
--6.1 AFTER/FOR 3
--Task - Create an after insert trigger on the employee table fired after a new record is inserted into the
--table.
-- the after trigger below creates a copy of the inserted data and store it in the example table 
CREATE OR REPLACE TRIGGER afterInsertTrigger 
AFTER INSERT ON EMPLOYEE FOR EACH row BEGIN
  INSERT INTO example (firstname, lastname)
    VALUES(:new.firstname, :new.lastname);
END;
--Task – Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE OR REPLACE TRIGGER afterUpdateAlbumTrigger AFTER
  UPDATE ON album FOR EACH row BEGIN
  INSERT INTO album
    (TITLE, ARTISTID) VALUES
    (:new.title, :old.title);
END;

--Task – Create an after delete trigger on the customer table that fires after a row is deleted from the
--table.
CREATE OR REPLACE TRIGGER afterUpdateAlbumTrigger
  AFTER DELETE ON customer
  for each row
BEGIN
  insert into changed_album (column1,column2)
  values (:new.title, :old.title);
END;
--7.0 JOINS 5
--In this section you will be working with combing various tables through the use of joins. You will work
--with outer, inner, right, left, cross, and self joins.
--7.1 INNER
--Task – Create an inner join that joins customers and orders and specifies the name of the customer and
--the invoiceId.
SELECT c.firstname, c.lastname, i.invoiceid
FROM customer c
INNER JOIN invoice i
ON i.customerId = c.customerid;

--7.2 OUTER
--Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId,
--firstname, lastname, invoiceId, and total.
SELECT c.customerid, c.firstname, c.lastname, i.invoiceid, i.total
FROM customer c
JOIN invoice i ON i.customerid = c.customerid;

--7.3 RIGHT
--Task – Create a right join that joins album and artist specifying artist name and title.
SELECT ar.name, al.title
FROM album al
RIGHT JOIN artist ar ON ar.artistid = al.artistid;

--7.4 CROSS
--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT * FROM album
CROSS JOIN artist 
ORDER BY name ASC;

--7.5 SELF
--Task – Perform a self-join on the employee table, joining on the reportsto column.
SELECT * FROM employee e1, employee e2 
WHERE e1.reportsto = e2.employeeid;
