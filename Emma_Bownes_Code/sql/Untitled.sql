-- Join:
-- Allows you to see the Foreign key relationship between tables
-- Create view: Gives you a way of looking at a table: makes a smaller table, but doesn't save it as a table

create view tracklist as
select * from track where lower(name) like '% for %';


select * from tracklist;

create view albumlist as
select * from album where ALBUMID BETWEEN 250 and 350;


-- Show every song and album title where the song is on an album, 
-- and the album has a song
select tr.name as trackname, al.title as "Album Title"
from track tr
inner join album al
on tr.ALBUMID = al.ALBUMID;

--shows 
select tr.name as trackname, al.title as "Album Title"
from tracklist tr
full OUTER join albumlist al
on tr.ALBUMID = al.ALBUMID
where tr.albumID is null
or al.ALBUMID is null;

select tr.name as trackname, al.title as "Album Title"
from tracklist tr
right join albumlist al
on tr.ALBUMID = al.ALBUMID
where tr.albumID is null
or al.ALBUMID is null;


select tr.name as trackname, al.title as "Album Title"
from tracklist tr
right join albumlist al
on tr.ALBUMID = al.ALBUMID;

select tr.name as trackname, al.title as "Album Title"
from tracklist tr
left join albumlist al
on tr.ALBUMID = al.ALBUMID;


select tr.name as "Track Name", al.title as "Album Title", art.NAME as "Artist Name"
from tracklist tr
inner join albumlist al on tr.albumID = al.albumid
inner join artist art on art.artistid = al.artistID
inner join PLAYLISTTRACK play on play.TRACKID = tr.TRACKID;

select cust.firstname||cust.lastname as "Customer Name",
tr.name as "Track Name", 
al.title as "Album Title", 
art.NAME as "Artist Name",
genre.name as "Genre",
invoice.invoicedate as "Date of Sale",
play.name as "Playlist",
med.name as "Media" 
from Customer cust
join invoice on inv.customerid = cust.customerid
join invoiceline invline on invline.invoiceid = invoice.invoiceid
join track tr on tr.trackid = invline.trackid
inner join albumlist al on tr.albumID = al.albumid
inner join artist art on art.artistid = al.artistID
join playlisttrack playt on playt.trackid = track.trackid
join playlist play on play.playlistid = playt.playlistid
join media med on med.mediaid = tr.mediaid
join genre on genre.genreid = tr.genreid;

-- this joins a crapload of tables, all 11 together
select cust.firstname||' '||cust.lastname as "Customer Name",
tr.name as "Track Name", 
al.title as "Album Title", 
art.NAME as "Artist Name",
genre.name as "Genre",
invoice.invoicedate as "Date of Sale",
play.name as "Playlist",
med.name as "Media" 
from Customer cust
join invoice on invoice.customerid = cust.customerid
join invoiceline invline on invline.invoiceid = invoice.invoiceid
join TRACK tr on invline.TRACKID = tr.TRACKID
join albumlist al on tr.albumID = al.albumid
join artist art on art.artistid = al.artistID
join playlisttrack playt on playt.trackid = tr.trackid
join playlist play on play.playlistid = playt.playlistid
join MEDIATYPE med on med.mediatypeid = tr.mediatypeid
join genre on genre.genreid = tr.genreid
join employee empl on cust.SUPPORTREPID = empl.EMPLOYEEID;

--Indexes 

create index trackname on track(name);
drop index trackname;
drop table tracknot;

-- # songs per genre

select name, count(play.trackID) as "Number of Tracks" from PLAYLIST
join PLAYLISTTRACK play on play.PLAYLISTID = PLAYLIST.PLAYLISTID
group by NAME;

select t1.name, count(*) from playlist t1, playlisttrack t2
where t1.PLAYLISTID = t2.PLAYLISTID
group by t1.NAME;

select t2.name , count(*) from track t1, genre t2
where t1.GENREID = t2.GENREID
group by t2.name;

--cascade delete
alter table album
add constraint fk_artist_id
foreign key (artistid)
references artist (artistid)
on delete cascade;
/

--functions

create table EXAMPLE
(
EX_ID NUMBER PRIMARY KEY,
FIRSTNAME VARCHAR2(30) NOT NULL,
LASTNAME VARCHAR2(30) NOT NULL,
FAVE_SONG_ID NUMBER,
CONSTRAINT FK_FAVESONG FOREIGN KEY (FAVE_SONG_ID)
REFERENCES TRACK(TRACKID)
);
/
CREATE SEQUENCE EX_ID_SEQ
INCREMENT BY 1
START WITH 1;

--TRIGGER
CREATE OR REPLACE TRIGGER EX_ID_TRIGGER
BEFORE INSERT ON EXAMPLE
FOR EACH ROW
BEGIN
  IF :NEW.EX_ID IS NULL THEN
    SELECT EX_ID_SEQ.NEXTVAL INTO :new.EX_ID FROM DUAL;
  END IF;
END;

/

create or replace procedure add_person(
fn varchar2,
ln in varchar2,
songID in number)
AS begin
insert into example(firstname, lastname, fave_song_ID)
values(fn,ln,songID);
commit;
end add_person;
/ 

DECLARE
  FN VARCHAR2(200);
  LN VARCHAR2(200);
  SONGID NUMBER;
BEGIN
  FN := 'stored';
  LN := 'proceedure';
  SONGID := 2;

  ADD_PERSON(
    FN => FN,
    LN => LN,
    SONGID => SONGID
  );
--rollback; 
END;
/

select * from example;

select ex.Ex_ID, ex.Firstname, ex.lastname, tr.name
from example ex
join track tr
on ex.FAVE_SONG_ID = tr.TRACKID;


select ex_id
from example
where lower(firstname) = lower('stored');


--function w/ cursor
create or replace function find_person
(fn in varchar2)
return number
is person_id number;
--create cursor to run through tables
cursor c1 is
select ex_id
from example
where lower(firstname) = lower(fn);
--set what it gave to something you can return
begin open c1;
fetch c1 into person_id;

if c1%notfound then
person_id := -1;
end if;
close c1;

return person_id;
end;
/

select FIRSTNAME||' '||Lastname from example;


create or replace function find_person_name
(i_d in number)
return VARCHAR2
is person_name VARCHAR2(30);
--create cursor to run through tables
cursor c2 is
select FIRSTNAME||' '||Lastname
from example
where i_d = EX_ID;
--set what it gave to something you can return
begin open c2;
fetch c2 into person_name;

if c2%notfound then
person_name := null;
end if;
close c2;

return person_name;
end;
/


insert into example(Firstname, lastname)
values('New', 'Person');

select ex.ex_id, ex.firstname, ex.lastname, tr.name
from example ex
left join track tr
on ex.fave_song_id = tr.trackid;
