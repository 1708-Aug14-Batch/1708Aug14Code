-- Bank Data Definition

drop table person;
CREATE TABLE person(
  person_id NUMBER PRIMARY KEY,
  first_name VARCHAR2(50) NOT NULL,
  last_name VARCHAR2(50) NOT NULL,
  email VARCHAR2(50) NOT NULL UNIQUE,
  birth_date DATE,
  deceased NUMBER(1) DEFAULT 0 NOT NULL
);

drop table bank_user;
CREATE TABLE bank_user(
  user_id NUMBER PRIMARY KEY,
  username VARCHAR2(50) NOT NULL UNIQUE,
  password VARCHAR2(50) NOT NULL,
  person_id NUMBER NOT NULL UNIQUE,
  CONSTRAINT fk_user_person FOREIGN KEY(person_id) REFERENCES person(person_id)
);

drop table clerk;
CREATE TABLE clerk(
  employee_id NUMBER PRIMARY KEY,
  password VARCHAR(50),
  date_hired DATE,
  hourly_wage NUMBER(8, 2),
  hired NUMBER(1) DEFAULT 1 NOT NULL,
  person_id NUMBER NOT NULL UNIQUE,
  CONSTRAINT fk_clerk_person FOREIGN KEY(person_id) REFERENCES person(person_id)
);

CREATE TABLE account_type(
  type_id NUMBER PRIMARY KEY,
  name VARCHAR2(25)
);

CREATE TABLE account_level(
  type_id NUMBER PRIMARY KEY,
  name VARCHAR2(25)
);

DROP TABLE account;
CREATE TABLE account(
  account_id NUMBER PRIMARY KEY,
  balance NUMBER(12, 2) DEFAULT 0.00,
  opened_date DATE,
  user_id NUMBER NOT NULL,
  type_id NUMBER NOT NULL,
  level_id NUMBER NOT NULL,
  deleted NUMBER(1) DEFAULT 0 NOT NULL,
  CONSTRAINT fk_account_type FOREIGN KEY(type_id) REFERENCES account_type(type_id),
  CONSTRAINT fk_account_level FOREIGN KEY(level_id) REFERENCES account_level(type_id),
  CONSTRAINT fk_user_id FOREIGN KEY(user_id) REFERENCES bank_user(user_id)
);

CREATE sequence person_seq start with 1 increment BY 1;
CREATE sequence user_seq start with 1 increment BY 1;
CREATE sequence acc_seq start with 1 increment BY 1;

CREATE OR REPLACE TRIGGER person_seq_trigger before
  INSERT ON person FOR EACH row BEGIN IF :new.person_id IS NULL THEN
  SELECT person_seq.nextval INTO :new.person_id FROM dual;
END IF;
END;

CREATE OR REPLACE TRIGGER user_seq_trigger before
  INSERT ON bank_user FOR EACH row BEGIN IF :new.user_id IS NULL THEN
  SELECT user_seq.nextval INTO :new.user_id FROM dual;
END IF;
END;
/
create or replace TRIGGER acc_seq_trigger before
  INSERT ON account FOR EACH row BEGIN IF :new.account_id IS NULL THEN
  SELECT acc_seq.nextval INTO :new.account_id FROM dual;
END IF;
END;
/

INSERT INTO account_type(type_id, name)
VALUES(1, 'Checking');
INSERT INTO account_type(type_id, name)
VALUES(2, 'Savings');
INSERT INTO account_type(type_id, name)
VALUES(3, 'Credit');
INSERT INTO account_type(type_id, name)
VALUES(4, 'Rewards');

INSERT INTO account_level(type_id, name)
VALUES(1, 'Bronze');
INSERT INTO account_level(type_id, name)
VALUES(2, 'Silver');
INSERT INTO account_level(type_id, name)
VALUES(3, 'Gold');
INSERT INTO account_level(type_id, name)
VALUES(4, 'Platinum');
INSERT INTO account_level(type_id, name)
VALUES(5, 'Double Platinum');

SELECT * FROM person;
SELECT * FROM bank_user;
SELECT * FROM clerk;
SELECT * FROM account;
