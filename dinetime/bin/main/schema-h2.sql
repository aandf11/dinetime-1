
DROP TABLE IF EXISTS customer_accounts;
DROP TABLE IF EXISTS business_accounts;
DROP TABLE IF EXISTS restaurants_location;


CREATE SEQUENCE hibernate_sequence START WITH 100 INCREMENT BY 1;

CREATE TABLE customer_accounts(
    id int primary key auto_increment,
	user_id VARCHAR(10),
	nm VARCHAR(50),
	email VARCHAR(50)
);

CREATE TABLE business_accounts(
    id int primary key auto_increment,
	user_id VARCHAR(10),
	business_nm VARCHAR(50),
	email VARCHAR(50)
);

CREATE TABLE restaurants_location(
    id int primary key auto_increment,
	location_id VARCHAR(10),
	business_nm VARCHAR(50),
	address VARCHAR(50),
	table_num int
);


CREATE TABLE table_availability(
	table_id VARCHAR(10) primary key,
	location_id VARCHAR(10),
	available BOOL,
	seats int,
	available_time varchar(10),
    available_day DATE
);

CREATE TABLE restaurants_detail(
	id int primary key auto_increment,
	location_id VARCHAR(10),
	restaurants_type VARCHAR(10),
	average_rate int
);

CREATE TABLE reservation_info(
	reservation_id VARCHAR(10) primary key,
	location_id VARCHAR(10),
	user_id VARCHAR(10),
	table_id VARCHAR(10),
	reservation_time VARCHAR(10),
    reservation_date DATE
);

CREATE TABLE rate_info(
	rate_id VARCHAR(10) NOT NULL PRIMARY KEY,
	location_id VARCHAR(10),
	user_id VARCHAR(10),
	ratingDate date
);

CREATE TABLE waitlist(
	user_id VARCHAR(10),
	table_id VARCHAR(10),
	nm VARCHAR(50)

);
