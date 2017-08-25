select * from employee where employeeid>2
order by firstname;

select COUNT(FIRSTNAME), city from customer group by city;


select COUNT(FIRSTNAME), city from customer where customerid>2
group by city having city like '%r%';



select firstname from employee
UNION
select firstname from customer;


select *
from track
where exists(SELECT name from artist where
artist.name=track.composer AND track.name like '%r%');


select MAX(albumid) from track;
select MIN(albumid) from track;

select UPPER(composer) from track;
select LOWER(composer) from track;
select LENGTH(composer) from track;

