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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Dren
 */
@Entity
@Table(name = "Zhanri")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Zhanri.findAll", query = "SELECT z FROM Zhanri z"),
    @NamedQuery(name = "Zhanri.findByZhanriID", query = "SELECT z FROM Zhanri z WHERE z.zhanriID = :zhanriID"),
    @NamedQuery(name = "Zhanri.findByLloji", query = "SELECT z FROM Zhanri z WHERE z.lloji = :lloji")})
public class Zhanri implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ZhanriID")
    private Integer zhanriID;
    @Basic(optional = false)
    @Column(name = "Lloji")
    private String lloji;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "zhanriID")
    private Collection<Filmi> filmiCollection;

    public Zhanri() {
    }

    public Zhanri(Integer zhanriID) {
        this.zhanriID = zhanriID;
    }

    public Zhanri(Integer zhanriID, String lloji) {
        this.zhanriID = zhanriID;
        this.lloji = lloji;
    }

    public Integer getZhanriID() {
        return zhanriID;
    }

    public void setZhanriID(Integer zhanriID) {
        this.zhanriID = zhanriID;
    }

    public String getLloji() {
        return lloji;
    }

    public void setLloji(String lloji) {
        this.lloji = lloji;
    }

    @XmlTransient
    public Collection<Filmi> getFilmiCollection() {
        return filmiCollection;
    }

    public void setFilmiCollection(Collection<Filmi> filmiCollection) {
        this.filmiCollection = filmiCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (zhanriID != null ? zhanriID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Zhanri)) {
            return false;
        }
        Zhanri other = (Zhanri) object;
        if ((this.zhanriID == null && other.zhanriID != null) || (this.zhanriID != null && !this.zhanriID.equals(other.zhanriID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return lloji;
    }
    
}
