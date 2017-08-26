create view tracklist as
select * from track where lower(name) like '% for %';

select * from tracklist;

CREATE view albumlist as
select * from album where albumid between 250 and 350;


--INNER JOIN
select tl.name as trackname , al.title as "Album Title"
from TRACKLIST tl
join ALBUMLIST al
on tl.ALBUMID = al.ALBUMID;
--where tl.albumid is null
--or al.ALBUMID is null;

select tl.name as "track name" , al.title as "Album Title" , art.Name as "Artist Name", ge.Name as genre, pl.name as playlist, mt.name as "Media Type",
 il.UNITPRICE, iv.invoiceid, ln.lastname as "Employee lastname",  cs.LASTNAME as "Customer lastname"
from track tl
--inner join track tl on tl.trackid = tl.trackid
inner join ALBUM al on tl.ALBUMID = al.ALBUMID
inner join artist art on art.artistid = al.artistid
inner join GENRE ge on ge.genreid = tl.genreid
inner join PLAYLISTTRACK plt on plt.TRACKID = plt.TRACKID
inner join playlist pl on plt.playlistid = pl.playlistid
inner join mediatype mt on mt.mediatypeid = tl.mediatypeid
inner join INVOICELINE il on il.TRACKID = tl.TRACKID
inner join invoice iv on iv.INVOICEID = il.INVOICEID
inner join CUSTOMER cs on cs.CUSTOMERID = iv.CUSTOMERID
inner join employee ln on ln.EMPLOYEEID = cs.SUPPORTREPID;
--inner join artist art on art.artistid = al.artistid;




--select cust.firstname CUSTNAME, emp.firstname EMPNAME
--from employee emp
--join customer cust on emp.statoup by PLAYLISTID;
select ex_id
from example
where lower(firstname) = lower('rick');

select  * from example;

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
--prop.getP
--select * from example;
--CREATE OR REPLACE FUNCTION findId(
--    fn IN INT)
--  RETURN VARCHAR2
--IS
--  person_name VARCHAR2;
--  CURSOR c2
--  IS
--    SELECT firstname, lastname FROM example WHERE ex_id = fn;
--BEGIN
--  OPEN c2;
--  FETCH c2 INTO person_name;
--  IF c2%notfound THEN
--    person_name := 'null';
--  END IF;
--CLOSE c2;
--RETURN person_name;
--END;
SELECT * FROM example;
insert into example(firstname,lastname)
values('adding', 'things');