#Stevie Scheid
use hw1;
#SELECT@d:=NOW(),SHA(@d);

#1.1
create table Guest (
	guestNo int,
    lastName varchar(15),
    firstName varchar(15),
    phoneNo varchar(12)
);

#1.2    
create table Booking (
	guestNo int,
    dateArrive date,
    dateDepart date,
    price decimal (10,2)
);

#2.1
INSERT INTO Guest VALUES (101, 'Washington', 'George', '444-444-4444');
INSERT INTO Guest VALUES (102, 'Smith', 'Jane', '444-444-4444');
INSERT INTO Guest VALUES (103, 'Scheid', 'Stevie', '444-444-4444');
INSERT INTO Guest VALUES (104, 'Marshall', 'Erik', '444-444-4444');
INSERT INTO Guest VALUES (105, 'Twice', 'Removed', '444-444-4444');

#2.2
INSERT INTO Booking VALUES(101, '2014-06-01', '2014-06-30', 500);
INSERT INTO Booking VALUES(101, '2014-08-01', '2014-08-30', 500);
INSERT INTO Booking VALUES(102, '2014-07-01', '2014-07-31', 500);
INSERT INTO Booking VALUES(102, '2015-07-01', '2015-07-31', 500);
INSERT INTO Booking VALUES(103, '2014-09-01', '2014-09-30', 500);

#3.1
SELECT * FROM Booking;

#3.2
SELECT * FROM Guest ORDER BY lastName DESC;

#3.3
SELECT guestNo FROM Booking;

#3.4
SELECT DISTINCT guestNo FROM Booking;

#3.5
SELECT firstName FROM Guest WHERE lastName='Washington';

#3.6
SELECT * FROM Guest WHERE lastName LIKE '%Wash%';

#4.1
DELETE FROM Booking WHERE guestNo = '103';

#4.2
SELECT * FROM Booking;

#5.1
UPDATE Guest SET lastName = 'Johnson' WHERE lastName = 'Smith';

#5.2
SELECT * FROM Guest;
