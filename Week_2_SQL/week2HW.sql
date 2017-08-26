--Homework

--2.1 Select
Select * from employee;

Select * from employee
where lastname = 'King';

Select * from employee
where firstname = 'Andrew'
and Reportsto = null;

--2.2 Order By

Select title FROM album
ORDER by title desc;

Select firstname, city from Customer
order by city asc;

--2.3 Insert Into

Insert Into Genre
Values(6969,'Prog Prog Rock');


Insert Into Employee
Values(9999,'Bonds','Andrew','The Coolest',null, '11-Apr-89','11-Apr-17', '23423 Hwy 59 North', 'Kingwood', 'TX','United States',77339,4798716491,9999999999,'apbonds1@gmail.com');


Insert Into Customer
Values(9999,'Bonds','Andrew','Revature','381 Sheridan', 'Winnetka', 'IL', 'United States', 77339, 4798716491,9999999999, 'apbonds1@gmail.com', 3);

--2.4 Update

Update Customer
Set firstname = 'Robert', lastname = 'Walter'
Where firstname = 'Aaron' and lastname = 'Mitchell';

Update Artist
Set NAME = 'CCR'
Where NAME = 'Creedence Clearwater Revival';

--2.5 Like

Select * from Invoice
Where billingaddress Like 'T%';

--2.6 Between

Select * from Invoice
Where total between 15 and 50;

Select * from Employee
Where hiredate between '01-Jun-03' and '01-Mar-04';

--2.7 Delete

Select * from Customer
Where firstname = 'Robert' and lastname = 'Walter';

Select * from Invoice
Where Customerid = 32;

Select * from invoiceline
Where invoiceid = 50;

--Had to delete from the invoiceline table and the invoice table because they were childs of Customer and thus would not let me delete Robert.
Delete from invoiceline
Where invoiceid = 290;
Delete from invoice
Where customerid = 32;
Delete from Customer
Where customerid = 32;


--3.1 System defined functions
create or replace function currentTime
return date is
theTime date;
begin
select sysdate into theTime from dual;
return theTime;
end;

select currentTime() from dual;

create or replace function getLength(mt_id number)
return number is
MLength number;
begin
Select Length(name) into Mlength from mediaType
Where mt_id = mediaTypeid;
return Mlength;
end;


Select getLength(1) from dual;

--3.2 System defined aggragate functions

create or replace function getAverage
return number is
average number(10,2);
begin
select AVG(total)into average from Invoice;
return average;
end;

Select getAverage from dual;

create or replace function getMax
return number is
theMax number;
begin
Select Max(UnitPrice) into theMax from track;
return theMax;
end;

Select getMax from dual;

--3.3 User Defined Scalar Functions
create or replace function invoiceAvg
return number is
theAvg number(10,2);
begin
Select avg(UnitPrice) into theAvg from invoiceline;
return theAvg;
end;

Select invoiceAvg from dual;

--3.4 User defined table valued functions

create or replace function getYear
return date is
birthyear date;
cursor c1
is
Select birthdate into birthyear from employee
Where birthdate > '31-DEC-68';
begin
  open c1;
  Loop
  fetch c1 into birthyear;
  exit when c1%notfound;
  end loop;
close c1;
return birthyear;
End;

select getYear from dual;

--





--4.1 Basic Stored Procedure

create or replace procedure nameSelector( 
fname out varchar,
lname out varchar)
as begin
Select firstname, lastname * into fname, lname from Employee;
END nameSelector;
/

/*4.1*/
CREATE OR REPLACE PROCEDURE ALL_EMPLOYEES(S OUT SYS_REFCURSOR) AS
BEGIN 
    OPEN S FOR
        SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE;
END;
/

/*GET_ALL EMPLOYEE NAMES*/
DBMS_OUTPUT.ENABLE;
DECLARE
      S SYS_REFCURSOR;
      FN EMPLOYEE.FIRSTNAME%TYPE;
      LN EMPLOYEE.LASTNAME%TYPE;
BEGIN  
     ALL_EMPLOYEES(S);
     LOOP
          FETCH S INTO FN, LN;
          EXIT WHEN S%NOTFOUND;
          DBMS_OUTPUT.PUT_LINE(FN||' '||LN);
     END LOOP;
     CLOSE S;
END;
/

DECLARE
  S SYS_REFCURSOR;
BEGIN

  ALL_EMPLOYEES(
    S => S
  );
  /* Legacy output: 
DBMS_OUTPUT.PUT_LINE('S = ' || S);
*/ 
  :S := S; --<-- Cursor
--rollback; 
END;

/
--4.2 Stored Procedures Input Parameters
create or replace procedure update_emp(
empid in number,
fname in varchar2,
lname in varchar2)
as begin
Update employee
Set firstname = fname, lastname = lname
Where employeeid = empid;
commit;
END update_emp;
/

Begin update_emp(2,'more','test');
End;



Create or replace procedure Get_Manager(
empID in number,
fname out varchar2,
lname out varchar2,
t out varchar2)
as begin
Select firstname, lastname, title into fname, lname, t from employee
Where employeeId in(
Select reportsto from employee
Where employeeID = empID);
end Get_manager;
    
    /

DECLARE
firstname varchar2(30);
lastname varchar2(30);
title varchar2(30);
Begin
Get_Manager(8,firstname,lastname,title);
dbms_output.put_line(firstname || ' ' || lastname || ' ' || title);
END;

--4.3 Output Parameters
Create or replace procedure getCustomerInfo(
custID in number,
fname out Varchar2,
lname out Varchar2,
comp out Varchar2)
as Begin
Select firstname, lastname, company into fname, lname, comp from Customer
Where(customerID = custID);
End;

Declare
firstname varchar2(30);
lastname varchar2(30);
company varchar2(200);
Begin
getCustomerInfo(5, firstname,lastname,company);
dbms_output.put_line(firstname || ' ' || lastname || ' ' || company);
End;


--5.0

Alter table invoiceLine
drop constraint FK_INVOICELINEINVOICEID;

Alter table invoiceLine
Add constraint FK_INVOICELINEINVOICEID
  Foreign Key (InvoiceID)
  REFERENCES INVOICE (InvoiceID)
  ON DELETE CASCADE;
  
  rollback;


create or replace procedure deleteInvoice(
invID in number)
as begin
Delete from Invoice
Where invoiceid = invID;
commit;
END;

Begin deleteInvoice(6);
End;


create or replace procedure InsertRecord(
cID in number,
fname in varchar2,
lname in varchar2,
comp in varchar2,
addr in varchar2,
c in varchar2,
st in varchar2,
cou in varchar2,
pcode in number,
phone in number,
fax in number,
email in varchar2,
supportrepid in number
)
as begin
Insert into Customer(customerid,firstname,lastname,company,address,city,state,country,postalcode,phone,fax,email,supportrepid)
values(cID,fname,lname,comp,addr,c,st,cou,pcode,phone,fax,email,supportrepid);
commit;
end;

Begin InsertRecord(5000,'This', 'is', 'a', 'test', 'does', 'IT', 'Work', 77339, 47979797979, 19000533434,'testemail@email.com', 4);
end;
