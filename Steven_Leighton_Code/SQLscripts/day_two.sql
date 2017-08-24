create view tracklist as 
select * from track where lower(name) like '% for %';

select * from tracklist;

create view albumlist as
select * from album where Albumid between 250 and 350;

select cust.firstname as customername, emp.firstname as emplname, tr.name as trackname, 
      al.title as albumname, art.name as artistname, gen.name as genrename, 
      med.name as medianame, inv.invoiceid as invoiceidnum, inl.UNITPRICE as price, 
      pl.name as playlistname
from track tr
inner join album al on tr.albumid = al.albumid
inner join artist art on art.artistid = al.artistid
inner join genre gen on tr.genreid = gen.genreid
inner join mediatype med on tr.mediatypeid = med.MEDIATYPEID
inner join invoiceline inl on inl.trackid = tr.trackid
inner join invoice inv on inl.INVOICEID = inv.INVOICEID
inner join customer cust on inv.customerid = cust.customerid
inner join employee emp on cust.SUPPORTREPID = emp.employeeid
inner join playlisttrack plt on plt.trackid = tr.TRACKID
inner join playlist pl on plt.playlistid = pl.playlistid;

select name, counts.total from track
inner join (
select count(PLAYLISTID) as total, TRACKID as trackid
from playlisttrack
group by TRACKID) counts on track.trackid = counts.trackid
order by counts.total desc;

select count(*) from playlisttrack
group by playlisttrack.playlistid;

ALTER TABLE ALBUM
   DROP CONSTRAINT FK_ALBUMARTISTID;
   
ALTER TABLE ALBUM
   ADD CONSTRAINT artist_Cascade
   FOREIGN KEY (artistID) REFERENCES ARTIST(artistid) ON DELETE CASCADE;
   

create or replace procedure add_person(
fn in varchar2,
ln in varchar2,
songID in number)
as BEGIN
insert into example(firstname,lastname,favorite_song_id)
values (fn,ln,songID);
commit;
END add_person;

DECLARE
  FN VARCHAR2(200);
  LN VARCHAR2(200);
  SONGID NUMBER;
BEGIN
  FN := 'stevo';
  LN := 'leighto';
  SONGID := 55;

  ADD_PERSON(
    FN => FN,
    LN => LN,
    SONGID => SONGID
  );
--rollback; 
END;

