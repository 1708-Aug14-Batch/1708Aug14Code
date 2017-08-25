create view tracklist as
select * from track where lower(name) like '% for %'

select * from tracklist;

create view albumlist as
select * from album where ALBUMID between 250 and 350;
--
SELECT  tr.name as trackname, al.title as "Album Title"
from tracklist tr
full outer join albumlist al
on tr.ALBUMID = al.ALBUMID;
-- inner join on two tables
SELECT  track.name, album.title
from track
INNER join album
on track.ALBUMID = album.ALBUMID;
-- full outer join where albumid in tracklist is null and albumi is null
SELECT  tr.name as trackname, al.title as "Album Title"
from tracklist tr
full outer join albumlist al
on tr.ALBUMID = al.ALBUMID
where tr.ALBUMID is null or al.albumid is null;
--right join
SELECT  tr.name as trackname, al.title as "Album Title"
from tracklist tr
right join albumlist al
on tr.ALBUMID = al.ALBUMID;
--left join
SELECT  tr.name as trackname, al.title as "Album Title"
from tracklist tr
left join albumlist al
on tr.ALBUMID = al.ALBUMID;
-- inner join on mult tables
SELECT  tr.name as "Track Name", al.title as "Album Title",art.NAME as "Artist Name"
from TRACK tr
inner join album al
on tr.ALBUMID = al.ALBUMID 
inner join artist art on art.ARTISTID = al.ARTISTID;

-- Inner joining all elven tables
select cust.Firstname as "Customer Name", inv.TOTAL invoice, invline.UNITPRICE as "Unit Price", tr.NAME as "Track Name", al.TITLE as "Album Title", ge.NAME as "Genre", emp.LASTNAME as "Support rep", pltr.Trackid as "PLTRid", PL.NAME as "Play List Name", art.NAME as "Artist Name", med.NAME as "Media Name"
from customer cust
inner join invoice inv
on cust.CUSTOMERID = inv.CUSTOMERID
inner join INVOICELINE invline
on invline.INVOICEID = inv.INVOICEID
inner join TRACK tr
on tr.TRACKID = invline.TRACKID
inner join Album al
on al.ALBUMID = tr.ALBUMID
inner join GENRE ge
on ge.GENREID = tr.GENREID
inner join EMPLOYEE emp
on emp.EMPLOYEEID = cust.SUPPORTREPID
inner join PLAYLISTTRACK pltr
on pltr.TRACKID = tr.TRACKID
inner join PLAYLIST PL
on pltr.PLAYLISTID = PL.PLAYLISTID
inner join Artist art
on art.ARTISTID = al.ARTISTID
inner join MEDIATYPE med
on med.MEDIATYPEID = tr.MEDIATYPEID;
--
select * from example 
where lower(firstname) = lower();

-- Functions

create or replace function findPersion(fn in varchar2)
return number
is persion_id number;

CURSOR cl is select ex_id from example where lower(FIRST_NAME) = lower(fn);

begin
open cl;
fetch cl into persion_id;

if cl%notfound then
persion_id := -1;
end if;
close c1;
return persion_id;
end findPersion;
/
------------------------------------

create or replace function findPersonNo(fn in varchar2)
return number
is persion_id
begin
select ex_id into person_id from example where lower(FIRST_NAME) = lower(fn)
return persion_id;
end;
/
select * from example

insert into example(firstName, LastName)
values('Adding','THings');

CREATE SEQUENCE EX_ID_SEQ
INCREMENT BY 1
START WITH 1;

CREATE OR REPLACE TRIGGER EX_ID_TRIGGER
BEFORE INSERT ON EXAMPLE
FOR EACH ROW
BEGIN
  if :new.ex_id is null then 
      select ex_id_seq.NEXTVAL INTO :new.ex_id FROM DUAL;
   END IF;
END;




select ex.ex_id, ex.FIRST_NAME,ex.LAST_NAME,tr.NAME 
from example ex
left join track tr
on ex.favorite_song_id = tr.trackid;

CREATE OR REPLACE FUNCTION findPerson(
    fn IN VARCHAR2)
  RETURN NUMBER
IS
  person_id NUMBER;
  CURSOR c1
  IS
    SELECT ex_id FROM example WHERE lower(FIRST_NAMEtname) = lower(fn);
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

SELECT ex.ex_id,
  ex.first_name,
  ex.last_name,
  tr.name
FROM example ex
ON ex.favorite_song_id = tr.trackid;

---HomeWork Scrips 8-24-2017
create or replace function finedNameOnId(ex_id in number)
return varchar2
is
fn varchar2;
ln varchar2;
BEGIN select first_name,last_name
into fn,ln
from example where ex_id = ex_id;
return fn,ln
end;
/