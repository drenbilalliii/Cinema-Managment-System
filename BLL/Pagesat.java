/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Dren
 */
@Entity
@Table(name = "Pagesat")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pagesat.findAll", query = "SELECT p FROM Pagesat p"),
    @NamedQuery(name = "Pagesat.findByPagesatID", query = "SELECT p FROM Pagesat p WHERE p.pagesatID = :pagesatID"),
    @NamedQuery(name = "Pagesat.findByShuma", query = "SELECT p FROM Pagesat p WHERE p.shuma = :shuma")})
public class Pagesat implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PagesatID")
    @GeneratedValue(generator = "InvSeq")
    @SequenceGenerator(name = "InvSeq" , sequenceName = "INV_SEQ", allocationSize = 1)
    
    private Integer pagesatID;
    @Basic(optional = false)
    @Column(name = "shuma")
    private long shuma;
    @JoinColumn(name = "BiletaID", referencedColumnName = "BiletaID")
    @ManyToOne(optional = false)
    private Bileta biletaID;
    @JoinColumn(name = "MenyraPagesesID", referencedColumnName = "MenyraPagesesID")
    @ManyToOne(optional = false)
    private MenyraPageses menyraPagesesID;

    public Pagesat() {
    }

    public Pagesat(Integer pagesatID) {
        this.pagesatID = pagesatID;
    }

    public Pagesat(Integer pagesatID, long shuma) {
        this.pagesatID = pagesatID;
        this.shuma = shuma;
    }

    public Integer getPagesatID() {
        return pagesatID;
    }

    public void setPagesatID(Integer pagesatID) {
        this.pagesatID = pagesatID;
    }

    public long getShuma() {
        return shuma;
    }

    public void setShuma(long shuma) {
        this.shuma = shuma;
    }

    public Bileta getBiletaID() {
        return biletaID;
    }

    public void setBiletaID(Bileta biletaID) {
        this.biletaID = biletaID;
    }

    public MenyraPageses getMenyraPagesesID() {
        return menyraPagesesID;
    }

    public void setMenyraPagesesID(MenyraPageses menyraPagesesID) {
        this.menyraPagesesID = menyraPagesesID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pagesatID != null ? pagesatID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pagesat)) {
            return false;
        }
        Pagesat other = (Pagesat) object;
        if ((this.pagesatID == null && other.pagesatID != null) || (this.pagesatID != null && !this.pagesatID.equals(other.pagesatID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BLL.Pagesat[ pagesatID=" + pagesatID + " ]";
    }
    
}
