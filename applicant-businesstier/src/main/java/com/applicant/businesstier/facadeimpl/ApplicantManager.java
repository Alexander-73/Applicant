/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.applicant.businesstier.facadeimpl;

import com.applicant.businesstier.entities.Applicant;
import com.applicant.businesstier.facades.ApplicantManagerLocal;
import com.applicant.businesstier.services.ApplicantService;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author Timo
 */
@Stateless
public class ApplicantManager implements ApplicantManagerLocal, Serializable {

    @EJB
    private ApplicantService service;
    
    @Override
    public void saveApplicant(Applicant applicant) {
        service.saveApplicant(applicant);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

}
