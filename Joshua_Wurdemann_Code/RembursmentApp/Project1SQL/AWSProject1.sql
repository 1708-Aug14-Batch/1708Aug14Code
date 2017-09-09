--  Rembursement DATA Defintion
CREATE TABLE USERS
  (
    userid   NUMBER PRIMARY KEY,
    firstname VARCHAR2(50) NOT NULL,
    lastname  VARCHAR2(50) NOT NULL,
    email     VARCHAR2(50) NOT NULL UNIQUE,
    password  VARCHAR2(50) NOT NULL,
    isMgr     Number(1,0) NOT NULL
    
  ); --created
  
 
  CREATE TABLE Reimbursements(
    reimburseid NUMBER PRIMARY KEY,
    submitterid NUMBER NOT NULL,
    resolverid  NUMBER NOT NULL,
    submitdate TIMESTAMP NOT NULL,
    resolved   TIMESTAMP NOT NULL,
    statusid   Number DEFAULT(0),
    description VARCHAR2(500),
    resolvnotes VARCHAR2(500),
    amount NUMBER(12,2) NOT NULL,
    CHECK (amount >0),
  
    CONSTRAINT fk_sumbitterid FOREIGN KEY(submitterid) REFERENCES USERS(userid),
    CONSTRAINT fk_resolverid FOREIGN KEY(resolverid) REFERENCES USERS(userid),
    CONSTRAINT fk_statusid FOREIGN KEY(statusid) REFERENCES RembursmentStatus(statid)
  );--created
  
  
   CREATE Table RembursmentStatus
  ( statid  NUMBER primary key,
    name     Varchar2(50)
    
  );--created
  
 --------------------SEQUENCES----------------------- 
  --Sequence for users
  CREATE SEQUENCE users_seq 
  start with 1 
  increment BY 1;
  -- Sequenc for reimbursements
CREATE SEQUENCE reimbursements_seq 
start with 1 
increment BY 1;
-----------------------TRIGGERS---------------------
--TRIGGERS for users
CREATE OR REPLACE TRIGGER users_seq_TRIGGER 
BEFORE INSERT ON USERS 
FOR EACH ROW 
BEGIN IF :new.userid IS NULL 
THEN
  SELECT users_seq.NEXTVAL INTO :new.userid FROM DUAL;
END IF;
END;/
-- Sequences for Status
CREATE OR REPLACE TRIGGER reimbursement_seq_TRIGGER 
BEFORE INSERT ON Reimbursements
FOR EACH ROW 
BEGIN IF :new.reimburseid IS NULL 
THEN
  SELECT reimbursements_seq.NEXTVAL INTO :new.reimburseid FROM DUAL;
END IF;
END;/
--

-- created user employee and jwurd
Create User  jwurd
Identified by p4ssw0rd;
Grant Connect To jwurd;
Grant Resource To jwurd;
Grant Create session to jwurd;
grant create view to jwurd;

insert into users
Value( 1 , 'josh', 'wurdemann', 'joshua@gmail.com', 0);
