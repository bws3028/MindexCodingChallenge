package com.mindex.challenge.dao;

import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.Employee;

import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.repository.MongoRepository;


/**
 * MongoRepository that hold {@link com.mindex.challenge.data.Compensation}  objects. Compensations map
 * to their {@link com.mindex.challenge.data.Employee} .
 * 
 */
@Qualifier("compensations")
@Repository
public interface CompensationRepository extends MongoRepository<Compensation, Employee> {
    /**
     * Finds a {@link com.mindex.challenge.data.Compensation}  in the Repository given an Employee
     * @param employee the 'id' the {@link com.mindex.challenge.data.Compensation}  is mapped to
     * @return the {@link com.mindex.challenge.data.Compensation}  that has the {@link com.mindex.challenge.data.Employee}  employee 
     */
    Compensation findCompensationByEmployee(Employee employee);
}
