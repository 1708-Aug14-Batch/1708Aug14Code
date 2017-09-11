
DROP TABLE bank_account;
DROP TABLE account_type;
DROP TABLE bank_user;

CREATE TABLE bank_user(
  bank_user_id NUMBER PRIMARY KEY,
  first_name VARCHAR2(50) NOT NULL,
  last_name VARCHAR2(50) NOT NULL,
  email VARCHAR2(50) NOT NULL UNIQUE,
  password VARCHAR2(50) NOT NULL,
  has_checking NUMBER(1) DEFAULT 0,
  has_savings NUMBER(1) DEFAULT 0,
  has_credit NUMBER(1) DEFAULT 0,
  enabled NUMBER(1) DEFAULT 1
);

CREATE TABLE account_type(
  account_type_id NUMBER PRIMARY KEY,
  name VARCHAR2(25) NOT NULL
);

CREATE TABLE bank_account(
  bank_account_id NUMBER PRIMARY KEY,
  balance NUMBER(12, 2) DEFAULT 0.0,
  bank_user_id NUMBER NOT NULL,
  account_type_id NUMBER NOT NULL,
  CONSTRAINT fk_user_id FOREIGN KEY(bank_user_id) REFERENCES bank_user(bank_user_id),
  CONSTRAINT fk_account_type_id FOREIGN KEY(account_type_id) REFERENCES account_type(account_type_id)
);

CREATE SEQUENCE bank_user_sequence START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE account_type_sequence START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE bank_account_sequence START WITH 1 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER bank_user_sequence_trigger
BEFORE INSERT ON bank_user
FOR EACH ROW
BEGIN
  IF :new.bank_user_id IS NULL THEN
    SELECT bank_user_sequence.NEXTVAL 
    INTO :new.bank_user_id 
    FROM dual;
  END IF;
END;
/

CREATE OR REPLACE TRIGGER account_type_sequence_trigger
BEFORE INSERT ON account_type
FOR EACH ROW
BEGIN
  IF :new.account_type_id IS NULL THEN
    SELECT account_type_sequence.NEXTVAL 
    INTO :new.account_type_id 
    FROM dual;
  END IF;
END;
/

CREATE OR REPLACE TRIGGER bank_account_sequence_trigger
BEFORE INSERT ON bank_account
FOR EACH ROW
BEGIN
  IF :new.bank_account_id IS NULL THEN
    SELECT bank_account_sequence.NEXTVAL 
    INTO :new.bank_account_id 
    FROM dual;
  END IF;
END;
/

INSERT ALL
  INTO account_type(account_type_id, name) VALUES(DEFAULT, 'Personal Checking')
  INTO account_type(account_type_id, name) VALUES(DEFAULT, 'Personal Savings')
  INTO account_type(account_type_id, name) VALUES(DEFAULT, 'Credit')
SELECT * FROM dual;
