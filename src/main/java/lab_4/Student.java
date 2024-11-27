package lab_4;
import java.time.LocalDate;
import java.util.Objects;
import java.util.regex.Pattern;

public class Student implements Comparable<Student> {

    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String recordBookNumber;

    public Student(String firstName, String lastName, LocalDate birthDate, String recordBookNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.recordBookNumber = recordBookNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getRecordBookNumber() {
        return recordBookNumber;
    }

    @Override
    public int compareTo(Student other) {
        return this.lastName.compareTo(other.lastName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(recordBookNumber, student.recordBookNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recordBookNumber);
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", recordBookNumber='" + recordBookNumber + '\'' +
                '}';
    }

    public static class StudentBuilder {
        private String firstName;
        private String lastName;
        private LocalDate birthDate;
        private String recordBookNumber;

        public StudentBuilder(String firstName, String lastName) {
            if (firstName == null || firstName.isEmpty()) {
                throw new IllegalArgumentException("First name cannot be empty.");
            }
            if (lastName == null || lastName.isEmpty()) {
                throw new IllegalArgumentException("Last name cannot be empty.");
            }
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public StudentBuilder birthDate(LocalDate birthDate) {
            if (birthDate == null || birthDate.isAfter(LocalDate.now())) {
                throw new IllegalArgumentException("Invalid birth date: cannot be in the future.");
            }
            this.birthDate = birthDate;
            return this;
        }

        public StudentBuilder recordBookNumber(String recordBookNumber) {
            if (recordBookNumber == null || recordBookNumber.isEmpty()) {
                throw new IllegalArgumentException("Record book number cannot be empty.");
            } else if (!Pattern.matches("^[A-Za-z0-9]+$", recordBookNumber)) {
                throw new IllegalArgumentException("Invalid record book number: must be alphanumeric.");
            }
            this.recordBookNumber = recordBookNumber;
            return this;
        }

        public Student build() {
            // Виконуємо валідацію на рівні всіх полів перед створенням об'єкта
            validateFields();
            return new Student(firstName, lastName, birthDate, recordBookNumber);
        }

        private void validateFields() {
            StringBuilder errors = new StringBuilder();

            if (firstName == null || firstName.isEmpty()) {
                errors.append("Invalid first name: cannot be empty.\n");
            }

            if (lastName == null || lastName.isEmpty()) {
                errors.append("Invalid last name: cannot be empty.\n");
            }

            if (birthDate == null || birthDate.isAfter(LocalDate.now())) {
                errors.append("Invalid birth date: cannot be in the future.\n");
            }

            if (recordBookNumber == null || recordBookNumber.isEmpty()) {
                errors.append("Invalid record book number: cannot be empty.\n");
            } else if (!Pattern.matches("^[A-Za-z0-9]+$", recordBookNumber)) {
                errors.append("Invalid record book number: must be alphanumeric.\n");
            }

            if (errors.length() > 0) {
                throw new IllegalArgumentException("Validation errors: \n" + errors.toString());
            }
        }
    }
}
