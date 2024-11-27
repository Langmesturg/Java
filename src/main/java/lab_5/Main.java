package lab_5;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Список студентів для тестування CRUD-операцій
        List<Student> studentList = new ArrayList<>();

        // Створення об'єкта для роботи з CRUD операціями
        CRUDOperations crudOperations = new CRUDOperations();

        // Додавання студентів
        System.out.println("Adding students...");
        crudOperations.addStudent(studentList, 1, "John", "Doe", LocalDate.of(2000, 1, 1), "RB12345");
        crudOperations.addStudent(studentList, 2, "Jane", "Smith", LocalDate.of(1999, 5, 15), "RB67890");
        crudOperations.addStudent(studentList, 3, "Michael", "Johnson", LocalDate.of(2001, 3, 22), "RB11223");

        // Виведення всіх студентів
        System.out.println("\nListing all students...");
        crudOperations.listAllStudents(studentList);

        // Пошук студента за ID
        System.out.println("\nFinding student with ID 1...");
        crudOperations.findStudentById(studentList, 1);

        // Оновлення студента
        System.out.println("\nUpdating student with ID 1...");
        crudOperations.updateStudent(studentList, 1, "John", "Doe", LocalDate.of(2000, 1, 1), "RB54321");

        // Виведення оновлених даних студента
        System.out.println("\nListing all students after update...");
        crudOperations.listAllStudents(studentList);

        // Видалення студента
        System.out.println("\nDeleting student with ID 2...");
        crudOperations.deleteStudent(studentList, 2);

        // Виведення всіх студентів після видалення
        System.out.println("\nListing all students after deletion...");
        crudOperations.listAllStudents(studentList);
    }
}
