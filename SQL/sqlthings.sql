
create view tracklist as
select * from track where lower(name) like '% for %';

select * from tracklist;

create view albumlist as
select * from album where albumid between 250 AND 350;

select * from albumlist;

select tr.name as "Track Name" , al.title as "Album Title", art.NAME as "Artist Name",
g.name as "Genre Name", pl.NAME "PlayList", mt.name as "MediaType", il.UNITPRICE,
cust.company, cust.lastname, emp.lastname as "Employee Name"
from TRACK tr 
inner join album al ON tr.ALBUMID = al.albumid
inner join artist art on art.artistid = al.ARTISTID
inner join genre g on g.GENREID = tr.genreid
inner join playlisttrack plt on plt.trackid = tr.trackid
inner join playlist pl on plt.playlistid = pl.PLAYLISTID
inner join mediatype  mt on mt.MEDIATYPEID  = tr.MEDIATYPEID
inner join invoiceline il on il.TRACKID = tr.TRACKID
inner join invoice inv on inv.INVOICEID = il.INVOICEID
inner join customer cust on cust.CUSTOMERID = inv.CUSTOMERID
inner join employee emp on emp.employeeid = cust.SUPPORTREPID
;


/
select tr.name as trackname, al.title as "Album Title", art.name as "Artist Name",
g.name as "Genre Name", pl.name as "PlayList", mt.name as "MediaType", 
il.unitprice, cust.company, cust.lastname as "Customer Name", 
emp.lastname as "Employee Name"
from track tr 
inner join albumlist al on tr.albumid = al.albumid
inner join artist art on art.artistid = al.artistid
inner join genre g on g.genreid = tr.genreid
inner join playlisttrack plt on plt.trackid = tr.trackid
inner join playlist pl on plt.playlistid = pl.playlistid
inner join mediatype mt on mt.mediatypeid = tr.mediatypeid
inner join invoiceline il on il.trackid = tr.trackid
inner join invoice inv on inv.invoiceid = il.invoiceid
inner join customer cust on cust.customerid = inv.customerid
inner join employee emp on emp.employeeid = cust.supportrepid;







--Genesis Bonds SQL Homework. 
--2.1 SELECT
--Task – Select all records from the Employee table.
select * from employee;

-- 2.2 Select all records from the Employee table where last name is King.
select * from employee where lastname = 'King';

-- 
