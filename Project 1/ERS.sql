DROP TABLE USERS CASCADE CONSTRAINTS;
DROP TABLE REIMBURSEMENTS CASCADE CONSTRAINTS;
DROP TABLE STATUS CASCADE CONSTRAINTS;

CREATE TABLE USERS (
  USERID  NUMBER PRIMARY KEY,
  FNAME   VARCHAR2(30) NOT NULL,
  LNAME   VARCHAR2(30) NOT NULL,
  EMAIL   VARCHAR2(50) UNIQUE NOT NULL,
  PWORD   VARCHAR2(50) NOT NULL,
  ISMNGR  NUMBER(1, 0) NOT NULL
);

CREATE TABLE STATUS (
  STATUS_ID   NUMBER PRIMARY KEY,
  NAME        VARCHAR2(100)
);

CREATE TABLE REIMBURSEMENTS (
  REIM_ID       NUMBER PRIMARY KEY,
  SUBMITTER_ID  NUMBER,
  RESOLVER_ID   NUMBER,
  SUBMIT_DATE   TIMESTAMP NOT NULL,
  RESOLVE_DATE  TIMESTAMP,
  STATUS        NUMBER DEFAULT 0,
  DESCRIPTION   VARCHAR2(100),
  NOTES         VARCHAR2(100),
  AMOUNT        NUMBER(14,2) NOT NULL CHECK (AMOUNT > 0),
  
  CONSTRAINT FK_SUBMITTER FOREIGN KEY (SUBMITTER_ID)
  REFERENCES USERS(USERID) ON DELETE CASCADE,
  
  CONSTRAINT FK_RESOLVER FOREIGN KEY (RESOLVER_ID)
  REFERENCES USERS(USERID),
  
  CONSTRAINT FK_STATUS FOREIGN KEY (STATUS)
  REFERENCES STATUS(STATUS_ID)
);
