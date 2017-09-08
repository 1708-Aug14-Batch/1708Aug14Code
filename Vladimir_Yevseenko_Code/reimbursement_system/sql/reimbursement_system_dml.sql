INSERT INTO statuses VALUES (1, 'pending');
INSERT INTO statuses VALUES (2, 'approved');
INSERT INTO statuses VALUES (3, 'denied');




/* test values for users */

INSERT INTO user (first_name, last_name, email, password, is_manager) VALUES ('Vladimir' , 'Yevseenko', 'yevseenko.vladimir@gmail.com',
  'password', 0);
  
INSERT INTO users (first_name, last_name, email, password, is_manager) VALUES ('Genesis' , 'Bonds', 'genesis@revature.com',
  'password', 1);
  
INSERT INTO users (first_name, last_name, email, password, is_manager) VALUES ('Ravi' , 'RavisLastName', 'ravi@revature.com',
  'ravispassword', 1);
  
INSERT INTO users (first_name, last_name, email, password, is_manager) VALUES ('Reavture' , 'Employee', 'em@revature.com',
  '123456789', 0);
  
INSERT INTO reimbursements (submitter_id, resolver_id, submission_date, resolution_date,
  reimbursement_status_id, description, amount) VALUES (1, 3, TO_DATE('01-01-1995', 'mm-dd-yyyy'),
  TO_DATE('10-28-2018', 'mm-dd-yyyy'), 1, 'vlads loan', 420);
  