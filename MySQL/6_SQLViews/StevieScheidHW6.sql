#Stevie Scheid
#USE hw3
#'2018-06-29 18:26:30'	'f7f7de73d9fecd27a275eeef8e7e97ebf13c89a6'

#1.1
CREATE VIEW JournalR 
AS SELECT j.*, a.description
FROM Acct a, Journal j
WHERE j.to_acct_id = a.acct_id AND a.acct_type = 1;

#1.2
UPDATE JournalR
SET amount = 650
WHERE description = 'rent';

#1.3
SELECT * FROM JournalR
WHERE description = 'rent';

#1.4
SELECT * FROM Journal
WHERE to_acct_id = 5;

#1.5
CREATE VIEW TotalAcctDetail
AS SELECT a.acct_id, 
a.description, 
a.category_id AS Category, 
SUM(j.amount) AS total_spent
FROM Acct a, 
Category c, 
Journal j
WHERE a.category_id = c.category_id 
AND j.to_acct_id = a.acct_id 
AND a.acct_type = 1
GROUP BY a.description;

#1.6
SELECT t.*, c.description 
FROM TotalAcctDetail t
JOIN Category c
ON t.category = c.category_id;

#1.7
Drop View ExpenseVBudget;
CREATE VIEW ExpenseVBudget
AS SELECT c.description AS Category, 
b.max_amt AS budgeted_money, 
t.total_spent,
CASE
	WHEN b.warn_percent*b.max_amt/100 < t.total_spent THEN 1
    ELSE 0
END AS AtRisk
FROM Category c, 
Budget b,
TotalAcctDetail t
WHERE t.category = c.category_id
AND b.budget_id = c.budget_id
GROUP BY c.description;

#1.8
UPDATE Budget SET warn_percent = 99 WHERE budget_id = 1;
-- There was no change to AtRisk since we are well below 99% of our budgeted amount
-- Currently we have spent 95$ and have a budget of 300$, if we changed it to something like
-- 25% we would then get an AtRisk of 1.