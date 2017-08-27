insert into users (firstname, lastname, username, password)
values ('test', 'account', 'testaccount@me.com', '1234');

insert into account (userid, typeid)
values (1,2);

commit;
