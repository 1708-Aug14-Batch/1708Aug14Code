create table EXAMPLE
(
EX_ID NUMBER PRIMARY KEY,
FIRSTNAME VARCHAR2(30) Not null,
LASTNAME varchar2(30) Not null,
FAVORITE_SONG_ID NUMBER,
CONSTRAINT FK_FAVESONG Foreign Key (FAVORITE_SONG_ID)
References TRACK(TRACKID)


);
--Sequence 
CREATE SEQUENCE EX_ID_SEQ
INCREMENT BY 1
START WITH 1;

--Trigger
CREATE OR REPLACE TRIGGER EX_ID_TRIGGER
BEFORE INSERT ON EXAMPLE
For each row
Begin
  IF :NEW.ex_id is null then
      select EX_ID_SEQ.nextval INTO :NEW.ex_id from DUAL;
  END IF;
end;

/

select * from DUAL;

select * from example;

insert into example(FIRSTNAME,LASTNAME, FAVORITE_SONG_ID)
values('Andrew','Bonds',17);

insert into example(FIRSTNAME,LASTNAME, FAVORITE_SONG_ID)
values ('test','testing',105);

--Inserting more values to mess with
insert into example(FIRSTNAME,LASTNAME, FAVORITE_SONG_ID)
values ('Paul','Jenkins',2);

insert into example(FIRSTNAME,LASTNAME, FAVORITE_SONG_ID)
values ('Sara','Thomason',10);

insert into example(FIRSTNAME,LASTNAME, FAVORITE_SONG_ID)
values ('Final','Test',12);
/


--Order by Example
Select * from example
Order by firstname;


--Group by Example
Select SUM(ex_id), lastname
from example
group by lastname;

--Where Example
Select ex_id, lastname
from example
Where lastname = 'Bonds';

--Having example
Select MAX(ex_id), lastname
from example
Group by lastname
Having MAX(ex_id) < 10;

--Union
Select firstname from example
Union All
Select lastname from example
Order by firstname;

--Exists
Select lastname from example
Where Exists
(Select firstname from example where firstname = 'Andrew' and ex_id > 0);

--Like/WildCard
Select * from example
Where firstname like '%a';

--Aggragate functions
Select Sum(ex_id) from example;

Select Avg(Favorite_song_id) from example;

Select Min(Favorite_song_id) from example;

--Scalar functions
Select Length(firstname) from example;

Select COUNT(lastname) from example;

Select SUBSTR(firstname, 1, 1)||lastname
from example;

--Nested query
Select firstname from example
where FAVORITE_SONG_ID in
  (Select FAVORITE_SONG_ID from example
   where ex_id > 5);

/

update EXAMPLE
set firstname = 'Genesis'
where ex_id = 0;

delete from example
where ex_id = 7;
delete from example
where ex_id = 5;

