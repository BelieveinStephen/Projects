#Stevie Scheid
#USE hw4;
#2018-06-15 21:52:18	c9bf52b10666d8d333c7a0b8ba3aeb9a5ba82d80

#1.1
DROP TABLE journal;
DROP TABLE acct;

#1.2
CREATE TABLE Journal (
	amount decimal(9,2) DEFAULT 100,
    from_acct_id int,
    to_acct_id int,
    t_date datetime,
    PRIMARY KEY (t_date, amount)
);

CREATE TABLE Acct (
	acct_id int,
    acct_type Boolean,
    description varchar(30),
    PRIMARY KEY (acct_id)
);

#1.3
INSERT INTO Acct VALUES(1, 0, 'cash');
INSERT INTO Acct VALUES(2, 0, 'checking');
INSERT INTO Acct VALUES(3, 0, 'saving');
INSERT INTO Acct VALUES(4, 1, 'food');
INSERT INTO Acct VALUES(5, 1, 'rent');
INSERT INTO Acct VALUES(6, 1, 'college');
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

#1.4
INSERT INTO Journal VALUES(30, 1, 4, '2018-06-16');

#1.5
-- No errors

#1.6
INSERT INTO Acct VALUES(NULL, 1, 'Car');

#1.7
-- Error Code: 1048. Column 'acct_id' cannot be null
-- problem is that SQL does not allow primary keys to be NULL

#1.8
INSERT INTO Journal(from_acct_id, to_acct_id, t_date) VALUES(2, 1, NOW());

#1.9
SELECT * FROM Journal WHERE t_date = NOW();
-- The default value of 100 was entered

#2.1
CREATE TABLE Budget(
budget_id int,
max_amt decimal(9,2),
warn_percent int,
start_date date,
end_date date,
PRIMARY KEY (budget_id)
);

#2.2
INSERT INTO Budget VALUES(1, 100.00, 50, '2018-10-13', '2019-10-13');
INSERT INTO Budget VALUES(2, 1000.00, 55, '2018-6-24', '2018-7-29');
INSERT INTO Budget VALUES(3, 10000.00, 59, '2018-10-10', '2018-10-30');

#3.1
INSERT INTO Budget(budget_id, max_amt, start_date, end_date) VALUES(4, 40000.00, '2018-5-15', '2018-8-20');

#3.2
ALTER TABLE Budget ALTER COLUMN warn_percent SET DEFAULT 80;

#3.3
INSERT INTO Budget(budget_id, max_amt, start_date, end_date) VALUES(5, 5000.00, '2017-2-15', '2018-5-25');

#3.4
SELECT * FROM Budget;
-- the warn percent is now 80

#3.5
ALTER TABLE Budget DROP start_date, DROP end_date;

#3.6
ALTER TABLE Acct ADD budget_id int NOT NULL DEFAULT 1;

#3.7
SELECT * FROM Acct;
-- the budget_id column was added to the table

#3.8
INSERT INTO Budget VALUES(6, 2000.00, 95);
INSERT INTO Acct VALUES(7, 1, 'travel', 6); 
