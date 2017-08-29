
CREATE TABLE "user"(
  userid NUMBER PRIMARY KEY,
  firstname VARCHAR2(50) NOT NULL,
  lastname VARCHAR2(50) NOT NULL,
  username VARCHAR2(50) NOT NULL UNIQUE,
  password VARCHAR2(50) NOT NULL
);

CREATE TABLE accounttype(
  accounttypeid NUMBER PRIMARY KEY,
  name VARCHAR2(25) NOT NULL
);

CREATE TABLE "account"(
  accountid NUMBER PRIMARY KEY,
  balance NUMBER(12, 2) DEFAULT 0.0,
  userid NUMBER NOT NULL,
  accounttypeid NUMBER NOT NULL,
  CONSTRAINT fk_userid FOREIGN KEY(user_id) REFERENCES "user"(user_id),
  CONSTRAINT fk_accounttypeid FOREIGN KEY(account_type_id) REFERENCES AccountType(accounttypeid)
);

CREATE SEQUENCE user_sequence START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE account_type_sequence START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE account_sequence START WITH 1 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER user_sequence_trigger
BEFORE INSERT ON "user"
FOR EACH ROW
BEGIN
  IF :new.userid IS NULL THEN
    SELECT user_sequence.NEXTVAL 
    INTO :new.userid 
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

CREATE OR REPLACE TRIGGER account_sequence_trigger
BEFORE INSERT ON "account"
FOR EACH ROW
BEGIN
  IF :new.accountid IS NULL THEN
    SELECT account_sequence.NEXTVAL 
    INTO :new.accountid 
    FROM dual;
  END IF;
END;
/

INSERT ALL
  INTO accounttype(name) VALUES('Personal Checking')
  INTO accounttype(name) VALUES('Personal Savings')
  INTO accounttype(name) VALUES('Credit')
SELECT * FROM dual;
