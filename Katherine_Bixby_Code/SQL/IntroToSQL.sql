--Homework 1
/*
  Order by, group by, where, having, union, exists, like/wildcards.
  3 aggregate functions, 3 scalar functions
*/

create table HOMEWORK
(
HW_ID NUMBER PRIMARY KEY,
FIRST_NAME VARCHAR2(30) NOT NULL,
LAST_NAME VARCHAR(20) NOT NULL,
LISTENING_TO_ID NUMBER,
CONSTRAINT FK_LISTENINGSONG FOREIGN KEY (LISTENING_TO_ID)
REFERENCES TRACK(TRACKID)
);

--SEQUENCE
CREATE SEQUENCE HW_ID_SEQ
INCREMENT BY 1
START WITH 1;


select * from homework;









/*
create table EXAMPLE
(
EX_ID NUMBER PRIMARY KEY,
FIRSTNAME VARCHAR2(30) NOT NULL,
LASTNAME VARCHAR(20) NOT NULL,
FAVE_SONG_ID NUMBER,
CONSTRAINT FK_FAVESONG FOREIGN KEY (FAVE_SONG_ID)
REFERENCES TRACK(TRACKID)

);
--SEQUENCE
CREATE SEQUENCE EX_ID_SEQ
INCREMENT BY 1
START WITH 1;


--TRIGGER
CREATE OR REPLACE TRIGGER EX_ID_TRIGGER
BEFORE INSERT ON EXAMPLE
FOR EACH ROW
BEGIN
  if :new.ex_id is null then
    select ex_id_seq.NEXTVAL INTO :new.ex_id FROM DUAL;
  END IF;

END;

/



select * from example;


insert into example(EX_ID,firstname,lastname,fave_song,id)
values(1,'Genesis','Bonds',17);

insert into example(firstname,lastname,fave_song_id)
values('test','testing',105);

update example
set firstname = 'Andrew'
where ex_id = 1;

delete from example
where EX_ID = 2;

commit;

rollback;

/
*/
