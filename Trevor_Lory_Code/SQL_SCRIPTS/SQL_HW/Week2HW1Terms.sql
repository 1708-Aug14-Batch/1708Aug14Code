-- order by
select * from album
order by ALBUMID desc;

-- group by / where
select count(composer), albumID from track
where albumID > 10
group by albumID;

-- having / like / wildcard
select count(albumID), composer from track
group by composer
having lower(composer) like 'a%';

-- union
select Title from album
union
select name from track;

-- exists
select albumID from album
where exists (select albumID from track);

-- aggregate functions
select sum(albumID) from track;

select min(title) from album;

select count(name) from track
where name like '% the %';

-- scalar functions
select * from track
where lower(name) like 'the %';

select * from track
where upper(name) like 'THE %';

select * from track
where reverse(name) like 'e%';

-- nested query
select name from track
where genreID in (select genreID from genre where genreID > 10);