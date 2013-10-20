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
 * @author timovaananen
 */
@Entity
@Table(name = "Address")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Address.findAll", query = "SELECT a FROM Address a"),
    @NamedQuery(name = "Address.findByIdAddress", query = "SELECT a FROM Address a WHERE a.idAddress = :idAddress"),
    @NamedQuery(name = "Address.findByStreet1", query = "SELECT a FROM Address a WHERE a.street1 = :street1"),
    @NamedQuery(name = "Address.findByStreet2", query = "SELECT a FROM Address a WHERE a.street2 = :street2"),
    @NamedQuery(name = "Address.findByPostaladdress", query = "SELECT a FROM Address a WHERE a.postaladdress = :postaladdress"),
    @NamedQuery(name = "Address.findByZipcode", query = "SELECT a FROM Address a WHERE a.zipcode = :zipcode")})
public class Address implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAddress")
    private Integer idAddress;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "street1")
    private String street1;
    @Size(max = 60)
    @Column(name = "street2")
    private String street2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "postaladdress")
    private String postaladdress;
    @Basic(optional = false)
    @NotNull
    @Column(name = "zipcode")
    private int zipcode;

    public Address() {
    }

    public Address(Integer idAddress) {
        this.idAddress = idAddress;
    }

    public Address(Integer idAddress, String street1, String postaladdress, int zipcode) {
        this.idAddress = idAddress;
        this.street1 = street1;
        this.postaladdress = postaladdress;
        this.zipcode = zipcode;
    }

    public Integer getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(Integer idAddress) {
        this.idAddress = idAddress;
    }

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getPostaladdress() {
        return postaladdress;
    }

    public void setPostaladdress(String postaladdress) {
        this.postaladdress = postaladdress;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAddress != null ? idAddress.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Address)) {
            return false;
        }
        Address other = (Address) object;
        if ((this.idAddress == null && other.idAddress != null) || (this.idAddress != null && !this.idAddress.equals(other.idAddress))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.applicant.businesstier.entities.Address[ idAddress=" + idAddress + " ]";
    }
    
}
