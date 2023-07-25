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
@Table(name = "statetb", catalog = "propertyrental", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Statetb.findAll", query = "SELECT s FROM Statetb s"),
    @NamedQuery(name = "Statetb.findAllStatus", query = "SELECT s FROM Statetb s WHERE s.isActive=:isActive"),
    @NamedQuery(name = "Statetb.findByStateId", query = "SELECT s FROM Statetb s WHERE s.stateId = :stateId"),
    @NamedQuery(name = "Statetb.findByState", query = "SELECT s FROM Statetb s WHERE s.state = :state"),
    @NamedQuery(name = "Statetb.findByIsActive", query = "SELECT s FROM Statetb s WHERE s.isActive = :isActive"),
    @NamedQuery(name = "Statetb.findByCreateDate", query = "SELECT s FROM Statetb s WHERE s.createDate = :createDate"),
    @NamedQuery(name = "Statetb.findByLastUpdate", query = "SELECT s FROM Statetb s WHERE s.lastUpdate = :lastUpdate")})
public class Statetb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "StateId", nullable = false)
    private Integer stateId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "State", nullable = false, length = 50)
    private String state;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stateId")
    private Collection<Sellertb> sellertbCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stateId")
    private Collection<Citytb> citytbCollection;

    public Statetb() {
    }

    public Statetb(Integer stateId) {
        this.stateId = stateId;
    }

    public Statetb(Integer stateId, String state, int isActive,Date createDate) {
        this.stateId = stateId;
        this.state = state;
        this.isActive = isActive;
        
        this.createDate = createDate;
    }

    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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
    @JsonbTransient
    @XmlTransient
    public Collection<Sellertb> getSellertbCollection() {
        return sellertbCollection;
    }

    public void setSellertbCollection(Collection<Sellertb> sellertbCollection) {
        this.sellertbCollection = sellertbCollection;
    }
    @JsonbTransient    
    @XmlTransient
    public Collection<Citytb> getCitytbCollection() {
        return citytbCollection;
    }

    public void setCitytbCollection(Collection<Citytb> citytbCollection) {
        this.citytbCollection = citytbCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stateId != null ? stateId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Statetb)) {
            return false;
        }
        Statetb other = (Statetb) object;
        if ((this.stateId == null && other.stateId != null) || (this.stateId != null && !this.stateId.equals(other.stateId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Statetb[ stateId=" + stateId + " ]";
    }
    
}
