-- IN CLASS WORK 2

-- create or replace function findPerson
-- function with cursor
select ex_id
from example
where lower(firstname) = lower('Genesis');

create or replace function findPerson(
  fn in varchar2)
return number
is person_id number;

-- CREATE CUSOR TO RUN THROUGH THE TABLES
cursor c1 is 
  select ex_id from example where lower(firstname) = lower(fn);

begin open c1;
fetch c1 into person_id;

if c1%notfound then 
person_id := -1;
end if;
close c1;

return person_id;
end;

create or replace function findPersonByID(
numid in number)
return varchar2 is personName varchar2(60);
  
  begin
  
  select concat(concat(firstname, ' '), lastname) into personName from example where ex_id = numid;

return personName;
end;

-- IN CLASS EXAMPLE
select ex.ex_id, ex.firstname, tr.name
from example ex
left join track tr
on ex.fave_song_id = tr.trackid;

-- IN CLASS ASSIGNMENT 8/24
select ex.ex_id, ex.firstname, ex.lastname, al.title
from example ex
inner join track tr
on ex.fave_song_id = tr.trackid
inner join album al
on tr.albumid = al.albumid;