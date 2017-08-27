CREATE OR REPLACE FUNCTION findFavSong(id IN NUMBER)
  RETURN String
IS
  person_fn VARCHAR2(30);
  person_ln VARCHAR2(30);

  CURSOR c2 IS
    SELECT ex.ex_id,
  ex.firstname,
  ex.lastname,
  tr.name
FROM example ex
LEFT JOIN track tr
ON ex.fave_song_id = tr.trackid;

BEGIN
  OPEN c2;
  FETCH c2 INTO person_fn, person_ln;
  IF c2%notfound THEN
    person_fn := '';
    person_ln := '';
  END IF;
  CLOSE c2;
  RETURN person_fn || ' ' || person_ln;
END;
