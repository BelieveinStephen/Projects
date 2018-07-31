#Stevie Scheid
#USE hw3;
#SELECT@d:=NOW(),SHA(@d);

#1.1
CREATE TABLE Journal (
	amount decimal(9,2),
    from_acct_id int,
    to_acct_id int,
    t_date datetime
);

#1.2
CREATE TABLE Acct (
	acct_id int,
    acct_type Boolean,
    description varchar(30)
);

#1.3
INSERT INTO Acct VALUES(1, 0, 'cash');
INSERT INTO Acct VALUES(2, 0, 'checking');
INSERT INTO Acct VALUES(3, 0, 'saving');
INSERT INTO Acct VALUES(4, 1, 'food');
INSERT INTO Acct VALUES(5, 1, 'rent');
INSERT INTO Acct VALUES(6, 1, 'college');

#1.4
INSERT INTO Journal VALUES(5000, 6, 2, '2018-05-31');
INSERT INTO Journal VALUES(200, 2, 1, '2018-06-02');
INSERT INTO Journal VALUES(2000, 2, 3, '2018-06-25');
INSERT INTO Journal VALUES(30, 1, 4, '2018-06-02');
INSERT INTO Journal VALUES(800, 2, 5, '2018-06-05');
INSERT INTO Journal VALUES(700, 2, 6, '2018-07-01');
INSERT INTO Journal VALUES(40, 1, 4, '2018-06-08');
INSERT INTO Journal VALUES(29, 1, 4, '2018-06-16');
INSERT INTO Journal VALUES(200, 2, 1, '2018-06-16');
INSERT INTO Journal VALUES(800, 2, 5, '2018-07-05');
INSERT INTO Journal VALUES(50, 1, 4, '2018-06-25');

#2.1
UPDATE Journal SET amount = 250 WHERE t_date = '2018-06-02' AND from_acct_id = 2 AND to_acct_id = 1;

#2.2
SELECT * FROM Journal WHERE t_date = '2018-06-02' AND from_acct_id = 2 AND to_acct_id = 1;

#2.3
UPDATE Journal SET amount= 47.35, t_date = '2018-06-09' WHERE amount = 40 AND t_date = '2018-06-08';

#2.4
SELECT * FROM Journal WHERE t_date = '2018-06-09' AND amount = 47.35;

#3.1
SELECT COUNT(acct_id) FROM Acct;

#3.2
SELECT AVG(amount) FROM Journal WHERE from_acct_id = 2;
SELECT MIN(amount) FROM Journal WHERE from_acct_id = 2;
SELECT MAX(amount) FROM Journal WHERE from_acct_id = 2;
SELECT SUM(amount) FROM Journal WHERE from_acct_id = 2;

#3.3
SELECT COUNT(from_acct_id AND to_acct_id) FROM Journal WHERE from_acct_id = 4 OR to_acct_id = 4;

#4.1
SELECT to_acct_id, AVG(amount) FROM Journal GROUP BY to_acct_id DESC;

#4.2
SELECT to_acct_id, AVG(amount) FROM Journal GROUP BY to_acct_id HAVING AVG(amount) < 1000;

#5.1
SELECT SUM(amount) from Journal WHERE from_acct_id =(
SELECT acct_id FROM Acct WHERE description LIKE 'c%' LIMIT 1);

#6.1
SELECT acct_id, description, acct_type, amount, t_date 
FROM Acct a, Journal j
WHERE a.acct_id = j.from_acct_id;

#6.2
SELECT DISTINCT acct_id, description, acct_type, amount 
FROM Acct a
RIGHT JOIN Journal j ON j.from_acct_id = a.acct_id OR j.to_acct_id =a.acct_id;

