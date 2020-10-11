DROP TABLE IF EXISTS course_students;
DROP TABLE IF EXISTS students;
DROP TABLE IF EXISTS course;
DROP TABLE IF EXISTS customer_accounts;


CREATE SEQUENCE hibernate_sequence START WITH 100 INCREMENT BY 1;



CREATE TABLE customer_accounts(
    id int primary key auto_increment,
	user_id VARCHAR(10),
	nm VARCHAR(50),
	email VARCHAR(50)
);
