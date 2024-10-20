import java.time.LocalDate;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager("Иван Иванов", 50000, "2023-01-15", Gender.MALE);
        Employee employee1 = new Employee("Петр Петров", 40000, "2022-10-20", Gender.MALE);
        Employee employee2 = new Employee("Мария Иванова", 35000, "2023-03-10", Gender.FEMALE);

        Employee[] employees = {manager, employee1, employee2};

        Manager.raiseSalaries(employees);

        System.out.println("Список сотрудников после повышения зарплаты:");
        Arrays.stream(employees).forEach(System.out::println);

        // Поздравления
        LocalDate today = LocalDate.now();
        greetEmployees(employees, today);
    }

    public static void greetEmployees(Employee[] employees, LocalDate today) {
        Holiday holiday = getHoliday(today);

        for (Employee employee : employees) {
            switch (holiday) {
                case NEW_YEAR:
                    System.out.println("С Новым годом, " + employee.getName() + "!");
                    break;
                case MARCH_8:
                    if (employee.getGender() == Gender.FEMALE) {
                        System.out.println("С 8 Марта, " + employee.getName() + "!");
                    }
                    break;
                case FEBRUARY_23:
                    if (employee.getGender() == Gender.MALE) {
                        System.out.println("С 23 Февраля, " + employee.getName() + "!");
                    }
                    break;
            }
        }
    }

    private static Holiday getHoliday(LocalDate date) {
        if (date.getMonthValue() == 1 && date.getDayOfMonth() == 1) {
            return Holiday.NEW_YEAR;
        } else if (date.getMonthValue() == 3 && date.getDayOfMonth() == 8) {
            return Holiday.MARCH_8;
        } else if (date.getMonthValue() == 2 && date.getDayOfMonth() == 23) {
            return Holiday.FEBRUARY_23;
        } else {
            return Holiday.NO_HOLIDAY;
        }
    }
}