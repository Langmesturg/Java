package lab_2;
import java.util.*;
import java.util.stream.Collectors;

public class StudentService {

    // Метод для фільтрації студентів за прізвищем
    public List<Student> filterByLastName(List<Student> students, String lastName) {
        return students.stream()
                .filter(student -> student.getLastName().equalsIgnoreCase(lastName))
                .collect(Collectors.toList());
    }

    // Метод для сортування студентів за датою народження (Comparator)
    public List<Student> sortByBirthDate(List<Student> students) {
        return students.stream()
                .sorted(Comparator.comparing(Student::getBirthDate))
                .collect(Collectors.toList());
    }

    // Метод для сортування студентів за прізвищем (Comparable)
    public List<Student> sortByLastName(List<Student> students) {
        Collections.sort(students);
        return students;
    }
}
