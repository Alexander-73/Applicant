/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.applicant.businesstier.facades;

import com.applicant.businesstier.entities.Applicant;
import javax.ejb.Local;
import javax.ejb.Stateless;

/**
 *
 * @author Timo
 */
@Local
public interface ApplicantManagerLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public void saveApplicant(Applicant applicant);
            
            
 }