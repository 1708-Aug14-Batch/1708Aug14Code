-- Bank Data Definition
drop table users cascade constraints;

create table users (
  userid number primary key,
  firstname varchar2(50) not null,
  lastname varchar2(50) not null,
  username varchar2(50) not null unique,
  password varchar2(50) not null 
);

drop table acctType cascade constraints;

create table AcctType (
  accttypeid number primary key,
  name varchar2(30)
);
  
drop table account cascade constraints;

create table Account (
 acctid number primary key,
 typeid number not null,
 balance number(12,1) default 0.0,
 userid number not null,
 constraint fk_acct_type foreign key(typeid) REFERENCES accttype(accttypeid),
 constraint fk_user_id foreign key(userid) references users(userid)
 );

drop sequence bank.userid_seq;

 create sequence userid_seq
 increment by 1
 start with 1;
 
 drop sequence acctid_seq;
 
 create sequence acctid_seq
 increment by 1
 start with 1;
 
CREATE OR REPLACE TRIGGER USERID_TRIGGER
BEFORE INSERT ON USERS
FOR EACH ROW
BEGIN
  if :new.userid is null then
    select userid_seq.nextval into :new.userid from dual;
  end if;
END;
/

CREATE OR REPLACE TRIGGER ACCTID_TRIGGER
BEFORE INSERT ON ACCOUNT
FOR EACH ROW
BEGIN
  if :new.acctid is null then
    select acctid_seq.nextval into :new.acctid from dual;
  end if;
END;
/

insert into accttype values (1, 'Checking');

insert into accttype values (2, 'Savings');

insert into accttype values (3, 'Credit');

commit;  
