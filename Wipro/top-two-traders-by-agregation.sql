
CREATE TABLE trades (id INT, trader VARCHAR(10), trade_date DATE, notional NUMERIC);
INSERT INTO trades VALUES
                       (1,'T1','2026-10-12',500),(2,'T2','2026-10-12',900),(3,'T3','2026-10-12',700),
                       (4,'T1','2026-10-12',400),(5,'T2','2026-10-13',300),(6,'T3','2026-10-13',800);

-- Task: top 2 traders by total notional for each trade_date
