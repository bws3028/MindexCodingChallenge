package com.mindex.challenge.data;

/**
 * Object representation of the ReportingStructure data type
 */
public class ReportingStructure {

    //The Employee linked to this ReporthingStructure. Base employee used in recursive function to calculate its numberOfReports.
    private Employee employee;

    //The number of Employees within the entire nested list structure of this ReportingStructure's Employee's directReport list.
    private int numberOfReports;

    //created for Spring Boot dependency injection
    public ReportingStructure(){
    }

    /**
     * Creates a ReportingStructure that has its numberOfReports immediately calculated on creation.
     * @param employee the Employee to set this ReportingStructure's employee object to.
     */
    public ReportingStructure(Employee employee){
        this.employee = employee;
        this.numberOfReports = numberOfDirectReportsRecursion(this.employee);
    }

    /**
     * Accesses the ReportingStructure's {@link com.mindex.challenge.data.Employee} 
     * @return the ReportingStructure's {@link com.mindex.challenge.data.Employee} 
     */
    public Employee getEmployee(){
        return this.employee;
    }

    /**
     * Set this ReportingStructure's employee to the given employee
     * @param employee the employee to set this objects {@link com.mindex.challenge.data.Employee}  to
     */
    public void setEmployee(Employee employee){
        this.employee = employee;
    }

    /**
     * Accesses the ReportingStructure's numberOfReports in its full reporting structure
     * @return the ReportingStructures numberOfReports
     */
    public int getNumberOfReports(){
        return this.numberOfReports;
    }

    /**
     * Modify the ReportingStructure's numberOfReports to be set to the given int
     * @param numberOfReports the int that the numberOfReports is to be set to
     */
    public void setNumberOfReports(int numberOfReports){
        this.numberOfReports = numberOfReports;
    }
    
    /**
     * Recursively traverses the list of lists contained within the directReport list within
     * a given {@link com.mindex.challenge.data.Employee} . Any depth of list's within list's of Employees can be proccessed
     * due to the use of recursion. The count of number of Employees held within this nested list
     * structure is found.
     * @param emp The {@link com.mindex.challenge.data.Employee} to have its directReport lists traveresed and counted
     * @return the count of total Employees in the direct report structure of the first {@link com.mindex.challenge.data.Employee} 
     *          passed into the method
     */
    private static int numberOfDirectReportsRecursion(Employee emp){
        int count = 0;
        if(emp.getDirectReports() != null){
            for(Employee currentDependent: emp.getDirectReports()){  
                count = count + 1 + numberOfDirectReportsRecursion(currentDependent);
            }
        }
        return count;  
    }

}
