create table employee
(
empid number primary key,
FIRSTNAME varchar2(30) NOT NULL,
LASTNAME varchar2(30) NOT NULL,
email varchar2(30) unique not null,
password varchar(30) not null,
username varchar2(30) unique not null,
ismanager number not null
);
/

create table reimbursestatus
(
statusid number primary key,
name varchar2(25)
);
/

create table reimbursement
(
reid number primary key,
submitterid number not null,
resolverid number,
submitdate timestamp not null,
resolved timestamp not null,
statusid number default(0),
description varchar2(30) NOT NULL,
notes varchar2(30) unique not null,
amount number(12,2) not null, 
check(amount>0),
constraint fk_submitter foreign key(submitterid) references employee(empid),
constraint fk_resolver foreign key(resolverid) references employee(empid),
constraint fk_status foreign key(statusid) references reimbursestatus(statusid)
);


create sequence empid_seq
increment by 1
start with 1;

create or replace trigger empid_trigger
before insert on employee
for each row
begin
   if :new.empid is null then
      select empid_seq.nextval into :new.empid from DUAL;
   end if;
end;

/

create sequence reimb_seq
increment by 1
start with 1;

create or replace trigger reimb_trigger
before insert on reimbursement
for each row
begin
   if :new.reid is null then
      select reimb_seq.nextval into :new.reid from DUAL;
   end if;
end;

/

insert into REIMBURSESTATUS(statusid, name)
values(0,'Pending');
insert into REIMBURSESTATUS(statusid, name)
values(1,'Approved');
insert into REIMBURSESTATUS(statusid, name)
values(2,'Denied');
/

create table reimbursement
(
reid number primary key,
submitterid number not null,
resolverid number,
submitdate timestamp not null,
resolved timestamp,
statusid number default(0),
description varchar2(30) NOT NULL,
notes varchar2(30) unique,
amount number(12,2) not null, 
check(amount>0),
constraint fk_submitter foreign key(submitterid) references employee(empid),
constraint fk_resolver foreign key(resolverid) references employee(empid),
constraint fk_status foreign key(statusid) references reimbursestatus(statusid)
);
/


create or replace procedure updateReimbursement
 (id in number,resolvid in number,resolvdate in timestamp,statid in number,note in varchar2)
 as begin
 update REIMBURSEMENT
 set resolverid = resolvid,
 resolved = resolvdate,
 statusid = statid,
 notes = note
 where reid = id;
 commit;
 end;
 /
 
 create or replace procedure updateEmployee
 (id in number,fn in varchar2,ln in varchar2,ema in varchar2,pw in varchar2, usrnm in varchar2)
 as begin
 update employee
 set firstname = fn,
 lastname = ln,
 email = ema,
 password = pw,
 username = usrnm
 where empid = id;
 commit;
 end;
 /
 
 create or replace procedure deleteReimbursement
(id in number)
as begin
delete from reimbursement
where reid = id;
commit;
end;
/