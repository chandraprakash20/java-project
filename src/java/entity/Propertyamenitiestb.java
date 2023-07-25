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
@Table(name = "propertyamenitiestb", catalog = "propertyrental", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Propertyamenitiestb.findAll", query = "SELECT p FROM Propertyamenitiestb p"),
    @NamedQuery(name = "Propertyamenitiestb.findByPropertyAmenitiesId", query = "SELECT p FROM Propertyamenitiestb p WHERE p.propertyAmenitiesId = :propertyAmenitiesId"),
    @NamedQuery(name = "Propertyamenitiestb.findByIsActive", query = "SELECT p FROM Propertyamenitiestb p WHERE p.isActive = :isActive"),
    @NamedQuery(name = "Propertyamenitiestb.findByCreateDate", query = "SELECT p FROM Propertyamenitiestb p WHERE p.createDate = :createDate"),
    @NamedQuery(name = "Propertyamenitiestb.findByLastUpdate", query = "SELECT p FROM Propertyamenitiestb p WHERE p.lastUpdate = :lastUpdate")})
public class Propertyamenitiestb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PropertyAmenitiesId", nullable = false)
    private Integer propertyAmenitiesId;
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
    @JoinColumn(name = "AmenitiesId", referencedColumnName = "AmenitiesId", nullable = false)
    @ManyToOne(optional = false)
    private Amenitiestb amenitiesId;

    public Propertyamenitiestb() {
    }

    public Propertyamenitiestb(Integer propertyAmenitiesId) {
        this.propertyAmenitiesId = propertyAmenitiesId;
    }

    public Propertyamenitiestb(Integer propertyAmenitiesId, int isActive,Date createDate) {
        this.propertyAmenitiesId = propertyAmenitiesId;
        this.isActive = isActive;
       
        this.createDate = createDate;
    }

    public Integer getPropertyAmenitiesId() {
        return propertyAmenitiesId;
    }

    public void setPropertyAmenitiesId(Integer propertyAmenitiesId) {
        this.propertyAmenitiesId = propertyAmenitiesId;
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

    public Amenitiestb getAmenitiesId() {
        return amenitiesId;
    }

    public void setAmenitiesId(Amenitiestb amenitiesId) {
        this.amenitiesId = amenitiesId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (propertyAmenitiesId != null ? propertyAmenitiesId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Propertyamenitiestb)) {
            return false;
        }
        Propertyamenitiestb other = (Propertyamenitiestb) object;
        if ((this.propertyAmenitiesId == null && other.propertyAmenitiesId != null) || (this.propertyAmenitiesId != null && !this.propertyAmenitiesId.equals(other.propertyAmenitiesId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Propertyamenitiestb[ propertyAmenitiesId=" + propertyAmenitiesId + " ]";
    }
    
}
