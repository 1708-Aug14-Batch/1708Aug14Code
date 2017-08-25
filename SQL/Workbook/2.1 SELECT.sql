
-- Select all records from the Employee table.
SELECT * FROM EMPLOYEE;

-- Select all records from the Employee table
-- where last name is King.
SELECT * FROM EMPLOYEE
WHERE UPPER(LASTNAME) LIKE 'KING';

-- Select all records from the Employee table
-- where first name is Andrew and REPORTSTO is NULL.
SELECT * FROM EMPLOYEE
WHERE UPPER(FIRSTNAME) LIKE 'ANDREW'
  AND REPORTSTO IS NULL;
