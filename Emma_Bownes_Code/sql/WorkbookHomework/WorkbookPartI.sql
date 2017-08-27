-- Emma Bownes, August 23, 2017 
-- Part I
-- 2.0 SQL Queries 14 - performing queries

-- 2.1 Select

-- Select all records from the Employee table.
select * from Employee;


-- Select all records from the Employee table where last name is King.
select * from Employee
where lastname like 'King';

-- Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
select * from Employee
where firstname like 'Andrew' and REPORTSTO is null;

-- 2.2 Order By
-- Select all albums in Album table and sort result set in descending order by title.
select title from ALBUM
order by TITLE desc;

-- Select first name from Customer and sort result set in ascending order by city
select firstname from customer
ORDER BY city asc;

-- 2.3 Insert Into
-- Insert two new records into Genre table

CREATE SEQUENCE GEN_ID_SEQ
INCREMENT BY 1
START WITH 26;
/

INSERT INTO GENRE (GENREID, name)
Values(GEN_ID_SEQ.nextval, 'Country');

INSERT INTO GENRE (GENREID, name)
Values(GEN_ID_SEQ.nextval, 'Folk');

select * from genre;
/
-- Insert two new records into Employee table

CREATE SEQUENCE EMPL_ID_SEQ
INCREMENT BY 1
START WITH 9;
/

CREATE OR REPLACE TRIGGER EMPL_ID_TRIGGER
BEFORE INSERT ON Employee
FOR EACH ROW
BEGIN
  IF :NEW.EMPLOYEEID IS NULL THEN
    SELECT EMPL_ID_SEQ.NEXTVAL INTO :new.EMPLOYEEID FROM DUAL;
  END IF;
END;

/

create or replace procedure add_employee(
ln VARCHAR2,
fn in VARCHAR2,
title in VARCHAR2,
reports in NUMBER,
birth in DATE,
hire in DATE,
address in VARCHAR2,
city in VARCHAR2,
state in VARCHAR2,
country in VARCHAR2,
pc in VARCHAR2,
pn in VARCHAR2,
fax in VARCHAR2,
email in VARCHAR2)
AS begin
insert into EMPLOYEE(LASTNAME,FIRSTNAME,
TITLE,REPORTSTO,BIRTHDATE,HIREDATE,ADDRESS,
CITY,STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL)
values(ln,fn,title,reports,birth,hire,address,city,state,country,pc,pn,fax,email);
commit;
end add_employee;
/ 


DECLARE
  LN VARCHAR2(200);
  FN VARCHAR2(200);
  TITLE VARCHAR2(200);
  REPORTS NUMBER;
  BIRTH DATE;
  HIRE DATE;
  ADDRESS VARCHAR2(200);
  CITY VARCHAR2(200);
  STATE VARCHAR2(200);
  COUNTRY VARCHAR2(200);
  PC VARCHAR2(200);
  PN VARCHAR2(200);
  FAX VARCHAR2(200);
  EMAIL VARCHAR2(200);
BEGIN
  LN := 'Jones';
  FN := 'Robert';
  TITLE := 'IT Staff';
  REPORTS := 1;
  BIRTH := TO_DATE('17/12/1975', 'DD/MM/YYYY');
  HIRE := TO_DATE('17/12/2015', 'DD/MM/YYYY');
  ADDRESS := '200 Gilbert Lane';
  CITY := 'Reston';
  STATE := 'VA';
  COUNTRY := 'USA';
  PC := '02190';
  PN := '+1 (415)-732-9000';
  FAX := '+1 (415)-732-9156';
  EMAIL := 'robj@gmail.com';

  ADD_EMPLOYEE(
    LN => LN,
    FN => FN,
    TITLE => TITLE,
    REPORTS => REPORTS,
    BIRTH => BIRTH,
    HIRE => HIRE,
    ADDRESS => ADDRESS,
    CITY => CITY,
    STATE => STATE,
    COUNTRY => COUNTRY,
    PC => PC,
    PN => PN,
    FAX => FAX,
    EMAIL => EMAIL
  );
--rollback; 
END;
/

DECLARE
  LN VARCHAR2(200);
  FN VARCHAR2(200);
  TITLE VARCHAR2(200);
  REPORTS NUMBER;
  BIRTH DATE;
  HIRE DATE;
  ADDRESS VARCHAR2(200);
  CITY VARCHAR2(200);
  STATE VARCHAR2(200);
  COUNTRY VARCHAR2(200);
  PC VARCHAR2(200);
  PN VARCHAR2(200);
  FAX VARCHAR2(200);
  EMAIL VARCHAR2(200);
BEGIN
  LN := 'Jolt';
  FN := 'Roberta';
  TITLE := 'IT Staff';
  REPORTS := 1;
  BIRTH := TO_DATE('01/12/2002','DD/MM/YYYY');
  HIRE := TO_DATE('01/08/2001', 'DD/MM/YYYY');
  ADDRESS := '2 Willow Lane';
  CITY := 'Reston';
  STATE := 'VA';
  COUNTRY := 'USA';
  PC := '02190';
  PN := '+1 (415)-732-9823';
  FAX := '+1 (415)-732-9077';
  EMAIL := 'bertajo@gmail.com';

  ADD_EMPLOYEE(
    LN => LN,
    FN => FN,
    TITLE => TITLE,
    REPORTS => REPORTS,
    BIRTH => BIRTH,
    HIRE => HIRE,
    ADDRESS => ADDRESS,
    CITY => CITY,
    STATE => STATE,
    COUNTRY => COUNTRY,
    PC => PC,
    PN => PN,
    FAX => FAX,
    EMAIL => EMAIL
  );
--rollback; 
END;
/

select * from employee;

-- Insert two new records into Customer table

insert INTO CUSTOMER(CUSTOMERID,FIRSTNAME,lastname,company,address,city,state,country,postalcode,phone,fax,email,Supportrepid)
VALUES(60,'George','Georgeson','George And Son','15 place st','Placeville','VA','USA','02156','657-932-0344','987-543-9901','gg@gson.com',4);
insert INTO CUSTOMER(CUSTOMERID,FIRSTNAME,lastname,company,address,city,state,country,postalcode,phone,fax,email,Supportrepid)
VALUES(61,'Geegee','Georgeson','Trader Joes','24 Orange st','Placeville','VA','USA','02156','685-346-9220','056-942-5572','gee@gmail.com',5);

select * from customer where firstname like 'Ge%';
-- 2.4 Update
-- Update Aaron Mitchell in Customer table to Robert Walter
select * from customer
where firstname like 'Aaron';

UPDATE CUSTOMER
set FIRSTNAME = 'Robert', LASTNAME = 'Walter'
where firstname like 'Aaron';

select * from customer
where firstname like 'Robert';

-- Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
UPDATE ARTIST
set NAME = 'CCR'
where name like 'Creedence Clearwater Revival';

select * from artist
where name like 'CCR';

-- 2.5 Like
-- Select all invoices with a billing address like “T%”
SELECT * FROM invoice
where BILLINGADDRESS like 'T%';

-- 2.6 Between
-- Select all invoices that have a total between 15 and 50
select * from INVOICE
where TOTAL BETWEEN 15 and 50;

-- Select all employees hired between 1st of June 2003 and 1st of March 2004
select * from EMPLOYEE
where HIREDATE between TO_DATE('01/06/2003','DD/MM/YYYY') and TO_DATE('01/03/2004','DD/MM/YYYY');

-- 2.7 Delete
-- Delete a record in Customer table where the name is Robert Walter (There may be 
    -- constraints that rely on this, find out how to resolve them).

ALTER table invoice
ADD constraint fk_InvoicecustomerID
    FOREIGN KEY (CustomerID)
    REFERENCES Customer (customerID)
    ON DELETE CASCADE;
  
  
ALTER table invoiceline
ADD constraint FK_INVOICELINEINVOICEID
    FOREIGN KEY (invoiceID)
    REFERENCES invoice (invoiceID)
    ON DELETE CASCADE;

DELETE FROM Customer
where lower(lastname) like 'walter';

-- 3.0 SQL Functions
-- using functions to perform various actions against the database

-- 3.1 System Defined Functions
-- Create a function that returns the current time.
create or replace function  get_time
return timestamp
is curtime timestamp;
begin
SELECT CURRENT_TIMESTAMP into curtime FROM DUAL;
end;
/

-- create a function that returns the length of a mediatype from the mediatype table
select * from track;
create or replace FUNCTION get_length
(mediatype_id number)
RETURN number
IS return_length NUMBER;
cursor c1 is
select milliseconds
from track
where mediatypeid = mediatype_id;
begin open c1;
fetch c1 into return_length;
          END get_length;
/


--3.2 System Defined Aggregate Functions
-- Create a function that returns the average total of all invoices
create or replace function findAv
return number
is
  av number;
begin
  select avg(total) 
  into av
  from invoice;
end findav;
/

-- Create a function that returns the most expensive track

create or replace function expensetrack
return varchar2
is 
  tname varchar2(30);
begin
declare 
maxp number;
begin
  select max(unitprice) 
  into maxp
  from track;
  select name
  into tname
  from track
  where UNITPRICE = maxp;
  return tname;
  end;
end expensetrack;
/
--3.3 User Defined Scalar Functions
-- Create a function that returns the average price of invoiceline items in the invoiceline table
create or replace function avgprice
return number
is avp number;
begin
  select AVG(quantity)*AVG(unitprice) into avp
  from INVOICELINE;
  return avp;
end;
/
--3.4 User Defined Table Valued Functions
-- Create a function that returns all employees who are born after 1968.

create or replace function born_after
RETURN sys_refcursor 
is c1 sys_refcursor;
begin
open c1 for
select *
from EMPLOYEE 
where EXTRACT(year from birthdate) > 1968;
return c1;
end;
/

select * from EMPLOYEE where EXTRACT(year from birthdate) > 1968;

-- 4.0 Stored Procedures 4
--   creating and executing stored procedures.

-- 4.1 Basic Stored Procedure
-- Create a stored procedure that selects the first and last names of all the employees.

create or replace procedure get_names(
fn out varchar2,
ln out varchar2)
AS begin
  select firstname, lastname 
  into fn, ln
  from employee;
end;
/

--4.2 Stored Procedure Input Parameters
-- Create a stored procedure that updates the personal information of an employee.

create or replace procedure update_employee(
i_d number,
ln VARCHAR2,
fn in VARCHAR2,
title in VARCHAR2,
reports in NUMBER,
birth in DATE,
hire in DATE,
address in VARCHAR2,
city in VARCHAR2,
state in VARCHAR2,
country in VARCHAR2,
pc in VARCHAR2,
pn in VARCHAR2,
fax in VARCHAR2,
email in VARCHAR2)
iS begin
UPDATE EMPLOYEE set LASTNAME = ln, FIRSTNAME = fn,
TITLE = title ,REPORTSTO = reports ,BIRTHDATE = birth,HIREDATE = hire,ADDRESS=address,
CITY = city, STATE = state,COUNTRY=COUNTRY,POSTALCODE=pc,PHONE=pn,FAX=fax,EMAIL=email
where employeeid = i_d;
commit;
end update_employee;
/


-- Create a stored procedure that returns the managers of an employee.

create or replace procedure get_manager(
emplid in number,
mngr out varchar2)
as 
begin
  declare
  mangr_id number;
  begin
    select reportsto
    into mangr_id
    from employee
    where employeeid = emplid;
    select firstname 
    into mngr
    from employee
    where employeeid = mangr_id;
  end;
end;
/


--4.3 Stored Procedure Output Parameters
-- Create a stored procedure that returns the name and company of a customer.

create or replace procedure getname_comp(
custid in number)
as 
begin
  declare 
  nm varchar2(30);
  comp varchar2(30);
  BEGIN
    select firstname, company
    into nm, comp
    from customer
    where customerid = custid;
  end;
end;
/

--5.0 Transactions
-- Working with transactions (usually nested within a stored procedure).

-- Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
create or replace procedure deleteinvoice(
invid in number)
AS 
begin
  delete invoice
  where INVOICEID = invid;
  commit;
end deleteinvoice;
/

-- Create a transaction nested within a stored procedure that inserts a new record in the Customer table
select * from customer;

create or replace procedure newcust(
fn varchar2,
ln in varchar2,
comp in varchar2)
AS 
begin
  insert into customer(firstname, lastname, company)
  values(fn,ln,comp);
  commit;
end newcust;
/

--6.0 Triggers
--   Create various kinds of triggers that work when certain DML statements are executed on a table.


-- 6.1 AFTER/FOR
-- Create an after insert trigger on the employee table fired after a new record is inserted into the table.
select * from employee;
select * from customer;
insert INTO EMPLOYEE(firstname, lastname, title) values('Robert','Jones','IT Staff');
select firstname from inserted;

create or replace trigger newempl
After INSERT ON employee
for each row
declare
custid number;
BEGIN
  select max(customerid) into custid from customer;
  update customer
  set supportrepid = :new.employeeid
  where supportrepid is null;
END;
/


-- Create an after update trigger on the album table that fires after a row is inserted in the table
create table album_backup(albumid number, title varchar2(30), artist number);
create or replace trigger newalbum
after insert on album
for each row
begin
  insert into album_backup(albumid, title, artist)
  values(:new.albumid, :new.title, :new.artistid);
end;
/

-- Create an after delete trigger on the customer table that fires after a row is deleted from the table.
create table lostcustomer
(LOSTID NUMBER PRIMARY KEY,
DateLost date);

create or replace trigger updatecustomer after delete
on customer
for each row
begin
  insert into lostcustomer(lostid,DATELOST)
  values(:old.customerid, sysdate);
end;
/


-- 7.0 JOINS
-- Combing various tables through the use outer, inner, right, left, cross, and self joins.

--7.1 INNER
-- Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
select cust.firstname||' '||cust.lastname as "customer name", inv.invoiceid as "order number"
from customer cust
join invoice inv on inv.customerid = cust.customerid;

--7.2 OUTER
-- Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
select c.customerid, c.firstname, c.lastname, i.total, i.invoiceid
from customer c
full outer join invoice i on i.customerid = c.customerid
order by c.customerid;

-- 7.3 RIGHT
-- Create a right join that joins album and artist specifying artist name and title.
select l.title as "album title", t.name as "artist name" 
from album l
right join artist t on t.ARTISTID = l.ARTISTID;

-- 7.4 CROSS
-- Create a cross join that joins album and artist and sorts by artist name in ascending order.
select l.title as "album title", t.name as "artist name" 
from album l
cross join artist t
order by t.NAME asc;

--7.5 SELF
-- Perform a self-join on the employee table, joining on the reportsto column.
select e1.firstname, e1.lastname, e2.firstname||' '||e2.lastname as MANAGERNAME
from EMPLOYEE e1
join Employee e2
on e1.reportsto = e2.employeeid;