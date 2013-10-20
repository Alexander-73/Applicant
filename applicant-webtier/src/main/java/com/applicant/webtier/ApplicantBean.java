/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.applicant.webtier;

import com.applicant.businesstier.entities.Applicant;
import com.applicant.businesstier.facades.ApplicantManagerLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Timo
 */
@ManagedBean
@SessionScoped
public class ApplicantBean implements Serializable {

    /**
     * Creates a new instance of ApplicantBean
     */
    private Applicant applicant;
    private List<Applicant> applicants;
    private Applicant selectedApplicant;
    private boolean editable;

    
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
        System.out.println("init()");
        
        this.applicant = new Applicant();
        
        this.genders = new HashMap<String, Integer>();
        this.genders.put("Male", 0);
        this.genders.put("Female", 1);
        
        this.applicant.setGender(this.genders.get("Male"));
        
        this.editable = false;
        
        this.applicants = new ArrayList<Applicant>();  
        this.applicants = manager.getApplicants();
        
        System.out.println("Applicants size: "+this.applicants.size());
       
    }
   
    public void saveApplicant()
    {
        
        System.out.println("saveApplicant()");//+this.applicant.getLastName());
      
        FacesContext context = FacesContext.getCurrentInstance();  
            
        context.addMessage(null, new FacesMessage("Saved applicant: "+this.applicant.getFirstName()+ " "+this.applicant.getLastName()));  
        
        manager.saveApplicant(this.applicant);
        
        this.applicants.add(this.applicant);
        init();
    }
    
    public void addApplicant()
    {
       init();
    }
    
    public void editApplicant()
    {
        System.out.println("Selected applicant: "+this.selectedApplicant.getLastName());
        
        this.applicant = this.selectedApplicant;
        
        this.editable = true;
    }
    public void removeApplicant()
    {
        System.out.println("Removing applicant: "+this.selectedApplicant.getLastName());
        
        manager.removeApplicant(this.selectedApplicant);
        this.applicants.remove(this.selectedApplicant);
    }
    public void edit()
    {
        manager.editApplicant(this.applicant);
    }
    
    public List<Applicant> getApplicants() {
        return applicants;
    }

    public void setApplicants(List<Applicant> applicants) {
        this.applicants = applicants;
    }
    
    public Applicant getSelectedApplicant() {
        return selectedApplicant;
    }

    public void setSelectedApplicant(Applicant selectedApplicant) {
        this.selectedApplicant = selectedApplicant;
    }
   
    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

   
    
   

}
