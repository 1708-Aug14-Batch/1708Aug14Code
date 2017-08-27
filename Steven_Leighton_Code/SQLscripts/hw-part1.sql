/*
STEVEN LEIGHTON

2.1 SELECT
Task – Select all records from the Employee table.
Task – Select all records from the Employee table where last name is King.
Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
*/
select * from employee;

select * from employee where lastname = 'King';

select * from employee where firstname = 'Andrew' AND reportsto is NULL;

/*
2.2 ORDER BY
Task – Select all albums in Album table and sort result set in descending order by title.
Task – Select first name from Customer and sort result set in ascending order by city
*/
select * from album
order by title desc;

select firstname from customer
order by city asc;

/*
2.3 INSERT INTO
Task – Insert two new records into Genre table
Task – Insert two new records into Employee table
Task – Insert two new records into Customer table
*/
insert into Genre (GENREID,NAME) values (26,'Anonymous');
insert into Genre (GENREID,NAME) values (27,'Perfection');

insert into Employee(employeeid, lastname,firstname,title,reportsto,birthdate,hiredate,
address,city,state,country,postalcode,phone,fax,email) values (
9, 'Leighton','Steven','IT Manager',1,'04-APR-95','07-MAY-16','35 Dean Street',
'Bangor','ME','United States','04401','+1 (207)570-4183','+1 (207)570-4183','steven.leighton@maine.edu');

insert into Employee(employeeid, lastname,firstname,title,reportsto,birthdate,hiredate,
address,city,state,country,postalcode,phone,fax,email) values (
10,'Audibert','Josh', 'IT Staff',9,'01-JAN-95','07-MAY-16','Somewhere in cambridge',
'Cambridge','MA','United States','12345','+1 (132)343-5721','+1 (132)343-5721','josh.audibert@mail.com');

insert into Customer(customerid, firstname,lastname,address,city,state,country,
postalcode,phone,fax,email,supportrepid) values (
60,'Maya','Silver', 'Somewhere in orono',
'Orono','ME','United States','04111','+1 (132)343-5721','+1 (132)343-5721','maya.silver@mail.com',10);

insert into Customer(customerid, firstname,lastname,address,city,state,country,
postalcode,phone,fax,email,supportrepid) values (
61,'Jake','Morno', 'Somewhere in bangor',
'Bangor','ME','United States','04401','+1 (132)888-1234','+1 (132)343-5721','jake.morno@mail.com',10);

/*
2.4 UPDATE
Task – Update Aaron Mitchell in Customer table to Robert Walter
Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
*/
update Customer
set firstname = 'Robert',lastname = 'Walter'
where firstname = 'Aaron' and lastname = 'Mitchell';

update artist
set name = 'Creedence Clearwater Revival'
where name = 'CCR';
/*
2.5 LIKE
Task – Select all invoices with a billing address like “T%”
*/
select * from invoice where BILLINGADDRESS like 'T%';
/*
2.6 BETWEEN
Task – Select all invoices that have a total between 15 and 50
Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
*/
select * from invoice where total between 15 and 50;

select * from employee where hiredate between '01-JUN-03' AND '01-MAR-04';
/*
2.7 DELETE
Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
*/

--set delete cascade in customer, invoice, and twice in invoiceline
ALTER TABLE CUSTOMER
   DROP CONSTRAINT FK_CUSTOMERSUPPORTREPID;
   
ALTER TABLE CUSTOMER
   ADD CONSTRAINT supportrep_Cascade
   FOREIGN KEY (supportrepid) REFERENCES employee(employeeid) ON DELETE CASCADE;

ALTER TABLE INVOICE
   DROP CONSTRAINT FK_INVOICECUSTOMERID;
   
ALTER TABLE INVOICE
   ADD CONSTRAINT invoiceCustomerId_Cascade
   FOREIGN KEY (customerid) REFERENCES customer(customerid) ON DELETE CASCADE;

ALTER TABLE INVOICELINE
   DROP CONSTRAINT FK_INVOICELINEINVOICEID;
   
ALTER TABLE INVOICELINE
   ADD CONSTRAINT invoicelineinvoiceId_Cascade
   FOREIGN KEY (invoiceid) REFERENCES invoice(invoiceid) ON DELETE CASCADE;

ALTER TABLE INVOICELINE
   DROP CONSTRAINT FK_INVOICELINETRACKID;
   
ALTER TABLE INVOICELINE
   ADD CONSTRAINT invoicelinetrackId_Cascade
   FOREIGN KEY (trackid) REFERENCES track(trackid) ON DELETE CASCADE;
   
delete from customer
where firstname = 'Robert' and lastname = 'Walter';
/*
3.0	SQL Functions 6
In this section you will be using the Oracle system functions, as well as your own functions, to perform various actions against the database
3.1 System Defined Functions
Task – Create a function that returns the current time.
Task – create a function that returns the length of a mediatype from the mediatype table
*/
create or replace function currentTime return timestamp
is
  stamp timestamp;
BEGIN
  stamp := CURRENT_TIMESTAMP;
  return stamp;
END currentTime;

create or replace function lenMediaType(typeName in varchar2) return number
is
  len number;
BEGIN
  len := length(typeName);
  return len;
END lenMediaType;

/*
3.2 System Defined Aggregate Functions
Task – Create a function that returns the average total of all invoices
Task – Create a function that returns the most expensive track
*/
create or replace function averageInvoice return number
is
  average number;
BEGIN
  select avg(total) into average
  from invoice;
  return average;
END averageInvoice; --5.65 with base chinook values right now

create or replace function maxPriceTrack return number
is
  price number;
BEGIN
  select max(unitprice) into price
  from track;
  return price;
END maxPriceTrack; --1.99 right now
/*
3.3 User Defined Scalar Functions
Task – Create a function that returns the average price of invoiceline items in the invoiceline table
*/
create or replace function averageInvoiceLine return number
is
  average number;
BEGIN
  select avg(unitprice) into average
  from invoiceline;
  return average;
END averageInvoiceLine; --1.04 with base chinook values right now
/*
3.4 User Defined Table Valued Functions
Task – Create a function that returns all employees who are born after 1968.
*/

CREATE OR REPLACE FUNCTION getEmpAfter1968
  RETURN SYS_REFCURSOR
AS
  my_cursor SYS_REFCURSOR;
BEGIN
  OPEN my_cursor FOR SELECT * FROM employee where birthdate > '31-DEC-68';
  RETURN my_cursor;
END getEmpAfter1968;

/*
4.0 Stored Procedures 4
 In this section you will be creating and executing stored procedures. You will be creating various types of stored procedures that take input and output parameters.
4.1 Basic Stored Procedure
Task – Create a stored procedure that selects the first and last names of all the employees.
*/
CREATE OR REPLACE PROCEDURE selectNames (
                      p_recordset OUT SYS_REFCURSOR) AS 
BEGIN 
  OPEN p_recordset FOR
    select firstname, lastname from employee;
END selectNames ;
/*
4.2 Stored Procedure Input Parameters
Task – Create a stored procedure that updates the personal information of an employee.
Task – Create a stored procedure that returns the managers of an employee.
*/
create or replace procedure updateEmp(newTitle in varchar2, empID in number) as
begin
  update employee
  set title = newTitle
  where employeeid = empID;
end updateEmp;

create or replace procedure getManager(empID in number, nam out varchar2) as 
begin
  select firstname || ' ' || lastname into nam
  from employee emp inner join 
  (select reportsto as managerID from employee where employeeid = empID) man 
  on man.managerID = emp.employeeID;
end getManager;
/*
4.3 Stored Procedure Output Parameters
Task – Create a stored procedure that returns the name and company of a customer.
*/
create or replace procedure nameAndCompany(custID in number, fullname out varchar2, comp out varchar2) as
begin
  select firstname || ' ' || lastname into fullname from customer where custID = customerid;
  select company into comp from customer where custID = customerid;
end nameAndCompany;
/*
5.0 Transactions 2
In this section you will be working with transactions. Transactions are usually nested within a stored procedure.
Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table
*/
-- deletes invoice with given invoiceid
create or replace procedure deleteInvoice(invID in number) as
BEGIN
--Begin the transaction
SET TRANSACTION READ WRITE;

delete from invoice where invoiceid = invID;

COMMIT;

END;

--add customer w/ procedure and transaction
CREATE OR REPLACE PROCEDURE addCustomer(
    cID      IN NUMBER,
    fn       IN VARCHAR2,
    ln       IN VARCHAR2,
    addr     IN VARCHAR2,
    ci       IN VARCHAR2,
    st       IN VARCHAR2,
    co       IN VARCHAR2,
    postal   IN VARCHAR2,
    phon     IN VARCHAR2,
    fa       IN VARCHAR2,
    emai     IN VARCHAR2,
    employee IN NUMBER)
AS
BEGIN
  --Begin the transaction
  SET TRANSACTION READ WRITE;
  INSERT
  INTO Customer
    (
      customerid,
      firstname,
      lastname,
      address,
      city,
      state,
      country,
      postalcode,
      phone,
      fax,
      email,
      supportrepid
    )
    VALUES
    (
      cID,
      fn,
      ln,
      addr,
      ci,
      st,
      co,
      postal,
      phon,
      fa,
      emai,
      employee
    );
  COMMIT;
END;

/*
6.0 Triggers
In this section you will create various kinds of triggers that work when certain DML statements are executed on a table.
6.1 AFTER/FOR 3
Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
Task – Create an after update trigger on the album table that fires after a row is updated in the table
Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
*/
--inserts name into example table
create or replace TRIGGER afterInsertTrigger
  AFTER INSERT ON EMPLOYEE 
  for each row
BEGIN
  insert into example (FIRSTNAME,lastname)
  values (:NEW.firstname, :NEW.lastname);
END;

--adds row to table that saves changes from old title to new title
create or replace TRIGGER afterUpdateAlbumTrigger
  AFTER update ON album 
  for each row
BEGIN
  insert into changed_album (column1,column2)
  values (:new.title, :old.title);
END;

--ADD NAME of person to deleted users table
create or replace TRIGGER afterDeleteCustomerTrigger
  AFTER delete ON customer 
  for each row
BEGIN
  insert into deleted_users (name)
  values (:old.firstname || ' ' || :old.lastname);
END;

/*
7.0 JOINS 5
In this section you will be working with combing various tables through the use of joins. You will work with outer, inner, right, left, cross, and self joins.
7.1 INNER
Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
*/
select cust.firstname, cust.lastname, inv.invoiceid
from customer cust
inner join invoice inv on inv.customerId = cust.customerid;
/*
7.2 OUTER
Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
*/
select cust.customerid, cust.firstname,cust.lastname, inv.invoiceid, inv.total
from customer cust
join invoice inv on inv.customerid = cust.customerid;
/*
7.3 RIGHT
Task – Create a right join that joins album and artist specifying artist name and title.
*/
select ar.name, al.title from album al
right join artist ar on ar.artistid = al.artistid;
/*
7.4 CROSS
Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
*/
select * from album,artist order by artist.name asc;
/*
7.5 SELF
Task – Perform a self-join on the employee table, joining on the reportsto column.
*/
select * from employee e1, employee e2 
where e1.reportsto = e2.employeeid;