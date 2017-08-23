--Order By composer
--where the name has the phrase "in a"
SELECT * FROM TRACK
WHERE NAME LIKE '% in a %'
ORDER BY COMPOSER;

--Group By,
--Shows the number of tracks created by each composer (that is not null)
--with the highest track count at the top
--uses aggregate count
SELECT count(TRACKID), COMPOSER FROM TRACK
where composer is not null
GROUP BY Composer
order by COUNT(TRACKID) desc;

--Nested Querey
-- lists tracks & their compuser where the album title contains the word "in"
SELECT NAME, COMPOSER FROM TRACK
WHERE ALBUMID IN
(SELECT albumid FROM ALBUM
WHERE TITLE like '% in %');

--Nested Querey
-- prints album ID with average song length if the average
-- song length is greater than 4 minutes
SELECT ALBUMID, avg(MILLISECONDS) FROM track
having avg(Milliseconds)>240000
group by albumid;

-- shows all employees and customers names and states
select firstname ||' '|| lastname, state from employee
union
select firstname ||' '|| lastname, state  from customer
where state is not null;

-- shows the shortest song's length in seconds
-- and the longest song in minutes 
SELECT (min(milliseconds)/1000) FROM TRACK
union
select max(milliseconds)/60000 from track;

-- shows employees sorted by hire year and last name
select firstname ||' '|| lastname, hiredate from employee
order by EXTRACT(YEAR FROM hiredate), lastname; 

-- shows artists with songs over 300000 milliseconds
SELECT name FROM artist
WHERE EXISTS
(SELECT name FROM track WHERE composer = artist.name and track.MILLISECONDS > 300000);