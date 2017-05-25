/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author MANAGER
 */
@Entity
@Table(name = "facture", catalog = "hotel_jee", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"idfacture"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Facture.findAll", query = "SELECT f FROM Facture f")
    , @NamedQuery(name = "Facture.findByIdfacture", query = "SELECT f FROM Facture f WHERE f.idfacture = :idfacture")
    , @NamedQuery(name = "Facture.findByServices", query = "SELECT f FROM Facture f WHERE f.services = :services")
    , @NamedQuery(name = "Facture.findByPrix", query = "SELECT f FROM Facture f WHERE f.prix = :prix")
    , @NamedQuery(name = "Facture.findByDate", query = "SELECT f FROM Facture f WHERE f.date = :date")
    , @NamedQuery(name = "Facture.findByDureesejour", query = "SELECT f FROM Facture f WHERE f.dureesejour = :dureesejour")})
public class Facture implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idfacture", nullable = false)
    private Integer idfacture;
    @Size(max = 254)
    @Column(name = "services", length = 254)
    private String services;
    @Column(name = "prix")
    private Integer prix;
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Size(max = 254)
    @Column(name = "dureesejour", length = 254)
    private String dureesejour;
    @ManyToMany(mappedBy = "factureCollection")
    private Collection<Client> clientCollection;
    @JoinColumn(name = "idreceptionniste", referencedColumnName = "idreceptionniste", nullable = false)
    @ManyToOne(optional = false)
    private Receptionniste idreceptionniste;

    public Facture() {
    }

    public Facture(Integer idfacture) {
        this.idfacture = idfacture;
    }

    public Integer getIdfacture() {
        return idfacture;
    }

    public void setIdfacture(Integer idfacture) {
        this.idfacture = idfacture;
    }

    public String getServices() {
        return services;
    }

    public void setServices(String services) {
        this.services = services;
    }

    public Integer getPrix() {
        return prix;
    }

    public void setPrix(Integer prix) {
        this.prix = prix;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDureesejour() {
        return dureesejour;
    }

    public void setDureesejour(String dureesejour) {
        this.dureesejour = dureesejour;
    }

    @XmlTransient
    public Collection<Client> getClientCollection() {
        return clientCollection;
    }

    public void setClientCollection(Collection<Client> clientCollection) {
        this.clientCollection = clientCollection;
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
        hash += (idfacture != null ? idfacture.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Facture)) {
            return false;
        }
        Facture other = (Facture) object;
        if ((this.idfacture == null && other.idfacture != null) || (this.idfacture != null && !this.idfacture.equals(other.idfacture))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Facture[ idfacture=" + idfacture + " ]";
    }
    
}
