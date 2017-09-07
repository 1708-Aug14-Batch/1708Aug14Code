drop table r_status cascade constraints;

create table r_status (
  status_id number primary key,
  name varchar2(10)
);

drop table reimbursements cascade constraints;

create table reimbursements (
  rid number primary key,
  submitter_id number not null,
  resolver_id number,
  submit_date date not null,
  resolved_date date,
  status_id number default 0,
  description varchar2(100),
  resolution_notes varchar2(100),
  amount number(12, 2) not null
);
  
drop table users cascade constraints;

create table users (
  userid number primary key,
  firstname varchar2(50) not null,
  lastname varchar2(50) not null,
  username varchar2(50) not null unique,
  password varchar2(50) not null,
  email varchar2(30) not null,
  isMgr number(1,0) not null
);

ALTER TABLE reimbursements 
  ADD CONSTRAINT status_fk 
  FOREIGN KEY (status_id) 
  REFERENCES r_status(status_id) 
  ON DELETE CASCADE;

ALTER TABLE reimbursements 
  ADD CONSTRAINT submitter_fk
  FOREIGN KEY (submitter_id) 
  REFERENCES users(userid) 
  ON DELETE CASCADE;
  
ALTER TABLE reimbursements 
  ADD CONSTRAINT resolver_fk
  FOREIGN KEY (resolver_id) 
  REFERENCES users(userid) 
  ON DELETE CASCADE;
  
ALTER TABLE reimbursements
ADD CONSTRAINT reimbursements_amt_ck CHECK (amount > 0);
  
insert into r_status values (0, 'Pending');
insert into r_status values (1, 'Approved');
insert into r_status values (2, 'Denied');

create sequence reimbursements_rid_seq
start with 0
increment by 1
minvalue 0
NOMAXVALUE
nocache;

create sequence users_userid_seq
start with 0
increment by 1
minvalue 0
NOMAXVALUE
nocache;

CREATE OR REPLACE TRIGGER USERS_USERID_TRIGGER
BEFORE INSERT ON USERS
FOR EACH ROW
BEGIN
  if :new.userid is null then
    select users_userid_seq.nextval into :new.userid from dual;
  end if;
END;
/

CREATE OR REPLACE TRIGGER REIMBURSEMENTS_RID_TRIGGER
BEFORE INSERT ON REIMBURSEMENTS
FOR EACH ROW
BEGIN
  if :new.rid is null then
    select reimbursements_rid_seq.nextval into :new.rid from dual;
  end if;
END;
/
