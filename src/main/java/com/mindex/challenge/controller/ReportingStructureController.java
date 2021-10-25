package com.mindex.challenge.controller;

import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.ReportingStructureService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * Handles get requests for {@link com.mindex.challenge.data.Compensation}  objects
 */
@RestController
public class ReportingStructureController {
    private static final Logger LOG = LoggerFactory.getLogger(ReportingStructure.class);

    @Autowired
    private ReportingStructureService reportingStructureService;

    /**
     * Maps a get request that takes an id parameter to the endpoint /reportStructure/{id}.
     * @param id String representation of the paramater extracted from the end of the
     *              /reportStructure/{id} endpoint
     * @return The {@link com.mindex.challenge.data.ReportingStructure}  that has an {@link com.mindex.challenge.data.Employee}  that has an id which matches the 
     *          id passed into the method through the request is returned.
     */
    @GetMapping("/reportingStructure/{id}")
    public ReportingStructure read(@PathVariable String id) {
        LOG.debug("Received employee create request for id [{}]", id);

        return reportingStructureService.read(id);
    }

}
