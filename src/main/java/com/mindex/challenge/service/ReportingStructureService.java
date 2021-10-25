package com.mindex.challenge.service;

import com.mindex.challenge.data.ReportingStructure;

/**
 * Contract that lays out the necessary methods to be implemented by ReportingStuctureService implementations
 */
public interface ReportingStructureService {
    /**
     * A method that attempts to create creates and return a ReportingStructure given an employeeId of an {@link com.mindex.challenge.data.Employee}   
     * @param id an Employee's employeeId
     * @return ReportingStructure that countains the Employee with the id given and the numberOfReports intialized to the correct number of reports the for the Employee.
     */
    ReportingStructure read(String id);
}
