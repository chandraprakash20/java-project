/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Vishal
 */
@Entity
@Table(name = "featurevaluetb", catalog = "propertyrental", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Featurevaluetb.findAll", query = "SELECT f FROM Featurevaluetb f"),
    @NamedQuery(name = "Featurevaluetb.findByFeatureValueId", query = "SELECT f FROM Featurevaluetb f WHERE f.featureValueId = :featureValueId"),
    @NamedQuery(name = "Featurevaluetb.findByFeatureId", query = "SELECT f FROM Featurevaluetb f WHERE f.featureId = :featureId"),
    @NamedQuery(name = "Featurevaluetb.findByValue", query = "SELECT f FROM Featurevaluetb f WHERE f.value = :value"),
    @NamedQuery(name = "Featurevaluetb.findByIsActive", query = "SELECT f FROM Featurevaluetb f WHERE f.isActive = :isActive"),
    @NamedQuery(name = "Featurevaluetb.findByCreateDate", query = "SELECT f FROM Featurevaluetb f WHERE f.createDate = :createDate"),
    @NamedQuery(name = "Featurevaluetb.findByLastUpdate", query = "SELECT f FROM Featurevaluetb f WHERE f.lastUpdate = :lastUpdate")})
public class Featurevaluetb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "FeatureValueId", nullable = false)
    private Integer featureValueId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FeatureId", nullable = false)
    private int featureId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Value", nullable = false, length = 50)
    private String value;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IsActive", nullable = false)
    private int isActive;
   
    @Basic(optional = false)
    @NotNull
    @Column(name = "CreateDate", nullable = false)
    private int createDate;
    @Column(name = "LastUpdate")
    private Integer lastUpdate;
    @JoinColumn(name = "FeatureValueId", referencedColumnName = "FeatureId", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Featurestb featurestb;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "featureValueId")
    private Collection<Propertyfeaturestb> propertyfeaturestbCollection;

    public Featurevaluetb() {
    }

    public Featurevaluetb(Integer featureValueId) {
        this.featureValueId = featureValueId;
    }

    public Featurevaluetb(Integer featureValueId, int featureId, String value, int isActive, int createDate) {
        this.featureValueId = featureValueId;
        this.featureId = featureId;
        this.value = value;
        this.isActive = isActive;
        
        this.createDate = createDate;
    }

    public Integer getFeatureValueId() {
        return featureValueId;
    }

    public void setFeatureValueId(Integer featureValueId) {
        this.featureValueId = featureValueId;
    }

    public int getFeatureId() {
        return featureId;
    }

    public void setFeatureId(int featureId) {
        this.featureId = featureId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

   

    public int getCreateDate() {
        return createDate;
    }

    public void setCreateDate(int createDate) {
        this.createDate = createDate;
    }

    public Integer getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Integer lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Featurestb getFeaturestb() {
        return featurestb;
    }

    public void setFeaturestb(Featurestb featurestb) {
        this.featurestb = featurestb;
    }

    @XmlTransient
    @JsonbTransient
    public Collection<Propertyfeaturestb> getPropertyfeaturestbCollection() {
        return propertyfeaturestbCollection;
    }

    public void setPropertyfeaturestbCollection(Collection<Propertyfeaturestb> propertyfeaturestbCollection) {
        this.propertyfeaturestbCollection = propertyfeaturestbCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (featureValueId != null ? featureValueId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Featurevaluetb)) {
            return false;
        }
        Featurevaluetb other = (Featurevaluetb) object;
        if ((this.featureValueId == null && other.featureValueId != null) || (this.featureValueId != null && !this.featureValueId.equals(other.featureValueId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Featurevaluetb[ featureValueId=" + featureValueId + " ]";
    }
    
}
