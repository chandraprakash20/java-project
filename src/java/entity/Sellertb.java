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
@Table(name = "sellertb", catalog = "propertyrental", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sellertb.findAll", query = "SELECT s FROM Sellertb s"),
    @NamedQuery(name = "Sellertb.findAllPtype", query = "SELECT s FROM Sellertb s,Propertytb p WHERE s.propertyId.propertyId=p.propertyId and p.propertyTypeId=:propertyTypeId and s.isActive = :isActive"),
    @NamedQuery(name = "Sellertb.findAllUserid", query = "SELECT s FROM Sellertb s,Usertb u WHERE s.userId.userId=u.userId and u.userId=:userId and s.isActive = :isActive"),
    @NamedQuery(name = "Sellertb.findBySellerId", query = "SELECT s FROM Sellertb s WHERE s.sellerId = :sellerId"),
    @NamedQuery(name = "Sellertb.findByType", query = "SELECT s FROM Sellertb s WHERE s.type = :type and s.isActive = :isActive"),
    @NamedQuery(name = "Sellertb.findByCity", query = "SELECT s FROM Sellertb s WHERE s.cityId = :CityId and s.isActive = :isActive"),
    @NamedQuery(name = "Sellertb.findByTC", query = "SELECT s FROM Sellertb s WHERE s.type = :type and s.cityId = :CityId and s.isActive = :isActive"),
    @NamedQuery(name = "Sellertb.findByCompanyName", query = "SELECT s FROM Sellertb s WHERE s.companyName = :companyName"),
    @NamedQuery(name = "Sellertb.findByCompanyURL", query = "SELECT s FROM Sellertb s WHERE s.companyURL = :companyURL"),
    @NamedQuery(name = "Sellertb.findByAddress", query = "SELECT s FROM Sellertb s WHERE s.address = :address"),
    @NamedQuery(name = "Sellertb.findByIsActive", query = "SELECT s FROM Sellertb s WHERE s.isActive = :isActive"),
    @NamedQuery(name = "Sellertb.findByCreateDate", query = "SELECT s FROM Sellertb s WHERE s.createDate = :createDate"),
    @NamedQuery(name = "Sellertb.findByLastUpdate", query = "SELECT s FROM Sellertb s WHERE s.lastUpdate = :lastUpdate"),
    @NamedQuery(name = "Sellertb.findByUpdateBy", query = "SELECT s FROM Sellertb s WHERE s.updateBy = :updateBy")})
public class Sellertb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SellerId", nullable = false)
    private Integer sellerId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Type", nullable = false, length = 50)
    private String type;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CompanyName", nullable = false, length = 50)
    private String companyName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CompanyURL", nullable = false, length = 50)
    private String companyURL;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Address", nullable = false, length = 50)
    private String address;
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
    @Size(max = 50)
    @Column(name = "UpdateBy", length = 50)
    private String updateBy;
    @JoinColumn(name = "StateId", referencedColumnName = "StateId", nullable = false)
    @ManyToOne(optional = false)
    private Statetb stateId;
    @JoinColumn(name = "CityId", referencedColumnName = "CityId", nullable = false)
    @ManyToOne(optional = false)
    private Citytb cityId;
    @JoinColumn(name = "PropertyId", referencedColumnName = "PropertyId", nullable = false)
    @ManyToOne(optional = false)
    private Propertytb propertyId;
    @JoinColumn(name = "UserId", referencedColumnName = "UserId", nullable = false)
    @ManyToOne(optional = false)
    private Usertb userId;

    public Sellertb() {
    }

    public Sellertb(Integer sellerId) {
        this.sellerId = sellerId;
    }

    public Sellertb(Integer sellerId, String type, String companyName, String companyURL, String address, int isActive,Date createDate) {
        this.sellerId = sellerId;
        this.type = type;
        this.companyName = companyName;
        this.companyURL = companyURL;
        this.address = address;
        this.isActive = isActive;
        
        this.createDate = createDate;
    }

    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyURL() {
        return companyURL;
    }

    public void setCompanyURL(String companyURL) {
        this.companyURL = companyURL;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Statetb getStateId() {
        return stateId;
    }

    public void setStateId(Statetb stateId) {
        this.stateId = stateId;
    }

    public Citytb getCityId() {
        return cityId;
    }

    public void setCityId(Citytb cityId) {
        this.cityId = cityId;
    }

    public Propertytb getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Propertytb propertyId) {
        this.propertyId = propertyId;
    }

    public Usertb getUserId() {
        return userId;
    }

    public void setUserId(Usertb userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sellerId != null ? sellerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sellertb)) {
            return false;
        }
        Sellertb other = (Sellertb) object;
        if ((this.sellerId == null && other.sellerId != null) || (this.sellerId != null && !this.sellerId.equals(other.sellerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Sellertb[ sellerId=" + sellerId + " ]";
    }
    
}
