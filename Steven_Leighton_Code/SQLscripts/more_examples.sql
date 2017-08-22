/*
order by -
group by -
where -
having -
union -
exists
like/wildcards
3 aggregate
3 scalar
1 nested
*/


select * from example
order by FAVORITE_SONG_ID desc;

-- number of times each track shows up in playlists
select count(PLAYLISTID) as total,TRACKID from playlisttrack
group by TRACKID
order by total desc;

-- number of times each track shows up in playlists more than 4 times
select count(*),TRACKID from playlisttrack
group by TRACKID having count(playlistid) > 4;

--new table of all employees and customers from alabama
select 'Customer', firstname, lastname, state from CUSTOMER
where state = 'AB'
UNION ALL
select 'Employee', firstname, lastname, state from EMPLOYEE
where state = 'AB';

--average number of songs per album
select avg(total) from
(select count(*) as total from track,album
where track.albumid = album.albumid
group by album.title);

-- exists return true if row returns true, then name is grabbed from track
select name from track
where
exists (
select title from album 
where album.albumid = track.albumid and track.unitprice > 1.00);

-- say hello using scalar function concatenation
select 'hello ' || firstname from example;

-- length of each person's first name
select length(firstname),firstname from example;

-- longest last name length
select max(length(lastname)) from example;

-- total hours worth of tracks
select sum(milliseconds)/(1000*60*60) from track;