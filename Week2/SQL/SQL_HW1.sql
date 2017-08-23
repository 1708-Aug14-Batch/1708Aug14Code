--SQL HomeWork

--Order By
SELECT * FROM ARTIST
ORDER BY NAME DESC;

--Group By
SELECT COUNT(TRACKID), NAME
FROM TRACK
GROUP BY NAME;

--Where
SELECT * FROM Customer
WHERE Country='Germany';

--Having
SELECT COUNT(CustomerID), Country
FROM Customer
GROUP BY Country
HAVING COUNT(CustomerID) > 5
ORDER BY COUNT(CustomerID) DESC;

--Union
Select Title from Album
Union
Select Name from Genre;

--Exists
SELECT TITLE
FROM ALBUM
WHERE EXISTS (SELECT ARTISTID FROM ARTIST 
              WHERE ARTISTID = ALBUM.ARTISTID
              AND NAME = 'AC/DC');
--Like/Wildcard
SELECT * FROM Customer
WHERE LastName LIKE 'G%';
SELECT SUM(UNITPRICE) FROM INVOICELINE;
SELECT COUNT(*) FROM INVOICELINE;
SELECT AVG(UNITPRICE) FROM INVOICELINE;

--3 Aggregate Funtions

--3 Scalar Functions
SELECT FIRSTNAME, LENGTH(FIRSTNAME) AS "First Name Length"
FROM CUSTOMER;

select * from customer
where upper(firstname) like 'A%';

select upper(firstname) from Customer;

select lower(lastname) from Examlpe;

--Nested Query
SELECT TITLE FROM ALBUM
WHERE ARTISTID IN (SELECT ARTISTID FROM ARTIST WHERE NAME = 'AC/DC');