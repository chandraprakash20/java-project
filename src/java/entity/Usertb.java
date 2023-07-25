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
@Table(name = "usertb", catalog = "propertyrental", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usertb.findAll", query = "SELECT u FROM Usertb u"),
    @NamedQuery(name = "Usertb.findAllStatus", query = "SELECT u FROM Usertb u WHERE u.isActive=:isActive"),
    @NamedQuery(name = "Usertb.validate", query = "SELECT u FROM Usertb u WHERE  u.email=:email and u.password=:password and u.isActive=:isActive"),
    @NamedQuery(name = "Usertb.findByUserId", query = "SELECT u FROM Usertb u WHERE u.userId = :userId"),
    @NamedQuery(name = "Usertb.findByUserName", query = "SELECT u FROM Usertb u WHERE u.userName = :userName"),
    @NamedQuery(name = "Usertb.findByEmail", query = "SELECT u FROM Usertb u WHERE u.email = :email"),
    @NamedQuery(name = "Usertb.findByPassword", query = "SELECT u FROM Usertb u WHERE u.password = :password"),
    @NamedQuery(name = "Usertb.findByMobileNo", query = "SELECT u FROM Usertb u WHERE u.mobileNo = :mobileNo"),
    @NamedQuery(name = "Usertb.findByIsSeller", query = "SELECT u FROM Usertb u WHERE u.isSeller = :isSeller and u.isActive=:isActive"),
    @NamedQuery(name = "Usertb.findByIsUser", query = "SELECT u FROM Usertb u WHERE u.isSeller = :isSeller and u.isActive=:isActive"),
    @NamedQuery(name = "Usertb.findByIsActive", query = "SELECT u FROM Usertb u WHERE u.isActive = :isActive"),
    @NamedQuery(name = "Usertb.findByCreateDate", query = "SELECT u FROM Usertb u WHERE u.createDate = :createDate"),
    @NamedQuery(name = "Usertb.findByLastUpdate", query = "SELECT u FROM Usertb u WHERE u.lastUpdate = :lastUpdate")})
public class Usertb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "UserId", nullable = false)
    private Integer userId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "UserName", nullable = false, length = 50)
    private String userName;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Email", nullable = false, length = 50)
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Password", nullable = false, length = 50)
    private String password;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MobileNo", nullable = false)
    private String mobileNo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IsSeller", nullable = false)
    private int isSeller;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<Sellertb> sellertbCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<Usergrouptb> usergrouptbCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<Wishlisttb> wishlisttbCollection;

    public Usertb() {
    }

    public Usertb(Integer userId) {
        this.userId = userId;
    }

    public Usertb(Integer userId, String userName, String email, String password, String mobileNo, int isSeller, int isActive, Date createDate) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.mobileNo = mobileNo;
        this.isSeller = isSeller;
        this.isActive = isActive;
        
        this.createDate = createDate;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public int getIsSeller() {
        return isSeller;
    }

    public void setIsSeller(int isSeller) {
        this.isSeller = isSeller;
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
    public Collection<Usergrouptb> getUsergrouptbCollection() {
        return usergrouptbCollection;
    }

    public void setUsergrouptbCollection(Collection<Usergrouptb> usergrouptbCollection) {
        this.usergrouptbCollection = usergrouptbCollection;
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
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usertb)) {
            return false;
        }
        Usertb other = (Usertb) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Usertb[ userId=" + userId + " ]";
    }
    
}
