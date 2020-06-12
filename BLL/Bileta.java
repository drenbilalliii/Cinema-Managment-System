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
@Table(name = "Bileta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bileta.findAll", query = "SELECT b FROM Bileta b"),
    @NamedQuery(name = "Bileta.findByBiletaID", query = "SELECT b FROM Bileta b WHERE b.biletaID = :biletaID")})
public class Bileta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "BiletaID")
    
    @GeneratedValue(generator = "InvSeq")
    @SequenceGenerator(name = "InvSeq" , sequenceName = "INV_SEQ", allocationSize = 1)
    
    private Integer biletaID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "biletaID")
    private Collection<Pagesat> pagesatCollection;
    @JoinColumn(name = "KlientiID", referencedColumnName = "KlientiID")
    @ManyToOne(optional = false)
    private Klienti klientiID;
    @JoinColumn(name = "SallaID", referencedColumnName = "SallaID")
    @ManyToOne(optional = false)
    private Sallat sallaID;
    @JoinColumn(name = "StreamingFilmID", referencedColumnName = "StreamingFilmID")
    @ManyToOne(optional = false)
    private StreamingFilmat streamingFilmID;
    @JoinColumn(name = "UlesejaID", referencedColumnName = "UlesejaID")
    @ManyToOne(optional = false)
    private Ulset ulesejaID;
    @JoinColumn(name = "UshqimiID", referencedColumnName = "UshqimiID")
    @ManyToOne
    private Ushqimi ushqimiID;

    public Bileta() {
    }

    public Bileta(Integer biletaID) {
        this.biletaID = biletaID;
    }

    public Integer getBiletaID() {
        return biletaID;
    }

    public void setBiletaID(Integer biletaID) {
        this.biletaID = biletaID;
    }

    @XmlTransient
    public Collection<Pagesat> getPagesatCollection() {
        return pagesatCollection;
    }

    public void setPagesatCollection(Collection<Pagesat> pagesatCollection) {
        this.pagesatCollection = pagesatCollection;
    }

    public Klienti getKlientiID() {
        return klientiID;
    }

    public void setKlientiID(Klienti klientiID) {
        this.klientiID = klientiID;
    }

    public Sallat getSallaID() {
        return sallaID;
    }

    public void setSallaID(Sallat sallaID) {
        this.sallaID = sallaID;
    }

    public StreamingFilmat getStreamingFilmID() {
        return streamingFilmID;
    }

    public void setStreamingFilmID(StreamingFilmat streamingFilmID) {
        this.streamingFilmID = streamingFilmID;
    }

    public Ulset getUlesejaID() {
        return ulesejaID;
    }

    public void setUlesejaID(Ulset ulesejaID) {
        this.ulesejaID = ulesejaID;
    }

    public Ushqimi getUshqimiID() {
        return ushqimiID;
    }

    public void setUshqimiID(Ushqimi ushqimiID) {
        this.ushqimiID = ushqimiID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (biletaID != null ? biletaID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bileta)) {
            return false;
        }
        Bileta other = (Bileta) object;
        if ((this.biletaID == null && other.biletaID != null) || (this.biletaID != null && !this.biletaID.equals(other.biletaID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return klientiID.getEmriMbiemri();
    }
    
}
