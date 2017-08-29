create table test_tab (tab_id number);
insert into test_tab values (10);
insert into test_tab values (20);
commit;

create table test_tab_audit (tab_id number, aud_date date);

create or replace procedure test_proc (id number)
as
begin
null;
end;
/

create or replace function test_fn(v_id number)
return number
as
begin
test_proc(v_id);
return v_id+1;
end;
/

select tab_id,test_fn(tab_id) from test_tab;