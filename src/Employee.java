import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

class Employee {
    private final String name;
    private int salary;
    private final LocalDate hireDate;
    private Gender gender; // Добавлено поле Gender

    public Employee(String name, int salary, String hireDateString, Gender gender) {
        this.name = name;
        this.salary = salary;
        this.hireDate = parseDate(hireDateString);
        this.gender = gender;
    }

    public static int compareDates(String dateStr1, String dateStr2) {
        LocalDate date1 = parseDate(dateStr1);
        LocalDate date2 = parseDate(dateStr2);

        return date1.compareTo(date2);
    }

    private static LocalDate parseDate(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            return LocalDate.parse(dateString, formatter);
        } catch (DateTimeParseException e) {
            System.err.println("Неверный формат даты: " + dateString);
            return null;
        }
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", hireDate=" + hireDate +
                ", gender=" + gender +
                '}';
    }
}
