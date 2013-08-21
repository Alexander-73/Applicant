/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.applicant.businesstier.services;

import com.applicant.businesstier.entities.Applicant;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Timo
 */
@Stateless
@LocalBean
public class ApplicantService implements Serializable {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @PersistenceContext(unitName="Applicant_PU")
    EntityManager em;
    
    public void saveApplicant(Applicant applicant)
    {
        em.persist(applicant);
    }

    public String getData() {
        return "Timon testi";
    }

    public List<Applicant> getApplicants() {
        return em.createNamedQuery("Applicant.findAll", Applicant.class).getResultList();
    }

}
