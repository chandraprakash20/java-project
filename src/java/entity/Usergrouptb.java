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
@Table(name = "usergrouptb", catalog = "propertyrental", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usergrouptb.findAll", query = "SELECT u FROM Usergrouptb u"),
    @NamedQuery(name = "Usergrouptb.findByUserGroupId", query = "SELECT u FROM Usergrouptb u WHERE u.userGroupId = :userGroupId"),
    @NamedQuery(name = "Usergrouptb.findByIsActive", query = "SELECT u FROM Usergrouptb u WHERE u.isActive = :isActive"),
    @NamedQuery(name = "Usergrouptb.findByCreateDate", query = "SELECT u FROM Usergrouptb u WHERE u.createDate = :createDate"),
    @NamedQuery(name = "Usergrouptb.findByLastUpdate", query = "SELECT u FROM Usergrouptb u WHERE u.lastUpdate = :lastUpdate")})
public class Usergrouptb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "UserGroupId", nullable = false)
    private Integer userGroupId;
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
    @JoinColumn(name = "GroupId", referencedColumnName = "GroupId", nullable = false)
    @ManyToOne(optional = false)
    private Grouptb groupId;

    public Usergrouptb() {
    }

    public Usergrouptb(Integer userGroupId) {
        this.userGroupId = userGroupId;
    }

    public Usergrouptb(Integer userGroupId, int isActive, Date createDate) {
        this.userGroupId = userGroupId;
        this.isActive = isActive;
        
        this.createDate = createDate;
    }

    public Integer getUserGroupId() {
        return userGroupId;
    }

    public void setUserGroupId(Integer userGroupId) {
        this.userGroupId = userGroupId;
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

    public Grouptb getGroupId() {
        return groupId;
    }

    public void setGroupId(Grouptb groupId) {
        this.groupId = groupId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userGroupId != null ? userGroupId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usergrouptb)) {
            return false;
        }
        Usergrouptb other = (Usergrouptb) object;
        if ((this.userGroupId == null && other.userGroupId != null) || (this.userGroupId != null && !this.userGroupId.equals(other.userGroupId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Usergrouptb[ userGroupId=" + userGroupId + " ]";
    }
    
}
