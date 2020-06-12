/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Dren
 */
@Entity
@Table(name = "Ankesat")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ankesat.findAll", query = "SELECT a FROM Ankesat a"),
    @NamedQuery(name = "Ankesat.findByAnkesaID", query = "SELECT a FROM Ankesat a WHERE a.ankesaID = :ankesaID"),
    @NamedQuery(name = "Ankesat.findByDataAnkseses", query = "SELECT a FROM Ankesat a WHERE a.dataAnkseses = :dataAnkseses")})
public class Ankesat implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "AnkesaID")
    
     @GeneratedValue(generator = "InvSeq")
    @SequenceGenerator(name = "InvSeq" , sequenceName = "INV_SEQ", allocationSize = 1)
    
    private Integer ankesaID;
    @Basic(optional = false)
    @Column(name = "DataAnkseses")
    @Temporal(TemporalType.DATE)
    private Date dataAnkseses;
    @Basic(optional = false)
    @Lob
    @Column(name = "Ankesa")
    private String ankesa;

    public Ankesat() {
    }

    public Ankesat(Integer ankesaID) {
        this.ankesaID = ankesaID;
    }

    public Ankesat(Integer ankesaID, Date dataAnkseses, String ankesa) {
        this.ankesaID = ankesaID;
        this.dataAnkseses = dataAnkseses;
        this.ankesa = ankesa;
    }

    public Integer getAnkesaID() {
        return ankesaID;
    }

    public void setAnkesaID(Integer ankesaID) {
        this.ankesaID = ankesaID;
    }

    public Date getDataAnkseses() {
        return dataAnkseses;
    }

    public void setDataAnkseses(Date dataAnkseses) {
        this.dataAnkseses = dataAnkseses;
    }

    public String getAnkesa() {
        return ankesa;
    }

    public void setAnkesa(String ankesa) {
        this.ankesa = ankesa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ankesaID != null ? ankesaID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ankesat)) {
            return false;
        }
        Ankesat other = (Ankesat) object;
        if ((this.ankesaID == null && other.ankesaID != null) || (this.ankesaID != null && !this.ankesaID.equals(other.ankesaID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BLL.Ankesat[ ankesaID=" + ankesaID + " ]";
    }
    
}
