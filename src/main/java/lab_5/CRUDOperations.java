package lab_5;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class CRUDOperations {

    // Метод для додавання нового студента
    public void addStudent(List<Student> studentList, int id, String firstName, String lastName, LocalDate birthDate, String recordBookNumber) {
        Student student = new Student(id, firstName, lastName, birthDate, recordBookNumber);  // Створення нового студента з номером залікової книжки
        studentList.add(student);
        System.out.println("Student added: " + student);
    }

    // Метод для оновлення студента за його id
    public void updateStudent(List<Student> studentList, int id, String firstName, String lastName, LocalDate birthDate, String recordBookNumber) {
        Optional<Student> studentOpt = studentList.stream()
                .filter(student -> student.getId() == id)
                .findFirst();

        if (studentOpt.isPresent()) {
            Student student = studentOpt.get();
            student.setFirstName(firstName);
            student.setLastName(lastName);
            student.setBirthDate(birthDate);
            student.setRecordBookNumber(recordBookNumber);  // Оновлення номера залікової книжки
            System.out.println("Student updated: " + student);
        } else {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    // Метод для видалення студента за його id
    public void deleteStudent(List<Student> studentList, int id) {
        Optional<Student> studentOpt = studentList.stream()
                .filter(student -> student.getId() == id)
                .findFirst();

        if (studentOpt.isPresent()) {
            studentList.remove(studentOpt.get());
            System.out.println("Student deleted: " + studentOpt.get());
        } else {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    // Метод для пошуку студента за його id
    public void findStudentById(List<Student> studentList, int id) {
        Optional<Student> studentOpt = studentList.stream()
                .filter(student -> student.getId() == id)
                .findFirst();

        if (studentOpt.isPresent()) {
            System.out.println("Student found: " + studentOpt.get());
        } else {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    // Метод для виведення всіх студентів
    public void listAllStudents(List<Student> studentList) {
        if (studentList.isEmpty()) {
            System.out.println("No students found.");
        } else {
            studentList.forEach(student -> System.out.println(student));
        }
    }
}
