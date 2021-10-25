package com.mindex.challenge.service;

import com.mindex.challenge.data.Employee;
/**
 * Contract that lays out the necessary methods to be implemented by EmployeeService implementations
 */
public interface EmployeeService {
    /**
     * Attempts to create and store an {@link com.mindex.challenge.data.Employee}  in the {@link com.mindex.challenge.dao.EmployeeRepository} 
     * @param employee the {@link com.mindex.challenge.data.Employee}  to be created and stored 
     * @return the created and stored {@link com.mindex.challenge.data.Employee} 
     */
    Employee create(Employee employee);
    
    /**
     * Attempts to find and return an {@link com.mindex.challenge.data.Employee}  with a given employeeId
     * @param id the employeeId that the desired {@link com.mindex.challenge.data.Employee}  has
     * @return the found {@link com.mindex.challenge.data.Employee} 
     */
    Employee read(String id);
    
    /**
     * Attempts to update a given {@link com.mindex.challenge.data.Employee} in the {@link com.mindex.challenge.dao.EmployeeRepository} 
     * @param employee the {@link com.mindex.challenge.data.Employee}  to be updated
     * @return the updated {@link com.mindex.challenge.data.Employee} 
     */
    Employee update(Employee employee);
}
