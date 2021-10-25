package com.mindex.challenge.data;

/**
 * Object representation of the Compensation data type
 */
public class Compensation {
    
    //The Employee linked to this Compensation data object
    private Employee employee;

    //The salary of the Employee
    private float salary;

    //The date the salary should be paid out
    private String effectiveDate;

    //Utilized for Spring Boot dependency injection
    public Compensation(){
    }
    
    /**
     * Accesses the {@link com.mindex.challenge.data.Employee}  linked to this Compensation
     * @return the {@link com.mindex.challenge.data.Employee}  linked to this Compensation
     */
    public Employee getEmployee() {
        return this.employee;
    }

    /**
     * Sets the Compensation's employee to the given employee
     * @param employee the {@link com.mindex.challenge.data.Employee}  this Compensations employee field is to be set to
     */
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    /**
     * Accesses the salary stored in this Compensation
     * @return the salary stored in this Compensation
     */
    public float getSalary() {
        return this.salary;
    }

    /**
     * Sets the salary field to the given salary
     * @param salary the value the given salary is to be set to
     */
    public void setSalary(float salary) {
        this.salary = salary;
    }

    /**
     * Acceses the effectiveDate stored in this Compensation
     * @return the effectiveDate stored in this Compensation
     */
    public String getEffectiveDate() {
        return this.effectiveDate;
    }

    /**
     * Sets the effectiveDate field stored in this Compensation
     * @param effectiveDate the value to set the effectiveDate field to
     */
    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }
}