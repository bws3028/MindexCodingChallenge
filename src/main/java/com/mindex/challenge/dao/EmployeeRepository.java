package com.mindex.challenge.dao;

import com.mindex.challenge.data.Employee;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * MongoRepository that hold {@link com.mindex.challenge.data.Employee}  objects. Employees map
 * to their employeeId.
 * 
 */
@Qualifier("employees")
@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {
    /**
     * Finds and returns a desired {@link com.mindex.challenge.data.Employee}  based on its employeeId if it exists in the EmployeeRpository. 
     * @param employeeID the employeeId of the {@link com.mindex.challenge.data.Employee}  that is desired to be found
     * @return the desired {@link com.mindex.challenge.data.Employee} 
     */
    Employee findByEmployeeId(String employeeID);
}
