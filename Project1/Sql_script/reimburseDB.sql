--------------------------TABLES--------------------------
create table users(
  userid number primary key,
  firstname varchar2(20) not null,
  lastname varchar(20) not null,
  username varchar2(20) not null unique,
  email varchar(30) not null unique,
  pwd varchar2(20) not null,
  isManager number(1,0) not null
);

create table status(
  statusid number primary key,
  name varchar(10)
);

create table reimbursements(
  reimbursementid number primary key,
  submitid number not null,
  resolveid number,
  statusid number default 0 not null,
  description varchar(200),
  manager_notes varchar(200),
  amount number(12,2) not null,
  submit_date timestamp not null,
  resolve_date timestamp,
  check (amount > 0),
  constraint fk_employee_id foreign key(submitid) references users(userid),
  constraint fk_manager_id foreign key(resolveid) references users(userid),
  constraint fk_status_id foreign key(statusid) references status(statusid)
);


--------------------------Seq/Triggers--------------------
CREATE SEQUENCE USER_ID_SEQ start with 1 increment by 1;
CREATE SEQUENCE REIMBURSEMENT_ID_SEQ start with 1 increment by 1;

create or replace TRIGGER USER_ID_TRIGGER
BEFORE INSERT ON users 
FOR EACH ROW 
BEGIN
  IF :new.userid is null then
    select user_ID_SEQ.NEXTVAL into :new.userid FROM dual;
  END IF;
END USER_ID_TRIGGER;

create or replace TRIGGER REIMBURSEMENT_ID_TRIGGER
BEFORE INSERT ON REIMBURSEMENTS
FOR EACH ROW 
BEGIN
  IF :new.reimbursementid is null then
    select REIMBURSEMENT_ID_SEQ.NEXTVAL into :new.reimbursementid FROM dual;
  END IF;
END REIMBURSEMENT_ID_TRIGGER;
----------------------Procedures/Functions----------------

--update a current user
CREATE OR REPLACE PROCEDURE updateUser(
    fn   IN VARCHAR2,
    ln   IN VARCHAR,
    pass IN VARCHAR,
    inID IN NUMBER)
AS
BEGIN
  UPDATE users
  SET firstname = fn,
    lastname    = ln,
    pwd         = pass
  WHERE userid  = inID;
END updateUser;

--add a new reimbursement row
create or replace procedure addReimbursement(
    employeeid in number,
    reason in varchar2,
    amount_request in number
    )
as
begin
  insert into reimbursements(submitid,description,amount,submit_date)
  values (employeeid,reason,amount_request,systimestamp);
end addReimbursement;

--update an existing reimbursement row
create or replace procedure resolveReimbursement(
    imburseID in number,
    managerid in number,
    notes in varchar2,
    status_type in number)
as
begin
  update reimbursements
  set resolveid = managerid,
  manager_notes = notes,
  resolve_date = SYSTIMESTAMP,
  statusid = status_type;
end resolveReimbursement;
--------------------------INSERTS-------------------------
--statuses
insert into status(statusid,name) values(0,'Pending');
insert into status(statusid,name) values(1,'Approved');
insert into status(statusid,name) values(2,'Denied');

--managers
insert into users(firstname,lastname,username,email,pwd,isManager) 
values ('Steven','Leighton','serka','steven.leighton95@gmail.com','pass',1);

--employees
insert into users(firstname,lastname,username,email,pwd,isManager) 
values ('Tyler','Dubay','tdubay','tdubay@maine.edu','tdubay',0);

--reimbursements
insert into reimbursements(submitid,description,amount,submit_date)
values (2,'Travel',100.50, SYSTIMESTAMP);

call resolveReimbursement(1,1,'Reasonable',1);
call addReimbursement(2,'Food',25.25);