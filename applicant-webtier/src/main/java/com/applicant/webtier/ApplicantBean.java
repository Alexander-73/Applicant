/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.applicant.webtier;

import com.applicant.businesstier.entities.Applicant;
import com.applicant.businesstier.facades.ApplicantManagerLocal;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Timo
 */
@ManagedBean
@SessionScoped
public class ApplicantBean {

    /**
     * Creates a new instance of ApplicantBean
     */
    private Applicant applicant;
    
    @EJB
    ApplicantManagerLocal manager;

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }
    public ApplicantBean() {
    }
    
     public Map<String, Integer> getGenders() {
        return genders;
    }

    public void setGenders(Map<String, Integer> genders) {
        this.genders = genders;
    }
    private Map<String, Integer> genders;
    
    @PostConstruct
    public void init()
    {
        this.applicant = new Applicant();
        
        this.genders = new HashMap<String, Integer>();
        this.genders.put("Male", 0);
        this.genders.put("Female", 1);
        
        this.applicant.setGender(this.genders.get("Male"));
      
    }
   
    public void saveApplicant()
    {
        
        System.out.println("saveApplicant()");//+this.applicant.getLastName());
       
        FacesContext context = FacesContext.getCurrentInstance();  
            
        context.addMessage(null, new FacesMessage("Saved applicant: "+this.applicant.getFirstName()+ " "+this.applicant.getLastName()));  
        
        manager.saveApplicant(this.applicant);
        init();
    }
}
