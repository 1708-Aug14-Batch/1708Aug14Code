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
Create Function getCurrentTime{


};

