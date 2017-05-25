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
@Table(name = "profile", catalog = "hotel_jee", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"idprofile"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Profile.findAll", query = "SELECT p FROM Profile p")
    , @NamedQuery(name = "Profile.findByIdprofile", query = "SELECT p FROM Profile p WHERE p.idprofile = :idprofile")
    , @NamedQuery(name = "Profile.findByTypeprofile", query = "SELECT p FROM Profile p WHERE p.typeprofile = :typeprofile")
    , @NamedQuery(name = "Profile.findByLogin", query = "SELECT p FROM Profile p WHERE p.login = :login")
    , @NamedQuery(name = "Profile.findByPass", query = "SELECT p FROM Profile p WHERE p.pass = :pass")})
public class Profile implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idprofile", nullable = false)
    private Integer idprofile;
    @Size(max = 254)
    @Column(name = "typeprofile", length = 254)
    private String typeprofile;
    @Size(max = 254)
    @Column(name = "login", length = 254)
    private String login;
    @Size(max = 254)
    @Column(name = "pass", length = 254)
    private String pass;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idprofile")
    private Collection<Receptionniste> receptionnisteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idprofile")
    private Collection<Gestionnaire> gestionnaireCollection;
    @JoinColumn(name = "id_gestionnaire", referencedColumnName = "id_gestionnaire", nullable = false)
    @ManyToOne(optional = false)
    private Gestionnaire idGestionnaire;
    @JoinColumn(name = "idreceptionniste", referencedColumnName = "idreceptionniste", nullable = false)
    @ManyToOne(optional = false)
    private Receptionniste idreceptionniste;

    public Profile() {
    }

    public Profile(Integer idprofile) {
        this.idprofile = idprofile;
    }

    public Integer getIdprofile() {
        return idprofile;
    }

    public void setIdprofile(Integer idprofile) {
        this.idprofile = idprofile;
    }

    public String getTypeprofile() {
        return typeprofile;
    }

    public void setTypeprofile(String typeprofile) {
        this.typeprofile = typeprofile;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @XmlTransient
    public Collection<Receptionniste> getReceptionnisteCollection() {
        return receptionnisteCollection;
    }

    public void setReceptionnisteCollection(Collection<Receptionniste> receptionnisteCollection) {
        this.receptionnisteCollection = receptionnisteCollection;
    }

    @XmlTransient
    public Collection<Gestionnaire> getGestionnaireCollection() {
        return gestionnaireCollection;
    }

    public void setGestionnaireCollection(Collection<Gestionnaire> gestionnaireCollection) {
        this.gestionnaireCollection = gestionnaireCollection;
    }

    public Gestionnaire getIdGestionnaire() {
        return idGestionnaire;
    }

    public void setIdGestionnaire(Gestionnaire idGestionnaire) {
        this.idGestionnaire = idGestionnaire;
    }

    public Receptionniste getIdreceptionniste() {
        return idreceptionniste;
    }

    public void setIdreceptionniste(Receptionniste idreceptionniste) {
        this.idreceptionniste = idreceptionniste;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idprofile != null ? idprofile.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profile)) {
            return false;
        }
        Profile other = (Profile) object;
        if ((this.idprofile == null && other.idprofile != null) || (this.idprofile != null && !this.idprofile.equals(other.idprofile))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Profile[ idprofile=" + idprofile + " ]";
    }
    
}
