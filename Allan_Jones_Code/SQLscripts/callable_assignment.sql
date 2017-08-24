CREATE OR REPLACE FUNCTION findPerson(
  id IN NUMBER)
  RETURN String
IS
  person_fn VARCHAR2;
  person_ln VARCHAR2;

  CURSOR c2
  IS
    SELECT FIRSTNAME, LASTNAME FROM example WHERE ex_id = id;
BEGIN
  OPEN c2;
  FETCH c2 INTO person_fn, person_ln;
  IF c2%notfound THEN
    person_fn := " ";
    person_ln := " ";
  END IF;
CLOSE c2;
RETURN person_fn + " " + person_ln;
END;
