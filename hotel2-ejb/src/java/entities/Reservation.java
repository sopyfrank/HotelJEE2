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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author MANAGER
 */
@Entity
@Table(name = "reservation", catalog = "hotel_jee", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"idreservation"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reservation.findAll", query = "SELECT r FROM Reservation r")
    , @NamedQuery(name = "Reservation.findByIdreservation", query = "SELECT r FROM Reservation r WHERE r.idreservation = :idreservation")
    , @NamedQuery(name = "Reservation.findByNbrechambre", query = "SELECT r FROM Reservation r WHERE r.nbrechambre = :nbrechambre")
    , @NamedQuery(name = "Reservation.findByNbreadultes", query = "SELECT r FROM Reservation r WHERE r.nbreadultes = :nbreadultes")
    , @NamedQuery(name = "Reservation.findByDatedebut", query = "SELECT r FROM Reservation r WHERE r.datedebut = :datedebut")
    , @NamedQuery(name = "Reservation.findByDatefin", query = "SELECT r FROM Reservation r WHERE r.datefin = :datefin")
    , @NamedQuery(name = "Reservation.findByEtat", query = "SELECT r FROM Reservation r WHERE r.etat = :etat")})
public class Reservation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idreservation", nullable = false)
    private Integer idreservation;
    @Column(name = "nbrechambre")
    private Integer nbrechambre;
    @Column(name = "nbreadultes")
    private Integer nbreadultes;
    @Column(name = "datedebut")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datedebut;
    @Column(name = "datefin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datefin;
    @Column(name = "etat")
    private Short etat;
    @ManyToMany(mappedBy = "reservationCollection")
    private Collection<Chambre> chambreCollection;
    @JoinColumn(name = "idclient", referencedColumnName = "idclient", nullable = false)
    @ManyToOne(optional = false)
    private Client idclient;
    @JoinColumn(name = "idreceptionniste", referencedColumnName = "idreceptionniste", nullable = false)
    @ManyToOne(optional = false)
    private Receptionniste idreceptionniste;

    public Reservation() {
    }

    public Reservation(Integer idreservation) {
        this.idreservation = idreservation;
    }

    public Integer getIdreservation() {
        return idreservation;
    }

    public void setIdreservation(Integer idreservation) {
        this.idreservation = idreservation;
    }

    public Integer getNbrechambre() {
        return nbrechambre;
    }

    public void setNbrechambre(Integer nbrechambre) {
        this.nbrechambre = nbrechambre;
    }

    public Integer getNbreadultes() {
        return nbreadultes;
    }

    public void setNbreadultes(Integer nbreadultes) {
        this.nbreadultes = nbreadultes;
    }

    public Date getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(Date datedebut) {
        this.datedebut = datedebut;
    }

    public Date getDatefin() {
        return datefin;
    }

    public void setDatefin(Date datefin) {
        this.datefin = datefin;
    }

    public Short getEtat() {
        return etat;
    }

    public void setEtat(Short etat) {
        this.etat = etat;
    }

    @XmlTransient
    public Collection<Chambre> getChambreCollection() {
        return chambreCollection;
    }

    public void setChambreCollection(Collection<Chambre> chambreCollection) {
        this.chambreCollection = chambreCollection;
    }

    public Client getIdclient() {
        return idclient;
    }

    public void setIdclient(Client idclient) {
        this.idclient = idclient;
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
        hash += (idreservation != null ? idreservation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reservation)) {
            return false;
        }
        Reservation other = (Reservation) object;
        if ((this.idreservation == null && other.idreservation != null) || (this.idreservation != null && !this.idreservation.equals(other.idreservation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Reservation[ idreservation=" + idreservation + " ]";
    }
    
}
