/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.applicant.businesstier.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Timo
 */
@Entity
@Table(name = "applicant")
@NamedQueries({
    @NamedQuery(name = "Applicant.findAll", query = "SELECT a FROM Applicant a")})
public class Applicant implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic
    @Column(name = "idapplicant")
    private Integer idapplicant;
    @Size(min = 3, max = 40)
    @Column(name = "firstname")
    private String firstName;
    @Size(min = 3, max = 100)
    @Column(name = "lastname")
    private String lastName;
    @Column(name = "gender")
    private Integer gender;
    @Basic(optional = false)
    @Column(name = "info")
    private String info;

    public Applicant() {
    }

    public Applicant(Integer idapplicant) {
        this.idapplicant = idapplicant;
    }

    public Applicant(Integer idapplicant, String info) {
        this.idapplicant = idapplicant;
        this.info = info;
    }

    public Integer getIdapplicant() {
        return idapplicant;
    }

    public void setIdapplicant(Integer idapplicant) {
        this.idapplicant = idapplicant;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastname) {
        this.lastName = lastname;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idapplicant != null ? idapplicant.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Applicant)) {
            return false;
        }
        Applicant other = (Applicant) object;
        if ((this.idapplicant == null && other.idapplicant != null) || (this.idapplicant != null && !this.idapplicant.equals(other.idapplicant))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.applicant.businesstier.entities.Applicant[ idapplicant=" + idapplicant + " ]";
    }
    
}
