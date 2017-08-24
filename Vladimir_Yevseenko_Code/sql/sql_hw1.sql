/* 2.1 */

/* Task - Select all records from the Employee table */
SELECT * FROM employee;


/* Task - Select all records fro the Employee table where last name is King */
SELECT * FROM employee WHERE lastname = 'King';


/* Task - Select all record from the Employee table where first name is Andrey and REPORTSTO is NULL */
SELECT * FROM employee WHERE firstname = 'Andrew' AND reportsto IS NULL;

/* 2.1 end */


/* 2.2 */

/* Task - Select all albums in album table and sort result set in descending order by title */
SELECT * FROM album ORDER BY title DESC;


/* Task - Select first name from Customer and sort result set in ascending order by city */
SELECT firstname FROM customer ORDER BY city;

/* 2.2 end */


/* 2.3 */

/* Task - Insert two new records into Genre table */
INSERT INTO genre VALUES (26, 'Funkpop');
INSERT INTO genre VALUES (27, 'DanceRock');


/* Task - Insert two new records into the Employee Table */
INSERT INTO employee VALUES (9, 'Yevseenko', 'Vladimir',
'Trainee', 6, DATE '1995-10-28', DATE '2017-08-14', 
'3165 Nostrand Ave Apt 3C', 'Brooklyn', 'NY', 'USA',
'11229', '+1 (347) 784-1612', NULL, 'yevseenko.vladimir@gmail.com');

INSERT INTO employee VALUES (10, 'Helper', 'Vlads',
'Helper', 9, DATE '1995-01-23', DATE '2015-03-17',
'11730 Plaza America Dr #205', 'Reston', 'VA', 'USA',
'20190', '+1 (347) 161-2784', '+1 (347) 127-8461', 'vlads.helper@revature.com');


/* Task - Insert two new records into Customer table */
INSERT INTO customer VALUES (60, 'Vladimir', 'Yevseenko',
'Revature', '3165 Nostrand Ave Apt 3C', 'Brooklyn',
'NY', 'USA', '11229', '+1 (347) 784-1612', NULL,
'yevseenko.vladimir@gmail.com', 5);

INSERT INTO customer VALUES (61, 'Generic', 'Customer',
'FooBar Inc', '123 Smith St', 'Dimsdale', 'VA', 'USA',
'11223', '+1 (347) 701-3839', NULL, 'generic.customer@gmail.com',
3);

/* 2.3 end */


/* 2.4 */

/* Task - Update Aaron Mitchell in customer table to Robert Walter */
UPDATE customer SET firstname = 'Robert', lastname = 'Walter'
WHERE firstname = 'Aaron' AND lastname = 'Mitchell';

/* Task - Update name of artists in the artist table t "Creedence Clearwater Revival" to "CCR" */
UPDATE artist SET name = 'CCR'
WHERE name = 'Creedence Clearwater Revival';

/* 2.4 end */


/* 2.5 */

/* Task - select all invoices with a billing address like "T%" */
SELECT * FROM invoice WHERE billingaddress LIKE 'T%';

/* 2.5 end */


/* 2.6 */

/* Task - select all invoices that have a total between 15 and 50 */
SELECT * FROM invoice WHERE total BETWEEN 15 AND 50;

/* Task - select all employees hired between 1st of June 2003 and 1st of March 2004 */
SELECT * FROM employee WHERE hiredate BETWEEN DATE ('06-01-2003) AND DATE ('03-01-2004');
