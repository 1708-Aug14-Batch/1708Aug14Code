select * from album;

select * from playlist;

select name, composer from track
where trackid <= 25;

select * from playlisttrack where TRACKID = 2326;

select * from genre;

create view afewtracks as
select * from track
where trackid <= 25;

select * from afewtracks;

select * from artist
where name like 'A%';

select * from track
where lower(name) like '%the%';

select * from track
where lower(name) like 'a_e%';

create table EXAMPLE
(
EX_ID NUMBER PRIMARY KEY,
FIRSTNAME VARCHAR2(30) NOT NULL,
LASTNAME VARCHAR2(30) NOT NULL,
FAVE_SONG_ID NUMBER,
CONSTRAINT FK_FAVESONG FOREIGN KEY (FAVE_SONG_ID)
REFERENCES TRACK(TRACKID)
);

-- SEQUENCE
CREATE SEQUENCE EX_ID_SEQ
INCREMENT BY 1
START WITH 1;

-- TRIGGER
CREATE OR REPLACE TRIGGER EX_ID_TRIGGER
BEFORE INSERT ON EXAMPLE
FOR EACH ROW
BEGIN
  IF :new.ex_id IS NULL THEN
      SELECT EX_ID_SEQ.NEXTVAL INTO :new.ex_id FROM DUAL;
    END IF;
END;

select * from DUAL;

select * from example;

INSERT INTO EXAMPLE (EX_ID, FIRSTNAME, LASTNAME, FAVE_SONG_ID)
values(0, 'Trevor', 'Lory', 24);

INSERT INTO EXAMPLE (FIRSTNAME, LASTNAME, FAVE_SONG_ID)
values('Trevor', 'Lory', 105);

INSERT INTO EXAMPLE (EX_ID, FIRSTNAME, LASTNAME, FAVE_SONG_ID)
values(EX_ID_SEQ.nextval, 'Trevor', 'Lory', 32);

UPDATE EXAMPLE
SET FIRSTNAME = 'NotTrevor'
WHERE ex_id = 1;

DELETE FROM EXAMPLE
WHERE EX_ID = 1;

commit;

rollback;