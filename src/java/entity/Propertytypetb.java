/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Vishal
 */
@Entity
@Table(name = "propertytypetb", catalog = "propertyrental", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Propertytypetb.findAll", query = "SELECT p FROM Propertytypetb p"),
    @NamedQuery(name = "Propertytypetb.findAllStatus", query = "SELECT p FROM Propertytypetb p WHERE p.isActive=:isActive"),
    @NamedQuery(name = "Propertytypetb.findByPropertytypeId", query = "SELECT p FROM Propertytypetb p WHERE p.propertytypeId = :propertytypeId"),
    @NamedQuery(name = "Propertytypetb.findByPropertyName", query = "SELECT p FROM Propertytypetb p WHERE p.propertyName = :propertyName"),
    @NamedQuery(name = "Propertytypetb.findByIsActive", query = "SELECT p FROM Propertytypetb p WHERE p.isActive = :isActive"),
    @NamedQuery(name = "Propertytypetb.findByCreateDate", query = "SELECT p FROM Propertytypetb p WHERE p.createDate = :createDate"),
    @NamedQuery(name = "Propertytypetb.findByLastUpdate", query = "SELECT p FROM Propertytypetb p WHERE p.lastUpdate = :lastUpdate")})
public class Propertytypetb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PropertytypeId", nullable = false)
    private Integer propertytypeId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "PropertyName", nullable = false, length = 100)
    private String propertyName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IsActive", nullable = false)
    private int isActive;
   
    @Basic(optional = false)
    @NotNull
    @Column(name = "CreateDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Column(name = "LastUpdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "propertyTypeId")
    private Collection<Propertytb> propertytbCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "propertyTypeId")
    private Collection<Featurestb> featurestbCollection;

    public Propertytypetb() {
    }

    public Propertytypetb(Integer propertytypeId) {
        this.propertytypeId = propertytypeId;
    }

    public Propertytypetb(Integer propertytypeId, String propertyName, int isActive, Date createDate) {
        this.propertytypeId = propertytypeId;
        this.propertyName = propertyName;
        this.isActive = isActive;
        
        this.createDate = createDate;
    }

    public Integer getPropertytypeId() {
        return propertytypeId;
    }

    public void setPropertytypeId(Integer propertytypeId) {
        this.propertytypeId = propertytypeId;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }


    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @XmlTransient
    @JsonbTransient
    public Collection<Propertytb> getPropertytbCollection() {
        return propertytbCollection;
    }

    public void setPropertytbCollection(Collection<Propertytb> propertytbCollection) {
        this.propertytbCollection = propertytbCollection;
    }

    @XmlTransient
    @JsonbTransient
    public Collection<Featurestb> getFeaturestbCollection() {
        return featurestbCollection;
    }

    public void setFeaturestbCollection(Collection<Featurestb> featurestbCollection) {
        this.featurestbCollection = featurestbCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (propertytypeId != null ? propertytypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Propertytypetb)) {
            return false;
        }
        Propertytypetb other = (Propertytypetb) object;
        if ((this.propertytypeId == null && other.propertytypeId != null) || (this.propertytypeId != null && !this.propertytypeId.equals(other.propertytypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Propertytypetb[ propertytypeId=" + propertytypeId + " ]";
    }
    
}
