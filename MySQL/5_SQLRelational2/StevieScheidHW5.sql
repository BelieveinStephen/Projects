# Stevie Scheid
# USE hw5;
#'2018-06-22 19:24:58'	'e23f23138f8243235de6527dfdbc689193fe7d8e'

DROP TABLE Journal, Acct, Category, Budget;

CREATE TABLE Budget(
budget_id int,
max_amt decimal(9,2),
warn_percent int,
start_date date,
end_date date,
PRIMARY KEY (budget_id)
);
INSERT INTO Budget VALUES(1, 100.00, 50, '2018-10-13', '2019-10-13');
INSERT INTO Budget VALUES(2, 1000.00, 55, '2018-6-24', '2018-7-29');
INSERT INTO Budget VALUES(3, 10000.00, 59, '2018-10-10', '2018-10-30');
INSERT INTO Budget(budget_id, max_amt, start_date, end_date) VALUES(4, 40000.00, '2018-5-15', '2018-8-20');

ALTER TABLE Budget 
ALTER COLUMN warn_percent 
SET DEFAULT 80;

INSERT INTO Budget(budget_id, max_amt, start_date, end_date) VALUES(5, 5000.00, '2017-2-15', '2018-5-25');

ALTER TABLE Budget 
DROP start_date, DROP end_date;

INSERT INTO Budget VALUES(6, 2000.00, 95);

CREATE TABLE Acct (
	acct_id int,
    acct_type Boolean,
    description varchar(30),
	PRIMARY KEY (acct_id)
);
 
INSERT INTO Acct VALUES(1, 0, 'cash');
INSERT INTO Acct VALUES(2, 0, 'checking');
INSERT INTO Acct VALUES(3, 0, 'saving');
INSERT INTO Acct VALUES(4, 1, 'food');
INSERT INTO Acct VALUES(5, 1, 'rent');
INSERT INTO Acct VALUES(6, 1, 'college');
ALTER TABLE Acct ADD budget_id int NOT NULL DEFAULT 1;
INSERT INTO Acct VALUES(7, 1, 'travel', 6);

CREATE TABLE Journal (
	amount decimal(9,2) DEFAULT 100,
    from_acct_id int,
    to_acct_id int,
    t_date datetime,
    PRIMARY KEY (t_date, amount)
);
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

UPDATE Journal 
SET amount = 250 
WHERE t_date = '2018-06-02' AND amount = 200;

UPDATE Journal 
SET amount= 47.35, t_date = '2018-06-08' 
WHERE amount = 40 AND t_date = '2018-06-09';

#1.1
CREATE TABLE Category (
	category_id INT AUTO_INCREMENT,
    description VARCHAR(64),
	date_created DATETIME,
    budget_warn CHAR(1) DEFAULT 'N',
    PRIMARY KEY (category_id)
);
ALTER TABLE Acct 
ADD category_id int NOT NULL DEFAULT 0;

#1.2
INSERT INTO Category(description, date_created)
VALUES('Food', NOW());

#1.3
UPDATE Acct SET description= 'Descartes Coffee Shop'
WHERE acct_id = 4;

UPDATE Acct SET category_id = 1
WHERE acct_id = 4;

INSERT INTO Acct
VALUES(8, 1, 'McDonalds', 1, 1);

INSERT INTO Acct
VALUES(9, 1, 'Starbucks', 1, 1);

#1.4
ALTER TABLE Acct 
ADD CONSTRAINT fk_ci 
FOREIGN KEY (category_id) 
REFERENCES Category(category_id);

#1.5
-- Error Code: 1452. Cannot add or update a child row: a foreign key constraint fails (`hw5`.`#sql-474_d`, CONSTRAINT `fk_ci` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`))
-- Yes, there was an error updating because category is not cleared when trying to make a foreign key

#1.6
INSERT INTO Category(description)
VALUES('General');

ALTER TABLE Acct
ALTER category_id SET DEFAULT 2;

UPDATE Acct 
SET category_id = 2 WHERE category_id = 0;

#1.7
ALTER TABLE Acct 
ADD CONSTRAINT fk_ci 
FOREIGN KEY (category_id) 
REFERENCES Category(category_id);

#1.8
INSERT INTO Acct(acct_id, description, category_id) VALUES(10, 'GAP', 3);
-- Error Code: 1452. Cannot add or update a child row: a foreign key constraint fails (`hw5`.`acct`, CONSTRAINT `fk_ci` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`))
-- There is an error since the Acct table is not completely clean to input a new entry

#1.9
ALTER TABLE Acct
DROP budget_id;

ALTER TABLE Category
ADD budget_id int;

ALTER TABLE Category 
ADD CONSTRAINT fk_cb 
FOREIGN KEY (budget_id) 
REFERENCES Budget(budget_id);

ALTER TABLE Journal
ADD CONSTRAINT fk_from
FOREIGN KEY(from_acct_id) 
REFERENCES Acct(acct_id);

ALTER TABLE Journal 
ADD CONSTRAINT fk_to
FOREIGN KEY (to_acct_id) 
REFERENCES Acct(acct_id);

#1.10
INSERT INTO Category(description, budget_id) VALUES('Clothing', 1);
INSERT INTO Acct VALUES(10, 1, 'GAP', 3);
INSERT INTO Acct VALUES(11, 1, 'Old Navy', 3);
UPDATE Budget SET max_amt = 300.00
WHERE budget_id =1;
INSERT INTO Journal VALUES(95, 1, 10, '2018-04-10');
INSERT INTO Journal VALUES(180, 1, 11, '2018-02-23');

#1.11
SELECT DISTINCT a.description, j.amount 
FROM Acct a RIGHT JOIN Journal j
ON a.acct_id = j.to_acct_id
JOIN Category
ON a.category_id = 3;

#1.12
DELETE FROM Acct
WHERE acct_id = 6;
-- Error Code: 1451. Cannot delete or update a parent row: a foreign key constraint fails (`hw5`.`journal`, CONSTRAINT `fk_from` FOREIGN KEY (`from_acct_id`) REFERENCES `acct` (`acct_id`))

#1.13
DELETE FROM Journal
WHERE from_acct_id = 6;

DELETE FROM Journal
WHERE to_acct_id = 6;

#1.14
ALTER TABLE Category DROP FOREIGN KEY fk_cb;

ALTER TABLE Category 
ADD CONSTRAINT fk_cb 
FOREIGN KEY (budget_id) 
REFERENCES Budget(budget_id)
ON DELETE CASCADE;

#1.15
INSERT INTO Category(description, budget_id) 
VALUES('College Expense', 3);

DELETE FROM Budget
WHERE budget_id = 3;

#1.16
SELECT * FROM Category;
SELECT * FROM Budget;

#2.1
CREATE TRIGGER tg_journal
BEFORE INSERT 
ON JOURNAL
WHEN 

#2.2
INSERT INTO Journal VALUES(100, 1, 7, '2018-03-22');

#2.3
SELECT * FROM Journal;

#3.1
CREATE INDEX idx_acct
ON Acct(description);