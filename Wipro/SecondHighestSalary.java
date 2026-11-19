// Wipro interview (?) — Find the second-highest salary from employees.

static void main() {

    List<Employee> employees= Arrays.asList(
            new Employee("Alex", 900),
            new Employee("Bruce", 600),
            new Employee("Joy", 200),
            new Employee("Brown", 100),
            new Employee("Mathew", 500)
    );
    System.out.println(employees.stream()
            .sorted((a,b)->b.salary()-a.salary()) //or .sorted((Comparator.comparingInt(Employee::salary)).reversed())

                    .limit(2)
                    .skip(1)
            .collect(Collectors.toList()));
}

record Employee(String name, int salary) {
}
