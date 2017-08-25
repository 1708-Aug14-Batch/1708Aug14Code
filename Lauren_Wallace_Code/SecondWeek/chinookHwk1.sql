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


-- UPDATE NAME OF ARTIST IN THE ARTIST TABLE "CREEDENCE CLEARWATER REVIVAL" 
-- TO "CCR"
