/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Vishal
 */
@Entity
@Table(name = "propertyfeaturestb", catalog = "propertyrental", schema = "")
@XmlRootElement
@NamedQueries({
     @NamedQuery(name = "Propertyfeaturestb.findByPropertyId", query = "SELECT p FROM Propertyfeaturestb p WHERE p.propertyId = :propertyId"),
    @NamedQuery(name = "Propertyfeaturestb.findAll", query = "SELECT p FROM Propertyfeaturestb p"),
    @NamedQuery(name = "Propertyfeaturestb.findByPropertyFeatureId", query = "SELECT p FROM Propertyfeaturestb p WHERE p.propertyFeatureId = :propertyFeatureId"),
    @NamedQuery(name = "Propertyfeaturestb.findByIsActive", query = "SELECT p FROM Propertyfeaturestb p WHERE p.isActive = :isActive"),
    @NamedQuery(name = "Propertyfeaturestb.findByCreateDate", query = "SELECT p FROM Propertyfeaturestb p WHERE p.createDate = :createDate"),
    @NamedQuery(name = "Propertyfeaturestb.findByLastUpdate", query = "SELECT p FROM Propertyfeaturestb p WHERE p.lastUpdate = :lastUpdate")})
public class Propertyfeaturestb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PropertyFeatureId", nullable = false)
    private Integer propertyFeatureId;
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
    @JoinColumn(name = "PropertyId", referencedColumnName = "PropertyId", nullable = false)
    @ManyToOne(optional = false)
    private Propertytb propertyId;
    @JoinColumn(name = "FeatureId", referencedColumnName = "FeatureId", nullable = false)
    @ManyToOne(optional = false)
    private Featurestb featureId;
    @JoinColumn(name = "FeatureValueId", referencedColumnName = "FeatureValueId", nullable = false)
    @ManyToOne(optional = false)
    private Featurevaluetb featureValueId;

    public Propertyfeaturestb() {
    }

    public Propertyfeaturestb(Integer propertyFeatureId) {
        this.propertyFeatureId = propertyFeatureId;
    }

    public Propertyfeaturestb(Integer propertyFeatureId, int isActive,Date createDate) {
        this.propertyFeatureId = propertyFeatureId;
        this.isActive = isActive;
      
        this.createDate = createDate;
    }

    public Integer getPropertyFeatureId() {
        return propertyFeatureId;
    }

    public void setPropertyFeatureId(Integer propertyFeatureId) {
        this.propertyFeatureId = propertyFeatureId;
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

    public Propertytb getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Propertytb propertyId) {
        this.propertyId = propertyId;
    }

    public Featurestb getFeatureId() {
        return featureId;
    }

    public void setFeatureId(Featurestb featureId) {
        this.featureId = featureId;
    }

    public Featurevaluetb getFeatureValueId() {
        return featureValueId;
    }

    public void setFeatureValueId(Featurevaluetb featureValueId) {
        this.featureValueId = featureValueId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (propertyFeatureId != null ? propertyFeatureId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Propertyfeaturestb)) {
            return false;
        }
        Propertyfeaturestb other = (Propertyfeaturestb) object;
        if ((this.propertyFeatureId == null && other.propertyFeatureId != null) || (this.propertyFeatureId != null && !this.propertyFeatureId.equals(other.propertyFeatureId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Propertyfeaturestb[ propertyFeatureId=" + propertyFeatureId + " ]";
    }
    
}
