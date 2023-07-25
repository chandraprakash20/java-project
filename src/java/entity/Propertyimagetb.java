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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Vishal
 */
@Entity
@Table(name = "propertyimagetb", catalog = "propertyrental", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Propertyimagetb.findAll", query = "SELECT p FROM Propertyimagetb p"),
    @NamedQuery(name = "Propertyimagetb.findById", query = "SELECT p FROM Propertyimagetb p WHERE p.propertyId = :propertyId"),
    @NamedQuery(name = "Propertyimagetb.findByImageId", query = "SELECT p FROM Propertyimagetb p WHERE p.imageId = :imageId"),
    @NamedQuery(name = "Propertyimagetb.findByImage", query = "SELECT p FROM Propertyimagetb p WHERE p.image = :image"),
    @NamedQuery(name = "Propertyimagetb.findByIsActive", query = "SELECT p FROM Propertyimagetb p WHERE p.isActive = :isActive"),
    @NamedQuery(name = "Propertyimagetb.findByCreateDate", query = "SELECT p FROM Propertyimagetb p WHERE p.createDate = :createDate"),
    @NamedQuery(name = "Propertyimagetb.findByLastUpdate", query = "SELECT p FROM Propertyimagetb p WHERE p.lastUpdate = :lastUpdate")})
public class Propertyimagetb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ImageId", nullable = false)
    private Integer imageId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "Image", nullable = false, length = 70)
    private String image;
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

    public Propertyimagetb() {
    }

    public Propertyimagetb(Integer imageId) {
        this.imageId = imageId;
    }

    public Propertyimagetb(Integer imageId, String image, int isActive,Date createDate) {
        this.imageId = imageId;
        this.image = image;
        this.isActive = isActive;
        
        this.createDate = createDate;
    }

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (imageId != null ? imageId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Propertyimagetb)) {
            return false;
        }
        Propertyimagetb other = (Propertyimagetb) object;
        if ((this.imageId == null && other.imageId != null) || (this.imageId != null && !this.imageId.equals(other.imageId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Propertyimagetb[ imageId=" + imageId + " ]";
    }
    
}
