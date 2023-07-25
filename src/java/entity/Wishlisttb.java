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
@Table(name = "wishlisttb", catalog = "propertyrental", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Wishlisttb.findAll", query = "SELECT w FROM Wishlisttb w"),
        @NamedQuery(name = "Wishlisttb.findAllByUserId", query = "SELECT w FROM Wishlisttb w WHERE w.userId=:userId"),
    @NamedQuery(name = "Wishlisttb.findByWishlistId", query = "SELECT w FROM Wishlisttb w WHERE w.wishlistId = :wishlistId"),
    @NamedQuery(name = "Wishlisttb.findByIsActive", query = "SELECT w FROM Wishlisttb w WHERE w.isActive = :isActive"),
    @NamedQuery(name = "Wishlisttb.findByCreateDate", query = "SELECT w FROM Wishlisttb w WHERE w.createDate = :createDate"),
    @NamedQuery(name = "Wishlisttb.findByLastUpdate", query = "SELECT w FROM Wishlisttb w WHERE w.lastUpdate = :lastUpdate")})
public class Wishlisttb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "WishlistId", nullable = false)
    private Integer wishlistId;
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
    @JoinColumn(name = "UserId", referencedColumnName = "UserId", nullable = false)
    @ManyToOne(optional = false)
    private Usertb userId;
    @JoinColumn(name = "PropertyId", referencedColumnName = "PropertyId", nullable = false)
    @ManyToOne(optional = false)
    private Propertytb propertyId;

    public Wishlisttb() {
    }

    public Wishlisttb(Integer wishlistId) {
        this.wishlistId = wishlistId;
    }

    public Wishlisttb(Integer wishlistId, int isActive,Date createDate) {
        this.wishlistId = wishlistId;
        this.isActive = isActive;
        
        this.createDate = createDate;
    }

    public Integer getWishlistId() {
        return wishlistId;
    }

    public void setWishlistId(Integer wishlistId) {
        this.wishlistId = wishlistId;
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

    public Usertb getUserId() {
        return userId;
    }

    public void setUserId(Usertb userId) {
        this.userId = userId;
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
        hash += (wishlistId != null ? wishlistId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Wishlisttb)) {
            return false;
        }
        Wishlisttb other = (Wishlisttb) object;
        if ((this.wishlistId == null && other.wishlistId != null) || (this.wishlistId != null && !this.wishlistId.equals(other.wishlistId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Wishlisttb[ wishlistId=" + wishlistId + " ]";
    }
    
}
