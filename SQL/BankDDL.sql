CREATE TABLE Users(
  userid NUMBER PRIMARY KEY,
  firstname VARCHAR2(50) NOT NULL,
  lastname VARCHAR2(50) NOT NULL,
  email VARCHAR2(50) NOT NULL UNIQUE,
  password VARCHAR2(50) NOT NULL
);

CREATE TABLE AccountType(
  typeid NUMBER PRIMARY KEY,
  name VARCHAR2(25)
);

CREATE TABLE Account(
  accountid NUMBER PRIMARY KEY,
  balance NUMBER(12, 2) DEFAULT 0.0,
  userid NUMBER NOT NULL,
  typeid NUMBER NOT NULL,
  CONSTRAINT fk_userid FOREIGN KEY(userid) REFERENCES Users(userid),
  CONSTRAINT fk_account_type FOREIGN KEY(typeid) REFERENCES AccountType(typeid)
);

CREATE SEQUENCE user_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE acc_seq START WITH 1 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER user_seq_trigger
BEFORE INSERT ON Users
FOR EACH ROW
BEGIN
  IF :new.userid IS NULL THEN
    SELECT user_seq.NEXTVAL 
    INTO :new.userid 
    FROM dual;
  END IF;
END;
/

CREATE OR REPLACE TRIGGER acc_seq_trigger
BEFORE INSERT ON Account
FOR EACH ROW
BEGIN
  IF :new.accountid IS NULL THEN
    SELECT acc_seq.NEXTVAL 
    INTO :new.accountid 
    FROM dual;
  END IF;
END;
/

INSERT INTO accounttype(typeid, name) VALUES(1, 'Checking');
INSERT INTO accounttype(typeid, name) VALUES(2, 'Savings');
INSERT INTO accounttype(typeid, name) VALUES(3, 'Credit');



