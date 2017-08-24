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
Task – Insert two new records into Genre table
Task – Insert two new records into Employee table
Task – Insert two new records into Customer table

-- 2.4 UPDATE
Task – Update Aaron Mitchell in Customer table to Robert Walter
Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”

-- 2.5 LIKE
Task – Select all invoices with a billing address like “T%”

-- 2.6 BETWEEN
Task – Select all invoices that have a total between 15 and 50
Task – Select all employees hired between 1st of June 2003 and 1st of March 2004

-- 2.7 DELETE
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
