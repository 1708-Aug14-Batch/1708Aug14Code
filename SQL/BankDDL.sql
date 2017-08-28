--DROP TABLE Account;
--DROP TABLE AccountType;
--DROP TABLE User;

CREATE TABLE bankuser(
  user_id NUMBER PRIMARY KEY,
  firstname VARCHAR2(50) NOT NULL,
  lastname VARCHAR2(50) NOT NULL,
  email VARCHAR2(50) NOT NULL UNIQUE,
  password VARCHAR2(50) NOT NULL
);

CREATE TABLE AccountType(
  account_type_id NUMBER PRIMARY KEY,
  name VARCHAR2(25) NOT NULL
);

CREATE TABLE bankaccount(
  account_id NUMBER PRIMARY KEY,
  balance NUMBER(12, 2) DEFAULT 0.0,
  user_id NUMBER NOT NULL,
  account_type_id NUMBER NOT NULL,
  CONSTRAINT fk_user_id FOREIGN KEY(user_id) REFERENCES "User"(user_id),
  CONSTRAINT fk_account_type_id FOREIGN KEY(account_type_id) REFERENCES AccountType(account_type_id)
);

CREATE SEQUENCE bankuser_sequence START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE account_type_sequence START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE bankaccount_sequence START WITH 1 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER bankuser_sequence_trigger
BEFORE INSERT ON bankuser
FOR EACH ROW
BEGIN
  IF :new.user_id IS NULL THEN
    SELECT bankuser_sequence.NEXTVAL 
    INTO :new.user_id 
    FROM dual;
  END IF;
END;
/

CREATE OR REPLACE TRIGGER account_type_sequence_trigger
BEFORE INSERT ON AccountType
FOR EACH ROW
BEGIN
  IF :new.account_type_id IS NULL THEN
    SELECT account_type_sequence.NEXTVAL 
    INTO :new.account_type_id 
    FROM dual;
  END IF;
END;
/

CREATE OR REPLACE TRIGGER bankaccount_sequence_trigger
BEFORE INSERT ON bankaccount
FOR EACH ROW
BEGIN
  IF :new.account_id IS NULL THEN
    SELECT bankaccount_sequence.NEXTVAL 
    INTO :new.account_id 
    FROM dual;
  END IF;
END;
/

INSERT ALL
  INTO accounttype(name) VALUES('Personal Checking')
  INTO accounttype(name) VALUES('Personal Savings')
SELECT * FROM dual;
