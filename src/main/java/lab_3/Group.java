package lab_3;
import java.util.Objects;

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
            this.groupNumber = groupNumber;
        }

        public GroupBuilder yearOfCreation(int year) {
            this.creationYear = year;
            return this;
        }

        public GroupBuilder department(String department) {
            this.department = department;
            return this;
        }

        public GroupBuilder curatorFirstName(String firstName) {
            this.curatorFirstName = firstName;
            return this;
        }

        public GroupBuilder curatorLastName(String lastName) {
            this.curatorLastName = lastName;
            return this;
        }

        public Group build() {
            return new Group(groupNumber, creationYear, department, curatorFirstName, curatorLastName);
        }
    }
}
