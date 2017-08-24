
create view tracklist as
select * from track where lower(name) like '% for %';

select * from tracklist;

create view albumlist as
select * from album where albumid between 250 AND 350;

select * from albumlist;

-- Inner Joins

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


-- Procedure

CREATE OR REPLACE PROCEDURE add_person(
    fn     IN VARCHAR2,
    ln     IN VARCHAR2,
    songID IN NUMBER)
AS
BEGIN
  INSERT
  INTO example
    (
      first_name,
      last_name,
      favorite_song_ID
    )
    VALUES
    (
      fn,
      ln,
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
  SONGID := 123;
  add_person(FN, LN, SONGID);
END;

SELECT * FROM example;

-- functions/procedures continued

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

SELECT * FROM example;

SELECT ex.ex_id, ex.firstname, ex.lastname, tr.name
FROM example ex
LEFT JOIN track tr
ON ex.favorite_song_id = tr.trackid;
