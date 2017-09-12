
--CREATE TABLE AUser(
--  u_id NUMBER PRIMARY KEY NOT NULL,
--  firstname VARCHAR2(50) NOT NULL,
--  lastname VARCHAR2(50) NOT NULL,
--  username VARCHAR2(50) NOT NULL UNIQUE,
--  email VARCHAR2(50) NOT NULL UNIQUE,
--  password VARCHAR2(50) NOT NULL,
--  isManager NUMBER NOT NULL
--);
--
--CREATE TABLE Reimbursement(
--  r_id NUMBER PRIMARY KEY NOT NULL,
--  submitterid NUMBER NOT NULL,
--  CONSTRAINT FK_SUBMITTER FOREIGN KEY (submitterid) REFERENCES AUSER(u_id),
--  resolverid NUMBER,
--  CONSTRAINT FK_RESOLVER FOREIGN KEY (resolverid) REFERENCES AUSER(u_id),
--  sumbitdate TIMESTAMP,
--  resolvedate TIMESTAMP NOT NULL,
--  statusid NUMBER DEFAULT 0,
--  CONSTRAINT FK_STATUS FOREIGN KEY (statusid) REFERENCES RSTATUS(st_id),
--  description VARCHAR2(200),
--  resolvenotes VARCHAR2(200),
--  amount NUMBER(12,2) NOT NULL CHECK (amount>0)
--);

--CREATE TABLE RStatus(
--  st_id NUMBER PRIMARY KEY,
--  stname VARCHAR2(20)
--);

insert into auser(u_id,firstname,lastname,username,email,password,ismanager)
values(3,'Hercule','Satan','champ','champion@hercule.com','pan',1);

insert into rstatus(st_id,stname) values (0,'Pending');

insert into reimbursement(submitterid,resolverid,submitdate,resolvedate,description,resolvenotes,amount)
values(2,null,CURRENT_TIMESTAMP,null,'My dad broke my laptop, and I need a new one to do my job.','',1000);






create or replace function getAUser(theUID in number)
  RETURN VARCHAR2
IS
  theuser varchar2(50);
  cursor c1 IS
    select to_char(u_id)||','||to_char(firstname)||','||to_char(lastname)||','||to_char(username)||','||to_char(email)||','||to_char(password)||','||to_char(isManager) FROM AUSER WHERE u_id = theUID;
BEGIN
  open c1;
    fetch c1 INTO theuser;
    if c1%notfound then
      theuser := -1;
    end if;
  close c1;
  return theuser;
END;




create or replace trigger auser_seq_trigger
before insert on AUser
for each row
begin
if :new.u_id is null then
select auser_seq.nextval into :new.u_id from dual;
end if;
end;
/
create or replace trigger reimbursement_seq_trigger
before insert on Reimbursement
for each row
begin
if :new.r_id is null then
select reimbursement_seq.nextval into :new.r_id from dual;
end if;
end;
/
CREATE SEQUENCE auser_seq
  START WITH 1
  INCREMENT BY 1
  NOCACHE
  NOCYCLE;
/
CREATE SEQUENCE reimbursement_seq
  START WITH 1
  INCREMENT BY 1
  NOCACHE
  NOCYCLE;
/
