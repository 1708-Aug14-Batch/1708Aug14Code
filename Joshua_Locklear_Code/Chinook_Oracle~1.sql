
--Order by
select *
from ALBUM
order by ARTISTID DESC;

--Group by
SELECT * FROM ARTIST
group by NAME;

--Where
select * from CUSTOMER
where LASTNAME = 'Martins';

--Having
select * from EMPLOYEE
GROUP by EMPLOYEEID
HAVING count(EMPLOYEEID) >= 2;

--Union
select * from CUSTOMER
left join INVOICE 
on CUSTOMER.CUSTOMERID = INVOICE.INVOICEID
UNION
Select * from CUSTOMER
Right join INVOICE
on CUSTOMER.CUSTOMERID = INVOICE.INVOICEID;

--wild card
select * from CUSTOMER 
where FIRSTNAME like 'Al%';

--aggregate functions
select avg(TOTAL)
from INVOICE
where CUSTOMERID >= 2;

select COUNT(LASTNAME)
form EMPLOYEE;

select avg(TOTAL)
from INVOICE;

--nested query
select INVOICEID from (select * from INVOICELINE); 



