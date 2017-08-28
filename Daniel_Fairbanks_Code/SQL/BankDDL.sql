
CREATE TABLE Users(
  UserID NUMBER PRIMARY KEY,
  Firstname VARCHAR2(50) NOT NULL,
  Lastname VARCHAR2(50) NOT NULL,
  Email VARCHAR2(50) NOT NULL UNIQUE,
  Password VARCHAR2(50) NOT NULL
);

CREATE TABLE AccountType(
  TypeID NUMBER PRIMARY KEY,
  Name VARCHAR2(25)
);

CREATE TABLE Account(
  AccountID NUMBER PRIMARY KEY,
  Balance NUMBER(12,2) DEFAULT 0.0,
  UserID NUMBER NOT NULL,
  TypeID NUMBER NOT NULL,
  CONSTRAINT FK_AccountType FOREIGN KEY(TypeID) REFERENCES AccountType(TypeID),
  CONSTRAINT FK_UserID FOREIGN KEY(UserID) REFERENCES Users(UserID)
);
ALTER TABLE Account
ADD (Active NUMBER(1,0));
TRUNCATE TABLE Account;
--SEQUENCE
CREATE SEQUENCE UsersSequence START WITH 1 INCREMENT BY 1;

--TRIGGER
CREATE OR REPLACE TRIGGER UsersSequence 
BEFORE INSERT ON Users 
FOR EACH ROW

BEGIN
IF :new.UserID IS NULL THEN
  SELECT UsersSequence.NEXTVAL
  INTO   :new.UserID
  FROM   dual;
END IF;
END;
/

--SEQUENCE
CREATE SEQUENCE AccountSequence START WITH 1 INCREMENT BY 1;

--TRIGGER
CREATE OR REPLACE TRIGGER AccountSequence 
BEFORE INSERT ON Account 
FOR EACH ROW

BEGIN
IF :new.AccountID IS NULL THEN
  SELECT AccountSequence.NEXTVAL
  INTO   :new.AccountID
  FROM   dual;
END IF;
END;
/

INSERT INTO AccountType(TypeID, Name)
VALUES(1, 'Checking');
INSERT INTO AccountType(TypeID, Name)
VALUES(2, 'Savings');
INSERT INTO AccountType(TypeID, Name)
VALUES(3, 'Credit');

CREATE OR REPLACE FUNCTION findUser(
    em IN VARCHAR2,
    pw IN VARCHAR2)
  RETURN NUMBER
IS
  person_id NUMBER;
  CURSOR c1
  IS
    SELECT UserID FROM Users WHERE lower(Email) = lower(em) AND Password = pw;
BEGIN
  OPEN c1;
  FETCH c1 INTO person_id;
  IF c1%notfound THEN
    person_id := -1;
  END IF;
CLOSE c1;
RETURN person_id;
END;
/

CREATE OR REPLACE FUNCTION getAcct(
    uid IN NUMBER)
  RETURN NUMBER
IS
  person_id NUMBER;
  CURSOR c1
  IS
    SELECT UserID FROM Users WHERE lower(Email) = lower(em) AND Password = pw;
BEGIN
  OPEN c1;
  FETCH c1 INTO person_id;
  IF c1%notfound THEN
    person_id := -1;
  END IF;
CLOSE c1;
RETURN person_id;
END;
/


CREATE OR REPLACE PROCEDURE updateUser(
    id IN NUMBER,
    fn IN VARCHAR2,
    ln IN VARCHAR2,
    em IN VARCHAR2,
    pw IN VARCHAR2)
AS BEGIN
  UPDATE Users SET Firstname=fn, Lastname=ln, Email=em, Password=pw WHERE UserID=id;
END;
/

CREATE OR REPLACE PROCEDURE closeAcct(
    aid IN NUMBER)
AS BEGIN
  UPDATE Account SET Active = 0 WHERE AccountID=aid;
END;
/

CREATE OR REPLACE PROCEDURE getAcct(
    uid IN NUMBER,
    aid OUT NUMBER,
    bal OUT NUMBER,
    atype OUT VARCHAR2)
AS BEGIN
  SELECT a.AccountID, a.Balance, t.Name
  INTO aid, bal, atype
  FROM Account a
  LEFT JOIN AccountType t
  ON a.TypeID = t.TypeID
  WHERE a.UserID = uid;
END;
/

CREATE OR REPLACE PROCEDURE updateBalance(
    id IN NUMBER,
    amt IN NUMBER,
    aid IN NUMBER)
AS BEGIN
  UPDATE Account SET Balance = amt WHERE UserID = id AND AccountID = aid;
END;
/

create or replace FUNCTION getBalance(
    uid IN NUMBER,
    aid IN NUMBER)
  RETURN NUMBER
IS
  balance NUMBER(12,2);
  CURSOR c1
  IS
    SELECT Balance FROM Account WHERE UserID = uid AND AccountID = aid;
BEGIN
  OPEN c1;
  FETCH c1 INTO balance;
  IF c1%notfound THEN
    balance := -1;
  END IF;
CLOSE c1;
RETURN balance;
END;
/

SELECT * FROM Users;
SELECT * FROM Account;
SELECT * FROM AccountType;
UPDATE Account SET Balance = 100.0 WHERE UserID = 2;
