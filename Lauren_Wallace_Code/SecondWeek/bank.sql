/*
drop user bank cascade;
create user bank identified by p4ssw0rd
default tablespace users
temporary tablespace temp
quota 10m on users;

grant connect to bank;
grant resource to bank;
grant create session to bank;
grant create table to bank;
grant create view to bank;

conn bank/p4ssw0rd
*/
-- BANK DATA DEFINITION
-- CREATES THE TABLE BANK_USERS, STORES USER INFORMATION
-- IF DELETE FUNCTIONALITY IS NEEDED MAKE SURE TO ON DELETE CASCADE
create table bank_users(
  userid number primary key,
  firstname varchar2(50) not null,
  lastname varchar2(50) not null,
  email varchar2(50) not null unique,
  password varchar2(50) not null
);

-- CREATES THE TABLE BANK_ACCOUNTTYPE, STORES ACCOUNT IDENITIFICATION
create table bank_accountType(
  typeid number primary key,
  name varchar2(25)
);

-- CREATES THE TABLE BANK_ACCOUNT, STORES USER'S BANK ACCOUNT(S)
create table bank_account(
  accountid number primary key,
  balance number(12,2) default 0.0,
  userid number not null,
  typeid number not null,
  constraint fk_account_type foreign key(typeid) references bank_AccountType(typeid),
  constraint fk_user_id foreign key(userid) references bank_Users(userid)
);

-- SEQUENCE FOR AUTO INCREMENTING USERID
CREATE SEQUENCE USERID_SEQ
INCREMENT BY 1
START WITH 1;

-- SEQUENCE FOR AUTO INCREMENTING ACCOUNTID
CREATE SEQUENCE ACCOUNTID_SEQ
INCREMENT BY 1
START WITH 1;

-- TRIGGER FOR THE USERID_SEQ
CREATE OR REPLACE TRIGGER USERID_TRIGGER
BEFORE INSERT ON bank_USERS
FOR EACH ROW
BEGIN
  if :new.userid is null then 
      select userid_seq.NEXTVAL INTO :new.userid FROM DUAL;
   END IF;
END;
/
-- TRIGGER FOR THE ACCOUNTID_SEQ
CREATE OR REPLACE TRIGGER ACCOUNTID_TRIGGER
BEFORE INSERT ON bank_account
FOR EACH ROW
BEGIN
    select accountid_seq.NEXTVAL INTO :new.accountid FROM DUAL;
END;
/

-- PROCEDURE FOR GETTING 
-- ALL USER INFORMATION TO SET USER OBJECT
create or replace procedure obtainUser(email in varchar2, ufname out varchar2, ulname out varchar2, upass out varchar2)
as begin
select firstname into ufname from bank_users where bank_users.email = email; 
select lastname into ulname from bank_users where bank_users.email = email;
select password into upass from bank_users where bank_users.email = email;
end;

-- FOR INSERTING USERS VIA SQL DEVELOPER
insert into bank_users (firstname, lastname, email, password) 
values ('Emma', 'Bizzle', 'bizCoder@gmail.com', 'emBizz');

insert into bank_users (firstname, lastname, email, password) 
values ('Katie', 'Bixby', 'kat4Coding@gmail.com', 'katCoder');

insert into bank_users (firstname, lastname, email, password) 
values ('Leah', 'Parker', 'fallenHero4R@gmail.com', 'leahP');

insert into bank_users (firstname, lastname, email, password) 
values ('Katherine', 'Carts', 'katTCoder@gmail.com', 'bEDev');

-- ADDS CHECKING TO BANK_ACCOUNTTYPE
insert into bank_accountType(typeid, name) 
values (0, 'Checking');

-- ADDS SAVINGS TO BANK_ACCOUNTTYPE
insert into bank_accountType(typeid, name) 
values (1, 'Savings');

-- ADDS A CHECKING USER ACCOUNT TO THE BANK_ACCOUNT TABLE
-- WHERE BALANCE IS 0.0 AS DEFAULT
insert into bank_account(balance, userid, typeid) 
values (0.0, 1, 0);

-- ADDS A SAVINGS USER ACCOUNT TO THE BANK_ACCOUNT TABLE
-- WHERE BALANCE IS 0.0 AS DEFAULT
insert into bank_account(balance, userid, typeid) 
values (0.0, 1, 1);

-- UPDATES THE USERFIRSTNAME 
update bank_users set firstname = '' where email = '';

-- UPDATES THE USERLASTNAME
update bank_users set lastname = '' where email = '';

-- UPDATES THE EMAIL 
update bank_users set email = '' where email = '';

-- UPDATES THE PASSWORD
update bank_users set password = '' where email = '';

-- UPDATES THE USER'S BALANCE
update bank_account set balance = '' where email = '';

select * from bank_account;