CREATE TABLE EXAMPLE (
  example_id NUMBER PRIMARY KEY,
  firstname VARCHAR2(30) NOT NULL,
  lastname VARCHAR2(30) NOT NULL,
  fav_song_id NUMBER,
  CONSTRAINT fk_favsong FOREIGN KEY (fav_song_id) REFERENCES TRACK(TRACKID) 
);

--SEQUENCE
CREATE SEQUENCE EXAMPLE_ID_SEQ
INCREMENT BY 1
START WITH 1;
SELECT * FROM EXAMPLE;

--TRIGGER
CREATE OR REPLACE TRIGGER example_id_trigger
BEFORE INSERT ON EXAMPLE
FOR EACH ROW
BEGIN
  IF :new.example_id IS NULL THEN
    SELECT example_id_seq.NEXTVAL INTO :new.example_id FROM DUAL;
  END IF;
END;

/

INSERT INTO EXAMPLE(example_id, firstname, lastname, fav_song_id) VALUES(EXAMPLE_ID_SEQ.nextval, 'Will', 'Underwood', 24);

UPDATE EXAMPLE
SET firstname = 'Milo'
WHERE example_id = 1;
