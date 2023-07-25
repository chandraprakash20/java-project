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
@Table(name = "grouptb", catalog = "propertyrental", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Grouptb.findAll", query = "SELECT g FROM Grouptb g"),
    @NamedQuery(name = "Grouptb.findByGroupId", query = "SELECT g FROM Grouptb g WHERE g.groupId = :groupId"),
    @NamedQuery(name = "Grouptb.findByGroupName", query = "SELECT g FROM Grouptb g WHERE g.groupName = :groupName"),
    @NamedQuery(name = "Grouptb.findByIsActive", query = "SELECT g FROM Grouptb g WHERE g.isActive = :isActive"),
    @NamedQuery(name = "Grouptb.findByCreateDate", query = "SELECT g FROM Grouptb g WHERE g.createDate = :createDate"),
    @NamedQuery(name = "Grouptb.findByLastUpdate", query = "SELECT g FROM Grouptb g WHERE g.lastUpdate = :lastUpdate")})
public class Grouptb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "GroupId", nullable = false)
    private Integer groupId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "GroupName", nullable = false, length = 50)
    private String groupName;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "groupId")
    private Collection<Usergrouptb> usergrouptbCollection;

    public Grouptb() {
    }

    public Grouptb(Integer groupId) {
        this.groupId = groupId;
    }

    public Grouptb(Integer groupId, String groupName, int isActive,Date createDate) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.isActive = isActive;
        
        this.createDate = createDate;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
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
    public Collection<Usergrouptb> getUsergrouptbCollection() {
        return usergrouptbCollection;
    }

    public void setUsergrouptbCollection(Collection<Usergrouptb> usergrouptbCollection) {
        this.usergrouptbCollection = usergrouptbCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (groupId != null ? groupId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Grouptb)) {
            return false;
        }
        Grouptb other = (Grouptb) object;
        if ((this.groupId == null && other.groupId != null) || (this.groupId != null && !this.groupId.equals(other.groupId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Grouptb[ groupId=" + groupId + " ]";
    }
    
}
