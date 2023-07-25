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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "featurestb", catalog = "propertyrental", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Featurestb.findAll", query = "SELECT f FROM Featurestb f"),
    @NamedQuery(name = "Featurestb.findAllStatus", query = "SELECT f FROM Featurestb f WHERE f.isActive=:isActive"),
    @NamedQuery(name = "Featurestb.findByFeatureId", query = "SELECT f FROM Featurestb f WHERE f.featureId = :featureId"),
    @NamedQuery(name = "Featurestb.findByFeature", query = "SELECT f FROM Featurestb f WHERE f.feature = :feature"),
    @NamedQuery(name = "Featurestb.findByIsActive", query = "SELECT f FROM Featurestb f WHERE f.isActive = :isActive"),
    @NamedQuery(name = "Featurestb.findByCreateDate", query = "SELECT f FROM Featurestb f WHERE f.createDate = :createDate"),
    @NamedQuery(name = "Featurestb.findByLastUpdate", query = "SELECT f FROM Featurestb f WHERE f.lastUpdate = :lastUpdate")})
public class Featurestb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "FeatureId", nullable = false)
    private Integer featureId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Feature", nullable = false, length = 50)
    private String feature;
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
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "featurestb")
    private Featurevaluetb featurevaluetb;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "featureId")
    private Collection<Propertyfeaturestb> propertyfeaturestbCollection;
    @JoinColumn(name = "PropertyTypeId", referencedColumnName = "PropertytypeId", nullable = false)
    @ManyToOne(optional = false)
    private Propertytypetb propertyTypeId;

    public Featurestb() {
    }

    public Featurestb(Integer featureId) {
        this.featureId = featureId;
    }

    public Featurestb(Integer featureId, String feature, int isActive, Date createDate) {
        this.featureId = featureId;
        this.feature = feature;
        this.isActive = isActive;
        
        this.createDate = createDate;
    }

    public Integer getFeatureId() {
        return featureId;
    }

    public void setFeatureId(Integer featureId) {
        this.featureId = featureId;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
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

    public Featurevaluetb getFeaturevaluetb() {
        return featurevaluetb;
    }

    public void setFeaturevaluetb(Featurevaluetb featurevaluetb) {
        this.featurevaluetb = featurevaluetb;
    }

    @XmlTransient
    @JsonbTransient
    public Collection<Propertyfeaturestb> getPropertyfeaturestbCollection() {
        return propertyfeaturestbCollection;
    }

    public void setPropertyfeaturestbCollection(Collection<Propertyfeaturestb> propertyfeaturestbCollection) {
        this.propertyfeaturestbCollection = propertyfeaturestbCollection;
    }

    public Propertytypetb getPropertyTypeId() {
        return propertyTypeId;
    }

    public void setPropertyTypeId(Propertytypetb propertyTypeId) {
        this.propertyTypeId = propertyTypeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (featureId != null ? featureId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Featurestb)) {
            return false;
        }
        Featurestb other = (Featurestb) object;
        if ((this.featureId == null && other.featureId != null) || (this.featureId != null && !this.featureId.equals(other.featureId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Featurestb[ featureId=" + featureId + " ]";
    }
    
}
