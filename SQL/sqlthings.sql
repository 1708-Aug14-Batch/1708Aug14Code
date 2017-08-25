CREATE VIEW tracklist AS
SELECT * FROM track WHERE lower(name) LIKE '% for %';
SELECT * FROM tracklist;
CREATE VIEW albumlist AS
SELECT * FROM album WHERE albumid BETWEEN 250 AND 350;
SELECT * FROM albumlist;
SELECT tr.name AS "Track Name" ,
  al.title     AS "Album Title",
  art.NAME     AS "Artist Name",
  g.name       AS "Genre Name",
  pl.NAME "PlayList",
  mt.name AS "MediaType",
  il.UNITPRICE,
  cust.company,
  cust.lastname,
  emp.lastname AS "Employee Name"
FROM TRACK tr
INNER JOIN album al
ON tr.ALBUMID = al.albumid
INNER JOIN artist art
ON art.artistid = al.ARTISTID
INNER JOIN genre g
ON g.GENREID = tr.genreid
INNER JOIN playlisttrack plt
ON plt.trackid = tr.trackid
INNER JOIN playlist pl
ON plt.playlistid = pl.PLAYLISTID
INNER JOIN mediatype mt
ON mt.MEDIATYPEID = tr.MEDIATYPEID
INNER JOIN invoiceline il
ON il.TRACKID = tr.TRACKID
INNER JOIN invoice inv
ON inv.INVOICEID = il.INVOICEID
INNER JOIN customer cust
ON cust.CUSTOMERID = inv.CUSTOMERID
INNER JOIN employee emp
ON emp.employeeid = cust.SUPPORTREPID ;
/
SELECT tr.name AS trackname,
  al.title     AS "Album Title",
  art.name     AS "Artist Name",
  g.name       AS "Genre Name",
  pl.name      AS "PlayList",
  mt.name      AS "MediaType",
  il.unitprice,
  cust.company,
  cust.lastname AS "Customer Name",
  emp.lastname  AS "Employee Name"
FROM track tr
INNER JOIN albumlist al
ON tr.albumid = al.albumid
INNER JOIN artist art
ON art.artistid = al.artistid
INNER JOIN genre g
ON g.genreid = tr.genreid
INNER JOIN playlisttrack plt
ON plt.trackid = tr.trackid
INNER JOIN playlist pl
ON plt.playlistid = pl.playlistid
INNER JOIN mediatype mt
ON mt.mediatypeid = tr.mediatypeid
INNER JOIN invoiceline il
ON il.trackid = tr.trackid
INNER JOIN invoice inv
ON inv.invoiceid = il.invoiceid
INNER JOIN customer cust
ON cust.customerid = inv.customerid
INNER JOIN employee emp
ON emp.employeeid = cust.supportrepid;
SELECT cust.firstname CUSTNAME,
  emp.firstname EMPNAME
FROM employee emp
FULL JOIN customer cust
ON emp.state = cust.state;
-- avg songs per album
SELECT AVG(total)
FROM
  (SELECT COUNT(*) AS total
  FROM track,
    album
  WHERE track.albumid = album.albumid
  GROUP BY album.title
  );
-- find things from track w ascii value
SELECT name
FROM track
WHERE ascii(SUBSTR(name, 1, 1)) = 72;
SELECT name FROM track WHERE name LIKE 'H%';
-- # songs per genre
SELECT t2.name ,
  COUNT(*)
FROM track t1,
  genre t2
WHERE t1.genreid = t2.genreid
GROUP BY t2.name;
-- #song per playlist
SELECT COUNT(playlistid) AS total,
  trackid
FROM playlisttrack
GROUP BY trackid
ORDER BY total;
--
SELECT name,
  counts.total
FROM track
INNER JOIN
  (SELECT COUNT(PLAYLISTID) AS total,
    TRACKID                 AS trackid
  FROM playlisttrack
  GROUP BY TRACKID
  ) counts
ON track.trackid = counts.trackid;
/
SELECT t1.name,
  COUNT(*)
FROM playlist t1,
  playlisttrack
WHERE t1.PLAYLISTID = playlisttrack.PLAYLISTID
GROUP BY t1.NAME;
SELECT * FROM playlisttrack WHERE playlistid = 4;
SELECT * FROM playlist;
--Genesis Bonds SQL Homework.
--2.1 SELECT
--Task – Select all records from the Employee table.
SELECT *
FROM employee;
-- 2.2 Select all records from the Employee table where last name is King.
SELECT *
FROM employee
WHERE lastname = 'King';
--
CREATE INDEX trackname ON track
  (name
  );
DROP INDEX trackname;
/
ALTER TABLE album ADD CONSTRAINT artistid_fk FOREIGN KEY (artistid) REFERENCES artist (artistid) ON
DELETE CASCADE;
ALTER TABLE ALBUM
DROP CONSTRAINT FK_ALBUMARTISTID;
ALTER TABLE ALBUM ADD CONSTRAINT artist_Cascade FOREIGN KEY (artistID) REFERENCES ARTIST(artistid) ON
DELETE CASCADE;
SELECT * FROM example;
INSERT
INTO example
  (
    firstname,
    lastname,
    fave_song_id
  )
  VALUES
  (
    'testing',
    'test',
    152
  );
/
CREATE OR REPLACE PROCEDURE add_person
  (
    fn     IN VARCHAR2,
    ln     IN VARCHAR2,
    songID IN NUMBER
  )
AS
BEGIN
  INSERT
  INTO example
    (
      firstname,
      lastname,
      fave_song_id
    )
    VALUES
    (
      fn,
      ln ,
      songID
    );
  COMMIT;
END add_person;
/
DECLARE
  FN     VARCHAR2(200);
  LN     VARCHAR2(200);
  SONGID NUMBER;
BEGIN
  FN     := 'stored';
  LN     := 'procedure';
  SONGID := 1;
  ADD_PERSON( FN => FN, LN => LN, SONGID => SONGID );
  --rollback;
END;
/
SELECT ex_id FROM example WHERE lower(firstname) = lower('genesis');
SELECT * FROM example;
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
END findPerson;
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
SELECT * FROM example;

insert into example (FIRSTNAME, LASTNAME)
values('autogenerate', 'a key');

select ex.ex_id, ex.firstname, ex.lastname, tr.name
from example ex
left join track tr
on ex.fave_song_id = tr.trackid;
