package com.mindex.challenge.service;

import com.mindex.challenge.data.Compensation;

import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Contract that lays out the necessary methods to be implemented by CompensationService implementations
 */
@Qualifier("compensations")
public interface CompensationService {
    /**
    * Attempts to utilize a post method to add a given {@link com.mindex.challenge.data.Compensation}  to the {@link com.mindex.challenge.dao.CompensationRepository} 
    * @param compensation the {@link com.mindex.challenge.data.Compensation}  object that will attempt to be posted.
    * @return The {@link com.mindex.challenge.data.Compensation}  object that is attempted to be posted.
    */
    Compensation create(Compensation compensation);
    
    /**
     * Attempts to find and return a {@link com.mindex.challenge.data.Compensation}  object held in the {@link com.mindex.challenge.dao.CompensationRepository}  by the {@link com.mindex.challenge.data.Employee}  that has a given id
     * @param id the id held by the {@link com.mindex.challenge.data.Employee}  linked with the {@link com.mindex.challenge.data.Compensation}  desired to be found
     * @return the {@link com.mindex.challenge.data.Compensation}  object that contains the {@link com.mindex.challenge.data.Employee}  with the given id
     */
    Compensation read(String id);
}
