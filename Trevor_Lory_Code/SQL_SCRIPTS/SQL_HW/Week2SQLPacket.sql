-- 2.1 SELECT
-- Task – Select all records from the Employee table.
select * from employee;
-- Task – Select all records from the Employee table where last name is King.
select * from employee where lastname = 'King';
-- Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
select * from employee where firstname = 'Andrew' and reportsto is null;

-- 2.2 ORDER BY
-- Task – Select all albums in Album table and sort result set in descending order by title.
select * from album order by title desc;
-- Task – Select first name from Customer and sort result set in ascending order by city
select firstname from customer order by city asc;

-- 2.3 INSERT INTO
-- Task – Insert two new records into Genre table
-- Task – Insert two new records into Employee table
-- Task – Insert two new records into Customer table