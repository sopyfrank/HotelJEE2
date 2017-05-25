/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MANAGER
 */
@Entity
@Table(name = "typechambre", catalog = "hotel_jee", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"idservice"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Typechambre.findAll", query = "SELECT t FROM Typechambre t")
    , @NamedQuery(name = "Typechambre.findByIdservice", query = "SELECT t FROM Typechambre t WHERE t.idservice = :idservice")
    , @NamedQuery(name = "Typechambre.findByDesignation", query = "SELECT t FROM Typechambre t WHERE t.designation = :designation")
    , @NamedQuery(name = "Typechambre.findByPrix", query = "SELECT t FROM Typechambre t WHERE t.prix = :prix")})
public class Typechambre implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idservice", nullable = false)
    private Integer idservice;
    @Size(max = 254)
    @Column(name = "designation", length = 254)
    private String designation;
    @Column(name = "prix")
    private Integer prix;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "typechambre")
    private Servicesupp servicesupp;

    public Typechambre() {
    }

    public Typechambre(Integer idservice) {
        this.idservice = idservice;
    }

    public Integer getIdservice() {
        return idservice;
    }

    public void setIdservice(Integer idservice) {
        this.idservice = idservice;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Integer getPrix() {
        return prix;
    }

    public void setPrix(Integer prix) {
        this.prix = prix;
    }

    public Servicesupp getServicesupp() {
        return servicesupp;
    }

    public void setServicesupp(Servicesupp servicesupp) {
        this.servicesupp = servicesupp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idservice != null ? idservice.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Typechambre)) {
            return false;
        }
        Typechambre other = (Typechambre) object;
        if ((this.idservice == null && other.idservice != null) || (this.idservice != null && !this.idservice.equals(other.idservice))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Typechambre[ idservice=" + idservice + " ]";
    }
    
}
