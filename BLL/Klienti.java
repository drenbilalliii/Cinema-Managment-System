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
@Table(name = "Klienti")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Klienti.findAll", query = "SELECT k FROM Klienti k"),
    @NamedQuery(name = "Klienti.findByKlientiID", query = "SELECT k FROM Klienti k WHERE k.klientiID = :klientiID"),
    @NamedQuery(name = "Klienti.findByEmriMbiemri", query = "SELECT k FROM Klienti k WHERE k.emriMbiemri = :emriMbiemri")})
public class Klienti implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "KlientiID")
   
    
    @GeneratedValue(generator = "InvSeq")
    @SequenceGenerator(name = "InvSeq" , sequenceName = "INV_SEQ", allocationSize = 1)
    private Integer klientiID;
     
    
    @Basic(optional = false)
    @Column(name = "EmriMbiemri")
    private String emriMbiemri;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "klientiID")
    private Collection<Bileta> biletaCollection;

    public Klienti() {
    }

    public Klienti(Integer klientiID) {
        this.klientiID = klientiID;
    }

    public Klienti(Integer klientiID, String emriMbiemri) {
        this.klientiID = klientiID;
        this.emriMbiemri = emriMbiemri;
    }

    public Integer getKlientiID() {
        return klientiID;
    }

    public void setKlientiID(Integer klientiID) {
        this.klientiID = klientiID;
    }

    public String getEmriMbiemri() {
        return emriMbiemri;
    }

    public void setEmriMbiemri(String emriMbiemri) {
        this.emriMbiemri = emriMbiemri;
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
        hash += (klientiID != null ? klientiID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Klienti)) {
            return false;
        }
        Klienti other = (Klienti) object;
        if ((this.klientiID == null && other.klientiID != null) || (this.klientiID != null && !this.klientiID.equals(other.klientiID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return emriMbiemri;
    }
    
}
