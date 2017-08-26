
-- 7.1 INNER --
-- Create an inner join that joins customers and orders
-- and specifies the name of the customer and the invoiceId.
SELECT CUST.FIRSTNAME, CUST.LASTNAME, INV.INVOICEID
FROM CUSTOMER CUST
INNER JOIN INVOICE INV ON CUST.CUSTOMERID = INV.CUSTOMERID;

-- 7.2 OUTER --
-- Create an outer join that joins the customer and invoice table,
-- specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT CUST.CUSTOMERID, CUST.FIRSTNAME, CUST.LASTNAME, INV.INVOICEID, INV.TOTAL
FROM CUSTOMER CUST
FULL OUTER JOIN INVOICE INV ON CUST.CUSTOMERID = INV.CUSTOMERID;

-- 7.3 RIGHT --
-- Create a right join that joins album and artist
-- specifying artist name and title.
SELECT ART.NAME, ALB.TITLE FROM ALBUM ALB
RIGHT JOIN ARTIST ART ON ALB.ARTISTID = ART.ARTISTID;

-- 7.4 CROSS --
-- Create a cross join that joins album and artist and sorts
-- by artist name in ascending order.
SELECT * FROM ALBUM
CROSS JOIN ARTIST
ORDER BY ARTIST.NAME;

-- 7.5 SELF --
-- Perform a self-join on the employee table,
-- joining on the reportsto column.
SELECT * FROM EMPLOYEE E1
INNER JOIN EMPLOYEE E2 ON E1.EMPLOYEEID = E2.REPORTSTO;
