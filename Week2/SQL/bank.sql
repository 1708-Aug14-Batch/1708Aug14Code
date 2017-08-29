ALTER table accounts
drop CONSTRAINT fk_account_type;
alter table accounts
add CONSTRAINT FK_accountType
foreign Key(type_id) REFERENCES accounttypes(type_id);

select user_id, FIRSTNAME, LASTNAME from users 
where email = 'rick@email.com' and password = 'noobnoob';

select accounts.ACCOUNT_ID,accounts.BALANCE,accounts.TYPE_ID, users.FIRSTNAME, users.LASTNAME
from accounts 
inner join users on accounts.user_id = users.USER_ID;
--where users.USER_ID = ;

select account_id, balance, type_id
from accounts
where USER_ID = 6;

 select accounts.balance, users.firstname
 from accounts 
 inner JOIN users on accounts.user_id = users.user_id -- users.user_id = users.user_id
 where users.user_id = 10;