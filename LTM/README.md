# LTM — Live-Coding Interview Notes

> 🚧 Drafts written during the interview, unfinished:
> [EmployeeStreams.java](EmployeeStreams.java) · [third-highest-salary.sql](third-highest-salary.sql)

## Domain

```
Employee
 ├── name
 ├── age
 └── department
```

## Tasks

### 1. Filter employees (Java Streams)

Filter all the employees with salary higher than 300 and collect them into a list.

> Note: the draft filters on `e.getName() > 21`, which doesn't match the statement (salary > 300),
> and the `Employee` model above has no `salary` field.

### 2. Group employees by department (Java)

Implement `Map<String, List<Employee>> getEmployeesByDeps(List<Employee> employees)` that collects
all the employees grouped by department.

### 3. Third highest salary (SQL)

Find the employee with the third highest salary.

```
Employee
 ├── id
 ├── name
 └── salary
```
