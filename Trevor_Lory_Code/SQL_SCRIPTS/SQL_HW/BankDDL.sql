-- Bank Data Definition

CREATE TABLE Users(
  userid NUMBER PRIMARY KEY,
  firstname varchar2(50) not null,
  lastname varchar2(50) not null,
  email varchar2(50) not null unique,
  password varchar2(50) not null
);

CREATE TABLE AccountTypes(
  typeID NUMBER PRIMARY KEY,
  name varchar2(25) not null unique
);

CREATE TABLE Accounts(
  accountID NUMBER PRIMARY KEY,
  balance NUMBER(12, 2) DEFAULT 0.0,
  name varchar2(50) not null,
  userid NUMBER not null,
  typeid NUMBER not null,
  CONSTRAINT fk_account_type FOREIGN KEY(typeid) REFERENCES AccountTypes(typeid),
  CONSTRAINT fk_user_id FOREIGN KEY(userid) REFERENCES Users(userid)
);

-- Pre defined AccountTypes
INSERT INTO AccountTypes(typeID, name)
values(0, 'Checking');

INSERT INTO AccountTypes(typeID, name)
values(1, 'Savings');

INSERT INTO AccountTypes(typeID, name)
values(2, 'Credit');

SELECT * from AccountTypes;

-- SEQUENCES
CREATE SEQUENCE USER_ID_SEQ
INCREMENT BY 1
START WITH 1;

CREATE SEQUENCE ACC_ID_SEQ
INCREMENT BY 1
START WITH 1;

-- TRIGGERS
/
CREATE OR REPLACE TRIGGER USER_ID_TRIGGER
BEFORE INSERT ON USERS
FOR EACH ROW
BEGIN
  IF :new.userid IS NULL THEN
      SELECT USER_ID_SEQ.NEXTVAL INTO :new.userid FROM DUAL;
    END IF;
END;
/
CREATE OR REPLACE TRIGGER ACC_ID_TRIGGER
BEFORE INSERT ON ACCOUNTS
FOR EACH ROW
BEGIN
  IF :new.accountID IS NULL THEN
      SELECT ACC_ID_SEQ.NEXTVAL INTO :new.accountID FROM DUAL;
    END IF;
END;
/

-- Test Code
update users set firstname = 'thing', lastname = '2thing', email = '3thing', password = '4thing' where userid = 4;
select userid, firstname, lastname, email, password from users where email = 'aaa' and password = 'aaa';

-- Check selects
select * from users;
select * from accounttypes;
select * from accounts;

insert into users (firstname, lastname, email, password) values('Trevor', 'Lory', 'trevorlory@gmail.com', 'p4ssw0rd');

