select *
from track
where lower(name) like '% to m%';

create view tracklist as
select * from track where lower(name) like '% for %';

create view albumlist as
select * from album where albumid between 250 and 350;

--ASCII syntax; Oracle SQL uses implicit joins
--ASCII SQL is better for learning the different joins
select track.name, ablum.title
from track inner join album
on track.albumid = album.albumid;

--Full outer
select t.name as trackname, a.title as "Album Title"
from TRACKLIST t full outer join ALBUMLIST a
on t.albumid = a.albumid;

select t.name as trackname, a.title as "Album Title"
from TRACKLIST t full outer join ALBUMLIST a
on t.albumid = a.albumid
where t.albumid is null
or a.albumid is null;

--Right Join
select t.name as trackname, a.title as "Album Title"
from TRACKLIST t right join ALBUMLIST a
on t.albumid = a.albumid;

--Left Join
select t.name as trackname, a.title as "Album Title"
from TRACKLIST t left join ALBUMLIST a
on t.albumid = a.albumid;

select t.name as trackname, al.title as albumtitle, ar.name as artistname
from track t
inner join album al on t.albumid = al.albumid
inner join artist ar on ar.artistid = al.artistid;