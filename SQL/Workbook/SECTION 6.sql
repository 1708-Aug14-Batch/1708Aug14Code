
-- 6.1 AFTER/FOR 3 --

-- Create an after insert trigger on the employee table
-- fired after a new record is inserted into the table.
CREATE OR REPLACE TRIGGER EMP_TRIGGER 
AFTER INSERT ON EMPLOYEE
FOR EACH ROW
BEGIN
  NULL;
END;
/

-- Create an after update trigger on the album table that
-- fires after a row is inserted in the table

CREATE OR REPLACE TRIGGER EMP_TRIGGER 
AFTER INSERT ON EMPLOYEE
FOR EACH ROW
BEGIN
  NULL;
END;
/

-- Create an after delete trigger on the customer table that
-- fires after a row is deleted from the table.

CREATE OR REPLACE TRIGGER EMP_TRIGGER 
AFTER INSERT ON EMPLOYEE
FOR EACH ROW
BEGIN
  NULL;
END;
/
