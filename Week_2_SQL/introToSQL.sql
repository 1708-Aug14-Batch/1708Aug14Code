create table EXAMPLE
(
EX_ID NUMBER PRIMARY KEY,
FIRSTNAME VARCHAR2(30) Not null,
LASTNAME varchar2(30) Not null,
FAVORITE_SONG_ID NUMBER,
CONSTRAINT FK_FAVESONG Foreign Key (FAVORITE_SONG_ID)
References TRACK(TRACKID)


);
--Sequence 
CREATE SEQUENCE EX_ID_SEQ
INCREMENT BY 1
START WITH 1;

--Trigger
CREATE OR REPLACE TRIGGER EX_ID_TRIGGER
BEFORE INSERT ON EXAMPLE
For each row
Begin
  IF :NEW.ex_id is null then
      select EX_ID_SEQ.nextval INTO :NEW.ex_id from DUAL;
  END IF;
end;

/

select * from DUAL;

select * from example;

insert into example(FIRSTNAME,LASTNAME, FAVORITE_SONG_ID)
values('Andrew','Bonds',17);

insert into example(FIRSTNAME,LASTNAME, FAVORITE_SONG_ID)
values ('test','testing',105);

--Inserting more values to mess with
insert into example(FIRSTNAME,LASTNAME, FAVORITE_SONG_ID)
values ('Paul','Jenkins',2);

insert into example(FIRSTNAME,LASTNAME, FAVORITE_SONG_ID)
values ('Sara','Thomason',10);

insert into example(FIRSTNAME,LASTNAME, FAVORITE_SONG_ID)
values ('Final','Test',12);
/


--Order by Example
Select * from example
Order by firstname;


--Group by Example
Select SUM(ex_id), lastname
from example
group by lastname;

--Where Example
Select ex_id, lastname
from example
Where lastname = 'Bonds';

--Having example
Select MAX(ex_id), lastname
from example
Group by lastname
Having MAX(ex_id) < 10;

--Union
Select firstname from example
Union All
Select lastname from example
Order by firstname;

--Exists
Select lastname from example
Where Exists
(Select firstname from example where firstname = 'Andrew' and ex_id > 0);

--Like/WildCard
Select * from example
Where firstname like '%a';

--Aggragate functions
Select Sum(ex_id) from example;

Select Avg(Favorite_song_id) from example;

Select Min(Favorite_song_id) from example;

--Scalar functions
Select Length(firstname) from example;

Select COUNT(lastname) from example;

Select SUBSTR(firstname, 1, 1)||lastname
from example;

--Nested query
Select firstname from example
where FAVORITE_SONG_ID in
  (Select FAVORITE_SONG_ID from example
   where ex_id > 5);

/

update EXAMPLE
set firstname = 'Genesis'
where ex_id = 0;

delete from example
where ex_id = 7;
delete from example
where ex_id = 5;



create view tracklist as 
select * from track where lower(name) like '% for %';

select * from tracklist;

create view albumlist as
select* from album where albumid between 250 and 350;


select tr.name as trackname, al.title as "Album Title", art.name as "Artist",
g.name as "Genre name", pl.name as "PlayList", m.name as "MediaType", ivl.unitprice,
iv.total, c.lastname, e.lastname as "Employee name"
from track tr
inner join album al ON tr.albumid = al.albumid
inner join artist art on art.artistid = al.artistid
inner join genre g on g.genreID = tr.genreid
inner join playlisttrack plt on plt.trackid = tr.trackid
inner join playlist pl on plt.playlistid = pl.playlistid
inner join mediatype m on m.mediatypeid = tr.mediatypeid
inner join invoiceline ivl on ivl.trackid = tr.trackid
inner join invoice iv on iv.invoiceid = ivl.invoiceid
inner join customer c on c.customerid = iv.customerid
inner join employee e on e.employeeid = c.supportrepid;

Select cust.FIRSTNAME as CUSTNAME, emp.FIRSTNAME as EMPNAME
from employee emp
full join customer cust on emp.state = cust.state;

--avg songs per album
select avg(total) 
from(select count(*) as total from track, ALBUM 
where track.albumid = ALBUM.ALBUMID group by album.title);

--Find things from genre w ascii value
select name from track
where ascii(substr(name, 1, 1)) = 72;

--
select name from track
where name like '%h';

--#songs per genre
select t2.name, count(*) from track t1, genre t2
where t1.genreid = t2.genreid
group by t2.name;

--#song per playlist
select count(playlistID) as total, trackid
from playlisttrack group by trackid
order by total;

--Song thing
select t1.name, count(*) from playlist t1, playlisttrack
where t1.playlistid = playlisttrack.playlistid
group by t1.name;

--creating index

create index trackname on Track(name)
drop index trackname;

--Delete cascade
alter table artist
add constraint artistid
foreign key artistid
references album, artistid;
on delete cascade;

Alter Table album
  add constraint artist_Cascade
  Foreign key (artistID) references artist(artistid) on Delete cascade;
  
insert into example(firstname, lastname, favorite_song_id)
values ('testing', 'test', 152);

create or replace procedure add_person(
fname in varchar2,
lname in varchar2,
songID in number)
as begin
insert into example(firstname, lastname, favorite_song_id)
values (fname, lname, songID);
commit;
End add_person; 
/


DECLARE
  FNAME VARCHAR2(200);
  LNAME VARCHAR2(200);
  SONGID NUMBER;
BEGIN
  FNAME := 'stored';
  LNAME := 'procedure';
  SONGID := 1;

  ADD_PERSON(
    FNAME => FNAME,
    LNAME => LNAME,
    SONGID => SONGID
  );
--rollback; 
END;
/

select ex_id
from example
where lower(firstname) = lower('genesis');

--Function
create or replace function findPerson
  (fname in varchar2)
  return number
is 
  person_id number;
  cursor c1 
  is 
    select ex_id from example where lower(firstname) = lower(fname);
BEGIN
  open c1;
  fetch c1 into person_id;
  if c1%notfound then
    person_id := -1; --:= is an assignment operator in this instance
  end if;
close c1;
return person_id;
End;

/

create or replace function getName
  (emp_id number)
  return varchar2
is
  person_name varchar2(242);
  cursor c1
  is
    select concat(firstname, concat(' ', lastname)) from example where ex_id = emp_id;
Begin
  open c1;
  fetch c1 into person_name;
  if c1%notfound then
    person_name := null;
  end if;
close c1;
return person_name;
End;

/
select * from example;

insert into example(firstname, lastname)
values('adding','things');