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

update example
set firstname = 'someoneelse'
where ex_id = 1;

delete from example
where ex_id = 1;


--order by
--group by
--where
--having
--union
--exists
--like/wildcards
--3 aggregate funcions
--3 scalar functions
--1 nested query