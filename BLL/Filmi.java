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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "Filmi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Filmi.findAll", query = "SELECT f FROM Filmi f"),
    @NamedQuery(name = "Filmi.findByFilmiID", query = "SELECT f FROM Filmi f WHERE f.filmiID = :filmiID"),
    @NamedQuery(name = "Filmi.findByEmriFilmit", query = "SELECT f FROM Filmi f WHERE f.emriFilmit = :emriFilmit"),
    @NamedQuery(name = "Filmi.findByPershkrimi", query = "SELECT f FROM Filmi f WHERE f.pershkrimi = :pershkrimi")})
public class Filmi implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "FilmiID")
    
    @GeneratedValue(generator = "InvSeq")
    @SequenceGenerator(name = "InvSeq" , sequenceName = "INV_SEQ", allocationSize = 1)
    
    private Integer filmiID;
    @Basic(optional = false)
    @Column(name = "EmriFilmit")
    private String emriFilmit;
    @Basic(optional = false)
    @Column(name = "Pershkrimi")
    private String pershkrimi;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "filmiID")
    private Collection<StreamingFilmat> streamingFilmatCollection;
    @JoinColumn(name = "ZhanriID", referencedColumnName = "ZhanriID")
    @ManyToOne(optional = false)
    private Zhanri zhanriID;
  
  
    
    public Filmi() {
    }

    public Filmi(Integer filmiID) {
        this.filmiID = filmiID;
    }

    public Filmi(Integer filmiID, String emriFilmit, String pershkrimi) {
        this.filmiID = filmiID;
        this.emriFilmit = emriFilmit;
        this.pershkrimi = pershkrimi;
    }

    public Integer getFilmiID() {
        return filmiID;
    }

    public void setFilmiID(Integer filmiID) {
        this.filmiID = filmiID;
    }

    public String getEmriFilmit() {
        return emriFilmit;
    }

    public void setEmriFilmit(String emriFilmit) {
        this.emriFilmit = emriFilmit;
    }

    public String getPershkrimi() {
        return pershkrimi;
    }

    public void setPershkrimi(String pershkrimi) {
        this.pershkrimi = pershkrimi;
    }

    @XmlTransient
    public Collection<StreamingFilmat> getStreamingFilmatCollection() {
        return streamingFilmatCollection;
    }

    public void setStreamingFilmatCollection(Collection<StreamingFilmat> streamingFilmatCollection) {
        this.streamingFilmatCollection = streamingFilmatCollection;
    }

    public Zhanri getZhanriID() {
        return zhanriID;
    }

    public void setZhanriID(Zhanri zhanriID) {
        this.zhanriID = zhanriID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (filmiID != null ? filmiID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Filmi)) {
            return false;
        }
        Filmi other = (Filmi) object;
        if ((this.filmiID == null && other.filmiID != null) || (this.filmiID != null && !this.filmiID.equals(other.filmiID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return emriFilmit;
    }
    
}
