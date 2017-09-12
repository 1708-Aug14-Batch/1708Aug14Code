CREATE TABLE Users(
  UserID NUMBER PRIMARY KEY,
  FirstName varchar2(100) not null,
  LastName varchar2(100) not null,
  Email varchar2(100) unique not null,
  Password varchar2(100) not null,
  IsManager NUMBER(1,0) not null,
  CONSTRAINT CHK_ManagerBool CHECK (IsManager >= 0 AND IsManager <= 1)
);

CREATE TABLE Reimbursements (
  R_ID NUMBER PRIMARY KEY,
  Sub_ID NUMBER not null,
  Res_ID NUMBER,
  SubDate TIMESTAMP not null,
  ResDate TIMESTAMP,
  StatusID NUMBER default 0,
  Description varchar2(250) not null,
  ResNote varchar2(250),
  Amount NUMBER(11,2) not null,
  CONSTRAINT fk_SubmitterID FOREIGN KEY(Sub_ID) REFERENCES Users(UserID),
  CONSTRAINT fk_ResolverID FOREIGN KEY(Res_ID) REFERENCES Users(UserID),
  CONSTRAINT fk_StatusID FOREIGN KEY(StatusID) REFERENCES Status(StatusID),
  CONSTRAINT CHK_AmountCheck CHECK (Amount >= 0)
);

CREATE TABLE Status (
  StatusID NUMBER PRIMARY KEY,
  name varchar2(50) unique not null
);

-- SEQUENCES
CREATE SEQUENCE USER_ID_SEQ
INCREMENT BY 1
START WITH 1;

CREATE SEQUENCE REIM_ID_SEQ
INCREMENT BY 1
START WITH 1;

-- Triggers
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
CREATE OR REPLACE TRIGGER REIM_ID_TRIGGER
BEFORE INSERT ON Reimbursements
FOR EACH ROW
BEGIN
  IF :new.R_ID IS NULL THEN
      SELECT REIM_ID_SEQ.NEXTVAL INTO :new.R_ID FROM DUAL;
    END IF;
END;
/

-- Input Static Status Variables
insert into Status values (0, 'Pending');
insert into Status values (1, 'Approved');
insert into Status values (2, 'Denied');

-- Procedures
/
create or replace procedure add_reim(EmpID in number, descrip in varchar2, amt in number)
as begin
  insert into Reimbursements (SUB_ID, SUBDATE, DESCRIPTION, AMOUNT) values (EmpID, CURRENT_TIMESTAMP, descrip, amt);
  commit;
end add_reim;
/

---------------------Test Code---------------------
---------------------------------------------------

insert into users (firstname, lastname, email, password, ismanager) values('Trevor', 'Lory', 'trevorlory@gmail.com', 'p4ssw0rd', 1);
insert into users (firstname, lastname, email, password, ismanager) values('Test', 'Employee', 'email', 'pass', 0);
insert into users (firstname, lastname, email, password, ismanager) values('Test', 'Manager', 'Memail', 'Mpass', 1);

insert into Reimbursements (SUB_ID, RES_ID, SUBDATE, RESDATE, STATUSID, DESCRIPTION, RESNOTE, AMOUNT) values (23, null, CURRENT_TIMESTAMP, null, 0, 'Yo, need this done', null, 100.32);
insert into Reimbursements (SUB_ID, RES_ID, SUBDATE, RESDATE, STATUSID, DESCRIPTION, RESNOTE, AMOUNT) values (23, 24, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1, 'Yo, need this done 2', 'This is done', 500.67);
insert into Reimbursements (SUB_ID, RES_ID, SUBDATE, RESDATE, STATUSID, DESCRIPTION, RESNOTE, AMOUNT) values (23, 24, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 2, 'Yo, need this done 3', 'This is not done', 1337.29);

select Reimbursements.R_ID, Users1.FIRSTNAME || ' ' || users1.LASTNAME as subname, users2.FIRSTNAME || ' ' || users2.LASTNAME as resname, 
Reimbursements.SUBDATE, Reimbursements.RESDATE, Reimbursements.STATUSID, Reimbursements.DESCRIPTION, Reimbursements.RESNOTE, Reimbursements.AMOUNT
from Reimbursements
left join USERS Users1
on Reimbursements.SUB_ID = USERS1.USERID
left join USERS Users2
on Reimbursements.RES_ID = USERS2.USERID
where SUB_ID = 23;

---------------------------------------------------
---------------------------------------------------

-- Select Queries for all tables (Keep at bottom for easy access)
select * from Users;
select * from Reimbursements;
select * from Status;

commit;













