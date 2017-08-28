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
create or replace function Time return VARCHAR2 is
  Time varchar2(10);
begin
  select to_char(sysdate, 'hh24:mi') into Time from dual;
  return Time;
end;
/
--Task – create a function that returns the length of a mediatype from the mediatype table
create or replace function media(id in number) return number is
  len number;
begin
  select length(name) into len from mediatype where mediatypeid = id;
  return vlen;
end;
/
--3.2 System Defined Aggregate Functions
--Task – Create a function that returns the average total of all invoices
create or replace function average return number is average number;
begin
select avg(total) into avg from invoice;
return average;
end;
/
--Task – Create a function that returns the most expensive track
--3.3 User Defined Scalar Functions
create or replace function expens return is varchar2 tracks varchar(100);
begin
select name into tracks from track where unitprice = select max(unitprice) from track
and rownum = 1;
return tracks;
end;
/
--Task – Create a function that returns the average price of invoiceline items in the invoiceline table
--3.4 User Defined Table Valued Functions
--Task – Create a function that returns all employees who are born after 1968.
select * from employees
where birthdate > date '68-01-01'
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
create or replace procedure returnmanagers(fn in varchar2(50), ln in varchar2(50),mgr out varchar(100))
is
begin
select firstname, lastname as Manager into mgr from employee
where employeeid = (select reportsto from employee where first name = fn and lastname = ln);
end;
/
--4.3 Stored Procedure Output Parameters
--Task – Create a stored procedure that returns the name and company of a customer.
create or replace procedure Company(cust_id in number, name out varchar2, comp out varchar2)is
begin
select firstname, lastname as cust, company into name, comp from customer
where customerid = custid_id;
end;
/
--5.0 Transactions 2
--Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table
create or replace procedure delinvoice(id in number)is
begin
set transaction name 'Delete2';
delete from invoiceline where invoiceid = id;
delete from invoice where in invoiceid = id;
end;
/
--Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table
create or replace procedure newCustomer(id in number, fn in varchar2, ln in varchar2, email in varchar2) is
begin
set transaction name 'newCustomer'
insert into customer
(customerid, firstname, lastname, email)
values
(id,fn,ln,email)
savepoint after_customer_insert
commit;
end;
/
--6.1 AFTER/FOR 3
--Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
create or replace Trigger 
--Task – Create an after update trigger on the album table that fires after a row is inserted in the table
create or replace trigger updateAlbum_TRIGGER
AFTER UPDATE ON ALBUM
FOR EACH ROW
BEGIN
  dbms_output.put_line('change to the ALBUM table');
END;
/
--Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table
-- 7.1 INNER
-- Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
select firstname as fn, lastname as ln, invoiceid
from customer cust
inner join invoice inv on cust.customerid = inv.customerid
order by 1,2;
--7.2 outer
-- Task – Create an outer join that joins the customer and invoice table,  
--        specifying the CustomerId, firstname, lastname, invoiceId, and total.
select cust.customerid, firstname, lastname, invoiceid, total
from customer cust
full outer join invoice inv on cust.customerid = inv.customerid
order by 1,4;
--7.3 Right
--Task – Create a right join that joins album and artist specifying artist name and title.
select title, name
from album
right join artist on album.artistid = artist.artistid;
--cross
--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
select name, title
from album
cross join artist
order by name asc;
--self
--Task – Perform a self-join on the employee table, joining on the reportsto column.
select * from employee t1, employee t2
where t1.employeeid = t2.reportsto;
