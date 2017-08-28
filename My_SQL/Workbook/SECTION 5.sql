
-- Create a transaction that given a invoiceId will delete that invoice
-- (There may be constraints that rely on this, find out how to resolve them).
CREATE OR REPLACE PROCEDURE DELETE_INV (ID IN NUMBER)
AS
BEGIN
  SET TRANSACTION NAME 'Delete Invoice';
    DELETE FROM INVOICELINE WHERE INVOICEID = ID;
    DELETE FROM INVOICE WHERE INVOICEID = ID;
  COMMIT;
END;
/
EXECUTE DELETE_INV(2);

-- Create a transaction nested within a stored procedure
-- that inserts a new record in the Customer table
CREATE OR REPLACE PROCEDURE NEW_CUSTOMER
(ID IN NUMBER, FNAME IN VARCHAR2, LNAME IN VARCHAR2, EML IN VARCHAR2)
AS
BEGIN
  SET TRANSACTION NAME 'Insert Customer';
    INSERT INTO CUSTOMER (CUSTOMERID, FIRSTNAME, LASTNAME, EMAIL)
    VALUES (ID, FNAME, LNAME, EML);
  COMMIT;
END;
/
EXECUTE NEW_CUSTOMER(999, 'Jimi', 'Hendrix', 'jimi@hendrix.com');
