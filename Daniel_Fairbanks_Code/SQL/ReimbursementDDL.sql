CREATE TABLE Users(
  UserID NUMBER PRIMARY KEY,
  Firstname VARCHAR2(50) NOT NULL,
  Lastname VARCHAR2(50) NOT NULL,
  Email VARCHAR2(50) NOT NULL UNIQUE,
  Password VARCHAR2(50) NOT NULL,
  IsMgr NUMBER(1,0) NOT NULL
);

CREATE TABLE ReimbursementStatus(
  StatusID NUMBER PRIMARY KEY,
  Name VARCHAR2(25)
);

CREATE TABLE Reimbursements(
  RID NUMBER PRIMARY KEY,
  Amount NUMBER(12,2) NOT NULL CHECK(Amount > 0),
  Description VARCHAR2(200),
  ResolvedNotes VARCHAR2(200),
  SubmitDate TIMESTAMP NOT NULL,
  ResolveDate TIMESTAMP,
  StatusID NUMBER NOT NULL,
  SubmitterID NUMBER NOT NULL,
  ResolverID NUMBER,
  CONSTRAINT FK_StatusID FOREIGN KEY(StatusID) REFERENCES ReimbursementStatus(StatusID),
  CONSTRAINT FK_SubmitterID FOREIGN KEY(SubmitterID) REFERENCES Users(UserID),
  CONSTRAINT FK_ResolverID FOREIGN KEY(ResolverID) REFERENCES Users(UserID)
);

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
CREATE SEQUENCE ReimburseSequence START WITH 1 INCREMENT BY 1;

--TRIGGER
CREATE OR REPLACE TRIGGER ReimburseSequence 
BEFORE INSERT ON Reimbursements 
FOR EACH ROW

BEGIN
IF :new.RID IS NULL THEN
  SELECT ReimburseSequence.NEXTVAL
  INTO   :new.RID
  FROM   dual;
END IF;
END;
/

INSERT INTO ReimbursementStatus(StatusID, Name)
VALUES(1, 'Pending');
INSERT INTO ReimbursementStatus(StatusID, Name)
VALUES(2, 'Approved');
INSERT INTO ReimbursementStatus(StatusID, Name)
VALUES(3, 'Denied');

CREATE OR REPLACE FUNCTION getUser(
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

CREATE OR REPLACE PROCEDURE editUser(
    id IN NUMBER,
    fn IN VARCHAR2,
    ln IN VARCHAR2,
    em IN VARCHAR2,
    pw IN VARCHAR2)
AS BEGIN
  UPDATE Users SET Firstname=fn, Lastname=ln, Email=em, Password=pw WHERE UserID=id;
END;
/

CREATE OR REPLACE PROCEDURE addRequest(
    amt IN NUMBER,
    descriptor IN VARCHAR2,
    stat IN NUMBER,
    sid IN NUMBER)
AS BEGIN
  INSERT INTO Reimbursements (Amount, Description, SubmitDate, StatusID, SubmitterID)
  VALUES (amt, descriptor, CURRENT_TIMESTAMP, stat, sid);
END;
/

INSERT INTO Reimbursements(Amount, Description, ResolvedNotes, SubmitDate, ResolveDate, StatusID, SubmitterID, ResolverID)
VALUES (476.55, 'Purchased new math textbooks for the incoming students.', 'Its about time! Goodluck with the students!',
TO_TIMESTAMP('2014-07-22 12:14:56', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2014-07-27 06:45:20', 'YYYY-MM-DD HH24:MI:SS'),
2, 1, 6);
commit;
SELECT * FROM Reimbursements;
SELECT * FROM Users;
