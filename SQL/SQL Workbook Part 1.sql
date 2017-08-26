-- Connor Monson
-- 8/23/17

-- Section 2.0 SQL Querries 14

-- 2.1 SELECT
SELECT * FROM employee;
SELECT * FROM employee WHERE lastname = 'King';
SELECT * FROM employee WHERE firstname = 'Andrew' and REPORTSTO IS NULL;

-- 2.2 ORDER BY
SELECT * FROM album ORDER BY title DESC;
SELECT firstname FROM customer ORDER BY city ASC;

-- 2.3 INSERT INTO
INSERT INTO genre(genreid, name) VALUES(26, 'Nightcore');
INSERT INTO genre(genreid, name) VALUES(27, 'Techno');

INSERT INTO employee (EmployeeId, LastName, FirstName, Title, BirthDate, HireDate, Address, City, State, Country, PostalCode, Phone, Fax, Email)
  VALUES (9, 'William', 'Scott', 'Superior Manager', TO_DATE('1989-8-04 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('2009-5-27 00:00:00','yyyy-mm-dd hh24:mi:ss'), '11120 Jasper Ave NW', 'Edmonton', 'AB', 'Canada', 'T5K 2N1', '+1 (780) 428-9482', '+1 (360) 123-4567', 'william@chinookcorp.com');
INSERT INTO employee (EmployeeId, LastName, FirstName, Title, BirthDate, HireDate, Address, City, State, Country, PostalCode, Phone, Fax, Email)
  VALUES (10, 'David', 'Smith', 'Superior Programmer', TO_DATE('1974-1-26 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('2013-4-06 00:00:00','yyyy-mm-dd hh24:mi:ss'), '11120 Jasper Ave NW', 'Edmonton', 'AB', 'Canada', 'T5K 2N1', '+1 (780) 428-9482', '+1 (801) 321-7654', 'david@chinookcorp.com');

INSERT INTO Customer (CustomerId, FirstName, LastName, Company, Address, City, State, Country, PostalCode, Phone, Fax, Email, SupportRepId)
  VALUES (60, 'Scott', 'Smith', 'Revature', 'Av. Brigadeiro Faria Lima, 2170', 'São José dos Campos', 'SP', 'Brazil', '12227-000', '+55 (12) 3923-5555', '+55 (12) 3923-5566', 'scott@mail.com', 3);
INSERT INTO Customer (CustomerId, FirstName, LastName, Company, Address, City, State, Country, PostalCode, Phone, Fax, Email, SupportRepId)
  VALUES (61, 'Matthew', 'Wheeler', 'Revature', 'Av. Brigadeiro Faria Lima, 2170', 'São José dos Campos', 'SP', 'Brazil', '12227-000', '+55 (12) 3923-5555', '+55 (12) 3923-5566', 'mathew@mail.com', 3);
SELECT * FROM customer;

-- 2.4 UPDATE
UPDATE customer SET firstname = 'Robert', lastname = 'Walter' WHERE firstname = 'Aaron' AND lastname = 'Mitchell';
UPDATE artist SET name = 'CCR' WHERE name = 'Creedence Clearwater Revival';

-- 2.5 LIKE
SELECT * FROM invoice WHERE billingaddress LIKE 'T%';

-- 2.6 BETWEEN
SELECT * FROM invoice WHERE total BETWEEN 15 AND 50;
SELECT * FROM employee WHERE hiredate BETWEEN TO_DATE('2003-6-01 00:00:00','yyyy-mm-dd hh24:mi:ss') AND TO_DATE('2004-3-01 00:00:00','yyyy-mm-dd hh24:mi:ss');

-- 2.7 DELETE
ALTER TABLE Invoice DROP CONSTRAINT FK_InvoiceCustomerId;
ALTER TABLE Invoice ADD CONSTRAINT FK_InvoiceCustomerId
    FOREIGN KEY (CustomerId) REFERENCES Customer (CustomerId) ON DELETE CASCADE;
ALTER TABLE InvoiceLine DROP CONSTRAINT FK_InvoiceLineInvoiceId;
ALTER TABLE InvoiceLine ADD CONSTRAINT FK_InvoiceLineInvoiceId
    FOREIGN KEY (InvoiceId) REFERENCES Invoice (InvoiceId) ON DELETE CASCADE;
DELETE FROM customer WHERE firstname = 'Robert' AND lastname = 'Walter';
/

-- Section 3.0 SQL Functions 6

-- 3.1 System Defined Functions
create or replace FUNCTION get_current_time(datetime OUT VARCHAR2) 
RETURN VARCHAR2
IS
BEGIN  
    datetime := CURRENT_TIMESTAMP;
    RETURN datetime;
END;
/
create or replace FUNCTION get_mediatype_length(len OUT VARCHAR2)
RETURN NUMBER
IS
BEGIN
  SELECT LENGTH(name) INTO len FROM mediatype;
END;
/

-- 3.2 System Defined Aggregate Functions
create or replace FUNCTION avg_total_invoices(average OUT NUMBER)
RETURN NUMBER
IS
BEGIN
  SELECT avg(total) INTO average FROM invoice;
END;
/

create or replace FUNCTION most_expensive_track(most_exp OUT NUMBER)
RETURN NUMBER
IS
BEGIN
  SELECT max(unitprice) INTO most_exp FROM track;
END;
/

-- 3.3 User Defined Scalar Functions
create or replace FUNCTION average_total_invoices2(average OUT NUMBER)
RETURN NUMBER
IS
x NUMBER := 0;
average NUMBER := 0;
maximum NUMBER := SELECT COUNT(*) FROM invoiceline;
BEGIN
  LOOP
    x := x + 1;
    average := average + SELECT ROUND(unitprice, 2) FROM invoiceline WHERE x = invoiceid;
    EXIT WHEN x = maximum;
  END LOOP;
  average := average / x;
END;
/

-- 3.4 User Defined Table Valued Functions
create or replace FUNCTION get_employees(employees OUT employee.employeeid%TYPE)
RETURN employee.employeeid%TYPE
IS
BEGIN
  SELECT firstname INTO employees FROM employee WHERE birthdate > TO_DATE('1968-1-01 00:00:00','yyyy-mm-dd hh24:mi:ss');
END;
/


-- Section 4.0 Stored Procedures 4

-- 4.1 Basic Stored Procedure
create or replace PROCEDURE select_names(
      firstname OUT employee.firstname%TYPE, 
      lastname OUT employee.lastname%TYPE)
IS
BEGIN
SELECT firstname, lastname into firstname, lastname FROM employee;
END;
/

-- 4.2 Stored Procedure Input Parameters
create or replace PROCEDURE update_employee(
    targetEmployeeId IN NUMBER,
    LastName IN VARCHAR2,
    FirstName IN VARCHAR,
    Title IN VARCHAR2,
    ReportsTo IN NUMBER,
    BirthDate IN DATE,
    HireDate IN DATE,
    Address IN VARCHAR2,
    City IN VARCHAR2,
    State IN VARCHAR2,
    Country IN VARCHAR2,
    PostalCode IN VARCHAR2,
    Phone IN VARCHAR2,
    Fax IN VARCHAR2,
    Email IN VARCHAR2)
IS
BEGIN
  update employee
  SET lastname=lastname, firstname=firstname, title=title, reportsTo=reportsTo,
      birthDate=birthDate, hireDate=hireDate, address=address, city=city,
      state=state, country=country, postalCode=postalCode, phone=phone,
      fax=fax, email=email
  WHERE employeeid = targetEmployeeId;
END;
/

create or replace PROCEDURE get_managers(employeeId IN NUMBER,
    managerId OUT employee.reportsTo%TYPE)
IS
BEGIN
  SELECT reportsTo INTO managerId FROM employee WHERE employeeId=employee.employeeId;
END;
/

-- 4.3 Stored Procedure Output Parameters
create or replace PROCEDURE get_managers(customerId IN NUMBER,
    firstname OUT customer.firstname%TYPE,
    lastname OUT customer.lastname%TYPE,
    company OUT customer.company%TYPE)
IS
BEGIN
  SELECT firstname, lastname, company INTO firstname, lastname, company
    FROM customer WHERE customerId=customer.customerId;
END;
/


-- Section 5.0 Transactions 2
DECLARE
  InvoiceId_int NUMBER;
BEGIN
  InvoiceId_int := 410;
  COMMIT;
  SET TRANSACTION READ WRITE;
  DELETE FROM invoice WHERE invoiceId = InvoiceId_int;
  COMMIT;
END;
/

create or replace PROCEDURE create_customer
IS
BEGIN
  COMMIT;
  SET TRANSACTION READ ONLY;
  INSERT INTO Customer (CustomerId, FirstName, LastName, Company, Address, City, State, Country, PostalCode, Phone, Fax, Email, SupportRepId)
    VALUES (60, 'David', 'Ronaldson', 'Revature', 'Av. Brigadeiro Faria Lima, 2170', 'São José dos Campos', 'SP', 'Brazil', '12227-000', '+55 (12) 3923-5555', '+55 (12) 3923-5566', 'david@revature.com', 3);
  COMMIT;
END;
/


-- Section 6.0 Triggers

-- 6.1 AFTER/FOR 3
CREATE OR REPLACE TRIGGER employee_added AFTER
  INSERT ON employee BEGIN dbms_output.put_line('Employee added');
END;
/

CREATE OR REPLACE TRIGGER album_added AFTER
  INSERT ON album BEGIN dbms_output.put_line('Record added');
END;
/

CREATE OR REPLACE TRIGGER customer_deleted AFTER
  DELETE ON customer BEGIN dbms_output.put_line('Customer deleted');
END;
/


-- Section 7.0 Joins 5

-- 7.1 INNER
SELECT customer.firstname, customer.lastname, invoice.invoiceid
FROM customer
INNER JOIN invoice
ON customer.customerid=invoice.customerid
/

-- 7.2 OUTER
SELECT customer.customerid, customer.firstname, customer.lastname, invoice.invoiceid, invoice.total
FROM invoice
LEFT OUTER JOIN customer
ON customer.customerid=invoice.customerid;
/


-- 7.3 RIGHT
SELECT artist.name, album.title
FROM artist
RIGHT JOIN album
ON artist.artistid=album.artistid;
/


-- 7.4 CROSS
SELECT * 
FROM album
CROSS JOIN artist ORDER BY artist.name;
/


-- 7.5 SELF
SELECT *
FROM employee e1
LEFT OUTER JOIN employee e2
ON e1.reportsto=e2.employeeid;
/
