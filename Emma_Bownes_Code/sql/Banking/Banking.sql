--Banking
  -- Requirements:
  --As a User I can

    -- change password <- almost done
    -- change name(s) <-almost done
    -- view balance
    --done:
--------------------------------------------------------------------------------
--DDL
    -- create accounts - done 
    -- (up to 6) - done
    -- close accounts - done
    -- transfer funds - done
    -- withdraw -- done
    -- deposit -- done

--------------------------------------------------------------------------------
--USER
Create table USERS(
user_Id Number Primary key,
firstname varchar2(50) not null,
lastname varchar2(50) not null,
username varchar2(50) not null unique,
pass_word varchar2(50) not null
);
  --sequence
  Create sequence User_id_seq
  increment by 1
  start with 1;
  
    --trigger
    CREATE OR REPLACE TRIGGER user_ID_TRIGGER
    BEFORE INSERT ON user
    FOR EACH ROW
    BEGIN
      IF :NEW.user_ID IS NULL THEN
        SELECT user_ID_SEQ.NEXTVAL INTO :new.user_ID FROM DUAL;
      END IF;
    END;
    /

--------------------------------------------------------------------------------
-- Account
Create table ACCOUNT(
account_id number primary key,
user_id number not null,
type_id number not null,
balance number(12, 2) default 0.0,
open_date date,
close_date date default null,
CONSTRAINT fk_account_type foreign key(type_id) REFERENCES Accounttype(type_id),
CONSTRAINT fk_user_id foreign key(user_id) REFERENCES users(user_id)
);

  -- sequence
  Create sequence account_id_seq
  increment by 1
  start with 1;
    
    --triggers
    CREATE OR REPLACE TRIGGER account_ID_TRIGGER
    BEFORE INSERT ON account
    FOR EACH ROW
    BEGIN
      IF :new.account_id IS NULL THEN
        SELECT account_id_seq.NEXTVAL INTO :new.account_id FROM DUAL;
      END IF;
    END;
    /
    
    --Trigger that creates the open date when a new account is created
    CREATE OR REPLACE TRIGGER open_date_TRIGGER
    BEFORE INSERT ON account
    FOR EACH ROW
    BEGIN
      :new.open_date := sysdate;
    END;
    /

--------------------------------------------------------------------------------
-- Account type table
create table ACCOUNTTYPE(
type_ID number primary KEY,
type_name varchar2(25)
);

  insert into ACCOUNTTYPE(TYPE_ID,TYPE_NAME)
  values(1,'Checking');
  
  insert into ACCOUNTTYPE(TYPE_ID,TYPE_NAME)
  values(2,'Savings');
  
  insert into ACCOUNTTYPE(TYPE_ID,TYPE_NAME)
  values(3,'Credit');
  
  select * from accounttype;
  
insert into users(firstname,lastname,username,pass_word)
values('fn','ln','usr','pass_word');


insert into account(USER_ID,TYPE_ID)
values(1,1);
select * from account;

-- Functions & Procedures 
  --Users:
    -- fucntions:
      -- get user_id based on username
      create or replace function get_user_id
        (usr in varchar2)
        return number
        is userId number;
        --create cursor to run through tables
        cursor c1 is
        select user_id
        from Users
        where lower(USERNAME) = lower(usr);
        --set what it gave to something you can return
        begin open c1;
        fetch c1 into userId;
        if c1%notfound then
        userId := -1;
        end if;
        close c1;
        return userId;
      end;
      /
      
      create or replace function get_user_pw
        (i_d in number)
        return varchar2
        is pwd VARCHAR2(25);
        cursor c1 is
        select PASS_WORD
        from Users
        where user_id = i_d;
        begin open c1;
        fetch c1 into pwd;
        if c1%notfound then
        pwd := null;
        end if;
        close c1;
        return pwd;
      end;
      /
      
      create or replace function get_user_fn
        (i_d in number)
        return varchar2
        is pwd VARCHAR2(25);
        cursor c1 is
        select firstname||':'||lastname
        from Users
        where user_id = i_d;
        begin open c1;
        fetch c1 into pwd;
        if c1%notfound then
        pwd := null;
        end if;
        close c1;
        return pwd;
      end;
      /
      
      create or replace function get_user
        (i_d in number)
        return varchar2
        is usr VARCHAR2(25);
        cursor c1 is
        select PASS_WORD||':'||FIRSTNAME||':'||LASTNAME
        from Users
        where user_id = i_d;
        begin open c1;
        fetch c1 into usr;
        if c1%notfound then
        usr := null;
        end if;
        close c1;
        return usr;
      end;
      /
      
      ALTER table Account
      ADD constraint FK_ACCOUNT_TYPE
      FOREIGN KEY (TYPE_ID)
      REFERENCES ACCOUNTtype (type_ID)
      ON DELETE CASCADE;
      
      select * from account;
      
      update account set close_date = sysdate, balance = 0 where ACCOUNT_ID = 39;
      
      update Users set FIRSTNAME = ?, LASTNAME = ?, PASS_WORD = ?,USERNAME = ? where USER_ID = ?;
      select * from account;
      
      -- get password
      -- get types based on user_id
    -- procedures
      -- change firstname
      -- change lastname
      -- change password
