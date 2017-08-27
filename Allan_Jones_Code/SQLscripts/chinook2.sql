create view tracklist as
select * from track
where lower(name) like '% for %';

select * from tracklist;

create view albumlist as
select * from album
where albumid between 250 and 350;

select t1.name, t2.title
from tracklist t1, albumlist t2
where t1.albumid(+) = t2.albumid;

select t1.name, t2.title
from track t1 
right outer join album t2 on t1.ALBUMID = t2.ALBUMID
inner join artist t3 on t2.artistid = t3.ARTISTID ;

--where t1.albumid is null
--or t2.albumid is null;

select *
from album t1, artist t2, customer t3, employee t4, genre t5,
     invoiceline t6, invoice t7, mediatype t9, playlist t10, playlisttrack t11, track t12
where
  t1.ARTISTID = t2.ARTISTID
  t3.
  
select *
from track tr
inner join album al on tr.album = al.albumid
inner join artist art on art.artistid = al.artistid
inner join genre g on g.genreid = tr.genreid
inner join playlisttrack plt on plt.trackid = tr.trackid
inner join playlist pl on pl.plalistid = plt.playlistid
inner join mediatype mt on mt.mediatypeid = tr.mediatypeid
inner join invoiceline il on il.trackid = tr.trackid
inner join invoice inv on inv.invoiceid = il.invoiceid
inner join customer cust on cust.customerid = inv.customerid
inner join employee emp on emp.employeeid = cust.supportrepid
;

select cust.firstname custname, emp.firstname empname
from employee emp, customer cust
where emp.state = cust.state;

select pl.NAME, count(*)
from playlist pl, track tr, playlisttrack plt
where tr.TRACKID = plt.TRACKID
and pl.PLAYLISTID = plt.PLAYLISTID
group by pl.name;


