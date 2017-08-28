-- 2.1 SELECT
-- Task – Select all records from the Employee table.
select * from employee;
-- Task – Select all records from the Employee table where last name is King.
select * from employee where lastname = 'King';
-- Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
select * from employee where firstname = 'Andrew' and reportsto is null;

-- 2.2 ORDER BY
-- Task – Select all albums in Album table and sort result set in descending order by title.
select * from album order by title desc;
-- Task – Select first name from Customer and sort result set in ascending order by city
select firstname from customer order by city asc;

-- 2.3 INSERT INTO
-- Task – Insert two new records into Genre table
insert into genre (genreid, name) values (26, 'Techno');
insert into genre (genreid, name) values (27, 'Better Techno');
-- Task – Insert two new records into Employee table
insert into employee (employeeid, lastname, firstname, title, reportsto, birthdate, hiredate, address, city, state, country, postalcode, phone, fax, email)
values (9, 'Lory', 'Trevor', 'Software Developer', 1, '07-Feb-97', '08-AUG-17', '21611 Park Villa dr', 'Katy', 'TX', 'United States', '77450', '+1 (832) 243-2786', null, 'trevorlory@gmail.com');
insert into employee (employeeid, lastname, firstname, title, reportsto, birthdate, hiredate, address, city, state, country, postalcode, phone, fax, email)
values (10, 'NotLory', 'NotTrevor', 'Software Developer', 9, '07-Feb-97', '08-AUG-17', '21611 Not Park Villa dr', 'Not Katy', 'TX', 'Not United States', '77450', '+1 (832) 243-2786', null, 'nottrevorlory@gmail.com');
-- Task – Insert two new records into Customer table
insert into customer (customerid, firstname, lastname, company, address, city, state, country, postalcode, phone, fax, email, supportrepid)
values (60, 'Trevor', 'Lory', null, '21611 Park Villa dr', 'Katy', 'TX', 'United States', '77450', null, null, 'trevorlory@gmail.com', null);
insert into customer (customerid, firstname, lastname, company, address, city, state, country, postalcode, phone, fax, email, supportrepid)
values (61, 'NotTrevor', 'NotLory', null, '21611 Not Park Villa dr', 'Not Katy', 'TX', 'Not United States', '77450', null, null, 'nottrevorlory@gmail.com', null);

-- 2.4 UPDATE
-- Task – Update Aaron Mitchell in Customer table to Robert Walter
update customer
set firstname = 'Robert',
lastname = 'Walter' 
where firstname = 'Aaron' and lastname = 'Mitchell';
-- Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
update artist
set name = 'CCR'
where name = 'Creedence Clearwater Revival';

-- 2.5 LIKE
-- Task – Select all invoices with a billing address like “T%”
select * from invoice where billingaddress like 'T%';

-- 2.6 BETWEEN
-- Task – Select all invoices that have a total between 15 and 50
select * from invoice where total between 15 and 50;
-- Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
select * from employee where hiredate between '01-JUN-03' and '01-MAR-04';

-- 2.7 DELETE
-- Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
alter table invoice
drop constraint FK_INVOICECUSTOMERID;
/
alter table invoice
add constraint invoicecustomerid_fk
foreign key (customerid)
references customer (customerid)
on delete cascade;
/
delete from customer where firstname = 'Robert' and lastname = 'Walter';

-- 3.1 System Defined Functions
-- Task – Create a function that returns the current time.
/
CREATE OR REPLACE FUNCTION currentTime
RETURN TIMESTAMP
IS
BEGIN
  RETURN CURRENT_TIMESTAMP;
END;
/
-- Task – create a function that returns the length of a mediatype from the mediatype table
create or replace function mediaLength (idthing in number)
return number
is
  mediaid number;
begin
  select length(name) into mediaid from mediatype where mediatypeid = idthing;
  return mediaid;
end;
/

-- 3.2 System Defined Aggregate Functions
-- Task – Create a function that returns the average total of all invoices
create or replace function totalAvInv
return number
is
  totav number(10, 2);
begin
  select avg(total) into totav from invoice;
  return totav;
end;
/
-- Task – Create a function that returns the most expensive track
create or replace function expTrack
return number
is
  expT number(10, 2);
begin
  select max(unitprice) into expT from track;
  return expT;
end;
/

-- 3.3 User Defined Scalar Functions
-- Task – Create a function that returns the average price of invoiceline items in the invoiceline table
create or replace function avgInvLine
return number
is
  avin number(10, 2);
begin
  select avg(unitprice) into avin from invoiceline;
  return avin;
end;
/

-- 3.4 User Defined Table Value Functions
-- Task – Create a function that returns all employees who are born after 1968.
create or replace function bornaft
return sys_refcursor
is
  thing sys_refcursor;
begin
  open thing
    for select * from employee where birthdate >= '01-JAN-69';
  return thing;
end;
/

-- 4.1 Basic Stored Procedure
-- Task – Create a stored procedure that selects the first and last names of all the employees
create or replace procedure selfirlas
is
fn varchar2(100);
ln varchar2(100);
begin
  select firstname, lastname into fn, ln from employee;
end selfirlas;
/

-- 4.2 Stored Procedure Input Paramaters
-- Task – Create a stored procedure that updates the personal information of an employee.
create or replace procedure upemp (empid in number, bir in varchar2)
is
begin
  update employee
  set birthdate = bir
  where empid = EMPLOYEEID;
  commit;
end upemp;
-- Task – Create a stored procedure that returns the managers of an employee.
create or replace procedure manemp (empid in number, manid out number)
is
begin
  select reportsto into manid from employee where empid = employeeid;
end manemp;
/

-- 4.3 Stored Procedure Output Paramaters
-- Task – Create a stored procedure that returns the name and company of a customer
create or replace procedure namcom(cusid in number, fn out varchar2, ln out varchar2, com out varchar2)
is
begin
  select firstname, lastname, company into fn, ln, com from customer where cusid = customerid;
end namcom;
/

-- 5.0 Transactions
-- Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them)
alter table invoiceline
drop constraint FK_INVOICELINEINVOICEID;
/
alter table invoiceline
add constraint invoicelinecustomerid_fk
foreign key (invoiceid)
references invoice (invoiceid)
on delete cascade;
/
delete from invoice
where invoiceid = 1;
commit;
-- Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table
create or replace procedure nest
is
begin
  insert into customer (Customerid, firstname, lastname, email)
  values(62, 'nested', 'procedure', 'test');
  commit;
end nest;
/

-- 6.1 AFTER / FOR
-- Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
create or replace trigger new_insert
after insert on employee
for each row
begin
  update customer
  set firstname = 'del_trig'
  where firstname = 'NotTrevor';
end;
/
-- Task – Create an after update trigger on the album table that fires after a row is inserted in the table
create or replace trigger aft_row
after update on album
for each row
begin
  update customer
  set firstname = 'del_trig'
  where firstname = 'NotTrevor';
end;
/
-- Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
create or replace trigger del_trig
after delete on customer
begin
  update customer
  set firstname = 'del_trig'
  where firstname = 'NotTrevor';
end;
/

-- 7.1 INNER JOIN
-- Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
select customer.firstname, customer.lastname, invoice.invoiceid from invoice
inner join customer on customer.customerid = invoice.customerid;

-- 7.2 OUTER JOIN
-- Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
select customer.customerid, customer.firstname, customer.lastname, invoice.invoiceid, invoice.total from invoice
full outer join customer on customer.customerid = invoice.customerid;

-- 7.3 RIGHT JOIN
-- Task – Create a right join that joins album and artist specifying artist name and title
select artist.name, album.title from album
right join artist on album.artistid = artist.artistid;

-- 7.4 CROSS JOIN
-- Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
select * from album cross join artist order by artist.name asc;

-- 7.5 SELF JOIN
-- Task – Perform a self-join on the employee table, joining on the reportsto column.
select s.employeeid, s.lastname, s.firstname, s.title, q.firstname || ' ' || q.lastname as manager, s.birthdate, s.hiredate, s.address, s.city, s.state, s.country, s.postalcode, s.phone, s.fax, s.email from employee s, employee q
where s.reportsto = q.employeeid;










