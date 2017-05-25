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
@Table(name = "receptionniste", catalog = "hotel_jee", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"idreceptionniste"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Receptionniste.findAll", query = "SELECT r FROM Receptionniste r")
    , @NamedQuery(name = "Receptionniste.findByIdreceptionniste", query = "SELECT r FROM Receptionniste r WHERE r.idreceptionniste = :idreceptionniste")
    , @NamedQuery(name = "Receptionniste.findByNoms", query = "SELECT r FROM Receptionniste r WHERE r.noms = :noms")
    , @NamedQuery(name = "Receptionniste.findByPrenoms", query = "SELECT r FROM Receptionniste r WHERE r.prenoms = :prenoms")
    , @NamedQuery(name = "Receptionniste.findByTel", query = "SELECT r FROM Receptionniste r WHERE r.tel = :tel")
    , @NamedQuery(name = "Receptionniste.findByEmail", query = "SELECT r FROM Receptionniste r WHERE r.email = :email")
    , @NamedQuery(name = "Receptionniste.findByMatricule", query = "SELECT r FROM Receptionniste r WHERE r.matricule = :matricule")})
public class Receptionniste implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idreceptionniste", nullable = false)
    private Integer idreceptionniste;
    @Size(max = 254)
    @Column(name = "noms", length = 254)
    private String noms;
    @Size(max = 254)
    @Column(name = "prenoms", length = 254)
    private String prenoms;
    @Column(name = "tel")
    private Integer tel;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 254)
    @Column(name = "email", length = 254)
    private String email;
    @Size(max = 254)
    @Column(name = "matricule", length = 254)
    private String matricule;
    @JoinColumn(name = "idprofile", referencedColumnName = "idprofile", nullable = false)
    @ManyToOne(optional = false)
    private Profile idprofile;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idreceptionniste")
    private Collection<Profile> profileCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idreceptionniste")
    private Collection<Facture> factureCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idreceptionniste")
    private Collection<Reservation> reservationCollection;

    public Receptionniste() {
    }

    public Receptionniste(Integer idreceptionniste) {
        this.idreceptionniste = idreceptionniste;
    }

    public Integer getIdreceptionniste() {
        return idreceptionniste;
    }

    public void setIdreceptionniste(Integer idreceptionniste) {
        this.idreceptionniste = idreceptionniste;
    }

    public String getNoms() {
        return noms;
    }

    public void setNoms(String noms) {
        this.noms = noms;
    }

    public String getPrenoms() {
        return prenoms;
    }

    public void setPrenoms(String prenoms) {
        this.prenoms = prenoms;
    }

    public Integer getTel() {
        return tel;
    }

    public void setTel(Integer tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
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

    @XmlTransient
    public Collection<Facture> getFactureCollection() {
        return factureCollection;
    }

    public void setFactureCollection(Collection<Facture> factureCollection) {
        this.factureCollection = factureCollection;
    }

    @XmlTransient
    public Collection<Reservation> getReservationCollection() {
        return reservationCollection;
    }

    public void setReservationCollection(Collection<Reservation> reservationCollection) {
        this.reservationCollection = reservationCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idreceptionniste != null ? idreceptionniste.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Receptionniste)) {
            return false;
        }
        Receptionniste other = (Receptionniste) object;
        if ((this.idreceptionniste == null && other.idreceptionniste != null) || (this.idreceptionniste != null && !this.idreceptionniste.equals(other.idreceptionniste))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Receptionniste[ idreceptionniste=" + idreceptionniste + " ]";
    }
    
}
