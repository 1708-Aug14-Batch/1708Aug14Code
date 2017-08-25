-- GOING INTO FUNCTIONS TODAY

select ex_id
from example
where lower(firstname) = lower('genesis');

select * from example;



/

create or replace function findPerson
    (fn IN varchar2)
  return number
IS
  person_id number;
  cursor c1 IS -- cursor
    select ex_id FROM example WHERE lower(firstname) = lower(fn);
BEGIN
  open c1;
  fetch c1 INTO person_id;
  if c1%notfound then
    person_id := -1; -- Colon before equals sign is assignment
  end if;
close c1;
RETURN PERSON_ID;
END;

create or replace function findName
    (human in number)
  return varchar2
IS
  person_name varchar2(30);
  cursor c1 IS
    select firstname ||' '|| lastname FROM example WHERE ex_id = human;
BEGIN
  open c1;
  fetch c1 INTO person_name;
  if c1%notfound then
    person_name := -1;
  end if;
close c1;
RETURN person_name;
END;