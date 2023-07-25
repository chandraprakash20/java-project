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
@Table(name = "propertytb", catalog = "propertyrental", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Propertytb.findAll", query = "SELECT p FROM Propertytb p"),
    @NamedQuery(name = "Propertytb.findByPropertyId", query = "SELECT p FROM Propertytb p WHERE p.propertyId = :propertyId"),
    @NamedQuery(name = "Propertytb.findByPropertyName", query = "SELECT p FROM Propertytb p WHERE p.propertyName = :propertyName"),
    @NamedQuery(name = "Propertytb.findByPlotArea", query = "SELECT p FROM Propertytb p WHERE p.plotArea = :plotArea"),
    @NamedQuery(name = "Propertytb.findByAreaUnit", query = "SELECT p FROM Propertytb p WHERE p.areaUnit = :areaUnit"),
    @NamedQuery(name = "Propertytb.findByPrice", query = "SELECT p FROM Propertytb p WHERE p.price = :price"),
    @NamedQuery(name = "Propertytb.findByDescription", query = "SELECT p FROM Propertytb p WHERE p.description = :description"),
    @NamedQuery(name = "Propertytb.findByIsActive", query = "SELECT p FROM Propertytb p WHERE p.isActive = :isActive"),
    @NamedQuery(name = "Propertytb.findByCreateDate", query = "SELECT p FROM Propertytb p WHERE p.createDate = :createDate"),
    @NamedQuery(name = "Propertytb.findByLastUpdate", query = "SELECT p FROM Propertytb p WHERE p.lastUpdate = :lastUpdate")})
public class Propertytb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PropertyId", nullable = false)
    private Integer propertyId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PropertyName", nullable = false, length = 50)
    private String propertyName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PlotArea", nullable = false, length = 50)
    private String plotArea;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "AreaUnit", nullable = false, length = 50)
    private String areaUnit;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Price", nullable = false, length = 20)
    private String price;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Description", nullable = false, length = 50)
    private String description;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "propertyId")
    private Collection<Sellertb> sellertbCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "propertyId")
    private Collection<Propertyfeaturestb> propertyfeaturestbCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "propertyId")
    private Collection<Propertyimagetb> propertyimagetbCollection;
    @JoinColumn(name = "PropertyTypeId", referencedColumnName = "PropertytypeId", nullable = false)
    @ManyToOne(optional = false)
    private Propertytypetb propertyTypeId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "propertyId")
    private Collection<Propertyamenitiestb> propertyamenitiestbCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "propertyId")
    private Collection<Wishlisttb> wishlisttbCollection;

    public Propertytb() {
    }

    public Propertytb(Integer propertyId) {
        this.propertyId = propertyId;
    }

    public Propertytb(Integer propertyId, String propertyName, String plotArea, String areaUnit, String price, String description, int isActive,Date createDate) {
        this.propertyId = propertyId;
        this.propertyName = propertyName;
        this.plotArea = plotArea;
        this.areaUnit = areaUnit;
        this.price = price;
        this.description = description;
        this.isActive = isActive;
        
        this.createDate = createDate;
    }

    public Integer getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Integer propertyId) {
        this.propertyId = propertyId;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getPlotArea() {
        return plotArea;
    }

    public void setPlotArea(String plotArea) {
        this.plotArea = plotArea;
    }

    public String getAreaUnit() {
        return areaUnit;
    }

    public void setAreaUnit(String areaUnit) {
        this.areaUnit = areaUnit;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
    public Collection<Sellertb> getSellertbCollection() {
        return sellertbCollection;
    }

    public void setSellertbCollection(Collection<Sellertb> sellertbCollection) {
        this.sellertbCollection = sellertbCollection;
    }

    @XmlTransient
    @JsonbTransient
    public Collection<Propertyfeaturestb> getPropertyfeaturestbCollection() {
        return propertyfeaturestbCollection;
    }

    public void setPropertyfeaturestbCollection(Collection<Propertyfeaturestb> propertyfeaturestbCollection) {
        this.propertyfeaturestbCollection = propertyfeaturestbCollection;
    }

    @XmlTransient
    @JsonbTransient
    public Collection<Propertyimagetb> getPropertyimagetbCollection() {
        return propertyimagetbCollection;
    }

    public void setPropertyimagetbCollection(Collection<Propertyimagetb> propertyimagetbCollection) {
        this.propertyimagetbCollection = propertyimagetbCollection;
    }

    public Propertytypetb getPropertyTypeId() {
        return propertyTypeId;
    }

    public void setPropertyTypeId(Propertytypetb propertyTypeId) {
        this.propertyTypeId = propertyTypeId;
    }

    @XmlTransient
    @JsonbTransient
    public Collection<Propertyamenitiestb> getPropertyamenitiestbCollection() {
        return propertyamenitiestbCollection;
    }

    public void setPropertyamenitiestbCollection(Collection<Propertyamenitiestb> propertyamenitiestbCollection) {
        this.propertyamenitiestbCollection = propertyamenitiestbCollection;
    }

    @XmlTransient
    @JsonbTransient
    public Collection<Wishlisttb> getWishlisttbCollection() {
        return wishlisttbCollection;
    }

    public void setWishlisttbCollection(Collection<Wishlisttb> wishlisttbCollection) {
        this.wishlisttbCollection = wishlisttbCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (propertyId != null ? propertyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Propertytb)) {
            return false;
        }
        Propertytb other = (Propertytb) object;
        if ((this.propertyId == null && other.propertyId != null) || (this.propertyId != null && !this.propertyId.equals(other.propertyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Propertytb[ propertyId=" + propertyId + " ]";
    }
    
}
