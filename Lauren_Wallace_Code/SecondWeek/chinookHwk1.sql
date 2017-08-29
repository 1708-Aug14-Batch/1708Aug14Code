/*
* WEEK 2 HOMEWORK
*/

-- 2.1 SELECT
-- SELECTS ALL FROM THE EMPLOYEE TABLE
select * from employee;

-- SELECT ALL FROM THE EMPLOYEE TABLE WHERE LASTNAME = KING
select * from employee where lastname = 'King';

-- SELECT ALL FROM THE EMPLOYEE TABLE WHERE FIRSTNAME = ANDREW AND REPORTSTO = NULL
select * from employee where firstname = 'Andrew' and reportsto is null;

-- 2.2 ORDER BY
-- SELECTS ALL ALBUMS FROM ALBUM & SORTS RESULT IN DESCENDING ORDER BY TITLE
select * from album order by title desc;

-- SELECTS FIRSTNAME FROM CUSTOMER & SORTS RESULT SET IN ASCENDING ORDER IN CITY
select firstname from customer order by city asc;

-- 2.3 INSERT INTO
-- INSERT 2 NEW RECORDS INTO THE GENRE TABLE
insert into genre(genreid, name)
values (26, 'vocaloid');

insert into genre(genreid, name)
values (27, 'videogame themes');

-- INSERT 2 NEW RECORDS INTO THE EMPLOYEE TABLE
insert into employee(employeeid, lastname, firstname, title, reportsto, 
birthdate, hiredate, address, city, state, country, postalcode, phone, fax, email)
values (9, 'Marcus', 'Lowry', 'Associate Manager', 1, '20-FEB-75',
'10-JUN-16', '1156 Swan Dr', 'Annapolis', 'MD', 'USA', '21012', '+1 (410) 757-2031', '+1 (780) 562-3621', 'ml@gmail.com');

insert into employee(employeeid, lastname, firstname, title, reportsto, 
birthdate, hiredate, address, city, state, country, postalcode, phone, fax, email)
values (10, 'Bonnie', 'Donna', 'Sales Manager', 1, '15-MAR-64',
'10-APR-14', '118 Mossberry Ave', 'Severna Park', 'MD', 'USA', '21112', 
'+1 (410) 757-0351', '+1 (780) 562-3621', 'bd@gmail.com');

-- INSERT 2 NEW RECORDS INTO THE CUSTOMER
insert into customer(customerid, firstname, lastname, company, address, city,
state, country, postalcode, phone, fax, email, supportrepid) values (60, 
'Damien', 'Domingo', 'Amazom', '1231 Huckleberry Rd', 'Bushes', 'FL', 'USA',
'21546', '+1 (564) 784-6254', '+1 (780) 562-1524', 'dd@hotmail.com', '8');

insert into customer(customerid, firstname, lastname, company, address, city,
state, country, postalcode, phone, fax, email, supportrepid) values (61,
'Rosette', 'Mary', 'Revature', '1179 Plaza America Rd', 'Revon', 'VA', 'USA',
'21365', '+1 (324) 624-8652', '+1 (435) 373-2685', 'rm@gmail.com', '4');

-- 2.4 UPDATE
-- UPDATE AARON MITCHELL IN CUSTOMER TABLE TO ROBERT WALTER
update customer set firstname = 'Robert', lastname = 'Walter'
where firstname = 'Aaron' and lastname = 'Mitchell';

-- UPDATE NAME OF ARTIST IN THE ARTIST TABLE "CREEDENCE CLEARWATER REVIVAL" 
-- TO "CCR"
update artist set name = 'CCR' where name = 'Creedence Clearwater Revival';

-- 2.5 LIKE
-- SELECTS ALL INVOICES FROM INVOICE WHERE BILLING ADDRESS 
-- HAS A T AT THE BEGINING
select * from invoice where billingaddress like 'T%';

-- 2.6 BETWEEN
-- SELECTS ALL INVOICES THAT HAVE A TOTAL BETWEEN 15 AND 50
select * from invoice where total between 15 and 50;

-- SELECTS ALL EMPLOYEES HIRED BETWEEN THE 1ST OF JUNE 2003 
-- AND 1ST OF MARCH 2004
select * from employee where hiredate between '01-JUN-03' and '01-MAR-04';

-- 2.7 DELETE
-- DELETES A RECORD IN CUSTOMER WHERE THE NAME IS ROBERT WALTER
-- 4 ALTER TABLE STATEMENTS, 2 DROP CONSTRAINTS, AND 2 ON DELETE CASCADE 
-- STATEMENTS ARE NEEDED TO PERFORM THE DELETE
-- THE TABLES TO ALTER ARE: INVOICE, INVOICELINE
alter table invoice 
drop constraint fk_invoicecustomerid;

alter table invoiceline
drop constraint fk_invoicelineinvoiceid;

alter table invoice 
add constraint fk_invoicecustomerid
foreign key (customerid) references customer (customerid)
on delete cascade;

alter table invoiceline
add constraint fk_invoicelineinvoiceid
foreign key (invoiceid) references invoice (invoiceid)
on delete cascade;

commit;

delete from customer where firstname = 'Robert' and lastname = 'Walter';

-- 3.1 SYSTEM DEFINED FUNCTIONS
-- FUNCTION THAT RETURNS THE CURRENT TIME
alter session set time_zone = '-5:0';
select current_timestamp from dual;

-- FUNCTION THAT RETURNS THE LENGTH OF A MEDIATYPE
-- FROM THE MEDIATYPE TABLE FOR EACH MEDIATYPE
select length('MPEG audio file') "Length in characters"
from dual;
select length('Protected AAC audio file') "Length in characters"
from dual;
select length('Protected MPEG-4 video file') "Length in characters"
from dual;
select length('Purchased AAC audio file') "Length in characters"
from dual;
select length('AAC audio file') "Length in characters"
from dual;

-- 3.2 SYSTEM DEFINED AGGREGATE FUNCTIONS
-- FUNCTION THAT RETURNS THE AVG TOTAL OF ALL INVOICES
select avg(total) from invoice;

-- FUNCTION THAT RETURNS THE MOST EXPENSIVE TRACK
select name, unitprice from track order by unitprice desc limit 1;

-- 3.3 USER DEFINED SCALAR FUNCTIONS
-- CREATES A AVGINLPRICE FUNCTION FOR INVOICELINE 
-- AVGS THE UNITPRICE OF THAT TABLE
create or replace double avgInlPrice(column_name)
return double as avgPrice := avg(column_name)
end;

select avgInlPrice(unitprice) from invoiceline;

-- 3.4 USER DEFINED TABLE VALUED FUNCTIONS
-- CREATES A FUNCTION TO RETURN ALL EMPLOYEES
-- WHO ARE BORN AFTER 1968
create or replace type youngemps(
firstname varchar2(50),
lastname varchar2(50)
)
create or replace function returnyoungemps 
return youngemps
cursor c1 is select firstname || '' || lastname
             from employee where birthdate > '31-DEC-68';
begin
open c1;
loop 
fetch c1 into youngemps;
exit when c1%notfound;
end loop;
close c1;
end;
-- 4.1 BASIC STORED PROCEDURE

-- 4.2 STORED PROCEDURE INPUT PARAMETERS

-- 4.3 STORED PROCEDURE OUTPUT PARAMETERS

-- 5.0 TRANSACTIONS

-- 6.0 TRIGGERS

-- 7.1 INNER JOIN
-- CREATE AN INNER JOIN FOR TABLES CUSTOMER & INVOICE
-- SHOWING THE CUSTOMER NAME & INVOICEID
select customer.firstname, customer.lastname, invoice.invoiceid
from customer, invoice
where customer.customerid = invoice.customerid;

-- 7.2 OUTER JOIN
-- CREATE AN OUTER JOIN FOR TABLES CUSTOMER & INVOICE
-- SHOWING THE CUSTOMERID, FIRSTNAME, LASTNAME, 
-- INVOICEID, & TOTAL


-- 7.3 RIGHT JOIN
-- CREATE A RIGHT JOIN FOR TABLES ALBUM & ARTIST
-- SHOWING THE ARTIST NAME AND TITLE


-- 7.4 CROSS JOIN
-- CREATE A CROSS JOIN FOR TABLES ALBUM & ARTIST
-- SHOWING ARTIST NAME IN ASCENDING ORDER
select artist.name, album
from artist, ALBUMLIST


-- 7.5 SELF JOIN
-- CREATE A SELF JOIN ON TABLE EMPLOYEE WHERE THE 
-- COLUMN TO JOIN IS REPORTSTO
select employee.firstname as empFName, employee.lastname as empLName,
employee.reportsto as supervisorid
from employee
where employee.employeeid = employee.reportsto;