# Tesco — Skill-Based Pay Calculator

> 🚧 Solution is work in progress: [SkillBasedPayCalculator.java](SkillBasedPayCalculator.java)

## Task

Tesco wants to implement a skill-based pay system to reward employees for their specialised skills. This system will provide differential pay in addition to their regular contracted pay. In the first phase, Tesco is only paying based on the contract and the skill they worked on. Write a Skill-based pay calculation system to calculate the total pay for a week for the given colleagues.

#### As a future enhancement, Tesco plans to introduce:
- different rates for overtime hours
- extra loyalty bonus for length of service

### Input:

You will be provided with a list of employees, each with the following information:
- Employee id
- List of shifts worked.
- Contract Type

Each shift will have the following information:
- Shift id
- Skill
- Duration

Example Json representation of the input
```
{
  "employees": [
    {
      "id": 1001,
      "contractType": "permanent",
      "shifts": [
        {
          "id": 1001,
          "skill": "Bakery",
          "duration": 8
        },
        {...}
      ]
    },
    {...}
  ]
}
```

### Skill Pay
| Skill            | Pay Rate  |
|------------------|-----------|
| Bakery           | £2/hour   |
| Checkout Cashier | £1.2/hour |
| Customer Service | £1.3/hour |
| Shift Leader     | £3/hour   |
| Security         | £1/hour   |
| Cleaning         | £1/hour   |
| Delivery Driver  | £2/hour   |

### Contract Pay
| Contract type  | Pay Rate   |
|----------------|------------|
| Permanent      | £12.5/hour |
| Agency         | £13/hour   |
| Zero-hours     | £13/hour   |

### Output:

For each employee, calculate and display their total weekly pay, including their contracted pay and the differential pay based on their worked skills.

Employee-1 -> 250.5
Employee-2 -> 140
Employee-3 -> 173.5

### Example:
employee:

|id.   | Contract Type |
|------|---------------|
| 1001 | Pernament     |

his shifts:

| id.  | Skill             | Dur.|
|------|-------------------|-----|
| 1001 | Bakery            | 8h  |
| 1002 | Checkout Cashier  | 4h  |
| 1003 | Security          | 4h  |
| 1004 | Cleaning          | 6h  |
| total|                   | 22h |

Contract salary: 22 x 12.5 = 275
Skill salary: 8 x 2 + 4 x 1.2 + 4 x 1 + 6 x 1 = 30.8
Total salary: 305.8
