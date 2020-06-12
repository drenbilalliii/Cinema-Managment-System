/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
@Table(name = "Ushqimi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ushqimi.findAll", query = "SELECT u FROM Ushqimi u"),
    @NamedQuery(name = "Ushqimi.findByUshqimiID", query = "SELECT u FROM Ushqimi u WHERE u.ushqimiID = :ushqimiID"),
    @NamedQuery(name = "Ushqimi.findByEmriUshqimit", query = "SELECT u FROM Ushqimi u WHERE u.emriUshqimit = :emriUshqimit"),
    @NamedQuery(name = "Ushqimi.findByCmimi", query = "SELECT u FROM Ushqimi u WHERE u.cmimi = :cmimi")})
public class Ushqimi implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "UshqimiID")
    
       @GeneratedValue(generator = "InvSeq")
       @SequenceGenerator(name = "InvSeq" , sequenceName = "INV_SEQ", allocationSize = 1)
    private Integer ushqimiID;
    @Basic(optional = false)
    @Column(name = "EmriUshqimit")
    private String emriUshqimit;
    @Basic(optional = false)
    @Column(name = "Cmimi")
    private long cmimi;
    @OneToMany(mappedBy = "ushqimiID")
    private Collection<Bileta> biletaCollection;

    public Ushqimi() {
    }

    public Ushqimi(Integer ushqimiID) {
        this.ushqimiID = ushqimiID;
    }

    public Ushqimi(Integer ushqimiID, String emriUshqimit, long cmimi) {
        this.ushqimiID = ushqimiID;
        this.emriUshqimit = emriUshqimit;
        this.cmimi = cmimi;
    }

    public Integer getUshqimiID() {
        return ushqimiID;
    }

    public void setUshqimiID(Integer ushqimiID) {
        this.ushqimiID = ushqimiID;
    }

    public String getEmriUshqimit() {
        return emriUshqimit;
    }

    public void setEmriUshqimit(String emriUshqimit) {
        this.emriUshqimit = emriUshqimit;
    }

    public long getCmimi() {
        return cmimi;
    }

    public void setCmimi(long cmimi) {
        this.cmimi = cmimi;
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
        hash += (ushqimiID != null ? ushqimiID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ushqimi)) {
            return false;
        }
        Ushqimi other = (Ushqimi) object;
        if ((this.ushqimiID == null && other.ushqimiID != null) || (this.ushqimiID != null && !this.ushqimiID.equals(other.ushqimiID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return emriUshqimit;
    }
    
}
