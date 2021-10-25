package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.CompensationRepository;
import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.service.CompensationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The business logic of {@link com.mindex.challenge.service.CompensationService}  implementations. Implements methods defined in 
 * {@link com.mindex.challenge.service.CompensationService}  used to create CompensationService's and store it into a repository
 * as well as find and return a {@link com.mindex.challenge.data.Compensation}  based on a given employeeId.
 */
@Service
public class CompensationServiceImpl implements CompensationService {

    private static final Logger LOG = LoggerFactory.getLogger(CompensationServiceImpl.class);

    @Autowired
    private CompensationRepository compensationRepository;

    /**
     * @see CompensationService
     */
    @Override
    public Compensation create(Compensation compensation) {
        LOG.debug("Creating compensation [{}]", compensation);

        compensationRepository.insert(compensation);

        return compensation;
    }

    /**
     * @see CompensationService
     */
    @Override
    public Compensation read(String id) {
        LOG.debug("Finding compensation with employee with id [{}]", id);

        List<Compensation> compensations = compensationRepository.findAll();

        /*looks through the entire list of Compensations in the compensationRepository and finds
         the Compensation that contains the Employee with the given employeeId*/ 
        for(Compensation compensation: compensations){
            Employee currentCompensationEmployee = compensation.getEmployee();
            String currentCompensationEmployeeID = currentCompensationEmployee.getEmployeeId();
            if(currentCompensationEmployeeID.equals(id)){
                return compensation;
            }
        }   
        throw new RuntimeException("Invalid employeeId: " + id);
    }
}
