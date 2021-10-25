package com.mindex.challenge;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


/**
 * Bootstraps the {@link com.mindex.challenge.dao.EmployeeRepository}  with data from the provide employee_database.json file
 */
@Component
public class DataBootstrap {
    private static final String DATASTORE_LOCATION = "/static/employee_database.json";

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * Bootstraps the {@link com.mindex.challenge.dao.EmployeeRepository} 
     */
    @PostConstruct
    public void init() {
        InputStream inputStream = this.getClass().getResourceAsStream(DATASTORE_LOCATION);

        Employee[] employees = null;

        try {
            employees = objectMapper.readValue(inputStream, Employee[].class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        

        for (Employee employee : employees) {
            employeeRepository.insert(recursiveDirectReportEmployeeInitialization(employee, employees));
        }    
    }

    
    /**
     * The recursiveDirectReportEmployeeInitialization method is used to edit the Employees' directReport lists
     * in order to ensure that the {@link com.mindex.challenge.data.Employee}  objects contained within these lists are null when necessary
     * but are fully initialized with non-null fields when they contain Employees. The original method
     * initialized these lists with Employee objects that had null fields for every field but the employeeID.
     * Any level of nesting of Employees within these lists should be capable of being processed due to the use
     * of recursion. This was created in an effort to decrease coupling, increase cohesion and ensure a good
     * level of encapsulation within the data classes Employee.java and ReportingStructure.java by preventing
     * api calls in a data class method.
     * 
     * Improvetments: This method should be improved to help improve performance.
     *                  Ideally, the employees would be ordered in a way that the ones at the bottom could be
     *                  created and used to build the ones at the top without having to be recreated. This would
     *                  require an initial sorting of the lists into something like a dictionairy with the 
     *                  employeeId as a key and a value of an array of employees that contain the current employee
     *                  within their directReports indexed by reverse order in the reporting structure (higer up
     *                  comes later in the array). I chose to prioritize the other functionality, however, as this
     *                  was not listed in the tasks.
     * 
     * @param employee: The current employee to be checked and possibly have its directReport Employee list
     *                   modified possibly followed up by the Employees held within their directReport list
     *                   and so on until the base case is met.
     * @param employees: The array of fully initalized employees initially read from the 
     *                    employee_database.json file.
     * @return The given Employee with a modified, fully initialized directReport list of Employees held within 
     *          their initial directReport list and all Employees nested at any level within the 
     *          ReportingStructure beneath them.
     */
    private static Employee recursiveDirectReportEmployeeInitialization(Employee employee, Employee[] employees){
        List<Employee> directReports = new ArrayList<Employee>(); //list of initialized Employees that will be built up with recursion and then set to each Employee recursed through
        Employee initializedEmployee = getInitializedEmployee(employee.getEmployeeId(), employees);
        if(initializedEmployee.getDirectReports() == null){
            return initializedEmployee;
        }
        else{
            for(Employee currentDirectReportEmployee: initializedEmployee.getDirectReports()){ //loop through Employee's directReports and recurse through them
                Employee initializedCurrentDirectReportEmployee = getInitializedEmployee(currentDirectReportEmployee.getEmployeeId(), employees);
                directReports.add(recursiveDirectReportEmployeeInitialization(initializedCurrentDirectReportEmployee, employees));
                employee.setDirectReports(directReports);
            }
        }
        return employee;
    
       
    }

    /**
     * The getInitializedEmployee method is a helper method used to provide a version of a requested {@link com.mindex.challenge.data.Employee} 
     *  hat is fully initialized given the desired Employee's employeeID and that the Employee exists in the employees
     * array. This is useful as the Employees contained in the directReports Employee lists are only initialized with
     * their employeeID. This id can be utilized to access the fully initialized version of the Employees stored in
     * the employees array in this class.
     * @param desiredEmployeeID: The employeeID of the {@link com.mindex.challenge.data.Employee}  that the fully initialized version is wanted.
     * @param employees: The array of fully initalized employees initially read ffrom the 
     *                    employee_database.json file.
     * @return The fully initialized version of an Employee determined by a given id.
     */
    private static Employee getInitializedEmployee(String desiredEmployeeID, Employee[] employees){
            for(int currentEmployeeIndex = 0; currentEmployeeIndex < employees.length; currentEmployeeIndex++){ //loop through eployees array
                Employee currentAccesedEmployee = employees[currentEmployeeIndex]; 
                String currentAccessedEmployeeID = currentAccesedEmployee.getEmployeeId();
                if(currentAccessedEmployeeID.equals(desiredEmployeeID)){ //finds fully initialized Employee if it exists in the list
                    return employees[currentEmployeeIndex]; //returns fully initialized Employee
                }
            }
            return null;
        }
    }
