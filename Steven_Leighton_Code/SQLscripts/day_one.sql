create table EXAMPLE
(
EX_ID NUMBER PRIMARY KEY,
FIRSTNAME VARCHAR2(30) NOT NULL,
LASTNAME VARCHAR(30) NOT NULL,
FAVORITE_SONG_ID NUMBER,

-- CONSTRAINT
CONSTRAINT fk_favsong FOREIGN KEY (FAVORITE_SONG_ID)
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
  IF :new.ex_id is null then
    select ex_id_seq.NEXTVAL into :new.ex_id FROM dual;
  END IF;
END;

/
 
select * from example;
 
update example
set firstname = 'Andrew'
where ex_id = 0;

delete from example
where ex_id = 0;

commit;