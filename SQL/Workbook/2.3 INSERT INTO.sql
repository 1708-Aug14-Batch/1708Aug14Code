
-- Insert two new records into Genre table
INSERT INTO GENRE VALUES (26, 'Folk');
INSERT INTO GENRE VALUES (27, 'Hawaiian');

-- Insert two new records into Employee table
INSERT INTO EMPLOYEE (EMPLOYEEID, FIRSTNAME, LASTNAME, REPORTSTO)
VALUES (9, 'Nathan', 'Koszuta', NULL);
INSERT INTO EMPLOYEE (EMPLOYEEID, FIRSTNAME, LASTNAME, STATE)
VALUES (10, 'John', 'Doe', 9);

-- Insert two new records into Customer table
INSERT INTO CUSTOMER (CUSTOMERID, FIRSTNAME, LASTNAME, EMAIL)
VALUES (60, 'Aaron', 'Rodgers', 'rodgers@packers.com');
INSERT INTO CUSTOMER (CUSTOMERID, FIRSTNAME, LASTNAME, EMAIL)
VALUES (61, 'Ty', 'Montgomery', 'montgomery@packers.com');
