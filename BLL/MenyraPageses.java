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
@Table(name = "MenyraPageses")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MenyraPageses.findAll", query = "SELECT m FROM MenyraPageses m"),
    @NamedQuery(name = "MenyraPageses.findByMenyraPagesesID", query = "SELECT m FROM MenyraPageses m WHERE m.menyraPagesesID = :menyraPagesesID"),
    @NamedQuery(name = "MenyraPageses.findByLlojiPageses", query = "SELECT m FROM MenyraPageses m WHERE m.llojiPageses = :llojiPageses")})
public class MenyraPageses implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "MenyraPagesesID")
    private Integer menyraPagesesID;
    @Basic(optional = false)
    @Column(name = "LlojiPageses")
    private String llojiPageses;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "menyraPagesesID")
    private Collection<Pagesat> pagesatCollection;

    public MenyraPageses() {
    }

    public MenyraPageses(Integer menyraPagesesID) {
        this.menyraPagesesID = menyraPagesesID;
    }

    public MenyraPageses(Integer menyraPagesesID, String llojiPageses) {
        this.menyraPagesesID = menyraPagesesID;
        this.llojiPageses = llojiPageses;
    }

    public Integer getMenyraPagesesID() {
        return menyraPagesesID;
    }

    public void setMenyraPagesesID(Integer menyraPagesesID) {
        this.menyraPagesesID = menyraPagesesID;
    }

    public String getLlojiPageses() {
        return llojiPageses;
    }

    public void setLlojiPageses(String llojiPageses) {
        this.llojiPageses = llojiPageses;
    }

    @XmlTransient
    public Collection<Pagesat> getPagesatCollection() {
        return pagesatCollection;
    }

    public void setPagesatCollection(Collection<Pagesat> pagesatCollection) {
        this.pagesatCollection = pagesatCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (menyraPagesesID != null ? menyraPagesesID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MenyraPageses)) {
            return false;
        }
        MenyraPageses other = (MenyraPageses) object;
        if ((this.menyraPagesesID == null && other.menyraPagesesID != null) || (this.menyraPagesesID != null && !this.menyraPagesesID.equals(other.menyraPagesesID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return llojiPageses;
    }
    
}
