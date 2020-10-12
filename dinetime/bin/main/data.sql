
INSERT INTO customer_accounts(user_id, nm, email) VALUES
    ('23494', 'KATE PARKER', 'KPARKER501@GMAIL.COM'),
	('87155', 'MARIA TALLEY', 'MARIA_TALLEY@YAHOO.COM');


INSERT INTO business_accounts(user_id, business_nm, email) VALUES
	('21313', 'MAMAS LITTLE BAKERY', 'MAMASBAKERY@GMAIL.COM'),
	('76521', 'ORGINAL PANCAKE HOUSE', 'OPH@YAHOO.COM'),
	('97564', 'PETES CAFE', 'PETESCAFE@GMAIL.COM');

-- INSERT INTO restaurants_location(location_id, business_nm, address, table_num) VALUES
-- 	('25870', 'MAMAS LITTLE BAKERY', '123 Main St. Chicago, IL', 4),
-- 	('95631', 'MAMAS LITTLE BAKERY', '721 Michigan Ave. Chicago, IL', 5),
-- 	('76313', 'ORGINAL PANCAKE HOUSE', '75 Clark Rd. Chicago, IL', 2),
-- 	('90839', 'PETES CAFE', '321 STATE ST. Chicago, IL', 3);

INSERT INTO table_availability(table_id, location_id, available, seats,available_time, available_day) VALUES
	('01321', '25870', '1', 2,'12:00','2020-01-02'),
    ('02433', '25870', '1', 4,'13:00', '2020-02-05'),
    ('03647', '25870', '1', 5,'14:00', '2020-01-02'),
    ('04367', '25870', '1', 2,'15:00', '2020-01-02'),
    ('05424', '95631', '1', 2,'13:00', '2020-02-05'),
    ('33104', '95631', '1', 5,'14:00', '2020-02-05'),
    ('87421', '76313', '1', 4,'20:00', '2020-01-03'),
    ('16404', '90839', '1', 2,'21:00', '2020-03-09'),
    ('86505', '90839', '1', 4,'17:00', '2020-02-05'),
    ('76506', '90839', '1', 6,'18:00', '2020-02-06');


-- INSERT INTO restaurants_detail( location_id, restaurants_type, average_rate) VALUES
-- 	('25870', 'BAKERY', 5),
-- 	('90839', 'CAFE', 4);


INSERT INTO reservation_info(reservation_id, location_id, user_id, table_id,reservation_time,reservation_date) VALUES
	('001', '25870', '23494','01321', '12:00', '2020-01-02'),
	('002', '95631', '87155','02433', '13:00', '2020-02-05');

INSERT INTO rate_info(rate_id, user_id,location_id,ratingDate)VALUES
	('R001','01321','23494', '2020-01-02'),
	('R002','02433','87155', '2020-02-05');

INSERT INTO waitlist(user_id, table_id,nm)VALUES
 	('23494', '01321', 'KATE PARKER'),
 	('87155', '02433', 'MARIA TALLEY');