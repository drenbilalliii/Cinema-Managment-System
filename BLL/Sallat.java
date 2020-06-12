/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Dren
 */
@Entity
@Table(name = "Sallat")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sallat.findAll", query = "SELECT s FROM Sallat s"),
    @NamedQuery(name = "Sallat.findBySallaID", query = "SELECT s FROM Sallat s WHERE s.sallaID = :sallaID"),
    @NamedQuery(name = "Sallat.findByEmriSalles", query = "SELECT s FROM Sallat s WHERE s.emriSalles = :emriSalles"),
    @NamedQuery(name = "Sallat.findByKapacitetiUlseve", query = "SELECT s FROM Sallat s WHERE s.kapacitetiUlseve = :kapacitetiUlseve")})
public class Sallat implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "SallaID")
       @GeneratedValue(generator = "InvSeq")
    @SequenceGenerator(name = "InvSeq" , sequenceName = "INV_SEQ", allocationSize = 1)
    
    private Integer sallaID;
    @Basic(optional = false)
    @Column(name = "EmriSalles")
    private String emriSalles;
    @Basic(optional = false)
    @Column(name = "KapacitetiUlseve")
    private int kapacitetiUlseve;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sallaID")
    private Collection<Ulset> ulsetCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sallaID")
    private Collection<Bileta> biletaCollection;

    public Sallat() {
    }

    public Sallat(Integer sallaID) {
        this.sallaID = sallaID;
    }

    public Sallat(Integer sallaID, String emriSalles, int kapacitetiUlseve) {
        this.sallaID = sallaID;
        this.emriSalles = emriSalles;
        this.kapacitetiUlseve = kapacitetiUlseve;
    }

    public Integer getSallaID() {
        return sallaID;
    }

    public void setSallaID(Integer sallaID) {
        this.sallaID = sallaID;
    }

    public String getEmriSalles() {
        return emriSalles;
    }

    public void setEmriSalles(String emriSalles) {
        this.emriSalles = emriSalles;
    }

    public int getKapacitetiUlseve() {
        return kapacitetiUlseve;
    }

    public void setKapacitetiUlseve(int kapacitetiUlseve) {
        this.kapacitetiUlseve = kapacitetiUlseve;
    }

    @XmlTransient
    public Collection<Ulset> getUlsetCollection() {
        return ulsetCollection;
    }

    public void setUlsetCollection(Collection<Ulset> ulsetCollection) {
        this.ulsetCollection = ulsetCollection;
    }

    @XmlTransient
    public Collection<Bileta> getBiletaCollection() {
        return biletaCollection;
    }

    public void setBiletaCollection(Collection<Bileta> biletaCollection) {
        this.biletaCollection = biletaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sallaID != null ? sallaID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sallat)) {
            return false;
        }
        Sallat other = (Sallat) object;
        if ((this.sallaID == null && other.sallaID != null) || (this.sallaID != null && !this.sallaID.equals(other.sallaID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return sallaID + " : " + emriSalles;
    }
    
}
