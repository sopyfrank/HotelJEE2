/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MANAGER
 */
@Entity
@Table(name = "servicesupp", catalog = "hotel_jee", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"idservice"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Servicesupp.findAll", query = "SELECT s FROM Servicesupp s")
    , @NamedQuery(name = "Servicesupp.findByIdservice", query = "SELECT s FROM Servicesupp s WHERE s.idservice = :idservice")
    , @NamedQuery(name = "Servicesupp.findByTypIdservice", query = "SELECT s FROM Servicesupp s WHERE s.typIdservice = :typIdservice")
    , @NamedQuery(name = "Servicesupp.findByDate", query = "SELECT s FROM Servicesupp s WHERE s.date = :date")})
public class Servicesupp implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idservice", nullable = false)
    private Integer idservice;
    @Basic(optional = false)
    @NotNull
    @Column(name = "typ_idservice", nullable = false)
    private int typIdservice;
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @JoinColumn(name = "idclient", referencedColumnName = "idclient", nullable = false)
    @ManyToOne(optional = false)
    private Client idclient;
    @JoinColumn(name = "idservice", referencedColumnName = "idservice", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Typechambre typechambre;

    public Servicesupp() {
    }

    public Servicesupp(Integer idservice) {
        this.idservice = idservice;
    }

    public Servicesupp(Integer idservice, int typIdservice) {
        this.idservice = idservice;
        this.typIdservice = typIdservice;
    }

    public Integer getIdservice() {
        return idservice;
    }

    public void setIdservice(Integer idservice) {
        this.idservice = idservice;
    }

    public int getTypIdservice() {
        return typIdservice;
    }

    public void setTypIdservice(int typIdservice) {
        this.typIdservice = typIdservice;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Client getIdclient() {
        return idclient;
    }

    public void setIdclient(Client idclient) {
        this.idclient = idclient;
    }

    public Typechambre getTypechambre() {
        return typechambre;
    }

    public void setTypechambre(Typechambre typechambre) {
        this.typechambre = typechambre;
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
        if (!(object instanceof Servicesupp)) {
            return false;
        }
        Servicesupp other = (Servicesupp) object;
        if ((this.idservice == null && other.idservice != null) || (this.idservice != null && !this.idservice.equals(other.idservice))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Servicesupp[ idservice=" + idservice + " ]";
    }
    
}
