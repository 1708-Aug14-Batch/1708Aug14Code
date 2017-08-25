-- IN CLASS WORK

select * from track;

-- JOINS

create view tracklist as 
select * from track where lower(name) like '% to %';

select * from tracklist;

create view albumlist as
select * from album where ALBUMID BETWEEN 250 AND 350;

select tr.name as trackname, al.title as "Album Title"
from TRACKLIST tr
left join albumLIST al
ON tr.ALBUMID = al.albumid;
--where tr.albumid IS NULL
--OR al.albumid IS NULL;
--^^^^^^These will make it so it will ONLY pull ones where the other sides values is NULL


select tr.name as "Track Name", al.title as "Album Title", art.NAME as "Artist Name",
g.name as "Genre Name", pl.NAME "PlayList", mt.name as "MediaTye", il.UNITPRICE,
cust.company, cust.lastname, emp.lastname as "Employee Name"
from TRACK tr
inner join albumlist al
on tr.albumid = al.albumid
inner join artist art on art.artistid = al.artistid
inner join genre g on g.GENREID = tr. genreid
inner join playlisttrack plt on plt.trackid = tr.trackid
inner join playlist pl on plt.playlistid = pl.PLAYLISTID
inner join mediatype mt on mt.MEDIATYPEID = tr.MEDIATYPEID
inner join invoiceline il on il.TRACKID = tr.TRACKID
inner join invoice inv on inv.INVOICEID = il.invoiceid
inner join customer cust on cust.CUSTOMERID = inv.CUSTOMERID
inner join employee emp on emp.employeeid = cust.SUPPORTREPID

;


-- number of songs per playlist
select count(playlistid) as total, trackid
from playlisttrack group by trackid
order by total;

-- number of songs per genre
select t2.name, count(*) from track t1, genre t2
where t1.genreid = t2.genreid
group by t2.name;

