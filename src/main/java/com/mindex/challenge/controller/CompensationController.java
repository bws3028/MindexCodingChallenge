package com.mindex.challenge.controller;

import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.service.CompensationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * Handles post and get requests for {@link com.mindex.challenge.data.Compensation} objects
 */
@RestController
public class CompensationController {
    private static final Logger LOG = LoggerFactory.getLogger(CompensationController.class);

    @Autowired
    private CompensationService compensationService;

    /**
     * Maps a post request to the /compensation endpoint. A {@link com.mindex.challenge.data.Compensation}  object is created by
     * passing a json representation of the {@link com.mindex.challenge.data.Compensation}  throught the body of a post request
     * to /compensation.
     * @param compensation The instantiation of the json representation of a {@link com.mindex.challenge.data.Compensation}  object
     *                      passed through the body of a post request to /compensation endpoint
     * @return The created {@link com.mindex.challenge.data.Compensation}  object is returned.
     */
    @PostMapping("/compensation")
    public Compensation create(@RequestBody Compensation compensation) {
        LOG.debug("Received employee create request for [{}]", compensation);

        return compensationService.create(compensation);
    }

    /**
     * Maps a get request that takes an id parameter to the endpoint /compensation/{id}.
     * @param id String representation of the paramater extracted from the end of the
     *              /compensation/{id} endpoint
     * @return The {@link com.mindex.challenge.data.Compensation}  that has an {@link com.mindex.challenge.data.Employee}  that has an id which matches the id passed
     *          into the method through the request is returned.
     */
    @GetMapping("/compensation/{id}")
    public Compensation read(@PathVariable String id) {
        LOG.debug("Received compensation create request for id [{}]", id);

        return compensationService.read(id);
    }

}
