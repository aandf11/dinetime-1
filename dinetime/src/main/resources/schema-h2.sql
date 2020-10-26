
DROP TABLE IF EXISTS customer_accounts;
DROP TABLE IF EXISTS business_accounts;
DROP TABLE IF EXISTS restaurants_location;
DROP TABLE IF EXISTS table_availability;
DROP TABLE IF EXISTS restaurant_detail;
DROP TABLE IF EXISTS restaurant;
DROP TABLE IF EXISTS reservation_info;
DROP TABLE IF EXISTS rate_restanrant;
DROP TABLE IF EXISTS waitlist;


CREATE SEQUENCE hibernate_sequence START WITH 100 INCREMENT BY 1;

-- CREATE TABLE customer_accounts(
--     id int primary key auto_increment,
-- 	user_id VARCHAR(10),
-- 	nm VARCHAR(50),
-- 	email VARCHAR(50)
-- );

CREATE TABLE customer_accounts(
    id INT AUTO_INCREMENT  PRIMARY KEY,   
	user_id VARCHAR(10),
	nm VARCHAR(50),
	email VARCHAR(50),
	PRIMARY KEY (ID)  
);

CREATE TABLE business_accounts(
    id int primary key auto_increment,
	user_id VARCHAR(10),
	business_nm VARCHAR(50),
	email VARCHAR(50)
);

CREATE TABLE restaurant_location(
    id int primary key auto_increment,
	address VARCHAR(50),
	table_num int
);


CREATE TABLE table_availability(
	id int primary key auto_increment,
	table_id VARCHAR(10),
	available BOOL,
	seats int,
	time varchar(10),
    date DATE
);

CREATE TABLE restaurant_detail(
	id int primary key auto_increment,
	business_nm VARCHAR(50),
	restaurants_type VARCHAR(10),
	average_rate int
);

CREATE TABLE restaurant(
	id int primary key auto_increment,
	location_id VARCHAR(10)
);


-- CREATE TABLE reservation_info(
-- 	reservation_id VARCHAR(10) primary key,
-- 	location_id VARCHAR(10),
-- 	user_id VARCHAR(10),
-- 	table_id VARCHAR(10),
-- 	reservation_time VARCHAR(10),
--     reservation_date DATE
-- );


-- CREATE TABLE reservation(
-- 	id int primary key auto_increment,
-- 	reservation_id VARCHAR(10),
-- 	location_id VARCHAR(10),
-- 	user_id VARCHAR(10),
-- 	table_id VARCHAR(10),
-- 	time VARCHAR(10),
--     date DATE
-- );



-- CREATE TABLE waitlist(
-- 	user_id VARCHAR(10),
-- 	table_id VARCHAR(10),
-- 	nm VARCHAR(50)

-- );