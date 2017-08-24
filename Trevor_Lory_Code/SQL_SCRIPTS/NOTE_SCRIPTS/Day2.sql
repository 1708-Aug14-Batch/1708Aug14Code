create view tracklist as 
select * from track where lower(name) like '% for %';

create view albumlist as
select * from album where albumid between 250 and 350;

select * from tracklist;

select * from albumlist;

select track.name, album.title
from track
inner join album
on track.albumid = album.albumid;

select tr.name as trackname, album.title as "Album Title"
from track tr
inner join album al
on tr.albumid = al.albumid;

select tr.name as trackname, al.title as "Album Title"
from tracklist tr
full outer join albumlist al
on tr.albumid = al.albumid;

select tr.name as trackname, al.title as "Album Title"
from tracklist tr
full outer join albumlist al
on tr.albumid = al.albumid
where tr.albumid is null
or al.albumid is null;

select tr.name as trackname, al.title as "Album Title"
from tracklist tr
left join albumlist al
on tr.albumid = al.albumid;

select tr.name as trackname, al.title as "Album Title"
from tracklist tr
right join albumlist al
on tr.albumid = al.albumid;

select tr.name as trackname, al.title as "Album Title", art.name as "Artist Name"
from track tr
inner join album al
on tr.albumid = al.albumid
inner join artist art
on art.artistid = al.artistid;

select tr.name as trackname, al.title as "Album Title", art.name as "Artist Name", gr.name as "Genre Name", mt.name as "Media Name", pl.name as "PlayList Name",
il.Unitprice as "Unit Price", cust.company as "Company", cust.lastname as "Last Name", emp.lastname as "Rep Last Name"
from track tr
inner join album al
on tr.albumid = al.albumid
inner join artist art
on art.artistid = al.artistid
inner join genre gr
on gr.genreid = tr.genreid
inner join mediatype mt
on mt.mediatypeid = tr.mediatypeid
inner join playlisttrack pt
on pt.trackid = tr.trackid
inner join playlist pl
on pl.playlistID = pt.playlistid
inner join invoiceline il
on il.trackid = tr.trackid
inner join invoice inv
on inv.invoiceid = il.invoiceid
inner join customer cust
on cust.customerid = inv.customerid
inner join employee emp
on emp.employeeid = cust.supportrepid;

select cust.firstname CUSTNAME, emp.firstname EMPNAME
from employee emp
join customer cust on emp.state = cust.state;

--average songs per album
select avg(total) from(select count(*) as total from track, album where track.albumid = album.albumid group by album.title);

--find things from genre w ascii value
select name from genre
where ascii(substr(name, 1, 1)) = 72;

select name from track where name like 'H%';

--# songs per genre
select t2.name, count(*) from track t1, genre t2 where t1.genreid = t2.genreid group by t2.name;

--# song per playlist
select count(plt.playlistid) as total, plt.trackid, pl.name from playlisttrack plt
inner join playlist pl
on pl.playlistid = plt.playlistid
group by plt.trackid, pl.name
order by total;

select t1.name, count(*) from playlist t1, playlisttrack
where t1.playlistid = playlisttrack.playlistid
group by t1.name;

--
create index trackname on track(name);
drop index trackname;

-- Homework cascade ?????? doesn't quite work
alter table album
add constraint artistid_fk
foreign key (artistid)
references artist (artistid)
on delete cascade;

-- procedures or something
select * from example;

insert into example (firstname, lastname, fave_song_id)
values('testing', 'test', 152);

/
create or replace procedure add_person(
fn in varchar2,
ln in varchar2,
songID in number)
as begin
  insert into example (firstname, lastname, fave_song_id)
  values(fn, ln, songID);
  commit;
end add_person; 
/

DECLARE
  FN VARCHAR2(200);
  LN VARCHAR2(200);
  SONGID NUMBER;
BEGIN
  FN := 'stored';
  LN := 'procedure';
  SONGID := 1;

  ADD_PERSON(
    FN => FN,
    LN => LN,
    SONGID => SONGID
  );
--rollback; 
END;
/

-----
select exa.firstname, tr.name from example exa
inner join track tr
on exa.fave_song_id = tr.trackid;
