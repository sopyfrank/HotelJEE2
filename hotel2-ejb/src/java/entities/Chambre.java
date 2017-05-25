/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "chambre", catalog = "hotel_jee", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"idchambre"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Chambre.findAll", query = "SELECT c FROM Chambre c")
    , @NamedQuery(name = "Chambre.findByIdchambre", query = "SELECT c FROM Chambre c WHERE c.idchambre = :idchambre")
    , @NamedQuery(name = "Chambre.findByNumero", query = "SELECT c FROM Chambre c WHERE c.numero = :numero")
    , @NamedQuery(name = "Chambre.findByNom", query = "SELECT c FROM Chambre c WHERE c.nom = :nom")})
public class Chambre implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idchambre", nullable = false)
    private Integer idchambre;
    @Column(name = "numero")
    private Integer numero;
    @Size(max = 254)
    @Column(name = "nom", length = 254)
    private String nom;
    @JoinTable(name = "reservation_chambre", joinColumns = {
        @JoinColumn(name = "idchambre", referencedColumnName = "idchambre", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "idreservation", referencedColumnName = "idreservation", nullable = false)})
    @ManyToMany
    private Collection<Reservation> reservationCollection;
    @JoinTable(name = "chambre_client", joinColumns = {
        @JoinColumn(name = "idchambre", referencedColumnName = "idchambre", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "idclient", referencedColumnName = "idclient", nullable = false)})
    @ManyToMany
    private Collection<Client> clientCollection;
    @JoinColumn(name = "idcategorie", referencedColumnName = "idcategorie", nullable = false)
    @ManyToOne(optional = false)
    private Categoriechambre idcategorie;

    public Chambre() {
    }

    public Chambre(Integer idchambre) {
        this.idchambre = idchambre;
    }

    public Integer getIdchambre() {
        return idchambre;
    }

    public void setIdchambre(Integer idchambre) {
        this.idchambre = idchambre;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @XmlTransient
    public Collection<Reservation> getReservationCollection() {
        return reservationCollection;
    }

    public void setReservationCollection(Collection<Reservation> reservationCollection) {
        this.reservationCollection = reservationCollection;
    }

    @XmlTransient
    public Collection<Client> getClientCollection() {
        return clientCollection;
    }

    public void setClientCollection(Collection<Client> clientCollection) {
        this.clientCollection = clientCollection;
    }

    public Categoriechambre getIdcategorie() {
        return idcategorie;
    }

    public void setIdcategorie(Categoriechambre idcategorie) {
        this.idcategorie = idcategorie;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idchambre != null ? idchambre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Chambre)) {
            return false;
        }
        Chambre other = (Chambre) object;
        if ((this.idchambre == null && other.idchambre != null) || (this.idchambre != null && !this.idchambre.equals(other.idchambre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Chambre[ idchambre=" + idchambre + " ]";
    }
    
}
