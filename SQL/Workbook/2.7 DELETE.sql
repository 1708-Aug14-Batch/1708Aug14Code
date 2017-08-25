
-- Delete a record in Customer table where the name
-- is Robert Walter (There may be constraints that
-- rely on this, find out how to resolve them).
DELETE FROM CUSTOMER
WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter';
