
--
INSERT INTO example(firstname, lastname) values("John", "Snow");

--
CREATE OR REPLACE FUNCTION findPerson(personID IN NUMBER)
RETURN VARCHAR2
IS
firstName VARCHAR2;
CURSOR c1 IS
SELECT firstname
FROM example
WHERE person_id = personID;
BEGIN
OPEN c1;
FETCH c1 INTO firstName;
IF c1%notfound THEN
firstName := 'Not found';
END IF;
CLOSE c1;
RETURN firstName;
END findPerson;
