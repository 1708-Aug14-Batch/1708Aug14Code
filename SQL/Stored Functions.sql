
CREATE OR REPLACE FUNCTION findPerson
(firstName IN VARCHAR2)
RETURN NUMBER
IS
person_id NUMBER;
CURSOR c1 IS
SELECT example_id
FROM example
WHERE lower(firstname) = lower(firstName);
BEGIN
OPEN c1;
FETCH c1 INTO person_id;
IF c1%notfound THEN
person_id := -1;
END IF;
CLOSE c1;
RETURN person_id;
END;
