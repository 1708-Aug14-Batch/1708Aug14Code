
-- Delete a record in Customer table where the name
-- is Robert Walter (There may be constraints that
-- rely on this, find out how to resolve them).
ALTER TABLE INVOICE
DROP CONSTRAINT FK_INVOICECUSTOMERID;

DELETE FROM CUSTOMER
WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter';
