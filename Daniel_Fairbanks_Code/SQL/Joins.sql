CREATE VIEW TrackList AS
SELECT * FROM Track WHERE lower(Name) LIKE  '% for %';

SELECT * FROM TrackList;

CREATE VIEW AlbumList AS
SELECT * FROM Album WHERE AlbumID BETWEEN 250 AND 350;

SELECT * FROM AlbumList;

--ALL TRACKS W/O ALBUMS AND ALBUMS W/O TRACKS
SELECT TrackList.Name AS "Track Name", AlbumList.Title AS "Album Title"
FROM TrackList
FULL OUTER JOIN AlbumList
ON TrackList.AlbumID = AlbumList.AlbumID
WHERE TrackList.AlbumID IS NULL
OR AlbumList.AlbumID IS NULL;

--ALL TRACKS WITH ALBUMS AND ALBUMS WITH TRACKS
SELECT TrackList.Name AS "Track Name", AlbumList.Title AS "Album Title"
FROM TrackList
INNER JOIN AlbumList
ON TrackList.AlbumID = AlbumList.AlbumID;

--ALL ALBUMS THAT AREN'T NULL
SELECT TrackList.Name AS "Track Name", AlbumList.Title AS "Album Title"
FROM TrackList
RIGHT JOIN AlbumList
ON TrackList.AlbumID = AlbumList.AlbumID;

--ALL TRACKS THAT AREN'T NULL
SELECT TrackList.Name AS "Track Name", AlbumList.Title AS "Album Title"
FROM TrackList
LEFT JOIN AlbumList
ON TrackList.AlbumID = AlbumList.AlbumID;

--JOINS 3 TABLES WITH ALL 3 FIELDS
SELECT Track.Name AS "Track Name", Album.Title AS "Album Title", Artist.Name AS "Artist Name"
FROM Track
INNER JOIN Album ON Track.AlbumID = Album.AlbumID
INNER JOIN Artist ON Artist.ArtistID = Album.ArtistID;

SELECT Track.Name AS "Track Name", Album.Title AS "Album Title", Artist.Name AS "Artist Name"
FROM Track
INNER JOIN Album ON Track.AlbumID = Album.AlbumID
INNER JOIN Artist ON Artist.ArtistID = Album.ArtistID;

SELECT Track.Name AS "Track Name", Album.Title AS "Album Title", Artist.Name AS "Artist Name",
Genre.Name AS "Genre", MediaType.Name AS "Media Type", InvoiceLine.UnitPrice AS "Price"
FROM InvoiceLine
INNER JOIN Invoice ON InvoiceLine.InvoiceID = Invoice.InvoiceID
INNER JOIN Customer ON Invoice.CustomerID = Customer.CustomerID
INNER JOIN Employee ON Customer.SupportRepID = Employee.EmployeeID
INNER JOIN Track ON InvoiceLine.TrackID = Track.TrackID
INNER JOIN Album ON Track.AlbumID = Album.AlbumID
INNER JOIN Artist ON Artist.ArtistID = Album.ArtistID
INNER JOIN Genre ON Track.GenreID = Genre.GenreID
INNER JOIN MediaType ON Track.MediaTypeID = MediaType.MediaTypeID
INNER JOIN PlayListTrack plt ON plt.TrackID = Track.TrackID
INNER JOIN PlayList ON plt.PlayListID = PlayList.PlayListID;

--AVG SONGS PER ALBUM
SELECT AVG(Total) FROM (SELECT COUNT(*) AS Total FROM Track, Album
WHERE Track.AlbumID = Album.AlbumID GROUP BY Album.Title);

--FIND THINGS FROM GENRE W/ ASCII VALUE
SELECT Name FROM Track
WHERE ASCII(substr(Name, 1, 1)) = 72;
--LIKE ABOVE BUT ORDERS RESULTS
SELECT Name FROM Track WHERE Name LIKE 'H%' ORDER BY Track.Name ASC;

--SONGS PER GENRE
SELECT t2.Name, COUNT(*) FROM Track t1, Genre t2
WHERE t1.GenreID = t2.GenreID
GROUP BY t2.Name;

--NUMBER OF PLAYLISTS SONG APPEARS ON
SELECT COUNT(PlayListID) AS Total, TrackID
FROM PlayListTrack GROUP BY TrackID
ORDER BY Total;

SELECT t1.Name, COUNT(*)
FROM PlayList t1, PlayListTrack
WHERE t1.PlayListID = PlayListTrack.PlayListID
GROUP BY t1.Name;

--INDEX
CREATE INDEX TrackName ON Track(Name);
DROP INDEX TrackName;

--FUNCTIONS
SELECT * FROM Example;


CREATE OR REPLACE PROCEDURE AddPerson
(
fn IN VARCHAR2,
ln IN VARCHAR2,
songID IN NUMBER
)
AS BEGIN
INSERT INTO Example (Firstname, Lastname, Favorite_Song_ID)
VALUES (fn, ln, songID);
commit;
END AddPerson;
/

DECLARE
  FN VARCHAR2(200);
  LN VARCHAR2(200);
  SONGID NUMBER;
BEGIN
  FN := 'Method';
  LN := 'Method';
  SONGID := 1;

  ADDPERSON(
    FN => FN,
    LN => LN,
    SONGID => SONGID
  );
--rollback; 
END;
/

SELECT ex.Ex_ID, ex.Firstname, ex.Lastname, tr.Name
FROM Example ex
INNER JOIN Track tr
ON ex.Favorite_Song_ID = tr.TrackID;

SELECT * FROM Example;
SELECT Ex_ID FROM Example WHERE lower(Firstname) = lower('daniel');

--FUNCTION EXAMPLE
CREATE OR REPLACE FUNCTION findPerson(
    fn IN VARCHAR2 )
  RETURN NUMBER
IS
  person_id NUMBER;
  CURSOR c1
  IS
    SELECT Ex_ID FROM Example WHERE lower(Firstname) = lower(fn);
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
--END FUNCTION EXAMPLE
CREATE OR REPLACE FUNCTION getName(
    id IN NUMBER )
  RETURN VARCHAR2
IS
  name VARCHAR2(242);
  CURSOR c1
  IS
    SELECT concat(Firstname, concat(' ', Lastname)) FROM Example;-- WHERE Ex_ID = id;
BEGIN
  OPEN c1;
  FETCH c1 INTO name;
  IF c1%notfound THEN
    name := '';
  END IF;
CLOSE c1;
RETURN name;
END;
/
--SECOND EXAMPLE WITH NO CURSOR
CREATE OR REPLACE FUNCTION findPersonNoCursor (
fn IN VARCHAR2)
RETURN NUMBER
IS
person_id NUMBER;
BEGIN
SELECT Ex_ID INTO person_id FROM Example WHERE lower(Firstname) = lower(fn);
RETURN person_id;
END;
/

INSERT INTO Example (Firstname, Lastname)
VALUES ('adding', 'things');

SELECT ex.Ex_ID, ex.Firstname, ex.Lastname, tr.Name
FROM Example ex
LEFT JOIN Track tr
ON Ex.Favorite_Song_ID = tr.TrackID;


SELECT * FROM Example;