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
@Table(name = "amenitiestb", catalog = "propertyrental", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Amenitiestb.findAll", query = "SELECT a FROM Amenitiestb a"),
    @NamedQuery(name = "Amenitiestb.findAllStatus", query = "SELECT a FROM Amenitiestb a WHERE a.isActive=:isActive"),
    @NamedQuery(name = "Amenitiestb.findByAmenitiesId", query = "SELECT a FROM Amenitiestb a WHERE a.amenitiesId = :amenitiesId"),
    @NamedQuery(name = "Amenitiestb.findByAmenities", query = "SELECT a FROM Amenitiestb a WHERE a.amenities = :amenities"),
    @NamedQuery(name = "Amenitiestb.findByIsActive", query = "SELECT a FROM Amenitiestb a WHERE a.isActive = :isActive"),
  
    @NamedQuery(name = "Amenitiestb.findByCreateDate", query = "SELECT a FROM Amenitiestb a WHERE a.createDate = :createDate"),
    @NamedQuery(name = "Amenitiestb.findByLastUpdate", query = "SELECT a FROM Amenitiestb a WHERE a.lastUpdate = :lastUpdate")})
public class Amenitiestb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "AmenitiesId", nullable = false)
    private Integer amenitiesId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Amenities", nullable = false, length = 50)
    private String amenities;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "amenitiesId")
    private Collection<Propertyamenitiestb> propertyamenitiestbCollection;

    public Amenitiestb() {
    }

    public Amenitiestb(Integer amenitiesId) {
        this.amenitiesId = amenitiesId;
    }

    public Amenitiestb(Integer amenitiesId, String amenities, int isActive,Date createDate) {
        this.amenitiesId = amenitiesId;
        this.amenities = amenities;
        this.isActive = isActive;
       
        this.createDate = createDate;
    }

    public Integer getAmenitiesId() {
        return amenitiesId;
    }

    public void setAmenitiesId(Integer amenitiesId) {
        this.amenitiesId = amenitiesId;
    }

    public String getAmenities() {
        return amenities;
    }

    public void setAmenities(String amenities) {
        this.amenities = amenities;
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
    public Collection<Propertyamenitiestb> getPropertyamenitiestbCollection() {
        return propertyamenitiestbCollection;
    }

    public void setPropertyamenitiestbCollection(Collection<Propertyamenitiestb> propertyamenitiestbCollection) {
        this.propertyamenitiestbCollection = propertyamenitiestbCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (amenitiesId != null ? amenitiesId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Amenitiestb)) {
            return false;
        }
        Amenitiestb other = (Amenitiestb) object;
        if ((this.amenitiesId == null && other.amenitiesId != null) || (this.amenitiesId != null && !this.amenitiesId.equals(other.amenitiesId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Amenitiestb[ amenitiesId=" + amenitiesId + " ]";
    }
    
}
