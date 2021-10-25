package com.mindex.challenge.controller;

import com.mindex.challenge.data.Employee;
import com.mindex.challenge.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Handles post, get, and put requests for {@link com.mindex.challenge.data.Employee}  objects
 */
@RestController
public class EmployeeController {
    private static final Logger LOG = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

   /**
    * Maps a post request to the endpoint "/employee". An {@link com.mindex.challenge.data.Employee}  is created, initialized through
    * body of the request and then stored in the {@link com.mindex.challenge.dao.EmployeeRepository} 
    * @param employee An {@link com.mindex.challenge.data.Employee}  that the body of the request is initialized into
    * @return the created {@link com.mindex.challenge.data.Employee} 
    */
    @PostMapping("/employee")
    public Employee create(@RequestBody Employee employee) {
        LOG.debug("Received employee create request for [{}]", employee);

        return employeeService.create(employee);
    }

   /**
    * Maps a get request to the endpoint "/employee/{id}" where the {id} parameter is the employeeId to 
    * a desired {@link com.mindex.challenge.data.Employee} . The desired Employee is searched for and returned if possible.
    * @param id the employeeId of a desired {@link com.mindex.challenge.data.Employee} 
    * @return the {@link com.mindex.challenge.data.Employee}  with the given id
    */
    @GetMapping("/employee/{id}")
    public Employee read(@PathVariable String id) {
        LOG.debug("Received employee create request for id [{}]", id);

        return employeeService.read(id);
    }

    /**
     * Maps a put request to the endpoint "/employee/{id}" where the {id} is the employeeId to a desired
     * {@link com.mindex.challenge.data.Employee}  which, if it exists, will be updated to match the an {@link com.mindex.challenge.data.Employee}  initialized
     * by the body of the request.
     * @param id the employeeId for the {@link com.mindex.challenge.data.Employee}  that is desired too be updated
     * @param employee the initialized version of the data used to update the desired {@link com.mindex.challenge.data.Employee} 
     * @return the updated {@link com.mindex.challenge.data.Employee} 
     */
    @PutMapping("/employee/{id}")
    public Employee update(@PathVariable String id, @RequestBody Employee employee) {
        LOG.debug("Received employee create request for id [{}] and employee [{}]", id, employee);

        employee.setEmployeeId(id);
        return employeeService.update(employee);
    }

}
