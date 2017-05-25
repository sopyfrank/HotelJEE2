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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "gestionnaire", catalog = "hotel_jee", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_gestionnaire"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gestionnaire.findAll", query = "SELECT g FROM Gestionnaire g")
    , @NamedQuery(name = "Gestionnaire.findByIdGestionnaire", query = "SELECT g FROM Gestionnaire g WHERE g.idGestionnaire = :idGestionnaire")
    , @NamedQuery(name = "Gestionnaire.findByNoms", query = "SELECT g FROM Gestionnaire g WHERE g.noms = :noms")
    , @NamedQuery(name = "Gestionnaire.findByPrenom", query = "SELECT g FROM Gestionnaire g WHERE g.prenom = :prenom")})
public class Gestionnaire implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_gestionnaire", nullable = false)
    private Integer idGestionnaire;
    @Size(max = 254)
    @Column(name = "noms", length = 254)
    private String noms;
    @Size(max = 254)
    @Column(name = "prenom", length = 254)
    private String prenom;
    @JoinColumn(name = "idprofile", referencedColumnName = "idprofile", nullable = false)
    @ManyToOne(optional = false)
    private Profile idprofile;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idGestionnaire")
    private Collection<Profile> profileCollection;

    public Gestionnaire() {
    }

    public Gestionnaire(Integer idGestionnaire) {
        this.idGestionnaire = idGestionnaire;
    }

    public Integer getIdGestionnaire() {
        return idGestionnaire;
    }

    public void setIdGestionnaire(Integer idGestionnaire) {
        this.idGestionnaire = idGestionnaire;
    }

    public String getNoms() {
        return noms;
    }

    public void setNoms(String noms) {
        this.noms = noms;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Profile getIdprofile() {
        return idprofile;
    }

    public void setIdprofile(Profile idprofile) {
        this.idprofile = idprofile;
    }

    @XmlTransient
    public Collection<Profile> getProfileCollection() {
        return profileCollection;
    }

    public void setProfileCollection(Collection<Profile> profileCollection) {
        this.profileCollection = profileCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGestionnaire != null ? idGestionnaire.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gestionnaire)) {
            return false;
        }
        Gestionnaire other = (Gestionnaire) object;
        if ((this.idGestionnaire == null && other.idGestionnaire != null) || (this.idGestionnaire != null && !this.idGestionnaire.equals(other.idGestionnaire))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Gestionnaire[ idGestionnaire=" + idGestionnaire + " ]";
    }
    
}
