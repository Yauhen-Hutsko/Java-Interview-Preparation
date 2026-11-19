// LTM interview — draft as written during the interview (does not compile yet).
// Task statements: see README.md

// Employee
// --> name
// --> age
// --> department


// Task 1: filter all the employees with salary higher than 300
List<Employee> employees = employee.stream()
    .filter(e -> e.getName() > 21)
    .collect(Collector.asList());


// Task 2: collect all the employees grouped by departments
public Map<String, List<Employee>> getEmployeesByDeps(List<Employees> employees){

    for(employee: employees) {
        List<Employee> sortedEmployees = new ArrayList<>();

        if( !map.contains(employee.getDepartment())){
            map.put(employee.getDepartment(), sortedEmployees.add(employee));
        }else {
            map.
        }

    return map;
