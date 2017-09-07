--DEFINING THE DATABASE

-- CREATING THE USERS TABLE
CREATE TABLE USERS
  (
    userID     NUMBER PRIMARY KEY,
    fristname  VARCHAR2(50) NOT NULL,
    lastname   VARCHAR2(50) NOT NULL,
    email      VARCHAR2(30) UNIQUE NOT NULL,
    password   VARCHAR2(15) NOT NULL,
    isManagaer NUMBER(1,0) NOT NULL
  );
  
--CREATING THE STATUS TABLE
CREATE TABLE STATUS
  (
    statusID NUMBER PRIMARY KEY,
    name     VARCHAR2(20)
  );
-- ADDING VALUES TO THE STATUS LOOK-UP TABLE
INSERT
INTO status 
VALUES(0,'Pending');

INSERT INTO status 
VALUES(1, 'Approved');
  
INSERT INTO status 
VALUES(2, 'Denied');


--Creating the Reimbursement Table
CREATE TABLE REIMBURSEMENTS
  (
    reimID        NUMBER PRIMARY KEY,
    description   VARCHAR2(160) NOT NULL,
    amount        NUMBER(12,2) NOT NULL CHECK(amount > 0),
    statusId      NUMBER DEFAULT 0,
    submitterId   NUMBER NOT NULL,
    submit_date   TIMESTAMP NOT NULL,
    resolverId    NUMBER NOT NULL,
    resolve_date  TIMESTAMP ,
    resolve_notes VARCHAR2(240),
    CONSTRAINT FK_reimbursement_status FOREIGN KEY (statusId) REFERENCES STATUS(statusid),
    CONSTRAINT FK_reimbursement_submitter FOREIGN KEY (submitterId) REFERENCES USERS(userid),
    CONSTRAINT FK_reimbursement_resolver FOREIGN KEY (resolverId) REFERENCES USERS(userid)
  );






