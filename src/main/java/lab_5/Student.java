package lab_5;
import java.time.LocalDate;
import java.util.Objects;
import java.util.regex.Pattern;

public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String recordBookNumber; // Додано поле для залікової книжки

    // Конструктор з усіма полями
    public Student(int id, String firstName, String lastName, LocalDate birthDate, String recordBookNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.recordBookNumber = recordBookNumber;
    }

    // Перевантажений конструктор без поля recordBookNumber
    public Student(int id, String firstName, String lastName, LocalDate birthDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.recordBookNumber = ""; // Якщо запис не має номера залікової книжки
    }

    // Геттери та сеттери
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getRecordBookNumber() {
        return recordBookNumber;
    }

    public void setRecordBookNumber(String recordBookNumber) {
        this.recordBookNumber = recordBookNumber;
    }

    // Перевизначення equals та hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && Objects.equals(firstName, student.firstName) && Objects.equals(lastName, student.lastName) && Objects.equals(birthDate, student.birthDate) && Objects.equals(recordBookNumber, student.recordBookNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, birthDate, recordBookNumber);
    }

    // Перевизначення toString
    @Override
    public String toString() {
        return "Student{id=" + id + ", firstName='" + firstName + "', lastName='" + lastName + "', birthDate=" + birthDate + ", recordBookNumber='" + recordBookNumber + "'}";
    }
}
