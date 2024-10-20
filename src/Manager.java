
class Manager extends Employee {
    public Manager(String name, int salary, String hireDateString, Gender gender) {
        super(name, salary, hireDateString, gender);
    }

    public static void raiseSalaries(Employee[] employees) {
        for (Employee employee : employees) {
            if (!(employee instanceof Manager)) {
                employee.setSalary(employee.getSalary() + 1000);
            }
        }
    }
}
