--Bank Data Definition

CREATE TABLE Users(
  user_id NUMBER PRIMARY KEY,
  firstame VARCHAR2(50) NOT NULL,
  lastname VARCHAR2(50) NOT NULL,
  email VARCHAR2(50) NOT NULL UNIQUE,
  password VARCHAR2(50) NOT NULL
);