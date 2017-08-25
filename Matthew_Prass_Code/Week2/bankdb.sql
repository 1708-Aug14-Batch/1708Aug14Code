--actual bank ddl
--other thing is dcl

create table users(
user_id number primary key,
firstname varchar2(50) not null,
lastname varchar2(50) not null,
email varchar2(50) not null unique,
password varchar2(50) not null
);

create table accounttype(
type_id number primary key,
--1 is checking, 2 is savings, 3 is credit
name varchar2(25)
);

create table account(
account_id number primary key,
balance number(12,2) default 0.0,
user_id number not null,
type_id number not null,
constraint fk_account_type foreign key(type_id) references accounttype(type_id),
constraint fk_use_id foreign key(user_id) references users(user_id)
);

create sequence user_id_seq
increment by 1
start with 1;

create or replace trigger user_id_trigger
before insert on users
for each row
begin
   if :new.user_id is null then
      select user_id_seq.nextval into :new.user_id from DUAL;
   end if;
end;
/

create sequence account_id_seq
increment by 1
start with 1;

create or replace trigger account_id_trigger
before insert on account
for each row
begin
   if :new.account_id is null then
      select account_id_seq.nextval into :new.account_id from DUAL;
   end if;
end;
/

insert into accounttype(type_id, name)
values(1,'checking');
insert into accounttype(type_id, name)
values(2,'savings');
insert into accounttype(type_id, name)
values(3,'credit');

insert into users(user_id,firstname,lastname,email,password)
values(user_id_seq.nextval,'test','testing','test@test.com','test');
commit;
/
commit;

select * from users;


insert into account(user_id, type_id)
values(1,2);
/