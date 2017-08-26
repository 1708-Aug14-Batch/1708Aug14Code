

select cust.firstname custname, emp.firstname empname
from EMPLOYEE emp
full join customer cust on emp.state = cust.state;
--2.1 SELECT
--Task – Select all records from the Employee table.
select * from employee;
--Task – Select all records from the Employee table where last name is King.
select * from employee where lastname = 'King';
--Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
select * from employee where firstname = 'Andrew' and REPORTSTO = 'NULL';



--2.2 ORDER BY
--Task – Select all albums in Album table and sort result set in descending order by title.
select * from album
ORDER BY title desc;


--Task – Select first name from Customer and sort result set in ascending order by city
select firstname from Customer
Order By city asc;

--2.3 INSERT INTO
--Task – Insert two new records into Genre table
INSERT INTO GENRE
VALUES ('219','ElectricAttitude');

INSERT INTO GENRE
VALUES ('220', 'MatrixMagic');

--Task – Insert two new records into Employee table
INSERT INTO employee
VALUES (215 , 'James' , 'John' , 'VP OF Sales' , 200 , '1979-06-18' , '2017-18-14' , 
'508 pride ave' , 'Herndon' , 'VA' , 'United States' , '91190' , '253-651-2222' , '253-651-2222' , 'JohnJames@gmail.com');

INSERT INTO employee
VALUES (216 ,'Sam' ,'Jones' , 'VP OF Marketing' , 201 , '1933-06-18' , '2017-18-14' , 
'508 pride ave' , 'Herndon' , 'VA' , 'United States' , '91190' , '253-651-2223' , '253-651-2223' , 'SameJones@gmail.com');



--Task – Insert two new records into Customer table
INSERT INTO  customer
VALUES (209 , 'Joshua' , 'Jones' , 'orcle' , '109 prid st' , 'Herndon' , 'VA' , 'United States' , '91702' , '253-651-1389' , '253-651-2233' , 'JoshuaWurdemann@gmail.com' , 1);

INSERT INTO  customer
VALUES (210 , 'Jessica' , 'Steele' , 'sys' , '109 prid st' , 'Herndon' , 'VA' , 'United States' ,
'91702' , '253-651-2322' , '253-651-3322' , 'JessicaSteele@gmail.com' , 2);


--2.4 UPDATE
--Task – Update Aaron Mitchell in Customer table to Robert Walter

UPDATE Customer
SET firstname = 'Robert' , lastname = 'Walter'
WHERE firstname = 'Aaron' AND lastname = 'Mitchell';

--Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
UPDATE ARTIST
SET  name = 'CCR'
WHERE name = 'Creedence Clearwater Revival';

--2.5 LIKE
--Task – Select all invoices with a billing address like “T%”
select * from invoice
where BillingAddress like'T%';

--2.6 BETWEEN
--Task – Select all invoices that have a total between 15 and 50

select * from invoice
where TOTAL between 15 and 20;

--Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
select * from employee
Where HIREDATE  Between Date '2003-06-01' and  Date '2004-03-01';

SELECT * FROM employee
WHERE HIREDATE BETWEEN '01-JUN-03' AND '01-MAR-04';

--2.7 DELETE
--Task – Delete a record in Customer table where the name is Robert Walter 
--(There may be constraints that rely on this, find out how to resolve them).

--select * from INVOICE where CUSTOMERID = 32;
--
--delete from INVOICE
--Where CUSTOMERID = 32;

ALTER TABLE invoiceline
DROP CONSTRAINT FK_invoicelineinvoiceid;
ALTER TABLE invoiceline 
ADD CONSTRAINT FK_invoicelineinvoiceid 
FOREIGN KEY (invoiceid) REFERENCES invoice (invoiceid) 
ON DELETE CASCADE;
ALTER TABLE invoice
DROP CONSTRAINT FK_invoicecustomerid;
ALTER TABLE invoice 
ADD CONSTRAINT FK_invoicecustomerid 
FOREIGN KEY (customerid) REFERENCES customer (customerid) 
ON DELETE CASCADE;
ALTER TABLE Customer
DROP CONSTRAINT FK_CUStomerSupportrepId;
ALTER TABLE Customer 
ADD CONSTRAINT FK_customersupportrepid 
FOREIGN KEY (supportrepid) REFERENCES employee (employeeid) 
ON DELETE CASCADE;
DELETE FROM customer
WHERE lower(FIRSTNAME) = lower('robert')
AND lower (lastname)   = lower('walter');


--3.1 System Defined Functions
--Task – Create a function that returns the current time.
--try to find a better solution to current time
 create or replace function GetSysdate
       (p_alt_date in varchar2 := null)
   return TIMESTAMP is
  begin
     if p_alt_date is null then
           return CURRENT_TIMESTAMP ;
       else
           return to_date(sys_context('example', p_alt_date)
                                         , 'hh24:mi:ss');
      end if;
  end;
  /
  
  select getsysdate from dual;

--Task – create a function that returns the length of a mediatype from the mediatype table

create or replace FUNCTION MEDIA_LENGTH(M_ID IN NUMBER)
    RETURN NUMBER  
   is M_LENGTH NUMBER(10);
        BEGIN  
            SELECT LENGTH(NAME) INTO M_LENGTH FROM MEDIATYPE WHERE MEDIATYPEID = M_ID;
            RETURN M_LENGTH;
        END;
   
      
        
--3.2 System Defined Aggregate Functions
--Task – Create a function that returns the average total of all invoices
create or replace FUNCTION avgTotalInvoices
    RETURN NUMBER  
   is avgTotal NUMBER(10,2);
        BEGIN  
            SELECT AVG(TOTAL) INTO AvgTotal FROM Invoice;
            RETURN avgTotal;
        END;
        select AVGTOTALINVOICES from invoice;
--Task – Create a function that returns the most expensive track
create or replace FUNCTION MostExpensivetrack(M_ID IN NUMBER)
    RETURN NUMBER  
   is M_LENGTH NUMBER(10);
        BEGIN  
            SELECT LENGTH(NAME) INTO M_LENGTH FROM MEDIATYPE WHERE MEDIATYPEID = M_ID;
            RETURN M_LENGTH;
        END;

---- create or replace procedure add_person(
--firstname in varchar2,
--lastname in varchar2,
--songid in number)
--as begin
--insert into example(firstname, lastname, fav_song_id)
--values(fn, ln, songid);
--commit
