package lab_2;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Створення списку студентів
        List<Student> students = new ArrayList<>();
        students.add(new Student("John", "Doe", LocalDate.of(2000, 1, 15), "RB12345"));
        students.add(new Student("Jane", "Smith", LocalDate.of(1999, 6, 23), "RB67890"));
        students.add(new Student("Alice", "Johnson", LocalDate.of(2001, 8, 30), "RB54321"));

        StudentService studentService = new StudentService();

        // Фільтрація студентів за прізвищем
        System.out.println("Фільтрація за прізвищем 'Doe':");
        studentService.filterByLastName(students, "Doe").forEach(System.out::println);

        // Сортування студентів за датою народження
        System.out.println("\nСортування за датою народження:");
        studentService.sortByBirthDate(students).forEach(System.out::println);

        // Сортування студентів за прізвищем
        System.out.println("\nСортування за прізвищем:");
        studentService.sortByLastName(students).forEach(System.out::println);

        // Створення списку успішності
        List<Performance> performances = new ArrayList<>();
        performances.add(new Performance("Math", "Dr. Brown", LocalDate.of(2024, 5, 20), 85));
        performances.add(new Performance("Math", "Dr. Brown", LocalDate.of(2024, 5, 21), 90));
        performances.add(new Performance("History", "Dr. White", LocalDate.of(2024, 6, 10), 75));

        PerformanceService performanceService = new PerformanceService();

        // Обчислення середнього балу
        System.out.println("\nСередній бал за предметами:");
        performanceService.calculateAverageGrade(performances).forEach((subject, avg) ->
                System.out.printf("%s: %.2f%n", subject, avg));
    }
}
