/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author MANAGER
 */
@Entity
@Table(name = "categoriechambre", catalog = "hotel_jee", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"idcategorie"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Categoriechambre.findAll", query = "SELECT c FROM Categoriechambre c")
    , @NamedQuery(name = "Categoriechambre.findByIdcategorie", query = "SELECT c FROM Categoriechambre c WHERE c.idcategorie = :idcategorie")
    , @NamedQuery(name = "Categoriechambre.findByDesignation", query = "SELECT c FROM Categoriechambre c WHERE c.designation = :designation")
    , @NamedQuery(name = "Categoriechambre.findByPrix", query = "SELECT c FROM Categoriechambre c WHERE c.prix = :prix")
    , @NamedQuery(name = "Categoriechambre.findByNbrelit", query = "SELECT c FROM Categoriechambre c WHERE c.nbrelit = :nbrelit")
    , @NamedQuery(name = "Categoriechambre.findByTelevision", query = "SELECT c FROM Categoriechambre c WHERE c.television = :television")})
public class Categoriechambre implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcategorie", nullable = false)
    private Integer idcategorie;
    @Size(max = 254)
    @Column(name = "designation", length = 254)
    private String designation;
    @Column(name = "prix")
    private Integer prix;
    @Column(name = "nbrelit")
    private Integer nbrelit;
    @Column(name = "television")
    private Short television;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcategorie")
    private Collection<Chambre> chambreCollection;

    public Categoriechambre() {
    }

    public Categoriechambre(Integer idcategorie) {
        this.idcategorie = idcategorie;
    }

    public Integer getIdcategorie() {
        return idcategorie;
    }

    public void setIdcategorie(Integer idcategorie) {
        this.idcategorie = idcategorie;
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

    public Integer getNbrelit() {
        return nbrelit;
    }

    public void setNbrelit(Integer nbrelit) {
        this.nbrelit = nbrelit;
    }

    public Short getTelevision() {
        return television;
    }

    public void setTelevision(Short television) {
        this.television = television;
    }

    @XmlTransient
    public Collection<Chambre> getChambreCollection() {
        return chambreCollection;
    }

    public void setChambreCollection(Collection<Chambre> chambreCollection) {
        this.chambreCollection = chambreCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcategorie != null ? idcategorie.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categoriechambre)) {
            return false;
        }
        Categoriechambre other = (Categoriechambre) object;
        if ((this.idcategorie == null && other.idcategorie != null) || (this.idcategorie != null && !this.idcategorie.equals(other.idcategorie))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Categoriechambre[ idcategorie=" + idcategorie + " ]";
    }
    
}
