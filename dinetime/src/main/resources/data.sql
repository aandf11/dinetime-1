
INSERT INTO customer_accounts(user_id, nm, email,password) VALUES
    ('23494', 'KATE PARKER', 'KPARKER501@GMAIL.COM','1234'),
	('87155', 'MARIA TALLEY', 'MARIA_TALLEY@YAHOO.COM','abc');


INSERT INTO business_accounts(user_id, business_nm, email) VALUES
	('21313', 'MAMAS LITTLE BAKERY', 'MAMASBAKERY@GMAIL.COM'),
	('76521', 'ORGINAL PANCAKE HOUSE', 'OPH@YAHOO.COM'),
	('97564', 'PETES CAFE', 'PETESCAFE@GMAIL.COM');


INSERT INTO restaurants( restaurant_nm, restaurant_address) VALUES
	('MAMAS LITTLE BAKERY', '123 Main St. Chicago, IL'),
	('PETES CAFE', '721 Michigan Ave. Chicago, IL');



-- INSERT INTO restaurant_location(address, table_num) VALUES
-- 	('123 Main St. Chicago, IL', 4),
-- 	('721 Michigan Ave. Chicago, IL', 5),
-- 	('75 Clark Rd. Chicago, IL', 2),
-- 	('321 STATE ST. Chicago, IL', 3);

-- INSERT INTO table_availability(table_id, location_id, available, seats,time, date) VALUES
-- 	('01321', '25870', '1', 2,'12:00','2020-01-02'),
--     ('02433', '25870', '1', 4,'13:00', '2020-02-05'),
--     ('03647', '25870', '1', 5,'14:00', '2020-01-02'),
--     ('04367', '25870', '1', 2,'15:00', '2020-01-02'),
--     ('05424', '95631', '1', 2,'13:00', '2020-02-05'),
--     ('33104', '95631', '1', 5,'14:00', '2020-02-05'),
--     ('87421', '76313', '1', 4,'20:00', '2020-01-03'),
--     ('16404', '90839', '1', 2,'21:00', '2020-03-09'),
--     ('86505', '90839', '1', 4,'17:00', '2020-02-05'),
--     ('76506', '90839', '1', 6,'18:00', '2020-02-06');

-- INSERT INTO table_availability(available, seats,time, date) VALUES
-- 	('1', 2,'12:00','2020-01-02'),
-- 	('1', 3,'14:00','2020-02-02'),
--     ('1', 4,'13:00', '2020-02-05');

-- INSERT INTO restaurant(location_id) VALUES('25870');


-- INSERT INTO restaurant_detail( business_nm, restaurants_type, average_rate) VALUES
-- 	('MAMAS LITTLE BAKERY', 'BAKERY', 5),
-- 	('PETES CAFE', 'CAFE', 4);


-- INSERT INTO reservation_info(reservation_id, location_id, user_id, table_id,reservation_time,reservation_date) VALUES
-- 	('001', '25870', '23494','01321', '12:00', '2020-01-02'),
-- 	('002', '95631', '87155','02433', '13:00', '2020-02-05');


-- INSERT INTO reservation(reservation_id, location_id , table_id,time,date) VALUES
-- 	('001', '25870','01321', '12:00', '2020-01-02');

-- INSERT INTO reservations(table_id, customer_id , business_id) VALUES
-- 	('t01', 'customer01','business01');

-- INSERT INTO waitlist(user_id, table_id,nm)VALUES
--  	('23494', '01321', 'KATE PARKER'),
--  	('87155', '02433', 'MARIA TALLEY');


