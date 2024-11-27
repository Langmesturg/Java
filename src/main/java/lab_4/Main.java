package lab_4;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Введення для Group
        try {
            Group group = new Group.GroupBuilder("CS101")
                    .yearOfCreation(1889)  // Виходить за межі допустимого діапазону (1900-2100)
                    .department("Computer Science")
                    .curatorFirstName("John")
                    .curatorLastName("Doe")
                    .build();
        } catch (IllegalArgumentException e) {
            System.out.println("Error creating group: " + e.getMessage());
        }

        // Введення для Student
        try {
            Student student = new Student.StudentBuilder("Alice", "Smith")
                    .birthDate(LocalDate.parse("2025-05-12"))  // Дата народження в майбутньому
                    .recordBookNumber("123456789012345678901234567890123456789012345678901")  // Більше 50 символів
                    .build();
        } catch (IllegalArgumentException e) {
            System.out.println("Error creating student: " + e.getMessage());
        }
    }
}
