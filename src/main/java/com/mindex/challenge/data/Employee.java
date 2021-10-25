package com.mindex.challenge.data;

import java.util.List;

/**
 * The object representation of the Employee data type
 */
public class Employee {
    private String employeeId;
    private String firstName;
    private String lastName;
    private String position;
    private String department;
    private List<Employee> directReports;

    public Employee() {
    }

    /**
     * Accesses this Employee's employeeId
     * @return this Employee's employeeId
     */
    public String getEmployeeId() {
        return employeeId;
    }

    /**
     * Sets this Employee's employeeId to given employeeId
     * @param employeeId the employeeId to set this Employee's employeeid
     */
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * Accesses this Employee's firstName
     * @return this Employee's firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets this Employee's firstName to given firstName
     * @param firstName the firstName to set this Employee's firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Accesses this Employee's lastName
     * @return this Employee's lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets this Employee's lastName to given lastName
     * @param lastName the lastName to set this Employee's lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Accesses this Employee's
     * @return this Employee's
     */
    public String getPosition() {
        return position;
    }

    /**
     * Sets this Employee's employeeId to given employeeId
     * @param position the employeeId to set this Employee's employeeid
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * Accesses this Employee's department
     * @return this Employee's department
     */
    public String getDepartment() {
        return department;
    }

    /**
     * Sets this Employee's department to given department
     * @param department the department to set this Employee's department
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * Accesses this Employee's directReports
     * @return this Employee's directReports
     */
    public List<Employee> getDirectReports() {
        return directReports;
    }

    /**
     * Sets this Employee's directReports to given directReports
     * @param directReports the directReports to set this Employee's directReports
     */
    public void setDirectReports(List<Employee> directReports) {
        this.directReports = directReports;
    }

    /**
     * String representation of all of the fields in an Employee
     */
    @Override
    public String toString() {
        return "Employee ID: "+employeeId + "\nFirst Name: "+firstName + "\nLastName: "+lastName
         + "\nPosition: " + position + "\nDepartment: " + department + "\nDirect Reports:" + directReports;
    }
}
