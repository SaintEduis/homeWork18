package pro.sky.coursecorkcefactoring;

public class Employee {
    private String firstName;
    private String lastName;


    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstNameOfWorker() {
        return this.firstName;
    }

    public String getLastNameOfWorker() {
        return this.lastName;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(this.toString());
    }

    @Override
    public boolean equals(Object other) {
        if (this.getClass() != other.getClass()) {
            return false;
        }
        Employee em2 = (Employee) other;
        return this.toString().equals(other.toString());
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}