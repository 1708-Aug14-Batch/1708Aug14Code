-- CREATING TABLE EXAMPLE
create table EXAMPLE
(
EX_ID NUMBER PRIMARY KEY,
FIRSTNAME VARCHAR2(30) NOT NULL,
LASTNAME VARCHAR2(30) NOT NULL,
FAVE_SONG_ID NUMBER,
CONSTRAINT FK_FAVESONG FOREIGN KEY (FAVE_SONG_ID)
REFERENCES TRACK(TRACKID)
);

-- SEQUENCE
CREATE SEQUENCE EX_ID_SEQ
INCREMENT BY 1
START WITH 1;

-- TRIGGER
CREATE OR REPLACE TRIGGER EX_ID_TRIGGER
BEFORE INSERT ON EXAMPLE
FOR EACH ROW
BEGIN
  if :new.ex_id is null then 
      select ex_id_seq.NEXTVAL INTO :new.ex_id FROM DUAL;
   END IF;
END;

-- SELECT USING WHERE TO REFINE THE RESULTS RETURNED 
-- NOTE: CAN BE USED WITH THE OTHER CRUD OPERATORS TO REFINE WHAT THEY APPLY TO
select * from track where genre = 'Music';

-- SELECT ALL FROM EXAMPLE TABLE 
select * from example;

-- SELECT WITH ORDER BY THINK OF IT AS A WAY TO SORT THE RESULT OF SELECT
select * from customer order by city;
select firstname, lastname, address from customer order by country;

/*
* SELECT WITH GROUP BY THINK OF IT AS A WAY TO SORT BY SIMILARITY
* OFTEN USED WITH AGGREGATE FUNCTIONS (COUNT, MAX, MIN, SUM, AVG)
* TO GROUP THE RESULT BY COLUMN(S)
*/
select count('Calgary'), title from employee group by title;

/* 
* SELECT WITH AGGREGATE FUNCTION COUNT UTILIZING HAVING 
* NOTE: HAVING WAS ADDED BECAUSE WHERE COULD NOT BE USED WITH 
* AGGREGATE FUNCTIONS
*/
select count(trackid), genreid from track group by genreid having count(trackid) > 20;

/*
* SELECT UTILIZING UNION
* EACH SELECT STATEMENT WITHIN UNION MUST HAVE THE SAME NUMBER OF COLUMNS
* COLUMNS MUST ALSO HAVE SIMILAR DATA TYPES
* COLUMNS IN EACH SELECT STATEMENT MUST ALSO BE IN THE SAME ORDER
*/
select playlistid from playlist union select playlistid from playlisttrack;

/*
* SELECT UTILIZING EXISTS
* USED TO TEST FOR THE EXISTENCE OF ANY RECORD IN A SUBQUERY
* NOTE: MAKE SURE TO CONNECT THE TABLES YOU ARE CHECKING
*/
select firstname, lastname from customer where exists (select invoiceid from invoice where invoice.BILLINGSTATE = customer.state AND state = 'NY');

/*
* SELECT UTILIZING LIKE AND THE % WILDCARD
* USED TO SEARCH FOR A SPECIFIED PATTERN IN A COLUMN
* THERE ARE 2 WILDCARDS THAT CAN BE USED WITH LIKE:
* % - REPRESENTS 0, 1, OR MULTIPLE CHARS
* _ - REPRESENTS A SINGLE CHAR
*/
select firstname from customer where company like 'G%';

/*
* THE AGGREGATE FUNCTIONS ARE:
* COUNT(), AVG(), SUM()
* MIN(), MAX()
* THE BELOW STATEMENTS TEST THESE FUNCTIONS
*/
select count(customerid) from invoice where customerid = 17;
select avg(total) from invoice where customerid = 17;
select sum(total) from invoice where CUSTOMERID > 5;
select min(total) as smallestprice from invoice;
select max(total) as biggestprice from invoice;

/*
* SOME SCALAR FUNCTIONS ARE:
* CEIL shorthand for ceiling, FLOOR, ABS - MATH RELATED FUNCTIONS
* ASCII, CONCAT - STRING RELATED FUNCTIONS
*/
select ceil(total) from invoice;
select floor(total) from invoice;
select name from genre where ascii(substr(name,1,1)) = 72;

--songs per genre
select t2.name, count(*) from track t1, genre t2
where t1.genreid = t2.genreid
group by t2.name;

-- song per playlist
select count(playlistid) as total, trackid
from playlisttrack group by trackid
order by total;

-- Emma's 
select t1.name, count(*) from playlist t1, playlisttrack
where t1.playlistid = playlisttrack.playlistid
group by t1.name;

-- NESTED QUERY AKA SUBQUERIES
select * from invoiceline where invoiceid in (select invoiceid from invoice where invoice.invoiceid = 3); 

-- INSERT INTO EXAMPLE TABLE
insert into example(EX_ID, firstname, lastname, fave_song_id)
values (EX_ID_SEQ.nextval, 'Genesis', 'Bonds', 17);

insert into example(firstname, lastname, fave_song_id) 
values ('test', 'testing', 105);

-- UPDATE FIRSTNAME IN EXAMPLE TABLE TO ANDREW WHERE ID = 1
update example
set firstname = 'Andrew'
where ex_id = 4;

-- DELETE ANY ROWS IN EXAMPLE WHERE ID = 1
delete from example
where EX_ID = 1;

-- CREATING AN INDEX

--
alter table album
add constraint artist_Cascade
foreign key (artistid) 
references artist(artistid)
on delete cascade;

-- CASCADING ON DELETE

-- PROCEDURE TO ADD A UNIT TO OUR TABLE
insert into example(ex_id.nextvalue, firstname, lastname, fave_song_id)
values ('testing', 'test',152);

create or replace procedure add_person(
fn in varchar2,
ln in varchar2,
songID in number)
as begin
insert into example(firstname, lastname, fave_song_id)
values (fn, ln, songid);
commit;
end add_person;

declare
  fn in varchar2(200),
  ln in varchar2(200),
  songid in number;
begin


select ex.ex_id, ex.firstname, ex.lastname, tr.name
from example ex
inner join track tr
on ex.fave_song_id = tr.trackid;