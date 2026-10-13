# Companies With More Than 10,000 Employees

Find companies that have more than `10000` employees.

The number of employees at several IT companies is stored in the `COMPANY` table. Print the IDs of all companies with more than `10000` employees. Order the results by `ID`.

## Table Schema

`COMPANY`

| Column | Type | Description |
|---|---|---|
| `ID` | Integer | Company ID in the inclusive range `[1, 1000]`. Primary key. |
| `NAME` | String | Company name, between `1` and `100` characters inclusive. |
| `EMPLOYEES` | Integer | Total number of employees in the company. |

## Sample Input

`COMPANY`

| ID | NAME | EMPLOYEES |
|---:|---|---:|
| 1 | Adobe | 28085 |
| 2 | Flipkart | 35543 |
| 3 | Amazon | 1089 |
| 4 | Paytm | 9982 |
| 5 | BookMyShow | 5589 |
| 6 | Oracle | 4003 |
| 7 | NIIT | 57782 |
| 8 | Samsung | 2000 |
| 9 | TCS | 10046 |
| 10 | Wipro | 3500 |

## Sample Output

```text
1
2
7
9
```

## Explanation

Adobe, Flipkart, NIIT, and TCS have more than `10000` employees, so their IDs are printed.
