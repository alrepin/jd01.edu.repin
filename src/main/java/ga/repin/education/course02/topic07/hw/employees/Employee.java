package ga.repin.education.course02.topic07.hw.employees;

import java.util.Objects;

/**
 * Simple JavaBean domain object representing an employee.
 *
 * @author Alexey Repin
 */

public class Employee {

    private final String firstName;
    private final String lastName;
    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    @Override
    public final String toString() {
        return "{ \"firstName\": \"" + this.firstName + "\", \"firstName\": \"" + this.lastName + "\" }";
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || this.getClass() != other.getClass()) {
            return false;
        }
        Employee otherAuthor = (Employee) other;
        if (this.hashCode() != other.hashCode()) {
            return false;
        }
        return this.getFirstName().equals(otherAuthor.getFirstName()) && this.getLastName().equals(otherAuthor.getLastName());
    }

    @Override
    public final int hashCode() {
        return Objects.hash(this.firstName, this.lastName);
    }
}