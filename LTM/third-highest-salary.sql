-- LTM interview — draft as written during the interview (unfinished).
-- Task: find the employee with the third highest salary.
--
-- Employee
--   - id
--   - name
--   - salary

SELECT e.name
FROM employee e
WHERE e.salary < (SELECT 1 FROM employee WHERE e.salary < MAX(e.salary) )
