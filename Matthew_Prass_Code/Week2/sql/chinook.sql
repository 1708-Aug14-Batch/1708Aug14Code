create table EXAMPLE
(
EX_ID number primary key,
FIRSTNAME varchar2(30) NOT NULL,
LASTNAME varchar2(30) NOT NULL,
FAVE_SONg_ID number,
constraint FK_FAVESONG foreign key (FAVE_SONG_ID) references TRACK(TRACKID)
);


create sequence EX_ID_SEQ
increment by 1
start with 1;

create or replace trigger ex_id_trigger
before insert on example
for each row
begin
   if :new.ex_id is null then
      select ex_id_seq.nextval into :new.ex_id from DUAL;
   end if;
end;

/

insert into EXAMPLE(ex_id,firstname,lastname,fave_song_id)
values(ex_id_seq.nextval,'matt','prass',12);

insert into EXAMPLE(ex_id,firstname,lastname,fave_song_id)
values(ex_id_seq.nextval,'john','doe',34);

update example
set firstname = 'someoneelse'
where ex_id = 1;

delete from example
where ex_id = 1;


--order by
select * from example
order by FIRSTNAME;
--group by
select count(FAVE_SONG_ID),FIRSTNAME
from example
group by firstname;
--where
select * from example
where FIRSTNAME = 'matt';
--having
select count (customerid),country
from customer
group by country
having count(customerid) > 3;
--union
select albumid from album
union
select albumid from track;
--exists
select title
from album
where exists(select artist.name from artist where album.title = artist.name);
--like/wildcards
select * from playlist
where name like 'Classical%';
--3 aggregate funcions
select count(*) from example;
select avg(artistid) from artist;
select max(customerid) from customer;
--3 scalar functions
select playlistid +trackid from playlisttrack;
select playlistid || trackid from playlisttrack;
select playlistid / trackid from playlisttrack;
--1 nested query
select *
from customer
where country in(select country 
                 from employee
                 )
/
