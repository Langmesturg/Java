package lab_5;
import java.util.Objects;
import java.util.regex.Pattern;

public class Group {

    private String groupNumber;
    private int creationYear;
    private String department;
    private String curatorFirstName;
    private String curatorLastName;

    public Group(String groupNumber, int creationYear, String department, String curatorFirstName, String curatorLastName) {
        this.groupNumber = groupNumber;
        this.creationYear = creationYear;
        this.department = department;
        this.curatorFirstName = curatorFirstName;
        this.curatorLastName = curatorLastName;
    }

    public String getGroupNumber() {
        return groupNumber;
    }

    public int getCreationYear() {
        return creationYear;
    }

    public String getDepartment() {
        return department;
    }

    public String getCuratorFirstName() {
        return curatorFirstName;
    }

    public String getCuratorLastName() {
        return curatorLastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return creationYear == group.creationYear && groupNumber.equals(group.groupNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupNumber, creationYear);
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupNumber='" + groupNumber + '\'' +
                ", creationYear=" + creationYear +
                ", department='" + department + '\'' +
                ", curator='" + curatorFirstName + " " + curatorLastName + '\'' +
                '}';
    }

    public static class GroupBuilder {
        private String groupNumber;
        private int creationYear;
        private String department;
        private String curatorFirstName;
        private String curatorLastName;

        public GroupBuilder(String groupNumber) {
            if (groupNumber == null || groupNumber.isEmpty()) {
                throw new IllegalArgumentException("Group number cannot be empty.");
            }
            this.groupNumber = groupNumber;
        }

        public GroupBuilder yearOfCreation(int year) {
            if (year < 1900 || year > 2100) {
                throw new IllegalArgumentException("Creation year must be between 1900 and 2100.");
            }
            this.creationYear = year;
            return this;
        }

        public GroupBuilder department(String department) {
            if (department == null || department.isEmpty()) {
                throw new IllegalArgumentException("Department cannot be empty.");
            }
            this.department = department;
            return this;
        }

        public GroupBuilder curatorFirstName(String firstName) {
            if (firstName == null || firstName.isEmpty()) {
                throw new IllegalArgumentException("Curator first name cannot be empty.");
            }
            this.curatorFirstName = firstName;
            return this;
        }

        public GroupBuilder curatorLastName(String lastName) {
            if (lastName == null || lastName.isEmpty()) {
                throw new IllegalArgumentException("Curator last name cannot be empty.");
            }
            this.curatorLastName = lastName;
            return this;
        }

        public Group build() {
            // Виконуємо валідацію на рівні всіх полів перед створенням об'єкта
            validateFields();

            return new Group(groupNumber, creationYear, department, curatorFirstName, curatorLastName);
        }

        private void validateFields() {
            StringBuilder errors = new StringBuilder();

            if (groupNumber == null || groupNumber.isEmpty()) {
                errors.append("Invalid group number: cannot be empty.\n");
            } else if (!Pattern.matches("^[A-Za-z0-9]+$", groupNumber)) {
                errors.append("Invalid group number: must be alphanumeric.\n");
            }

            if (creationYear < 1900 || creationYear > 2100) {
                errors.append("Invalid creation year: must be between 1900 and 2100.\n");
            }

            if (department == null || department.isEmpty()) {
                errors.append("Invalid department: cannot be empty.\n");
            }

            if (curatorFirstName == null || curatorFirstName.isEmpty()) {
                errors.append("Invalid curator first name: cannot be empty.\n");
            }

            if (curatorLastName == null || curatorLastName.isEmpty()) {
                errors.append("Invalid curator last name: cannot be empty.\n");
            }

            if (errors.length() > 0) {
                throw new IllegalArgumentException("Validation errors: \n" + errors.toString());
            }
        }
    }
}
