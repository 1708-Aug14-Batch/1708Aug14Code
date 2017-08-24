SELECT * FROM example;
SELECT ex_id FROM example WHERE lower(firstname) = lower('testing');
/
CREATE OR REPLACE FUNCTION findPerson(
    fn IN VARCHAR2)
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
/
CREATE OR REPLACE FUNCTION findPersonNoCursor(
  fn IN VARCHAR2)
RETURN NUMBER
IS
  person_id NUMBER;
BEGIN
  SELECT ex_id INTO person_id FROM example WHERE lower(firstname) = lower(fn);
  RETURN person_id;
END;
/
CREATE OR REPLACE FUNCTION findName(
  eid IN NUMBER)
RETURN VARCHAR2
IS
  person_fn VARCHAR2(100);
  person_ln VARCHAR2(100);
BEGIN
  SELECT firstname,
    lastname
  INTO person_fn,
    person_ln
  FROM example
  WHERE ex_id = eid;
  RETURN person_fn || ' ' || person_ln;
END;
/
INSERT INTO example
  (firstname, lastname
  ) VALUES
  ('adding', 'things'
  );

select * from example;
select example.ex_id, example.firstname, example.lastname, track.name from example 
left join track 
on track.trackid = example.fave_song_id;