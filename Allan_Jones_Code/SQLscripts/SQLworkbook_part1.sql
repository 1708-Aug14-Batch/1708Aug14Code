-- 2.1
-- Task – Select all records from the Employee table.
select * from employee;

-- Task – Select all records from the Employee table where last name is King.
select * from employee
where lastname = 'King';

-- Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
select * from employee
where firstname = 'Andrew'
and reportsto is null;

-- 2.2
-- Task – Select all albums in Album table and sort result set in descending order by title.
select * from album
order by title desc;

-- Task – Select first name from Customer and sort result set in ascending order by city
select firstname from customer 
order by city asc;

-- 2.3
-- Task – Insert two new records into Genre table
insert into genre
values
(26, 'Country'); 

-- Task – Insert two new records into Employee table
insert into employee
values (9, 'Doe', 'John', 'Sales Support Agent', 2, '13-AUG-66', '03-MAY-03', 
        '1111 6 Ave SW', 'Calgary', 'AB', 'Canada', 'T2P 5M5', '+1 (403) 262-3443',
        '+1 (403) 262-6712', 'john@chinookcorp.com');
        
insert into employee
values (10, 'James', 'Jesse', 'Sales Support Agent', 2, '13-AUG-66', '03-MAY-03', 
        '1111 6 Ave SW', 'Calgary', 'AB', 'Canada', 'T2P 5M5', '+1 (403) 262-3443',
        '+1 (403) 262-6712', 'jesse@chinookcorp.com');        

commit;
-- Task – Insert two new records into Customer table
insert into customer
(customerid, firstname, lastname, email)
values (60, 'Martha', 'Washington', 'martha.washington@gmail.com');

insert into customer
(customerid, firstname, lastname, email)
values (61, 'George', 'Washington', 'george.washington@gmail.com');

commit;

-- 2.4
-- Task – Update Aaron Mitchell in Customer table to Robert Walter
update customer
set firstname = 'Robert', lastname = 'Walter'
where firstname = 'Aaron'
and lastname = 'Mitchell';

commit;

-- Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
update artist
set name = 'CCR'
where name = 'Creedence Clearwater Revival';

commit;

--2.5 LIKE
--Task – Select all invoices with a billing address like “T%”
select * from invoice
where BILLINGADDRESS like 'T%';

--2.6 BETWEEN
--Task – Select all invoices that have a total between 15 and 50
Select * from invoice
where total between 15 and 50;

--Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
select * from employee
where hiredate between to_date('01-JUN-03', 'DD-MON-YY') and to_date('01-MAR-04', 'DD-MON-YY');

--2.7 DELETE
--Task – Delete a record in Customer table where the name is Robert Walter 
--      (There may be constraints that rely on this, find out how to resolve them).
delete from INVOICELINE
where invoiceid in (Select t2.invoiceid from customer t1, invoice t2
                    where t1.customerid = t2.customerid
                    and t1.firstname = 'Robert'
                    and t1.lastname = 'Walter');

delete from invoice
where customerid in (select t1.customerid from customer t1, invoice t2
                    where t1.customerid = t2.customerid
                    and t1.firstname = 'Robert'
                    and t1.lastname = 'Walter');

delete from Customer
where firstname = 'Robert'
and lastname = 'Walter';

commit;

--3.1 System Defined Functions
-- Task – Create a function that returns the current time.
create or replace function currentTime return VARCHAR2 is
  vTime varchar2(10);
begin
  select to_char(sysdate, 'hh24:mi') into vTime from dual;
  return vTime;
end;
/

select currentTime from dual;

-- Task – create a function that returns the length of a mediatype from the mediatype table
create or replace function medialength(id in number) return number is
  vlen number;
begin
  select length(name) into vlen from mediatype where mediatypeid = id;
  return vlen;
end;
/

select medialength(1) from dual;

-- 3.2 System Defined Aggregate Functions
-- Task – Create a function that returns the average total of all invoices
create or replace function avginvoice return number is
  vavg number(10,2);
begin
  select avg(total) into vavg from invoice;
  return vavg;
end;
/

select avginvoice from dual;

-- Task – Create a function that returns the most expensive track
create or replace function mostexptrack return varchar2 is
  vtrack varchar2(200);
begin
  select name into vtrack from track
  where unitprice = (select max(unitprice) from track)
  and rownum = 1;
  return vtrack;
end;
/

select mostexptrack from dual;

-- 3.3 User Defined Scalar Functions
-- Task – Create a function that returns the average price of invoiceline items in the invoiceline table
create or replace function avgunitprice return number is
  vprice number(10,2);
begin
  select avg(unitprice) into vprice from invoiceline;
  return vprice;
end;
/

select avgunitprice from dual;

-- 3.4 User Defined Table Valued Functions
-- Task – Create a function that returns all employees who are born after 1968.
CREATE OR REPLACE FUNCTION empafter68 RETURN SYS_REFCURSOR IS
  l_rc SYS_REFCURSOR;
BEGIN
  OPEN l_rc
   FOR select firstname || ' ' || lastname as "Employee" from employee
       where birthdate > to_date('1968', 'YYYY');
  RETURN l_rc;
END;
/

select empafter68 from dual;

-- 4.1 Basic Stored Procedure
-- Task – Create a stored procedure that selects the first and last names of all the employees.
create procedure getemployees(prc out sys_refcursor) is
begin
  open prc for 
  select firstname, lastname from employee;
end;
/

var rc refcursor
execute getemployees(:rc);
print rc;

-- 4.2 Stored Procedure Input Parameters
-- Task – Create a stored procedure that updates the personal information of an employee.
create or replace procedure updateEmp(fn in varchar2, ln in varchar2, vbday in date, vphone in varchar2, vemail in varchar2) is
begin
  update employee
  set birthdate = vbday, phone = vphone, email = vemail
  where firstname = fn and lastname = ln;
end;
/

execute updateEmp('John', 'Doe', to_date('14-AUG-66', 'DD-MON-YY'), '+1 (403) 262-3553', 'jdoe@comcast.net');

-- Task – Create a stored procedure that returns the managers of an employee.
create or replace procedure empmgr(fn in varchar2, ln in varchar2, mgr out varchar2) is
begin
  select firstname || ' ' || lastname as Manager into mgr from employee
  where employeeid = (select reportsto from employee
                      where firstname = fn and lastname = ln);
end;
/

var vmgr varchar2
execute empmgr('Jesse', 'James', :vmgr);
print vmgr;

-- 4.3 Stored Procedure Output Parameters
-- Task – Create a stored procedure that returns the name and company of a customer.
create or replace procedure custcompany(custid in number, name out varchar2, comp out varchar2) is
begin
  select firstname || ' ' || lastname as cust, company into name, comp from customer
  where customerid = custid;
end;
/

var vname varchar2
var vcompany varchar2
execute custcompany(1, :vname, :vcompany);
print vname;
print vcompany;

-- 5.0
-- Task – Create a transaction that given a invoiceId will delete that invoice 
-- (There may be constraints that rely on this, find out how to resolve them).
create or replace procedure delinvoice(id in number) is
begin
set transaction name 'del_invoice';
  delete from invoiceline where invoiceid = id;
  delete from invoice where invoiceid = id;
--rollback;
end;
/

execute delinvoice(1);
rollback;

-- Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table
create or replace procedure newCust(id in number, fn in varchar2, ln in varchar2, email in varchar2) is
begin
  set transaction name 'insertCust';
    insert into customer
    (customerid, firstname, lastname, email)
    values
    (id, fn, ln, email);
  savepoint after_cust_insert;
  commit;
end;
/

execute newcust(62, 'Allan', 'Jones', 'allan.jones@gmail.com');

-- 6.1 AFTER/FOR 3
-- Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
create or replace TRIGGER EmployeeBday_TRIGGER
AFTER INSERT ON EMPLOYEE
FOR EACH ROW
BEGIN
   IF ADD_MONTHS (:new.hiredate, -1*18*12) < :new.birthdate
   THEN
      dbms_output.put_line('Employees must be at least 18 years old');
      dbms_output.put_line('Rollback insert or delete record');
   END IF;
END;
/

set SERVEROUTPUT ON

insert into employee
(employeeid, firstname, lastname, birthdate, hiredate)
values
(11, 'Allan', 'Jones', to_date('11-NOV-2009', 'DD-MON-YYYY'), sysdate -1);

rollback;

-- Task – Create an after update trigger on the album table that fires after a row is inserted in the table
create or replace trigger updateAlbum_TRIGGER
AFTER UPDATE ON ALBUM
FOR EACH ROW
BEGIN
  dbms_output.put_line('Note: you have made a change to the ALBUM table');
END;
/

set serveroutput on

update album
set title = 'War (what it is good for)'
where albumid = 239;

rollback;

-- Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
create or replace TRIGGER deleteCustomer_TRIGGER
AFTER DELETE ON customer
FOR EACH ROW
BEGIN
  dbms_output.put_line('Note: if this failed, first delete related records in invoiceline and invoice tables first');
END;
/ 

set SERVEROUTPUT ON

delete from customer where customerid = 1;

-- 7.1 INNER
-- Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
select firstname || ' ' || lastname as name, invoiceid
from customer t1
inner join invoice t2 on t1.customerid = t2.customerid
order by 1, 2;

-- 7.2 OUTER
-- Task – Create an outer join that joins the customer and invoice table,  
--        specifying the CustomerId, firstname, lastname, invoiceId, and total.
select cust.customerid, firstname, lastname, invoiceid, total
from customer cust
full outer join invoice inv on cust.customerid = inv.customerid
order by 1, 4;

-- 7.3 RIGHT
-- Task – Create a right join that joins album and artist specifying artist name and title.
select title, name
from album
right join artist on album.artistid = artist.artistid;

-- 7.4 CROSS
-- Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
select name, title
from album
cross join artist
order by name asc;

-- 7.5 SELF
-- Task – Perform a self-join on the employee table, joining on the reportsto column.
select * from employee t1, employee t2
where t1.employeeid = t2.reportsto;

