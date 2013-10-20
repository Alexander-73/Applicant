/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.applicant.businesstier.facadeimpl;

import com.applicant.businesstier.entities.Applicant;
import com.applicant.businesstier.facades.ApplicantManagerLocal;
import com.applicant.businesstier.services.ApplicantService;
import java.io.Serializable;
import java.util.List;
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
    
    @Override
    public List getApplicants()
    {
        return service.getApplicants();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void editApplicant(Applicant applicant) {
        service.editApplicant(applicant);
    }

    @Override
    public void removeApplicant(Applicant selectedApplicant) {
        service.removeApplicant(selectedApplicant);
    }

}
