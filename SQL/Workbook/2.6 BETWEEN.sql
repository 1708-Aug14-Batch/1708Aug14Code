
-- Select all invoices that have a total between 15 and 50
SELECT * FROM INVOICE
WHERE TOTAL BETWEEN 15 AND 50;

-- Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT * FROM EMPLOYEE
WHERE HIREDATE BETWEEN TO_DATE('06/01/2003', 'MM/DD/YYYY')
  AND TO_DATE('03/01/2004', 'MM/DD/YYYY');
  