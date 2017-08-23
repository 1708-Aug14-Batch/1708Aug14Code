
--ORDER BY
SELECT name
FROM track
ORDER BY milliseconds ASC;

--GROUP BY
SELECT COUNT(customerid), country
FROM CUSTOMER
GROUP BY country;

--WHERE
SELECT t.name, g.name
FROM genre g, track t
WHERE g.genreid = t.genreid;

--HAVING
SELECT COUNT(customerid), country
FROM CUSTOMER
GROUP BY country
HAVING COUNT(customerid) > 3;

--UNION
SELECT title FROM album
UNION
SELECT name FROM track;

--EXISTS / NESTED
SELECT name
FROM artist
WHERE EXISTS
(SELECT name FROM track WHERE name = 'Ace Of Spades');

--LIKE
SELECT name
FROM track
WHERE name LIKE 'A_e%';

--AGGREGATE
SELECT MIN(milliseconds)
FROM track;

--AGGREGATE
SELECT MAX(milliseconds)
FROM track;

--AGGREGATE
SELECT AVG(milliseconds)
FROM track
WHERE name LIKE 'Ace%';

--SCALAR
SELECT MAX(milliseconds) - MIN(milliseconds)
FROM track;

--SCALAR
SELECT MAX(milliseconds) + MIN(milliseconds)
FROM track;

--SCALAR
SELECT MAX(milliseconds) / MIN(milliseconds)
FROM track;