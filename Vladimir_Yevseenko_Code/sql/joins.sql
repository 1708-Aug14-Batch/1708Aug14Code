CREATE VIEW tracklist AS
SELECT * FROM track WHERE LOWER(name) LIKE '% for %';

CREATE VIEW albumlist AS
SELECT * FROM album WHERE albumid BETWEEN 250 AND 350;


SELECT track.name as "Track Name", album.title as "Album Title", artist.name as "Artist Name"
FROM track track
INNER JOIN album album ON track.albumid = album.albumid
INNER JOIN artist artist ON artist.artistid = album.artistid;

DROP TABLE example;

SELECT customer.firstname AS "Customer First",
  employee.firstname AS "Employee First",
  invoice.invoicedate AS "Invoice Date",
  invoiceline.quantity AS "Invoice Quantity",
  track.name AS "Track Name",
  album.title AS "Album Title",
  artist.name AS "Artist Name",
  genre.name AS "Genre",
  mediatype.name AS "Media Type",
  playlist.name AS "Playlist"
  FROM track
  INNER JOIN album ON track.albumid = album.albumid
  INNER JOIN mediatype ON track.mediatypeid = mediatype.mediatypeid
  INNER JOIN playlisttrack ON track.trackid = playlisttrack.trackid
  INNER JOIN playlist ON playlisttrack.playlistid = playlist.playlistid
  INNER JOIN invoiceline ON track.trackid = invoiceline.trackid
  INNER JOIN invoice ON invoiceline.invoiceid = invoice.invoiceid
  INNER JOIN customer ON invoice.customerid = customer.customerid
  INNER JOIN employee ON customer.supportrepid = employee.employeeid
  INNER JOIN genre ON track.genreid = genre.genreid
  INNER JOIN artist ON album.artistid = artist.artistid
  ORDER BY invoice.invoicedate;
  
  SELECT customer.firstname AS "Customer First",
  customer.lastname AS "Customer Last",
  employee.firstname AS "Employee First",
  employee.lastname AS "Employee Last"
  FROM customer 
  JOIN employee ON customer.state = employee.state;
  
  
  

