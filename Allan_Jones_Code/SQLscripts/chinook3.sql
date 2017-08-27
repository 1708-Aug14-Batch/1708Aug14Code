SELECT ex_id FROM example WHERE lower(firstname) = lower('Genesis');
--
CREATE OR REPLACE FUNCTION findID(fn IN VARCHAR2)
  RETURN NUMBER
IS
  person_id NUMBER;
  CURSOR c1
  IS
    SELECT ex_id FROM example WHERE lower(firstname) = lower(fn);
BEGIN
  OPEN c1;
  FETCH c1 INTO person_id;
  IF c1%notfound THEN
    person_id := -1;
  END IF;
CLOSE c1;
RETURN person_id;
END;

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


select ex.ex_id, ex.firstname, ex.lastname, tr.name
from example ex
left join track tr on ex.fave_song_id = tr.trackid;

