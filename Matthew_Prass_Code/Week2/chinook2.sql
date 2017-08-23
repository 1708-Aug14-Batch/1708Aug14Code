create view tracklist as
select * from track where lower(name) like '% for %';

select * from tracklist;

create view albumlist as
select * from album where albumid between 250 and 350;

select tr.name as trackname,al.title as "Album Title",art.name as "artist name", g.name as "genre", pl.name "Playlist", mt.name,invl.unitprice, cust.lastname, emp.lastname
from track tr
inner join album al on tr.albumid = al.albumid
inner join artist art on art.artistid = al.artistid
inner join genre g on g.genreid = tr.genreid
inner join playlisttrack plt on plt.trackid = tr.trackid
inner join playlist pl on plt.playlistid = pl.playlistid
inner join mediatype mt on mt.mediatypeid = tr.mediatypeid
inner join invoiceline invl on invl.trackid = tr.trackid
inner join invoice inv on inv.invoiceid = invl.invoiceid
inner join customer cust on cust.customerid = inv.customerid
inner join employee emp on emp.employeeid = cust.supportrepid
;

select count(playlistid) as total,trackid
from playlisttrack group by trackid
order by total;

--number of songs per playlist
select t1.name, count (*) 
from playlist t1, playlisttrack
where t1.playlistid = playlisttrack.playlistid
group by t1.name;

alter table album
add constraint artistid_fk
foreign key (artistid)
references artist(artistid)
on delete cascade;

