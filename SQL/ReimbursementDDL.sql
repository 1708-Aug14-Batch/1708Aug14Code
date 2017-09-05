
--DROP TABLE reimbursement;
--DROP TABLE status;
--DROP TABLE r_user;

CREATE TABLE r_user (
    r_user_id NUMBER NOT NULL PRIMARY KEY,
    first_name VARCHAR2(20) NOT NULL,
    last_name VARCHAR2(20) NOT NULL,
    email VARCHAR2(40) NOT NULL,
    password VARCHAR2(16) NOT NULL,
    is_manager NUMBER(1) DEFAULT 0
);

CREATE TABLE status (
    status_id NUMBER NOT NULL PRIMARY KEY,
    name VARCHAR2(8) NOT NULL
);

CREATE TABLE reimbursement (
    r_id NUMBER NOT NULL PRIMARY KEY,
    submitter_id NUMBER NOT NULL,
    resolver_id NUMBER NOT NULL,
    date_submitted TIMESTAMP NOT NULL,
    date_resolved TIMESTAMP,
    status_id NUMBER DEFAULT 0,
    description VARCHAR2(140) NOT NULL,
    resolution_notes VARCHAR2(140),
    amount NUMBER(12, 2) NOT NULL CHECK (amount > 0.0),
    CONSTRAINT fk_submitter_id FOREIGN KEY(submitter_id) REFERENCES r_user(r_user_id),
    CONSTRAINT fk_resolver_id FOREIGN KEY(resolver_id) REFERENCES r_user(r_user_id),
    CONSTRAINT fk_status_id FOREIGN KEY(status_id) REFERENCES status(status_id)
);

CREATE SEQUENCE r_user_sequence START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE status_sequence START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE reimbursement_sequence START WITH 1 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER r_user_id_auto_increment
BEFORE INSERT ON r_user
FOR EACH ROW
BEGIN
  IF :new.r_user_id IS NULL THEN
    SELECT r_user_sequence.NEXTVAL 
    INTO :new.r_user_id 
    FROM dual;
  END IF;
END;
/

CREATE OR REPLACE TRIGGER status_id_auto_increment
BEFORE INSERT ON status
FOR EACH ROW
BEGIN
  IF :new.status_id IS NULL THEN
    SELECT status_sequence.NEXTVAL 
    INTO :new.status_id 
    FROM dual;
  END IF;
END;
/

CREATE OR REPLACE TRIGGER r_id_auto_increment
BEFORE INSERT ON reimbursement
FOR EACH ROW
BEGIN
  IF :new.r_id IS NULL THEN
    SELECT reimbursement_sequence.NEXTVAL 
    INTO :new.r_id 
    FROM dual;
  END IF;
END;
/

INSERT ALL
  INTO status(status_id, name) VALUES(DEFAULT, 'Pending')
  INTO status(status_id, name) VALUES(DEFAULT, 'Approved')
  INTO status(status_id, name) VALUES(DEFAULT, 'Denied')
SELECT * FROM dual;
