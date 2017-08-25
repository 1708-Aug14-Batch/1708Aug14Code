--Joshua Locklear Sql homework
--2.1 SELECT
--Task – Select all records from the Employee table
select * from EMPLOYEE;

--Task – Select all records from the Employee table where last name is King.
select * from EMPLOYEE where lastname = 'King';
--Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
select * from employee where firstname = 'Andrew' and REPORTSTO is null;
--2.2 ORDER BY
--Task – Select all albums in Album table and sort result set in descending order by title.
select * from ALBUM order by TITLE DESC;
--Task – Select first name from Customer and sort result set in ascending order by city
select firstname from CUSTOMER order by city asc;
--2.3 INSERT INTO
--Task – Insert two new records into Genre table
insert into GENRE
(GENREID,NAME)
values
(26,'Jack');
insert into GENRE
(GENREID,NAME)
values
(27,'Jill');
--Task – Insert two new records into Employee table
insert into EMPLOYEE(EMPLOYEEID,LASTNAME,firstname,title,reportsto, birthdate,
hiredate, address, city, state, country, postalcode, phone, fax, email) 
values
(9, 'Hill', 'Jill', 'Sales', 2, '18-JUN-1872', '18-JUN-2017', '1234 Hill lane', 'Hill', 'NC', 'Hill', '12345678','12345678', '12345678', '12345678');
insert into EMPLOYEE(EMPLOYEEID,LASTNAME,firstname,title,reportsto, birthdate,
hiredate, address, city, state, country, postalcode, phone, fax, email) 
values
(10, 'Hill', 'Jim', 'Sales', 2, '18-JUN-1872', '18-JUN-2017', '1234 Hill lane', 'Hill', 'NC', 'Hill', '12345678','12345678', '12345678', '12345678');
--Task – Insert two new records into Customer table
insert into customers VALUES ( 
      666999, 'Joe', 'Smith', myaddr, NULL, NULL, NULL, NULL, 
      NULL, NULL, NULL, NULL, NULL, NULL, NULL);
insert into customers VALUES ( 
      666910, 'Joe', 'Smith', myaddr, NULL, NULL, NULL, NULL, 
      NULL, NULL, NULL, NULL, NULL, NULL, NULL);
--2.4 UPDATE
--Task – Update Aaron Mitchell in Customer table to Robert Walter
UPDATE CUSTOMER
set FIRSTNAME = 'Robert', LASTNAME = 'Walter'
where FIRSTNAME = 'Aaron' and LASTNAME = 'Mitchell';
--Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
UPDATE artist
set NAME = 'CCR'
where NAME = 'Creedence Clearwater Revival';
--2.5 LIKE
--Task – Select all invoices with a billing address like “T%”
SELECT * FROM INVOICE
where BILLINGADDRESS like 'T%';
--2.6 BETWEEN
--Task – Select all invoices that have a total between 15 and 50
SELECT * FROM INVOICE
where total between 15 and 50;
--Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
select * from EMPLOYEE
where HIREDATE between '1-JUN-2003' and '1-MAR-2004';
--2.7 DELETE
--Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
ALTER table customer
add constraint fk_empid_hiredate
   FOREIGN KEY (employee_id, hire_date)
   REFERENCES hr.job_history(employee_id, start_date)on delete cascade
   EXCEPTIONS INTO wrong_emp;
--3.1 System Defined Functions
--Task – Create a function that returns the current time.
--Task – create a function that returns the length of a mediatype from the mediatype table
--3.2 System Defined Aggregate Functions
--Task – Create a function that returns the average total of all invoices
--Task – Create a function that returns the most expensive track
--3.3 User Defined Scalar Functions
--Task – Create a function that returns the average price of invoiceline items in the invoiceline table
--3.4 User Defined Table Valued Functions
--Task – Create a function that returns all employees who are born after 1968.
--4.0 Stored Procedures 4
--4.1 Basic Stored Procedure
--Task – Create a stored procedure that selects the first and last names of all the employees.
create or replace PROCEDURE fnlnSelector(fn out varchar2, ln out varchar2)
as begin
select firstname, lastname from EMPLOYEE;
end;
--4.2 Stored Procedure Input Parameters
--Task – Create a stored procedure that updates the personal information of an employee.
create or replace procedure empUpdate(fn in varchar,ln in varchar, emid in number)
as begin
UPDATE EMPLOYEE 
set firstname = fn, lastname = ln
where EMPLOYEEID = emid;
commit;
end;
/
--Task – Create a stored procedure that returns the managers of an employee.

--4.3 Stored Procedure Output Parameters
--Task – Create a stored procedure that returns the name and company of a customer.


