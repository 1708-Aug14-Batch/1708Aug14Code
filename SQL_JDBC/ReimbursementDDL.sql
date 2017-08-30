-- Bank Data Definition

drop table worker;
CREATE TABLE worker(
  worker_id NUMBER PRIMARY KEY,
  first_name VARCHAR2(50) NOT NULL,
  last_name VARCHAR2(50) NOT NULL,
  email VARCHAR2(50) NOT NULL UNIQUE,
  username VARCHAR2(50) NOT NULL UNIQUE,
  password VARCHAR2(50) NOT NULL,
  is_manager NUMBER(1) DEFAULT 0 NOT NULL CHECK (is_manager=0 OR is_manager=1),
  is_hired NUMBER(1) DEFAULT 1 NOT NULL CHECK (is_hired=0 OR is_hired=1)
);

drop table reimbursement_status;
CREATE TABLE reimbursement_status(
  status_id NUMBER PRIMARY KEY,
  name VARCHAR(10)
);

drop table reimbursement;
CREATE TABLE reimbursement(
  reimbursement_id NUMBER PRIMARY KEY,
  submitter_id_fk NUMBER NOT NULL,
  resolver_id_fk NUMBER,
  status_id_fk NUMBER DEFAULT 1 NOT NULL,
  submit_date TIMESTAMP NOT NULL,
  resolved_date TIMESTAMP,
  description VARCHAR2(50) NOT NULL,
  resolve_notes VARCHAR2(50),
  ammount NUMBER(12,2) NOT NULL CHECK (ammount >= 0),
  
  CONSTRAINT fk_submitter_id FOREIGN KEY(submitter_id_fk) REFERENCES worker(worker_id),
  CONSTRAINT fk_resolver_id FOREIGN KEY(resolver_id_fk) REFERENCES worker(worker_id),
  CONSTRAINT fk_status_id FOREIGN KEY(status_id_fk) REFERENCES reimbursement_status(status_id)
);

CREATE sequence worker_seq start with 1 increment BY 1;
CREATE sequence reimbursement_seq start with 1 increment BY 1;

CREATE OR REPLACE TRIGGER worker_seq_trigger before
  INSERT ON worker FOR EACH row BEGIN IF :new.worker_id IS NULL THEN
  SELECT worker_seq.nextval INTO :new.worker_id FROM dual;
END IF;
END;
/
CREATE OR REPLACE TRIGGER reimbursement_seq_trigger before
  INSERT ON reimbursement FOR EACH row BEGIN IF :new.reimbursement_id IS NULL THEN
  SELECT reimbursement_seq.nextval INTO :new.reimbursement_id FROM dual;
END IF;
END;
/

INSERT INTO reimbursement_status(status_id, name)
VALUES(1, 'Pending');
INSERT INTO reimbursement_status(status_id, name)
VALUES(2, 'Denied');
INSERT INTO reimbursement_status(status_id, name)
VALUES(3, 'Approved');

SELECT * FROM worker;
SELECT * FROM reimbursement;
SELECT * FROM reimbursement_status;
