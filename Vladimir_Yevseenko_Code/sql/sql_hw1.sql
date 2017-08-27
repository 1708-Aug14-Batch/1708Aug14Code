/* 2.1 */

/* Task - Select all records from the Employee table */
SELECT * FROM employee;


/* Task - Select all records fro the Employee table where last name is King */
SELECT * FROM employee WHERE lastname = 'King';


/* Task - Select all record from the Employee table where first name is Andrey and REPORTSTO is NULL */
SELECT * FROM employee WHERE firstname = 'Andrew' AND reportsto IS NULL;

/* 2.1 end */


/* 2.2 */

/* Task - Select all albums in album table and sort result set in descending order by title */
SELECT * FROM album ORDER BY title DESC;


/* Task - Select first name from Customer and sort result set in ascending order by city */
SELECT firstname FROM customer ORDER BY city;

/* 2.2 end */


/* 2.3 */

/* Task - Insert two new records into Genre table */
INSERT INTO genre VALUES (26, 'Funkpop');
INSERT INTO genre VALUES (27, 'DanceRock');


/* Task - Insert two new records into the Employee Table */
INSERT INTO employee VALUES (9, 'Yevseenko', 'Vladimir',
'Trainee', 6, DATE '1995-10-28', DATE '2017-08-14', 
'3165 Nostrand Ave Apt 3C', 'Brooklyn', 'NY', 'USA',
'11229', '+1 (347) 784-1612', NULL, 'yevseenko.vladimir@gmail.com');

INSERT INTO employee VALUES (10, 'Helper', 'Vlads',
'Helper', 9, DATE '1995-01-23', DATE '2015-03-17',
'11730 Plaza America Dr #205', 'Reston', 'VA', 'USA',
'20190', '+1 (347) 161-2784', '+1 (347) 127-8461', 'vlads.helper@revature.com');


/* Task - Insert two new records into Customer table */
INSERT INTO customer VALUES (60, 'Vladimir', 'Yevseenko',
'Revature', '3165 Nostrand Ave Apt 3C', 'Brooklyn',
'NY', 'USA', '11229', '+1 (347) 784-1612', NULL,
'yevseenko.vladimir@gmail.com', 5);

INSERT INTO customer VALUES (61, 'Generic', 'Customer',
'FooBar Inc', '123 Smith St', 'Dimsdale', 'VA', 'USA',
'11223', '+1 (347) 701-3839', NULL, 'generic.customer@gmail.com',
3);

/* 2.3 end */


/* 2.4 */

/* Task - Update Aaron Mitchell in customer table to Robert Walter */
UPDATE customer SET firstname = 'Robert', lastname = 'Walter'
WHERE firstname = 'Aaron' AND lastname = 'Mitchell';

/* Task - Update name of artists in the artist table t "Creedence Clearwater Revival" to "CCR" */
UPDATE artist SET name = 'CCR'
WHERE name = 'Creedence Clearwater Revival';

/* 2.4 end */


/* 2.5 */

/* Task - select all invoices with a billing address like "T%" */
SELECT * FROM invoice WHERE billingaddress LIKE 'T%';

/* 2.5 end */


/* 2.6 */

/* Task - select all invoices that have a total between 15 and 50 */
SELECT * FROM invoice WHERE total BETWEEN 15 AND 50;

/* Task - select all employees hired between 1st of June 2003 and 1st of March 2004 */
SELECT * FROM employee WHERE hiredate BETWEEN TO_DATE('2003-06-01', 'YYYY-MM-DD') 
AND TO_DATE('2004-03-01', 'YYYY-MM-DD');

/* 2.6 end */


/* 2.7 */

/* Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them). */
/* invoiceline is a child table of invoice which is a child of customer 
  in order to delete a customer we must alter the constraints on the other table
  foreign keys to make then cascade on delete */
ALTER TABLE invoiceline DROP CONSTRAINT fk_invoicelineinvoiceid;

ALTER TABLE invoiceline ADD CONSTRAINT fk_invoicelineinvoiceid
FOREIGN KEY (invoiceid) REFERENCES invoice (invoiceid) ON DELETE CASCADE;

ALTER TABLE invoice DROP CONSTRAINT fk_invoicecustomerid;

ALTER TABLE invoice ADD CONSTRAINT fk_invoicecustomerid 
FOREIGN KEY (customerid) REFERENCES customer (customerid) ON DELETE CASCADE;

/* we can finally remove the entry */
DELETE FROM customer WHERE firstname = 'Robert' AND lastname = 'Walter';

/* 2.7 end */



/* 3.1 */

/* Task – Create a function that returns the current time. */
CREATE FUNCTION cur_time
RETURN DATE
IS
cur_date DATE;
BEGIN
  SELECT SYSDATE INTO cur_date FROM dual;
  RETURN cur_date;
END;
/* test of the function below, otuputs current date and time correctly */
SELECT TO_CHAR(cur_time(), 'DD-MON-YYYY HH:MI:SS') FROM dual;


/* Task – create a function that returns the length of a mediatype from the mediatype table 
  I interpreted this as given the id of a mediatype, return the length of its name */
CREATE FUNCTION mediatypeLengthFromId(id IN NUMBER)
RETURN NUMBER
IS
len NUMBER;
BEGIN
  SELECT LENGTH(name) INTO len FROM mediatype WHERE mediatype.mediatypeid = id;
  RETURN len;
END;
/* test */
SELECT mediatypeLengthFromId(1) FROM DUAL;

/* 3.1 end */



/* 3.2 */

/* Task – Create a function that returns the average total of all invoices */
CREATE OR REPLACE FUNCTION avgTotalOfInvoices
RETURN NUMBER
IS
cnt NUMBER;
total NUMBER;
BEGIN
  SELECT COUNT(*) INTO cnt FROM invoice;
  SELECT SUM(total) INTO total FROM invoice;
  RETURN total/cnt;
END;
/* test */
SELECT avgTotalOfInvoices() FROM dual;


/* Task – Create a function that returns the most expensive track
  returns the lowest numbered track that has the max price */
CREATE OR REPLACE FUNCTION mostExpensiveTrackId
RETURN NUMBER
IS
id NUMBER;
max NUMBER;
BEGIN
  SELECT MIN(trackid) INTO id FROM track WHERE unitprice = (SELECT MAX(unitprice) FROM track);
  RETURN id;
END;

/* 3.2 end */


/* 3.3 */

/* Task – Create a function that returns the average price of invoiceline items in the invoiceline table */

CREATE FUNCTION invoiceLineAvgUnitPrice
RETURN NUMBER
AS
total NUMBER;
cnt NUMBER;
BEGIN
  SELECT SUM(unitprice) INTO total FROM invoiceline;
  SELECT COUNT(unitprice) INTO cnt FROM invoiceline;
  RETURN total / cnt;
END;

/* 3.3 end */


/* 3.4 */

/* Task – Create a function that returns all employees who are born after 1968. 
  In order to return a table from a function we need a custom table object of employees */
  
CREATE TYPE employee_object IS OBJECT 
(employeeid NUMBER, lastname VARCHAR2(20), firstname VARCHAR2(20),
title VARCHAR2(30), reportsto NUMBER, birthdate DATE, hiredate DATE, address VARCHAR2(70),
city VARCHAR2(40), state VARCHAR2(40), country VARCHAR2(40), postalcode VARCHAR(10),
phone VARCHAR2(24), fax VARCHAR2(24), email VARCHAR2(60));

CREATE TYPE employee_table IS TABLE OF employee_object;

CREATE OR REPLACE FUNCTION getEmployeesBornAfter1968
RETURN employee_table
IS
emp_tab employee_table := employee_table();
n NUMBER := 0;
BEGIN
  for e in (SELECT * FROM employee WHERE birthdate > TO_DATE('1968-12-31', 'yyyy-mm-dd'))
  loop
    emp_tab.extend;
    n := n+1;
    emp_tab(n) := employee_object(e.employeeid, e.lastname, e.firstname, e.title,
    e.reportsto, e.birthdate, e.hiredate, e.address, e.city, e.state, e.country, e.postalcode,
    e.phone, e.fax, e.email);
  end loop;
  return emp_tab;
END;

SELECT * FROM table (getEmployeesBornAfter1968);


/* 3.4 end */



/* 4.1 */

/* Task – Create a stored procedure that selects the first and last names of all the employees */
CREATE TYPE employee_first_last AS OBJECT
(firstname VARCHAR2(20), lastname VARCHAR2(20));

CREATE TYPE employee_first_last_table AS TABLE of employee_first_last;

CREATE OR REPLACE PROCEDURE selectFirstAndLastOfEmployees(tab OUT employee_first_last_table)
IS
BEGIN
  SELECT firstname, lastname INTO tab FROM employee;
END selectFirstAndLastOfEmployees;

/* end 4.1 */


/* 4.2 */
/* Task – Create a stored procedure that updates the personal information of an employee. */

CREATE PROCEDURE update_employee_info(id IN NUMBER, fn IN VARCHAR2, ln IN VARCHAR2,
titl IN VARCHAR2, rprtsto IN NUMBER, bdate IN DATE, hdate IN DATE, addr IN VARCHAR2,
cty IN VARCHAR2, stat IN VARCHAR2, cntry IN VARCHAR2, postal IN VARCHAR2, phn IN VARCHAR2,
fx IN VARCHAR2, eml IN VARCHAR2)
IS
BEGIN
  UPDATE employee SET firstname = fn, lastname = ln, title = titl, reportsto = rprtsto,
  birthdate = bdate, hiredate = hdate, address = addr, city = cty, state = stat, country = cntry,
  postalcode = postal, phone = phn, fax = fx, email = eml WHERE employeeid = id;
END update_employee_info;


/* Task – Create a stored procedure that returns the managers of an employee. */
CREATE PROCEDURE getReportsTo(id IN NUMBER, rprtsto OUT NUMBER)
IS
BEGIN
  SELECT reportsto INTO rprtsto FROM employee WHERE employeeid = id;
END getReportsTo;

/* end 4.2 */




/* 4.3 */
/* Task – Create a stored procedure that returns the name and company of a customer. */
CREATE PROCEDURE getNameAndCompany(id IN NUMBER, fn OUT VARCHAR2, ln OUT VARCHAR2, cmpny OUT VARCHAR2)
IS
BEGIN
  SELECT firstname, lastname, company INTO fn, ln, cmpny FROM customer WHERE customerid = id;
END getNameAndCompany;
/* 4.3 end */



/* 5.0 */
/* Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them). */
/* Since a previous question had us cascade on delete for customer and therefore invoice, there is no constraint anymore */
CREATE PROCEDURE deleteInvoice(id IN NUMBER)
AS
BEGIN
  DELETE FROM invoice WHERE invoiceid = id;
END deleteInvoice;



/* Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table */
CREATE PROCEDURE addCustomer(fn IN VARCHAR2, ln IN VARCHAR2, cmpny IN VARCHAR2, addr IN VARCHAR2,
cty IN VARCHAR2, stat IN VARCHAR2, cntry IN VARCHAR2, pscode IN VARCHAR2,
phn IN VARCHAR2, fx IN VARCHAR2, eml IN VARCHAR2, suprepid IN NUMBER)
AS
BEGIN
  INSERT INTO employee (firstname, lastname, company, address, city, state, country, postalcode,
    phone, fax, email, supportrepid) VALUES (fn, ln, cmpny, addr, cty, stat, cntry, pscode,
    phn, fx, eml, suprepid);
END addCustomer;
/* 5.0 end */


/* 6.1 */

/* Task - create an after insert trigger on the employee table fired after a new record is inserted into the table. */
CREATE TRIGGER announce_insert_trigger AFTER INSERT ON employee
FOR EACH ROW
DECLARE
BEGIN
  DBMS_OUTPUT.PUT_LINE('New employee inserted');
END announce_insert_trigger;


/* Task – Create an after update trigger on the album table that fires after a row is inserted in the table */
CREATE TRIGGER announce_insert_album_trigger AFTER INSERT ON album
FOR EACH ROW
DECLARE
BEGIN
  DBMS_OUTPUT.PUT_LINE('New album inserted');
END announce_insert_album_trigger;
  
/* Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table. */
CREATE TRIGGER announce_delete_trigger AFTER DELETE ON customer
FOR EACH ROW
DECLARE
BEGIN
  DBMS_OUTPUT.PUT_LINE('Customer deleted');
END announce_delete_trigger;

/* 6.1 end */ 



/* 7.0 */

/* Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId. */
SELECT cust.firstname, inv.invoiceid FROM customer cust
INNER JOIN invoice inv ON cust.customerid = inv.customerid;

/* Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total. */
SELECT cust.customerid, cust.firstname, cust.lastname, inv.invoiceid, inv.total FROM customer cust
FULL JOIN invoice inv ON cust.customerid = inv.customerid;

/* Task – Create a right join that joins album and artist specifying artist name and title. */
SELECT art.name, alb.title FROM artist art
RIGHT JOIN album alb ON art.artistid = alb.artistid;

/* Task – Create a cross join that joins album and artist and sorts by artist name in ascending order. */
SELECT art.name FROM artist art
CROSS JOIN album alb ORDER BY art.name;


/* Task – Perform a self-join on the employee table, joining on the reportsto column. */
SELECT * FROM employee e1, employee e2 WHERE e1.reportsto = e2.employeeid;

/* 7.1 end */