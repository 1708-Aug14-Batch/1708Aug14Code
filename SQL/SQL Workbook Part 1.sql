-- Connor Monson
-- 8/23/17

--FIXME remove below code
select cust.firstname CUSTNAME, emp.firstname EMPNAME
from employee emp
join customer cust on emp.state = cust.state;

-- average songs per album
select avg(total) from(select count(*) as total from track, album 
where track.albumid = album.albumid group by album.title);

-- find things from genre w ascii value
select name from genre
where ascii(substr(name, 1, 1)) = 72;

-- Number of songs per genre
select t2.name, count(*) from track t1, genre t2
where t.genreid = ts.genreid
group by t2.name;

-- Number of songs per playlist
select count(playlistid) as total, trackid
from playlisttrack group by trackid
order by total;

-- Number of songs per playlist
select t1.name, count(*) from playlist t1, playlisttrack
where t1.playlistid = playlisttrack.playlistid
group by t1.name;

alter table table_name add constraint column_name foreign key (column_name) references table_name2 (column_name) on delete cascade;
--FIXME remove above code

-- Section 2.0 SQL Querries 14

-- 2.1 SELECT
SELECT * FROM employee;
SELECT * FROM employee WHERE lastname = 'King';
SELECT * FROM employee WHERE firstname = 'Andrew' and REPORTSTO IS NULL;

-- 2.2 ORDER BY
SELECT * FROM albums ORDER BY title DEC;
SELECT firstname FROM customer ORDER BY city ASC;

-- 2.3 INSERT INTO
INSERT INTO genre(genreid, name) VALUES(26, 'Nightcore');
INSERT INTO genre(genreid, name) VALUES(27, 'Techno');

INSERT INTO employee (EmployeeId, LastName, FirstName, Title, BirthDate, HireDate, Address, City, State, Country, PostalCode, Phone, Fax, Email)
  VALUES (9, 'William', 'Scott', 'Superior Manager', TO_DATE('1989-8-04 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('2009-5-27 00:00:00','yyyy-mm-dd hh24:mi:ss'), '11120 Jasper Ave NW', 'Edmonton', 'AB', 'Canada', 'T5K 2N1', '+1 (780) 428-9482', '+1 (360) 123-4567', 'william@chinookcorp.com');
INSERT INTO employee (EmployeeId, LastName, FirstName, Title, BirthDate, HireDate, Address, City, State, Country, PostalCode, Phone, Fax, Email)
  VALUES (10, 'David', 'Smith', 'Superior Programmer', TO_DATE('1974-1-26 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('2013-4-06 00:00:00','yyyy-mm-dd hh24:mi:ss'), '11120 Jasper Ave NW', 'Edmonton', 'AB', 'Canada', 'T5K 2N1', '+1 (780) 428-9482', '+1 (801) 321-7654', 'david@chinookcorp.com');

INSERT INTO Customer (CustomerId, FirstName, LastName, Company, Address, City, State, Country, PostalCode, Phone, Fax, Email, SupportRepId)
  VALUES (60, 'Scott', 'Smith', 'Revature', 'Av. Brigadeiro Faria Lima, 2170', 'São José dos Campos', 'SP', 'Brazil', '12227-000', '+55 (12) 3923-5555', '+55 (12) 3923-5566', 'scott@mail.com', 3);
INSERT INTO Customer (CustomerId, FirstName, LastName, Company, Address, City, State, Country, PostalCode, Phone, Fax, Email, SupportRepId)
  VALUES (61, 'Matthew', 'Wheeler', 'Revature', 'Av. Brigadeiro Faria Lima, 2170', 'São José dos Campos', 'SP', 'Brazil', '12227-000', '+55 (12) 3923-5555', '+55 (12) 3923-5566', 'mathew@mail.com', 3);
SELECT * FROM customer;

-- 2.4 UPDATE
UPDATE customer SET firstname = 'Robert', lastname = 'Walter' WHERE firstname = 'Aaron' AND lastname = 'Mitchell';
UPDATE artist SET name = 'CCR' WHERE name = 'Creedence Clearwater Revival';

-- 2.5 LIKE
SELECT * FROM invoice WHERE billingaddress LIKE 'T%';

-- 2.6 BETWEEN
SELECT * FROM invoice WHERE total BETWEEN 15 AND 50;
SELECT * FROM employee WHERE hiredate BETWEEN TO_DATE('2003-6-01 00:00:00','yyyy-mm-dd hh24:mi:ss') AND TO_DATE('2004-3-01 00:00:00','yyyy-mm-dd hh24:mi:ss');

-- 2.7 DELETE
DELETE FROM customer WHERE firstname = 'Robert' AND lastname = 'Walter';
Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).


-- Section 3.0 SQL Functions 6

-- 3.1 System Defined Functions
Task – Create a function that returns the current time.
Task – create a function that returns the length of a mediatype from the mediatype table

-- 3.2 System Defined Aggregate Functions
Task – Create a function that returns the average total of all invoices
Task – Create a function that returns the most expensive track

-- 3.3 User Defined Scalar Functions
Task – Create a function that returns the average price of invoiceline items in the invoiceline table

-- 3.4 User Defined Table Valued Functions
Task – Create a function that returns all employees who are born after 1968.


-- Section 4.0 Stored Procedures 4

-- 4.1 Basic Stored Procedure
Task – Create a stored procedure that selects the first and last names of all the employees.

-- 4.2 Stored Procedure Input Parameters
Task – Create a stored procedure that updates the personal information of an employee.
Task – Create a stored procedure that returns the managers of an employee.

-- 4.3 Stored Procedure Output Parameters
Task – Create a stored procedure that returns the name and company of a customer.


-- Section 5.0 Transactions 2
Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table


-- Section 6.0 Triggers

-- 6.1 AFTER/FOR 3
Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
Task – Create an after update trigger on the album table that fires after a row is inserted in the table
Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.


-- Section 7.0 Joins 5

-- 7.1 INNER
Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.

-- 7.2 OUTER
Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.

-- 7.3 RIGHT
Task – Create a right join that joins album and artist specifying artist name and title.

-- 7.4 CROSS
Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.

-- 7.5 SELF
Task – Perform a self-join on the employee table, joining on the reportsto column.
