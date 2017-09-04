CREATE TABLE users 
(
  id NUMBER CONSTRAINT user_id_pk PRIMARY KEY,
  first_name VARCHAR2(50) NOT NULL,
  last_name VARCHAR(50) NOT NULL,
  email VARCHAR(50) NOT NULL UNIQUE,
  password VARCHAR2(50) NOT NULL,
  is_manager NUMBER(1, 0) NOT NULL CONSTRAINT check_is_manager CHECK (is_manager = 0 OR is_manager = 1)
);

CREATE SEQUENCE user_id_seq START WITH 1;

CREATE TRIGGER user_id_trig BEFORE INSERT ON users
FOR EACH ROW
BEGIN
IF :new.id IS NULL THEN :new.id := user_id_seq.NEXTVAL;
END IF;
END;



CREATE TABLE statuses
(
  id NUMBER CONSTRAINT status_id_pk PRIMARY KEY,
  str VARCHAR(8) NOT NULL CONSTRAINT check_status_str CHECK (str IN ('pending', 'approved', 'denied'))
);



CREATE TABLE reimbursements
(
  id NUMBER CONSTRAINT reimbursement_id_pk PRIMARY KEY,
  submitter_id NUMBER NOT NULL CONSTRAINT submitter_id_fk REFERENCES users(id) ON DELETE CASCADE,
  resolver_id NUMBER CONSTRAINT resolver_id_fk REFERENCES users(id) ON DELETE CASCADE,
  submission_date DATE NOT NULL,
  resolution_date DATE,
  reimbursement_status_id NUMBER NOT NULL CONSTRAINT reimbursement_status_id_fk REFERENCES statuses (id) ON DELETE CASCADE,
  description VARCHAR(100),
  amount NUMBER(12, 2) NOT NULL CONSTRAINT check_amount CHECK (amount > 0)
);

CREATE SEQUENCE reimbursement_id_seq START WITH 1;

create or replace TRIGGER reimbursement_id_trig BEFORE INSERT ON reimbursements
FOR EACH ROW
BEGIN
IF :new.id IS NULL THEN :new.id := reimbursement_id_seq.NEXTVAL;
END IF;
END;
